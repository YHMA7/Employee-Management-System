///// Name: Yazan Husaain Alyami /////
///// ID: 2339804 /////
///// Section: CS1 /////

import java.time.LocalDate;

//Initializes a Manager object with the given name, ID, and salary. It also sets the manager status of the employee to true.
class Manager extends Employee implements Approver {
    public Manager(String name, int id, double salary) {
        super(name, id, salary);
        this.setManager(true); }


    //Marks the specified employee as working by setting their state to 'working'.
    @Override
    public void markEmployeeAsWorking(Employee employee) {
        employee.setStateWorking();
    }


    //Calculates and returns the bonus for the manager, which is 15% of their salary.
    @Override
    public double calculateBonus() {
        return getSalary() * 0.15 ; }


    //Creates a new Leave object with the provided employee, start date, and duration.
    @Override
    public void approveLeave(Employee employee, LocalDate startDate, int days) {
        Leave leave = new Leave(employee, startDate, days);
        employee.addLeaveRecord(leave); //Adds the leave record to the employee's leave records.
        employee.setStateOnLeave(); } //Sets the employee's state to 'on leave'.
}