package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tbl_manager")
public class Manager {

    @Id
    @Column(name = "manager_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;

    @OneToMany(targetEntity = Employee.class,
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    @JoinColumn(name = "manager_id",
            referencedColumnName = "manager_id")
    private List<Employee> employees;

    public Manager(String fullName, List<Employee> employees) {
        this.fullName = fullName;
        this.employees = employees;
    }

}
