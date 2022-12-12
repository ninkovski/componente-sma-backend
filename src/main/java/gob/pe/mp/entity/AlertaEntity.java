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
public class AlertaEntity {

    private Integer id_alerta;
    private Integer id_fiscal;
    private String nombres;
    private String apellido_paterno;
    private String apellido_materno;
    private Integer id_delito;
    private String tx_detalle_delito;
    private String de_dis_judi;
    private String de_depe_mpub;
    private String de_depe_poli;
    private String caso;
    private Date fec_ing_caso;
    private String nombres_agraviado;
    private String nombres_imputado;
    private String ti_sexo;
    private Integer id_estado;
    private String descripcion;
    private Integer id_tb_ficha_reca;
    private Date fec_registro_nuevo;
}
