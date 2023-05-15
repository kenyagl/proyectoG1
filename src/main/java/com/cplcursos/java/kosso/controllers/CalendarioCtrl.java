package com.cplcursos.java.kosso.controllers;

import com.cplcursos.java.kosso.MyUserDetails;
import com.cplcursos.java.kosso.entities.Usuario;
import com.cplcursos.java.kosso.repositories.UsuarioRepo;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Controller
@Log4j2
public class CalendarioCtrl {

    @Autowired
    UsuarioRepo usuarioRepository;

    @GetMapping("/calendario")
    public String getCalendarioHTML(Model model,
                                    @RequestParam("day") Optional<Integer> day,
                                    @RequestParam("month") Optional<Integer> month,
                                    @RequestParam("year") Optional<Integer> year,
                                    @AuthenticationPrincipal MyUserDetails userDetails)
    {
        String email = userDetails.getUsername();
        Usuario usuario = usuarioRepository.findByEmail(email);

        model.addAttribute("usuario", usuario);

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

        String monthName = objetoFecha.getMonth().getDisplayName(TextStyle.FULL, Locale.getDefault());
        String capitalizedMonthName = monthName.substring(0, 1).toUpperCase() + monthName.substring(1).toLowerCase();

        model.addAttribute("diaActual", diaActual);
        model.addAttribute("numeroColumnas",numeroColumnas);
        model.addAttribute("month", mes);
        model.addAttribute("monthName", capitalizedMonthName);
        model.addAttribute("year", agno);
        model.addAttribute("dias",dias);
        model.addAttribute("hayPuntos", hayPuntos);

        return "calendario";
    }

    @GetMapping("/calendario-anterior")
public String mostrarMesAnterior(Model model,
                                 @RequestParam("month") int month,
                                 @RequestParam("year") int year) {
    LocalDate fechaActual = LocalDate.of(year, month, 1).minusMonths(1);
    return "redirect:/calendario?month=" + fechaActual.getMonthValue() + "&year=" + fechaActual.getYear();
}

@GetMapping("/calendario-siguiente")
public String mostrarMesSiguiente(Model model,
                                  @RequestParam("month") int month,
                                  @RequestParam("year") int year) {
    LocalDate fechaActual = LocalDate.of(year, month, 1).plusMonths(1);
    return "redirect:/calendario?month=" + fechaActual.getMonthValue() + "&year=" + fechaActual.getYear();
}

    private boolean hayPuntosEnTalDia(LocalDate fecha) {
        return false;
    }

}
