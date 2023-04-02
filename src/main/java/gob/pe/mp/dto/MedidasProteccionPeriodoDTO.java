package gob.pe.mp.dto;

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
public class MedidasProteccionPeriodoDTO {
	private String fecha_periodo;
	private String medida_proteccion;
	private Integer cantidad;
}