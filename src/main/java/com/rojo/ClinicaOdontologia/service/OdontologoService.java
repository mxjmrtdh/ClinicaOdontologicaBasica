package com.rojo.ClinicaOdontologia.service;

import com.rojo.ClinicaOdontologia.dao.IDao;
import com.rojo.ClinicaOdontologia.model.Odontologo;
import com.rojo.ClinicaOdontologia.model.Paciente;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OdontologoService {
    private IDao<Odontologo> odontologoIDao;

    public OdontologoService(IDao<Odontologo> odontologoIDao) {
        this.odontologoIDao = odontologoIDao;
    }

    public Odontologo guardarOdontologo(Odontologo odontologo){
        return odontologoIDao.guardar(odontologo);
    }

    public Odontologo buscarPorId(Integer id){
        return odontologoIDao.buscarPorId(id);
    }

    public List<Odontologo> listarTodos(){
        return odontologoIDao.listarTodos();
    }

    public void modificarOdontologo(Odontologo odontologo){ odontologoIDao.modificar(odontologo); }

    public void eliminarOdontologo(Integer id) { odontologoIDao.eliminar(id);}
}
