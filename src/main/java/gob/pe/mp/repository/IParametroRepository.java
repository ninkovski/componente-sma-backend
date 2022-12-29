package gob.pe.mp.repository;

import gob.pe.mp.entity.ParametroEntity;

import java.util.Date;
import java.util.List;

public interface IParametroRepository {

    List<ParametroEntity> listar(Integer codigoPadre);
    List<ParametroEntity> listar();
    void actualizar(Integer id, Integer valor, String usuarioModificacion, Date fechaModificacion);
}
