package it.polito.tdp.lab04.model;

import java.util.*;

public class Corso {
	
	private List<Integer> matricoleStudentiIscritti = new ArrayList<Integer>();
	private List<Studente> studentiIscritti = new ArrayList<Studente>();

	private String codins;
	private int numeroCrediti;
	private String nome;
	private int periodoDidattico;
	
	public Corso(String codins, int numeroCrediti, String nome, int periodoDidattico) {
		super();
		this.codins = codins;
		this.numeroCrediti = numeroCrediti;
		this.nome = nome;
		this.periodoDidattico = periodoDidattico;
	}

	public String getCodins() {
		return codins;
	}

	public void setCodins(String codins) {
		this.codins = codins;
	}

	public int getNumeroCrediti() {
		return numeroCrediti;
	}

	public void setNumeroCrediti(int numeroCrediti) {
		this.numeroCrediti = numeroCrediti;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getPeriodoDidattico() {
		return periodoDidattico;
	}

	public void setPeriodoDidattico(int periodoDidattico) {
		this.periodoDidattico = periodoDidattico;
	}
	
	public void aggiungiMatricolaStudente(int matricolaStudente) {
		matricoleStudentiIscritti.add(matricolaStudente);
	}
	
	public void aggiungiStudentiIscritti(Studente studente) {
		studentiIscritti.add(studente);
	}

	public List<Integer> getMatricoleStudentiIscritti() {
		return matricoleStudentiIscritti;
	}

	public void setMatricoleStudentiIscritti(List<Integer> matricoleStudentiIscritti) {
		this.matricoleStudentiIscritti = matricoleStudentiIscritti;
	}

	public List<Studente> getStudentiIscritti() {
		return studentiIscritti;
	}

	public void setStudentiIscritti(List<Studente> studentiIscritti) {
		this.studentiIscritti = studentiIscritti;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codins == null) ? 0 : codins.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Corso other = (Corso) obj;
		if (codins == null) {
			if (other.codins != null)
				return false;
		} else if (!codins.equals(other.codins))
			return false;
		return true;
	}

}
