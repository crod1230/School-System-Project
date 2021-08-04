

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nina
 */
public class Professor {
    
    private LocalDate dob; //date of birth 
    private String name; //name of teacher 
    private String edulvl; //education level (bachelor, master, etc.)
    private String dpt; //subject they teach 
    private int finalID; //unique identification for all teachers 
    List<Course> coursesTaught; //list of courses the prof teaches
    
    //name, dob, department, education lvl
    public Professor(String n, LocalDate b, String d, String e, int i) {
        //set parameters in parenthesis 
        name = n;
        dob = b;
        dpt = d;
        edulvl = e;
        finalID = i;
        coursesTaught = new ArrayList<>();
        //initialize fields in here 
    }
    
    
    //calculate and returns age of professor 
    public int age() {
        LocalDate today = LocalDate.now();
        
        Period p = Period.between(this.dob, today);
        
        return p.getYears();
    }
    
    
    //prints all classes the prof teaches
    public void showClasses() {
        System.out.println("Courses taught by this professor: ");
        for (int i = 0; i < coursesTaught.size(); i++)
            System.out.println(coursesTaught.get(i).toString());
    }
    
    //adds a class object to the coursesTaught list
    public void addClass(Course course) {
        coursesTaught.add(course);
        System.out.println(course.toString() + " has been added to Professor's Course List");
    }
    
    
    
    
    //get + set date of birth
    public void setDoB(int year, int month, int day) {
        this.dob = LocalDate.of(year, month, day);
    } 
    public LocalDate getDoB() {
        return this.dob;
    }
    
    
    //get + set name 
    public void setName(String newName) {
        this.name = newName;
    }
    public String getName() {
        return this.name;
    }
    
    
    //get + set department 
    public void setDpt(String newDpt) {
        this.dpt = newDpt;
    } 
    public String getDpt() {
        return this.dpt;
    }
    
    
    //get + set education level 
    public void setEduLvl(String newEduLvl) {
        this.edulvl = newEduLvl;
    }
    public String getEduLvl() {
        return this.edulvl;
    }
    
    @Override
    public String toString() {
        return name.toString();
    }
    

    
    
    
    
    
}
