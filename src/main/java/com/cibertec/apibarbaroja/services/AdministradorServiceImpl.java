package com.cibertec.apibarbaroja.services;

import com.cibertec.apibarbaroja.entities.AdministradorEntity;
import com.cibertec.apibarbaroja.repositories.AdministradoresRepository;
import com.cibertec.apibarbaroja.repositories.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AdministradorServiceImpl extends BaseServiceImpl<AdministradorEntity, Integer> implements AdministradorService{

    @Autowired
    private AdministradoresRepository repo;

    public AdministradorServiceImpl(BaseRepository<AdministradorEntity, Integer> baseRepository) {
        super(baseRepository);
    }

    @Override
    public ResponseEntity<?> loginAdmin(String correo, String pass) {
        try {
            // Buscar el admin por correo
            AdministradorEntity admin = repo.findByCorreo(correo);

            if (admin != null) {
                // Si el admin existe se valida la contraseña.
                if (admin.getPass().equals(pass)) {
                    // Si la contraseña es válida, se devuelve el admin y un mensaje de éxito
                    return ResponseEntity.ok(Map.of(
                            "admin", admin,
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