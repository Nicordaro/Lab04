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

	/*
	 * Ottengo tutti i corsi salvati nel Db
	 */
	public List<Corso> getTuttiICorsi() {

		final String sql = "SELECT * FROM corso";
		final String sqlIscr ="SELECT * FROM iscrizione";

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

				Corso corso = new Corso(codins, numeroCrediti, nome, periodoDidattico);
				corsi.add(corso);
				
				// Crea un nuovo JAVA Bean Corso
				// Aggiungi il nuovo oggetto Corso alla lista corsi
			}

			
			PreparedStatement st2 = conn.prepareStatement(sqlIscr);
			
			ResultSet rs2 = st2.executeQuery();
					
					while(rs2.next()) {
						String codCorIns = rs2.getString("codins");
						Corso ctemp = new Corso(codCorIns, 0, null, 0);
						int matricola = rs2.getInt("matricola");
						for(Corso c: corsi) {
							if(c.equals(ctemp)) {
								c.aggiungiMatricolaStudente(matricola);
							}
						}
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
		
		// TODO
	}

	/*
	 * Ottengo tutti gli studenti iscritti al Corso
	 */
	public List<Studente> getStudentiIscrittiAlCorso(Corso corso) {
		List<Studente> listaStudenti = new ArrayList<>();
		for(Corso c: this.getTuttiICorsi()) {
			if(c.equals(corso)) {
				listaStudenti = c.getStudentiIscritti();
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
				corso.aggiungiStudentiIscritti(studente);
				return true;
			}
		}
		return false;
	}
}
