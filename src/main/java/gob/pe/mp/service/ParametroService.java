package gob.pe.mp.service;

import gob.pe.mp.api.ParametrosApiDelegate;
import gob.pe.mp.entity.ParametroEntity;
import gob.pe.mp.model.*;
import gob.pe.mp.repository.impl.ParametroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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
    public ResponseEntity<RegistrarParametroResponse> registrarParametro(RegistrarParametroRequest request) {
        parametroRepository.insertar(request.getDescripcion(), request.getValor(), request.getUsuarioRegistro());

        Metadata metadata = new Metadata();
        metadata.setStatus(HttpStatus.OK.value());
        metadata.setMessage("El proceso fue exitoso.");

        RegistrarParametroResponse response = new RegistrarParametroResponse();
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
