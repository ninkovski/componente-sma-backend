package gob.pe.mp.repository;

import gob.pe.mp.entity.AccionAlertaEntity;
import gob.pe.mp.entity.AlertaEntity;
import gob.pe.mp.entity.ProteccionAlertaEntity;

import java.util.Date;
import java.util.List;

public interface IAlertaRepository {

    void insertar(Integer idFiscal, Integer idDelito, String disJuridiccion, String depeMpub,
                  String depePol, String caso, Date fechIngcaso, String nombresAgraviado,
                  String nombreImputado, String sexo, Integer idEstado, Integer idFichaReca, Date fecRegistro);
    List<AlertaEntity> listar();
    Integer contar();
    List<AlertaEntity> listarByFechas(Date fechaInicio, Date fechaFin);
    Integer contarByFechas(Date fechaInicio, Date fechaFin);

    void insertarAccionAlerta(String descripcion);
    List<AccionAlertaEntity> listarAccionAlerta();

    void insertarProteccionAlerta(String descripcion);
    List<ProteccionAlertaEntity> listarProteccionAlerta();
    Integer contarProteccionAlerta();
    List<ProteccionAlertaEntity> listarProteccionAlertaByFechas(Date fechaInicio, Date fechaFin);
    Integer contarProteccionAlertaByFechas(Date fechaInicio, Date fechaFin);

    void insertarAlertaAccion(Integer idAlerta, Integer idAccion, Date fecRegistro, String usuarioRegistro);
    void insertarAlertaMedidaProteccion(Integer idAlerta, Integer idMedidaProteccion, Date fecRegistro, String usuarioRegistro);

    void insertarDenunciaAlerta(Integer idDenuncia, Integer idAlerta, Date fechaRegistro, String usuarioRegistro);
}
