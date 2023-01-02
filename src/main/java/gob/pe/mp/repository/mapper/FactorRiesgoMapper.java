package gob.pe.mp.repository.mapper;

import gob.pe.mp.entity.FactorRiesgoEntity;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.StatementType;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Mapper
@Component
public interface FactorRiesgoMapper {

    @Insert(value = "INSERT INTO \"TB_FACT_RIESGO_DETALLE\" " +
            "(\"FACT_RIESGO\",\"ID_TB_FICHA_RECA\",\"DETALLE\",\"FEC_REGISTRO_NUEVO\",\"USUARIO_AUDT_NUEVO\") " +
            "VALUES (#{factorRiesgo},#{idFichaReca},#{detalle},#{fechaRegistro},#{usuarioRegistro})")
    void insertar(@Param("factorRiesgo") Integer factorRiesgo, @Param("idFichaReca") Integer idFichaReca,
                  @Param("detalle") String detalle, @Param("fechaRegistro") Date fechaRegistro,
                  @Param("usuarioRegistro") String usuarioRegistro);

    @Select(value = "SELECT " + "\"ID_FACT_RIESGO_DETALLE\",\"FACT_RIESGO\",\"ID_TB_FICHA_RECA\",\"DETALLE\" " +
            "FROM \"TB_FACT_RIESGO_DETALLE\" WHERE \"ID_TB_FICHA_RECA\"=#{codigoFichaReca}")
    @Options(statementType = StatementType.CALLABLE)
    List<FactorRiesgoEntity> listarPorCodigoReca(@Param("codigoFichaReca") Integer codigoFichaReca);

    @Delete(value = "DELETE FROM \"TB_FACT_RIESGO_DETALLE\" " +
            "WHERE \"ID_TB_FICHA_RECA\"=#{codigoFichaReca}")
    void eliminarPorFichaReca(@Param("codigoFichaReca") Integer codigoFichaReca);
}
