package com.elca.reactive;

import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.BaseStream;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.r2dbc.core.DatabaseClient;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

import com.elca.reactive.repository.EmployeeRepository;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@SpringBootApplication
@EnableR2dbcRepositories
public class ReactiveApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReactiveApplication.class, args);
    }

    @Bean
    public ApplicationRunner seeder(DatabaseClient client, EmployeeRepository repository) {
        return args -> getSchema()
                .flatMap(sql -> executeSql(client, sql))
                .doOnSuccess(count -> log.info("Schema created, rows updated: {}", count))
/*                .then(repository.deleteAll())
                .doOnSuccess(v -> log.info("Repository cleared"))
                .thenMany(getEmployees())
                .flatMap(repository::save)*/
                .subscribe(employee -> log.info("Employee saved: {}", employee));
    }

/*    private Flux<Employee> getEmployees() {
        return Flux.just(new Employee(null, "John", "Doe"), new Employee(null, "Jane", "Doe"));
    }*/

    private Mono<Integer> executeSql(DatabaseClient client, String sql) {
        return client.execute(sql).fetch().rowsUpdated();
    }

    private Mono<String> getSchema() throws URISyntaxException {
        Path path = Paths.get(ClassLoader.getSystemResource("schema.sql").toURI());
        return Flux
                .using(() -> Files.lines(path), Flux::fromStream, BaseStream::close)
                .reduce((line1, line2) -> line1 + "\n" + line2);
    }


}
