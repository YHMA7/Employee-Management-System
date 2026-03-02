///// Name: Yazan Husaain Alyami /////
///// ID: 2339804 /////
///// Section: CS1 /////

import java.util.ArrayList;

//These are private instance variables representing the name, ID, salary, state (working/on leave),
//leave records, and manager status of an employee, respectively.
abstract class Employee {
    private String name;
    private int id;
    private double salary;
    private String state;
    private ArrayList<Leave> leaveRecords;
    private boolean isManager;


    //Sets the initial state of the employee to "Working", initializes the leave records list, and sets the manager status to false.
    public Employee(String name , int id , double salary)
    {   this.name = name;
        this.id = id;
        this.salary = salary;
        this.state = "Working";
        this.leaveRecords = new ArrayList<>();
        this.isManager = false; }


    public boolean isManager() {
        return isManager;
    }
    public void setManager(boolean manager) {
        isManager = manager;
    }


    public abstract double calculateBonus();


    @Override
    public String toString() { return "Name: " + name + ", ID: " + id + ", Salary: " + salary + ", Bonus: " + calculateBonus(); }


    public void setStateOnLeave() {
        this.state = "On Leave";
    }
    public void setStateWorking() {
        this.state = "Working";
    }
    public void addLeaveRecord(Leave leave) {
        leaveRecords.add(leave);
    }
    public String getName() {
        return name;
    }
    public int getId() {
        return id;
    }
    public double getSalary() {
        return salary;
    }
    public ArrayList<Leave> getLeaveRecords() {
        return leaveRecords;
    }
}