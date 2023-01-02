package gob.pe.mp.repository;

import gob.pe.mp.entity.FactorRiesgoEntity;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface IFactorRiesgoRepository {

    void insertar(Integer factorRiesgo, Integer idFichaReca, String detalle, Date fechaRegistro, String usuarioRegistro);
    List<FactorRiesgoEntity> listar(Integer codigoFichaReca);
    void eliminarPorFichaReca(@Param("codigo") Integer codigoFichaReca);
}
