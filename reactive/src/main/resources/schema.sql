CREATE SCHEMA IF NOT EXISTS postgres;

DROP TABLE IF EXISTS employee;

CREATE TABLE IF NOT EXISTS employee
(
    id         SERIAL PRIMARY KEY,
    first_name VARCHAR(255),
    last_name  VARCHAR(255)
);

INSERT INTO employee (first_name, last_name)
values ('John', 'Doe');
INSERT INTO employee (first_name, last_name)
values ('Jane', 'Doe');

DROP TABLE IF EXISTS skill;

CREATE TABLE IF NOT EXISTS skill
(
    id          SERIAL PRIMARY KEY,
    name        VARCHAR(255),
    description VARCHAR(255)
);

INSERT INTO skill (name, description)
values ('Java 11', 'Reference implementation of version 11 of the Java SE Platform');
INSERT INTO skill (name, description)
values ('Mapstruct',
        'MapStruct is an annotation processor which is plugged into the Java compiler for automatic conversion');

DROP TABLE IF EXISTS skill_set;

CREATE TABLE IF NOT EXISTS skill_set
(
    id          SERIAL PRIMARY KEY,
    employee_id INT,
    skill_id    INT,
    skill_Level VARCHAR(255)
);

INSERT INTO skill_set (employee_id, skill_id, skill_Level)
VALUES (1, 1, 'Expert');
INSERT INTO skill_set (employee_id, skill_id, skill_Level)
VALUES (1, 2, 'Intermediate');
INSERT INTO skill_set (employee_id, skill_id, skill_Level)
VALUES (2, 1, 'Expert');






