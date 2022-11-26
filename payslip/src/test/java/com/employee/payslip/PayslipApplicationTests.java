package com.employee.payslip;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.YearMonth;
import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.employee.payslip.model.Employee;
import com.employee.payslip.model.EmployeePaySlip;
import com.employee.payslip.service.PaymentService;

@SpringBootTest
class PayslipApplicationTests {

	@Autowired
	private PaymentService paymentService;

	@Test
	void contextLoads() {
		double taxRate=0,annualSalary;
        Integer minTax,over;
        annualSalary = 60050;
		if(annualSalary<=18200){
            taxRate=0;
        }else if(annualSalary<=37000){
            minTax=0;
            taxRate=0.19;
            over=18201;

			Integer superRate = 9;
			Long grossIncome = Math.round(annualSalary/12);
			long incomeTax = Math.round(minTax+ (annualSalary-over)*taxRate/12);
            long netIncome = grossIncome -incomeTax;
            long superIncome = Long.valueOf(Math.round(grossIncome*superRate)/100);
			System.out.println(netIncome);
			System.out.println(superIncome);
		}else if(annualSalary<=87000){
				minTax=3572;
				taxRate=0.325;
				over=37000;

				Integer superRate =9;
				Long grossIncome = Math.round(annualSalary/12);
				long incomeTax = Math.round(minTax+ (annualSalary-over)*taxRate/12);
				long netIncome = grossIncome -incomeTax;
				long superIncome = Long.valueOf(Math.round(grossIncome*superRate)/100);
				System.out.println(netIncome);
				System.out.println(superIncome);
		}else if (annualSalary<=180000){
				minTax=19822;
				taxRate=0.37;
				over=87000;

				Integer superRate =9;
				Long grossIncome = Math.round(annualSalary/12);
				long incomeTax = Math.round(minTax+ (annualSalary-over)*taxRate/12);
				long netIncome = grossIncome -incomeTax;
				long superIncome = Long.valueOf(Math.round(grossIncome*superRate)/100);
				System.out.println(netIncome);
				System.out.println(superIncome);
		}else {
			minTax=54232;
			taxRate=0.45;
			over=180000;
			Integer superRate=9;
			Long grossIncome = Math.round(annualSalary/12);
			long incomeTax = Math.round(minTax+ (annualSalary-over)*taxRate/12);
			long netIncome = grossIncome -incomeTax;
			long superIncome = Long.valueOf(Math.round(grossIncome*superRate)/100);
			System.out.println(netIncome);
			System.out.println(superIncome);
			
			
		}
	}

	@Test
	public void date(){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		System.out.println();
		YearMonth yearMonth = YearMonth.of(calendar.get(Calendar.YEAR),12);

		String month = yearMonth.atDay(1).getMonth().name();
		int endOfMonth = yearMonth.atEndOfMonth().lengthOfMonth();
		System.out.println(1+" "+ month);
		System.out.println(endOfMonth+" "+month);
	}

	@Test
	public void testPaymentServiceCalculateFunction(){

		Employee employee = new Employee("Vincent", "Bai", 6000, 1, 13.0);

		EmployeePaySlip ep = paymentService.calculate(employee);

		EmployeePaySlip assertEp = new EmployeePaySlip();

		assertEp.setEmployee(employee);

		assertEp.setGrossIncome(500);
		assertEp.setIncomeTax(0);
		assertEp.setPayEndDay("31JANUARY");
		assertEp.setPayStartDay("1JANUARY");
		assertEp.setNetIncome(500);
		assertEp.setSuperIncome(6500);

		assertEquals(ep, assertEp);

	}
}
