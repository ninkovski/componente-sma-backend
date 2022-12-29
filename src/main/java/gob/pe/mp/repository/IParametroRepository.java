package gob.pe.mp.repository;

import gob.pe.mp.entity.ParametroEntity;

import java.util.List;

public interface IParametroRepository {

    List<ParametroEntity> listar(Integer codigoPadre);
    List<ParametroEntity> listar();
    void insertar(String descripcion, Integer valor, String usuarioRegistro);
}
