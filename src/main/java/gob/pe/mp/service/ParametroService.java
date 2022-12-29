package gob.pe.mp.service;

import gob.pe.mp.api.ParametrosApiDelegate;
import gob.pe.mp.entity.ParametroEntity;
import gob.pe.mp.model.*;
import gob.pe.mp.repository.impl.ParametroRepository;
import gob.pe.mp.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ParametroService implements ParametrosApiDelegate {

    @Autowired
    private ParametroRepository parametroRepository;

    @Override
    public ResponseEntity<ListarParametroResponse> listarParametro(Integer codigo) {
        List<ParametroEntity> lista;

        if (codigo != null && codigo != 0) {
            lista = parametroRepository.listar(codigo);
        } else {
            lista = parametroRepository.listar();
        }

        List<ListarParametroDataResponse> listaReponse = lista
                .stream()
                .map(this::obtenerDataResponse)
                .collect(Collectors.toList());

        Metadata metadata = new Metadata();
        metadata.setStatus(HttpStatus.OK.value());
        metadata.setMessage("El proceso fue exitoso.");

        ListarParametroResponse response = new ListarParametroResponse();
        response.setMetadata(metadata);
        response.setData(listaReponse);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ActualizarParametroResponse> actualizarParametro(ActualizarParametroRequest request) {
        Date fecha = DateUtil.getDateFromString(request.getFechaMoficacion(), DateUtil.DATETIME_FORMAT);

        parametroRepository.actualizar(request.getId(), request.getValor(), request.getUsuarioMoficacion(), fecha);

        Metadata metadata = new Metadata();
        metadata.setStatus(HttpStatus.OK.value());
        metadata.setMessage("El proceso fue exitoso.");

        ActualizarParametroResponse response = new ActualizarParametroResponse();
        response.setMetadata(metadata);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    private ListarParametroDataResponse obtenerDataResponse(ParametroEntity entity) {
        ListarParametroDataResponse response = new ListarParametroDataResponse();
        response.setId(entity.getId_parametro());
        response.setDescripcion(entity.getDescripcion());
        response.setValor(entity.getValor());

        return response;
    }

}
