package com.SpringDataJdbc.JdbcImplement.Repositary;

import com.SpringDataJdbc.JdbcImplement.Exception.EmptyInputException;
import com.SpringDataJdbc.JdbcImplement.Model.EmpModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.List;

@Repository
public class EmpRepo {

    @Autowired
    JdbcTemplate jdbcTemplate;
    // creating table with jdbc
    public int createTable(){
        String query ="CREATE TABLE IF NOT EXISTS Employee(id SERIAL PRIMARY KEY,name varchar(200),department varchar(100),salary int)";
        int update = this.jdbcTemplate.update(query);
        return update;
    }
    //inserting employee details with jdbc
    public int createEmp(EmpModel empModel){
        if(empModel.getName().isEmpty()||empModel.getName().length()==0){
            throw new EmptyInputException("601","Input field:name is empty");
        }
        String query = "INSERT INTO Employee(name,department,salary) VALUES(?,?,?)";
        int update = this.jdbcTemplate.update(query,new Object[]{empModel.getName(),empModel.getDepartment(),empModel.getSalary()});
        return update;
    }
    //updating employee by id with the help of jdbc
    public int updateEmp(long id,EmpModel empModel){
        String query = "UPDATE Employee SET name=?,department=?,salary=? WHERE id = ?";
        int update = this.jdbcTemplate.update(query,new Object[]{empModel.getName(),empModel.getDepartment(),empModel.getSalary(),id});
        return update;
    }
    //deleting student by id with the help of jdbc
    public int deleteEmp(long id){
        String query = "DELETE FROM Employee where id= ?";
        int delete  = this.jdbcTemplate.update(query,id);
        return delete;
    }
    //get an Employee by id with the help of jdbc
    public EmpModel getEmp(long id){
        String query = "select * from Employee where id=?";
        EmpModel empModel = this.jdbcTemplate.queryForObject(query,(rs,rowNum) ->
        {EmpModel empModel1 =new EmpModel();
            empModel1.setId(rs.getLong(1));
            empModel1.setName(rs.getString(2));
            empModel1.setDepartment(rs.getString(3));
            empModel1.setSalary(rs.getInt(4));
            return empModel1;
        },id);
        return empModel;
    }
    //get all Employee with the help of jdbc
    public List<EmpModel> getAllEmp(){
        String query = "select * from Employee";
        List<EmpModel> empModels = jdbcTemplate.query(query,(rs,rowNum) -> {
            EmpModel empModel= new EmpModel();
            empModel.setId(rs.getInt(1));
            empModel.setName(rs.getString(2));
            empModel.setDepartment(rs.getString(3));
            empModel.setSalary(rs.getInt(4));
            return empModel;
        });
        return empModels;
    }

}
