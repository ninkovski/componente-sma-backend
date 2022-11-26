package gob.pe.mp.repository;

import gob.pe.mp.entity.AccionAlertaEntity;
import gob.pe.mp.entity.AlertaEntity;
import gob.pe.mp.entity.ProteccionAlertaEntity;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface IAlertaRepository {

    void insertar(Integer idFiscal, Integer idDelito, String disJuridiccion, String depeMpub,
                  String depePol, String caso, Date fechIngcaso, String nombresAgraviado,
                  String nombreImputado, String sexo, Integer idEstado);
    List<AlertaEntity> listar();
    Integer contar();
    List<AlertaEntity> listarByFechas(Date fechaInicio, Date fechaFin);
    Integer contarByFechas(Date fechaInicio, Date fechaFin);

    void insertarAccionAlerta(String descripcion);
    List<AccionAlertaEntity> listarAccionAlerta();

    void insertarProteccionAlerta(String descripcion);
    List<ProteccionAlertaEntity> listarProteccionAlerta();
    List<ProteccionAlertaEntity> listarProteccionAlertaByFechas(Date fechaInicio, Date fechaFin);
    Integer contarProteccionAlertaByFechas(Date fechaInicio, Date fechaFin);

    void insertarAlertaAccionMedidaProteccion(Integer idAlerta, Integer idAccion, String detalleAccion, Integer idMedidaProteccion,
                                              String detalleMedidaProteccion, Date fecRegistro, String usuarioRegistro);

    void insertarDenunciaAlerta(Integer idDenuncia, Integer idAlerta, Date fechaRegistro, String usuarioRegistro);
}
