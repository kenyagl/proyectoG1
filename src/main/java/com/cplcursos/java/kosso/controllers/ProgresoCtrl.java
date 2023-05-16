package com.cplcursos.java.kosso.controllers;

import com.cplcursos.java.kosso.MyUserDetails;
import com.cplcursos.java.kosso.entities.EjercicioOpMul;
import com.cplcursos.java.kosso.entities.PuntosForo;
import com.cplcursos.java.kosso.entities.RespuestaEjOpMul;
import com.cplcursos.java.kosso.services.EjerciciosSrvc;
import com.cplcursos.java.kosso.services.PuntosForoSrvc;
import com.cplcursos.java.kosso.services.RespuestaEjOpMulSrvc;
import com.cplcursos.java.kosso.services.UsuarioSrvcImpl;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.DateFormatSymbols;
import java.time.LocalDateTime;
import java.time.temporal.IsoFields;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
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
    @Autowired
    PuntosForoSrvc puntosForoSrvc;
    @Autowired
    UsuarioSrvcImpl usuarioSrvc;

    // Points per action
    final static int puntosEjercicio = 100;
//    final static int puntosPreguntaForo = 10;
//    final static int puntosRespuestaForo = 25;

    // Set maximum value for progress bars
    int progressBarEjercicioMax = 0;
//    int progressBarPreguntaForoMax = 0;
//    int progressBarRespuestaMax = 0;

    // Returns a list with all respuestas
    @GetMapping(value = {"/", ""})
    public String showAllProgreso(Model model) {
        model.addAttribute("respuestas", respuestaEjOpMulSrvc.findAll());
        return "progreso/respuesta";
    }

    // Returns a view of respuestas grouped by month, day and year with no reference to current date (could be used for general statics)
    @GetMapping("/progress")
    public String showProgress(Model model, @AuthenticationPrincipal MyUserDetails userDetails) {

        // Retrieve data from database
        List<EjercicioOpMul> ejercicios = ejerciciosSrvc.findAll();
        List<RespuestaEjOpMul> respuestas = respuestaEjOpMulSrvc.findAll();

        // Calculate the number of ejercicios and respuestas
        int numeroEjercicios = ejercicios.size();
        int numeroRespuestas = respuestas.size();

        // Calculate the number of respuestas by month, week and day
        // This shows the progress by month in general with no reference to current date

        // Create a HashMap with <respuestaByDateRange, counter>
        Map<String, Integer> respuestasByMonth = new HashMap<>();
        Map<String, Integer> respuestasByWeek = new HashMap<>();
        Map<String, Integer> respuestasByDay = new HashMap<>();

        // Create a DateFormatSymbols object with Spanish locale
        DateFormatSymbols dfs = new DateFormatSymbols(new Locale("es", "ES"));

        for (RespuestaEjOpMul respuesta : respuestas) {
            // Retrieve the array of month names in Spanish
            String[] monthNames = dfs.getMonths();

            // Get the month number as an integer
            int monthNumber = respuesta.getFechaRespuesta().getMonthValue();

            // Retrieve the corresponding month name in Spanish from the array
            String monthEs = monthNames[monthNumber - 1];
            String month = StringUtils.capitalize(monthEs);

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

        progressBarEjercicioMax = (numeroEjercicios * puntosEjercicio);

        // Add the data to the model
        model.addAttribute("progressBarEjercicioMax", progressBarEjercicioMax);
        model.addAttribute("respuestasByMonth", respuestasByMonth);
        model.addAttribute("respuestasByWeek", respuestasByWeek);
        model.addAttribute("respuestasByDay", respuestasByDay);
        model.addAttribute("usuario", usuarioSrvc.findByAuth(userDetails));

        return "progreso/progress";
    }

    // Returns a view of progress with reference to the current month, day and week
    @GetMapping("/usuario-progress")
    public String showUsuarioProgress(Model model, @AuthenticationPrincipal MyUserDetails userDetails) {

        // Retrieve data from database
        List<EjercicioOpMul> ejercicios = ejerciciosSrvc.findAll();
        List<RespuestaEjOpMul> respuestas = respuestaEjOpMulSrvc.findAll();

        // Calculate the number of ejercicios and respuestas
        int numeroEjercicios = ejercicios.size();
        int numeroRespuestas = respuestas.size();

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
        totalAnswersThisMonth *= puntosEjercicio;
        totalAnswersThisWeek *= puntosEjercicio;
        totalAnswersToday *= puntosEjercicio;
        progressBarEjercicioMax = (numeroEjercicios * puntosEjercicio);


        // Add progress data to model
        model.addAttribute("progressBarEjercicioMax", progressBarEjercicioMax);
        model.addAttribute("totalAnswersThisMonth", totalAnswersThisMonth);
        model.addAttribute("totalAnswersThisWeek", totalAnswersThisWeek);
        model.addAttribute("totalAnswersToday", totalAnswersToday);
        model.addAttribute("usuario", usuarioSrvc.findByAuth(userDetails));

        return "progreso/usuario-progress";
    }
/*    @GetMapping("/usuario-progress/{dia}/{mes}/{ano}")
    public String showProgresoDia(Model model, @PathVariable("dia") int dia, @PathVariable("mes") int mes, @PathVariable("ano") int ano){
        // Calcular/leer el progreso para la fecha indicada

        // modelo a utilizar
        return "usuario/usuario";
    }*/
}