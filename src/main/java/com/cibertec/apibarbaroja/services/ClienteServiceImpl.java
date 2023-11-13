package com.cibertec.apibarbaroja.services;

import com.cibertec.apibarbaroja.entities.ClienteEntity;
import com.cibertec.apibarbaroja.repositories.BaseRepository;
import com.cibertec.apibarbaroja.repositories.ClienteRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ClienteServiceImpl extends BaseServiceImpl<ClienteEntity, Integer> implements ClienteService{

    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteServiceImpl(BaseRepository<ClienteEntity, Integer> baseRepository) {
        super(baseRepository);
    }

    @Override
    public ResponseEntity<?> loginCliente(String correo, String pass) {
        try {
            // Buscar el cliente por correo
            ClienteEntity cliente = clienteRepository.findByCorreo(correo);

            if (cliente != null) {
                // Si el cliente existe se valida la contraseña.
                if (cliente.getPass().equals(pass)) {
                    // Si la contraseña es válida, se devuelve el cliente y un mensaje de éxito
                    return ResponseEntity.ok(Map.of(
                            "cliente", cliente,
                            "mensaje", "Inicio de sesión exitoso"
                    ));
                } else {
                    // Si la contraseña es incorrecta se devuelve otro mensaje
                    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Contraseña incorrecta");
                }
            } else {
                // Si el correo no existe se envia el mensaje de error correspondiente
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Correo no encontrado");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}