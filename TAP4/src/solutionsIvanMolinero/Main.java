package solutionsIvanMolinero;

public class Main {
    public static void main(String[] args) {
        EmpBusinessLogicInterface emp = (EmpBusinessLogicInterface) DynamicProxyIvan.newInstance(new EmpBusinessLogic());

        EmployeeDetails employee = new EmployeeDetails();
        employee.setName("Rajeev");
        employee.setAge(25);
        employee.setMonthlySalary(8000);


        System.out.println(emp.calculateYearlySalary(employee));
        System.out.println(emp.calculateAppraisal(employee));
    }
}
