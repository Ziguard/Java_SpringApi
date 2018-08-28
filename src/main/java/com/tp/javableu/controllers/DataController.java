package com.tp.javableu.controllers;

import com.tp.javableu.model.Data;
import com.tp.javableu.services.Interface.IDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class DataController {

    @Autowired
    private IDataService dataService;

    @RequestMapping(value = "/data/{id}", method = GET)
    @ResponseBody
    private Data getServeur(@PathVariable(value="id")Integer dataId)
    {
        return dataService.getData(dataId);
    }

    @RequestMapping(value = "/dataBteween",method = GET)
    @ResponseBody
    private List<Data> getDataBetween(@PathVariable(value="id") Integer dataId , @PathVariable(value="secondId") Integer dataSecondId)
    {
        return dataService.getDataBetween(dataId,dataSecondId);
    }
}
