package gob.pe.mp.repository.impl;

import gob.pe.mp.entity.PaisEntity;
import gob.pe.mp.repository.IPaisRepository;
import gob.pe.mp.repository.mapper.PaisMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PaisRepository implements IPaisRepository {

    @Autowired
    private PaisMapper paisMapper;

    @Override
    public List<PaisEntity> listar(Integer codigo) {
        return paisMapper.listarPorCod(codigo);
    }

    @Override
    public List<PaisEntity> listar() {
        return paisMapper.listar();
    }
}
