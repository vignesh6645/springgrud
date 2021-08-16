package com.example.crudoperation.controller;

import com.example.crudoperation.BaseResponse.BaseResponse;
import com.example.crudoperation.DTO.WorkerDTO;
import com.example.crudoperation.model.Worker;
import com.example.crudoperation.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/workers")
public class WorkerController {

    @Autowired
    private WorkerService workerService;

    @GetMapping("/detail")
    public List<Worker> list(){
        return workerService.listAll();
    }
    @PostMapping("/add")
    public BaseResponse display(@RequestBody WorkerDTO workerDTO){
        return workerService.adddetaill(workerDTO);
    }
    @GetMapping("/workers/{id}")
    public Worker findWorkerByID(@PathVariable int id){
        return workerService.getWorkerByID(id);
    }
    @PutMapping("/{id}")
    public BaseResponse updatedetail(@RequestBody WorkerDTO workerDTO){
        return workerService.updatedetail(workerDTO);
    }
    @DeleteMapping("/delete/{id}")
    public BaseResponse deletedinfo(@PathVariable int id){
        return workerService.deletedinfo(id);
    }
}
