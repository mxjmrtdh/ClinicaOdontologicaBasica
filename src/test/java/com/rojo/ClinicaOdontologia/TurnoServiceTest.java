package com.rojo.ClinicaOdontologia;

import com.rojo.ClinicaOdontologia.dto.request.TurnoRequestDto;
import com.rojo.ClinicaOdontologia.dto.response.TurnoResponseDto;
import com.rojo.ClinicaOdontologia.entity.Odontologo;
import com.rojo.ClinicaOdontologia.entity.Turno;
import com.rojo.ClinicaOdontologia.service.impl.OdontologoService;
import com.rojo.ClinicaOdontologia.service.impl.TurnoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
@Transactional
public class TurnoServiceTest {
    static final Logger logger = LoggerFactory.getLogger(TurnoServiceTest.class);
    @Autowired
    TurnoService turnoService;
    TurnoRequestDto turno;
    TurnoResponseDto turnoDesdeDb;

    @BeforeEach
    void cargarDatos(){
        turno = new TurnoRequestDto();
        turno.setPaciente_id(1);
        turno.setOdontologo_id(1);
        turno.setFecha("2024-11-11");
        turnoDesdeDb = turnoService.guardarTurno(turno);
    }

    @Test
    @DisplayName("Testear que un turno fue cargado correctamente")
    void caso1(){
        assertNotNull(turnoDesdeDb.getId());
    }

    @Test
    @DisplayName("Testear que un turno pueda acceder por id")
    void caso2(){
        //Dado
        Integer id = turnoDesdeDb.getId();
        //cuando
        TurnoResponseDto turnoRecuperado = turnoService.buscarPorId(id).get();
        // entonces
        assertEquals(id, turnoRecuperado.getId());
    }

//    @Test
//    @DisplayName("Testear listado de todos los turnos")
//    void ListadoDeTodos(){
//        //dado
//        List<turno> listaTurno;
//        //cuando
//        listaTurnos=odontologoService.buscarTodos();
//        //entonces
//        assertFalse(listaOdontologos.isEmpty());
//    }
}