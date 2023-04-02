package gob.pe.mp.service;

import gob.pe.mp.api.DashboardsApiDelegate;
import gob.pe.mp.dto.*;
import gob.pe.mp.model.*;
import gob.pe.mp.repository.impl.DashboardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DashboardService implements DashboardsApiDelegate {

    @Autowired
    private DashboardRepository dashboardRepository;

    @Override
    public ResponseEntity<ActivacionAlertaAnioResponse> activacionAlertaAnio(String anioInicio, String anioFin) {
        List<ActivacionAlertaAnioDTO> lista = dashboardRepository.activacionAlertaAnio(anioInicio, anioFin);

        List<ActivacionAlertaAnioDataResponse> listaReponse = lista
                .stream()
                .map(this::obtenerDataResponse)
                .collect(Collectors.toList());

        Metadata metadata = new Metadata();
        metadata.setStatus(HttpStatus.OK.value());
        metadata.setMessage("El proceso fue exitoso.");

        ActivacionAlertaAnioResponse response = new ActivacionAlertaAnioResponse();
        response.setMetadata(metadata);
        response.setData(listaReponse);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ActivacionAlertaPeriodoResponse> activacionAlertaPeriodo(String fechaInicio, String fechaFin) {
        List<ActivacionAlertaPeriodoDTO> lista = dashboardRepository.activacionAlertaPeriodo(fechaInicio, fechaFin);

        List<ActivacionAlertaPeriodoDataResponse> listaReponse = lista
                .stream()
                .map(this::obtenerDataResponse)
                .collect(Collectors.toList());

        Metadata metadata = new Metadata();
        metadata.setStatus(HttpStatus.OK.value());
        metadata.setMessage("El proceso fue exitoso.");

        ActivacionAlertaPeriodoResponse response = new ActivacionAlertaPeriodoResponse();
        response.setMetadata(metadata);
        response.setData(listaReponse);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ActivacionAlertaRankingAnioResponse> activacionAlertaRankingAnio(String anioInicio, String anioFin) {
        List<ActivacionAlertaRankingAnioDTO> lista = dashboardRepository.activacionAlertaRankingAnio(anioInicio, anioFin);

        List<ActivacionAlertaRankingAnioDataResponse> listaReponse = lista
                .stream()
                .map(this::obtenerDataResponse)
                .collect(Collectors.toList());

        Metadata metadata = new Metadata();
        metadata.setStatus(HttpStatus.OK.value());
        metadata.setMessage("El proceso fue exitoso.");

        ActivacionAlertaRankingAnioResponse response = new ActivacionAlertaRankingAnioResponse();
        response.setMetadata(metadata);
        response.setData(listaReponse);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ActivacionAlertaRankingPeriodoResponse> activacionAlertaRankingPeriodo(String fechaInicio, String fechaFin) {
        List<ActivacionAlertaRankingPeriodoDTO> lista = dashboardRepository.activacionAlertaRankingPeriodo(fechaInicio, fechaFin);

        List<ActivacionAlertaRankingPeriodoDataResponse> listaReponse = lista
                .stream()
                .map(this::obtenerDataResponse)
                .collect(Collectors.toList());

        Metadata metadata = new Metadata();
        metadata.setStatus(HttpStatus.OK.value());
        metadata.setMessage("El proceso fue exitoso.");

        ActivacionAlertaRankingPeriodoResponse response = new ActivacionAlertaRankingPeriodoResponse();
        response.setMetadata(metadata);
        response.setData(listaReponse);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<VictimasPotencialesAnioResponse> victimasPotencialesAnio(String anioInicio, String anioFin) {
        List<VictimasPotencialesAnioDTO> lista = dashboardRepository.victimasPotencialesAnio(anioInicio, anioFin);

        List<VictimasPotencialesAnioDataResponse> listaReponse = lista
                .stream()
                .map(this::obtenerDataResponse)
                .collect(Collectors.toList());

        Metadata metadata = new Metadata();
        metadata.setStatus(HttpStatus.OK.value());
        metadata.setMessage("El proceso fue exitoso.");

        VictimasPotencialesAnioResponse response = new VictimasPotencialesAnioResponse();
        response.setMetadata(metadata);
        response.setData(listaReponse);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<VictimasPotencialesPeriodoResponse> victimasPotencialesPeriodo(String fechaInicio, String fechaFin) {
        List<VictimasPotencialesPeriodoDTO> lista = dashboardRepository.victimasPotencialesPeriodo(fechaInicio, fechaFin);

        List<VictimasPotencialesPeriodoDataResponse> listaReponse = lista
                .stream()
                .map(this::obtenerDataResponse)
                .collect(Collectors.toList());

        Metadata metadata = new Metadata();
        metadata.setStatus(HttpStatus.OK.value());
        metadata.setMessage("El proceso fue exitoso.");

        VictimasPotencialesPeriodoResponse response = new VictimasPotencialesPeriodoResponse();
        response.setMetadata(metadata);
        response.setData(listaReponse);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<VictimasPotencialesRankingAnioResponse> victimasPotencialesRankingAnio(String anioInicio, String anioFin) {
        List<VictimasPotencialesRankingAnioDTO> lista = dashboardRepository.victimasPotencialesRankingAnio(anioInicio, anioFin);

        List<VictimasPotencialesRankingAnioDataResponse> listaReponse = lista
                .stream()
                .map(this::obtenerDataResponse)
                .collect(Collectors.toList());

        Metadata metadata = new Metadata();
        metadata.setStatus(HttpStatus.OK.value());
        metadata.setMessage("El proceso fue exitoso.");

        VictimasPotencialesRankingAnioResponse response = new VictimasPotencialesRankingAnioResponse();
        response.setMetadata(metadata);
        response.setData(listaReponse);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<VictimasPotencialesRankingPeriodoResponse> victimasPotencialesRankingPeriodo(String fechaInicio, String fechaFin) {
        List<VictimasPotencialesRankingPeriodoDTO> lista = dashboardRepository.victimasPotencialesRankingPeriodo(fechaInicio, fechaFin);

        List<VictimasPotencialesRankingPeriodoDataResponse> listaReponse = lista
                .stream()
                .map(this::obtenerDataResponse)
                .collect(Collectors.toList());

        Metadata metadata = new Metadata();
        metadata.setStatus(HttpStatus.OK.value());
        metadata.setMessage("El proceso fue exitoso.");

        VictimasPotencialesRankingPeriodoResponse response = new VictimasPotencialesRankingPeriodoResponse();
        response.setMetadata(metadata);
        response.setData(listaReponse);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<AccionesFiscalesAnioResponse> accionesFiscalesAnio(String anioInicio, String anioFin) {
        List<AccionesFiscalesAnioDTO> lista = dashboardRepository.accionesFiscalesAnio(anioInicio, anioFin);

        List<AccionesFiscalesAnioDataResponse> listaReponse = lista
                .stream()
                .map(this::obtenerDataResponse)
                .collect(Collectors.toList());

        Metadata metadata = new Metadata();
        metadata.setStatus(HttpStatus.OK.value());
        metadata.setMessage("El proceso fue exitoso.");

        AccionesFiscalesAnioResponse response = new AccionesFiscalesAnioResponse();
        response.setMetadata(metadata);
        response.setData(listaReponse);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<AccionesFiscalesPeriodoResponse> accionesFiscalesPeriodo(String fechaInicio, String fechaFin) {
        List<AccionesFiscalesPeriodoDTO> lista = dashboardRepository.accionesFiscalesPeriodo(fechaInicio, fechaFin);

        List<AccionesFiscalesPeriodoDataResponse> listaReponse = lista
                .stream()
                .map(this::obtenerDataResponse)
                .collect(Collectors.toList());

        Metadata metadata = new Metadata();
        metadata.setStatus(HttpStatus.OK.value());
        metadata.setMessage("El proceso fue exitoso.");

        AccionesFiscalesPeriodoResponse response = new AccionesFiscalesPeriodoResponse();
        response.setMetadata(metadata);
        response.setData(listaReponse);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ServiciosAsistenciaUdavitAnioResponse> serviciosAsistenciaUdavitAnio(String anioInicio, String anioFin) {
        List<ServiciosAsistenciaUdavitAnioDTO> lista = dashboardRepository.serviciosAsistenciaUdavitAnio(anioInicio, anioFin);

        List<ServiciosAsistenciaUdavitAnioDataResponse> listaReponse = lista
                .stream()
                .map(this::obtenerDataResponse)
                .collect(Collectors.toList());

        Metadata metadata = new Metadata();
        metadata.setStatus(HttpStatus.OK.value());
        metadata.setMessage("El proceso fue exitoso.");

        ServiciosAsistenciaUdavitAnioResponse response = new ServiciosAsistenciaUdavitAnioResponse();
        response.setMetadata(metadata);
        response.setData(listaReponse);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ServiciosAsistenciaUdavitPeriodoResponse> serviciosAsistenciaUdavitPeriodo(String fechaInicio, String fechaFin) {
        List<ServiciosAsistenciaUdavitPeriodoDTO> lista = dashboardRepository.serviciosAsistenciaUdavitPeriodo(fechaInicio, fechaFin);

        List<ServiciosAsistenciaUdavitPeriodoDataResponse> listaReponse = lista
                .stream()
                .map(this::obtenerDataResponse)
                .collect(Collectors.toList());

        Metadata metadata = new Metadata();
        metadata.setStatus(HttpStatus.OK.value());
        metadata.setMessage("El proceso fue exitoso.");

        ServiciosAsistenciaUdavitPeriodoResponse response = new ServiciosAsistenciaUdavitPeriodoResponse();
        response.setMetadata(metadata);
        response.setData(listaReponse);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<MedidasProteccionAnioResponse> medidasProteccionAnio(String anioInicio, String anioFin) {
        List<MedidasProteccionAnioDTO> lista = dashboardRepository.medidasProteccionAnio(anioInicio, anioFin);

        List<MedidasProteccionAnioDataResponse> listaReponse = lista
                .stream()
                .map(this::obtenerDataResponse)
                .collect(Collectors.toList());

        Metadata metadata = new Metadata();
        metadata.setStatus(HttpStatus.OK.value());
        metadata.setMessage("El proceso fue exitoso.");

        MedidasProteccionAnioResponse response = new MedidasProteccionAnioResponse();
        response.setMetadata(metadata);
        response.setData(listaReponse);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<MedidasProteccionPeriodoResponse> medidasProteccionPeriodo(String fechaInicio, String fechaFin) {
        List<MedidasProteccionPeriodoDTO> lista = dashboardRepository.medidasProteccionPeriodo(fechaInicio, fechaFin);

        List<MedidasProteccionPeriodoDataResponse> listaReponse = lista
                .stream()
                .map(this::obtenerDataResponse)
                .collect(Collectors.toList());

        Metadata metadata = new Metadata();
        metadata.setStatus(HttpStatus.OK.value());
        metadata.setMessage("El proceso fue exitoso.");

        MedidasProteccionPeriodoResponse response = new MedidasProteccionPeriodoResponse();
        response.setMetadata(metadata);
        response.setData(listaReponse);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    private ActivacionAlertaAnioDataResponse obtenerDataResponse(ActivacionAlertaAnioDTO entity) {
        ActivacionAlertaAnioDataResponse response = new ActivacionAlertaAnioDataResponse();
        response.setAnio(entity.getFecha_year());
        response.setCantidad(entity.getCantidad());
        return response;
    }

    private ActivacionAlertaPeriodoDataResponse obtenerDataResponse(ActivacionAlertaPeriodoDTO entity) {
        ActivacionAlertaPeriodoDataResponse response = new ActivacionAlertaPeriodoDataResponse();
        response.setPeriodo(entity.getFecha_periodo());
        response.setCantidad(entity.getCantidad());
        return response;
    }

    private ActivacionAlertaRankingAnioDataResponse obtenerDataResponse(ActivacionAlertaRankingAnioDTO entity) {
        ActivacionAlertaRankingAnioDataResponse response = new ActivacionAlertaRankingAnioDataResponse();
        response.setDistrito(entity.getDistrito());
        response.setCantidad(entity.getCantidad());
        return response;
    }

    private ActivacionAlertaRankingPeriodoDataResponse obtenerDataResponse(ActivacionAlertaRankingPeriodoDTO entity) {
        ActivacionAlertaRankingPeriodoDataResponse response = new ActivacionAlertaRankingPeriodoDataResponse();
        response.setPeriodo(entity.getFecha_periodo());
        response.setDistrito(entity.getDistrito());
        response.setCantidad(entity.getCantidad());
        return response;
    }

    private VictimasPotencialesAnioDataResponse obtenerDataResponse(VictimasPotencialesAnioDTO entity) {
        VictimasPotencialesAnioDataResponse response = new VictimasPotencialesAnioDataResponse();
        response.setAnio(entity.getFecha_year());
        response.setCantidad(entity.getCantidad());
        return response;
    }

    private VictimasPotencialesPeriodoDataResponse obtenerDataResponse(VictimasPotencialesPeriodoDTO entity) {
        VictimasPotencialesPeriodoDataResponse response = new VictimasPotencialesPeriodoDataResponse();
        response.setPeriodo(entity.getFecha_periodo());
        response.setCantidad(entity.getCantidad());
        return response;
    }

    private VictimasPotencialesRankingAnioDataResponse obtenerDataResponse(VictimasPotencialesRankingAnioDTO entity) {
        VictimasPotencialesRankingAnioDataResponse response = new VictimasPotencialesRankingAnioDataResponse();
        response.setAnio(entity.getFecha_year());
        response.setDistrito(entity.getDistrito());
        response.setCantidad(entity.getCantidad());
        return response;
    }

    private VictimasPotencialesRankingPeriodoDataResponse obtenerDataResponse(VictimasPotencialesRankingPeriodoDTO entity) {
        VictimasPotencialesRankingPeriodoDataResponse response = new VictimasPotencialesRankingPeriodoDataResponse();
        response.setPeriodo(entity.getFecha_periodo());
        response.setDistrito(entity.getDistrito());
        response.setCantidad(entity.getCantidad());
        return response;
    }

    private AccionesFiscalesAnioDataResponse obtenerDataResponse(AccionesFiscalesAnioDTO entity) {
        AccionesFiscalesAnioDataResponse response = new AccionesFiscalesAnioDataResponse();
        response.setAnio(entity.getFecha_year());
        response.setAccion(entity.getAccion());
        response.setCantidad(entity.getCantidad());
        return response;
    }

    private AccionesFiscalesPeriodoDataResponse obtenerDataResponse(AccionesFiscalesPeriodoDTO entity) {
        AccionesFiscalesPeriodoDataResponse response = new AccionesFiscalesPeriodoDataResponse();
        response.setPeriodo(entity.getFecha_periodo());
        response.setAccion(entity.getAccion());
        response.setCantidad(entity.getCantidad());
        return response;
    }

    private ServiciosAsistenciaUdavitAnioDataResponse obtenerDataResponse(ServiciosAsistenciaUdavitAnioDTO entity) {
        ServiciosAsistenciaUdavitAnioDataResponse response = new ServiciosAsistenciaUdavitAnioDataResponse();
        response.setAnio(entity.getFecha_year());
        response.setCantidad(entity.getCantidad());
        return response;
    }

    private ServiciosAsistenciaUdavitPeriodoDataResponse obtenerDataResponse(ServiciosAsistenciaUdavitPeriodoDTO entity) {
        ServiciosAsistenciaUdavitPeriodoDataResponse response = new ServiciosAsistenciaUdavitPeriodoDataResponse();
        response.setPeriodo(entity.getFecha_periodo());
        response.setCantidad(entity.getCantidad());
        return response;
    }

    private MedidasProteccionAnioDataResponse obtenerDataResponse(MedidasProteccionAnioDTO entity) {
        MedidasProteccionAnioDataResponse response = new MedidasProteccionAnioDataResponse();
        response.setAnio(entity.getFecha_year());
        response.setMedidaProteccion(entity.getMedida_proteccion());
        response.setCantidad(entity.getCantidad());
        return response;
    }

    private MedidasProteccionPeriodoDataResponse obtenerDataResponse(MedidasProteccionPeriodoDTO entity) {
        MedidasProteccionPeriodoDataResponse response = new MedidasProteccionPeriodoDataResponse();
        response.setPeriodo(entity.getFecha_periodo());
        response.setMedidaProteccion(entity.getMedida_proteccion());
        response.setCantidad(entity.getCantidad());
        return response;
    }

}
