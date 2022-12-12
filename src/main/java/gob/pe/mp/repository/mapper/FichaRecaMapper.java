package gob.pe.mp.repository.mapper;

import gob.pe.mp.entity.FichaRecaEntity;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.StatementType;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Mapper
@Component
public interface FichaRecaMapper {

    @Insert(value = "INSERT INTO \"TB_FICHA_RECA\"" +
            "(" +
            " \"GEN_DIST_JUDICIAL\", \"GEN_UDAVIT_UAVIT\", \"GEN_NUM_FICHA\", \"GEN_FEC_FICHA\", \"GEN_BENEFICIARIA\", \"GEN_BENEFICIARIA_FECHA\", " +
            "\"GEN_NUM_CARPETA_ASIST\", \"GEN_NOMBRE_ABOGAGO\", \"GEN_T_SOCIAL\", \"GEN_PSICOLOGO\", \"GEN_MEDIO_DE_COMUNI\", \"GEN_NOMBRE_MEDIO\", " +
            "\"GEN_FEC_PUBLIC\", \"VICT_NOM_APELL\", \"VICT_ID_TB_NACIONALIDAD\", \"VICT_TIP_DOCU\", \"VICT_N_DNI\", \"VICT_DEPARTAMENTO\", \"VICT_PROVINCIA\", " +
            "\"VICT_DISTRITO\", \"VICT_FEC_NACIMIENTO\", \"VICT_TELF_FIJO\", \"VICT_CELULAR\", \"VICT_EMAIL\", \"VICT_DOMINICILIO\", \"VICT_IDIOMA\", \"VICT_ETNIA\", " +
            "\"VICT_HJOS\", \"VICT_GESTANDO\", \"VICT_GESTANDO_MESES\", \"VICT_ESTADO_CIVIL\", \"VICT_ESTADO_CIVIL_OTRO\", \"VICT_N_EDUCATIVO\", \"VICT_TRABAJA\", " +
            "\"VICT_OCUPACION\", \"VICT_OCUPACION_OTROS\", \"VICT_CENTRO_TRAB\", \"VICT_REMUNERACION\", \"VICT_DISCAPACIDAD\", \"VICT_DISCAPACIDAD_DES\", \"VICT_ACC_SALUD\", " +
            "\"VICT_ACC_SALUD_DETALLE\", \"VICT_RELA_AGRESORA\", \"VICT_RELA_AGRESORA_DETALLE\", \"VICT_DEP_NOM_APELL\", \"VICT_DEP_NACIONALIDAD\", \"VICT_DEP_TIP_DOCUMENTO\", " +
            "\"VICT_DEP_N_DNI\", \"VICT_DEP_EDAD\", \"VICT_DEP_DOMICILIO\", \"VICT_DEP_NIVEL_ED\", \"VICT_DEP_ESTU\", \"VICT_DEP_ESTU_TIP\", \"VICT_DEP_NOM_EDU\", " +
            "\"VICT_DEP_ESTU_ANO\", \"VICT_DEP_TRABAJA\", \"VICT_DEP_OCUPACION\", \"VICT_DEP_REMUNERADO\", \"VICT_DEP_CENT_TRABAJO\", \"VICT_DEP_DISCAPACIDAD\", " +
            "\"VICT_DEP_DISCAPACIDAD_DES\", \"VICT_DEP_RELA_DIRECT\", \"VICT_DEP_RELA_DIRECT_DETALLE\", \"VICT_DEP2_NOM_APELL\", \"VICT_DEP2_NACIONALIDAD\", " +
            "\"VICT_DEP2_TIP_DOCUMENTO\", \"VICT_DEP2_N_DNI\", \"VICT_DEP2_EDAD\", \"VICT_DEP2_DOMICILIO\", \"VICT_DEP2_NIVEL_EDU\", \"VICT_DEP2_ESTU\", \"VICT_DEP2_ESTU_TIP\", " +
            "\"VICT_DEP2_NOM_EDU\", \"VICT_DEP2_ESTU_ANO\", \"VICT_DEP2_TRABAJA\", \"VICT_DEP2_OCUPACION\", \"VICT_DEP2_REMUNERADO\", \"VICT_DEP2_CENT_TRABAJO\", " +
            "\"VICT_DEP2_DISCAPACIDAD\", \"VICT_DEP2_DISCAPACIDAD_DES\", \"VICT_DEP2_RELA_DIREC\", \"VICT_DEP2_RELA_DIREC_DETALLE\", \"ASIST_LEGAL\", \"ASIST_SOCIAL\", " +
            "\"ASIST_PSICOLOGICA\", \"ASIST_INFOR_EMIT\", \"ASIST_ASIST_LEGA_DET\", \"ASIST_PSICOLOGICA_DET\", \"ASIST_SOCIAL_DET\", \"APRE_PREGUNT_1\", \"APRE_PREGUNT_2\", " +
            "\"APRE_PREGUNT_3\", \"APRE_PREGUNT_4\", \"APRE_PREGUNT_5\", \"APRE_PREGUNT_6\", \"APRE_PREGUNT_7\", \"UDAVIT_SOL_FISCAL\", \"UDAVIT_SOL_FISCAL_DET\", " +
            "\"UDAVIT_INVESTIGACION\", \"UDAVIT_ACCIONES\", \"UDAVIT_DENUCIA\", \"UDAVIT_MIMP\", \"UDAVIT_MINEDU\", \"UDAVIT_MINSA\", \"UDAVIT_MIRE\", \"UDAVIT_MINJUS\", " +
            "\"UDAVIT_REINSER_LABORAL\", \"UDAVIT_OTROS\", \"CONT_ESTRATEGIA\", \"CONT_ESTRATEGIA_OP\", \"CONT_ESTRATEGIA_OP_DETALLE\" " +
            ") " +
            "VALUES (" +
            "#{genDistJudicial}, #{genUdavitUavit}, #{genNumFicha}, #{genFecFicha}, #{genBeneficiaria}, #{genBeneficiariaFecha}, #{genNumCarpetaAsist}, #{genNombreAbogago}, " +
            "#{genTSocial}, #{genPsicologo}, #{genMedioDeComuni}, #{genNombreMedio}, #{genFecPublic}, #{victNomApell}, #{victIdTbNacionalidad}, #{victTipDocu}, #{victNDni}, " +
            "#{victDepartamento}, #{victProvincia}, #{victDistirto}, #{victFecNacimiento}, #{victTelfFijo}, #{victCelular}, #{victEmail}, #{victDominicilio}, #{victIdioma}, " +
            "#{victEtnia}, #{victHjos}, #{victGestando}, #{victGestandoMeses}, #{victEstadoCivil}, #{victEstadoCivilOtro}, #{victNEducativo}, #{victTrabaja}, #{victOcupacion}, " +
            "#{victOcupacionOtros}, #{victCentroTrab}, #{victRemuneracion}, #{victDiscapacidad}, #{victDiscapacidadDes}, #{victAccSalud}, #{victAccSaludDetalle}, " +
            "#{victRelaAgresora}, #{victRelaAgresoraDetalle}, #{victDepNomApell}, #{victDepNacionalidad}, #{victDepTipDocumento}, #{victDepNDni}, #{victDepEdad}, " +
            "#{victDepDomicilio}, #{victDepNivelEd}, #{victDepEstu}, #{victDepEstuTip}, #{victDepNomEdu}, #{victDepEstuAno}, #{victDepTrabaja}, #{victDepOcupacion}, " +
            "#{victDepRemunerado}, #{victDepCentTrabajo}, #{victDepDiscapacidad}, #{victDepDiscapacidadDes}, #{victDepRelaDirect}, #{victDepRelaDirectDetalle}, " +
            "#{victDep2NomApell}, #{victDep2Nacionalidad}, #{victDep2TipDocumento}, #{victDep2NDni}, #{victDep2Edad}, #{victDep2Domicilio}, #{victDep2NivelEdu}, " +
            "#{victDep2Estu}, #{victDep2EstuTip}, #{victDep2NomEdu}, #{victDep2EstuAno}, #{victDep2Trabaja}, #{victDep2Ocupacion}, #{victDep2Remunerado}, " +
            "#{victDep2CentTrabajo}, #{victDep2Discapacidad}, #{victDep2DiscapacidadDes}, #{victDep2RelaDirec}, #{victDep2RelaDirecDetalle}, #{asistLegal}, " +
            "#{asistSocial}, #{asistPsicologica}, #{asistInforEmit}, #{asistAsistLegaDet}, #{asistPsicologicaDet}, #{asistSocialDet}, #{aprePregunt1}, " +
            "#{aprePregunt2}, #{aprePregunt3}, #{aprePregunt4}, #{aprePregunt5}, #{aprePregunt6}, #{aprePregunt7}, #{udavitSolFiscal}, #{udavitSolFiscalDet}, " +
            "#{udavitInvestigacion}, #{udavitAcciones}, #{udavitDenucia}, #{udavitMimp}, #{udavitMinedu}, #{udavitMinsa}, #{udavitMire}, #{udavitMinjus}, " +
            "#{udavitReinserLaboral}, #{udavitOtros}, #{contEstrategia}, #{contEstrategiaOp}, #{contEstrategiaOpDetalle}" +
            ")")
    void insertar(@Param("genDistJudicial") String genDistJudicial, @Param("genUdavitUavit") String genUdavitUavit, @Param("genNumFicha") Integer genNumFicha,
                  @Param("genFecFicha") Date genFecFicha, @Param("genBeneficiaria") Integer genBeneficiaria, @Param("genBeneficiariaFecha") Date genBeneficiariaFecha,
                  @Param("genNumCarpetaAsist") Integer genNumCarpetaAsist, @Param("genNombreAbogago") String genNombreAbogago, @Param("genTSocial") String genTSocial,
                  @Param("genPsicologo") String genPsicologo, @Param("genMedioDeComuni") Integer genMedioDeComuni, @Param("genNombreMedio") String genNombreMedio,
                  @Param("genFecPublic") Date genFecPublic, @Param("victNomApell") String victNomApell, @Param("victIdTbNacionalidad") Integer victIdTbNacionalidad,
                  @Param("victTipDocu") Integer victTipDocu, @Param("victNDni") Integer victNDni, @Param("victDepartamento") String victDepartamento,
                  @Param("victProvincia") String victProvincia, @Param("victDistirto") String victDistirto, @Param("victFecNacimiento") Date victFecNacimiento,
                  @Param("victTelfFijo") String victTelfFijo, @Param("victCelular") Integer victCelular, @Param("victEmail") String victEmail,
                  @Param("victDominicilio") String victDominicilio, @Param("victIdioma") Integer victIdioma, @Param("victEtnia") Integer victEtnia,
                  @Param("victHjos") Integer victHjos, @Param("victGestando") Integer victGestando, @Param("victGestandoMeses") Integer victGestandoMeses,
                  @Param("victEstadoCivil") Integer victEstadoCivil, @Param("victEstadoCivilOtro") String victEstadoCivilOtro, @Param("victNEducativo") Integer victNEducativo,
                  @Param("victTrabaja") Integer victTrabaja, @Param("victOcupacion") Integer victOcupacion, @Param("victOcupacionOtros") String victOcupacionOtros,
                  @Param("victCentroTrab") String victCentroTrab, @Param("victRemuneracion") Integer victRemuneracion, @Param("victDiscapacidad") Integer victDiscapacidad,
                  @Param("victDiscapacidadDes") Integer victDiscapacidadDes, @Param("victAccSalud") Integer victAccSalud, @Param("victAccSaludDetalle") String victAccSaludDetalle,
                  @Param("victRelaAgresora") Integer victRelaAgresora, @Param("victRelaAgresoraDetalle") String victRelaAgresoraDetalle, @Param("victDepNomApell") String victDepNomApell,
                  @Param("victDepNacionalidad") Integer victDepNacionalidad, @Param("victDepTipDocumento") Integer victDepTipDocumento, @Param("victDepNDni") Integer victDepNDni,
                  @Param("victDepEdad") Integer victDepEdad, @Param("victDepDomicilio") String victDepDomicilio, @Param("victDepNivelEd") Integer victDepNivelEd,
                  @Param("victDepEstu") Integer victDepEstu, @Param("victDepEstuTip") Integer victDepEstuTip, @Param("victDepNomEdu") String victDepNomEdu,
                  @Param("victDepEstuAno") String victDepEstuAno, @Param("victDepTrabaja") Integer victDepTrabaja, @Param("victDepOcupacion") Integer victDepOcupacion,
                  @Param("victDepRemunerado") Integer victDepRemunerado, @Param("victDepCentTrabajo") String victDepCentTrabajo, @Param("victDepDiscapacidad") Integer victDepDiscapacidad,
                  @Param("victDepDiscapacidadDes") Integer victDepDiscapacidadDes, @Param("victDepRelaDirect") Integer victDepRelaDirect, @Param("victDepRelaDirectDetalle") String victDepRelaDirectDetalle,
                  @Param("victDep2NomApell") String victDep2NomApell, @Param("victDep2Nacionalidad") Integer victDep2Nacionalidad, @Param("victDep2TipDocumento") Integer victDep2TipDocumento,
                  @Param("victDep2NDni") Integer victDep2NDni, @Param("victDep2Edad") Integer victDep2Edad, @Param("victDep2Domicilio") String victDep2Domicilio,
                  @Param("victDep2NivelEdu") Integer victDep2NivelEdu, @Param("victDep2Estu") Integer victDep2Estu, @Param("victDep2EstuTip") Integer victDep2EstuTip,
                  @Param("victDep2NomEdu") String victDep2NomEdu, @Param("victDep2EstuAno") String victDep2EstuAno, @Param("victDep2Trabaja") Integer victDep2Trabaja,
                  @Param("victDep2Ocupacion") Integer victDep2Ocupacion, @Param("victDep2Remunerado") Integer victDep2Remunerado, @Param("victDep2CentTrabajo") String victDep2CentTrabajo,
                  @Param("victDep2Discapacidad") Integer victDep2Discapacidad, @Param("victDep2DiscapacidadDes") Integer victDep2DiscapacidadDes, @Param("victDep2RelaDirec") Integer victDep2RelaDirec,
                  @Param("victDep2RelaDirecDetalle") String victDep2RelaDirecDetalle, @Param("asistLegal") Integer asistLegal, @Param("asistSocial") Integer asistSocial,
                  @Param("asistPsicologica") Integer asistPsicologica, @Param("asistInforEmit") String asistInforEmit, @Param("asistAsistLegaDet") String asistAsistLegaDet,
                  @Param("asistPsicologicaDet") String asistPsicologicaDet, @Param("asistSocialDet") String asistSocialDet, @Param("aprePregunt1") Integer aprePregunt1,
                  @Param("aprePregunt2") Integer aprePregunt2, @Param("aprePregunt3") Integer aprePregunt3, @Param("aprePregunt4") Integer aprePregunt4,
                  @Param("aprePregunt5") Integer aprePregunt5, @Param("aprePregunt6") Integer aprePregunt6, @Param("aprePregunt7") String aprePregunt7,
                  @Param("udavitSolFiscal") Integer udavitSolFiscal, @Param("udavitSolFiscalDet") String udavitSolFiscalDet, @Param("udavitInvestigacion") String udavitInvestigacion,
                  @Param("udavitAcciones") String udavitAcciones, @Param("udavitDenucia") String udavitDenucia, @Param("udavitMimp") String udavitMimp,
                  @Param("udavitMinedu") String udavitMinedu, @Param("udavitMinsa") String udavitMinsa, @Param("udavitMire") String udavitMire,
                  @Param("udavitMinjus") String udavitMinjus, @Param("udavitReinserLaboral") String udavitReinserLaboral, @Param("udavitOtros") String udavitOtros,
                  @Param("contEstrategia") Integer contEstrategia, @Param("contEstrategiaOp") Integer contEstrategiaOp, @Param("contEstrategiaOpDetalle") String contEstrategiaOpDetalle
                  );


    @Select(value = "SELECT " +
            "\"ID_TB_FICHA_RECA\", \"GEN_DIST_JUDICIAL\", \"GEN_UDAVIT_UAVIT\", \"GEN_NUM_FICHA\", \"GEN_FEC_FICHA\", \"GEN_BENEFICIARIA\", \"GEN_BENEFICIARIA_FECHA\", " +
            "\"GEN_NUM_CARPETA_ASIST\", \"GEN_NOMBRE_ABOGAGO\", \"GEN_T_SOCIAL\", \"GEN_PSICOLOGO\", \"GEN_MEDIO_DE_COMUNI\", \"GEN_NOMBRE_MEDIO\", " +
            "\"GEN_FEC_PUBLIC\", \"VICT_NOM_APELL\", \"VICT_ID_TB_NACIONALIDAD\", \"VICT_TIP_DOCU\", \"VICT_N_DNI\", \"VICT_DEPARTAMENTO\", \"VICT_PROVINCIA\", " +
            "\"VICT_DISTRITO\", \"VICT_FEC_NACIMIENTO\", \"VICT_TELF_FIJO\", \"VICT_CELULAR\", \"VICT_EMAIL\", \"VICT_DOMINICILIO\", \"VICT_IDIOMA\", \"VICT_ETNIA\", " +
            "\"VICT_HJOS\", \"VICT_GESTANDO\", \"VICT_GESTANDO_MESES\", \"VICT_ESTADO_CIVIL\", \"VICT_ESTADO_CIVIL_OTRO\", \"VICT_N_EDUCATIVO\", \"VICT_TRABAJA\", " +
            "\"VICT_OCUPACION\", \"VICT_OCUPACION_OTROS\", \"VICT_CENTRO_TRAB\", \"VICT_REMUNERACION\", \"VICT_DISCAPACIDAD\", \"VICT_DISCAPACIDAD_DES\", \"VICT_ACC_SALUD\", " +
            "\"VICT_ACC_SALUD_DETALLE\", \"VICT_RELA_AGRESORA\", \"VICT_RELA_AGRESORA_DETALLE\", \"VICT_DEP_NOM_APELL\", \"VICT_DEP_NACIONALIDAD\", \"VICT_DEP_TIP_DOCUMENTO\", " +
            "\"VICT_DEP_N_DNI\", \"VICT_DEP_EDAD\", \"VICT_DEP_DOMICILIO\", \"VICT_DEP_NIVEL_ED\", \"VICT_DEP_ESTU\", \"VICT_DEP_ESTU_TIP\", \"VICT_DEP_NOM_EDU\", " +
            "\"VICT_DEP_ESTU_ANO\", \"VICT_DEP_TRABAJA\", \"VICT_DEP_OCUPACION\", \"VICT_DEP_REMUNERADO\", \"VICT_DEP_CENT_TRABAJO\", \"VICT_DEP_DISCAPACIDAD\", " +
            "\"VICT_DEP_DISCAPACIDAD_DES\", \"VICT_DEP_RELA_DIRECT\", \"VICT_DEP_RELA_DIRECT_DETALLE\", \"VICT_DEP2_NOM_APELL\", \"VICT_DEP2_NACIONALIDAD\", " +
            "\"VICT_DEP2_TIP_DOCUMENTO\", \"VICT_DEP2_N_DNI\", \"VICT_DEP2_EDAD\", \"VICT_DEP2_DOMICILIO\", \"VICT_DEP2_NIVEL_EDU\", \"VICT_DEP2_ESTU\", \"VICT_DEP2_ESTU_TIP\", " +
            "\"VICT_DEP2_NOM_EDU\", \"VICT_DEP2_ESTU_ANO\", \"VICT_DEP2_TRABAJA\", \"VICT_DEP2_OCUPACION\", \"VICT_DEP2_REMUNERADO\", \"VICT_DEP2_CENT_TRABAJO\", " +
            "\"VICT_DEP2_DISCAPACIDAD\", \"VICT_DEP2_DISCAPACIDAD_DES\", \"VICT_DEP2_RELA_DIREC\", \"VICT_DEP2_RELA_DIREC_DETALLE\", \"ASIST_LEGAL\", \"ASIST_SOCIAL\", " +
            "\"ASIST_PSICOLOGICA\", \"ASIST_INFOR_EMIT\", \"ASIST_ASIST_LEGA_DET\", \"ASIST_PSICOLOGICA_DET\", \"ASIST_SOCIAL_DET\", \"APRE_PREGUNT_1\", \"APRE_PREGUNT_2\", " +
            "\"APRE_PREGUNT_3\", \"APRE_PREGUNT_4\", \"APRE_PREGUNT_5\", \"APRE_PREGUNT_6\", \"APRE_PREGUNT_7\", \"UDAVIT_SOL_FISCAL\", \"UDAVIT_SOL_FISCAL_DET\", " +
            "\"UDAVIT_INVESTIGACION\", \"UDAVIT_ACCIONES\", \"UDAVIT_DENUCIA\", \"UDAVIT_MIMP\", \"UDAVIT_MINEDU\", \"UDAVIT_MINSA\", \"UDAVIT_MIRE\", \"UDAVIT_MINJUS\", " +
            "\"UDAVIT_REINSER_LABORAL\", \"UDAVIT_OTROS\", \"CONT_ESTRATEGIA\", \"CONT_ESTRATEGIA_OP\", \"CONT_ESTRATEGIA_OP_DETALLE\" " +
            "FROM \"TB_FICHA_RECA\"")
    @Options(statementType = StatementType.CALLABLE)
    List<FichaRecaEntity> listar();
}
