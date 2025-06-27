package com.sssp.crudop.Services;

import com.sssp.crudop.DTO.CodemeganDTO;
import com.sssp.crudop.exception.ResourceNotFoundException;
import com.sssp.crudop.model.Codemegan;
import com.sssp.crudop.repository.CodemeganRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class CodemeganDTOService {

    @Autowired

    private CodemeganRepo codemeganRepo;

public Codemegan create(CodemeganDTO dto){
    Codemegan codemegan = new Codemegan();
    codemegan.setName(dto.getName());
    codemegan.setAge(dto.getAge());
    codemegan.setMobile(dto.getMobile());
    codemegan.setAddress(dto.getAddress());
    return codemeganRepo.save(codemegan);
}

public List<Codemegan> getAllEmployee(){
    return codemeganRepo.findAll();
}

public Codemegan GetEmployeeById(int Id){
    return codemeganRepo.findById(Id).orElseThrow(()->new ResourceNotFoundException("Employee Not Found at ID : "+Id));

}

public Codemegan updateEmployee(int Id,CodemeganDTO dto){
    Codemegan codemegan = codemeganRepo.findById(Id).orElseThrow(()->new ResourceNotFoundException("Employee not FOund At ID : " +Id));

    codemegan.setName(dto.getName());
    codemegan.setAge(dto.getAge());
    codemegan.setMobile(dto.getMobile());
    codemegan.setAddress(dto.getAddress());
    return codemeganRepo.save(codemegan);
}

public void deleteEmployee(int Id){
    codemeganRepo.deleteById(Id);
}

}
