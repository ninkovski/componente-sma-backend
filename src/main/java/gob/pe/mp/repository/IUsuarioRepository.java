package gob.pe.mp.repository;

import gob.pe.mp.entity.UsuarioEntity;

public interface IUsuarioRepository {

    UsuarioEntity validarInicioSesion(String usuario);
}
