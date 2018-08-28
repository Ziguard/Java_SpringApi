package com.tp.javableu.repositories;

import com.tp.javableu.model.Data;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DataRepository extends CrudRepository<Data,Integer> {

    @Query("select d from Data d where d.id between :dataId and :dataSecondId")
    List<Data> dataBetween(@Param("dataId") Integer dataId ,@Param("dataSecondId") Integer dataSecondId);

    List<Data> findByContenu(Integer contenuId);

/*    List<Data> findByIdBetweenAAndContenuLike(int dataId, int dataSecondId,String param);*/
}
