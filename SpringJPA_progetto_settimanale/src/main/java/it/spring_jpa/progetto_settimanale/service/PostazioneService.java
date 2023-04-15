package it.spring_jpa.progetto_settimanale.service;

import java.util.List;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;

import it.spring_jpa.progetto_settimanale.model.Postazione;
import it.spring_jpa.progetto_settimanale.repository.PostazioneDaoRepository;

public class PostazioneService {
	
	@Autowired private PostazioneDaoRepository repo;
	@Autowired private ObjectProvider<Postazione> creaPostazioneProvider;
	
	public void creaPostazioneDb() {
		
	}
	
	public void inserisciPostazione(Postazione p) {
		repo.save(p);
	}
	
	public void eliminaPostazione(Postazione p) {
		repo.delete(p);
	}
	
	public Postazione cercaPostazione(Long id) {
		return repo.findById(id).get();
	}
	
	public void aggiornaPostazione(Postazione p) {
		repo.save(p);
	}
	
	public List<Postazione> cercaTutte(){
		return (List<Postazione>) repo.findAll();
	}
}
