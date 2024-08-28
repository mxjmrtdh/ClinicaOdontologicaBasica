package com.rojo.ClinicaOdontologia.service.impl;

import com.rojo.ClinicaOdontologia.entity.Odontologo;
import com.rojo.ClinicaOdontologia.entity.Paciente;
import com.rojo.ClinicaOdontologia.entity.Turno;
import com.rojo.ClinicaOdontologia.repository.ITurnoRepository;
import com.rojo.ClinicaOdontologia.service.IOdontologoService;
import com.rojo.ClinicaOdontologia.service.IPacienteService;
import com.rojo.ClinicaOdontologia.service.ITurnoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurnoService implements ITurnoService {
    private ITurnoRepository turnoRepository;
    private IPacienteService pacienteService;
    private IOdontologoService odontologoService;

    public TurnoService(ITurnoRepository turnoRepository, IPacienteService pacienteService, IOdontologoService odontologoService) {
        this.turnoRepository = turnoRepository;
        this.pacienteService = pacienteService;
        this.odontologoService = odontologoService;
    }

    @Override
    public Turno guardarTurno(Turno turno){
        Optional<Paciente> paciente = pacienteService.buscarPorId(turno.getPaciente().getId());
        Optional<Odontologo> odontologo = odontologoService.buscarPorId(turno.getOdontologo().getId());
        Turno turnoARetornar = null;
        if(paciente.isPresent() && odontologo.isPresent()){
            turno.setPaciente(paciente.get());
            turno.setOdontologo(odontologo.get());
            turnoARetornar = turnoRepository.save(turno);
        }
        return turnoARetornar;
    }

    @Override
    public Optional<Turno> buscarPorId(Integer id){
        return turnoRepository.findById(id);
    }

    @Override
    public List<Turno> buscarTodos(){
        return turnoRepository.findAll();
    }

    @Override
    public void modificarTurno(Turno turno){
        Optional<Paciente> paciente = pacienteService.buscarPorId(turno.getPaciente().getId());
        Optional<Odontologo> odontologo = odontologoService.buscarPorId(turno.getOdontologo().getId());
        if(paciente.isPresent() && odontologo.isPresent()){
            turno.setPaciente(paciente.get());
            turno.setOdontologo(odontologo.get());
            turnoRepository.save(turno);
        }
    }

    @Override
    public void eliminarTurno(Integer id){
        turnoRepository.deleteById(id);
    }
}
