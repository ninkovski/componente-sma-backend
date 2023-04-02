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
public class ServiciosAsistenciaUdavitPeriodoDTO {
	private String fecha_periodo;
	private Integer cantidad;
}