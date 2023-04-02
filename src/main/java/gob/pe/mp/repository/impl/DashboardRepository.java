package gob.pe.mp.repository.impl;

import gob.pe.mp.dto.*;
import gob.pe.mp.repository.IDashboardRepository;
import gob.pe.mp.repository.mapper.DashboardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DashboardRepository implements IDashboardRepository {

    @Autowired
    private DashboardMapper dashboardMapper;

    @Override
    public List<ActivacionAlertaAnioDTO> activacionAlertaAnio(String anioInicio, String anioFin) {
        return dashboardMapper.contarAcumuladoAnio(anioInicio, anioFin);
    }

    @Override
    public List<ActivacionAlertaPeriodoDTO> activacionAlertaPeriodo(String fechaInicio, String fechaFin) {
        return dashboardMapper.contarAcumuladoPeriodo(fechaInicio, fechaFin);
    }

    @Override
    public List<ActivacionAlertaRankingAnioDTO> activacionAlertaRankingAnio(String anioInicio, String anioFin) {
        return dashboardMapper.activacionAlertaRankingAnio(anioInicio, anioFin);
    }

    @Override
    public List<ActivacionAlertaRankingPeriodoDTO> activacionAlertaRankingPeriodo(String fechaInicio, String fechaFin) {
        return dashboardMapper.activacionAlertaRankingPeriodo(fechaInicio, fechaFin);
    }

    @Override
    public List<VictimasPotencialesAnioDTO> victimasPotencialesAnio(String anioInicio, String anioFin) {
        return dashboardMapper.victimasPotencialesAnio(anioInicio, anioFin);
    }

    @Override
    public List<VictimasPotencialesPeriodoDTO> victimasPotencialesPeriodo(String fechaInicio, String fechaFin) {
        return dashboardMapper.victimasPotencialesPeriodo(fechaInicio, fechaFin);
    }

    @Override
    public List<VictimasPotencialesRankingAnioDTO> victimasPotencialesRankingAnio(String anioInicio, String anioFin) {
        return dashboardMapper.victimasPotencialesRankingAnio(anioInicio, anioFin);
    }

    @Override
    public List<VictimasPotencialesRankingPeriodoDTO> victimasPotencialesRankingPeriodo(String fechaInicio, String fechaFin) {
        return dashboardMapper.victimasPotencialesRankingPeriodo(fechaInicio, fechaFin);
    }

    @Override
    public List<AccionesFiscalesAnioDTO> accionesFiscalesAnio(String anioInicio, String anioFin) {
        return dashboardMapper.accionesFiscalesAnio(anioInicio, anioFin);
    }

    @Override
    public List<AccionesFiscalesPeriodoDTO> accionesFiscalesPeriodo(String fechaInicio, String fechaFin) {
        return dashboardMapper.accionesFiscalesPeriodo(fechaInicio, fechaFin);
    }

    @Override
    public List<ServiciosAsistenciaUdavitAnioDTO> serviciosAsistenciaUdavitAnio(String anioInicio, String anioFin) {
        return dashboardMapper.serviciosAsistenciaUdavitAnio(anioInicio, anioFin);
    }

    @Override
    public List<ServiciosAsistenciaUdavitPeriodoDTO> serviciosAsistenciaUdavitPeriodo(String fechaInicio, String fechaFin) {
        return dashboardMapper.serviciosAsistenciaUdavitPeriodo(fechaInicio, fechaFin);
    }

    @Override
    public List<MedidasProteccionAnioDTO> medidasProteccionAnio(String anioInicio, String anioFin) {
        return dashboardMapper.medidasProteccionAnio(anioInicio, anioFin);
    }

    @Override
    public List<MedidasProteccionPeriodoDTO> medidasProteccionPeriodo(String fechaInicio, String fechaFin) {
        return dashboardMapper.medidasProteccionPeriodo(fechaInicio, fechaFin);
    }

}
