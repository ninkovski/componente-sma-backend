package gob.pe.mp.enums;

import lombok.Getter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Getter
public enum EstadoAlertaEnum {

    NOTIFICA(1, "Notifica"),
    EN_PROCESO(2, "En procedo"),
    CERRADO(3, "Cerrado"),
    NO_ATENDIDO(4, "No atendido");

    private Integer codigo;
    private String descripcion;

    private static Map<Integer, EstadoAlertaEnum> map = new HashMap<>();

    EstadoAlertaEnum(Integer codigo, String descripcion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
    }

    static {
        Arrays.stream(EstadoAlertaEnum.values()).forEach(tokensConfigEnum ->
                map.put(tokensConfigEnum.codigo, tokensConfigEnum)
        );
    }

}
