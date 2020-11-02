package model;

public abstract class  Teacher extends Employee {
    
    private Degree degree;

    public Teacher(String name, int idCard, int numCompletedSemesters, Degree degree){
        super(name, idCard, numCompletedSemesters);
        this.degree  = degree;
    }
    @Override
    public String showStatistics(){
        String out = "";
        out += "****************************"+
                "Employee: "+getName()+"\n"+
                "IDCard: "+getIdCard()+"\n"+
                "Number of completed semesters: "+getNumCompletedSemesters()+"\n"+
                "Degree: "+degree.toString()+"\n";
        return out;
    }
    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

}
