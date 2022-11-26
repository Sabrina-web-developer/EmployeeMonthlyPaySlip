package com.employee.payslip.service;

import com.employee.payslip.model.Employee;
import com.employee.payslip.model.EmployeePaySlip;

import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

// pay period = per calendar month • gross income = annual salary / 12 months 
// income tax = based on the tax table provided below 
// net income = gross income - income tax 
// super = gross income x super rate 

// pay period = Month of March (01 March to 31 March) 
// gross income = 60,050 / 12 = 5,004.16666667 (round down) = 5,004 
// income tax = (3,572 + (60,050 - 37,000) x 0.325) / 12 = 921.9375 (round up) = 922 
// net income = 5,004 - 922 = 4,082 
// super = 5,004 x 9% = 450.36 (round down) = 450 

@Service
public class PaymentService {

    public List<EmployeePaySlip> prcoessEmployeePaySlip(List<Employee>employees){
        System.out.println(employees);
        List<EmployeePaySlip>employeePaySlips = new ArrayList<>();
        employees.forEach(employee->{
            EmployeePaySlip employeePaySlip = calculate(employee);
            employeePaySlips.add(employeePaySlip);
        });
        return employeePaySlips;
    }

    public EmployeePaySlip calculate(Employee employee){

        EmployeePaySlip employeePaySlip = new EmployeePaySlip();
        // Employee employee2 = completeEmployee(employee);
        employeePaySlip.setEmployee(employee);

        double taxRate=0.0;
        Integer minTax = 0;
        int over = 0;

        if(employee.getAnnualSalary()<=18200){
            taxRate = 0;
        }else if(employee.getAnnualSalary()<=37000){

            minTax=3572;
            taxRate=0.325;
            over=37000;
            
        }else if(employee.getAnnualSalary()<=87000){

            minTax=3572;
            taxRate=0.325;
            over=37000;
            
        }else if (employee.getAnnualSalary()<=180000){

            minTax=19822;
            taxRate=0.37;
            over=87000;
            
        }else {

            minTax=54232;
            taxRate=0.45;
            over=180000;
            
        }

        employeePaySlip = this.completeEmployee(employeePaySlip, minTax, taxRate, over);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        YearMonth yearMonth = YearMonth.of(calendar.get(Calendar.YEAR), employee.getPaymentDate());
        String  month = yearMonth.atDay(1).getMonth().name();
        int endOfMonth = yearMonth.atEndOfMonth().lengthOfMonth();
        String StartDate = 1+""+ month;
        String EndDate = endOfMonth +""+month;
        employeePaySlip.setPayStartDay(StartDate);
        employeePaySlip.setPayEndDay(EndDate);
        return employeePaySlip;
    }

    public EmployeePaySlip completeEmployee(EmployeePaySlip employeePaySlip, int minTax, double taxRate, int over){

        int grossIncome = Math.round(employeePaySlip.getEmployee().getAnnualSalary()/12);
        long incomeTax = Math.round(minTax+ (employeePaySlip.getEmployee().getAnnualSalary()-over)*taxRate/12);
        long netIncome = grossIncome -incomeTax;
        long superIncome = Long.valueOf(Math.round(grossIncome*employeePaySlip.getEmployee().getSuperRate()));
        employeePaySlip.setGrossIncome(Math.toIntExact(grossIncome));
        employeePaySlip.setIncomeTax(Math.toIntExact(incomeTax));
        employeePaySlip.setNetIncome(Math.toIntExact(netIncome));
        employeePaySlip.setSuperIncome(Math.toIntExact(superIncome)); 

        return employeePaySlip;
    }
}
