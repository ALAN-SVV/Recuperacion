package org.alan.proyectocompraventa.controllers.services;

import org.alan.proyectocompraventa.controllers.models.Categoria;
import org.alan.proyectocompraventa.controllers.repositories.CategoriaRepositoryJdbcImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class CategoriaServiceJdbcImplement implements CategoriaService {

    private CategoriaRepositoryJdbcImpl repositoryJdbc;
    public CategoriaServiceJdbcImplement(Connection conn) {
        this.repositoryJdbc = new CategoriaRepositoryJdbcImpl(conn);
    }
    @Override
    public List<Categoria> listar(){
        try {
            return repositoryJdbc.listar();
        } catch (SQLException throwables) {
            throw new ServiceJdcException(throwables.getMessage(), throwables.getCause());
        }
    }

    @Override
    public Optional<Categoria> porId(Long id){
        try {
            return Optional.ofNullable(repositoryJdbc.porId(id));
        } catch (SQLException throwables) {
            throw new ServiceJdcException(throwables.getMessage(), throwables.getCause());
        }
    }
    @Override
    public void guardar(Categoria categoria) {
        try {
            repositoryJdbc.guardar(categoria);
        } catch (SQLException throwables) {
            throw new ServiceJdcException(throwables.getMessage(), throwables.getCause());
        }
    }

}
