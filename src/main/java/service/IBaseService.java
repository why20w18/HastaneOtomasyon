package service;

import java.sql.SQLException;
import java.util.List;

public interface IBaseService<T> {
    public abstract void addModel(T model) throws SQLException;
    public abstract T getModelById(int id) throws SQLException;
    public abstract List<T> getAllModel() throws SQLException;
    public abstract void updateModel(T model) throws SQLException;
    public abstract void deleteModel(int id) throws SQLException;
}
