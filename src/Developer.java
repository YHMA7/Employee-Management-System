///// Name: Yazan Husaain Alyami /////
///// ID: 2339804 /////
///// Section: CS1 /////

class Developer extends Employee {
    //Initializes a Developer object with the given name, ID, and salary by calling the constructor of the superclass (Employee).
    public Developer(String name, int id, double salary)
    { super(name, id, salary); }


    //Calculates and returns the bonus for the developer, which is 12% of their salary.
    @Override
    public double calculateBonus() {
        return getSalary() * 0.12;
    }
}