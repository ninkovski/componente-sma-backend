package gob.pe.mp.repository.impl;

import gob.pe.mp.entity.ParametroEntity;
import gob.pe.mp.repository.IParametroRepository;
import gob.pe.mp.repository.mapper.ParametroMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class ParametroRepository implements IParametroRepository {

    @Autowired
    private ParametroMapper parametroMapper;

    @Override
    public List<ParametroEntity> listar(Integer codigo) {
        return parametroMapper.listarPorCod(codigo);
    }

    @Override
    public List<ParametroEntity> listar() {
        return parametroMapper.listar();
    }

    @Override
    public void actualizar(Integer id, Integer valor, String usuarioModificacion, Date fechaModificacion) {
        parametroMapper.insertar(id, valor, usuarioModificacion, fechaModificacion);
    }
}
