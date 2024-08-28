package com.rojo.ClinicaOdontologia.controller;

import com.rojo.ClinicaOdontologia.entity.Odontologo;
import com.rojo.ClinicaOdontologia.entity.Paciente;
import com.rojo.ClinicaOdontologia.service.IOdontologoService;
import com.rojo.ClinicaOdontologia.service.impl.OdontologoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/odontologo")
public class OdontologoController {
    private IOdontologoService odontologoService;

    public OdontologoController(IOdontologoService odontologoService) {
        this.odontologoService = odontologoService;
    }

    //POST
    @PostMapping("/guardar")
    public ResponseEntity<Odontologo> guardarOdontologo(@RequestBody Odontologo odontologo){
        return ResponseEntity.ok(odontologoService.guardarOdontologo(odontologo));
    }

    //PUT
    @PutMapping("/modificar")
    public ResponseEntity<String> modificarOdontologo(@RequestBody Odontologo odontologo){
        Optional<Odontologo> odontologoEncontrado=odontologoService.buscarPorId(odontologo.getId());
        if(odontologoEncontrado.isPresent()){
            odontologoService.modificarOdontologo(odontologo);
            String jsonResponse = "{\"mensaje\": \"El odontologo fue modificado\"}";
            return ResponseEntity.ok(jsonResponse);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    //DELETE
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarOdontologo(@PathVariable Integer id){
        Optional<Odontologo> odontologoEncontrado= odontologoService.buscarPorId(id);
        if(odontologoEncontrado.isPresent()){
            odontologoService.eliminarOdontologo(id);
            String jsonResponse = "{\"mensaje\": \"El odontologo fue eliminado\"}";
            return ResponseEntity.ok(jsonResponse);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //GET
    @GetMapping("/buscar/{id}")
    public ResponseEntity<Odontologo> buscarPorId(@PathVariable Integer id){
        Optional<Odontologo> odontologo = odontologoService.buscarPorId(id);
        if(odontologo.isPresent()){
            return ResponseEntity.ok(odontologo.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //GET
    @GetMapping("/listarTodos")
    public ResponseEntity<List<Odontologo>> buscarTodos(){
        return ResponseEntity.ok(odontologoService.buscarTodos());
    }
}
