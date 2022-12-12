package gob.pe.mp.repository;

import gob.pe.mp.entity.PaisEntity;

import java.util.List;

public interface IPaisRepository {

    List<PaisEntity> listar(Integer codigoPadre);
    List<PaisEntity> listar();
}
