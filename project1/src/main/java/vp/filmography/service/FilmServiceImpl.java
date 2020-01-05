package vp.filmography.service;

import vp.filmography.config.HibernateConfig;
import vp.filmography.dao.FilmDAO;
import vp.filmography.dao.FilmDAOImpl;
import vp.filmography.model.Film;

import java.sql.Connection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.naming.NamingException;
import javax.naming.Reference;
import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceUnitUtil;
import javax.persistence.Query;
import javax.persistence.SynchronizationType;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.metamodel.Metamodel;

import org.hibernate.Cache;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionBuilder;
import org.hibernate.SessionFactory;
import org.hibernate.StatelessSession;
import org.hibernate.StatelessSessionBuilder;
import org.hibernate.TypeHelper;
import org.hibernate.boot.spi.SessionFactoryOptions;
import org.hibernate.engine.spi.FilterDefinition;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.metadata.CollectionMetadata;
import org.hibernate.stat.Statistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FilmServiceImpl implements FilmService {
	//vp_@Autowired
	//@Autowired
    //private FilmDAO filmDAO = new FilmDAOImpl();
	
	private FilmDAO filmDAO;

	@Autowired
    public void setFilmDAO(FilmDAO filmDAO) {
		this.filmDAO = filmDAO;
	}

	
	//@Override
    @Transactional
    public List<Film> allFilms(int page) {
        return filmDAO.allFilms(page);
    }

    //@Override
    @Transactional
    public void add(Film film) {
        filmDAO.add(film);
    }

    //@Override
    @Transactional
    public void delete(Film film) {
        filmDAO.delete(film);
    }

    //@Override
    @Transactional
    public void edit(Film film) {
        filmDAO.edit(film);
    }

    //@Override
    @Transactional
    public Film getById(int id) {
        return filmDAO.getById(id);
    }


	@Override
	@Transactional
	public int filmsCount() {
		return filmDAO.filmsCount();
	}
}