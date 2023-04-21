package com.demo.springbatch.reponsitories;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.demo.springbatch.entity.Salary;

/**
 * Salary RowMapper.
 * 
 * @author thutrang
 */
public class SalaryRowMapper implements RowMapper<Salary> {

    @Override
    public Salary mapRow(ResultSet rs, int rowNum) throws SQLException {
        Salary salary = new Salary();
        salary.setId(rs.getInt("id"));
        salary.setIdStaff(rs.getInt("id_staff"));
        salary.setMonth(rs.getInt("month"));
        salary.setYear(rs.getInt("year"));
        salary.setSalaryBase(rs.getDouble("sbase"));
        salary.setTax(rs.getDouble("tax"));
        salary.setSalaryNet(rs.getDouble("snet"));
        salary.setDateCreate(rs.getString("date_create"));
        return salary;
    }
}