package org.example1;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//klase qe perdor per te krijuar metodat e ndryshme

public class Student {

    Connection connection = new Connection("jdbc:postgresql://localhost:5432/Dev-Intern",
            "postgres", "Geraldi2004");


    //Krijoni nje metode qe merr ne input nje Map<String,String> koloneTip (ruan emrin e kolones dhe tipin),
    // nje String tableName dhe krijon tabele


    public void krijoTabele(Map<String, String> koloneTip, String tableName) {

        if (connection.connect()) {
            try {
                Statement stat = connection.getConnection().createStatement();

              //te perdor nje list ne menyre qe te hedh te dhenat e iteruara nga Map per krijimn e tabeles

                List<String> kolonat = new ArrayList<>();

                //e perdorur dhe ne ushtrimin ne diten e 2 dev Map.Entry dhe entrySet
                for(Map.Entry<String,String> entry : koloneTip.entrySet()) {

                   String emri = entry.getKey();
                   String kolona =  entry.getValue();
                   kolonat.add(emri + " " + kolona);
                }

                //e gatshme , i bashkon te gjitha vlerat e kolones nga lista duke i ndare me presje , pra kthen shembull :
                // ["emri VARCHAR(100)" , "emri VARCHAR(100)"]  ne query si emri VARCHAR(100) , emri VARCHAR(100)
                String sql = "CREATE TABLE IF NOT EXISTS " + tableName + " (" +
                        String.join(", ", kolonat) +
                        ");";

                stat.executeUpdate(sql);

                System.out.println("Tabela ose u krijua ose ka qene e krijuar ");

            } catch (Exception e) {
                System.out.println("Tabela nuk u krijua");
                e.printStackTrace();
            }

        }else{
            System.out.println("lidhja me databazend deshtoi");
        }
    }
    //ta perdor ne main qe te shikoj tabelen e shfaqur para dhe pas , eshte funksion i krijuar ne detyrat e kaluara
    public void shfaqTabelat() {
        if (connection.connect()) {
            try {
                DatabaseMetaData dbmd = connection.getConnection().getMetaData();
                ResultSet tables = dbmd.getTables(null, null, "%", new String[]{"TABLE"});

                while (tables.next()) {
                    String tableName = tables.getString("TABLE_NAME");
                    System.out.println("Tabelat : " + tableName);

                }
            } catch (SQLException e) {

                e.printStackTrace();
            }
        } else {
            System.out.println("lidhja me databazend deshtoi");
        }
    }


    //Krijoni nje metode qe merr  ne input emrin e tabeles e fshin tabelen
    //Supozojme qe tableName jepet parameter i sakte

    public void fshiTabelen(String tableName){
        if (connection.connect()) {

            try(Statement stat = connection.getConnection().createStatement()){
                String sql = "DROP TABLE IF EXISTS " + tableName + ";";
                stat.executeUpdate(sql);

                //do printohet edhe nese tabela nuk ekziston  por per ta zgjidhur  mund te perdorim ResultSet
                // dhe DataBaseMetaData per te pare
                // nese ajo tabele ekziston ne fillim dhe nese po te vazhdohet me kushtin
                //nje logjike te tille e kam perdorur ne fshirjen e studentit
                System.out.println("Tabela " + tableName+" u fshi");

            }catch(SQLException e){
                e.printStackTrace();

            }

        }



        }

    //Krijoni nje metode qe merr ne input te dhenat e studentit dhe i fut ne tabelen student.
    // i jap si parameter 2 kolonat e para tjerat le te plotesohen si null

    //kontrollin qe studenti ekziston i pavlefshem se mund te kete studente me te njejtin emer :)

    public void shtoStudent(String emri , String emaili) {
        if (connection.connect()) {

            try(Statement stat = connection.getConnection().createStatement()){
                String sql = "INSERT INTO student (emri, emaili) VALUES ('" + emri + "', '" + emaili + "')";
                //me insert e perdor si int

                int rezultati =  stat.executeUpdate(sql);

                if(rezultati>0){
                    System.out.println("Student " + emri + " u shtua");
                }else{
                    System.out.println("Student " + emri + " nuk u shtua");
                }

            }catch(SQLException e){
                e.printStackTrace();

            }

        }
    }

    //Nje metode qe merr te dhenat e studentit nga input id.
    //Ketu bej kontrollin nese id ekziston

    public void printoTeDhenatStudent(String id){

        if(id==null) return;

        if (connection.connect()) {
            try {
                Statement stat = connection.getConnection().createStatement();
                String sql = "SELECT * FROM student WHERE id = '" + id + "'";
                ResultSet result = stat.executeQuery(sql);

                if(result.next()) {

                    System.out.println("Emri  " + result.getString("emri"));
                    System.out.println("Emaili " + result.getString("emaili"));
                    }
                else {
                    System.out.println("Studenti nuk ekziston");
                }


            } catch (SQLException e) {
               e.printStackTrace();
            }
        }


    }

    public void modifikoTeDhenatStudent(String id , String emri , String emaili ) {

        if (connection.connect()) {
            try {
                Statement stat = connection.getConnection().createStatement();
                String sql = "SELECT * FROM student WHERE id = '" + id + "'";
                ResultSet result = stat.executeQuery(sql);

                if(result.next()) {
                //kod i njejte pak a shume me ate siper , ketu do bej update

             String sql1 = "UPDATE student SET emaili = '" + emaili + "', emri = '" + emri + "' WHERE id = '" + id + "'";
                  stat.executeUpdate(sql1);
                  System.out.println("Studenti u modifikua ");
                }
                else {
                    System.out.println("Studenti nuk ekziston");
                }


            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void fshiStudent(String id  ) {

        if (connection.connect()) {
            try {
                Statement stat = connection.getConnection().createStatement();
                String sql = "SELECT * FROM student WHERE id = '" + id + "'";
                ResultSet result = stat.executeQuery(sql);

                if(result.next()) {
                    //kod i njejte pak a shume me ate siper , ketu do bej update

                    String sql1 = "DELETE FROM student  WHERE id = '" + id + "'";
                    stat.executeUpdate(sql1);
                    System.out.println("Studenti u fshi ");
                }
                else {
                    System.out.println("Studenti nuk ekziston");
                }


            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
