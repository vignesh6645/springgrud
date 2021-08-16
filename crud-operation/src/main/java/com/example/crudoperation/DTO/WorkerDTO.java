package com.example.crudoperation.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class WorkerDTO {
    private int id;
    private String name;
    private String area;
}
