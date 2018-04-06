package it.polito.tdp.lab04.model;

import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.lab04.DAO.CorsoDAO;
import it.polito.tdp.lab04.DAO.StudenteDAO;

public class Model {
	
	CorsoDAO corsoDao = new CorsoDAO();
	StudenteDAO studenteDao = new StudenteDAO();
	
	public List<Corso> listaCorsi = new ArrayList<Corso>();
	public List<Studente> listaStudenti = new ArrayList<Studente>(studenteDao.getTuttiGliStudenti());
	
	public void inizializza() {
		for(Corso c: listaCorsi) {
			for(Studente s: listaStudenti) {
				if(c.getMatricoleStudentiIscritti().contains(s.getMatricola())) {
					c.aggiungiStudentiIscritti(s);
					s.aggiungiCorsi(c);
				}
			}
		}
	}
	
	public List<Corso> getCorsi(){
		listaCorsi=corsoDao.getTuttiICorsi();
		return listaCorsi;
	}
	
	public List<String> listaCorsi(){
		List<String> ctemp = new ArrayList<>();
		for(Corso corso : this.listaCorsi) {
			ctemp.add(corso.getNome());
		}
		return ctemp;
	}
	
	public List<Studente> getStudenti(){
		return listaStudenti;
	}
	
	public Studente autocomplete(String matricola) {
		int numeroMatr=Integer.parseInt(matricola);
		Studente stemp=null;
		for(Studente s: listaStudenti) {
			if(s.getMatricola()==numeroMatr)
				stemp=s;
		}
		return stemp;
	}
	
	public List<Studente> getStudentiPerCorso(Corso corso){
		List<Studente> studentifreq = new ArrayList<>();
		for(Corso c: listaCorsi) {
			if (c.equals(corso)) {
				for(Studente s: c.getStudentiIscritti()) {
					studentifreq.add(new Studente(s.getMatricola(), s.getCognome(), s.getNome(), s.getCDS()));
				}
			}
		}
		return studentifreq;
	}
	
	public List<Studente> getStudentiIscrittiAlCorso(Corso corso) {
		return corsoDao.getStudentiIscrittiAlCorso(corso);
	}
	
	
	
	public List<Corso> getCorsiPerStudente(Studente studente){
		List<Corso> corsifreq = new ArrayList<>();
		for(Studente s: listaStudenti) {
			if (studente.equals(s)) {
				for(Corso c: s.getCorsi()) {
					corsifreq.add(new Corso(c.getCodins(), c.getNumeroCrediti(), c.getNome(), c.getPeriodoDidattico()));
				}
			}
		}
		return corsifreq;
	}
	
	public void iscrivi(Studente studente, Corso corso) {
		for(Studente s: listaStudenti) {
			if(s.equals(studente)) {
				for(Corso c: listaCorsi) {
					if(c.equals(corso)) {
						c.aggiungiStudentiIscritti(s);
						s.aggiungiCorsi(c);
						}
				}
				}
			}
	}
}
