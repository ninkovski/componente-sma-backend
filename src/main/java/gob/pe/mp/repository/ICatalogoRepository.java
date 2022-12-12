package gob.pe.mp.repository;

import gob.pe.mp.entity.CatalogoEntity;

import java.util.List;

public interface ICatalogoRepository {

    List<CatalogoEntity> listar(Integer codigoPadre, Integer codigohijo);
    List<CatalogoEntity> listar(Integer codigoPadre);
}
