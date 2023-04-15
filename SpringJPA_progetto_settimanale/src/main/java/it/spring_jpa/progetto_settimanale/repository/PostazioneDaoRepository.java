package it.spring_jpa.progetto_settimanale.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.spring_jpa.progetto_settimanale.model.Edificio;
import it.spring_jpa.progetto_settimanale.model.Postazione;
import it.spring_jpa.progetto_settimanale.model.Tipo;

@Repository
public interface PostazioneDaoRepository extends CrudRepository<Postazione, Long>{
	
	public List<Postazione> findByTipo(Tipo tipo);
	public List<Postazione> findByEdificio(Edificio edificio);
	
}
