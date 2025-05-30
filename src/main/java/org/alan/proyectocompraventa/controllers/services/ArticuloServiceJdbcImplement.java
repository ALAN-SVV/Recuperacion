package org.alan.proyectocompraventa.controllers.services;

import org.alan.proyectocompraventa.controllers.models.Articulo;
import org.alan.proyectocompraventa.controllers.repositories.ArticuloRepositoryJdbcImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class ArticuloServiceJdbcImplement implements ArticuloService {

    private final ArticuloRepositoryJdbcImpl repository;

    public ArticuloServiceJdbcImplement(Connection conn) {
        this.repository = new ArticuloRepositoryJdbcImpl(conn);
    }

    @Override
    public List<Articulo> listar() {
        try {
            return repository.listar();
        } catch (SQLException e) {
            throw new ServiceJdcException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public Optional<Articulo> porId(Long id) {
        try {
            return Optional.ofNullable(repository.porId(id));
        } catch (SQLException e) {
            throw new ServiceJdcException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public void guardar(Articulo articulo) {
        try {
            repository.guardar(articulo);
        } catch (SQLException e) {
            throw new ServiceJdcException(e.getMessage(), e.getCause());
        }
    }
}
