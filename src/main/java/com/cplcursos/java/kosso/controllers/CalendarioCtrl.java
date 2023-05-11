package com.cplcursos.java.kosso.controllers;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@Log4j2
public class CalendarioCtrl {

    @GetMapping("/calendario")
    public String getCalendarioHTML(Model model,
                                    @RequestParam("day") Optional<Integer> day,
                                    @RequestParam("month") Optional<Integer> month,
                                    @RequestParam("year") Optional<Integer> year)
    {
        boolean hayPuntos = false;
        LocalDate fechaActual = LocalDate.now();
        int diaActual = fechaActual.getDayOfMonth();

        int numeroColumnas = 7;
        int mes = fechaActual.getMonthValue();
        int agno = fechaActual.getYear();
        int dia = fechaActual.getDayOfMonth();


        int totalDias;
        if(month.isPresent())
        {
            mes=month.get();
        }

        if(year.isPresent())
        {
            agno=year.get();
        }


        List<List<String>> dias = new ArrayList<>();

        LocalDate objetoFecha = LocalDate.of(agno, mes, dia);

        totalDias = objetoFecha.lengthOfMonth();

        int fila=-1;
        for(int i = 1; i<= totalDias; i++)
        {
            LocalDate fechaEnUso = LocalDate.of(agno, mes, i);
            if( fechaEnUso.getDayOfWeek().ordinal() == 0 || fila==-1)
            {
                fila+=1;
                List<String> semana = new ArrayList<>();
                dias.add(semana);

                if(fila==0)
                {
                    for (int j=0;j<fechaEnUso.getDayOfWeek().ordinal(); j++)
                    {
                        dias.get(fila).add("");
                    }
                }

            }
            if (hayPuntosEnTalDia(fechaEnUso)) {
                hayPuntos = true;
            }
            dias.get(fila).add(String.valueOf(i));
        }

        model.addAttribute("diaActual", diaActual);
        model.addAttribute("numeroColumnas",numeroColumnas);
        model.addAttribute("dias",dias);
        model.addAttribute("hayPuntos", hayPuntos);

        return "calendario";
    }

    private boolean hayPuntosEnTalDia(LocalDate fecha) {
        return false;
    }

}
