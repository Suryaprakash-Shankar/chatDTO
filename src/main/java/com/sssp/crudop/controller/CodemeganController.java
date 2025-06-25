package com.sssp.crudop.controller;

import com.sssp.crudop.exception.ResourceNotFoundException;
import com.sssp.crudop.model.Codemegan;
import com.sssp.crudop.repository.CodemeganRepo;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/codemegan")

public class CodemeganController {

    @Autowired
    private CodemeganRepo codemeganRepo;

//    Create New data using the post method

    @PostMapping("/NewData")
    public Codemegan PostValue (@RequestBody Codemegan codemegan){
        return codemeganRepo.save(codemegan);
    }

//    Find all data in a Repo in database

    @GetMapping("/getall")

    public List<Codemegan> GetAll(){
        return codemeganRepo.findAll();
    }

//    Find Data using ID

    @GetMapping("/findbyid/{Id}")

    public Codemegan FindByID(@PathVariable int Id){
        return codemeganRepo.findById(Id).orElseThrow(()-> new ResourceNotFoundException("No Data or Id found at ID : " +Id));
    }

//    Update The value using ID

    @PutMapping("/update/{Id}")

    public Codemegan UpdateValue(@PathVariable int Id , @RequestBody Codemegan UpdateValue){
        Codemegan codemegan = codemeganRepo.findById(Id).orElseThrow(()-> new ResourceNotFoundException("Not found Id in database Id No: " +Id));
        codemegan.setName(UpdateValue.getName());
        codemegan.setAge(UpdateValue.getAge());
        codemegan.setMobile(UpdateValue.getMobile());
        codemegan.setAddress(UpdateValue.getAddress());
        return codemeganRepo.save(codemegan);
    }



//    Delete the data

    @DeleteMapping("/delete/{Id}")

    public String DeleteById (@PathVariable int Id){
        codemeganRepo.deleteById(Id);
        return "Deleted Id No : " +Id +"Successfully";
    }

//    Delete All Data from Database
    @DeleteMapping("/deleteAll")
    public String DeleteAll(){
        codemeganRepo.deleteAll();
        return "All data removed from Database Successfully";
    }

}

