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

public class CorsoDAO {

	private List<Studente> listaStudenti = new ArrayList<Studente>();
	
	/*
	 * Ottengo tutti i corsi salvati nel Db
	 */
	public List<Corso> getTuttiICorsi() {

		final String sql = "SELECT i.matricola, c.*" + 
				"FROM iscrizione AS i LEFT JOIN corso AS c ON i.`codins`=c.`codins`";

		List<Corso> corsi = new LinkedList<Corso>();
		

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				String codins = rs.getString("codins");
				int numeroCrediti = rs.getInt("crediti");
				String nome = rs.getString("nome");
				int periodoDidattico = rs.getInt("pd");

				System.out.println(codins + " " + numeroCrediti + " " + nome + " " + periodoDidattico);
				
				corsi.add(new Corso(codins, numeroCrediti, nome, periodoDidattico));

				// Crea un nuovo JAVA Bean Corso
				// Aggiungi il nuovo oggetto Corso alla lista corsi
			}

			return corsi;

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
	}

	/*
	 * Dato un codice insegnamento, ottengo il corso
	 */
	public void getCorso(Corso corso) {
		for(Corso c: this.getTuttiICorsi()) {
			if(c.equals(corso)) {
				corso.setNome(c.getNome());
				corso.setNumeroCrediti(c.getNumeroCrediti());
				corso.setPeriodoDidattico(c.getPeriodoDidattico());	
			}
		}
	}

	/*
	 * Ottengo tutti gli studenti iscritti al Corso
	 */
	public List<Studente> getStudentiIscrittiAlCorso(Corso corso) {
		for(Corso c: this.getTuttiICorsi()) {
			if(c.equals(corso)) {
				this.listaStudenti=c.getStudenti();
			}
		}
		return listaStudenti;
	}

	/*
	 * Data una matricola ed il codice insegnamento, iscrivi lo studente al corso.
	 */
	public boolean inscriviStudenteACorso(Studente studente, Corso corso) {
		// TODO
		// ritorna true se l'iscrizione e' avvenuta con successo
		for(Corso c: this.getTuttiICorsi()) {
			if(c.equals(corso)) {
				corso.addStudente(studente);
				studente.addCorso(corso);
				return true;
			}
		}
		return false;
	}

	
}


