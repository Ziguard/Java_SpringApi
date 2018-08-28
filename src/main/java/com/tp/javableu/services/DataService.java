package com.tp.javableu.services;

import com.tp.javableu.model.Data;
import com.tp.javableu.repositories.DataRepository;
import com.tp.javableu.services.Interface.IDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataService implements IDataService {

    @Autowired
    DataRepository dataRepository;

    @Override
    public Data getData(Integer idData) {
        return dataRepository.findOne(idData);
    }

    @Override
    public List<Data> getDataBetween(Integer dataId, Integer dataSecondId) {
        return dataRepository.dataBetween(dataId,dataSecondId);
    }

    @Override
    public List<Data> getDataByContenu(Integer contenuId) {
        return dataRepository.findByContenu(contenuId);
    }

}
