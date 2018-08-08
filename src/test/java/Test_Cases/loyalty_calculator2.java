package Test_Cases;

import java.text.DecimalFormat;
import java.util.Scanner;

import org.testng.annotations.Test;

public class loyalty_calculator2 {

	public double meal_price;
	public double VAT = 5;

	public double commision_percentage;
	public double baseprice;
	public double loyality_amount;
	public double loyality_points;

	public double commision;
	public double meal_vat;

	@Test
	public void calculate_loyalty_markup() throws InterruptedException {

		Scanner scan = new Scanner(System.in);
		System.err.print("Enter meal price :");

		Thread.sleep(1000);

		meal_price = scan.nextInt();

		System.err.print("Enter commission % :");

		Thread.sleep(1000);

		commision_percentage = scan.nextInt();

		meal_vat = (meal_price * 100) / (100 + commision_percentage);

		DecimalFormat df = new DecimalFormat("#.##");
		Double v = new Double(meal_vat);
		String b = df.format(v);
		System.out.println("meal+vat:" + " " + b + " " + "AED");

		Thread.sleep(1000);

		baseprice = (meal_vat * 100) / (100 + VAT);

		DecimalFormat df2 = new DecimalFormat("#.##");
		Double v2 = new Double(baseprice);
		String b2 = df.format(v2);

		System.out.println("baseprice:" + " " + b2 + " " + "AED");

		loyality_amount = (2 * baseprice) / 100;

		Double La = new Double(baseprice);
		String b21 = df.format(La);

		System.out.println("loyality_amount :" + " " + b21);
		Thread.sleep(1000);

		loyality_points = loyality_amount * 100;

		System.err.println("loyality_points :" + " " + Math.round(loyality_points));

	}

}