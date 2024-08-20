package com.rojo.ClinicaOdontologia.service;

import com.rojo.ClinicaOdontologia.dao.IDao;
import com.rojo.ClinicaOdontologia.model.Odontologo;

import java.util.List;

public class OdontologoService {
    private IDao<Odontologo> odontologoIDao;

    public OdontologoService(IDao<Odontologo> odontologoIDao) {
        this.odontologoIDao = odontologoIDao;
    }

    public Odontologo guardarOdontologo(Odontologo odontologo){
        return odontologoIDao.guardar(odontologo);
    }

    public List<Odontologo> listarTodos(){
        return odontologoIDao.listarTodos();
    }
}
