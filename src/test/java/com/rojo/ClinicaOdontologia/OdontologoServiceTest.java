package com.rojo.ClinicaOdontologia;

import com.rojo.ClinicaOdontologia.entity.Domicilio;
import com.rojo.ClinicaOdontologia.entity.Odontologo;
import com.rojo.ClinicaOdontologia.entity.Paciente;
import com.rojo.ClinicaOdontologia.service.impl.PacienteService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.rojo.ClinicaOdontologia.service.impl.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
@Transactional
public class OdontologoServiceTest {
    static final Logger logger = LoggerFactory.getLogger(OdontologoServiceTest.class);
    @Autowired
    OdontologoService odontologoService;
    Odontologo odontologo;
    Odontologo odontologoDesdeDb;

    @BeforeEach
    void cargarDatos(){
        odontologo = new Odontologo();
        odontologo.setNumeroMatricula(1512);
        odontologo.setApellido("Castra");
        odontologo.setNombre("Mario");
        odontologoDesdeDb = odontologoService.guardarOdontologo(odontologo);
    }

    @Test
    @DisplayName("Testear que un odontologo fue cargado correctamente")
    void caso1(){

        assertNotNull(odontologoDesdeDb.getId());
    }

    @Test
    @DisplayName("Testear que un odontologo pueda acceder por id")
    void caso2(){
        //Dado
        Integer id = odontologoDesdeDb.getId();
        //cuando
        Odontologo odontologoRecuperado = odontologoService.buscarPorId(id).get();
        // entonces
        assertEquals(id, odontologoRecuperado.getId());
    }

    @Test
    @DisplayName("Testear listado de todos los odontologos")
    void ListadoDeTodos(){
        //dado
        List<Odontologo> listaOdontologos;
        //cuando
        listaOdontologos=odontologoService.buscarTodos();
        //entonces
        assertFalse(listaOdontologos.isEmpty());
    }
}
