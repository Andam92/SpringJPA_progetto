package com.jpa_project.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import com.jpa_project.configuration.PrenotazioneConfiguration;
import com.jpa_project.configuration.UtenteConfiguration;
import com.jpa_project.model.Postazione;
import com.jpa_project.model.Prenotazione;
import com.jpa_project.model.Utente;
import com.jpa_project.repository.PrenotazioneRepository;

@Service
public class PrenotazioneService {
	
	@Autowired PrenotazioneRepository repo;
	
	public void creaPrenotazione(Postazione postazione, LocalDate data, Utente u) {
		
		List<Prenotazione> listaPrenotazioni = ottieniPrenotazioni(data, postazione);
		List<Prenotazione> listaPrenotazioniPerData = cercaPrenotazioniUtenteData(u, data);
		
		if(listaPrenotazioni.size() == 0 && listaPrenotazioniPerData.size() == 0) {
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(PrenotazioneConfiguration.class);
		
		Prenotazione p = (Prenotazione) appContext.getBean("nuovaPrenotazione");
		p.setDataPrenotazione(data);
		p.setPostazionePrenotata(postazione);
		p.setUtente(u);
		p.setScadenzaPrenotazione(data.plusDays(1)); 
		salvaPrenotazione(p);
		System.out.println("La postazione nell' " + postazione.getEdificio().getNome() + " è stata prenotata con successo!");
		} else if(listaPrenotazioni.size() > 0 && listaPrenotazioniPerData.size() == 0) {
			System.out.println("Risulta già una prenotazione per la data " + data);
		} else {
			System.out.println("L'utente " + u.getNome() + u.getCognome() + " ha già prenotato una postazione per quella data");
		}
	}
		
	public void salvaPrenotazione(Prenotazione p) {
		repo.save(p);
	}
	
	
	public List<Prenotazione> getPrenotazioneById (Long id) {
		return (List<Prenotazione>) repo.findById(id).get();
	}
	
	public List<Prenotazione> ottieniPrenotazioni(LocalDate data, Postazione postazione){
		return repo.checkPrenotazione(data, postazione);
	}
	
	public List<Prenotazione> cercaPrenotazioniUtenteData(Utente u, LocalDate data){
		return repo.checkPrenotazioniUtenteData(u, data);
	}
}
