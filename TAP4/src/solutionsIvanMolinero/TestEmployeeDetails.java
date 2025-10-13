package solutionsIvanMolinero;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestEmployeeDetails {

    EmpBusinessLogicInterface empBusinessLogic = (EmpBusinessLogicInterface) DynamicProxyIvan.newInstance(new EmpBusinessLogic());
	EmployeeDetails employee;

	@Before
	public void setup() {
		System.out.println("setup!");
		employee = new EmployeeDetails();
		employee.setName("Rajeev");
		employee.setAge(25);
		employee.setMonthlySalary(8000);
	}

	//test to check appraisal
	@Test
	public void testCalculateAppraisal() {
		System.out.println("testCalculateAppraisal");
		double appraisal= empBusinessLogic.calculateAppraisal(employee);
		assertEquals(5500, appraisal, 0.0);
	}
	
	// test to check yearly salary
	@Test
	public void testCalculateYearlySalary() {
		System.out.println("testCalculateYearlySalary");
		double salary= empBusinessLogic.calculateYearlySalary(employee);
		assertEquals(101000, salary, 0.0);
	}

	@After
	public void tearDown() {
		System.out.println("tear down!");
		employee = null;
	}
}