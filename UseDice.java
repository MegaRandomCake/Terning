package terning;
import java.util.Scanner;

public class UseDice {
	public static void main(String[] args) {
		//rull af 2 terninger, en wingame boolean og en scanner indlæses
		Dice dices = new Dice();
		boolean wingame = false;
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to the diceroll racegame to 40 points.");
		System.out.println("Player 1, please enter a username");
		String p1 = sc.nextLine();
		System.out.println("Player 2, please enter a username");
		String p2 = sc.nextLine();
		//Hele spillet lægges i for-loopet så der kan skiftes i mellem spiller 1 og 2 på en nem måde
		for(double i=1; i<Double.POSITIVE_INFINITY; i++) {
			System.out.println("");
			System.out.println("The current score is: " + p1 + " have " + dices.p1score + " points and " + p2 + " have " + dices.p2score + " points.");
			//Hvis i er ulige køres koden for spiller 1, hvis ikke køres for spiller 2
			if(i%2!=0) {
				System.out.println(p1 + " please enter anything to roll the dice.");
				@SuppressWarnings("unused")
				String tekst = sc.next();
				dices.rollMultiple();
				//Hvis der er slået 2 seksere i forrige kast og spilleren gør det igen, vinder han spillet. Derefter afsluttes programmet.
				if(dices.c==12 && wingame == true) {
					System.out.println("Congratulations " + p1 + " you won the game by rolling 2 sixes twice in a row.");
					i = Double.POSITIVE_INFINITY;
					continue;
				}
				//Hvis spilleren slår 2 ens, tjekker programmet pointscoren. Enten får spilleren et ekstra slag, ellers vinderen spilleren spillet.
				if(dices.a==dices.b) {
					if(dices.p1score>=40) {
						System.out.println("Congratulations " + p1 + " you won the game by rolling 2 of a kind with 40+ points.");
						i = Double.POSITIVE_INFINITY;
					}
					else
						System.out.println("You rolled two of the same, so you get an extra throw.");
					//i-- gør at spilleren får en ekstra tur.
					i--;
				}
				//Scoren bliver lagt til spillerens points.
				dices.p1score += dices.a + dices.b;
				//Der tjekkes efter om spilleren har slået 2 eller 12 i forhold til at miste alle points, eller kommentar i line 25.
				switch(dices.c) {
				case 2:
					System.out.println("You rolled snakeeyes, so you lose all your points.");
					dices.p1score = 0;
					wingame = false;
					break;
				case 12:
					System.out.println("You rolled 12. If you roll 12 in your next roll, you win the game");
					wingame = true;
					break;
				default:
					wingame = false;
					break;
				}
			}
			//Samme kode, men for spiller 2.
			else {
				System.out.println(p2 + " please enter anything to roll the dice.");
				@SuppressWarnings("unused")
				String tekst = sc.next();
				dices.rollMultiple();
				if(dices.c==12 && wingame == true) {
					System.out.println("Congratulations " + p2 + " you won the game by rolling 2 sixes twice in a row.");
					i = Double.POSITIVE_INFINITY;
					continue;
				}
				if(dices.a==dices.b) {
					if(dices.p2score>=40) {
						System.out.println("Congratulations " + p2 + " you won the game by rolling 2 of a kind with 40+ points.");
						i = Double.POSITIVE_INFINITY;
					}
					else
						System.out.println("You rolled two of the same, so you get an extra throw.");
					i--;
				}
				dices.p2score += dices.a + dices.b;
				switch(dices.c) {
				case 2:
					System.out.println("You rolled snakeeyes, so you lose all your points.");
					dices.p2score = 0;
					wingame = false;
					break;
				case 12:
					System.out.println("You rolled 12. If you roll 12 in your next roll, you win the game");
					wingame = true;
					break;
				default:
					wingame = false;
					break;
				}
			}
		}
		sc.close();
	}    
}