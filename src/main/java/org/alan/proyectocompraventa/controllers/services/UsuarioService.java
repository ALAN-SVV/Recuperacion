package org.alan.proyectocompraventa.controllers.services;

import org.alan.proyectocompraventa.controllers.models.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    List<Usuario> listar();
    Optional<Usuario> porId(Long id);
    void guardar(Usuario usuario);
}
