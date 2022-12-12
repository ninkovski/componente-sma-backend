package gob.pe.mp.repository.mapper;

import gob.pe.mp.entity.CatalogoEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface CatalogoMapper {

    @Select(value = "SELECT \"ID_SUB_GRUPO\",\"DESCRIPCION\" "+
            "FROM \"TB_CATALOGO\" " +
            "WHERE \"ID_GRUPO\"=#{codigoPadre} and \"ID_SUB_GRUPO\"=#{codigoHijo}")
    @Options(statementType = StatementType.CALLABLE)
    List<CatalogoEntity> listarPorCodPadreHijo(@Param("codigoPadre") Integer codigoPadre, @Param("codigoHijo") Integer codigoHijo);

    @Select(value = "SELECT \"ID_SUB_GRUPO\",\"DESCRIPCION\" "+
            "FROM \"TB_CATALOGO\" " +
            "WHERE \"ID_GRUPO\"=#{codigoPadre}")
    @Options(statementType = StatementType.CALLABLE)
    List<CatalogoEntity> listarPorCodPadre(@Param("codigoPadre") Integer codigoPadre);
}
