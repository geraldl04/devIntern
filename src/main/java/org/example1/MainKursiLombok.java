package org.example1;

import java.util.List;

public class MainKursiLombok {

    public static void main(String[] args) {

    // meqe kemi te bejme me circular dependency te krijojme kursant dhe trajner dhe me pas te perdorim set
        //se nuk e bejme dot direkt .Trajner pa u krijuar me perpara dhe anasjelltas
        Kursant geri = Kursant.builder()
                .id(3)
                .name("Geri")
                .email("geri@gmail.com")
                .piket(95)
                .build();

        Kursant mila = Kursant.builder()
                .id(4)
                .name("Mila")
                .email("mila@gmail.com")
                .piket(88)
                .build();

        Trajner endra = Trajner.builder()
                .id(1)
                .name("Endra")
                .email("endra@gmail.com")
                .Kursant(geri)
                .Kursant(mila)
                .build();


        Kursi  internship = new Kursi(
                "Java ",
                "3 muaj",
                endra,
                geri
        );



        geri.setTrajneri(endra);
        mila.setTrajneri(endra);

        System.out.println(endra);
        System.out.println(geri);

        System.out.println(endra.getKursantet());
        System.out.println(geri.getTrajneri());

        System.out.println("Kursi:");
        System.out.println(internship );


    }
}
