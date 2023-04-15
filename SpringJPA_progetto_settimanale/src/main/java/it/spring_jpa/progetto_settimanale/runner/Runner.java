package it.spring_jpa.progetto_settimanale.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import it.spring_jpa.progetto_settimanale.model.Tipo;
import it.spring_jpa.progetto_settimanale.service.PostazioneService;

@Component
public class Runner implements ApplicationRunner{

	@Autowired PostazioneService postazioneService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
	//	Edificio e = new Edificio();
	//	Postazione p = new Postazione("Una semplice postazione per 10 persone", Tipo.SALA_RIUNIONI, e);
		
		postazioneService.inserisciPostazione(p);
	}

}
