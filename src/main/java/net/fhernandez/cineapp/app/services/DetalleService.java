package net.fhernandez.cineapp.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.fhernandez.cineapp.app.Dao.DetalleDao;
import net.fhernandez.cineapp.app.model.Detalle;
import net.fhernandez.cineapp.app.repository.DetalleRepository;

@Service
public class DetalleService implements DetalleDao {
	
	@Autowired
	private DetalleRepository detalleRepository;
	
	@Override
	public void save(Detalle detalle) {
		detalleRepository.save(detalle);
	}
	
	@Override
	public List<Detalle> getList (){
		List<Detalle> detalleList = detalleRepository.findAll();
		return detalleList;
	}
	
	@Override
	public Detalle getById (int idDetalle) {
		Optional<Detalle> detalle = detalleRepository.findById(idDetalle);
		return detalle.get();
	}

	@Override
	public void delete(int idDetalle) {
		// TODO Auto-generated method stub
		detalleRepository.deleteById(idDetalle);
		
	}

}
