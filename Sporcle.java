import java.util.Scanner;
import java.lang.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
/**
	This class was a challenge requested on ACADEMIA DO JAVA, ajtf96.
	The main objective was to use arrays and Java's control flow statements.
	@author:	Patrick Alex Freitas da Silva
	@date: 2016-06-23
*/
class Sporcle {
	
	@Getter @Setter(AccessLevel.PROTECTED) private String playerName;
	Tela tela = new Tela();
	
	@Getter private String[] keywordArray = {
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
	String[] triesArray = new String[keywordArray.length];
	@Getter private int mistakes = 0;
	@Getter private int hits = 0;
	Cronometro cronometro = new Cronometro();
	
	/**
	  * @author		Patrick Alex - patrickalex@gmail.com
	  * @version	0.1, 07/24/2016
	  * @param
	  * @return		void
	  * @throws/@exception (since javadoc 1.2)
	  * @since		0.1
	  */
	public void startGame() {
		
		this.tela.showMessage(this.makeWelcome());
		this.tela.showMessage(this.showGameDescription());
		this.setPlayerName(this.tela.screenPrompts("PlayerName: "));
		this.tela.showMessage(this.showLevel01Description());
		this.tela.showMessage(this.showTotalWords());
		this.tela.showMessage(this.playerName + ", good luck!");
		
		this.cronometro.startChronometer();
		int i = 0;
		while( this.playCondition() ){
			this.evalTry(this.readTry(i));
			this.cronometro.checkPoint();
			this.giveFeedback();
			i++;
		}
		
		this.endGame();
		return;
	}
	
	private String makeWelcome(){
		return "Welcome to sporcle game!";
	}
	
	private String showGameDescription(){
		return "In this game you try to get right as many words as you can.";
	}
	
	private String showLevel01Description(){
		return "Level 1\nTime left: " + this.cronometro.minutesLeft() + " minutes";
	}
	
	private String showTotalWords(){
		return "Total words to get right: " + this.keywordArray.length;
	}
	
	private String readTry(final int i){
		return this.tela.screenPrompts("Try " + (i+1) + ": ");
	}
	
	private void evalTry(final String nTry){
		boolean wordFound = false;
		for(int j = 0; j < this.keywordArray.length; j++) {
			if (nTry != null & nTry.equals(this.keywordArray[j]) & !nTry.equals(this.triesArray[j])){
				this.triesArray[j] = nTry;
				this.addaHit();
				wordFound = true;
			}
		}
		if( wordFound ){
			wordFound = false;
		} else {
			this.addaMistake();
		}
		return;
	}
	
	private void giveFeedback(){
		this.tela.showMessage(this.toString());
		this.tela.showMessage("Hits: " + this.getHits());
		this.tela.showMessage("Mistakes: " + this.getMistakes());
		this.tela.showMessage("Eleapsed time: " + this.cronometro.getEleapsedTime());
		return;
	}
	
	/*
	 * Prints words tried in 10 x 5 (columns x lines)
	 */
	public String toString(){
		String result = "";
		for(int j = 0; j < this.keywordArray.length; j++){ 
			result += ( (triesArray[j] == null)?("----"):(triesArray[j]) ) + "\t";
			if( (j+1) % 10 == 0 )
				result += "\n";
		}
		return result;
	}
	
	private void addaMistake(){
		this.mistakes++;
	}
	
	private void addaHit(){
		this.hits++;
	}
	
	private boolean playCondition(){
		return this.hits < this.keywordArray.length & !this.cronometro.ringingAlarm();
	}
	private void endGame(){
		if(this.hits == this.keywordArray.length)
			this.tela.showMessage(this.playerName + " YOU WIN! You got all the " + 
								this.keywordArray.length + " words in less than " +
								this.cronometro.minutesLeft() + " minutes.");
		else
			this.tela.showMessage("YOU LOST");
		this.tela.showMessage("Play again?");
	}
}
