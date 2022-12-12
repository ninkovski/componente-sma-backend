package gob.pe.mp.repository.mapper;

import gob.pe.mp.entity.DepartamentoEntity;
import gob.pe.mp.entity.DistritoEntity;
import gob.pe.mp.entity.ProvinciaEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface UbigeoMapper {

    @Select(value = "SELECT \"ID_DEPARTAMENTO\",\"DESCRIPCION\" "+
            "FROM \"TB_DEPARTAMENTO\"")
    @Options(statementType = StatementType.CALLABLE)
    List<DepartamentoEntity> listarDepartamento();

    @Select(value = "SELECT \"ID_PROVINCIA\",\"DESCRIPCION\" "+
            "FROM \"TB_PROVINCIA\" " +
            "WHERE \"ID_DEPARTAMENTO\"=#{codigoDepartamento}")
    @Options(statementType = StatementType.CALLABLE)
    List<ProvinciaEntity> listarProvincia(@Param("codigoDepartamento") String codigoDepartamento);

    @Select(value = "SELECT \"ID_DISTRITO\",\"DESCRIPCION\" "+
            "FROM \"TB_DISTRITO\" " +
            "WHERE \"ID_PROVINCIA\"=#{codigoProvincia}")
    @Options(statementType = StatementType.CALLABLE)
    List<DistritoEntity> listarDistrito(@Param("codigoProvincia") String codigoProvincia);
}
