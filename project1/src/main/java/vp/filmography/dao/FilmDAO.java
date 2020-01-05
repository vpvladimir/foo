package vp.filmography.dao;

import vp.filmography.model.Film;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


public interface FilmDAO {
	//void setSessionFactory(SessionFactory sessionFactory);
    List<Film> allFilms(int page);
    int filmsCount();
    void add(Film film);
    void delete(Film film);
    void edit(Film film);
    Film getById(int id);
}
