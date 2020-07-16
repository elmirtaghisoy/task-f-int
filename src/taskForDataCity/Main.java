package taskForDataCity;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("0 və 1001 araliginda eded daxil edin.");

		String input = sc.nextLine();

		if (!inputChecker(input)) {
			System.out.println(input + " ededine bolunen ilk sade ededlerin cemi -> " + result(input));
		} else {
			main(args);
		}
	}

	private static boolean inputChecker(String input) {
		return inputIsEmpty(input) == false || inputIsNumber(input) == false || inputIsBoundOfRange(input) == false;
	}

	private static boolean inputIsEmpty(String input) {
		if (input.replace(" ", "").length() == 0) {
			System.err.println(
					"Siz boş məlumat daxil etdiniz \nYalniz 0 və 1001 araliginda tam eded daxil ede bilersiniz.");
			return false;
		}
		return true;
	}

	private static boolean inputIsNumber(String input) {
		try {
			Integer.parseInt(input.replace(" ", ""));
		} catch (Exception e) {
			System.err.println(
					"Daxil etdiyinin melumatda ancaq {0,1,2,3,4,5,6,7,8,9} simvollarindan istifade ederek 0 və 1001 araliginda tam eded daxil ede bilersiniz.");
			return false;
		}
		return true;
	}

	private static boolean inputIsBoundOfRange(String input) {
		int operationNumber = Integer.parseInt(input.replace(" ", ""));
		if (operationNumber <= 0 || operationNumber >= 1001) {
			System.err.println("Daxil edilmis " + operationNumber
					+ " ededi gozlenilen araliqda deyil. \nYalniz 0 və 1001 araliginda tam eded daxil ede bilersiniz.");
			return false;
		}
		return true;
	}

	// Bu metod daxilinde serh edilmish setrleri acaraq prosesin backgroundunu gore bilersiniz
	private static int result(String input) {
		int number = Integer.parseInt(input.replace(" ", ""));
		int sum = 0;
		boolean controller = true;
		for (int i = 1; controller; i++) {
			if (isPrimeNumber(i) == true) {
//				System.out.println("eded="+ i);
				sum += i;
//				System.out.println("cem="+sum);
			} else {
				continue;
			}
			if (sum % number == 0) {
				controller = false;
			}
		}
		return sum;
	}

	private static boolean isPrimeNumber(int n) {
		for (int i = 2; i < n; i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}
}
