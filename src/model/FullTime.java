package model;

public class FullTime extends Teacher {
    
    private boolean investigator;
    private double  baseSalary;

    public FullTime(String name, int idCard, int numCompletedSemesters, Degree degree, boolean  investigator, double baseSalary){
        super(name, idCard, numCompletedSemesters, degree);
        this.investigator = investigator;
        this.baseSalary  = baseSalary;
    }
    @Override
    public String showStatistics(){
        String out = "";
        out += "****************************"+"\n"+
                "Employee: "+getName()+"\n"+
                "IDCard: "+getIdCard()+"\n"+
                "Number of completed semesters: "+getNumCompletedSemesters()+"\n"+
                "Degree: "+getDegree().toString()+"\n"+
                "Investigator: "+investigator+"\n"+
                "Base salary: "+baseSalary+"\n";
        return out;
    }

    public boolean isInvestigator() {
        return investigator;
    }

    public void setInvestigator(boolean investigator) {
        this.investigator = investigator;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

}
