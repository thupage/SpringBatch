package com.demo.springbatch.config;

import com.demo.springbatch.entity.Salary;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Salary Batch Config.
 * 
 * @author thutrang
 */
@Configuration
@EnableBatchProcessing
public class SalaryBatchConfig {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    SalaryItemReader salaryItemReader;

    @Autowired
    SalaryItemWriter salaryItemWriter;

    // Initialize "SalaryProcessor".
    @Bean
    public SalaryProcessor processor() {
        return new SalaryProcessor();
    }

    /**
     * Configuration of Step.
     * 
     * @return stepBuilderFactory.
     */
    @Bean
    public Step salaryFilterStep() {
        return stepBuilderFactory.get("salaryFilterStep")
                .<Salary, Salary>chunk(10) // Set the maximum number of processing elements in each batch to 10.
                .reader(salaryItemReader)
                .processor(processor())
                .writer(salaryItemWriter)
                .build(); // Finish the configuration of step.
    }

    /**
     * Configuration of Job.
     * 
     * @return salaryFilterJob.
     */
    @Bean
    public Job salaryFilterJob() {
        return jobBuilderFactory.get("salaryFilterJob")
                .incrementer(new RunIdIncrementer())
                .flow(salaryFilterStep())
                .end()
                .build(); // Finish the configuration of job.
    }
}