package gob.pe.mp.service;

import gob.pe.mp.api.DenunciasApiDelegate;
import gob.pe.mp.entity.DenunciaEntity;
import gob.pe.mp.model.ListarDenunciaDataResponse;
import gob.pe.mp.model.ListarDenunciaResponse;
import gob.pe.mp.model.Metadata;
import gob.pe.mp.repository.impl.DenunciaRepository;
import gob.pe.mp.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DenunciaRecaService implements DenunciasApiDelegate {

    @Autowired
    private DenunciaRepository denunciaRepository;

    @Override
    public ResponseEntity<ListarDenunciaResponse> listarDenuncia(Integer idAlerta) {
        List<DenunciaEntity> lista = denunciaRepository.listar(idAlerta);

        List<ListarDenunciaDataResponse> listaReponse = lista
                .stream()
                .map(this::obtenerDataResponse)
                .collect(Collectors.toList());

        Metadata metadata = new Metadata();
        metadata.setStatus(HttpStatus.OK.value());
        metadata.setMessage("El proceso fue exitoso.");

        ListarDenunciaResponse response = new ListarDenunciaResponse();
        response.setMetadata(metadata);
        response.setData(listaReponse);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    private ListarDenunciaDataResponse obtenerDataResponse(DenunciaEntity entity) {
        ListarDenunciaDataResponse response = new ListarDenunciaDataResponse();
        response.setIdDenuncia(entity.getId_denuncia());
        response.setAno(entity.getAno());
        response.setMes(entity.getMes());
        response.deDistJudi(entity.getDe_dist_judi());
        response.setDeDepeMPub(entity.getDe_depe_mpub());
        response.setDeDist(entity.getDe_dist());
        response.setDeDepePoli(entity.getDe_depe_poli());
        response.setIdUnico(entity.getId_unico());
        response.setCaso(entity.getCaso());

        if (entity.getFe_ing_caso() != null) {
            response.setFeIngCase(DateUtil.getStringFromDate(entity.getFe_ing_caso(), DateUtil.DATETIME_FORMAT));
        }

        response.setDeProced(entity.getDe_proced());
        response.setNombres(entity.getNombres());
        response.setRazon(entity.getRazon());
        response.setDeEdad(entity.getDe_edad());
        response.setTiSexo(entity.getTi_sexo());
        response.setCondicion(entity.getCondicion());
        response.setDeTipoParte(entity.getDe_tipo_parte());
        response.setGenDeMatDeli(entity.getGen_de_mat_deli());
        response.setSubDeMatDeli(entity.getSub_de_mat_deli());
        response.setEspDeMatDeli(entity.getEsp_de_mat_deli());
        response.setNuArti(entity.getNu_arti());
        response.setStComponente(entity.getSt_componente());
        response.setDeOcupProf(entity.getDe_ocup_prof());
        response.setDeGradInst(entity.getDe_grad_inst());
        response.setRegistroFlag(entity.getRegistro_flag());

        return response;
    }

}
