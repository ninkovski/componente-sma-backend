package gob.pe.mp.repository.mapper;

import gob.pe.mp.entity.DenunciaEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface DenunciaMapper {

    @Select(value = "SELECT " +
            "\"ID_DENUNCIA\", \"ANO\", \"MES\", \"DE_DIST_JUDI\", \"DE_DEPE_MPUB\", \"DE_DIST\", \"DE_DEPE_POLI\", " +
            "\"ID_UNICO\", \"CASO\", \"FE_ING_CASO\", \"DE_PROCED\", \"ID_DENUCIA\", \"NOMBRES\", \"RAZON\", \"DE_EDAD\", " +
            "\"TI_SEXO\", \"CONDICION\", \"DE_TIPO_PARTE\", \"GEN_DE_MAT_DELI\", \"SUB_DE_MAT_DELI\", \"ESP_DE_MAT_DELI\", " +
            "\"NU_ARTI\", \"ST_COMPONENTE\", \"DE_OCUP_PROF\", \"DE_GRAD_INST\", \"REGISTRO_FLAG\"" +
            "FROM \"TB_DENUNCIA\" td " +
            "INNER JOIN \"TB_DENUNCIA_ALERTA\" tda on td.\"ID_DENUNCIA\" = tda.\"ID_DENUNCIA_ALERTA\" " +
            "WHERE tda.\"ID_ALERTA\"=#{idAlerta}")
    @Options(statementType = StatementType.CALLABLE)
    List<DenunciaEntity> listar(@Param("idAlerta") Integer idAlerta);
}
