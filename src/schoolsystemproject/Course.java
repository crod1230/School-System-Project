package schoolsystemproject;
import java.util.List;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nina
 */
public class Course {
    //fields 
    private String courseName; //name of course
    private String courseSubject; //3 letter acronym (CSC or MAT)
    private String courseNumber; //3 numbers that rep course number
    private Professor professor; //represents prof teaching this class 
    private Integer creditHours;
    private List<Course> courseList; 
    
    //methods 
    public Course(String name, String subj, String num, Integer cred) {
        //sets all fields 
        courseName = name;
        courseSubject = subj;
        courseNumber = num;
        creditHours = cred;
    }
    
    //prints all classes the prof teaches
    public void showClasses() {
        System.out.println("Courses taught by this professor: ");
        for (int i = 0; i < courseList.size(); i++)
            System.out.println(courseList.get(i).toString());
    }
    
    //adds a class object to the coursesTaught list
    public void addClass(Course course) {
        courseList.add(course);
        System.out.println(course.toString() + " has been added to Professor's Course List");
    }
    
    
 
    //get + set Course Name
    public void setCourseName(String newName) {
        this.courseName = newName;
    }
    public String getCourseName() {
        return this.courseName;
    }
    
    
    //get + set Course Subject 
    public void setCourseSubj(String newSubj) {
        this.courseSubject = newSubj;
    }
    public String getCourseSubj() {
        return this.courseSubject;
    }
    
    
    //get + set Course Number 
    public void setCourseNum(String newNum) {
        this.courseNumber = newNum;
    }
    public String getCourseNum() {
        return this.courseNumber;
    }
  
    
    //get + set course Professor 
    public void setCourseProf(Professor newProf) {
        this.professor = newProf;
    }
    public Professor getCourseProf() {
        return this.professor;
    }
    
    
    //get + set course Credit Hours 
    public void setCredit(int newCred) {
        this.creditHours = newCred;
    }
    public int getCredit() {
        return this.creditHours;
    }
    
    
    
    public List<Course> getCourseList() {
        return this.courseList;
    }
    
    
    
    public void fullCourseID() {
        //return concatenation of course subject and number with "-" in between
        //Ex. CSC-111 or MAT-256
        System.out.println("Full Course ID: " + this.courseSubject + "-" + this.courseNumber);
    }
   
    
    @Override
    public String toString() {
        return courseName;
    }
}
