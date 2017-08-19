/* Obligatorisk oppgave 7: Bomstasjon
* Andreas Klausen
* Det skal lages et program for analyse av data
* Fra en bomstasjon.
* Dataene skal leses fra fil og resultatene skal skrives til fil
* etter at de er behandlet
*
*Pga. et telleverk som ikke fungerer fungerer ikke programmet som det skal.
* Alle komponenter utenom dette fungerer, derfor leverer jeg i håp om å få tilbakemelding alikevel.
*/

import static java.lang.System.*;
import static java.lang.Integer.*;
import static javax.swing.JOptionPane.*;
import java.io.*;
import java.util.*;

public class AKOblig7 {
  public static void main(String[] args) {

  	//deklarering av varibaler
  	String okMelding = "Filavlesing vellykket.";
  	Scanner leser = null;
  	PrintWriter skriver = null;
  	
  	try {
	  	// Brukeren oppgir navnet på filen som skal leses
		  	String filnavn = showInputDialog("Oppgi filnavn for avlesing:");
		    File fil = new File(filnavn);
		  	leser = new Scanner(fil);

	  	//Teller totalt antall registeringer
	  	//Prøvde å fjerne sum, men da sluttet denne å fungere
		  	int sum = 0;
		  	int antall = 0;
		  	while ( leser.hasNextInt()) {
		  		sum += leser.nextInt();
		  		antall++;
		  	}
		  	leser.close();

		//DENNE FUNGERER IKKE, MEN DEN skal egentlig telle antallet av hver forekomst.
		int [] antReg = new int[antall];
		//while (leser.hasNextInt())

			for for (int i=0;i<antReg[i]; leser.nextInt()); {
				antReg[i] = leser.nextInt();
			}
		

		//telletabell
		int [] antallAv = new int [5];
		for (int i=0; i<antall; i++)
			antallAv[antReg[i]] ++;

	  	//Skrive data til res[dato].txt
			skriver = new PrintWriter("res"+ filnavn +".txt");
				for (int i=0; i<5; i++)
				skriver.println(i + ": " +  " (" + antallAv[i] + ")");
				skriver.println(Min.skrivTegn('-', 10));
				skriver.println("Sum: " + antall);
	}

	catch (NumberFormatException e) {
		okMelding = "Feil format på inndatafilen.";
	}

	catch (Exception e) {
		okMelding = "problemer med summeringen.";
		
	}

	finally {
		//lukking av leser og skriver
			if (leser != null)
				leser.close();
			if (skriver != null)
				skriver.close();
	}

	out.println(okMelding);


	}
}