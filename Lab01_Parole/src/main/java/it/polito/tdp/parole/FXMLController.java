package it.polito.tdp.parole;

import it.polito.tdp.parole.model.Parole;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	Parole elenco;
	LinkedList<String> lista = new LinkedList<String>();

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TextField txtParola;

	@FXML
	private Button btnInserisci;

	@FXML
	private TextArea txtResult;

	@FXML
	private Button btnReset;

	@FXML
	private TextArea txtTempiEsecuzione;

	@FXML
	private Button btnCancella;

	@FXML
	void doInsert(ActionEvent event) {
		// TODO

		String parola = txtParola.getText();

		elenco.addParola(parola);
		txtParola.clear();

		lista.add(parola);
		Collections.sort(lista);

		String x = "";
		for (String s : elenco.getElenco()) {
			x += s + "\n";
		}
		txtResult.setText(x);

		double tempo = System.nanoTime();
		this.txtTempiEsecuzione.setText(Double.toString(tempo));

	}

	@FXML
	void doReset(ActionEvent event) {

		lista.clear();
		elenco.reset();
		txtResult.clear();

		double tempo = System.nanoTime();
		this.txtTempiEsecuzione.setText(Double.toString(tempo));

	}

	@FXML
	void doCancella(ActionEvent event) {
		String daCancellare = this.txtResult.getSelectedText();
		txtResult.clear();

		LinkedList<String> y = new LinkedList<String>(lista);

		for (String s : y) {
			if (s.compareTo(daCancellare) != 0) {
				txtResult.appendText(s + "\n");
			} else {
				elenco.getElenco().remove(s);
				lista.remove(s);

			}
		}
		

		double tempo = System.nanoTime();
		this.txtTempiEsecuzione.setText(Double.toString(tempo));

	}

	@FXML
	void initialize() {
		assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
		assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
		assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
		assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";
		assert txtTempiEsecuzione != null : "fx:id=\"txtTempiEsecuzione\" was not injected: check your FXML file 'Scene.fxml'.";
		assert btnCancella != null : "fx:id=\"btnCancella\" was not injected: check your FXML file 'Scene.fxml'.";
		elenco = new Parole();
	}
}
