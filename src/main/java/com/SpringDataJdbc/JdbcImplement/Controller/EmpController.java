package com.SpringDataJdbc.JdbcImplement.Controller;

import com.SpringDataJdbc.JdbcImplement.Model.EmpModel;
import com.SpringDataJdbc.JdbcImplement.Repositary.EmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/employee")
public class EmpController {

    @Autowired
    EmpRepo empRepo;

    @PostMapping
    public ResponseEntity<Integer> creatingEmp(@RequestBody EmpModel empModel){
        int emp = empRepo.createEmp(empModel);
        return new ResponseEntity<Integer>(emp,HttpStatus.CREATED);
    }
    @PutMapping("{id}")
    public ResponseEntity<Integer> updateEmp(@PathVariable long id,@RequestBody EmpModel empModel){
        int emp = empRepo.updateEmp(id,empModel);
        return new ResponseEntity<Integer>(emp,HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Integer> deleteEmp(@PathVariable long id){
        int emp = empRepo.deleteEmp(id);
        return new ResponseEntity<Integer>(emp,HttpStatus.ACCEPTED);
    }
    @GetMapping("{id}")
    public ResponseEntity<EmpModel> getEmp(@PathVariable long id){
        EmpModel emp = empRepo.getEmp(id);
        return new ResponseEntity<EmpModel>(emp,HttpStatus.OK);
    }
    @GetMapping
    public  ResponseEntity<List<EmpModel>> getall(){
        List<EmpModel> emp = empRepo.getAllEmp();
        return new ResponseEntity<List<EmpModel>>(emp,HttpStatus.OK);

    }


}
