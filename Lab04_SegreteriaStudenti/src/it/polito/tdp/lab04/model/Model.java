package it.polito.tdp.lab04.model;

import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.lab04.DAO.CorsoDAO;
import it.polito.tdp.lab04.DAO.StudenteDAO;

public class Model {
	
	CorsoDAO corsoDao = new CorsoDAO();
	StudenteDAO studenteDao = new StudenteDAO();
	
	private List<Corso> listaCorsi = new ArrayList<Corso>(corsoDao.getTuttiICorsi());
	private List<Studente> listaStudenti = new ArrayList<Studente>(studenteDao.getTuttiGliStudenti());
	
	public List<Corso> getCorsi(){
		return listaCorsi;
	}
	
	//public List<Studente>
}
