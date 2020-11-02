package ui;

import java.util.Scanner;
import model.Department;

public class Main {
    
    private Department myDepartment;
    private Scanner sc;

    public Main(){
        myDepartment = new Department(""); //!Cambiar nombre al departamento
        sc = new Scanner(System.in);
    }
    public static void main(String[] args){
        System.out.println("Inicio del codigo");
        int operation = 0;
        Main myMain = new Main();
        do{
            operation = myMain.showMenu();
            myMain.executeOption(operation);
        }while (operation != 0);

    }
    public int showMenu(){
        int option = 0;
        System.out.println(
            "Menú principal, seleccione una opción\n" +
            "(1) Agregar Profesor \n" +
            "(2) Agregar Secretario(a) \n"+
            "(3) Mostrar nomina\n"+
            "(4) Eliminar empleado de la nomina\n" +  
            "(5) Añadir profesor a la sala de profesores\n" +
            "(6) Mostrar sala de profesores\n" +
            "(7) Eliminar profesor a la sala de profesores\n" +
            "(0) Para salir"
            );
        option= sc.nextInt();
        sc.nextLine();
        return option;
    }
    public void executeOption(int operation){
        switch (operation){
            case 1:
            int sOption = 0;
            System.out.println("-----------------------------------");
            System.out.println("Que tipo de profesor desea añadir?");
            System.out.println("-----------------------------------");
            System.out.println("(1) Tiempo completo"+"\n"+
                                "(2) Hora catedra");
            sOption = sc.nextInt();
            switch(sOption){
                case 1:
                String name = "";
                int idCode = 0;
                int numSemesters = 0;
                String degree = "";
                boolean investigator = false;
                //!Hacer el degree
                //! Hacer investigator
                double baseSalary = 0.0;
                int decision = 0;
                if(myDepartment.hasWorkers()){
                    sc.nextLine();
                    System.out.println("Ingrese el nombre del profesor");
                    name = sc.nextLine();
                    System.out.println("Ingrese el código");
                    idCode = sc.nextInt();
                    System.out.println("Ingrese el numero de semestres completados");
                    numSemesters = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Ingrese el nivel de estudios: \n(1) Undergrad \n(2) Master \n(3) PhD");
                    decision = sc.nextInt();
                    if(decision == 1){degree = "UNDERGRAD";}
                    else if(decision == 2){degree = "MASTER";}
                    else if(decision == 3){degree = "PHD";}
                    decision = 0;
                    System.out.println("Es investigador?");
                    System.out.println("(1) Si \n(2) No");
                    decision = sc.nextInt();
                    if(decision == 1){ investigator = true;}
                    else{ investigator = false; }
                    System.out.println("Ingrese el salario base");
                    baseSalary = sc.nextDouble();
                    myDepartment.hireFullTimeTeacher(name, idCode, numSemesters, degree, investigator, baseSalary);
                    System.out.println("----------------------------------");
                    System.out.println("Profesor(a) de tiempo completo creado(a) con éxito");
                    System.out.println("----------------------------------");
                    //System.out.println(myDepartment.departmentStatistics());
                }else{
                    System.out.println("No puede añadir mas trabajadores a la nomina");
                }
                break;
                case 2:
                if(myDepartment.hasWorkers()){
                    int hoursPerWeek = 0;
                    degree = "";
                    sc.nextLine();
                    System.out.println("Ingrese el nombre del profesor");
                    name = sc.nextLine();
                    System.out.println("Ingrese el código");
                    idCode = sc.nextInt();
                    System.out.println("Ingrese el numero de semestres completados");
                    numSemesters = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Ingrese el nivel de estudios: \n(1) Undergrad \n(2) Master \n(3) PhD");
                    decision = sc.nextInt();
                    if(decision == 1){degree = "UNDERGRAD";}
                    else if(decision == 2){degree = "MASTER";}
                    else if(decision == 3){degree = "PHD";}
                    decision = 0;
                    if(decision == 1){ investigator = true;}
                    else{ investigator = false; }
                    System.out.println("Ingrese las horas trabajadas por semana");
                    hoursPerWeek = sc.nextInt();
                    myDepartment.hireLecturer(name, idCode, numSemesters, degree, hoursPerWeek);
                    System.out.println("----------------------------------");
                    System.out.println("Profesor(a) de cátedra creado(a) con éxito");
                    System.out.println("----------------------------------");
                    //System.out.println(myDepartment.departmentStatistics());
                }else{
                    System.out.println("No puedes añadir mas trabajadores a la nomina");
                }
                break;
            }
                break;
            case 2:
            String name = "";
            int code = 0;
            int amountSem = 0;
            double salary = 0.0;
            if(myDepartment.hasWorkers()){
                System.out.println("Ingrese el nombre de el/la secretario(a)");
                name = sc.nextLine();
                System.out.println("Ingrese el código de el/la secretario(a)");
                code = sc.nextInt();
                System.out.println("Ingrese la cantidad de semestres completados por el/la secretario(a)");
                amountSem = sc.nextInt();
                System.out.println("Ingrese el salario de el/la secretario(a)");
                salary = sc.nextDouble();
                myDepartment.hireSecretary(name, code, amountSem, salary);
                System.out.println("----------------------------------");
                System.out.println("Secretario(a) creado(a) con éxito");
                System.out.println("----------------------------------");
                //System.out.println(myDepartment.departmentStatistics());
                
            }else{
                System.out.println("No puedes añadir mas trabajadores a la nomina");
            }
                break;
            case 3:
                if(myDepartment.departmentStatistics().equals("")){
                    System.out.println("----------------------------------");
                    System.out.println("El departamento está vacío");
                    System.out.println("----------------------------------");
                }else{
                    System.out.println("----------------------------------");
                    System.out.println(myDepartment.departmentStatistics());
                    System.out.println("----------------------------------");
                }
                
                break;
            case 4:
                int index = 0;
                System.out.println("Que trabajador desea eliminar de la nomina?");
                System.out.println(myDepartment.showNames());
                index = sc.nextInt();
                myDepartment.fireEmployee(index);
                System.out.println("----------------------------------");
                System.out.println("Trabajador eliminado de la nomina");
                System.out.println("----------------------------------");
                break;
            case 5:
                int index2 = 0;
                System.out.println("Que profesor desea añadir a la sala de profesores?");
                System.out.println(myDepartment.showNamesTeachersRoom(myDepartment.teachersRoomArray()));
                index2 = sc.nextInt();
                myDepartment.addToTeachersRoom(index2, myDepartment.teachersRoomArray());
                System.out.println("----------------------------------");
                System.out.println("Profesor añadido a la sala de profesores");
                System.out.println("----------------------------------");
                break;
            case 6:
                System.out.println(myDepartment.showTeachersRoom());
                break;
            case 7:
                int index3 = 0;
                System.out.println("Que profesor desea eliminar de la sala de profesores?");
                System.out.println(myDepartment.showNamesTeachersRoom(myDepartment.teachersRoomArray()));
                index3 = sc.nextInt();
                myDepartment.deleteTeacherFromRoom(index3);
                System.out.println("----------------------------------");
                System.out.println("Profesor eliminado de la sala de profesores");
                System.out.println("----------------------------------");
                break;
        }
    }
}
