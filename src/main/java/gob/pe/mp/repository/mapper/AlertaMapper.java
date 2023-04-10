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
            "\"TI_SEXO\",\"ID_ESTADO\",\"ID_TB_FICHA_RECA\",\"FEC_REGISTRO_NUEVO\") " +
            "VALUES (#{idFiscal},#{idDelito},#{juridiccion},#{depMipub},#{depPol},#{caso}," +
            "#{fecIngCaso},#{nombreAgraviado},#{nombreImputado},#{sexo},#{idEstado},#{idFichaReca},#{fecRegistro})")
    void insertar(@Param("idFiscal") Integer idFiscal, @Param("idDelito") Integer idDelito, @Param("juridiccion") String juridiccion,
                  @Param("depMipub") String depMipub, @Param("depPol") String depPol, @Param("caso") String caso,
                  @Param("fecIngCaso") Date fecIngCaso, @Param("nombreAgraviado") String nombreAgraviado,
                  @Param("nombreImputado") String nombreImputado, @Param("sexo") String sexo, @Param("idEstado") Integer idEstado,
                  @Param("idFichaReca") Integer idFichaReca, @Param("fecRegistro") Date fecRegistro);

    @Select(value = "SELECT " +
            "TA.\"ID_ALERTA\",TA.\"ID_FISCAL\",TF.\"NOMBRES\",TF.\"APELLIDO_PATERNO\",TF.\"APELLIDO_MATERNO\",TA.\"ID_DELITO\",TD.\"TX_DETALLE_DELITO\"," +
            "TA.\"DE_DIS_JUDI\",TA.\"DE_DEPE_MPUB\",TA.\"DE_DEPE_POLI\",TA.\"CASO\",TA.\"FEC_ING_CASO\",TA.\"NOMBRES_AGRAVIADO\"," +
            "TA.\"NOMBRES_IMPUTADO\",TA.\"TI_SEXO\",TA.\"ID_ESTADO\",TE.\"DESCRIPCION\",TA.\"ID_TB_FICHA_RECA\",TA.\"FEC_REGISTRO_NUEVO\" " +
            "FROM \"TB_ALERTA\" TA " +
            "INNER JOIN \"TB_FISCAL\" TF ON TA.\"ID_FISCAL\"=TF.\"ID_FISCAL\" " +
            "INNER JOIN \"TB_DELITO\" TD ON TA.\"ID_DELITO\"=TD.\"ID_DELITO\" " +
            "INNER JOIN \"TB_ESTADO\" TE ON TA.\"ID_ESTADO\"=TE.\"ID_ESTADO\" ")
    @Options(statementType = StatementType.CALLABLE)
    List<AlertaEntity> listar();

    @Select(value = "SELECT count(\"ID_ALERTA\") FROM \"TB_ALERTA\"")
    @Options(statementType = StatementType.CALLABLE)
    Integer contar();

    @Select(value = "SELECT " +
            "TA.\"ID_ALERTA\",TA.\"ID_FISCAL\",TF.\"NOMBRES\",TF.\"APELLIDO_PATERNO\",TF.\"APELLIDO_MATERNO\",TA.\"ID_DELITO\",TD.\"TX_DETALLE_DELITO\"," +
            "TA.\"DE_DIS_JUDI\",TA.\"DE_DEPE_MPUB\",TA.\"DE_DEPE_POLI\",TA.\"CASO\",TA.\"FEC_ING_CASO\",TA.\"NOMBRES_AGRAVIADO\"," +
            "TA.\"NOMBRES_IMPUTADO\",TA.\"TI_SEXO\",TA.\"ID_ESTADO\",TE.\"DESCRIPCION\",TA.\"ID_TB_FICHA_RECA\",TA.\"FEC_REGISTRO_NUEVO\" " +
            "FROM \"TB_ALERTA\" TA " +
            "INNER JOIN \"TB_FISCAL\" TF ON TA.\"ID_FISCAL\"=TF.\"ID_FISCAL\" " +
            "INNER JOIN \"TB_DELITO\" TD ON TA.\"ID_DELITO\"=TD.\"ID_DELITO\" " +
            "INNER JOIN \"TB_ESTADO\" TE ON TA.\"ID_ESTADO\"=TE.\"ID_ESTADO\" " +
            "WHERE CAST (TA.\"FEC_ING_CASO\" AS DATE) BETWEEN #{fechaInicio} AND #{fechaFin}")
    @Options(statementType = StatementType.CALLABLE)
    List<AlertaEntity> listarByFechas(@Param("fechaInicio") Date fechaInicio, @Param("fechaFin") Date fechaFin);

    @Select(value = "SELECT count(\"ID_ALERTA\") from \"TB_ALERTA\" WHERE CAST (\"FEC_ING_CASO\" AS DATE) BETWEEN #{fechaInicio} AND #{fechaFin}")
    @Options(statementType = StatementType.CALLABLE)
    Integer contarByFechas(@Param("fechaInicio") Date fechaInicio, @Param("fechaFin") Date fechaFin);

    @Insert(value = "UPDATE \"TB_ALERTA\"" +
            "set \"ID_TB_FICHA_RECA\"=#{idFichaReca} where \"ID_ALERTA\"=#{idAlerta}")
    void actualizar(@Param("idAlerta") Integer idAlerta, @Param("idFichaReca") Integer idFichaReca);

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

    @Select(value = "SELECT COUNT(\"ID_MED_PROTECCION\") FROM \"TB_MEDIDA_PROTECCION\"")
    @Options(statementType = StatementType.CALLABLE)
    Integer contarProteccionAlerta();

    @Select(value = "SELECT tbp.*" +
            "FROM \"TB_MEDIDA_PROTECCION\" tbp " +
            "INNER JOIN \"TB_ALERTA_PROTECCION\" tap on tbp.\"ID_MED_PROTECCION\"=tap.\"ID_MED_PROTECCION\" " +
            "INNER JOIN \"TB_ALERTA\" ta on ta.\"ID_ALERTA\"=tap.\"ID_ALERTA\" where CAST (ta.\"FEC_ING_CASO\" AS DATE) BETWEEN #{fechaInicio} AND #{fechaFin}")
    @Options(statementType = StatementType.CALLABLE)
    List<ProteccionAlertaEntity> listarProteccionAlertaByFechas(@Param("fechaInicio") Date fechaInicio, @Param("fechaFin") Date fechaFin);

    @Select(value = "SELECT count(tbp.\"ID_MED_PROTECCION\") " +
            "FROM \"TB_MEDIDA_PROTECCION\" tbp " +
            "INNER JOIN \"TB_ALERTA_PROTECCION\" tap on tbp.\"ID_MED_PROTECCION\"=tap.\"ID_MED_PROTECCION\" " +
            "INNER JOIN \"TB_ALERTA\" ta on ta.\"ID_ALERTA\"=tap.\"ID_ALERTA\" where CAST (ta.\"FEC_ING_CASO\" AS DATE) BETWEEN #{fechaInicio} AND #{fechaFin}")
    @Options(statementType = StatementType.CALLABLE)
    Integer contarProteccionAlertaByFechas(@Param("fechaInicio") Date fechaInicio, @Param("fechaFin") Date fechaFin);

    @Select(value = "SELECT tbp.*" +
            "FROM \"TB_MEDIDA_PROTECCION\" tbp " +
            "INNER JOIN \"TB_ALERTA_PROTECCION\" tap on tbp.\"ID_MED_PROTECCION\"=tap.\"ID_MED_PROTECCION\" " +
            "INNER JOIN \"TB_ALERTA\" ta on ta.\"ID_ALERTA\"=tap.\"ID_ALERTA\" where ta.\"ID_ALERTA\"=#{idAlerta}")
    @Options(statementType = StatementType.CALLABLE)
    List<ProteccionAlertaEntity> listarProteccionAlertaById(@Param("idAlerta") Integer idAlerta);

    @Select(value = "SELECT tbac.*" +
            "FROM \"TB_ACCION_ALERTA\" tbac " +
            "INNER JOIN \"TB_ALERTA_ACION\" taa on tbac.\"ID_ACCION_ALERTA\"=taa.\"ID_ACCION_ALERTA\" " +
            "INNER JOIN \"TB_ALERTA\" ta on ta.\"ID_ALERTA\"=taa.\"ID_ALERTA\" where ta.\"ID_ALERTA\"=#{idAlerta}")
    @Options(statementType = StatementType.CALLABLE)
    List<AccionAlertaEntity> listarAccionAlertaById(@Param("idAlerta") Integer idAlerta);

    @Insert(value = "INSERT INTO \"TB_ALERTA_ACION\"" +
            "(\"ID_ALERTA\",\"ID_ACCION_ALERTA\",\"FEC_REGISTRO_NUEVO\",\"USUARIO_AUDT_NUEVO\") " +
            "VALUES (#{idAlerta},#{idAccion},#{fecRegistro},#{usuarioRegistro})")
    void insertarAlertaAccion(@Param("idAlerta") Integer idAlerta, @Param("idAccion") Integer idAccion,
                              @Param("fecRegistro") Date fecRegistro, @Param("usuarioRegistro") String usuarioRegistro);

    @Insert(value = "INSERT INTO \"TB_ALERTA_PROTECCION\"" +
            "(\"ID_ALERTA\",\"ID_MED_PROTECCION\",\"FEC_REGISTRO_NUEVO\",\"USUARIO_AUDT_NUEVO\") " +
            "VALUES (#{idAlerta},#{idMedidaProteccion},#{fecRegistro},#{usuarioRegistro})")
    void insertarAlertaMedidaProteccion(@Param("idAlerta") Integer idAlerta, @Param("idMedidaProteccion") Integer idMedidaProteccion,
                                        @Param("fecRegistro") Date fecRegistro, @Param("usuarioRegistro") String usuarioRegistro);

    @Insert(value = "INSERT INTO \"TB_DENUNCIA_ALERTA\"" +
            "(\"ID_DENUNCIA_ALERTA\",\"ID_ALERTA\",\"FEC_REGISTRO_NUEVO\",\"USUARIO_AUDT_NUEVO\") " +
            "VALUES (#{idDenuncia},#{idAlerta},#{fechaRegistro},#{usuarioRegistro})")
    void insertarDenunciaAlerta(@Param("idDenuncia") Integer idDenuncia, @Param("idAlerta") Integer idAlerta,
                                @Param("fechaRegistro") Date fechaRegistro, @Param("usuarioRegistro") String usuarioRegistro);

    @Insert(value = "UPDATE \"TB_ALERTA\"" +
            "set \"ID_ESTADO\"=#{idEstado} where \"ID_ALERTA\"=#{idAlerta}")
    void actualizarEstado(@Param("idAlerta") Integer idAlerta, @Param("idEstado") Integer idEstado);
}
