package gob.pe.mp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper=false)
@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FactorRiesgoEntity {

    private Integer id_fact_riesgo_detalle;
    private Integer fact_riesgo;
    private String id_tb_ficha_reca;
    private String detalle;
}
