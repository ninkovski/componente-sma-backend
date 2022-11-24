package gob.pe.mp.service;

import gob.pe.mp.api.AlertasApiDelegate;
import gob.pe.mp.entity.AccionAlertaEntity;
import gob.pe.mp.entity.AlertaEntity;
import gob.pe.mp.entity.ProteccionAlertaEntity;
import gob.pe.mp.model.*;
import gob.pe.mp.repository.impl.AlertaRepository;
import gob.pe.mp.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlertaService implements AlertasApiDelegate {

    @Autowired
    private AlertaRepository alertaRepository;

    @Override
    public ResponseEntity<RegistrarAlertaResponse> registrarAlerta(RegistrarAlertaRequest request) {
        Date fecha = DateUtil.getDateFromString(request.getFechaIngreso(), DateUtil.DATE_FORMAT);

        alertaRepository.insertar(
                request.getIdFiscal(), request.getIdDelito(), request.getJuridiccion(),
                request.getDependenciaMPub(), request.getDependenciaPol(), request.getCaso(),
                fecha, request.getNombreAgraviado(), request.getNombreImputado(), request.getSexo(),
                request.getIdEstado()
        );

        Metadata metadata = new Metadata();
        metadata.setStatus(HttpStatus.OK.value());
        metadata.setMessage("El proceso fue exitoso.");

        RegistrarAlertaResponse response = new RegistrarAlertaResponse();
        response.setMetadata(metadata);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ListarAlertaResponse> listarAlerta(String fechaInicio, String fechaFin) {
        List<AlertaEntity> lista;

        if (fechaInicio != null && !fechaInicio.isEmpty()
                && fechaFin != null && !fechaFin.isEmpty()) {
            Date fechaInicioDate = DateUtil.getDateFromString(fechaInicio, DateUtil.DATE_FORMAT);
            Date fechaFinDate = DateUtil.getDateFromString(fechaFin, DateUtil.DATE_FORMAT);
            lista = alertaRepository.listarByFechas(fechaInicioDate, fechaFinDate);
        } else {
            lista = alertaRepository.listar();
        }

        List<ListarAlertaDataResponse> listaReponse = lista
                .stream()
                .map(this::obtenerDataResponse)
                .collect(Collectors.toList());

        Metadata metadata = new Metadata();
        metadata.setStatus(HttpStatus.OK.value());
        metadata.setMessage("El proceso fue exitoso.");

        ListarAlertaResponse response = new ListarAlertaResponse();
        response.setMetadata(metadata);
        response.setData(listaReponse);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ContarAlertaResponse> contarAlerta(String fechaInicio, String fechaFin) {
        Integer cantidad;

        if (fechaInicio != null && !fechaInicio.isEmpty()
                && fechaFin != null && !fechaFin.isEmpty()) {
            Date fechaInicioDate = DateUtil.getDateFromString(fechaInicio, DateUtil.DATE_FORMAT);
            Date fechaFinDate = DateUtil.getDateFromString(fechaFin, DateUtil.DATE_FORMAT);
            cantidad = alertaRepository.contarByFechas(fechaInicioDate, fechaFinDate);
        } else {
            cantidad = alertaRepository.contar();
        }

        ContarAlertaDataResponse cantidadAlertaDataResponse = new ContarAlertaDataResponse();
        cantidadAlertaDataResponse.setCantidad(cantidad);

        Metadata metadata = new Metadata();
        metadata.setStatus(HttpStatus.OK.value());
        metadata.setMessage("El proceso fue exitoso.");

        ContarAlertaResponse response = new ContarAlertaResponse();
        response.setMetadata(metadata);
        response.setData(cantidadAlertaDataResponse);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ListarAccionAlertaResponse> listarAccionAlerta() {
        List<AccionAlertaEntity> lista = alertaRepository.listarAccionAlerta();

        List<ListarAccionAlertaDataResponse> listaReponse = lista
                .stream()
                .map(this::obtenerDataResponse)
                .collect(Collectors.toList());

        Metadata metadata = new Metadata();
        metadata.setStatus(HttpStatus.OK.value());
        metadata.setMessage("El proceso fue exitoso.");

        ListarAccionAlertaResponse response = new ListarAccionAlertaResponse();
        response.setMetadata(metadata);
        response.setData(listaReponse);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<RegistrarAccionAlertaResponse> registrarAccionAlerta(RegistrarAccionAlertaRequest request) {
        alertaRepository.insertarAccionAlerta(request.getDescripcion());

        Metadata metadata = new Metadata();
        metadata.setStatus(HttpStatus.OK.value());
        metadata.setMessage("El proceso fue exitoso.");

        RegistrarAccionAlertaResponse response = new RegistrarAccionAlertaResponse();
        response.setMetadata(metadata);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ListarProteccionAlertaResponse> listarProteccionAlerta(String fechaInicio, String fechaFin) {
        List<ProteccionAlertaEntity> lista;

        if (fechaInicio != null && !fechaInicio.isEmpty()
                && fechaFin != null && !fechaFin.isEmpty()) {
            Date fechaInicioDate = DateUtil.getDateFromString(fechaInicio, DateUtil.DATE_FORMAT);
            Date fechaFinDate = DateUtil.getDateFromString(fechaFin, DateUtil.DATE_FORMAT);
            lista = alertaRepository.listarProteccionAlertaByFechas(fechaInicioDate, fechaFinDate);
        } else {
            lista = alertaRepository.listarProteccionAlerta();
        }


        List<ListarProteccionAlertaDataResponse> listaReponse = lista
                .stream()
                .map(this::obtenerDataResponse)
                .collect(Collectors.toList());

        Metadata metadata = new Metadata();
        metadata.setStatus(HttpStatus.OK.value());
        metadata.setMessage("El proceso fue exitoso.");

        ListarProteccionAlertaResponse response = new ListarProteccionAlertaResponse();
        response.setMetadata(metadata);
        response.setData(listaReponse);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ContarProteccionAlertaResponse> contarProteccionAlerta(String fechaInicio, String fechaFin) {
        Integer cantidad;

        if (fechaInicio != null && !fechaInicio.isEmpty()
                && fechaFin != null && !fechaFin.isEmpty()) {
            Date fechaInicioDate = DateUtil.getDateFromString(fechaInicio, DateUtil.DATE_FORMAT);
            Date fechaFinDate = DateUtil.getDateFromString(fechaFin, DateUtil.DATE_FORMAT);
            cantidad = alertaRepository.contarProteccionAlertaByFechas(fechaInicioDate, fechaFinDate);
        } else {
            cantidad = alertaRepository.contar();
        }

        ContarProteccionAlertaDataResponse contarProteccionAlertaDataResponse = new ContarProteccionAlertaDataResponse();
        contarProteccionAlertaDataResponse.setCantidad(cantidad);

        Metadata metadata = new Metadata();
        metadata.setStatus(HttpStatus.OK.value());
        metadata.setMessage("El proceso fue exitoso.");

        ContarProteccionAlertaResponse response = new ContarProteccionAlertaResponse();
        response.setMetadata(metadata);
        response.setData(contarProteccionAlertaDataResponse);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<RegistrarProteccionAlertaResponse> registrarProteccionAlerta(RegistrarProteccionAlertaRequest request) {
        alertaRepository.insertarProteccionAlerta(request.getDescripcion());

        Metadata metadata = new Metadata();
        metadata.setStatus(HttpStatus.OK.value());
        metadata.setMessage("El proceso fue exitoso.");

        RegistrarProteccionAlertaResponse response = new RegistrarProteccionAlertaResponse();
        response.setMetadata(metadata);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<RegistrarDenunciaAlertaResponse> registrarDenunciaAlerta(RegistrarDenunciaAlertaRequest request) {
        alertaRepository.insertarDenunciaAlerta(
                request.getIdDenuncia(), request.getIdAlerta(),
                new Date(), request.getUsuarioRegistro()
        );

        Metadata metadata = new Metadata();
        metadata.setStatus(HttpStatus.OK.value());
        metadata.setMessage("El proceso fue exitoso.");

        RegistrarDenunciaAlertaResponse response = new RegistrarDenunciaAlertaResponse();
        response.setMetadata(metadata);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    private ListarAlertaDataResponse obtenerDataResponse(AlertaEntity entity) {
        ListarAlertaDataResponse response = new ListarAlertaDataResponse();
        response.setIdAlerta(entity.getId_alerta());
        response.setIdFiscal(entity.getId_fiscal());
        response.setIdDelito(entity.getId_delito());
        response.setJuridiccion(entity.getDe_dis_judi());
        response.setDependenciaMPub(entity.getDe_depe_mpub());
        response.setDependenciaPol(entity.getDe_depe_poli());
        response.setCaso(entity.getCaso());
        response.setFechaIngreso(DateUtil.getStringFromDate(entity.getFec_ing_caso(), DateUtil.DATE_FORMAT));
        response.setNombreAgraviado(entity.getNombres_agraviado());
        response.setNombreImputado(entity.getNombres_imputado());
        response.setSexo(entity.getTi_sexo());
        response.setIdEstado(entity.getId_estado());

        return response;
    }

    private ListarAccionAlertaDataResponse obtenerDataResponse(AccionAlertaEntity entity) {
        ListarAccionAlertaDataResponse response = new ListarAccionAlertaDataResponse();
        response.setIdAccionAlerta(entity.getId_accion_alerta());
        response.setDescripcion(entity.getDescripcion());

        return response;
    }

    private ListarProteccionAlertaDataResponse obtenerDataResponse(ProteccionAlertaEntity entity) {
        ListarProteccionAlertaDataResponse response = new ListarProteccionAlertaDataResponse();
        response.setIdProteccionAlerta(entity.getId_med_proteccion());
        response.setDescripcion(entity.getDescripcion());

        return response;
    }

}
