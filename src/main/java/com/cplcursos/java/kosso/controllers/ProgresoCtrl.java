package com.cplcursos.java.kosso.controllers;


import com.cplcursos.java.kosso.entities.RespuestaEjOpMul;
import com.cplcursos.java.kosso.services.RespuestaEjOpMulSrvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/progreso")
public class ProgresoCtrl {
    @Autowired
    RespuestaEjOpMulSrvc respuestaEjOpMulSrvc;
    @GetMapping("/progreso-mensual")
    public String showProgresoMensual(Model model) {
        LocalDateTime currentDate = LocalDateTime.now();
        LocalDateTime startDate = currentDate.minusMonths(1);
        List<RespuestaEjOpMul> agrupaPorMes = respuestaEjOpMulSrvc.getDateRange(startDate, currentDate);
        model.addAttribute("agrupaPorMes", agrupaPorMes);
        return "tuProgreso";
    }

    @GetMapping("/progreso-semanal")
    public String showProgresoSemanal(Model model){
        LocalDateTime currentDate = LocalDateTime.now();
        LocalDateTime startDate = currentDate.minusWeeks(1);
        List<RespuestaEjOpMul> agrupaPorSemana = respuestaEjOpMulSrvc.getDateRange(startDate, currentDate);
        model.addAttribute("agrupaPorSemana", agrupaPorSemana);
        return "tuProgreso";
    }

    @GetMapping("/progreso-diario")
    public String showProgresoDiario(Model model){
        LocalDateTime currentDate = LocalDateTime.now();
        LocalDateTime startDate = currentDate.minusDays(1);
        List<RespuestaEjOpMul> agrupaPorDia = respuestaEjOpMulSrvc.getDateRange(startDate, currentDate);
        model.addAttribute("agrupaPorDia", agrupaPorDia);
        return "tuProgreso";
    }
}