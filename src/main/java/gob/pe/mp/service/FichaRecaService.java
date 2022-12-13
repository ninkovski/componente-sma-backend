package gob.pe.mp.service;

import gob.pe.mp.api.FichasRecaApiDelegate;
import gob.pe.mp.entity.FichaRecaEntity;
import gob.pe.mp.model.*;
import gob.pe.mp.repository.impl.AlertaRepository;
import gob.pe.mp.repository.impl.FichaRecaRepository;
import gob.pe.mp.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FichaRecaService implements FichasRecaApiDelegate {

    @Autowired
    private FichaRecaRepository fichaRecaRepository;

    @Autowired
    private AlertaRepository alertaRepository;

    @Override
    public ResponseEntity<RegistrarFichaRecaResponse> registrarFichaReca(RegistrarFichaRecaRequest request) {
        Date genFecFicha = null;
        Date genBeneficiariaFecha = null;
        Date genFecPublic = null;
        Date victFecNacimiento = null;

        if (request.getGenFecFicha() != null && !request.getGenFecFicha().isEmpty()) {
            genFecFicha = DateUtil.getDateFromString(request.getGenFecFicha(), DateUtil.DATETIME_FORMAT);
        }

        if (request.getGenBeneficiariaFecha() != null && !request.getGenBeneficiariaFecha().isEmpty()) {
            genBeneficiariaFecha = DateUtil.getDateFromString(request.getGenBeneficiariaFecha(), DateUtil.DATETIME_FORMAT);
        }

        if (request.getGenFecPublic() != null && !request.getGenFecPublic().isEmpty()) {
            genFecPublic = DateUtil.getDateFromString(request.getGenFecPublic(), DateUtil.DATETIME_FORMAT);
        }

        if (request.getVictFecNacimiento() != null && !request.getVictFecNacimiento().isEmpty()) {
            victFecNacimiento = DateUtil.getDateFromString(request.getVictFecNacimiento(), DateUtil.DATETIME_FORMAT);
        }

        Integer idFichaReca = fichaRecaRepository.insertar(
                request.getGenDistJudicial(), request.getGenUdavitUavit(), request.getGenNumFicha(), genFecFicha,
                request.getGenBeneficiaria(), genBeneficiariaFecha, request.getGenNumCarpetaAsist(), request.getGenNombreAbogago(),
                request.getGenTSocial(), request.getGenPsicologo(), request.getGenMedioDeComuni(), request.getGenNombreMedio(),
                genFecPublic, request.getVictNomApell(), request.getVictIdTbNacionalidad(), request.getVictTipDocu(), request.getVictNDni(),
                request.getVictDepartamento(), request.getVictProvincia(), request.getVictDistirto(), victFecNacimiento, request.getVictTelfFijo(),
                request.getVictCelular(), request.getVictEmail(), request.getVictDominicilio(), request.getVictIdioma(), request.getVictEtnia(), request.getVictHjos(),
                request.getVictGestando(), request.getVictGestandoMeses(), request.getVictEstadoCivil(), request.getVictEstadoCivilOtro(), request.getVictNEducativo(),
                request.getVictTrabaja(), request.getVictOcupacion(), request.getVictOcupacionOtros(), request.getVictCentroTrab(), request.getVictRemuneracion(),
                request.getVictDiscapacidad(), request.getVictDiscapacidadDes(), request.getVictAccSalud(), request.getVictAccSaludDetalle(), request.getVictRelaAgresora(),
                request.getVictRelaAgresoraDetalle(), request.getVictDepNomApell(), request.getVictDepNacionalidad(), request.getVictDepTipDocumento(), request.getVictDepNDni(),
                request.getVictDepEdad(), request.getVictDepDomicilio(), request.getVictDepNivelEd(), request.getVictDepEstu(), request.getVictDepEstuTip(), request.getVictDepNomEdu(),
                request.getVictDepEstuAno(), request.getVictDepTrabaja(), request.getVictDepOcupacion(), request.getVictDepRemunerado(), request.getVictDepCentTrabajo(), request.getVictDepDiscapacidad(),
                request.getVictDepDiscapacidadDes(), request.getVictDepRelaDirect(), request.getVictDepRelaDirectDetalle(), request.getVictDep2NomApell(), request.getVictDep2Nacionalidad(), request.getVictDep2TipDocumento(),
                request.getVictDep2NDni(), request.getVictDep2Edad(), request.getVictDep2Domicilio(), request.getVictDep2NivelEdu(), request.getVictDep2Estu(), request.getVictDep2EstuTip(), request.getVictDep2NomEdu(),
                request.getVictDep2EstuAno(), request.getVictDep2Trabaja(), request.getVictDep2Ocupacion(), request.getVictDep2Remunerado(), request.getVictDep2CentTrabajo(), request.getVictDep2Discapacidad(),
                request.getVictDep2DiscapacidadDes(), request.getVictDep2RelaDirec(), request.getVictDep2RelaDirecDetalle(), request.getAsistLegal(), request.getAsistSocial(), request.getAsistPsicologica(), request.getAsistInforEmit(),
                request.getAsistAsistLegaDet(), request.getAsistPsicologicaDet(), request.getAsistSocialDet(), request.getAprePregunt1(), request.getAprePregunt2(), request.getAprePregunt3(), request.getAprePregunt4(),
                request.getAprePregunt5(), request.getAprePregunt6(), request.getAprePregunt7(), request.getUdavitSolFiscal(), request.getUdavitSolFiscalDet(), request.getUdavitInvestigacion(), request.getUdavitAcciones(),
                request.getUdavitDenucia(), request.getUdavitMimp(), request.getUdavitMinedu(), request.getUdavitMinsa(), request.getUdavitMire(), request.getUdavitMinjus(), request.getUdavitReinserLaboral(), request.getUdavitOtros(),
                request.getContEstrategia(), request.getContEstrategiaOp(), request.getContEstrategiaOpDetalle()
        );

        actualizarAlertaConIdFichaReca(request.getIdAlerta(), idFichaReca);

        Metadata metadata = new Metadata();
        metadata.setStatus(HttpStatus.OK.value());
        metadata.setMessage("El proceso fue exitoso.");

        RegistrarFichaRecaResponse response = new RegistrarFichaRecaResponse();
        response.setMetadata(metadata);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ListarFichaRecaResponse> listarFichareca() {
        List<FichaRecaEntity> lista = fichaRecaRepository.listar();

        List<ListarFichaRecaDataResponse> listaReponse = lista
                .stream()
                .map(this::obtenerDataResponse)
                .collect(Collectors.toList());

        Metadata metadata = new Metadata();
        metadata.setStatus(HttpStatus.OK.value());
        metadata.setMessage("El proceso fue exitoso.");

        ListarFichaRecaResponse response = new ListarFichaRecaResponse();
        response.setMetadata(metadata);
        response.setData(listaReponse);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    private void actualizarAlertaConIdFichaReca(Integer idAlerta, Integer idFichaReca) {
        if (idFichaReca != null) {
            alertaRepository.actualizar(idAlerta, idFichaReca);
        }
    }

    private ListarFichaRecaDataResponse obtenerDataResponse(FichaRecaEntity entity) {
        ListarFichaRecaDataResponse response = new ListarFichaRecaDataResponse();
        response.setIdTbFichaReca(entity.getId_tb_ficha_reca());
        response.setGenDistJudicial(entity.getGen_dist_judicial());
        response.setGenUdavitUavit(entity.getGen_udavit_uavit());
        response.setGenNumFicha(entity.getGen_num_ficha());

        if (entity.getGen_fec_ficha() != null) {
            response.setGenFecFicha(DateUtil.getStringFromDate(entity.getGen_fec_ficha(), DateUtil.DATETIME_FORMAT));
        }

        response.setGenBeneficiaria(entity.getGen_beneficiaria());

        if (entity.getGen_beneficiaria_fecha() != null) {
            response.setGenBeneficiariaFecha(DateUtil.getStringFromDate(entity.getGen_beneficiaria_fecha(), DateUtil.DATETIME_FORMAT));
        }

        response.setGenNumCarpetaAsist(entity.getGen_num_carpeta_asist());
        response.setGenNombreAbogago(entity.getGen_nombre_abogago());
        response.setGenTSocial(entity.getGen_t_social());
        response.setGenPsicologo(entity.getGen_psicologo());
        response.setGenMedioDeComuni(entity.getGen_medio_de_comuni());
        response.setGenNombreMedio(entity.getGen_nombre_medio());

        if (entity.getGen_fec_public() != null) {
            response.setGenFecPublic(DateUtil.getStringFromDate(entity.getGen_fec_public(), DateUtil.DATETIME_FORMAT));
        }

        response.setVictNomApell(entity.getVict_nom_apell());
        response.setVictIdTbNacionalidad(entity.getVict_id_tb_nacionalidad());
        response.setVictTipDocu(entity.getVict_tip_docu());
        response.setVictNDni(entity.getVict_n_dni());
        response.setVictDepartamento(entity.getVict_departamento());
        response.setVictProvincia(entity.getVict_provincia());
        response.setVictDistirto(entity.getVict_distrito());

        if (entity.getVict_fec_nacimiento() != null) {
            response.setVictFecNacimiento(DateUtil.getStringFromDate(entity.getVict_fec_nacimiento(), DateUtil.DATETIME_FORMAT));
        }

        response.setVictTelfFijo(entity.getVict_telf_fijo());
        response.setVictCelular(entity.getVict_celular());
        response.setVictEmail(entity.getVict_email());
        response.setVictDominicilio(entity.getVict_dominicilio());
        response.setVictIdioma(entity.getVict_idioma());
        response.setVictEtnia(entity.getVict_etnia());
        response.setVictHjos(entity.getVict_hjos());
        response.setVictGestando(entity.getVict_gestando());
        response.setVictGestandoMeses(entity.getVict_gestando_meses());
        response.setVictEstadoCivil(entity.getVict_estado_civil());
        response.setVictEstadoCivilOtro(entity.getVict_estado_civil_otro());
        response.setVictNEducativo(entity.getVict_n_educativo());
        response.setVictTrabaja(entity.getVict_trabaja());
        response.setVictOcupacion(entity.getVict_ocupacion());
        response.setVictOcupacionOtros(entity.getVict_ocupacion_otros());
        response.setVictCentroTrab(entity.getVict_centro_trab());
        response.setVictRemuneracion(entity.getVict_remuneracion());
        response.setVictDiscapacidad(entity.getVict_discapacidad());
        response.setVictDiscapacidadDes(entity.getVict_discapacidad_des());
        response.setVictAccSalud(entity.getVict_acc_salud());
        response.setVictAccSaludDetalle(entity.getVict_acc_salud_detalle());
        response.setVictRelaAgresora(entity.getVict_rela_agresora());
        response.setVictRelaAgresoraDetalle(entity.getVict_rela_agresora_detalle());
        response.setVictDepNomApell(entity.getVict_dep_nom_apell());
        response.setVictDepNacionalidad(entity.getVict_dep_nacionalidad());
        response.setVictDepTipDocumento(entity.getVict_dep_tip_documento());
        response.setVictDepNDni(entity.getVict_dep_n_dni());
        response.setVictDepEdad(entity.getVict_dep_edad());
        response.setVictDepDomicilio(entity.getVict_dep_domicilio());
        response.setVictDepNivelEd(entity.getVict_dep_nivel_ed());
        response.setVictDepEstu(entity.getVict_dep_estu());
        response.setVictDepEstuTip(entity.getVict_dep_estu_tip());
        response.setVictDepNomEdu(entity.getVict_dep_nom_edu());
        response.setVictDepEstuAno(entity.getVict_dep_estu_ano());
        response.setVictDepTrabaja(entity.getVict_dep_trabaja());
        response.setVictDepOcupacion(entity.getVict_dep_ocupacion());
        response.setVictDepRemunerado(entity.getVict_dep_remunerado());
        response.setVictDepCentTrabajo(entity.getVict_dep_cent_trabajo());
        response.setVictDepDiscapacidad(entity.getVict_dep_discapacidad());
        response.setVictDepDiscapacidadDes(entity.getVict_dep_discapacidad_des());
        response.setVictDepRelaDirect(entity.getVict_dep_rela_direct());
        response.setVictDepRelaDirectDetalle(entity.getVict_dep_rela_direct_detalle());
        response.setVictDep2NomApell(entity.getVict_dep2_nom_apell());
        response.setVictDep2Nacionalidad(entity.getVict_dep2_nacionalidad());
        response.setVictDep2TipDocumento(entity.getVict_dep2_tip_documento());
        response.setVictDep2NDni(entity.getVict_dep2_n_dni());
        response.setVictDep2Edad(entity.getVict_dep2_edad());
        response.setVictDep2Domicilio(entity.getVict_dep2_domicilio());
        response.setVictDep2NivelEdu(entity.getVict_dep2_nivel_edu());
        response.setVictDep2Estu(entity.getVict_dep2_estu());
        response.setVictDep2EstuTip(entity.getVict_dep2_estu_tip());
        response.setVictDep2NomEdu(entity.getVict_dep2_nom_edu());
        response.setVictDep2EstuAno(entity.getVict_dep2_estu_ano());
        response.setVictDep2Trabaja(entity.getVict_dep2_trabaja());
        response.setVictDep2Ocupacion(entity.getVict_dep2_ocupacion());
        response.setVictDep2Remunerado(entity.getVict_dep2_remunerado());
        response.setVictDep2CentTrabajo(entity.getVict_dep2_cent_trabajo());
        response.setVictDep2Discapacidad(entity.getVict_dep2_discapacidad());
        response.setVictDep2DiscapacidadDes(entity.getVict_dep2_discapacidad_des());
        response.setVictDep2RelaDirec(entity.getVict_dep2_rela_direc());
        response.setVictDep2RelaDirecDetalle(entity.getVict_dep2_rela_direc_detalle());
        response.setAsistLegal(entity.getAsist_legal());
        response.setAsistSocial(entity.getAsist_social());
        response.setAsistPsicologica(entity.getAsist_psicologica());
        response.setAsistInforEmit(entity.getAsist_infor_emit());
        response.setAsistAsistLegaDet(entity.getAsist_asist_lega_det());
        response.setAsistPsicologicaDet(entity.getAsist_psicologica_det());
        response.setAsistSocialDet(entity.getAsist_social_det());
        response.setAprePregunt1(entity.getApre_pregunt_1());
        response.setAprePregunt2(entity.getApre_pregunt_2());
        response.setAprePregunt3(entity.getApre_pregunt_3());
        response.setAprePregunt4(entity.getApre_pregunt_4());
        response.setAprePregunt5(entity.getApre_pregunt_5());
        response.setAprePregunt6(entity.getApre_pregunt_6());
        response.setAprePregunt7(entity.getApre_pregunt_7());
        response.setUdavitSolFiscal(entity.getUdavit_sol_fiscal());
        response.setUdavitSolFiscalDet(entity.getUdavit_sol_fiscal_det());
        response.setUdavitInvestigacion(entity.getUdavit_investigacion());
        response.setUdavitAcciones(entity.getUdavit_acciones());
        response.setUdavitAcciones(entity.getUdavit_acciones());
        response.setUdavitDenucia(entity.getUdavit_denucia());
        response.setUdavitMimp(entity.getUdavit_mimp());
        response.setUdavitMinedu(entity.getUdavit_minedu());
        response.setUdavitMinsa(entity.getUdavit_minsa());
        response.setUdavitMire(entity.getUdavit_mire());
        response.setUdavitMinjus(entity.getUdavit_minjus());
        response.setUdavitReinserLaboral(entity.getUdavit_reinser_laboral());
        response.setUdavitOtros(entity.getUdavit_otros());
        response.setContEstrategia(entity.getCont_estrategia());
        response.setContEstrategiaOp(entity.getCont_estrategia_op());
        response.setContEstrategiaOpDetalle(entity.getCont_estrategia_op_detalle());

        return response;
    }

}
