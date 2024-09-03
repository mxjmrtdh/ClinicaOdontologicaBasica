package com.rojo.ClinicaOdontologia.service;

import com.rojo.ClinicaOdontologia.entity.Paciente;

import java.util.List;
import java.util.Optional;

public interface IPacienteService {
    Paciente guardarPaciente(Paciente paciente);

    Optional<Paciente> buscarPorId(Integer id);
    List<Paciente> buscarTodos();

    void modificarPaciente(Paciente paciente);

    void eliminarPaciente(Integer id);

    List<Paciente> buscarPorApellidoyNombre(String apellido, String nombre);
    List<Paciente> buscarPorUnaParteApellido(String parte);
}
