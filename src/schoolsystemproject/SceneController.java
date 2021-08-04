/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schoolsystemproject;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Nina
 */
public class SceneController {
    
    private Stage stage; 
    private Scene scene; 
    private Parent parent;
    
    public void switchToCourses(ActionEvent event) throws IOException {
        this.parent = FXMLLoader.load(getClass().getResource("CourseAdd.fxml"));
        this.stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        this.scene = new Scene(parent); 
        this.stage.setScene(scene);
        this.stage.show();
    }
    
    public void switchToProfessors(ActionEvent event) throws IOException {
        this.parent = FXMLLoader.load(getClass().getResource("ProfessorAdd.fxml"));
        this.stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        this.scene = new Scene(parent); 
        this.stage.setScene(scene);
        this.stage.show();
    }
    
    public void switchToStudents(ActionEvent event) throws IOException {
        this.parent = FXMLLoader.load(getClass().getResource("CourseAdd.fxml"));
        this.stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        this.scene = new Scene(parent); 
        this.stage.setScene(scene);
        this.stage.show();
    }
}
