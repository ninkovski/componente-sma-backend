package gob.pe.mp.repository.impl;

import gob.pe.mp.entity.FactorRiesgoEntity;
import gob.pe.mp.repository.IFactorRiesgoRepository;
import gob.pe.mp.repository.mapper.FactorRiesgoMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class FactorRiesgoRepository implements IFactorRiesgoRepository {

    @Autowired
    private FactorRiesgoMapper factorRiesgoMapper;

    @Override
    public void insertar(Integer factorRiesgo, Integer idFichaReca, String detalle, Date fechaRegistro, String usuarioRegistro) {
        factorRiesgoMapper.insertar(factorRiesgo, idFichaReca, detalle, fechaRegistro, usuarioRegistro);
    }

    @Override
    public List<FactorRiesgoEntity> listar(Integer codigoFichaReca) {
        return factorRiesgoMapper.listarPorCodigoReca(codigoFichaReca);
    }

    @Override
    public void eliminarPorFichaReca(@Param("codigo") Integer codigoFichaReca) {
        factorRiesgoMapper.eliminarPorFichaReca(codigoFichaReca);
    }
}
