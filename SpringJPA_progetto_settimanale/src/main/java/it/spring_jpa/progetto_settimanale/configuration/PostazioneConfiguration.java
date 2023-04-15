package it.spring_jpa.progetto_settimanale.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import it.spring_jpa.progetto_settimanale.model.Edificio;
import it.spring_jpa.progetto_settimanale.model.Postazione;
import it.spring_jpa.progetto_settimanale.model.Tipo;

@Configuration
public class PostazioneConfiguration {
	
	@Bean
	@Scope("prototype")
	public Postazione creaPostazione(String descrizione, Tipo tipo, Integer occupantiMax, Edificio edificio) {
		 Postazione postazione = new Postazione(descrizione, tipo, edificio);
		
			switch (postazione.getTipo()) {
			case PRIVATO:
				postazione.setOccupantiMax(5); 
				break;
			case OPEN_SPACE:
				postazione.setOccupantiMax(30); 
				break;
			case SALA_RIUNIONI:
				postazione.setOccupantiMax(12);
				break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + tipo);
			}
			return null;	
	}
}
