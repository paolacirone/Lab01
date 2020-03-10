package it.polito.tdp.parole.model;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Parole {
	
	List<String> parole;
		
	public List<String> getParole() {
		return parole;
	}

	public void setParole(List<String> parole) {
		this.parole = parole;
	}

	public Parole() {
		//TODO
		parole= new LinkedList<String>();
	}
	
	public void addParola(String p) {
		//TODO
		parole.add(p);
	}
	
	public List<String> getElenco() {
		Collections.sort(parole);
		return parole;
	}
	
	public void reset() {
		parole.removeAll(parole);
	}

}
