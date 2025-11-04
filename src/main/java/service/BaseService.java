package service;

import model.IBaseModel;
import repository.IBaseRepository;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Year;
import java.util.List;

public class BaseService<M extends IBaseModel<M>,R extends IBaseRepository<M>> implements IBaseService<M> {
    protected final R repo;

    public BaseService(R repo){
        this.repo = repo;
    }

    protected boolean isIdNegative(int id){
        return (id < 0);
    }

    protected boolean isModelNull(M model){
        return model == null;
    }

    protected boolean isDateLegal(LocalDate date){
        return date != null && !date.isAfter(LocalDate.now());
    }

    protected LocalDate stringToDate(int day , int month , int year){
        if(month < 0 || month > 13){
            return null;
        }

        if(year > LocalDate.now().getYear()){
            return null;
        }

        if(day > 31 || day < 0){
            return null;
        }

        return LocalDate.of(year,month,day);
    }

    protected boolean isModelValidate(M model){
        if(isModelNull(model)){
            System.err.printf("[VAL_HO_%s.modelValidate()] model null !%n",getClass().getSimpleName());
            return false;
        }
        if(isIdNegative(model.getId())){
            System.err.printf("[VAL_HO_%s.modelValidate()] id degeri negatif olamaz !%n",getClass().getSimpleName());
            return false;
        }
        return true;
    }



    @Override
    public void addModel(M model) throws SQLException {
        if(!isModelValidate(model)){
            return;
        }
        repo.save(model);
    }

    @Override
    public M getModelById(int id) throws SQLException {
        if(isIdNegative(id)){
            return null;
        }
        return repo.findById(id);
    }

    @Override
    public List<M> getAllModel() throws SQLException {
        return repo.findAll();
    }

    @Override
    public void updateModel(M model) throws SQLException {
        if(!isModelValidate(model)){
            return;
        }
        repo.update(model);
    }

    @Override
    public void deleteModel(int id) throws SQLException {
        if(isIdNegative(id)){
            return;
        }
        repo.delete(id);
    }
}
