package org.academiadecodigo.codezillas.portfolioApp.persistence;

import org.academiadecodigo.codezillas.portfolioApp.domainModel.Model;

import java.util.ArrayList;
import java.util.List;

public abstract class GenericPersist<T extends Model> implements Persist<T> {

    protected List<T> list;
    protected Class<T> modelType;

    public GenericPersist(Class<T> modelType) {
        this.modelType = modelType;
        this.list = new ArrayList<>();
    }

    @Override
    public T find(Integer id) {

        if (id == null) {
            System.out.println("Persist find(id) parameter is null");
            return null;
        }

        T result = null;
        for (T element : list) {
            if (element.getId().equals(id)) {
                result = element;
            }
        }
        return result;
    }

    @Override
    public List<T> findAll() {
        return list;
    }

    @Override
    public Boolean saveOrUpdate(T modelObject) {
        return list.add(modelObject);
    }

    @Override
    public Boolean delete(T modelObject) {
        return list.remove(modelObject);
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
