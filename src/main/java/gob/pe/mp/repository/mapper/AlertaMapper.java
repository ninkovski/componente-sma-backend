package gob.pe.mp.repository.mapper;

import gob.pe.mp.entity.AccionAlertaEntity;
import gob.pe.mp.entity.AlertaEntity;
import gob.pe.mp.entity.ProteccionAlertaEntity;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.StatementType;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Mapper
@Component
public interface AlertaMapper {

    @Insert(value = "INSERT INTO \"TB_ALERTA\"" +
            "(\"ID_FISCAL\",\"ID_DELITO\",\"DE_DIS_JUDI\",\"DE_DEPE_MPUB\"," +
            "\"DE_DEPE_POLI\",\"CASO\",\"FEC_ING_CASO\",\"NOMBRES_AGRAVIADO\",\"NOMBRES_IMPUTADO\"," +
            "\"TI_SEXO\",\"ID_ESTADO\") " +
            "VALUES (#{idFiscal},#{idDelito},#{juridiccion},#{depMipub},#{depPol},#{caso}," +
            "#{fecIngCaso},#{nombreAgraviado},#{nombreImputado},#{sexo},#{idEstado})")
    void insertar(@Param("idFiscal") Integer idFiscal, @Param("idDelito") Integer idDelito, @Param("juridiccion") String juridiccion,
                  @Param("depMipub") String depMipub, @Param("depPol") String depPol, @Param("caso") String caso,
                  @Param("fecIngCaso") Date fecIngCaso, @Param("nombreAgraviado") String nombreAgraviado,
                  @Param("nombreImputado") String nombreImputado, @Param("sexo") String sexo, @Param("idEstado") Integer idEstado);

    @Select(value = "SELECT * FROM \"TB_ALERTA\"")
    @Options(statementType = StatementType.CALLABLE)
    List<AlertaEntity> listar();

    @Select(value = "SELECT count(\"ID_ALERTA\") FROM \"TB_ALERTA\"")
    @Options(statementType = StatementType.CALLABLE)
    Integer contar();

    @Select(value = "SELECT * FROM \"TB_ALERTA\" WHERE CAST (\"FEC_ING_CASO\" AS DATE) BETWEEN #{fechaInicio} AND #{fechaFin}")
    @Options(statementType = StatementType.CALLABLE)
    List<AlertaEntity> listarByFechas(@Param("fechaInicio") Date fechaInicio, @Param("fechaFin") Date fechaFin);

    @Select(value = "SELECT count(\"ID_ALERTA\") from \"TB_ALERTA\" WHERE CAST (\"FEC_ING_CASO\" AS DATE) BETWEEN #{fechaInicio} AND #{fechaFin}")
    @Options(statementType = StatementType.CALLABLE)
    Integer contarByFechas(@Param("fechaInicio") Date fechaInicio, @Param("fechaFin") Date fechaFin);

    @Insert(value = "INSERT INTO \"TB_ACCION_ALERTA\" (\"DESCRIPCION\") VALUES (#{descripcion})")
    void insertarAccionAlerta(@Param("descripcion") String descripcion);

    @Select(value = "SELECT * FROM \"TB_ACCION_ALERTA\"")
    @Options(statementType = StatementType.CALLABLE)
    List<AccionAlertaEntity> listarAccionAlerta();

    @Insert(value = "INSERT INTO \"TB_MEDIDA_PROTECCION\" (\"DESCRIPCION\") VALUES (#{descripcion})")
    void insertarProteccionAlerta(@Param("descripcion") String descripcion);

    @Select(value = "SELECT * FROM \"TB_MEDIDA_PROTECCION\"")
    @Options(statementType = StatementType.CALLABLE)
    List<ProteccionAlertaEntity> listarProteccionAlerta();

    @Select(value = "SELECT tbp.*" +
            "FROM \"TB_MEDIDA_PROTECCION\" tbp " +
            "INNER JOIN \"TB_ALERTA_ACION_PROTECCION\" taap on tbp.\"ID_MED_PROTECCION\"=taap.\"ID_MED_PROTECCION\" " +
            "INNER JOIN \"TB_ALERTA\" ta on ta.\"ID_ALERTA\"=taap.\"ID_ALERTA\" where CAST (ta.\"FEC_ING_CASO\" AS DATE) BETWEEN #{fechaInicio} AND #{fechaFin}")
    @Options(statementType = StatementType.CALLABLE)
    List<ProteccionAlertaEntity> listarProteccionAlertaByFechas(@Param("fechaInicio") Date fechaInicio, @Param("fechaFin") Date fechaFin);

    @Select(value = "SELECT count(tbp.\"ID_MED_PROTECCION\") " +
            "FROM \"TB_MEDIDA_PROTECCION\" tbp " +
            "INNER JOIN \"TB_ALERTA_ACION_PROTECCION\" taap on tbp.\"ID_MED_PROTECCION\"=taap.\"ID_MED_PROTECCION\" " +
            "INNER JOIN \"TB_ALERTA\" ta on ta.\"ID_ALERTA\"=taap.\"ID_ALERTA\" where CAST (ta.\"FEC_ING_CASO\" AS DATE) BETWEEN #{fechaInicio} AND #{fechaFin}")
    @Options(statementType = StatementType.CALLABLE)
    Integer contarProteccionAlertaByFechas(@Param("fechaInicio") Date fechaInicio, @Param("fechaFin") Date fechaFin);

    @Insert(value = "INSERT INTO \"TB_DENUNCIA_ALERTA\"" +
            "(\"ID_DENUNCIA_ALERTA\",\"ID_ALERTA\",\"FEC_REGISTRO_NUEVO\",\"USUARIO_AUDT_NUEVO\") " +
            "VALUES (#{idDenuncia},#{idAlerta},#{fechaRegistro},#{usuarioRegistro})")
    void insertarDenunciaAlerta(@Param("idDenuncia") Integer idDenuncia, @Param("idAlerta") Integer idAlerta,
                                @Param("fechaRegistro") Date fechaRegistro, @Param("usuarioRegistro") String usuarioRegistro);
}
