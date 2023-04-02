package com.packages.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter(value = AccessLevel.PUBLIC)
@Setter(value = AccessLevel.PUBLIC)

@NoArgsConstructor
@AllArgsConstructor
public class Auteur extends Personne {
	@Column(unique = true)
	public String email;
	@ManyToMany(fetch = FetchType.EAGER)

	@JsonIgnore
	private List<Livre> livre;

	public void addLivre(Livre livre) {
		this.livre.add(livre);
	}
}
