package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Studente;

public class StudenteDAO {
	
	private List<Corso> listaCorsi = new ArrayList<Corso>();
	
//	private CorsoDAO corsodao = new CorsoDAO();
	
	public List<Studente> getTuttiGliStudenti() {

		final String sql = "SELECT * FROM studente";

		List<Studente> studenti = new LinkedList<Studente>();
		

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				int matricola = rs.getInt("matricola");
				String nome = rs.getString("nome");
				String cognome = rs.getString("cognome");
				String corso = rs.getString("CDS");
				

				System.out.println(matricola + " " + cognome + " " + nome + " " + corso);
				

			}

			return studenti;

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
	}
	
	public void getStudente(Studente studente) {
		for(Studente s: this.getTuttiGliStudenti()) {
			if(s.getMatricola()==(studente.getMatricola())) {
				studente.setNome(s.getNome());
				studente.setCognome(s.getCognome());
				studente.setCDS(s.getCDS());
			}
		}
	}
	
	public void getCorsiDelloStudente(Studente studente) {
		for(Studente s: this.getTuttiGliStudenti()) {
			if (s.getMatricola()==studente.getMatricola()) {
				listaCorsi=s.getCorsi();
			}
		}
		// TODO
	}

	public List<Corso> getListaCorsi() {
		return listaCorsi;
	}
	
}
