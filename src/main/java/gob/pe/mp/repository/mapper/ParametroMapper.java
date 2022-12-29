package gob.pe.mp.repository.mapper;

import gob.pe.mp.entity.ParametroEntity;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.StatementType;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Mapper
@Component
public interface ParametroMapper {

    @Select(value = "SELECT \"ID_PARAMETRO\",\"DESCRIPCION\",\"VALOR\" " +
            "FROM \"TB_PARAMETRO\" " +
            "WHERE \"ID_PARAMETRO\"=#{codigo}")
    @Options(statementType = StatementType.CALLABLE)
    List<ParametroEntity> listarPorCod(@Param("codigo") Integer codigo);

    @Select(value = "SELECT \"ID_PARAMETRO\",\"DESCRIPCION\",\"VALOR\" " +
            "FROM \"TB_PARAMETRO\"")
    @Options(statementType = StatementType.CALLABLE)
    List<ParametroEntity> listar();

    @Insert(value = "UPDATE \"TB_PARAMETRO\" SET \"VALOR\"=#{valor},\"USUARIO_AUDT_MODF\"=#{usuarioModificacion},\"FEC_REGISTRO_AUDT_MODF\"=#{fechaMoficacion} " +
            "where \"ID_PARAMETRO\"=#{id}")
    void insertar(@Param("id") Integer id, @Param("valor") Integer valor, @Param("usuarioModificacion") String usuarioModificacion,
                  @Param("fechaMoficacion") Date fechaMoficacion);
}
