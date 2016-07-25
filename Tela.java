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
		
	}
	
	/**
	  * @author		Patrick Alex - patrickalex@gmail.com
	  * @version	0.1, 07/24/2016
	  * @param		msg		A string containing the message to be printed on the default output right before calling keyboard reading.
	  * @return		void
	  * @throws/@exception (since javadoc 1.2)
	  * @since		0.1
	  */
	public String screenPrompts(String msg) {
		Scanner sc = new Scanner(System.in);
		System.out.print(msg);
		return sc.nextLine();
	}
	
	public void showMessage(String msg){
		System.out.println(msg);
		return;
	}
}