package gob.pe.mp.repository.mapper;

import gob.pe.mp.entity.UsuarioEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UsuarioMapper {

    @Select(value = "SELECT * FROM \"TB_USUARIOS\" WHERE \"USUARIOS\"=#{usuario}")
    @Options(statementType = StatementType.CALLABLE)
    UsuarioEntity obtenerUsuario(String usuario);
}
