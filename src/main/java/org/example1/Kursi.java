package org.example1;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data


public class Kursi {

    @NonNull
    private String  emri ;

    @NonNull
    private String  kohezgjatja ;


    @NonNull
    private Trajner trajner ;

    @NonNull
    private Kursant kursanti  ;



}
