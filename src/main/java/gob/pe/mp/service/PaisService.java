package gob.pe.mp.service;

import gob.pe.mp.api.PaisesApiDelegate;
import gob.pe.mp.entity.PaisEntity;
import gob.pe.mp.model.ListarPaisDataResponse;
import gob.pe.mp.model.ListarPaisResponse;
import gob.pe.mp.model.Metadata;
import gob.pe.mp.repository.impl.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaisService implements PaisesApiDelegate {

    @Autowired
    private PaisRepository paisRepository;

    @Override
    public ResponseEntity<ListarPaisResponse> listarPais(Integer codigo) {
        List<PaisEntity> lista;

        if (codigo != null && codigo != 0) {
            lista = paisRepository.listar(codigo);
        } else {
            lista = paisRepository.listar();
        }

        List<ListarPaisDataResponse> listaReponse = lista
                .stream()
                .map(this::obtenerDataResponse)
                .collect(Collectors.toList());

        Metadata metadata = new Metadata();
        metadata.setStatus(HttpStatus.OK.value());
        metadata.setMessage("El proceso fue exitoso.");

        ListarPaisResponse response = new ListarPaisResponse();
        response.setMetadata(metadata);
        response.setData(listaReponse);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    private ListarPaisDataResponse obtenerDataResponse(PaisEntity entity) {
        ListarPaisDataResponse response = new ListarPaisDataResponse();
        response.setId(entity.getId_nacionalidad());
        response.setDescripcion(entity.getDescripcion());

        return response;
    }

}
