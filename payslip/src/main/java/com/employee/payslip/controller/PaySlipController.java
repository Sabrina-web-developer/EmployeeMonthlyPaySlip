package com.employee.payslip.controller;
import com.employee.payslip.model.Employee;
import com.employee.payslip.model.EmployeePaySlip;
import com.employee.payslip.service.PaymentService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaySlipController{

    @Autowired
    private PaymentService paymentService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String welcome(){
        return "Welcome";
    }

    @RequestMapping(value = "/aaa", method = RequestMethod.GET)
    public String aaa(){
        return "aaa";
    }

    @RequestMapping(value = "/bbb", method = RequestMethod.POST)
    public String bbb(){
        return "bbb";
    }

    @RequestMapping(value = "/getMomthlyPaySlip", method = RequestMethod.POST)
    public List<EmployeePaySlip> GetMonthlyPaySlip(@RequestBody List<Employee> employeeList){
        List<EmployeePaySlip> employeePaySlips = paymentService.prcoessEmployeePaySlip(employeeList);
        return employeePaySlips;
    }

    @RequestMapping(value = "/getEmployee", method = RequestMethod.POST)
    public Employee getEmployee(@RequestBody Employee employee){
        return employee;
    }

    

}