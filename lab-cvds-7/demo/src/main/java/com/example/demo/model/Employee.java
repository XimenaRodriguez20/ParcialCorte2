package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long employeeId;
    private String firstName;
    private String lastName;
    private String role;
    private Double salary;

    //New

    private LocalDate fechaNacimiento;



    public Employee() {
    }

    public Employee(String firstName, String lastName, String role, double salary, LocalDate fechaNacimiento) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.salary = salary;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public LocalDate getfechaNacimiento() {return fechaNacimiento;}

    public void setfechaNacimiento(LocalDate fechaNacimiento) {this.fechaNacimiento = fechaNacimiento;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return employeeId.equals(employee.employeeId) && firstName.equals(employee.firstName) && lastName.equals(employee.lastName) && role.equals(employee.role) && salary.equals(employee.salary) && fechaNacimiento.equals(employee.fechaNacimiento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, firstName, lastName, role, salary, fechaNacimiento);
    }

    public int edad(){
        LocalDateTime  fechaActual = LocalDateTime.now() ;
        return fechaActual.getYear() - fechaNacimiento.getYear();
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", role='" + role + '\'' +
                ", salary=" + salary + '\''+
                ", fechaNacimiento='" + fechaNacimiento +
                '}';
    }
}
