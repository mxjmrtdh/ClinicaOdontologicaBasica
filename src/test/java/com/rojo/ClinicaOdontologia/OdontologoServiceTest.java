package com.rojo.ClinicaOdontologia;

import com.rojo.ClinicaOdontologia.dao.impl.DaoH2Odontologo;
import com.rojo.ClinicaOdontologia.model.Odontologo;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.rojo.ClinicaOdontologia.service.OdontologoService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class OdontologoServiceTest {
    static final Logger logger = LoggerFactory.getLogger(OdontologoServiceTest.class);
    OdontologoService odontologoService = new OdontologoService(new DaoH2Odontologo());

    @BeforeAll
    static void crearTablas(){
        Connection connection = null;
        try {
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection("jdbc:h2:./ClinicaOdontologica;INIT=RUNSCRIPT FROM 'CrearTablasBD.sql'", "sa", "sa");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                logger.error(e.getMessage());
            }
        }
    }

    @Test
    @DisplayName("Testear listado de todos los odontologos")
    void ListadoDeTodos(){
        //dado
        List<Odontologo> listaOdontologos;
        //cuando
        listaOdontologos=odontologoService.listarTodos();
        //entonces
        assertFalse(listaOdontologos.isEmpty());
    }
}
