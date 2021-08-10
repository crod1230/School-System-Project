/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schoolsystemproject;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Nina
 */
public class CourseAddController implements Initializable {
    static Course course;
    
    @FXML private Button back;
    @FXML private Button removeCourse; 
    @FXML private Button addCourse;
    @FXML private ListView<Course> list; 
    @FXML private TextField addName;
    @FXML private TextField addSubject;
    @FXML private TextField addNumber;
    @FXML private TextField addCredit; 
    private List<Course> courseList;
  
    //adds a course object to the courseList
    @FXML
    public void addCourse(TextField course) {
        list.getItems();
        //get object associated with list view
        list.add(course.getText());
    }
    
    
    //fields for switching scenes
    private Stage stage; 
    private Scene scene; 
    private Parent parent;
    
    //method to return to main scene 
    @FXML
    public void returnToMain(ActionEvent event) throws IOException {
        this.parent = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        this.stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        this.scene = new Scene(parent); 
        this.stage.setScene(scene); 
        this.stage.show();
    }
    
    
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        course = new Course();
        
        List<String> courseListAsStrings = new ArrayList<>();
        
        ObservableList<Lemonade> items = FXCollections.observableList(LemonadeStand2.cart.getCart());
        cartListView.setItems(items);

        setLabels();
        
        
    }    
    
}
