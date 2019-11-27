package net.fhernandez.cineapp.app.services;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.fhernandez.cineapp.app.Dao.BannerDao;
import net.fhernandez.cineapp.app.model.Banner;
import net.fhernandez.cineapp.app.repository.BannerRepository;

@Service
public class BannerService implements BannerDao {
	
	@Autowired
	private BannerRepository bannerRepository;

	@Override
	public void delete(int idBanner) {
		bannerRepository.deleteById(idBanner);
	}

	@Override
	public List<Banner> getList() {
		List<Banner> bannerList = bannerRepository.findAll();
		return bannerList;
	}

	@Override
	public Banner getById(int idBanner) {
		Optional<Banner> banner = bannerRepository.findById(idBanner);
		return banner.get();
	}

	@Override
	public List<Banner> getListBannerEstatus(Boolean estatus) {
		List<Banner> bannerActivosList = bannerRepository.findByEstatus(estatus);
		return bannerActivosList;
	}

	@Override
	public Page<Banner> bannerListPaginado(Pageable page) {
		Page<Banner> getListBannerPaginado = bannerRepository.findAll(page);
		return getListBannerPaginado;
	}

	@Override
	public void save(Banner banner) {
		if(banner.getFecha() == null) {
			banner.setFecha(new Date());
		}
		if(banner.getEstatus() == null) {
			banner.setEstatus(true);
		}
		
		if(banner.getArchivo() == null) {
			banner.setArchivo("cinema.png");
		}
		
		bannerRepository.save(banner);
	}

}
