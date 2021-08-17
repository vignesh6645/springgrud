package com.example.crudoperation.service;

import com.example.crudoperation.BaseResponse.BaseResponse;
import com.example.crudoperation.DTO.WorkerDTO;
import com.example.crudoperation.model.Worker;
import com.example.crudoperation.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Workerservice {
    @Autowired
    private WorkerRepository workerRepository;



    public BaseResponse adddetaill(WorkerDTO workerDTO)
    {
        Worker dto=new Worker();
        BaseResponse baseResponse=new BaseResponse();
        dto.setName(workerDTO.getName());
        dto.setArea(workerDTO.getArea());
        workerRepository.save(dto);

        baseResponse.setStatusCode("200");
        baseResponse.setStatusMsg("success");
        baseResponse.setData(dto);
        return  baseResponse;
    }

    public Worker getWorkerById(int id) {
        return workerRepository.findById(id).orElseThrow(()->new RuntimeException("ID Not found"));
    }
    public List<Worker> listAll() {
        return workerRepository.findAll();
    }

    public BaseResponse updatedetail(WorkerDTO workerDTO) {
        BaseResponse baseResponse = new BaseResponse();
        
        Optional<Worker> existworkers = workerRepository.findById(workerDTO.getId());
        if(existworkers.isPresent()){
            existworkers.get().setId(workerDTO.getId());
            existworkers.get().setName(workerDTO.getName());
            existworkers.get().setArea(workerDTO.getArea());
            workerRepository.save(existworkers.get());}
        else
        {
            throw new RuntimeException("data not found"); }
        baseResponse.setStatusCode("200");
        baseResponse.setStatusMsg("worker updated successfully");
        baseResponse.setData(existworkers);
        return baseResponse;
    }

    public BaseResponse deletedinfo(int id){
        BaseResponse baseResponse = new BaseResponse();
        workerRepository.deleteById(id);
        baseResponse.setData(id);
        baseResponse.setStatusCode("200");
        baseResponse.setStatusMsg("Success");
        return baseResponse;
    }
    public BaseResponse deleted(){
        BaseResponse baseResponse = new BaseResponse();
        workerRepository.deleteAll();
        baseResponse.setData();
        baseResponse.setStatusCode("200");
        baseResponse.setStatusMsg("Success");
        return baseResponse;
    }
}
