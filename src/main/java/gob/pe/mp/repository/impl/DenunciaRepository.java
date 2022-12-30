package gob.pe.mp.repository.impl;

import gob.pe.mp.entity.DenunciaEntity;
import gob.pe.mp.repository.IDenunciaRepository;
import gob.pe.mp.repository.mapper.DenunciaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DenunciaRepository implements IDenunciaRepository {

    @Autowired
    private DenunciaMapper denunciaMapper;

    @Override
    public List<DenunciaEntity> listar(Integer idAlerta) {
        return denunciaMapper.listar(idAlerta);
    }
}
