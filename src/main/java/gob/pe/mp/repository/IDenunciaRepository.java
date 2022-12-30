package gob.pe.mp.repository;

import gob.pe.mp.entity.DenunciaEntity;

import java.util.List;

public interface IDenunciaRepository {

    List<DenunciaEntity> listar(Integer idAlerta);
}
