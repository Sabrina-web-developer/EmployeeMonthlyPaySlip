package com.employee.payslip.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.Data;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private String fName;
    private String lName;
    private Integer annualSalary;
    private Integer paymentDate;
    private Double superRate;

    public String getfName() {
        return fName;
    }
    public void setfName(String fName) {
        this.fName = fName;
    }
    public String getlName() {
        return lName;
    }
    public void setlName(String lName) {
        this.lName = lName;
    }

    public void setAnnualSalary(Integer annualSalary){
        this.annualSalary = annualSalary;
    }

    public Integer getAnnualSalary() {
        return annualSalary;
    }
    
    public void setPaymentDate(Integer paymentDate){
        this.paymentDate = paymentDate;
    }
    
    public Integer getPaymentDate() {
        return paymentDate;
    }
    
    public void setSuperRate(Double superRate){
        this.superRate = superRate;
    }

    public Double getSuperRate() {
        return superRate;
    }
}
