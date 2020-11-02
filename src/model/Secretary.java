package model;

public class Secretary extends Employee {
    
    private double salary;
    
    public Secretary(String name, int idCard, int numCompletedSemesters, double salary){
        super(name, idCard, numCompletedSemesters);
        this.salary = salary;
    }
    @Override
    public String showStatistics(){
        String out = "";
        out += "****************************\n"+
                "Employee: "+getName()+"\n"+
                "IDCard: "+getIdCard()+"\n"+
                "Number of completed semesters: "+getNumCompletedSemesters()+"\n"+
                "Salary: "+salary+"\n";
        return out;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

}
