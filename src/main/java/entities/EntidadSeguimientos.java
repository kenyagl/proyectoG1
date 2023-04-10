package entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class EntidadSeguimientos {

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Entity
    @Table(name = "Seguimientos")
    public class Seguimientos {
        @Id
        Long idSigueA;
        @Id
        Long idSeguidoPor;

    }





}

