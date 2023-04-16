package com.jpa_project.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jpa_project.model.Postazione;
import com.jpa_project.model.Prenotazione;
import com.jpa_project.model.Utente;

@Repository
public interface PrenotazioneRepository extends CrudRepository<Prenotazione, Long>{

	@Query(value = "SELECT p FROM Prenotazione p WHERE :data BETWEEN p.dataPrenotazione AND p.scadenzaPrenotazione"
            + " AND p.postazionePrenotata = :postazione")
    List<Prenotazione> checkPrenotazione(LocalDate data, Postazione postazione);
	
	@Query(value = "SELECT p FROM Prenotazione p WHERE p.utente = :u AND p.dataPrenotazione = :data")
	List<Prenotazione> checkPrenotazioniUtenteData(Utente u, LocalDate data);
	
}