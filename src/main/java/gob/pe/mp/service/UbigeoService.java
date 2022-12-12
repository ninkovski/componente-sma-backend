package gob.pe.mp.service;

import gob.pe.mp.api.UbigeosApiDelegate;
import gob.pe.mp.entity.DepartamentoEntity;
import gob.pe.mp.entity.DistritoEntity;
import gob.pe.mp.entity.ProvinciaEntity;
import gob.pe.mp.model.ListarUbigeoDataResponse;
import gob.pe.mp.model.ListarUbigeoResponse;
import gob.pe.mp.model.Metadata;
import gob.pe.mp.repository.impl.UbigeoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UbigeoService implements UbigeosApiDelegate {

    @Autowired
    private UbigeoRepository ubigeoRepository;

    @Override
    public ResponseEntity<ListarUbigeoResponse> listarUbigeo(String codigoDepartamento, String codigoProvincia) {
        List<DepartamentoEntity> listaDepartamento = null;
        List<ProvinciaEntity> listaProvincia = null;
        List<DistritoEntity> listaDistrito = null;

        List<ListarUbigeoDataResponse> listaReponse = null;

        if ((codigoDepartamento == null || codigoDepartamento.isEmpty() )&&
                (codigoProvincia == null || codigoProvincia.isEmpty())) {
            listaDepartamento = ubigeoRepository.listarDepartamento();
            listaReponse = listaDepartamento
                    .stream()
                    .map(this::obtenerDataResponse)
                    .collect(Collectors.toList());
        } else if (codigoDepartamento != null && !codigoDepartamento.isEmpty() &&
                (codigoProvincia == null || codigoProvincia.isEmpty())) {
            listaProvincia = ubigeoRepository.listarProvincia(codigoDepartamento);
            listaReponse = listaProvincia
                    .stream()
                    .map(this::obtenerDataResponse)
                    .collect(Collectors.toList());
        } else if (codigoDepartamento != null && !codigoDepartamento.isEmpty() &&
                codigoProvincia != null && !codigoProvincia.isEmpty()) {
            listaDistrito = ubigeoRepository.listarDistrito(codigoDepartamento + codigoProvincia);
            listaReponse = listaDistrito
                    .stream()
                    .map(this::obtenerDataResponse)
                    .collect(Collectors.toList());
        }

        Metadata metadata = new Metadata();
        metadata.setStatus(HttpStatus.OK.value());
        metadata.setMessage("El proceso fue exitoso.");

        ListarUbigeoResponse response = new ListarUbigeoResponse();
        response.setMetadata(metadata);
        response.setData(listaReponse);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    private ListarUbigeoDataResponse obtenerDataResponse(DepartamentoEntity entity) {
        ListarUbigeoDataResponse response = new ListarUbigeoDataResponse();
        response.setId(entity.getId_departamento());
        response.setDescripcion(entity.getDescripcion());

        return response;
    }

    private ListarUbigeoDataResponse obtenerDataResponse(ProvinciaEntity entity) {
        ListarUbigeoDataResponse response = new ListarUbigeoDataResponse();
        response.setId(entity.getId_provincia());
        response.setDescripcion(entity.getDescripcion());

        return response;
    }

    private ListarUbigeoDataResponse obtenerDataResponse(DistritoEntity entity) {
        ListarUbigeoDataResponse response = new ListarUbigeoDataResponse();
        response.setId(entity.getId_distrito());
        response.setDescripcion(entity.getDescripcion());

        return response;
    }

}
