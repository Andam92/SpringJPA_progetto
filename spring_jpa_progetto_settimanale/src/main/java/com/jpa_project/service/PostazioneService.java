package com.jpa_project.service;

import java.util.List;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import com.jpa_project.configuration.PostazioneConfiguration;
import com.jpa_project.model.Edificio;
import com.jpa_project.model.Postazione;
import com.jpa_project.model.Tipo;
import com.jpa_project.repository.PostazioneDaoRepository;


@Service
public class PostazioneService {

	@Autowired private PostazioneDaoRepository repo;
	
	public void creaPostazione(String desc, Edificio e, Tipo t) {

	 AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(PostazioneConfiguration.class);
	 Postazione p = (Postazione) appContext.getBean("creaPostazione");

		p.setDescrizione(desc);
		p.setEdificio(e);
		p.setTipo(t);
		p.creaOccupanti(p);
		inserisciPostazione(p);
		
		System.out.println("La postazione " + p.getDescrizione() + " (" + p.getTipo() + ", " + p.getEdificio().getNome() + ") " + "è stata inserita nel DB");

	}
	
	public void inserisciPostazione(Postazione p) {
		repo.save(p);
	}
	
	public void rimuoviPostazione(Postazione p) {
		repo.delete(p);
	}
	
	public Postazione getPostazioneById(Long id) {
		Postazione p = repo.findById(id).get();
		System.out.println("La postazione cercata è nella città " + p.getEdificio().getCitta() + ", di tipo " + p.getTipo());
		return p;

	}
	
	public Postazione updatePostazione(Postazione p) {
		Postazione updatedP = repo.save(p);
		System.out.println("la postazione " + updatedP.getId() + " è stata correttamente aggiornata");
		return updatedP;
	}
	
	public void eliminaPostazione(Postazione p) {
		repo.delete(p);
		System.out.println("La postazione " + p.toString() + " è stata eliminata dal DB");
	}
	
	public List<Postazione> cercaTuttePostazioni(){
		 List<Postazione> lista = repo.findAll();
		 System.out.println("Lista di postazioni:");
			lista.forEach(p -> System.out.println(p.toString()));

		 return lista;
	}
	
	public List<Postazione> cercaPostazioniByTipoAndCitta(Tipo tipo, String citta, Postazione p){
		List<Postazione> lista = repo.cercaPostazioniByTipoAndCitta(tipo, citta);
		System.out.println("Lista di postazioni di tipo " + p.getTipo() + "nella città " + citta);
		lista.forEach(postazione -> System.out.println(postazione.toString()));
		return lista;
	}
}
