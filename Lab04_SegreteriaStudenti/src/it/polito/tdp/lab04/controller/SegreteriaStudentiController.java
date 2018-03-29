/**
 * Sample Skeleton for 'SegreteriaStudenti.fxml' Controller Class
 */

package it.polito.tdp.lab04.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.lab04.model.Model;
import it.polito.tdp.lab04.model.Studente;
import it.polito.tdp.lab04.model.Corso;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class SegreteriaStudentiController {
	
	Model model = new Model();

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="comboBox"
    private ComboBox<Corso> comboBox; // Value injected by FXMLLoader

    @FXML // fx:id="btnSearchSubscribers"
    private Button btnSearchSubscribers; // Value injected by FXMLLoader

    @FXML // fx:id="txtID"
    private TextField txtID; // Value injected by FXMLLoader

    @FXML // fx:id="btnComplete"
    private Button btnComplete; // Value injected by FXMLLoader

    @FXML // fx:id="txtName"
    private TextField txtName; // Value injected by FXMLLoader

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
    	String matricola = txtID.getText();
    	txtLog.clear();
    	txtName.clear();
    	txtSurname.clear();
    	Studente stemp;
    	if(matricola.length()==0) {
    		txtLog.setText("Errore, devi inserire un numero di matricola!");
    	} else {
    	
    	stemp=model.autocomplete(matricola);
    	txtName.setText(stemp.getNome());
    	txtSurname.setText(stemp.getCognome());
    	}
    }

    @FXML
    void doReset(ActionEvent event) {
    	txtID.clear();
    	txtLog.clear();
    	txtName.clear();
    	txtSurname.clear();
    }

    @FXML
    void doSearchCourses(ActionEvent event) {
    	
    	try {
    		
    	String matricola = txtID.getText();
    	
    	Studente stemp;
    	int counter =0;
    	List<Corso> corsi = new ArrayList<>();
    	String corsiSeguiti = "";
    	if(matricola.length()==0) {
    		txtLog.setText("Errore, devi inserire un numero di matricola!");
    	} else {
    	int matrN=Integer.parseInt(matricola);
    	stemp=model.autocomplete(matricola);
    	for(Studente s: model.listaStudenti) {
    		if(s.getMatricola()==matrN) {
    		for(Corso c: s.getCorsi()) {
    			corsiSeguiti+= c.toString()+"\n";
    			}
    		}
    	}
    		txtLog.setText(corsiSeguiti);
    	
    	
    	}}
    	catch(Exception e){
    		txtLog.appendText("Errore nell'inserimento");
    		System.out.println("Errore nell'inserimento.");
    	}
    }

    @FXML
    void doSearchSubscribers(ActionEvent event) {
    	String studentiIscritti="";
    	if(comboBox.getValue()!=null) {
    	for(Studente s : model.getStudentiPerCorso(comboBox.getValue())) {
    		studentiIscritti+= s.toString()+"\n";
    	}
    		txtLog.appendText(studentiIscritti);
    	}
    	else {
    		txtLog.appendText("Errore nell'inserimento");
    		txtLog.setText("Errore, seleziona un corso!");
    	}
    }

    @FXML
    void doSelectCourse(ActionEvent event) {

    }

    @FXML
    void doSubscribe(ActionEvent event) {
    	try {
    		if(comboBox.getValue()!=null && txtID.getText().length()!=0) {
    			Corso ctemp = comboBox.getValue();
    			String mtemp = txtID.getText();
    			Studente stemp=model.autocomplete(mtemp);
    			model.iscrivi(stemp, ctemp);
    			txtLog.setText("Studente " +stemp.toString()+ " iscritto al corso: "+ctemp.toString());
    		}
    	
    	
    	}
    	catch(Exception e) {
    		System.out.println("Errore nell'inserimento.");
    	}

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert comboBox != null : "fx:id=\"comboBox\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btnSearchSubscribers != null : "fx:id=\"btnSearchSubscribers\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert txtID != null : "fx:id=\"txtID\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btnComplete != null : "fx:id=\"btnComplete\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert txtName != null : "fx:id=\"txtName\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert txtSurname != null : "fx:id=\"txtSurname\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btnSearchCourses != null : "fx:id=\"btnSearchCourses\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btnSubscribe != null : "fx:id=\"btnSubscribe\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert txtLog != null : "fx:id=\"txtLog\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        comboBox.getItems().addAll(model.getCorsi());
        comboBox.getItems().add(model.getCorsi().size(), null);
        model.inizializza();

    }
}
