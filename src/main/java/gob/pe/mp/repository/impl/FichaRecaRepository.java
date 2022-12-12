package gob.pe.mp.repository.impl;

import gob.pe.mp.entity.FichaRecaEntity;
import gob.pe.mp.repository.IFichaRecaRepository;
import gob.pe.mp.repository.mapper.FichaRecaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class FichaRecaRepository implements IFichaRecaRepository {

    @Autowired
    private FichaRecaMapper fichaRecaMapper;

    @Override
    public void insertar(String genDistJudicial, String genUdavitUavit, Integer genNumFicha,
                         Date genFecFicha, Integer genBeneficiaria, Date genBeneficiariaFecha,
                         Integer genNumCarpetaAsist, String genNombreAbogago, String genTSocial,
                         String genPsicologo, Integer genMedioDeComuni, String genNombreMedio,
                         Date genFecPublic, String victNomApell, Integer victIdTbNacionalidad,
                         Integer victTipDocu, Integer victNDni, String victDepartamento,
                         String victProvincia, String victDistirto, Date victFecNacimiento,
                         String victTelfFijo, Integer victCelular, String victEmail,
                         String victDominicilio, Integer victIdioma, Integer victEtnia,
                         Integer victHjos, Integer victGestando, Integer victGestandoMeses,
                         Integer victEstadoCivil, String victEstadoCivilOtro, Integer victNEducativo,
                         Integer victTrabaja, Integer victOcupacion, String victOcupacionOtros,
                         String victCentroTrab, Integer victRemuneracion, Integer victDiscapacidad,
                         Integer victDiscapacidadDes, Integer victAccSalud, String victAccSaludDetalle,
                         Integer victRelaAgresora, String victRelaAgresoraDetalle, String victDepNomApell,
                         Integer victDepNacionalidad, Integer victDepTipDocumento, Integer victDepNDni,
                         Integer victDepEdad, String victDepDomicilio, Integer victDepNivelEd,
                         Integer victDepEstu, Integer victDepEstuTip, String victDepNomEdu,
                         String victDepEstuAno, Integer victDepTrabaja, Integer victDepOcupacion,
                         Integer victDepRemunerado, String victDepCentTrabajo, Integer victDepDiscapacidad,
                         Integer victDepDiscapacidadDes, Integer victDepRelaDirect, String victDepRelaDirectDetalle,
                         String victDep2NomApell, Integer victDep2Nacionalidad, Integer victDep2TipDocumento,
                         Integer victDep2NDni, Integer victDep2Edad, String victDep2Domicilio,
                         Integer victDep2NivelEdu, Integer victDep2Estu, Integer victDep2EstuTip,
                         String victDep2NomEdu, String victDep2EstuAno, Integer victDep2Trabaja,
                         Integer victDep2Ocupacion, Integer victDep2Remunerado, String victDep2CentTrabajo,
                         Integer victDep2Discapacidad, Integer victDep2DiscapacidadDes, Integer victDep2RelaDirec,
                         String victDep2RelaDirecDetalle, Integer asistLegal, Integer asistSocial,
                         Integer asistPsicologica, String asistInforEmit, String asistAsistLegaDet,
                         String asistPsicologicaDet, String asistSocialDet, Integer aprePregunt1,
                         Integer aprePregunt2, Integer aprePregunt3, Integer aprePregunt4,
                         Integer aprePregunt5, Integer aprePregunt6, String aprePregunt7,
                         Integer udavitSolFiscal, String udavitSolFiscalDet, String udavitInvestigacion,
                         String udavitAcciones, String udavitDenucia, String udavitMimp,
                         String udavitMinedu, String udavitMinsa, String udavitMire,
                         String udavitMinjus, String udavitReinserLaboral, String udavitOtros,
                         Integer contEstrategia, Integer contEstrategiaOp, String contEstrategiaOpDetalle) {
        fichaRecaMapper.insertar(genDistJudicial, genUdavitUavit, genNumFicha,
                genFecFicha, genBeneficiaria, genBeneficiariaFecha,
                genNumCarpetaAsist, genNombreAbogago, genTSocial,
                genPsicologo, genMedioDeComuni, genNombreMedio,
                genFecPublic, victNomApell, victIdTbNacionalidad,
                victTipDocu, victNDni, victDepartamento,
                victProvincia, victDistirto, victFecNacimiento,
                victTelfFijo, victCelular, victEmail,
                victDominicilio, victIdioma, victEtnia,
                victHjos, victGestando, victGestandoMeses,
                victEstadoCivil, victEstadoCivilOtro, victNEducativo,
                victTrabaja, victOcupacion, victOcupacionOtros,
                victCentroTrab, victRemuneracion, victDiscapacidad,
                victDiscapacidadDes, victAccSalud, victAccSaludDetalle,
                victRelaAgresora, victRelaAgresoraDetalle, victDepNomApell,
                victDepNacionalidad, victDepTipDocumento, victDepNDni,
                victDepEdad, victDepDomicilio, victDepNivelEd,
                victDepEstu, victDepEstuTip, victDepNomEdu,
                victDepEstuAno, victDepTrabaja, victDepOcupacion,
                victDepRemunerado, victDepCentTrabajo, victDepDiscapacidad,
                victDepDiscapacidadDes, victDepRelaDirect, victDepRelaDirectDetalle,
                victDep2NomApell, victDep2Nacionalidad, victDep2TipDocumento,
                victDep2NDni, victDep2Edad, victDep2Domicilio,
                victDep2NivelEdu, victDep2Estu, victDep2EstuTip,
                victDep2NomEdu, victDep2EstuAno, victDep2Trabaja,
                victDep2Ocupacion, victDep2Remunerado, victDep2CentTrabajo,
                victDep2Discapacidad, victDep2DiscapacidadDes, victDep2RelaDirec,
                victDep2RelaDirecDetalle, asistLegal, asistSocial,
                asistPsicologica, asistInforEmit, asistAsistLegaDet,
                asistPsicologicaDet, asistSocialDet, aprePregunt1,
                aprePregunt2, aprePregunt3, aprePregunt4,
                aprePregunt5, aprePregunt6, aprePregunt7,
                udavitSolFiscal, udavitSolFiscalDet, udavitInvestigacion,
                udavitAcciones, udavitDenucia, udavitMimp,
                udavitMinedu, udavitMinsa, udavitMire,
                udavitMinjus, udavitReinserLaboral, udavitOtros,
                contEstrategia, contEstrategiaOp, contEstrategiaOpDetalle);
    }

    @Override
    public List<FichaRecaEntity> listar() {
        return fichaRecaMapper.listar();
    }
}
