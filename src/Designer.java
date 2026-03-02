///// Name: Yazan Husaain Alyami /////
///// ID: 2339804 /////
///// Section: CS1 /////

class Designer extends Employee {
    //Initializes a Designer object with the given name, ID, and salary by calling the constructor of the superclass (Employee).
    public Designer(String name, int id, double salary)
    { super(name, id, salary); }


    //Calculates and returns the bonus for the designer, which is 10% of their salary.
    @Override
    public double calculateBonus()
    { return getSalary() * 0.10; //(overpaid)
    }
}