package gob.pe.mp.repository;

import gob.pe.mp.entity.DepartamentoEntity;
import gob.pe.mp.entity.DistritoEntity;
import gob.pe.mp.entity.ProvinciaEntity;

import java.util.List;

public interface IUbigeoRepository {

    List<DepartamentoEntity> listarDepartamento();
    List<ProvinciaEntity> listarProvincia(String codigoDepartamento);
    List<DistritoEntity> listarDistrito(String codigoProvincia);
}
