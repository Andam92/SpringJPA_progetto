package com.jpa_project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import com.jpa_project.configuration.EdificioConfiguration;
import com.jpa_project.model.Edificio;
import com.jpa_project.repository.EdificioDaoRepository;

import jakarta.transaction.Transactional;

@Service
public class EdificioService {

	@Autowired private EdificioDaoRepository repo;
	
	
	public void creaEdificio() {
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(EdificioConfiguration.class);
		Edificio e = (Edificio) appContext.getBean("nuovoEdificio");
		inserisciEdificio(e);
		System.out.println("L'edificio " + e.getNome() + " nella città di " + e.getCitta() + " è stato creato e inserito nel DB!");
		
	}
	
	public void inserisciEdificio(Edificio e) {
		repo.save(e);
		
	}
	
	public Edificio cercaEdificioById(Long id) {
		
        Edificio e = repo.findById(id).get();
        System.out.println("L'edificio cercato è " + e.getNome());
        return e;
    }
	
	public void eliminaEdificio(Edificio e) {
		repo.delete(e);
		System.out.println("Edificio " + e.getNome() + " è stato correttamente eliminato dal DB!");
	}
	
	public void updateEdificio(Edificio e) {
		repo.save(e);
		System.out.println("Edificio " + e.getNome() + " è stato correttamente aggiornato");
	}
	
	public List<Edificio> cercaTuttiEdifici(){
		List<Edificio> lista = repo.findAll();
		System.out.println("Lista di edifici:");
		lista.forEach(e -> System.out.println(e.toString()));
		return lista;
	}
	
	public Edificio trovaUltimoEdificio() {
		List<Edificio>lista = cercaTuttiEdifici();
		Edificio ultimoEdificio = lista.get((int)lista.size() - 1);
		System.out.println("L'ultimo edificio aggiunto al DB è: " + ultimoEdificio.getNome() + ", [id: " + ultimoEdificio.getId() + "]");
		return ultimoEdificio; 
	}
}
