package eu.prochazkaml.semestralka;
import java.util.Scanner;

public class soupisky {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.printf("Zadejte kladné celé číslo, které mám zkontrolovat: ");

		String input = sc.nextLine();

		sc.close();

		if(!input.matches("^[1-9][0-9]*$")) { // začíná 1-9, může následovat libovolný počet číslic
			System.out.printf("Zadaná hodnota není platné celé číslo.\n");
			return;
		}

		String soupiska = generovatSoupisku(input);

		System.out.printf("Soupiska čísla " + input + " je " + soupiska + ".\n");
		
		System.out.printf("Číslo " + input + " \033[1m%s\033[0m zápisem své soupisky.\n", input.equals(soupiska) ? "je" : "není");
	}

	private static String generovatSoupisku(String input) {
		int[] cislice = new int[10];

		for(int i = 0; i < input.length(); i++) {
			int id = input.charAt(i) - 48; // ASCII '0'

			if(id < 0 || id > 9) {
				System.out.printf("Zavolejte do Oraclu, že jim nefungují regulární výrazy. Narazil jsem totiž na kritickou chybu, které měl regex zabránit.\n");
				return "";
			}

			cislice[id]++;
		}

		String out = "";

		for(int i = 0; i < 10; i++) {
			if(cislice[i] > 0) {
				out += String.valueOf(cislice[i]) + String.valueOf(i);
			}
		}

		return out;
	}
}
