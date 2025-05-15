package org.example1;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/Dev-Intern";
        String user = "postgres";
        String password = "Geraldi2004";



        Connection connection = new Connection(url , user , password) ;

        boolean lidhja =  connection.connect() ;

        System.out.println("Lidhur me Databazen : " + lidhja);


        Student student = new Student() ;

//
        Map<String, String> koloneTip = new HashMap<>();
        koloneTip.put("id", "SERIAL PRIMARY KEY");
        koloneTip.put("emri", "VARCHAR(50)");
        koloneTip.put("mosha", "INTEGER");

       String tableName = "tabeleNgaJava";
//
        student.shfaqTabelat();
        student.krijoTabele(koloneTip , tableName);
        student.shfaqTabelat();

        student.fshiTabelen("tabeleNgaJava");
        student.shtoStudent("Lolo" , "Lol");
        student.printoTeDhenatStudent("6");


        student.modifikoTeDhenatStudent("6" , "rafael" , "hello@outlook.com");
        student.printoTeDhenatStudent("6");

        student.fshiStudent("6");
        student.printoTeDhenatStudent("6");

    }
}
