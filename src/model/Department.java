package  model;


public  class Department{
    public static final int MAX_EMPLOYEES = 50;
    //Atributos
    private  String name;
    
    //Relaciones
    private Teacher[] teachersRoom;
    private Employee[] payroll;
    private int amountWorkers = 0;
    
    public Department(String name){
        this.name = name;
        teachersRoom = new Teacher[40];
        this.payroll = new Employee[MAX_EMPLOYEES];
    }
    

    public String showNames(){
        String out = "";
        for(int i = 0; i < MAX_EMPLOYEES; i++){
            if(payroll[i] != null){
                out += "("+(i+1)+") "+payroll[i].getName()+", ";
            }
        }
        return out;
    }
    public boolean hasWorkers(){
        return amountWorkers < payroll.length;
    }

    public void hireSecretary(String name, int idCard, int numCompletedSemesters, double salary){
        boolean stop = false;
        for(int i = 0; i<MAX_EMPLOYEES && !stop; i++){
            if(payroll[i] == null){
                payroll[i] = new Secretary(name, idCard, numCompletedSemesters, salary);
                stop = true;
            }
        }
        amountWorkers++;
    }
    public void hireFullTimeTeacher(String name, int idCard, int numCompletedSemesters, String degree, boolean investigator, double baseSalary){
        Degree thisDegree = Degree.valueOf(degree);
        boolean stop = false;
        for(int i = 0; i<MAX_EMPLOYEES && !stop; i++){
            if(payroll[i] == null){
                payroll[i] = new FullTime(name, idCard, numCompletedSemesters, thisDegree, investigator, baseSalary);
                stop = true;
            }
        }
        amountWorkers++;
    }
    public void hireLecturer(String name, int idCard, int numCompletedSemesters, String degree, double hoursPerWeek){
        Degree thisDegree = Degree.valueOf(degree);
        boolean stop = false;
        for(int i = 0; i<MAX_EMPLOYEES && !stop; i++){
            if(payroll[i] == null){
                payroll[i] = new Lecturer(name, idCard, numCompletedSemesters, thisDegree, hoursPerWeek);
                stop = true;
            }
        }
        amountWorkers++;
    }
    public void fireEmployee(int index){
        index = index-1;
        payroll[index] = null;
        amountWorkers--;
    }

    public void addToTeachersRoom(int index, Teacher[] onlyTeachers){
        boolean stop = false;
        index = index-1;
        for(int i = 0; i < teachersRoom.length && !stop; i++){
            if(teachersRoom[i] == null){
                teachersRoom[i] = onlyTeachers[index];
                stop = true;
            }
        }
    }
    public void deleteTeacherFromRoom(int index){
        boolean stop = false;
        index = index-1;
        for(int i = 0; i < teachersRoom.length && !stop; i++){
            if(teachersRoom[index] != null){
                teachersRoom[i] = null;
            }
        }

    }
    public Teacher[] teachersRoomArray(){
        Teacher[] onlyTeachers = new Teacher[teachersRoom.length];
        int k = 0;
        for(int i = 0; i < onlyTeachers.length; i++){
            if(payroll[i] instanceof Teacher){
                onlyTeachers[k] = (Teacher)payroll[i];
            }
        }
        return onlyTeachers;
    }
    public String showNamesTeachersRoom(Teacher[] onlyTeachers){
        String out = "";
        for(int i = 0; i < teachersRoom.length; i++){
            if(onlyTeachers[i] != null){
                out += "("+(i+1)+")"+onlyTeachers[i].getName()+", ";
            }
        }
        return out;
    }
    public String showTeachersRoom(){
        String out = "";
        int aFullTime = 0;
        int aLecturer = 0;
        int totalTeachers = 0;
        for(int i = 0; i < teachersRoom.length; i++){
            if(teachersRoom[i] != null){
                if(teachersRoom[i] instanceof FullTime ){aFullTime++; totalTeachers++;}
                else if(teachersRoom[i] instanceof Lecturer){aLecturer++; totalTeachers++;}
            }
        }
        out += "********** Sala de profesores **********\n";
        out += "Profesores de tiempo completo: "+aFullTime+"\n";
        out += "Profesores de cátedra: "+aLecturer+"\n";
        out += "Total de profesores en la sala: "+totalTeachers+"\n";
        return out;
    }
    public void removeFromTeachersRoom(String name){
        boolean stop = false;
        for(int i = 0; i < teachersRoom.length && !stop; i++){
            if(teachersRoom[i].getName().equals(name)){
                teachersRoom[i] = null;
                stop = true;
            }
        }
    }
    public String departmentStatistics(){
        String out = "";
        for(int i = 0; i < MAX_EMPLOYEES; i++){
            if(payroll[i] != null){
                out += payroll[i].showStatistics();
                out += "****************************\n";
            }
        }
        return out;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teacher[] getTeachersRoom() {
        return teachersRoom;
    }

    public void setTeachersRoom(Teacher[] teachersRoom) {
        this.teachersRoom = teachersRoom;
    }

}