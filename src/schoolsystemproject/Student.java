package schoolsystemproject;


import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nina
 */
public class Student {
    //fields 
    private LocalDate dob; //student date of birth
    private String name; //student full name
    private String grade; //student grade level
    private String major; //student major 
    private String finalID; //identification number
    private List<Course> coursesTaking; //list of courses student is taking
    private Integer creditHours; //keeps count of credit hours for classes taken
    
    //methods 
    public Student(String n, LocalDate d, String g, String m, String i) {
        //set all fields EXCEPT coursesTaking and credit 
        name = n;  
        dob = d;
        grade = g;
        major = m;
        finalID = i;
        coursesTaking = new ArrayList<>();
        creditHours = 0;
        //initialize coursesTaking to a newList<>() and creditHours to 0
    }
    
    //methods
    public int age() {
        //calculate age based on dob and return it 
        LocalDate today = LocalDate.now(); //locates the current local time 
        
        Period p = Period.between(this.dob, today); //calculates time difference between two dates 
        
        return p.getYears();
    }
    
    public void showClasses() {
        System.out.println("Courses student is taking: " + this.coursesTaking);
        //print all classes the student is taking 
    }
    
    public void addCourse(Course course) {
        //adds a class object to courseTaking list AND add the corresponding credit hours to this.creditHours
        
        this.coursesTaking.add(course);
        this.creditHours = this.creditHours + course.getCredit();
        System.out.println(course.toString() + " has been added to Student Courses Taking List");
        System.out.println("Current number of credit hours: " + this.creditHours);
        
    }
    
    
    //get + set DateOfBirth
    public void setDoB(int year, int month, int day) {
        this.dob = LocalDate.of(year, month, day);
    }
    public LocalDate getDoB() {
        return this.dob;
    }
    
    //get + set Name 
    public void setName(String newName) {
        this.name = newName;
    }
    public String getName() {
        return this.name;
    }
    
    //get + set Grade
    public void setGrade(String newGrade) {
        this.grade = newGrade;
    }
    public String getGrade() {
        return this.grade;
    }
    
    //get + set Major 
    public void setMajor(String newMajor) {
        this.major = newMajor;
    }
    public String getMajor() {
        return this.major;
    }
    
    //get + set Final ID
    public void setFinalID(String newID) {
        this.finalID = newID;
    }
    public String getFinalID() {
        return this.finalID;
    }
}
