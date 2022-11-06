package com.visu.springdataonetoonemapping.bootstrap;

import com.visu.springdataonetoonemapping.model.*;
import com.visu.springdataonetoonemapping.repository.AccountRepository;
import com.visu.springdataonetoonemapping.repository.EmployeeRepository;
import com.visu.springdataonetoonemapping.repository.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class DataLoader implements CommandLineRunner {

    private final PersonRepository personRepository;
    private final EmployeeRepository employeeRepository;

    private final AccountRepository accountRepository;

    public DataLoader(PersonRepository personRepository, EmployeeRepository employeeRepository, AccountRepository accountRepository) {
        this.personRepository = personRepository;
        this.employeeRepository = employeeRepository;
        this.accountRepository = accountRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Tom", new IDCard()));
        persons.add(new Person("Daisy", new IDCard()));
        persons.add(new Person("Alex", new IDCard()));
        personRepository.saveAll(persons);
        // ======= `@IdClass` Annotation =======

        // create new accounts
        accountRepository.save(new Account("458666", "Checking", 4588));
        accountRepository.save(new Account("458689", "Checking", 2500));
        accountRepository.save(new Account("424265", "Saving", 100000));

        // fetch accounts by a given type
        List<Account> accounts = accountRepository.findByAccountType("Checking");
        accounts.forEach(System.out::println);

        // fetch account by composite key
        Optional<Account> account = accountRepository.findById(new AccountId("424265", "Saving"));
        account.ifPresent(System.out::println);

        // ======= `@EmbeddedId` Annotation =======

        // create new employees
        employeeRepository.save(new Employee(new EmployeeId(100L, 10L),
                "John Doe", "john@example.com", "123456"));
        employeeRepository.save(new Employee(new EmployeeId(101L, 20L),
                "Emma Ali", "emma@example.com", "654321"));

        // fetch employees by a given department id
        List<Employee> employees = employeeRepository.findByEmployeeIdDepartmentId(20L);
        employees.forEach(System.out::println);

        // fetch employee by composite key
        Optional<Employee> employee = employeeRepository.findById(new EmployeeId(100L, 10L));
        employee.ifPresent(System.out::println);
    }
}
