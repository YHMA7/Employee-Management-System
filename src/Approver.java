///// Name: Yazan Husaain Alyami /////
///// ID: 2339804 /////
///// Section: CS1 /////

import java.time.LocalDate;

//Marks an employee as actively working. Also approves leave for an employee for a specified duration starting from a given date.
interface Approver {
    void markEmployeeAsWorking(Employee employee);
    void approveLeave(Employee employee, LocalDate startDate, int days);
}