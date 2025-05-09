package DIta3Dev;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {


        //Shkruaj nje funksion qe krijon nje file data.txt dhe shkruan nje input nga perdoruesi ne te.

        // shkrujNeFile();

        // lexoRreshtaFile();
        //lexoRreshtatNjeherazi();
//        numeroRreshtat();
//        pjestoNumrat(4,0);

//        validateNumber(18) ;
        ushtrimi6();

    }


    public static void shkrujNeFile() {
        try {
            FileWriter file = new FileWriter("C:\\Users\\USER\\IdeaProjects\\Dev-Internship\\src\\DIta3Dev\\data.txt", true);
            // per tmos i bere override e bej append true
            Scanner input = new Scanner(System.in);

            while (true) {
                String rreshti = input.nextLine();
                if (rreshti.trim().isEmpty()) {
                    file.close();
                    break;
                }
                file.write(rreshti + " , ");

            }

        } catch (IOException e) {

            throw new RuntimeException(e);


        }
    }


    public static void lexoRreshtaFile() {

        try {
            Scanner sc = new Scanner(new FileReader("C:\\Users\\USER\\IdeaProjects\\Dev-Internship\\src\\DIta3Dev\\data.txt"));

            while (sc.hasNextLine()) {
                String rreshtat = sc.nextLine();
                System.out.println(rreshtat);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void lexoRreshtatNjeherazi() {

        Path filePath = Paths.get("C:\\Users\\USER\\IdeaProjects\\Dev-Internship\\src\\DIta3Dev\\data.txt");

        try {
            List<String> rreshtat = Files.readAllLines(filePath);
            System.out.println(rreshtat);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Shkruani nje funksion qe lexon nj file dhe numeron sa rrjeshta permban

    public static void numeroRreshtat(){
        int count = 0 ;
        try {

            Scanner sc = new Scanner(new FileReader("C:\\Users\\USER\\IdeaProjects\\Dev-Internship\\src\\DIta3Dev\\data.txt"));

            while (sc.hasNextLine()) {
                sc.nextLine() ;
                count++ ;
            }
            System.out.println("Numri i rrehstave eshte : " + count );
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    //Krijo nje metode qe pjeston dy numra. Nese emeruesi eshte 0, kap ArithmeticException
    //dhe printo nje mesazh informues.

    public static void pjestoNumrat(int nr1 , int nr2){

        try {
            int heresi = nr1/nr2 ;
            System.out.println(" rezultati i pjestimit " + heresi);
        }catch(ArithmeticException e ){
            e.printStackTrace();
        }

    }

    //Krijo nje metode validateNumber(int number) qe hedh IllegalArgumentException nese
    //number eshte me pak se 20.

    public static void validateNumber (int number) {
        if (number < 20) {
            throw new IllegalArgumentException("Numri te jete me i madh se 20 ");
        }
        System.out.println("numri eshte ne rregull ");
    }
     /*
     Lexon nje file.
    b. Merr nje numer nga perdoruesi.
    c. Ben nje operacion matematikor me te.
    d. Trajto 3 gabime te mundshme:
    e. File nuk ekziston.
    f. Input i pavlefshem (InputMismatchException).
    g. Pjestim me zero
      */
    public static void ushtrimi6(){
        File file = new File("testFile1.txt");

        try {
            if (file.createNewFile()) {
                System.out.println("File is created!");
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            InputStream f = new FileInputStream(file);
            int size = f.available() ; //kthen nr e byteve qe do lexohen

            for(int i = 0 ; i<size ; i++){
                f.read()  ;
            }
            System.out.println("File u lexua");
            f.close();

        }catch(FileNotFoundException e ){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }

        try {
            Scanner sc = new Scanner(System.in) ;
            System.out.println("Vendos 2 numra per te kryer pjestimin : " );
            int nr1 = sc.nextInt();
            int nr2 = sc.nextInt();
            pjestoNumrat(nr1 , nr2);

        } catch (InputMismatchException e ){
            e.printStackTrace();
        }


    }














}
