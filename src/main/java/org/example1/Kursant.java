package org.example1;

import lombok.*;

@Builder

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "trajneri") // i bej exclude se ne rast se jo ne moment thirrje ne main do thirret ToString ne cikel
//njehere nga trajneri me pas kursantet e trajnerit e keshtu

public class Kursant {

    private int id ;

    private String name ;

    private String email ;

    private int piket ;

    private Trajner trajneri ;


}
