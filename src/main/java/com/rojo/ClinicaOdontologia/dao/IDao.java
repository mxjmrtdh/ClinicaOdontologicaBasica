package com.rojo.ClinicaOdontologia.dao;

import java.util.List;

public interface IDao<T> {
    T guardar(T t);
    T buscarPorId(Integer id);
    List<T> listarTodos();
    void modificar(T t);
    void eliminar(Integer id);
}
