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
public class DenunciaEntity {

    private Integer id_denuncia;
    private String ano;
    private String mes;
    private String de_dist_judi;
    private String de_depe_mpub;
    private String de_dist;
    private String de_depe_poli;
    private String id_unico;
    private String caso;
    private Date fe_ing_caso;
    private String de_proced;
    private String nombres;
    private String razon;
    private String de_edad;
    private String ti_sexo;
    private String condicion;
    private String de_tipo_parte;
    private String gen_de_mat_deli;
    private String sub_de_mat_deli;
    private String esp_de_mat_deli;
    private String nu_arti;
    private String st_componente;
    private String de_ocup_prof;
    private String de_grad_inst;
    private String registro_flag;
}
