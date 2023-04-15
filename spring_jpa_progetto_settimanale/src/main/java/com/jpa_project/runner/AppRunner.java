package com.jpa_project.runner;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import com.jpa_project.model.Edificio;
import com.jpa_project.model.Postazione;
import com.jpa_project.model.Prenotazione;
import com.jpa_project.model.Tipo;
import com.jpa_project.model.Utente;
import com.jpa_project.service.EdificioService;
import com.jpa_project.service.PostazioneService;
import com.jpa_project.service.PrenotazioneService;
import com.jpa_project.service.UtenteService;

@Component
public class AppRunner implements CommandLineRunner{
	
	@Autowired private PostazioneService postazioneService;
	@Autowired private EdificioService edificioService;
	@Autowired private AnnotationConfigApplicationContext appContext;
	@Autowired private UtenteService utenteService;
	@Autowired private PrenotazioneService prenotazioneService;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Run...");

		// EDIFICI
		Edificio e1 = (Edificio) appContext.getBean("nuovoEdificio");		
//		edificioService.inserisciEdificio(e1);
		Edificio edificioLetto = edificioService.cercaEdificio(1l);
//		edificioService.eliminaEdificio(edificioLetto);
//		System.out.println(edificioLetto);
		
		// POSTAZIONI
//		Postazione p1 = (Postazione) appContext.getBean("creaPostazione");
//		postazioneService.creaPostazione("prova postazione", edificioLetto, Tipo.OPENSPACE);
		
		Postazione postazioneLetta = postazioneService.getPostazioneById(1l);
//		System.out.println(postazioneLetta);
		
		// UTENTI
//		utenteService.creaUtente();
		
		Utente utenteLetto = utenteService.getUtenteById(1l);
		
	//	System.out.println(utenteLetto);
		
		// PRENOTAZIONI
			prenotazioneService.creaPrenotazione(postazioneLetta, LocalDate.now().plusMonths(4), utenteLetto);
		
//		List<Prenotazione> prenot = prenotazioneService.ottieniPrenotazioni(LocalDate.of(2023, 04, 20), postazioneLetta);
//		System.out.println(prenot);
			
			// CERCA POSTAZIONI
			List <Postazione> listaPostazioniCercate = postazioneService.cercaPostazioniByTipoAndCitta(Tipo.OPENSPACE, "Piras umbro");
			listaPostazioniCercate.forEach(p -> System.out.println(p));
			System.out.println(listaPostazioniCercate.size());
	}

}
