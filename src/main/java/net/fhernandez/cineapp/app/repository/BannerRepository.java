package net.fhernandez.cineapp.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.fhernandez.cineapp.app.model.Banner;

@Repository
public interface BannerRepository extends JpaRepository<Banner, Integer> {
	
	List<Banner> findByEstatus(Boolean estatus);
}
