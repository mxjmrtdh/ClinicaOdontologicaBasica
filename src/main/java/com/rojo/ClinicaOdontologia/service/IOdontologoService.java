package com.rojo.ClinicaOdontologia.service;

import com.rojo.ClinicaOdontologia.entity.Odontologo;
import com.rojo.ClinicaOdontologia.entity.Paciente;

import java.util.List;
import java.util.Optional;

public interface IOdontologoService {
    Odontologo guardarOdontologo(Odontologo odontologo);

    Optional<Odontologo> buscarPorId(Integer id);
    List<Odontologo> buscarTodos();

    void modificarOdontologo(Odontologo odontologo);

    void eliminarOdontologo(Integer id);

    List<Odontologo> buscarPorMatricula(Integer numeroMatricula);

    List<Odontologo> buscarPorParteNombre(String parteNombre);
}
