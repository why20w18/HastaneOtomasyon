package service;

import model.IBaseModel;
import repository.IBaseRepository;

import java.sql.SQLException;
import java.util.List;

public class BaseService<M extends IBaseModel<M>,R extends IBaseRepository<M>> implements IBaseService<M>{

    protected final R repo;

    public BaseService(R repo){
        this.repo = repo;
    }

    protected void modelValidate(M model){
        if(model == null) throw new NullPointerException("[HATA][BaseService.ModelValidate] MODEL NULL !");
        if(model.getId() < 0) throw new IllegalArgumentException("[HATA][BaseService.ModelValidate] ID NEGATIF !");
    }

    @Override
    public void addModel(M model) throws SQLException {
        modelValidate(model);
        repo.save(model);
    }

    @Override
    public M getModelById(int id) throws SQLException {
        if(id < 0) throw new IllegalArgumentException("[HATA][DEFAULT BaseService] ID NEGATIF !");
        return repo.findById(id);
    }

    @Override
    public List<M> getAllModel() throws SQLException {
        return repo.findAll();
    }

    @Override
    public void updateModel(M model) throws SQLException {
        modelValidate(model);
        repo.update(model);
    }

    @Override
    public void deleteModel(int id) throws SQLException {
        if(id < 0) throw new IllegalArgumentException("[HATA][DEFAULT BaseService] ID NEGATIF !");
        repo.delete(id);
    }
}
