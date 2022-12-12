package gob.pe.mp.repository.impl;

import gob.pe.mp.entity.DepartamentoEntity;
import gob.pe.mp.entity.DistritoEntity;
import gob.pe.mp.entity.ProvinciaEntity;
import gob.pe.mp.repository.IUbigeoRepository;
import gob.pe.mp.repository.mapper.UbigeoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UbigeoRepository implements IUbigeoRepository {

    @Autowired
    private UbigeoMapper ubigeoMapper;

    @Override
    public List<DepartamentoEntity> listarDepartamento() {
        return ubigeoMapper.listarDepartamento();
    }

    @Override
    public List<ProvinciaEntity> listarProvincia(String codigoDepartamento) {
        return ubigeoMapper.listarProvincia(codigoDepartamento);
    }

    @Override
    public List<DistritoEntity> listarDistrito(String codigoProvincia) {
        return ubigeoMapper.listarDistrito(codigoProvincia);
    }
}
