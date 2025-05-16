package org.example1;


import lombok.*;

import java.util.List;


@Data   // krijon getter seeter  argsconstructor  , equals hashcode  , to string
@Builder  //krijimi i objekteve me i thjeshte

@ToString(exclude = "kursantet" )   // kur gjenerohet to string emaili perjshatohet pra "i fshehte"
@NoArgsConstructor
@AllArgsConstructor


public class Trajner {

    private int id;
    private String name;
    private String email;

    @Singular("Kursant") //kur te bejme build na lejon te shtojme nje nga nje kursant , zak perdorett ne lista dhe map
    private List<Kursant> kursantet;

}

