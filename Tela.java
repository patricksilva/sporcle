import java.util.Scanner;
import java.lang.*;
/**
	This class was a challenge requested on ACADEMIA DO JAVA, ajtf96.
	The main objective was to use arrays and Java's control flow statements.
	@author:	Patrick Alex Freitas da Silva
	@date: 2016-06-23
*/
class Tela {
	
	public static void main(String[] args){
		
		Sporcle jogoSporcle = new Sporcle();
		
		jogoSporcle.startGame();
		
		jogoSporcle.setPlayerName(screenPrompts("Player name: "));
		// String name = getPlayerName();
		System.out.println(jogoSporcle.getPlayerName());
		
	}
		
	static String screenPrompts(String msg) {
		Scanner sc = new Scanner(System.in);
		System.out.print(msg);
		return sc.nextLine();
	}
}