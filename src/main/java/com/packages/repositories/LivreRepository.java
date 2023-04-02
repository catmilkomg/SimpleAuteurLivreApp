package com.packages.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.packages.entities.Livre;

public interface LivreRepository extends JpaRepository<Livre, Integer> {

	Livre findById(int id);

	List<Livre> findByDateEditionBetween(Date startDate, Date endDate);
}
