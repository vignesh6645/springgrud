package com.example.crudoperation.controller;

import com.example.crudoperation.model.Worker;
import com.example.crudoperation.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/worker")
public class WorkerController {

    @Autowired
    private WorkerService workerService;

    @GetMapping("/getall")
    public List<Worker> list(){
        return workerService.listAll();
    }
    @PostMapping("/add")
    public String add(@RequestBody Worker worker){
        workerService.save(worker);
        return "New Worker details added...";
    }
    @GetMapping("/{id}")
    public ResponseEntity<Worker> get(@PathVariable Integer id){
        try{
            Worker worker=workerService.get(id);
            return new ResponseEntity<Worker>(worker, HttpStatus.OK);
    }catch (NoSuchElementException e){
        return new ResponseEntity<Worker>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<Worker> update(@RequestBody Worker worker,@PathVariable Integer id){
        try {
            Worker existingWorker=workerService.get(id);
            workerService.save(worker);
            return new ResponseEntity<Worker>(worker,HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<Worker>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id){
        workerService.delete(id);
        return "deleted successfully this id : " +id;
    }
}
