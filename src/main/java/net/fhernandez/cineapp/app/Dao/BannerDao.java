package net.fhernandez.cineapp.app.Dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import net.fhernandez.cineapp.app.model.Banner;

public interface BannerDao {
	 void save(Banner banner);
	 List<Banner> getList();
	 void delete(int idBanner);
	 Banner getById(int idBanner);
	 List<Banner> getListBannerEstatus(Boolean estatus);
	 Page<Banner> bannerListPaginado(Pageable page);
		
}
