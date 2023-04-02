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
public class VictimasPotencialesRankingAnioDTO {
	private String fecha_year;
	private String distrito;
	private Integer cantidad;
}