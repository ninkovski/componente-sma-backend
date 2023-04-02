package gob.pe.mp.repository.mapper;

import gob.pe.mp.dto.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface DashboardMapper {

    @Select(value= "{CALL sp_dashboard_alerta_year(#{anioInicio}, #{anioFin})}")
    @Options(statementType = StatementType.CALLABLE)
    List<ActivacionAlertaAnioDTO> contarAcumuladoAnio(String anioInicio, String anioFin);
    @Select(value= "{CALL sp_dashboard_alerta_periodo(#{fechaInicio}, #{fechaFin})}")
    @Options(statementType = StatementType.CALLABLE)
    List<ActivacionAlertaPeriodoDTO> contarAcumuladoPeriodo(String fechaInicio, String fechaFin);

    @Select(value= "{CALL sp_dashboard_alerta_year_distrito(#{anioInicio}, #{anioFin})}")
    @Options(statementType = StatementType.CALLABLE)
    List<ActivacionAlertaRankingAnioDTO> activacionAlertaRankingAnio(String anioInicio, String anioFin);
    @Select(value= "{CALL sp_dashboard_alerta_periodo_distrito(#{fechaInicio}, #{fechaFin})}")
    @Options(statementType = StatementType.CALLABLE)
    List<ActivacionAlertaRankingPeriodoDTO> activacionAlertaRankingPeriodo(String fechaInicio, String fechaFin);

    @Select(value= "{CALL sp_dashboard_alerta_year_medida_proteccion(#{anioInicio}, #{anioFin})}")
    @Options(statementType = StatementType.CALLABLE)
    List<VictimasPotencialesAnioDTO> victimasPotencialesAnio(String anioInicio, String anioFin);
    @Select(value= "{CALL sp_dashboard_alerta_periodo_medida_proteccion(#{fechaInicio}, #{fechaFin})}")
    @Options(statementType = StatementType.CALLABLE)
    List<VictimasPotencialesPeriodoDTO> victimasPotencialesPeriodo(String fechaInicio, String fechaFin);

    @Select(value= "{CALL sp_dashboard_alerta_year_distrito_medida_proteccion(#{anioInicio}, #{anioFin})}")
    @Options(statementType = StatementType.CALLABLE)
    List<VictimasPotencialesRankingAnioDTO> victimasPotencialesRankingAnio(String anioInicio, String anioFin);
    @Select(value= "{CALL sp_dashboard_alerta_periodo_distrito_medida_proteccion(#{fechaInicio}, #{fechaFin})}")
    @Options(statementType = StatementType.CALLABLE)
    List<VictimasPotencialesRankingPeriodoDTO> victimasPotencialesRankingPeriodo(String fechaInicio, String fechaFin);

    @Select(value= "{CALL sp_dashboard_alerta_year_acciones(#{anioInicio}, #{anioFin})}")
    @Options(statementType = StatementType.CALLABLE)
    List<AccionesFiscalesAnioDTO> accionesFiscalesAnio(String anioInicio, String anioFin);
    @Select(value= "{CALL sp_dashboard_alerta_periodo_acciones(#{fechaInicio}, #{fechaFin})}")
    @Options(statementType = StatementType.CALLABLE)
    List<AccionesFiscalesPeriodoDTO> accionesFiscalesPeriodo(String fechaInicio, String fechaFin);

    @Select(value= "{CALL sp_dashboard_alerta_year_UDAVIT(#{anioInicio}, #{anioFin})}")
    @Options(statementType = StatementType.CALLABLE)
    List<ServiciosAsistenciaUdavitAnioDTO> serviciosAsistenciaUdavitAnio(String anioInicio, String anioFin);
    @Select(value= "{CALL sp_dashboard_alerta_periodo_UDAVIT(#{fechaInicio}, #{fechaFin})}")
    @Options(statementType = StatementType.CALLABLE)
    List<ServiciosAsistenciaUdavitPeriodoDTO> serviciosAsistenciaUdavitPeriodo(String fechaInicio, String fechaFin);

    @Select(value= "{CALL sp_dashboard_alerta_year_medida_proteccion_tipo(#{anioInicio}, #{anioFin})}")
    @Options(statementType = StatementType.CALLABLE)
    List<MedidasProteccionAnioDTO> medidasProteccionAnio(String anioInicio, String anioFin);
    @Select(value= "{CALL sp_dashboard_alerta_periodo_medida_proteccion_tipo(#{fechaInicio}, #{fechaFin})}")
    @Options(statementType = StatementType.CALLABLE)
    List<MedidasProteccionPeriodoDTO> medidasProteccionPeriodo(String fechaInicio, String fechaFin);
}
