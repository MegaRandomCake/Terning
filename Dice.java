package terning;

public class Dice {
	//rull af en terning
	public int roll() {
		int d1 = (int)(Math.random()*6+1);
		return d1;
	}
	//a og b er de forskellige øjneslag, c er totalværdien
	public int a;
	public int b;
	public int c;
	//roll køres 2 gange og gemmes som a, b og c
	public void rollMultiple() {
		a = roll();
		b = roll();
		c = a + b;
		System.out.println("You rolled: " + a + " and " + b + ", which means you gain " + c + " points.");
		}	
	//Af en eller anden grund kunne jeg ikke bruge p1score og p2score uden at lægge dem her
	public int p1score;
	public int p2score;
	}

