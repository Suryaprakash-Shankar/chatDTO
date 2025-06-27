package com.sssp.crudop.controller;

import com.sssp.crudop.DTO.CodemeganDTO;
import com.sssp.crudop.Services.CodemeganDTOService;
import com.sssp.crudop.exception.ResourceNotFoundException;
import com.sssp.crudop.model.Codemegan;
import com.sssp.crudop.repository.CodemeganRepo;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import org.aspectj.apache.bcel.classfile.Code;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/codemegan")

public class CodemeganController {

    @Autowired
    private CodemeganDTOService codemeganDTOService;

//    Create New data using the post method

    @PostMapping("/NewData")
    public ResponseEntity<Codemegan> create(@Valid @RequestBody CodemeganDTO dto){
        Codemegan saved = codemeganDTOService.create(dto);
        return new ResponseEntity<>(saved,HttpStatus.CREATED);
    }

//    Find all data in a Repo in database

    @GetMapping("/getall")

    public List<Codemegan> GetAll(){
        return codemeganDTOService.getAllEmployee();
    }

//    Find Data using ID

    @GetMapping("/findbyid/{Id}")

    public Codemegan FindByID(@PathVariable int Id){
        return codemeganDTOService.GetEmployeeById(Id);
    }

//    Update The value using ID

    @PutMapping("/update/{Id}")

    public Codemegan UpdateValue(@PathVariable int Id , @RequestBody CodemeganDTO dto){
        return codemeganDTOService.updateEmployee(Id,dto);
    }



//    Delete the data

    @DeleteMapping("/delete/{Id}")

    public String DeleteById (@PathVariable int Id){
        codemeganDTOService.deleteEmployee(Id);
        return "Deleted Id No : " +Id +"Successfully";
    }


}

