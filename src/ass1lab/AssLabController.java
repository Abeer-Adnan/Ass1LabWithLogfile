/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ass1lab;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import sun.util.logging.PlatformLogger;

/**
 * FXML Controller class
 *
 * @author rant
 */
public class AssLabController implements Initializable {

    @FXML
    private TextField textId;
    @FXML
    private TextField textName;
    @FXML
    private TextField textAge;
    @FXML
    private TextField textSpec;
    @FXML
    private TableView<doctors> tableView;
    @FXML
    private TableColumn<doctors, Integer> tcID;
    @FXML
    private TableColumn<doctors, String> tcName;
    @FXML
    private TableColumn<doctors, Integer> tcAge;
    @FXML
    private TableColumn<doctors, String> tcSpec;
    @FXML
    private Button buttonView;
    @FXML
    private Button buttonAdd;
    @FXML
    private Button buttonUpdate;
    @FXML
    private Button buttonDelete;
    @FXML
    private Button buttonReset;
    @FXML
    private Button buttonExit;
    Statement statement;
    PrintWriter pw;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
          try {
           
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection =
               DriverManager.
                getConnection("jdbc:mysql://127.0.0.1:3306/hospitall?serverTimezone=UTC",
                        "root", "");
            this.statement = connection.createStatement();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        try {
            pw=new PrintWriter(new FileWriter(new File("src/ass1lab/ss.txt"),true));
            pw.println("************************** \n ");
        } catch (IOException ex) {
            Logger.getLogger(AssLabController.class.getName()).log(Level.SEVERE, null, ex);
        }
          
        tcID.setCellValueFactory(new PropertyValueFactory("id"));
        tcName.setCellValueFactory(new PropertyValueFactory("name"));
        tcAge.setCellValueFactory(new PropertyValueFactory("age"));
        tcSpec.setCellValueFactory(new PropertyValueFactory("specialization"));
        tableView.getSelectionModel().selectedItemProperty().addListener(
                event-> showSelectedDoctors() );
    }    
private void showSelectedDoctors() {
        doctors doc = tableView.getSelectionModel().getSelectedItem();
        if (doc != null) {
            textId.setText(String.valueOf(doc.getId()));
            textName.setText(doc.getName());
            textAge.setText(String.valueOf(doc.getAge()));
            textSpec.setText(doc.getSpecialization());
        }

    }
    @FXML
    private void buttonViewHandle(ActionEvent event) throws Exception {
        ResultSet rs = this.statement.executeQuery("select * From doctors");
        tableView.getItems().clear();
        while (rs.next()) {
            doctors doc = new doctors();
            doc.setId(rs.getInt("id"));
            doc.setName(rs.getString("name"));
            doc.setAge(rs.getInt("age"));
            doc.setSpecialization(rs.getString("specialization"));
            tableView.getItems().add(doc);
        }
        pw.flush();
    }
                
    

    @FXML
    private void buttonAddHandle(ActionEvent event)throws Exception {
      Integer id = Integer.parseInt(textId.getText());
        String name = textName.getText();
        Integer age = Integer.parseInt(textAge.getText());
        String specialization = textSpec.getText();
        String sql = "Insert Into doctors values(" + id + ",'" + name + "',"
                + age + ",'" + specialization + "')";
        this.statement.executeUpdate(sql);
        pw.println("Added new Doctor : \n "+ new doctors(id, name, age, specialization));
        pw.flush();
        
    }

    @FXML
    private void buttonUpdateHandle(ActionEvent event)throws Exception{
  Integer id = Integer.parseInt(textId.getText());
        String name = textName.getText();
        Integer age = Integer.parseInt(textAge.getText());
        String specialization = textSpec.getText();
        String sql = "Update doctors Set name='" + name + "', age="
                + age + ", specialization='" + specialization + "' Where id=" + id;
        this.statement.executeUpdate(sql);
        pw.println("Update Doctor to : \n "+ new doctors(id, name, age, specialization));
        pw.flush();
    }

    @FXML
    private void buttonDeleteHandle(ActionEvent event) throws Exception{
       Integer id = Integer.parseInt(textId.getText());
        String name = textName.getText();
        Integer age = Integer.parseInt(textAge.getText());
        String specialization = textSpec.getText();
        String sql = "Delete From doctors Where id=" + id;
        pw.println("Deleted Doctor : \n "+ new doctors(id, name, age, specialization));
        pw.flush();
        this.statement.executeUpdate(sql);
    }

    @FXML
    private void buttonResetHandle(ActionEvent event) {
        textId.setText("");
        textName.setText("");
        textAge.setText("");
        textSpec.setText("");
        tableView.getItems().clear();
    }

    @FXML
    private void buttonExitHandle(ActionEvent event) {
        System.exit(0);
    }
    
}
