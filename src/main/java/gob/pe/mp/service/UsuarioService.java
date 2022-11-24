package gob.pe.mp.service;

import gob.pe.mp.api.LoginApiDelegate;
import gob.pe.mp.entity.UsuarioEntity;
import gob.pe.mp.model.LoginDataResponse;
import gob.pe.mp.model.LoginRequest;
import gob.pe.mp.model.LoginResponse;
import gob.pe.mp.model.Metadata;
import gob.pe.mp.repository.impl.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements LoginApiDelegate {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public ResponseEntity<LoginResponse> login(LoginRequest request) {
        UsuarioEntity usuarioEntity = usuarioRepository.validarInicioSesion(request.getUsuario());

        boolean isInicioSesionCorrecta =
                usuarioEntity != null && usuarioEntity.getClave().equals(request.getClave());

        LoginDataResponse loginDataResponse = new LoginDataResponse();
        loginDataResponse.setEstado(isInicioSesionCorrecta);

        Metadata metadata = new Metadata();
        metadata.setStatus(HttpStatus.OK.value());
        metadata.setMessage("El proceso fue exitoso.");

        LoginResponse response = new LoginResponse();
        response.setMetadata(metadata);
        response.setData(loginDataResponse);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
