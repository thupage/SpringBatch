package com.demo.springbatch.config;

import com.demo.springbatch.entity.Salary;
import io.micrometer.core.lang.NonNull;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.springframework.batch.item.ItemProcessor;
/**
 * Salary Processor.
 * 
 * @author thutrang
 */
public class SalaryProcessor implements ItemProcessor<Salary, Salary> {
    
    @Override
    public Salary process(@NonNull Salary salary) throws Exception {
        LocalDate now = LocalDate.now(); //Set to current date.
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); //set format is "yyyy-MM-dd".
        //If Salary creation date is null, return null.
        if (salary.getDateCreate() == null) {
            return null;
        } else {
            LocalDate createdDate = LocalDate.parse(salary.getDateCreate(), formatter);
            //If Salary creation date is different from current date, return null.
            if (!createdDate.equals(now)) { 
                return null;
            }
            //Salary creation date is same as current date, return salary.
            return salary;
        }
    }
}
