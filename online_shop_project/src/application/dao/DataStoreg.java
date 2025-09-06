package application.dao;

import application.model.Model;

import java.util.List;

public interface DataStoreg <T extends Model> {

    T save (T entity);
    T getById(Integer id);
    List<T> getAll();
}
