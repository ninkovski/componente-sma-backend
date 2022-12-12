package gob.pe.mp.service;

import gob.pe.mp.api.CatalogosApiDelegate;
import gob.pe.mp.entity.CatalogoEntity;
import gob.pe.mp.model.ListarCatalogoDataResponse;
import gob.pe.mp.model.ListarCatalogoResponse;
import gob.pe.mp.model.Metadata;
import gob.pe.mp.repository.impl.CatalogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CatalogoService implements CatalogosApiDelegate {

    @Autowired
    private CatalogoRepository catalogoRepository;

    @Override
    public ResponseEntity<ListarCatalogoResponse> listarCatalogo(Integer codigoPadre, Integer codigoHijo) {
        List<CatalogoEntity> lista;

        if (codigoHijo != null && codigoHijo != 0) {
            lista = catalogoRepository.listar(codigoPadre, codigoHijo);
        } else {
            lista = catalogoRepository.listar(codigoPadre);
        }

        List<ListarCatalogoDataResponse> listaReponse = lista
                .stream()
                .map(this::obtenerDataResponse)
                .collect(Collectors.toList());

        Metadata metadata = new Metadata();
        metadata.setStatus(HttpStatus.OK.value());
        metadata.setMessage("El proceso fue exitoso.");

        ListarCatalogoResponse response = new ListarCatalogoResponse();
        response.setMetadata(metadata);
        response.setData(listaReponse);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    private ListarCatalogoDataResponse obtenerDataResponse(CatalogoEntity entity) {
        ListarCatalogoDataResponse response = new ListarCatalogoDataResponse();
        response.setIdSubGrupo(entity.getId_sub_grupo());
        response.setDescripcion(entity.getDescripcion());

        return response;
    }

}
