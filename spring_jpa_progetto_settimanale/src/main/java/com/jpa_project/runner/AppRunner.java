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
//		edificioService.creaEdificio();
		Edificio edificioLetto = edificioService.cercaEdificioById(1l);
		Edificio ultimoEdificio = edificioService.trovaUltimoEdificio();
//		edificioService.eliminaEdificio(edificioLetto); //prova elimina
//		System.out.println(edificioLetto);
//		ultimoEdificio.setNome("Prova update!");
//		edificioService.updateEdificio(edificioLetto);
		
		
		// POSTAZIONI				
//		postazioneService.creaPostazione("un'altra postazione", edificioLetto, Tipo.PRIVATO);
		
//		Postazione postazioneLetta = postazioneService.getPostazioneById(1l);
//		System.out.println(postazioneLetta);
		
		
		// UTENTI		
//		utenteService.creaUtente();		
		Utente utenteLetto = utenteService.getUtenteById(1l);
		
	//	System.out.println(utenteLetto);
		
		
		// PRENOTAZIONI
//			prenotazioneService.creaPrenotazione(postazioneLetta, LocalDate.now().plusMonths(5), utenteLetto);
		
//		List<Prenotazione> prenot = prenotazioneService.ottieniPrenotazioni(LocalDate.of(2023, 04, 20), postazioneLetta);
//		System.out.println(prenot);
			
		
			// CERCA POSTAZIONI PER TIPO E CITTA'
//			List <Postazione> listaPostazioniCercate = postazioneService.cercaPostazioniByTipoAndCitta(Tipo.OPENSPACE, "Piras umbro");
//			listaPostazioniCercate.forEach(p -> System.out.println(p));
//			System.out.println(listaPostazioniCercate.size());
		
		
		
	}

}
