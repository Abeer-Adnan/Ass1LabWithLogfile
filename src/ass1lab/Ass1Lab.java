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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author rant
 */
public class Ass1Lab extends Application{
AssLabController c;
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader f=new FXMLLoader();
        Parent paneTableView = f.load(getClass().getResource("assLab.fxml"));       
        c=f.getController();
        Scene scene = new Scene(paneTableView);
        
        primaryStage.setTitle("Hospital App");
        primaryStage.setScene(scene);
        primaryStage.setOnCloseRequest(value->{
            c.pw.close();
        });
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
    
}
