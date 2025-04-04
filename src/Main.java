import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        int[] intArray= {1,2,3};
        String s = null;


        if(s == null){
            System.out.println("object not found (null check med if-sats)");
        }

        try{

            s.toUpperCase();
        }catch (IndexOutOfBoundsException e){
            System.out.println("index out of bounds");
            e.printStackTrace();

        } catch (NullPointerException e){
            System.out.println("object not found");
        } finally {
            System.out.println("detta skrivs alltid ut");

        }

        System.out.println("koden kör vidare...");

        try {
            exceptionGenerator();
        } catch (IOException e) {
            e.printStackTrace();
           throw new RuntimeException(e);
        }

        System.out.println("koden kör vidare...");

    }

    public static void exceptionGenerator() throws IOException{
        System.out.println("jag är jätteavancerad kod som med stor sannolikhet kan gå fel");
        throw new IOException();
    }
}