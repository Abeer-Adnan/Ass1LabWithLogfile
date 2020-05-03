/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ass1lab;

import java.util.Map;
import java.util.TreeMap;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author rant
 */
public class Ass1Lab extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane paneTableView = FXMLLoader.load(getClass().getResource("assLab.fxml"));
     
        
        Map<String,Pane>mapPanes=new TreeMap<>(); 
        mapPanes.put("doctors", paneTableView);
       
        
        Scene scene = new Scene(mapPanes.get("doctors"));
        
        primaryStage.setTitle("Hospital App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
    
}
