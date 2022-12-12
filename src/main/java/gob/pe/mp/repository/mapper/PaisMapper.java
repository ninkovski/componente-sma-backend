package gob.pe.mp.repository.mapper;

import gob.pe.mp.entity.PaisEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface PaisMapper {

    @Select(value = "SELECT \"ID_NACIONALIDAD\",\"DESCRIPCION\" "+
            "FROM \"TB_NACIONALIDAD\" " +
            "WHERE \"ID_NACIONALIDAD\"=#{codigo}")
    @Options(statementType = StatementType.CALLABLE)
    List<PaisEntity> listarPorCod(@Param("codigo") Integer codigo);

    @Select(value = "SELECT \"ID_NACIONALIDAD\",\"DESCRIPCION\" "+
            "FROM \"TB_NACIONALIDAD\"")
    @Options(statementType = StatementType.CALLABLE)
    List<PaisEntity> listar();
}
