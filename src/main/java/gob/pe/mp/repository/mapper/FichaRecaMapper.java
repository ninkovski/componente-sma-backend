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

    @Select(value = "INSERT INTO \"TB_FICHA_RECA\"" +
            "(" +
            "\"GEN_DIST_JUDICIAL\", \"GEN_UDAVIT_UAVIT\", \"GEN_NUM_FICHA\", \"GEN_FEC_FICHA\", \"GEN_BENEFICIARIA\", \"GEN_BENEFICIARIA_FECHA\", " +
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
            ") returning \"ID_TB_FICHA_RECA\"")
    @Result(column = "ID_TB_FICHA_RECA")
    Integer insertar(@Param("genDistJudicial") String genDistJudicial, @Param("genUdavitUavit") String genUdavitUavit, @Param("genNumFicha") Integer genNumFicha,
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
            "FROM \"TB_FICHA_RECA\" WHERE \"ID_TB_FICHA_RECA\"=#{codigo}")
    @Options(statementType = StatementType.CALLABLE)
    List<FichaRecaEntity> listarPorCod(@Param("codigo") Integer codigo);

    @Update(value = "UPDATE \"TB_FICHA_RECA\" SET " +
            "\"GEN_DIST_JUDICIAL\"=#{genDistJudicial}, \"GEN_UDAVIT_UAVIT\"=#{genUdavitUavit}, \"GEN_NUM_FICHA\"=#{genNumFicha}, \"GEN_FEC_FICHA\"=#{genFecFicha}, \"GEN_BENEFICIARIA\"=#{genBeneficiaria}, \"GEN_BENEFICIARIA_FECHA\"=#{genBeneficiariaFecha}, " +
            "\"GEN_NUM_CARPETA_ASIST\"=#{genNumCarpetaAsist}, \"GEN_NOMBRE_ABOGAGO\"=#{genNombreAbogago}, \"GEN_T_SOCIAL\"=#{genTSocial}, \"GEN_PSICOLOGO\"=#{genPsicologo}, \"GEN_MEDIO_DE_COMUNI\"=#{genMedioDeComuni}, \"GEN_NOMBRE_MEDIO\"=#{genNombreMedio}, " +
            "\"GEN_FEC_PUBLIC\"=#{genFecPublic}, \"VICT_NOM_APELL\"=#{victNomApell}, \"VICT_ID_TB_NACIONALIDAD\"=#{victIdTbNacionalidad}, \"VICT_TIP_DOCU\"=#{victTipDocu}, \"VICT_N_DNI\"=#{victNDni}, \"VICT_DEPARTAMENTO\"=#{victDepartamento}, \"VICT_PROVINCIA\"=#{victProvincia}, " +
            "\"VICT_DISTRITO\"=#{victDistirto}, \"VICT_FEC_NACIMIENTO\"=#{victFecNacimiento}, \"VICT_TELF_FIJO\"=#{victTelfFijo}, \"VICT_CELULAR\"=#{victCelular}, \"VICT_EMAIL\"=#{victEmail}, \"VICT_DOMINICILIO\"=#{victDominicilio}, \"VICT_IDIOMA\"=#{victIdioma}, \"VICT_ETNIA\"=#{victEtnia}, " +
            "\"VICT_HJOS\"=#{victHjos}, \"VICT_GESTANDO\"=#{victGestando}, \"VICT_GESTANDO_MESES\"=#{victGestandoMeses}, \"VICT_ESTADO_CIVIL\"=#{victEstadoCivil}, \"VICT_ESTADO_CIVIL_OTRO\"=#{victEstadoCivilOtro}, \"VICT_N_EDUCATIVO\"=#{victNEducativo}, \"VICT_TRABAJA\"=#{victTrabaja}, " +
            "\"VICT_OCUPACION\"=#{victOcupacion}, \"VICT_OCUPACION_OTROS\"=#{victOcupacionOtros}, \"VICT_CENTRO_TRAB\"=#{victCentroTrab}, \"VICT_REMUNERACION\"=#{victRemuneracion}, \"VICT_DISCAPACIDAD\"=#{victDiscapacidad}, \"VICT_DISCAPACIDAD_DES\"=#{victDiscapacidadDes}, \"VICT_ACC_SALUD\"=#{victAccSalud}, " +
            "\"VICT_ACC_SALUD_DETALLE\"=#{victAccSaludDetalle}, \"VICT_RELA_AGRESORA\"=#{victRelaAgresora}, \"VICT_RELA_AGRESORA_DETALLE\"=#{victRelaAgresoraDetalle}, \"VICT_DEP_NOM_APELL\"=#{victDepNomApell}, \"VICT_DEP_NACIONALIDAD\"=#{victDepNacionalidad}, \"VICT_DEP_TIP_DOCUMENTO\"=#{victDepTipDocumento}, " +
            "\"VICT_DEP_N_DNI\"=#{victDepNDni}, \"VICT_DEP_EDAD\"=#{victDepEdad}, \"VICT_DEP_DOMICILIO\"=#{victDepDomicilio}, \"VICT_DEP_NIVEL_ED\"=#{victDepNivelEd}, \"VICT_DEP_ESTU\"=#{victDepEstu}, \"VICT_DEP_ESTU_TIP\"=#{victDepEstuTip}, \"VICT_DEP_NOM_EDU\"=#{victDepNomEdu}, " +
            "\"VICT_DEP_ESTU_ANO\"=#{victDepEstuAno}, \"VICT_DEP_TRABAJA\"=#{victDepTrabaja}, \"VICT_DEP_OCUPACION\"=#{victDepOcupacion}, \"VICT_DEP_REMUNERADO\"=#{victDepRemunerado}, \"VICT_DEP_CENT_TRABAJO\"=#{victDepCentTrabajo}, \"VICT_DEP_DISCAPACIDAD\"=#{victDepDiscapacidad}, " +
            "\"VICT_DEP_DISCAPACIDAD_DES\"=#{victDepDiscapacidadDes}, \"VICT_DEP_RELA_DIRECT\"=#{victDepRelaDirect}, \"VICT_DEP_RELA_DIRECT_DETALLE\"=#{victDepRelaDirectDetalle}, \"VICT_DEP2_NOM_APELL\"=#{victDep2NomApell}, \"VICT_DEP2_NACIONALIDAD\"=#{victDep2Nacionalidad}, " +
            "\"VICT_DEP2_TIP_DOCUMENTO\"=#{victDep2TipDocumento}, \"VICT_DEP2_N_DNI\"=#{victDep2NDni}, \"VICT_DEP2_EDAD\"=#{victDep2Edad}, \"VICT_DEP2_DOMICILIO\"=#{victDep2Domicilio}, \"VICT_DEP2_NIVEL_EDU\"=#{victDep2NivelEdu}, \"VICT_DEP2_ESTU\"=#{victDep2Estu}, \"VICT_DEP2_ESTU_TIP\"=#{victDep2EstuTip}, " +
            "\"VICT_DEP2_NOM_EDU\"=#{victDep2NomEdu}, \"VICT_DEP2_ESTU_ANO\"=#{victDep2EstuAno}, \"VICT_DEP2_TRABAJA\"=#{victDep2Trabaja}, \"VICT_DEP2_OCUPACION\"=#{victDep2Ocupacion}, \"VICT_DEP2_REMUNERADO\"=#{victDep2Remunerado}, \"VICT_DEP2_CENT_TRABAJO\"=#{victDep2CentTrabajo}, " +
            "\"VICT_DEP2_DISCAPACIDAD\"=#{victDep2Discapacidad}, \"VICT_DEP2_DISCAPACIDAD_DES\"=#{victDep2DiscapacidadDes}, \"VICT_DEP2_RELA_DIREC\"=#{victDep2RelaDirec}, \"VICT_DEP2_RELA_DIREC_DETALLE\"=#{victDep2RelaDirecDetalle}, \"ASIST_LEGAL\"=#{asistLegal}, \"ASIST_SOCIAL\"=#{asistSocial}, " +
            "\"ASIST_PSICOLOGICA\"=#{asistPsicologica}, \"ASIST_INFOR_EMIT\"=#{asistInforEmit}, \"ASIST_ASIST_LEGA_DET\"=#{asistAsistLegaDet}, \"ASIST_PSICOLOGICA_DET\"=#{asistPsicologicaDet}, \"ASIST_SOCIAL_DET\"=#{asistSocialDet}, \"APRE_PREGUNT_1\"=#{aprePregunt1}, \"APRE_PREGUNT_2\"=#{aprePregunt2}, " +
            "\"APRE_PREGUNT_3\"=#{aprePregunt3}, \"APRE_PREGUNT_4\"=#{aprePregunt4}, \"APRE_PREGUNT_5\"=#{aprePregunt5}, \"APRE_PREGUNT_6\"=#{aprePregunt6}, \"APRE_PREGUNT_7\"=#{aprePregunt7}, \"UDAVIT_SOL_FISCAL\"=#{udavitSolFiscal}, \"UDAVIT_SOL_FISCAL_DET\"=#{udavitSolFiscalDet}, " +
            "\"UDAVIT_INVESTIGACION\"=#{udavitInvestigacion}, \"UDAVIT_ACCIONES\"=#{udavitAcciones}, \"UDAVIT_DENUCIA\"=#{udavitDenucia}, \"UDAVIT_MIMP\"=#{udavitMimp}, \"UDAVIT_MINEDU\"=#{udavitMinedu}, \"UDAVIT_MINSA\"=#{udavitMinsa}, \"UDAVIT_MIRE\"=#{udavitMire}, \"UDAVIT_MINJUS\"=#{udavitMinjus}, " +
            "\"UDAVIT_REINSER_LABORAL\"=#{udavitReinserLaboral}, \"UDAVIT_OTROS\"=#{udavitOtros}, \"CONT_ESTRATEGIA\"=#{contEstrategia}, \"CONT_ESTRATEGIA_OP\"=#{contEstrategiaOp}, \"CONT_ESTRATEGIA_OP_DETALLE\"=#{contEstrategiaOpDetalle} " +
            " WHERE \"ID_TB_FICHA_RECA\"=#{idFechaReca}")
    void actualizar(@Param("idFechaReca") Integer idFechaReca,@Param("genDistJudicial") String genDistJudicial, @Param("genUdavitUavit") String genUdavitUavit, @Param("genNumFicha") Integer genNumFicha,
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
}
