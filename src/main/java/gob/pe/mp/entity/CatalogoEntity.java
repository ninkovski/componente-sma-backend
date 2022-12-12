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
public class CatalogoEntity {

    private Integer id_tb_catologo;
    private Integer id_grupo;
    private String descripcion_grupo;
    private Integer id_sub_grupo;
    private String descripcion;
}
