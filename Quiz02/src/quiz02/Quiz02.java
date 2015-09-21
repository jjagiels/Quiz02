package quiz02;
/**
 * 
 * @author Justin Jagielski
 * @version 1.0
 * 
 *
 */

import java.util.Scanner;
import org.apache.poi.ss.formula.functions.FinanceLib;

public class Quiz02 {
	public static void main(String[] args){
		//Begin declaring variables
		double tuition = 0;
		double incTuition, plusTuition, yrTuition;
		double loanAPR = 0;
		int yrPay = 0;
		double monthPay = 0;
		//End declaring variables
		
		Scanner inp = new Scanner(System.in);
		
		System.out.print("What is the Tuition for year 1?: "); //User input for initial tuition
		tuition = inp.nextInt();
		yrTuition = tuition;
		
		for(int i = 0; i<=2; i++){ //Asks the user for each year's tuition increase, then adds the increased tuition to the total tuition
			System.out.printf("What is the percent increase (whole number) for year %d?: ", i+2);
			incTuition = inp.nextInt();
			plusTuition = tuition * (incTuition/100);
			yrTuition = plusTuition + yrTuition;
			tuition = yrTuition + tuition;
		}
		System.out.print("What is the APR for your loan?: "); //Asks for the APR
		loanAPR = (inp.nextInt()/100);
		
		System.out.print("How many years will it take to pay this loan off?: "); //Asks for the number of years before paying off the loan.
		yrPay = inp.nextInt();
		
		monthPay = FinanceLib.pmt(loanAPR/12, yrPay*12, 0, tuition, false);
		
		System.out.printf("After four years of college, you will owe $%1.2f. In order to pay it off, you need to pay the bank $%1.2f a month.", tuition, -monthPay);
	}
}
