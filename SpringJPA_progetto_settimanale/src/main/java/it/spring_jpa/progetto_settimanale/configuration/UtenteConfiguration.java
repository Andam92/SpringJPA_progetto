package it.spring_jpa.progetto_settimanale.configuration;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.github.javafaker.Faker;

import it.spring_jpa.progetto_settimanale.model.Utente;

@Configuration
public class UtenteConfiguration {

	@Bean
	@Scope("prototype")
	public Utente nuovoUtente(String nome, String cognome, String email) {
		Utente u = new Utente();
		Faker fake = Faker.instance(new Locale("it-IT"));
		u.setNome(fake.name().firstName());
		u.setCognome(fake.name().lastName());
		u.setEmail(u.getNome().toLowerCase() + "." + u.getCognome().toLowerCase() + "@example.it");
		
		return u;
		
	}
}
