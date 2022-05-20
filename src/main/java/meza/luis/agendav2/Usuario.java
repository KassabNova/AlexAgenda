/*
 * Copyright (c) 2022 Nextiva, Inc. to Present.
 * All rights reserved.
 */

package meza.luis.agendav2;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Class Description goes here.
 * Created by ckassab on 20/05/22
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    Integer ID;
    String nombre;
    String apellido;
    String domicilio;
    String telefono;
    String email;
    Date birthdate;
    Integer edad;
    String sexo;

    public int calcularEdad() {
        LocalDate curDate = LocalDate.now();
        LocalDate birthdayLocalDate = this.birthdate
                .toInstant()
                .atZone(ZoneId.systemDefault()).toLocalDate();
        //calculates the difference betwween two dates
        Period period = Period.between(birthdayLocalDate, curDate);

        this.edad = period.getYears();
        return period.getYears();
    }
}
