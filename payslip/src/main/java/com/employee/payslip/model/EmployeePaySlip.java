package com.employee.payslip.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.Data;

@Getter
@Setter
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class EmployeePaySlip {
    private Employee employee;
    private String payStartDay;
    private String payEndDay;
    private Integer grossIncome;
    private Integer incomeTax;
    private Integer netIncome;
    private Integer superIncome;
}
