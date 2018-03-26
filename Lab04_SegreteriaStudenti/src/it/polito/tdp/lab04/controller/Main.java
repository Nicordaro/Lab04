package it.polito.tdp.lab04.controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		
		//Da fare 
	

		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("SegreteriaStudenti.fxml"));
			BorderPane root = (BorderPane) loader.load();

			SegreteriaStudentiController controller = loader.getController();

			/*
			 * Create and set the model here!
			 */
			// controller.setModel();

			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
