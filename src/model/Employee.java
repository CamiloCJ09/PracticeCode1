package model;

public class Employee {
    
    private  String name;
    private int idCard;
    private int numCompletedSemesters;

    public Employee(String name, int idCard, int numCompletedSemesters){
        this.name = name;
        this.idCard = idCard;
        this.numCompletedSemesters = numCompletedSemesters;
    }
    
    public String showStatistics(){
        String out = "";
        out += "****************************\n"+
                "Employee: "+name+"\n"+
                "IDCard: "+idCard+"\n"+
                "Number of completed semesters: "+numCompletedSemesters+"\n";
        return out;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdCard() {
        return idCard;
    }

    public void setIdCard(int idCard) {
        this.idCard = idCard;
    }

    public int getNumCompletedSemesters() {
        return numCompletedSemesters;
    }

    public void setNumCompletedSemesters(int numCompletedSemesters) {
        this.numCompletedSemesters = numCompletedSemesters;
    }

}
