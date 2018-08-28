package com.tp.javableu.services.Interface;

import com.tp.javableu.model.Data;

import java.util.List;

public interface IDataService {

    Data getData(Integer idData);

    List<Data> getDataBetween(Integer dataId, Integer dataSecondId);

    List<Data> getDataByContenu(Integer contenu);
}
