package net.fhernandez.cineapp.app.Dao;

import java.util.List;

import net.fhernandez.cineapp.app.model.Detalle;

public interface DetalleDao {
	void save(Detalle detalle);
	List<Detalle> getList ();
	Detalle getById(int idDetalle);
	void delete(int idDetalle);
}
