import java.util.Scanner;
import java.lang.*;
/**
	This class was a challenge requested on ACADEMIA DO JAVA, ajtf96.
	The main objective was to use arrays and Java's control flow statements.
	@author:	Patrick Alex Freitas da Silva
	@date: 2016-06-23
*/
class Sporcle {
	public static void main(String[] args) {
		
		boolean wordFound = false;
		int maxLength = 0;
		int nWords = 0;
		int hits = 0;
		int mistakes = 0;
		long clockStart = 0L;
		long clockNow = 0L;
		long timeLimit = 300000L;
		String playerName = "";
		String tryN = "";
		String[] triesArray = new String[50];
		String[] keywordArray = {
			"abstract","assert","boolean","break","byte","case",
			"catch","char","class","const","continue","default",
			"do","double","else","enum","extends","final","finally",
			"float","for","goto","if","implements","import",
			"instanceof","int","interface","long","native","new",
			"package","private","protected","public","return",
			"short","static","strictfp","super","switch","synchronized",
			"this","throw","throws","transient","try","void","volatile",
			"while"
		};
		
		System.out.println("Welcome to sporcle game!");
		System.out.println("In this game you try to get right as many words as you can.");
		playerName = getPlayerName();
		
		System.out.println("Level 1");
		System.out.println("Time left: 5 minutes");

		nWords = keywordArray.length;
		System.out.println("Total words to get right: " + nWords);
		
		// Begin clock
		clockStart = System.currentTimeMillis();
		
		int i = 0;
		while( (clockNow - clockStart ) <= timeLimit ){
			clockNow = System.currentTimeMillis();
			tryN = prompt("Try " +  (i+1)  + ": ");
			// Checks if the time is up
			if ((clockNow - clockStart ) > timeLimit )
				break;
			// Checks tries
			for(int j = 0; j < nWords; j++) {
				if (tryN != null & tryN.equals(keywordArray[j]) & !tryN.equals(triesArray[j])){
					triesArray[j] = tryN;
					hits++;
					wordFound = true;
				}
				
				// Prints words tried in 10 x 5 (columns x lines)
				System.out.print( 
					( (triesArray[j] == null)?("----"):(triesArray[j]) ) + "\t" 
				);
				if( (j+1) % 10 == 0 )
					System.out.println();
			}
			if( wordFound ){
				wordFound = false;
			} else {
				mistakes += 1;
			}
			System.out.println(String.format("\tHits: %s\tMistakes: %s\tEleapsed time: %s", hits, mistakes, ((clockNow - clockStart) * .001)));
			i++;
		}
		if(hits == nWords)
			System.out.println(String.format("%s YOU WIN! You got all the %s words in less than 5 minutes", playerName, nWords));
		else
			System.out.println(String.format("%s, do you want to play again?", playerName));
	}
	
	static String getPlayerName(){
		return prompt("Player name: ");
	}
	
	static String prompt(String msg) {
		Scanner sc = new Scanner(System.in);
		System.out.print(msg);
		return sc.nextLine();
	}
	
	static int getMaxLength(String[] array){
		int L = 0;
		for(String item : array){
			L = (item.length() > L) ? item.length() : L;
		}
		return L;
	}
	
}