package gob.pe.mp.service;

import gob.pe.mp.api.AlertasApiDelegate;
import gob.pe.mp.entity.AccionAlertaEntity;
import gob.pe.mp.entity.AlertaEntity;
import gob.pe.mp.entity.ProteccionAlertaEntity;
import gob.pe.mp.enums.EstadoAlertaEnum;
import gob.pe.mp.model.*;
import gob.pe.mp.repository.impl.AlertaRepository;
import gob.pe.mp.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlertaService implements AlertasApiDelegate {

    @Autowired
    private AlertaRepository alertaRepository;

    @Override
    public ResponseEntity<RegistrarAlertaResponse> registrarAlerta(RegistrarAlertaRequest request) {
        Date fechaIngreso = DateUtil.getDateFromString(request.getFechaIngreso(), DateUtil.DATETIME_FORMAT);
        Date fechaRegistro = DateUtil.getDateFromString(request.getFechaRegistro(), DateUtil.DATETIME_FORMAT);

        alertaRepository.insertar(
                request.getIdFiscal(), request.getIdDelito(), request.getJuridiccion(),
                request.getDependenciaMPub(), request.getDependenciaPol(), request.getCaso(),
                fechaIngreso, request.getNombreAgraviado(), request.getNombreImputado(), request.getSexo(),
                request.getIdEstado(), request.getIdFichaReca(), fechaRegistro
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
            cantidad = alertaRepository.contarProteccionAlerta();
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
    public ResponseEntity<ListarAlertaAccionProteccionResponse> listarAlertaAccionProteccion(Integer idAlerta) {
        List<ProteccionAlertaEntity> listaProteccion = alertaRepository.listarProteccionAlertaById(idAlerta);
        List<AccionAlertaEntity> listaAccion = alertaRepository.listarAcccionAlertaById(idAlerta);

        List<ListarAlertaAccionProteccionDataResponse> listaAlertaProteccionAccion = new ArrayList<>();

        listaProteccion.stream().forEach(proteccionAlertaEntity -> {
            ListarAlertaAccionProteccionDataResponse item = new ListarAlertaAccionProteccionDataResponse();
            item.setCodigo(proteccionAlertaEntity.getId_med_proteccion());
            item.descripcion(proteccionAlertaEntity.getDescripcion());
            item.setTipo("MP");
            listaAlertaProteccionAccion.add(item);
        });

        listaAccion.stream().forEach(accionAlertaEntity -> {
            ListarAlertaAccionProteccionDataResponse item = new ListarAlertaAccionProteccionDataResponse();
            item.setCodigo(accionAlertaEntity.getId_accion_alerta());
            item.descripcion(accionAlertaEntity.getDescripcion());
            item.setTipo("A");
            listaAlertaProteccionAccion.add(item);
        });

        Metadata metadata = new Metadata();
        metadata.setStatus(HttpStatus.OK.value());
        metadata.setMessage("El proceso fue exitoso.");

        ListarAlertaAccionProteccionResponse response = new ListarAlertaAccionProteccionResponse();
        response.setMetadata(metadata);
        response.setData(listaAlertaProteccionAccion);

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
    public ResponseEntity<RegistrarAlertaAccionResponse> registrarAlertaAccion(RegistrarAlertaAccionRequest request) {
        Date fecha = DateUtil.getDateFromString(request.getFechaRegistro(), DateUtil.DATETIME_FORMAT);

        alertaRepository.insertarAlertaAccion(request.getIdAlerta(), request.getIdAccion(), fecha, request.getUsuarioRegistro());
        alertaRepository.actualizarEstado(request.getIdAlerta(), EstadoAlertaEnum.EN_PROCESO.getCodigo());

        Metadata metadata = new Metadata();
        metadata.setStatus(HttpStatus.OK.value());
        metadata.setMessage("El proceso fue exitoso.");

        RegistrarAlertaAccionResponse response = new RegistrarAlertaAccionResponse();
        response.setMetadata(metadata);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<RegistrarAlertaProteccionResponse> registrarAlertaMedidaProteccion(RegistrarAlertaProteccionRequest request) {
        Date fecha = DateUtil.getDateFromString(request.getFechaRegistro(), DateUtil.DATETIME_FORMAT);

        alertaRepository.insertarAlertaMedidaProteccion(request.getIdAlerta(), request.getIdMedidaProteccion(), fecha, request.getUsuarioRegistro());
        alertaRepository.actualizarEstado(request.getIdAlerta(), EstadoAlertaEnum.CERRADO.getCodigo());

        Metadata metadata = new Metadata();
        metadata.setStatus(HttpStatus.OK.value());
        metadata.setMessage("El proceso fue exitoso.");

        RegistrarAlertaProteccionResponse response = new RegistrarAlertaProteccionResponse();
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
        response.setNombresFiscal(
                (entity.getNombres() != null ? (entity.getNombres() + " ") : "") +
                        (entity.getApellido_paterno() != null ? (entity.getApellido_paterno() + " ") : "") +
                        (entity.getApellido_materno() != null ? entity.getApellido_materno() : "")
        );
        response.setIdDelito(entity.getId_delito());
        response.setDetalleDelito(entity.getTx_detalle_delito() != null ? entity.getTx_detalle_delito() : "");
        response.setJuridiccion(entity.getDe_dis_judi());
        response.setDependenciaMPub(entity.getDe_depe_mpub());
        response.setDependenciaPol(entity.getDe_depe_poli());
        response.setCaso(entity.getCaso());
        response.setFechaIngreso(DateUtil.getStringFromDate(entity.getFec_ing_caso(), DateUtil.DATETIME_FORMAT));
        response.setNombreAgraviado(entity.getNombres_agraviado());
        response.setNombreImputado(entity.getNombres_imputado());
        response.setSexo(entity.getTi_sexo());
        response.setIdEstado(entity.getId_estado());
        response.setDescripcionEstado(entity.getDescripcion() != null ? entity.getDescripcion() : "");
        response.setIdFichaReca(entity.getId_tb_ficha_reca());

        if (entity.getFec_registro_nuevo() != null) {
            response.setFechaRegistro(DateUtil.getStringFromDate(entity.getFec_registro_nuevo(), DateUtil.DATETIME_FORMAT));
        }

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
