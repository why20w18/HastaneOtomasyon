package repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface IBaseRepository<T> {

    public abstract void save(T clazz) throws SQLException;
    public abstract T findById(int id) throws SQLException;
    public abstract List<T> findAll() throws SQLException;
    public abstract void update(T clazz) throws SQLException;
    public abstract void delete(int id) throws SQLException;
    public abstract T toMapping(ResultSet resultSet) throws SQLException;
}
