///// Name: Yazan Husaain Alyami /////
///// ID: 2339804 /////
///// Section: CS1 /////

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class EmployeeManagementSystem {

    //represents a list of employees managed by the system.
    private List<Employee> employees;

    //Initializes an object by creating a new ArrayList to store employees.
    public EmployeeManagementSystem() {
        this.employees = new ArrayList<>(); }

    //Adds a new employee to the list of employees.
    public void addEmployee(Employee employee) {
        employees.add(employee); }

    //Iterates through the list of employees, finds the employee with the specified ID,
    //removes them from the list, and returns true if successful, otherwise returns false.
    public boolean removeEmployee(int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                employees.remove(employee);
                return true; }
        }
        return false; }


    //Entry point of the application.
    public static void main(String[] args) {
        EmployeeManagementSystem system = new EmployeeManagementSystem();
        system.processInputFile("Input.txt", "Output.txt"); }


    //handles any IOException that may occur during file processing by writing an error message.
    public void processInputFile(String inputFilePath, String outputFilePath) {
        File inputFile = new File(inputFilePath);
        File outputFile = new File(outputFilePath);
        try { Scanner scanner = new Scanner(inputFile);
            PrintWriter writer = new PrintWriter(outputFile);
            while (scanner.hasNextLine()) {
                String command = scanner.nextLine();
                String result = processCommand(command, writer);
                writer.println(result); }

            scanner.close();
            writer.close();
        } catch (IOException e) {
            try {
                PrintWriter errorWriter = new PrintWriter(outputFile);
                errorWriter.print("Error occurred while processing the input file.");
                errorWriter.close();
            } catch (IOException ioException) {
                // Ignore
            }
        }
    }


    //returns the result of processing the command to the output file.
    private String processCommand(String command, PrintWriter writer) {
        String[] parts = command.split(",");
        String action = parts[0].trim();

        switch (action) {
            case "Add_Manager":
                addManager(parts, writer);
                break;
            case "Add_Developer":
                addDeveloper(parts, writer);
                break;
            case "Add_Designer":
                addDesigner(parts, writer);
                break;
            case "Give_Leave":
                giveLeave(parts, writer);
                break;
            case "Change_State":
                changeState(parts, writer);
                break;
            case "del_Employee":
                delEmployee(parts, writer);
                break;
            case "printAllEmployees":
                return printAllEmployees();
            case "print_Leave_Records":
                return printLeaveRecords(parts);
            default:
                return "Wrong command"; }
        return ""; }


    //Creates a Manager object.
    private void addManager(String[] parts, PrintWriter writer)
    { String name = parts[1].trim();
        int id = Integer.parseInt(parts[2].trim());
        double salary = Double.parseDouble(parts[3].trim());
        Manager manager = new Manager(name, id, salary);
        addEmployee(manager);
        writer.print("Manager " + name + " added."); }


    //Creates a Developer object.
    private void addDeveloper(String[] parts, PrintWriter writer)
    { String name = parts[1].trim();
        int id = Integer.parseInt(parts[2].trim());
        double salary = Double.parseDouble(parts[3].trim());
        Developer developer = new Developer(name, id, salary);
        addEmployee(developer);
        writer.print("Developer " + name + " added."); }


    //Creates a Designer object.
    private void addDesigner(String[] parts, PrintWriter writer)
    { String name = parts[1].trim();
        int id = Integer.parseInt(parts[2].trim());
        double salary = Double.parseDouble(parts[3].trim());
        Designer designer = new Designer(name, id, salary);
        addEmployee(designer);
        writer.print("Designer " + name + " added."); }


    public void giveLeave(String[] parts, PrintWriter writer)
    { int managerId = Integer.parseInt(parts[1].trim());
        int employeeId = Integer.parseInt(parts[2].trim());
        LocalDate startDate = LocalDate.parse(parts[3].trim());
        int days = Integer.parseInt(parts[4].trim());

        Employee manager = findEmployeeById(managerId);
        Employee employee = findEmployeeById(employeeId);

        if (manager != null && employee != null) {
            try {
                Manager mgr = (Manager) manager;
                mgr.approveLeave(employee, startDate, days);
                writer.print("Leave approved for " + employee.getName() + ".");
            } catch (ClassCastException e) { writer.print("Cannot approve leave for " + employee + " as they are already on leave."); }
        } else { writer.print("Leave approval failed. Either manager ID is incorrect or employee ID does not exist."); }
    }


    private void changeState(String[] parts, PrintWriter writer) {
        int managerId = Integer.parseInt(parts[1].trim());
        int employeeId = Integer.parseInt(parts[2].trim());
        String state = parts[3].trim();

        Employee manager = findEmployeeById(managerId);
        Employee employee = findEmployeeById(employeeId);

        if (manager != null && employee != null && manager.isManager()) {
            if (state.equalsIgnoreCase("Working")) {
                employee.setStateWorking();
                writer.print("Employee " + employee.getName() + " is now marked as working."); }
        }
    }


    private void delEmployee(String[] parts, PrintWriter writer) {
        int id = Integer.parseInt(parts[1].trim());
        boolean removed = removeEmployee(id);
        if (removed) { writer.print("Employee removed successfully."); }
        else { writer.print("Employee with ID " + id + " not found."); }
    }


    //Returns the employee with the specified ID if found, otherwise returns null.
    public Employee findEmployeeById(int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee; }
        }
        return null; }


    //Returns the string representation of all employees.
    public String printAllEmployees() {
        StringBuilder sb = new StringBuilder();
        sb.append("Name \t\tID \tSalary    Bonus \n");
        for (Employee employee : employees) {
            sb.append(employee.getName()).append("      \t");
            sb.append(employee.getId()).append("\t");
            sb.append(employee.getSalary()).append("\t  ");
            sb.append(employee.calculateBonus()).append("\n");
        }
        return sb.toString(); }


    //Prints leave records for a specific employee.
    private String printLeaveRecords(String[] parts) {
        int employeeId = Integer.parseInt(parts[1].trim());
        Employee employee = findEmployeeById(employeeId);
        if (employee != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Leave Records for ").append(employee.getName()).append(":\n");
            sb.append("Start Date   Days of Leave\n");
            for (Leave leave : employee.getLeaveRecords()) {
                sb.append(leave.getStartDate()).append("   ").append(leave.getDays()).append("\n"); }
            return sb.toString(); }
        return "Employee with ID " + employeeId + " not found."; }
}