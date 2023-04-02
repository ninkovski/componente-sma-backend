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
public class AccionesFiscalesAnioDTO {
	private String fecha_year;
	private String accion;
	private Integer cantidad;
}