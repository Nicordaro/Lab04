/**
 * Sample Skeleton for 'SegreteriaStudenti.fxml' Controller Class
 */

package it.polito.tdp.lab04.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class SegreteriaStudentiController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="comboBox"
    private ComboBox<?> comboBox; // Value injected by FXMLLoader

    @FXML // fx:id="btnSearchSubscribers"
    private Button btnSearchSubscribers; // Value injected by FXMLLoader

    @FXML // fx:id="txtName"
    private TextField txtName; // Value injected by FXMLLoader

    @FXML // fx:id="txtID"
    private TextField txtID; // Value injected by FXMLLoader

    @FXML // fx:id="btnComplete"
    private Button btnComplete; // Value injected by FXMLLoader

    @FXML // fx:id="txtSurname"
    private TextField txtSurname; // Value injected by FXMLLoader

    @FXML // fx:id="btnSearchCourses"
    private Button btnSearchCourses; // Value injected by FXMLLoader

    @FXML // fx:id="btnSubscribe"
    private Button btnSubscribe; // Value injected by FXMLLoader

    @FXML // fx:id="txtLog"
    private TextArea txtLog; // Value injected by FXMLLoader

    @FXML // fx:id="btnReset"
    private Button btnReset; // Value injected by FXMLLoader

    @FXML
    void doComplete(ActionEvent event) {

    }

    @FXML
    void doPopola(ActionEvent event) {

    }

    @FXML
    void doReset(ActionEvent event) {

    }

    @FXML
    void doSearchCourses(ActionEvent event) {

    }

    @FXML
    void doSearchSubscribers(ActionEvent event) {

    }

    @FXML
    void doSubscribe(ActionEvent event) {

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert comboBox != null : "fx:id=\"comboBox\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btnSearchSubscribers != null : "fx:id=\"btnSearchSubscribers\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert txtName != null : "fx:id=\"txtName\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert txtID != null : "fx:id=\"txtID\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btnComplete != null : "fx:id=\"btnComplete\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert txtSurname != null : "fx:id=\"txtSurname\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btnSearchCourses != null : "fx:id=\"btnSearchCourses\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btnSubscribe != null : "fx:id=\"btnSubscribe\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert txtLog != null : "fx:id=\"txtLog\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";

    }
}
