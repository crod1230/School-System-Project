

import java.time.LocalDate;
import schoolsystemproject.Course;
import schoolsystemproject.Professor;
import schoolsystemproject.Student;

/**
 *
 * @author Nina
 */
public class SchoolSystemTest {
    public static void main(String[] args) {
        
        //create local date objects for birth dates 
        LocalDate s1 = LocalDate.of(2002, 12, 30);
        LocalDate s2 = LocalDate.of(1997, 06, 07);
        LocalDate p1 = LocalDate.of(1976, 03, 24);
        LocalDate p2 = LocalDate.of(1975, 10, 12);
        
        //create 2 student objects
        Student student1 = new Student("Carina Rodriguez", s1, "Freshman", "Art", "9352649");
        Student student2 = new Student("Diego Rodriguez", s2, "Senior", "Computer Science", "8241538");
        
        //create 2 teacher objects
        Professor professor1 = new Professor("Jayna Huffines", p1, "Art", "Bachelors", "1234567");
        Professor professor2 = new Professor("Richard Hunt", p2, "Computer Science", "Masters", "7654321");
        
        //create course obj and assign the teacher objects to each of the courses 
        Course course1 = new Course("Math", "MAT", "001", 3);
        Course course2 = new Course("English", "ENG", "002", 3); 
        Course course3 = new Course("Intro to Computer Science", "CSC", "003", 3); 
        Course course4 = new Course("Visual Arts", "ART", "004", 3);


        System.out.println("Student 1 Name: " + student1.getName());
        System.out.println("Student 1 DoB: " + student1.getDoB());
        System.out.println("Student 1 Grade: " + student1.getGrade());
        System.out.println("Student 1 Major: " + student1.getMajor());
        System.out.println("Student 1 ID: " + student1.getFinalID());
        System.out.println("");
        System.out.println("Course 1 Subject: " + course1.getCourseSubj());
        System.out.println("Course 1 Professor: " + course1.getCourseProf());
        System.out.println("");
        
        
        //Add course objects to the teachers who teach them
        professor1.addClass(course2);
        professor1.addClass(course4);
        professor2.addClass(course1);
        professor2.addClass(course3);
        System.out.println("");
        
        
        //Verify TEACHER COURSES TAUGHT
        professor1.showClasses();
        System.out.println("");
        
        
        //Verify STUDENT COURSES TAKEN + CREDIT HOURS
        student1.addCourse(course4); //Add course objects to student's coursesTaken list
        student1.addCourse(course2);
        student2.addCourse(course1);
        student2.addCourse(course3);
        System.out.println("");
        student1.showClasses();
        System.out.println("");
        student2.showClasses();
        System.out.println("");
        
        
        //VERIFY Age 
        System.out.println("Professor 1 Age: " + professor1.age());
        System.out.println("Student 1 Age: " + student1.age());
        System.out.println("");

        
        //Verify FULL COURSE ID 
        course1.fullCourseID();
        course2.fullCourseID();
        course3.fullCourseID();
        course4.fullCourseID();
    }
    
    
}
