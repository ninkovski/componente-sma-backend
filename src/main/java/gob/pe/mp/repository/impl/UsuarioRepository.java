package gob.pe.mp.repository.impl;

import gob.pe.mp.entity.UsuarioEntity;
import gob.pe.mp.repository.IUsuarioRepository;
import gob.pe.mp.repository.mapper.UsuarioMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UsuarioRepository implements IUsuarioRepository {

    @Autowired
    private UsuarioMapper usuarioMapper;

    @Override
    public UsuarioEntity validarInicioSesion(String usuario) {
        return usuarioMapper.obtenerUsuario(usuario);
    }
}
