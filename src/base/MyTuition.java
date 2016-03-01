package base;
import java.util.Scanner;
import org.apache.poi.ss.formula.functions.FinanceLib;
public class MyTuition {
	
	public static void main(String[] args) {
		
		// This program calculateS the total cost of tuition to
		// complete a degree and determine the monthly REpayment for your
		// student loan after graduation.

		Scanner input = new Scanner(System.in);

		double initialTuition, percentIncrease,repayTerm,APR;

		System.out.print("Please enter the initial tuition cost:$");
		initialTuition = input.nextDouble();

		System.out.print("Please enter the percentage increases for tuition:");
		percentIncrease = input.nextDouble();

		System.out.print("Please enter the repayment term in years:");
		repayTerm = input.nextDouble();
		
		System.out.print("Please enter the repayment APR:");
		APR = input.nextDouble();
		
		//r is monthly APR rate, n is repay term in months
		//p is initial tuition, f is total tuition
		//y is monthly repayment

		double r,n,p,f,y;
		boolean t;
		double pmf;
		double a = 1 + percentIncrease;
		r = (APR / 12);
		n = repayTerm * 12;
		p = initialTuition;
		f = p + Math.pow(p,a)+Math.pow(p, a*a)+Math.pow(p, a*a*a);
		t = false;
		
		//Use finance library builtin function pmf to calculate total payment
		
		pmf = FinanceLib.pmt(r, n, p, f, t);
		System.out.printf("total of term payment: \n", pmf);

		double FV;
		r = (percentIncrease / 12);
		n = repayTerm * 12;
		p = 0;
		y = pmf / 12;
		t = false;
		
		//use finance library to calculate monthly payment

		FV = FinanceLib.fv(r, n, y, p, t);
		System.out.printf("monthly payment: $%.2f.", FV);

		input.close();

	}

}

