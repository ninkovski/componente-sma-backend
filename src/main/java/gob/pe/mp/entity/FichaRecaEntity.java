package gob.pe.mp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@EqualsAndHashCode(callSuper=false)
@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FichaRecaEntity {

    private Integer id_tb_ficha_reca;
    private String gen_dist_judicial;
    private String gen_udavit_uavit;
    private Integer gen_num_ficha;
    private Date gen_fec_ficha;
    private Integer gen_beneficiaria;
    private Date gen_beneficiaria_fecha;
    private Integer gen_num_carpeta_asist;
    private String gen_nombre_abogago;
    private String gen_t_social;
    private String gen_psicologo;
    private Integer gen_medio_de_comuni;
    private String gen_nombre_medio;
    private Date gen_fec_public;
    private String vict_nom_apell;
    private Integer vict_id_tb_nacionalidad;
    private Integer vict_tip_docu;
    private Integer vict_n_dni;
    private String vict_departamento;
    private String vict_provincia;
    private String vict_distrito;
    private Date vict_fec_nacimiento;
    private String vict_telf_fijo;
    private Integer vict_celular;
    private String vict_email;
    private String vict_dominicilio;
    private Integer vict_idioma;
    private Integer vict_etnia;
    private Integer vict_hjos;
    private Integer vict_gestando;
    private Integer vict_gestando_meses;
    private Integer vict_estado_civil;
    private String vict_estado_civil_otro;
    private Integer vict_n_educativo;
    private Integer vict_trabaja;
    private Integer vict_ocupacion;
    private String vict_ocupacion_otros;
    private String vict_centro_trab;
    private Integer vict_remuneracion;
    private Integer vict_discapacidad;
    private Integer vict_discapacidad_des;
    private Integer vict_acc_salud;
    private String vict_acc_salud_detalle;
    private Integer vict_rela_agresora;
    private String vict_rela_agresora_detalle;
    private String vict_dep_nom_apell;
    private Integer vict_dep_nacionalidad;
    private Integer vict_dep_tip_documento;
    private Integer vict_dep_n_dni;
    private Integer vict_dep_edad;
    private String vict_dep_domicilio;
    private Integer vict_dep_nivel_ed;
    private Integer vict_dep_estu;
    private Integer vict_dep_estu_tip;
    private String vict_dep_nom_edu;
    private String vict_dep_estu_ano;
    private Integer vict_dep_trabaja;
    private Integer vict_dep_ocupacion;
    private Integer vict_dep_remunerado;
    private String vict_dep_cent_trabajo;
    private Integer vict_dep_discapacidad;
    private Integer vict_dep_discapacidad_des;
    private Integer vict_dep_rela_direct;
    private String vict_dep_rela_direct_detalle;
    private String vict_dep2_nom_apell;
    private Integer vict_dep2_nacionalidad;
    private Integer vict_dep2_tip_documento;
    private Integer vict_dep2_n_dni;
    private Integer vict_dep2_edad;
    private String vict_dep2_domicilio;
    private Integer vict_dep2_nivel_edu;
    private Integer vict_dep2_estu;
    private Integer vict_dep2_estu_tip;
    private String vict_dep2_nom_edu;
    private String vict_dep2_estu_ano;
    private Integer vict_dep2_trabaja;
    private Integer vict_dep2_ocupacion;
    private Integer vict_dep2_remunerado;
    private String vict_dep2_cent_trabajo;
    private Integer vict_dep2_discapacidad;
    private Integer vict_dep2_discapacidad_des;
    private Integer vict_dep2_rela_direc;
    private String vict_dep2_rela_direc_detalle;
    private Integer asist_legal;
    private Integer asist_social;
    private Integer asist_psicologica;
    private String asist_infor_emit;
    private String asist_asist_lega_det;
    private String asist_psicologica_det;
    private String asist_social_det;
    private Integer apre_pregunt_1;
    private Integer apre_pregunt_2;
    private Integer apre_pregunt_3;
    private Integer apre_pregunt_4;
    private Integer apre_pregunt_5;
    private Integer apre_pregunt_6;
    private String apre_pregunt_7;
    private Integer udavit_sol_fiscal;
    private String udavit_sol_fiscal_det;
    private String udavit_investigacion;
    private String udavit_acciones;
    private String udavit_denucia;
    private String udavit_mimp;
    private String udavit_minedu;
    private String udavit_minsa;
    private String udavit_mire;
    private String udavit_minjus;
    private String udavit_reinser_laboral;
    private String udavit_otros;
    private Integer cont_estrategia;
    private Integer cont_estrategia_op;
    private String cont_estrategia_op_detalle;
}