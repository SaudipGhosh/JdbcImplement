package com.SpringDataJdbc.JdbcImplement.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmpModel {
    long id;
    String name;
    String department;
    int Salary;
}
