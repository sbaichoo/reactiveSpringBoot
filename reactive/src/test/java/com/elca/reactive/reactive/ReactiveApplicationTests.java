package com.elca.reactive.reactive;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReactiveApplicationTests {
   /*
    @Autowired
    private EmployeeRepository employeeRepository;

    private DatabaseClient client;

    private H2ConnectionConfiguration h2ConnectionConfiguration;

    public ReactiveApplicationTests() {
    }

    @Before
    public void setup() {

        Hooks.onOperatorDebug();

        List<String> statements = Arrays.asList(//
                "DROP TABLE IF EXISTS employee;",
                "CREATE table e,ployee (id INT AUTO_INCREMENT NOT NULL, first_name VARCHAR2, last_name VARCHAR2);");

        statements.forEach(it -> client.execute(it) //
                .fetch() //
                .rowsUpdated() //
                .as(StepVerifier::create) //
                .expectNextCount(1) //
                .verifyComplete());

    }

    @Test
    public void whenDeleteAll_then0IsExpected() {

        employeeRepository.deleteAll()
                .as(StepVerifier::create)
                .expectNextCount(0)
                .verifyComplete();
    }

    @Test
    public void test() {
        insertEmployees();
        employeeRepository.findById(1L)
                .as(StepVerifier::create)
                .expectNextCount(2)
                .verifyComplete();
    }

    private void insertEmployees() {
        List<Employee> employees = Arrays.asList(
                new Employee(1L, "John", "Doe"),
        new Employee(2L, "Johnnny", "Doe"));
    }
*/

}
