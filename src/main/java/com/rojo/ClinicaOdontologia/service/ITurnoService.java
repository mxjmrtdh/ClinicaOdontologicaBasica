package com.rojo.ClinicaOdontologia.service;

import com.rojo.ClinicaOdontologia.dto.request.TurnoModifyDto;
import com.rojo.ClinicaOdontologia.dto.request.TurnoRequestDto;
import com.rojo.ClinicaOdontologia.dto.response.TurnoResponseDto;
import com.rojo.ClinicaOdontologia.entity.Turno;

import java.util.List;
import java.util.Optional;

public interface ITurnoService {
    TurnoResponseDto guardarTurno(TurnoRequestDto turnoRequestDto);

    Optional<TurnoResponseDto> buscarPorId(Integer id);
    List<TurnoResponseDto> buscarTodos();

    void modificarTurno(TurnoModifyDto turnoModifyDto);

    void eliminarTurno(Integer id);
    Optional<TurnoResponseDto> buscarTurnosPorPaciente(String pacienteApellido);
}
