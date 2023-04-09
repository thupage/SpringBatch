package com.demo.springbatch.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entity Salary.
 * 
 * @author thutrang
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Salary {

    private int id;
    private int idStaff;
    private int month;
    private int year;
    private Double SalaryBase;
    private Double tax;
    private Double SalaryNet;
    private String dateCreate;
}
