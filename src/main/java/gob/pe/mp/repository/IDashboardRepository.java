package gob.pe.mp.repository;

import gob.pe.mp.dto.*;

import java.util.List;

public interface IDashboardRepository {

    List<ActivacionAlertaAnioDTO> activacionAlertaAnio(String anioInicio, String anioFin);
    List<ActivacionAlertaPeriodoDTO> activacionAlertaPeriodo(String fechaInicio, String fechaFin);

    List<ActivacionAlertaRankingAnioDTO> activacionAlertaRankingAnio(String anioInicio, String anioFin);
    List<ActivacionAlertaRankingPeriodoDTO> activacionAlertaRankingPeriodo(String fechaInicio, String fechaFin);

    List<VictimasPotencialesAnioDTO> victimasPotencialesAnio(String anioInicio, String anioFin);
    List<VictimasPotencialesPeriodoDTO> victimasPotencialesPeriodo(String fechaInicio, String fechaFin);

    List<VictimasPotencialesRankingAnioDTO> victimasPotencialesRankingAnio(String anioInicio, String anioFin);
    List<VictimasPotencialesRankingPeriodoDTO> victimasPotencialesRankingPeriodo(String fechaInicio, String fechaFin);

    List<AccionesFiscalesAnioDTO> accionesFiscalesAnio(String anioInicio, String anioFin);
    List<AccionesFiscalesPeriodoDTO> accionesFiscalesPeriodo(String fechaInicio, String fechaFin);

    List<ServiciosAsistenciaUdavitAnioDTO> serviciosAsistenciaUdavitAnio(String anioInicio, String anioFin);
    List<ServiciosAsistenciaUdavitPeriodoDTO> serviciosAsistenciaUdavitPeriodo(String fechaInicio, String fechaFin);

    List<MedidasProteccionAnioDTO> medidasProteccionAnio(String anioInicio, String anioFin);
    List<MedidasProteccionPeriodoDTO> medidasProteccionPeriodo(String fechaInicio, String fechaFin);
}
