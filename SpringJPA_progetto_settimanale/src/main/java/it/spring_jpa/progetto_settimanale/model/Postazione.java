package it.spring_jpa.progetto_settimanale.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "postazioni")
public class Postazione {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String descrizione;
	private Tipo tipo;
	private Integer occupantiMax;
	@OneToOne
	private Edificio edificio;
	@ManyToOne
	private Utente utentePrenotato;

	// Costruttore custom
	public Postazione(String descrizione, Tipo tipo, Edificio edificio) {
		super();
		this.descrizione = descrizione;
		this.tipo = tipo;
		this.edificio = edificio;
	}

	

}
