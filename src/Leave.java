///// Name: Yazan Husaain Alyami /////
///// ID: 2339804 /////
///// Section: CS1 /////

import java.time.LocalDate;

//Private instance variables representing the start date of the leave,
//the employee requesting the leave, and the number of days for the leave, respectively.
class Leave {
    private LocalDate startDate;
    private Employee employee;
    private int days;


    //Getter methods for retrieving the start date, employee, and number of days for the leave, respectively.
    public LocalDate getStartDate() {
        return startDate;
    }
    public Employee getEmployee() {
        return employee;
    }
    public int getDays() {
        return days;
    }


    //Initializes a Leave object with the given employee, start date, and number of days for the leave.
    public Leave(Employee employee, LocalDate startDate, int days)
    {   this.startDate = startDate;
        this.employee = employee;
        this.days = days; }


    //Generates and returns a string containing leave details for a specific employee.
    public String displayLeaveDetails(Employee employee) {
        StringBuilder details = new StringBuilder();
        details.append("Leave Records for ").append(employee.getName()).append(":\n");
        details.append("Start Date   Days of Leave\n");
        for (Leave leave : employee.getLeaveRecords()) {
            if (leave.getEmployee().getId() == employee.getId()) {
                details.append(leave.getStartDate()).append("   ").append(leave.getDays()).append("\n"); }
        }
        return details.toString(); }
}