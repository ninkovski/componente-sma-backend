package gob.pe.mp.repository.impl;

import gob.pe.mp.entity.CatalogoEntity;
import gob.pe.mp.repository.ICatalogoRepository;
import gob.pe.mp.repository.mapper.CatalogoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CatalogoRepository implements ICatalogoRepository {

    @Autowired
    private CatalogoMapper catalogoMapper;

    @Override
    public List<CatalogoEntity> listar(Integer codigoPadre, Integer codigohijo) {
        return catalogoMapper.listarPorCodPadreHijo(codigoPadre, codigohijo);
    }

    @Override
    public List<CatalogoEntity> listar(Integer codigoPadre) {
        return catalogoMapper.listarPorCodPadre(codigoPadre);
    }
}
