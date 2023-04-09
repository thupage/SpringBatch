package com.demo.springbatch.config;

import com.demo.springbatch.entity.Salary;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Component;
/**
 * Configure SalaryItemWriter.
 * 
 * @author thutrang
 */
@Component
public class SalaryItemWriter extends FlatFileItemWriter<Salary> {

    /**
     * The constructor of the SalaryItemWriter class.
     * 
     */
    public SalaryItemWriter() {
        setResource(new FileSystemResource("salary.csv")); //Set the output file to 'salary.csv'.
        setLineAggregator(getDelimitedLineAggregator());
    }

    /**
     * Configure DelimitedLineAggregator.
     * 
     * @return delimitedLineAggregator
     */
    public DelimitedLineAggregator<Salary> getDelimitedLineAggregator() {
        BeanWrapperFieldExtractor<Salary> fieldExtractor = new BeanWrapperFieldExtractor<>();
        fieldExtractor.setNames(
                new String[] { "id", "idStaff", "month", "year", "SalaryBase", "tax", "SalaryNet", "dateCreate" }); //Set the field names in Salary to convert to string.
        DelimitedLineAggregator<Salary> delimitedLineAggregator = new DelimitedLineAggregator<Salary>();
        delimitedLineAggregator.setDelimiter(","); //Set the field separator to ",".
        delimitedLineAggregator.setFieldExtractor(fieldExtractor); //Set up fieldExtractor to convert from Salary to string.
        return delimitedLineAggregator;
    }
}
