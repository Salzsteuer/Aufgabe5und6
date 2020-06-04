package de.hfu;

/**
* Hello world!
*
*/
import java.util.Scanner;

public class App {

public static void main(String[] args) {


Scanner scanner = new Scanner(System.in);



System.out.println("Geben Sie Ihre Zeichenkette ein:");
String eingabe = scanner.nextLine();

scanner.close();

System.out.println("Ihre Zeichenkette in Großbuchstaben:");


System.out.println(eingabe.toUpperCase());
}
}