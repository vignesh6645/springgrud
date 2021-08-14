package com.example.crudoperation.service;

import com.example.crudoperation.model.Worker;
import com.example.crudoperation.repository.WorkerRepository;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkerService {
    @Autowired
    private WorkerRepository workerRepository;

    public List<Worker> listAll(){
        return workerRepository.findAll();
    }
    public void save(Worker worker){
        workerRepository.save(worker);
    }
    public Worker get(Integer id){
        return workerRepository.findById(id).get();

    }
    public void delete(Integer id){
        workerRepository.deleteById(id);
    }
}
