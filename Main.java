import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		ccFunction c1 = new ccFunction();
		boolean loop = true;// loop to keep trying
		while (loop == true) {
			System.out.println("Enter a CC Number: ");
			long cc = input.nextLong(); //get CC num
			int length = c1.getLength(cc);
			if (length >16 || length <13) {
				System.out.println("Invalid"); //exit condi if too long/short
				}
			else {
			int total = c1.ccChecksum(cc, length);	//check for valid card
			if(total %10!= 0) {
				System.out.println("Invalid");
			}
			else {
				long fD = c1.getFirst(cc, length); //card type check
				long sD = c1.getSecond(cc, length);
				int cardType = c1.ccType(fD, sD, length);
				if(cardType == 0) {
					System.out.println("Invalid");
				}
				else {
					System.out.println("Card Number: " +cc);
					System.out.print("Type: ");
					switch (cardType) {
					case 3:
						System.out.print("AMEX\n"); 
						break;
					case 4:
						System.out.print("VISA\n");
						break;
					case 5: 
						System.out.print("MASTER\n");
						break;
					}
				}
			}
			
	}
		}
	}
}
