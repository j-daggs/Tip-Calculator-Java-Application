/*
======================================================================================================================
PROGRAM PURPOSE: The purpose of TipCalculator.java is to implement a class TipCalculator that launches the TipCalculator
				application outlined with TipCalculator.fxml and in TipCalculatorController.java.

Name: John Daggs
Date: 4/15/2022
Section: CSC 331-002
======================================================================================================================
*/

package com.example.tipcalculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TipCalculator extends Application {
	public TipCalculator() {
	}

	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(this.getClass().getResource("TipCalculator.fxml"));
		Scene scene = new Scene(root);
		stage.setTitle("TipCalculator");
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}}