package com.cplcursos.java.kosso.controllers;

import com.cplcursos.java.kosso.entities.EjercicioOpMul;
import com.cplcursos.java.kosso.entities.RespuestaEjOpMul;
import com.cplcursos.java.kosso.services.EjerciciosSrvc;
import com.cplcursos.java.kosso.services.RespuestaEjOpMulSrvc;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.time.temporal.IsoFields;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Log4j2
@Controller
@RequestMapping("/progreso")
public class ProgresoCtrl {

    // Dependency injection
    @Autowired
    RespuestaEjOpMulSrvc respuestaEjOpMulSrvc;
    @Autowired
    EjerciciosSrvc ejerciciosSrvc;
    // TODO import voto and pregunta(foro) dependencies, it should be preferably be a service to follow same implementation logic of other entities

    // Points per action
    final static int puntosEjercicio = 100;
    final static int puntosPreguntaForo = 10;
    final static int puntosRespuestaForo = 25;
    final static int puntosUpVote = 25;

    // Set maximum for progress bars
    final static int progressBarEjercicioMax = 2000;
    final static int progressBarPreguntaForoMax = 0;
    final static int progressBarRespuestaMax = 0;
    final static int progressBarUpMax = 0;

    // Returns a list with all respuestas
    @GetMapping(value = {"/", ""})
    public String showAllProgreso (Model model){
        model.addAttribute("respuestas", respuestaEjOpMulSrvc.findAll());
        return "respuesta";
    }

    // Returns a view of respuestas grouped by month, day and year with no reference to current day (could be used for general statics)
    @GetMapping("/progress")
    public String showProgress(Model model) {
        // Retrieve data from database
        List<EjercicioOpMul> ejercicios = ejerciciosSrvc.findAll();
        List<RespuestaEjOpMul> respuestas = respuestaEjOpMulSrvc.findAll();

        // Calculate the number of ejercicios and respuestas
        int numeroEjercicios = ejercicios.size();
//        int numeroRespuestas = respuestas.size();

        // Calculate the number of respuestas by month, week and day
        // This shows the progress by month in general with no reference to current date

        // Create a HashMap with <respuestaByDateRange, counter>
        Map<String, Integer> respuestasByMonth = new HashMap<>();
        Map<String, Integer> respuestasByWeek = new HashMap<>();
        Map<String, Integer> respuestasByDay = new HashMap<>();
        for (RespuestaEjOpMul respuesta : respuestas) {
            String month = respuesta.getFechaRespuesta().getMonth().toString();
            String week = respuesta.getFechaRespuesta().getYear() + "-Semana: " + respuesta.getFechaRespuesta().get(IsoFields.WEEK_OF_WEEK_BASED_YEAR);
            String day = respuesta.getFechaRespuesta().toString().substring(0, 10);
            respuestasByMonth.put(month, respuestasByMonth.getOrDefault(month, 0) + 1);
            respuestasByWeek.put(week, respuestasByWeek.getOrDefault(week, 0) + 1);
            respuestasByDay.put(day, respuestasByDay.getOrDefault(day, 0) + 1);
        }
        // Calculate the percentages of responses for each time period (returns the number of answers by dateRange as a percentage
        // Of the total number of answers)

        for (Map.Entry<String, Integer> entry : respuestasByMonth.entrySet()) {
            entry.setValue(entry.getValue() * puntosEjercicio);
        }
        for (Map.Entry<String, Integer> entry : respuestasByWeek.entrySet()) {
            entry.setValue(entry.getValue() * puntosEjercicio);
        }
        for (Map.Entry<String, Integer> entry : respuestasByDay.entrySet()) {
            entry.setValue(entry.getValue() * puntosEjercicio);
        }

        // Add the data to the model
        model.addAttribute("progressBarEjercicioMax", progressBarEjercicioMax);
        model.addAttribute("respuestasByMonth", respuestasByMonth);
        model.addAttribute("respuestasByWeek", respuestasByWeek);
        model.addAttribute("respuestasByDay", respuestasByDay);

        return "progress";
    }

    // Returns a view of progress with reference to the current month, day and week
    @GetMapping("/usuario-progress")
    public String showUsuarioProgress(Model model) {

        // Retrieve all RespuestaEjOpMul entities
        List<RespuestaEjOpMul> respuestas = respuestaEjOpMulSrvc.findAll();

        // Calculate progress for current month, week, and day
        LocalDateTime now = LocalDateTime.now();
        int currentMonth = now.getMonthValue();
        int currentWeek = now.get(IsoFields.WEEK_OF_WEEK_BASED_YEAR);
        int currentDay = now.getDayOfMonth();
        int totalAnswersThisMonth = 0;
        int totalAnswersThisWeek = 0;
        int totalAnswersToday = 0;
        for (RespuestaEjOpMul respuesta : respuestas) {
            LocalDateTime fechaRespuesta = respuesta.getFechaRespuesta();
            if (fechaRespuesta.getMonthValue() == currentMonth) {
                totalAnswersThisMonth++;
            }
            if (fechaRespuesta.get(IsoFields.WEEK_OF_WEEK_BASED_YEAR) == currentWeek) {
                totalAnswersThisWeek++;
            }
            if (fechaRespuesta.getDayOfMonth() == currentDay) {
                totalAnswersToday++;
            }
        }
        totalAnswersThisMonth*= puntosEjercicio;
        totalAnswersThisWeek*= puntosEjercicio;
        totalAnswersToday*= puntosEjercicio;


        // Add progress data to model
        model.addAttribute("progressBarEjercicioMax", progressBarEjercicioMax);
        model.addAttribute("totalAnswersThisMonth", totalAnswersThisMonth);
        model.addAttribute("totalAnswersThisWeek", totalAnswersThisWeek);
        model.addAttribute("totalAnswersToday", totalAnswersToday);

        return "usuario-progress";
    }
}