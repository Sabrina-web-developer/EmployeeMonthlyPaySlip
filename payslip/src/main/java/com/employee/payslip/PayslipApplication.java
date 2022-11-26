package com.employee.payslip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.employee" })
public class PayslipApplication {

	public static void main(String[] args) {
		SpringApplication.run(PayslipApplication.class, args);
	}

}
