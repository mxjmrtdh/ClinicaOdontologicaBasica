package com.rojo.ClinicaOdontologia.controller;

import com.rojo.ClinicaOdontologia.model.Paciente;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.rojo.ClinicaOdontologia.service.PacienteService;

@Controller
public class PacienteController {
    private PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @GetMapping("/prueba")
    public String buscarPaciente(Model model, @RequestParam Integer id){
        Paciente paciente = pacienteService.buscarPorId(id);

        model.addAttribute("nombre", paciente.getNombre());
        model.addAttribute("apellido", paciente.getApellido());
        return "index";
    }
}
