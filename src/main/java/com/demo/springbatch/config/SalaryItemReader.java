package com.demo.springbatch.config;

import javax.sql.DataSource;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.stereotype.Component;
import com.demo.springbatch.entity.Salary;

/**
 * Configure SalaryItemReader.
 * 
 * @author thutrang
 */
@Component
public class SalaryItemReader extends JdbcCursorItemReader<Salary> implements ItemReader<Salary> {

    public SalaryItemReader(DataSource dataSource) {
        setDataSource(dataSource);
        setSql("SELECT * FROM salary"); // Set up SQL statement for Salary data.
        setFetchSize(100); // Set the size of each data retrieval.
        setRowMapper(new SalaryRowMapper());
    }
}