package com.jpa_project.service;

import java.time.LocalDate;

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
		
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(PrenotazioneConfiguration.class);
		
		Prenotazione p = (Prenotazione) appContext.getBean("nuovaPrenotazione");
		p.setDataPrenotazione(data);
		p.setPostazionePrenotata(postazione);
		p.setUtente(u);
		salvaPrenotazione(p);
		
	}
		
	public void salvaPrenotazione(Prenotazione p) {
		repo.save(p);
	}
}
