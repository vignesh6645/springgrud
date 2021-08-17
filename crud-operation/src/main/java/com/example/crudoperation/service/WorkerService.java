package com.example.crudoperation.service;

import com.example.crudoperation.BaseResponse.BaseResponse;
import com.example.crudoperation.DTO.WorkerDTO;
import com.example.crudoperation.model.Worker;
import com.example.crudoperation.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkerService {
    @Autowired
    private WorkerRepository workerRepository;

    public List<Worker> listAll() {
        return workerRepository.findAll();
    }


    public BaseResponse adddetaill(WorkerDTO workerDTO)
    {
        Worker dto=new Worker();
        BaseResponse baseResponse=new BaseResponse();
        dto.setName(workerDTO.getName());
        dto.setArea(workerDTO.getArea());
        workerRepository.save(dto);
        baseResponse.setData(dto);
        baseResponse.setStatusCode("200");
        baseResponse.setStatusMsg("success");
        return  baseResponse;
    }

    public Worker getWorkerById(int id) {
        return workerRepository.findById(id).orElse(null);
    }

    public BaseResponse updatedetail(WorkerDTO workerDTO) {
        BaseResponse baseResponse = new BaseResponse();
        Worker existworker = workerRepository.findById(workerDTO.getId()).orElse(null);
        existworker.setId(workerDTO.getId());
        existworker.setName(workerDTO.getName());
        existworker.setArea(workerDTO.getArea());
        workerRepository.save(existworker);
        baseResponse.setStatusCode("104");
        baseResponse.setStatusMsg("Workers info changed & updated successfully");
        baseResponse.setData(existworker);
        return baseResponse;
    }


    public Worker getWorkerByID(int id) {
        return workerRepository.findById(id).orElse(null);
    }
    public BaseResponse deletedinfo(int id){
        BaseResponse baseResponse = new BaseResponse();
        workerRepository.deleteById(id);
        baseResponse.setData(id);
        baseResponse.setStatusCode("103");
        baseResponse.setStatusMsg("Worker info deleted successfully..");
        return baseResponse;
    }
}
