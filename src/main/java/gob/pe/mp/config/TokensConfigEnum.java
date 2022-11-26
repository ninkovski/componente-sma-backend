package gob.pe.mp.config;

import lombok.Getter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Getter
public enum TokensConfigEnum {

    //NUMERO_UNO("992731775", "ACec30858077a488ae328ab28c02ba84a5", "d580dce004d61f73a6186ee92f658553", "+16402213288", "+14155238886");
    NUMERO_DEFAULT("992731775", "ACec30858077a488ae328ab28c02ba84a5", "d580dce004d61f73a6186ee92f658553", "+16402213288", "+14155238886");

    private String numero;
    private String sid;
    private String token;
    private String numeroFrom;
    private String numeroFromWhatsapp;

    private static Map<String, TokensConfigEnum> map = new HashMap<>();

    TokensConfigEnum(String numero, String sid, String token, String numeroFrom, String numeroFromWhatsapp) {
        this.numero = numero;
        this.sid = sid;
        this.token = token;
        this.numeroFrom = numeroFrom;
        this.numeroFromWhatsapp = numeroFromWhatsapp;
    }

    static {
        Arrays.stream(TokensConfigEnum.values()).forEach(tokensConfigEnum ->
                map.put(tokensConfigEnum.numero, tokensConfigEnum)
        );
    }

    public static TokensConfigEnum getTokenConfigEnum(String numero) {
        return map.get(numero) != null ? map.get(numero) : TokensConfigEnum.NUMERO_DEFAULT;
    }

}
