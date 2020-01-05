package vp.filmography.dao;

import vp.filmography.model.Film;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.stereotype.Repository;

import vp.filmography.model.Film;

@Repository/*("Film")*/
public class FilmDAOImpl implements FilmDAO {
    //private static final AtomicInteger AUTO_ID = new AtomicInteger(0);
    //private static Map<Integer, Film> films = new HashMap<>();

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    

    @Override
    @SuppressWarnings("unchecked")
    public List<Film> allFilms(int page) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Film").setFirstResult(10 * (page - 1)).setMaxResults(10).list();
    }
    
    public int filmsCount() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select count(*) from Film", Number.class).getSingleResult().intValue();
    }
    
    @Override
    public void add(Film film) {
        //film.setId(AUTO_ID.getAndIncrement());
        //films.put(film.getId(), film);
        Session session = sessionFactory.getCurrentSession();
        session.persist(film);
    }

    @Override
    public void delete(Film film) {
        //films.remove(film.getId());
    	Session session = sessionFactory.getCurrentSession();
        session.delete(film);
    }

    @Override
    public void edit(Film film) {
        //films.put(film.getId(), film);
    	Session session = sessionFactory.getCurrentSession();
        session.update(film);
    }

    @Override
    public Film getById(int id) {
        //return films.get(id);
    	Session session = sessionFactory.getCurrentSession();
        return session.get(Film.class, id);
    }
}
