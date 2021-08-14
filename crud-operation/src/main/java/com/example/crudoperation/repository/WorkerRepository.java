package com.example.crudoperation.repository;

import com.example.crudoperation.model.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerRepository extends JpaRepository<Worker,Integer> {


}
