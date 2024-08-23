package com.rojo.ClinicaOdontologia.service;

import com.rojo.ClinicaOdontologia.dao.IDao;
import com.rojo.ClinicaOdontologia.model.Odontologo;
import com.rojo.ClinicaOdontologia.model.Paciente;
import com.rojo.ClinicaOdontologia.model.Turno;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurnoService {
    private IDao<Turno> turnoIDao;
    private PacienteService pacienteService;
    private OdontologoService odontologoService;

    public TurnoService(IDao<Turno> turnoIDao, PacienteService pacienteService, OdontologoService odontologoService) {
        this.turnoIDao = turnoIDao;
        this.pacienteService = pacienteService;
        this.odontologoService = odontologoService;
    }

    public Turno guardarTurno(Turno turno){
        Paciente paciente = pacienteService.buscarPorId(turno.getPaciente().getId());
        Odontologo odontologo = odontologoService.buscarPorId(turno.getOdontologo().getId());
        Turno turnoARetornar = null;
        if(paciente!= null && odontologo!= null){
            turno.setPaciente(paciente);
            turno.setOdontologo(odontologo);
            turnoARetornar = turnoIDao.guardar(turno);
        }
        return turnoARetornar;
    }
    public Turno buscarPorId(Integer id){
        return turnoIDao.buscarPorId(id);
    }

    public List<Turno> buscarTodos(){
        return turnoIDao.listarTodos();
    }

    public void modificarTurno(Turno turno){
        turnoIDao.modificar(turno);
    }

    public void eliminarTurno(Integer id){
        turnoIDao.eliminar(id);
    }


}
