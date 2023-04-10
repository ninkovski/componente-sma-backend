package gob.pe.mp.repository.impl;

import gob.pe.mp.entity.AccionAlertaEntity;
import gob.pe.mp.entity.AlertaEntity;
import gob.pe.mp.entity.ProteccionAlertaEntity;
import gob.pe.mp.repository.IAlertaRepository;
import gob.pe.mp.repository.mapper.AlertaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class AlertaRepository implements IAlertaRepository {

    @Autowired
    private AlertaMapper alertaMapper;

    @Override
    public void insertar(Integer idFiscal, Integer idDelito, String disJuridiccion, String depeMpub,
                         String depePol, String caso, Date fechIngcaso, String nombresAgraviado,
                         String nombreImputado, String sexo, Integer idEstado, Integer idFichaReca, Date fecRegistro) {
        alertaMapper.insertar(idFiscal, idDelito, disJuridiccion, depeMpub, depePol, caso, fechIngcaso, nombresAgraviado,
                nombreImputado, sexo, idEstado, idFichaReca, fecRegistro);
    }

    @Override
    public List<AlertaEntity> listar() {
        return alertaMapper.listar();
    }

    @Override
    public Integer contar() {
        return alertaMapper.contar();
    }

    @Override
    public List<AlertaEntity> listarByFechas(Date fechaInicio, Date fechaFin) {
        return alertaMapper.listarByFechas(fechaInicio, fechaFin);
    }

    @Override
    public Integer contarByFechas(Date fechaInicio, Date fechaFin) {
        return alertaMapper.contarByFechas(fechaInicio, fechaFin);
    }

    @Override
    public void actualizar(Integer idAlerta, Integer idFichaReca) {
        alertaMapper.actualizar(idAlerta, idFichaReca);
    }

    @Override
    public void insertarAccionAlerta(String descripcion) {
        alertaMapper.insertarAccionAlerta(descripcion);
    }

    @Override
    public List<AccionAlertaEntity> listarAccionAlerta() {
        return alertaMapper.listarAccionAlerta();
    }

    @Override
    public void insertarProteccionAlerta(String descripcion) {
        alertaMapper.insertarProteccionAlerta(descripcion);
    }

    @Override
    public List<ProteccionAlertaEntity> listarProteccionAlerta() {
        return alertaMapper.listarProteccionAlerta();
    }

    @Override
    public Integer contarProteccionAlerta() {
        return alertaMapper.contarProteccionAlerta();
    }

    @Override
    public List<ProteccionAlertaEntity> listarProteccionAlertaById(Integer idAlerta) {
        return alertaMapper.listarProteccionAlertaById(idAlerta);
    }

    @Override
    public List<AccionAlertaEntity> listarAcccionAlertaById(Integer idAlerta) {
        return alertaMapper.listarAccionAlertaById(idAlerta);
    }

    @Override
    public Integer contarProteccionAlertaByFechas(Date fechaInicio, Date fechaFin) {
        return alertaMapper.contarProteccionAlertaByFechas(fechaInicio, fechaFin);
    }

    @Override
    public List<ProteccionAlertaEntity> listarProteccionAlertaByFechas(Date fechaInicio, Date fechaFin) {
        return alertaMapper.listarProteccionAlertaByFechas(fechaInicio, fechaFin);
    }

    @Override
    public void insertarAlertaAccion(Integer idAlerta, Integer idAccion, Date fecRegistro, String usuarioRegistro) {
        alertaMapper.insertarAlertaAccion(idAlerta, idAccion, fecRegistro, usuarioRegistro);
    }

    @Override
    public void insertarAlertaMedidaProteccion(Integer idAlerta, Integer idMedidaProteccion, Date fecRegistro, String usuarioRegistro) {
        alertaMapper.insertarAlertaMedidaProteccion(idAlerta, idMedidaProteccion, fecRegistro, usuarioRegistro);
    }

    @Override
    public void insertarDenunciaAlerta(Integer idDenuncia, Integer idAlerta, Date fechRegistro, String usuarioRegistro) {
        alertaMapper.insertarDenunciaAlerta(idDenuncia, idAlerta, fechRegistro, usuarioRegistro);
    }

    @Override
    public void actualizarEstado(Integer idAlerta, Integer idEstando) {
        alertaMapper.actualizarEstado(idAlerta, idEstando);
    }
}
