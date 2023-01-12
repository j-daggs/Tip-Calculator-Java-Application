/*
======================================================================================================================
PROGRAM PURPOSE: The purpose of TipCalculatorController.java is to implement a class TipCalculatorController that is the
				controller for TipCalculator.fxml. The controller is to implement a modified tip controller app that
				allows the user to enter the number of people in the party. Then (when the calculate button is pressed),
				The program is to calculate and display the amount owed by each person in an even split, as well as the
				tip amount and the total amount in the corresponding fields.

Name: John Daggs
Date: 4/15/2022
Section: CSC 331-002
======================================================================================================================
*/

package com.example.tipcalculator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

public class TipCalculatorController {
	private static final NumberFormat currency = NumberFormat.getCurrencyInstance();
	private static final NumberFormat percent = NumberFormat.getPercentInstance();

	private BigDecimal tipPercentage = new BigDecimal(0.15); // 15% default

	@FXML
	private TextField amountTextField;

	@FXML
	private TextField peopleTextField;

	@FXML
	private TextField eachPersonTextField;

	@FXML
	private Label tipPercentageLabel;
	@FXML
	private Slider tipPercentageSlider;

	@FXML
	private TextField tipTextField;

	@FXML
	private TextField totalTextField;


	@FXML
	private void calculateButtonPressed(ActionEvent event) {

		try {
			BigDecimal amount = new BigDecimal(amountTextField.getText());
			BigDecimal people = new BigDecimal(peopleTextField.getText());
			BigDecimal tip = amount.multiply(tipPercentage);
			BigDecimal total = amount.add(tip);

			// variable representing the amount of each person
			BigDecimal eachPerson = total.divide(people);



			tipTextField.setText(currency.format(tip));
			totalTextField.setText(currency.format(total));

			// Format eachPerson
			eachPersonTextField.setText(currency.format(eachPerson));
		} catch (NumberFormatException ex) {
			amountTextField.setText("Enter the amount");

			// for entering the number of people
			peopleTextField.setText("Enter the number of people");
			amountTextField.selectAll();
			amountTextField.requestFocus();
		}
	}

	public void initialize() {

		currency.setRoundingMode(RoundingMode.HALF_UP);

		// listener to accommodate for changes made to the tipPercentageSlider
		tipPercentageSlider.valueProperty().addListener((ChangeListener) (observable, oldValue, newValue) -> {
			tipPercentage = BigDecimal.valueOf(((Number) newValue).intValue() / 100.0);
			tipPercentageLabel.setText(percent.format(tipPercentage));
		});
	}
}

