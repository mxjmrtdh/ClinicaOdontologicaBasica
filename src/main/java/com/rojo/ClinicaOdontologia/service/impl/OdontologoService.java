package com.rojo.ClinicaOdontologia.service.impl;

import com.rojo.ClinicaOdontologia.entity.Odontologo;
import com.rojo.ClinicaOdontologia.exception.ResourceNotFoundException;
import com.rojo.ClinicaOdontologia.repository.IOdontologoRepository;
import com.rojo.ClinicaOdontologia.repository.IPacienteRepository;
import com.rojo.ClinicaOdontologia.service.IOdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OdontologoService implements IOdontologoService {
    @Autowired
    private IOdontologoRepository odontologoRepository;

    @Override
    public Odontologo guardarOdontologo(Odontologo odontologo) {
        return odontologoRepository.save(odontologo);
    }

    @Override
    public Optional<Odontologo> buscarPorId(Integer id) {
        Optional<Odontologo> odontologoEncontrado = odontologoRepository.findById(id);
        if(odontologoEncontrado.isPresent()){
            return odontologoEncontrado;
        } else {
            throw new ResourceNotFoundException("Odontologo no encontrado");
        }
    }

    @Override
    public List<Odontologo> buscarTodos() {
        return odontologoRepository.findAll();
    }

    @Override
    public void modificarOdontologo(Odontologo odontologo) {
        odontologoRepository.save(odontologo);
    }

    @Override
    public void eliminarOdontologo(Integer id) {
        Optional<Odontologo> odontologoEncontrado= buscarPorId(id);
        if(odontologoEncontrado.isPresent()){
            odontologoRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Odontologo no encontrado");
        }
    }

    @Override
    public List<Odontologo> buscarPorMatricula(Integer numeroMatricula) {
        return odontologoRepository.findBynumeroMatricula(numeroMatricula);
    }

    @Override
    public List<Odontologo> buscarPorParteNombre(String parteNombre) {
        return odontologoRepository.buscarPorParteNombre(parteNombre);
    }

}
