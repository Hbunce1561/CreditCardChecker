
public class ccFunction {
 public long getFirst(long ccNum, int length) {
		for (int i = 0; i < length -1; i++)
		{
			ccNum /= 10;//concatenate to first digit
		}
		return ccNum;
	}
 	public long getSecond(long ccNum, int length) {
 		for (int i = 1; i < length -1; i++) //conc. to first 2
		{
			ccNum /= 10;
		}
 		return ccNum%10;//remainder 10 to get 2nd digit
 	}
 	public int getLength(long ccNum) {
 		int ccL=0;
 		int temp = 0;
 		while (ccNum != temp) {
 			ccNum /=10;//concat all digits, taking tally of each cycle
 			ccL++;
 		}
 		return ccL;
 	}
 	public int ccType(long fD, long sD, int length) {
 			if(length ==15 && fD ==3) {
 				if (sD == 4 || sD ==7) {
 					return 3;//AMEX
 				}
 			}
 			else if(length == 13 && fD ==4|| length ==16 && fD==4 ) {
 				return 4;//Visa
 			}
 			else if(length == 16 && fD==5) {
 				if(sD == 1||sD ==2 || sD==3 || sD == 4 || sD ==5) {
 					return 5;//MC
 				}
 			}
 				return 0;
 				
 	}
 	public int ccChecksum(long ccNum, int length) {
 		int total = 0;
 		long temp = ccNum;
 		for (int i = 0; i < length; i++)
		{
			ccNum /= 10; //concat once to skip last digit
			if(ccNum%10 *2 > 9) {
				long temp2 = ccNum %10 *2; //multiply out, if more than remainder 10
				temp2 /=10; 
				total += temp2;//add first digit
			}
			else {
 			total += ccNum %10 *2; //remainder 10 if <10
			}
			ccNum /= 10; //concat the cc again to skip 
		}
 		for (int j = 1; j < length; j++) {
 			total+= temp%10; // odd digit, add to total, concat twice
 			temp/=10;
 			temp/=10;
 		}
 		
 		return total;
 	}

}
