package model;

public class Lecturer extends Teacher {
    
    private double hoursPerWeek;

    public Lecturer(String name, int idCard, int numCompletedSemesters, Degree degree, double hoursPerWeek){
        super(name, idCard, numCompletedSemesters, degree);
        this.hoursPerWeek = hoursPerWeek;

    }
    @Override
    public String showStatistics(){
        String out = "";
        out += "****************************\n"+
                "Employee: "+getName()+"\n"+
                "IDCard: "+getIdCard()+"\n"+
                "Number of completed semesters: "+getNumCompletedSemesters()+"\n"+
                "Degree: "+getDegree().toString()+"\n"+
                "Hours per week: "+hoursPerWeek+"\n";
        return out;
    }

    public double getHoursPerWeek() {
        return hoursPerWeek;
    }
    public void setHoursPerWeek(double hoursPerWeek) {
        this.hoursPerWeek = hoursPerWeek;
    }


}
