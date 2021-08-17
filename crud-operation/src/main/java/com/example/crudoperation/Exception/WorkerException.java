package com.example.crudoperation.Exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class WorkerException extends RuntimeException{
    private static final long serialVersionUID = 1L;


    public void ResourceFoundException(String message){

    }
}
