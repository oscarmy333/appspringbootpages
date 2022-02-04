package com.myoscorp.modelo;

import java.time.Instant;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "planta")
@Getter
@Setter
public class Planta {
	public Planta() {
		this.createdAt = Instant.now();
	}
	
	public Planta(String nombre, String scNombre, String familia) {
		this.nombre =nombre;
		this.scNombre = scNombre;
		this.familia = familia;
		this.createdAt = Instant.now();
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@NaturalId()
	@Column(name ="nombre")
	private String nombre;
	
	@NaturalId()
	@Column(name = "scNombre")
	private String scNombre;
	
	@Column(name = "familia")
	private String familia;
	
	@Column(name = "createdAt")
	private Instant createdAt = Instant.now();
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
        if (!(obj instanceof Planta)) return false;
        Planta planta = (Planta) obj;
        return Objects.equals(id, planta.id) && Objects.equals(nombre, planta.nombre) && Objects.equals(scNombre,
                planta.scNombre) && Objects.equals(familia, planta.familia) && Objects.equals(createdAt,
                planta.createdAt);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id, nombre, scNombre, familia, createdAt);
	}
	
	@Override
	public String toString() {
		return "Planta{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", scNombre='" + scNombre + '\'' +
                ", familia='" + familia + '\'' +
                ", createdAt=" + createdAt +
                '}';
	}
}
