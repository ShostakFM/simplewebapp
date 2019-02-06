package com.shostak.dao;

import com.shostak.config.AppConfiguration;
import com.shostak.entity.Employee;
import com.shostak.entity.Gender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {AppConfiguration.class})
public class EmployeeDaoImplTest {

    @Autowired
    EmployeeDao employeeDao;

    @Test
    public void findAllTest() {
        List<Employee> employees = employeeDao.findAll();
        assertEquals(9, employees.size());
    }

    @Test
    public void getByIdTest() {
        Employee employee = employeeDao.getById(1);
        assertEquals("Marina", employee.getFirstName());
    }

    @Test
    public void createTest() {
        int size = employeeDao.findAll().size();
        employeeDao.create(new Employee((long) 0, "Dmitry", "Sergievich", (long) 5, "Manager", Gender.MALE,
                new GregorianCalendar(1980, Calendar.NOVEMBER, 12).getTime()));
        assertEquals(size + 1, employeeDao.findAll().size());
    }

    @Test
    public void updateTest() {
        employeeDao.update(new Employee((long) 14, "Dmitry", "Sergievich", (long) 5, "PR-Manager", Gender.MALE,
                new GregorianCalendar(1980, Calendar.NOVEMBER, 12).getTime()));
        assertEquals("PR-Manager", employeeDao.getById(14).getJobTitle());
    }

    @Test
    public void deleteTest() {
        int size = employeeDao.findAll().size();
        employeeDao.delete(14);
        assertEquals(size - 1, employeeDao.findAll().size());
    }


}
