import java.util.Scanner;
import java.lang.Math;

public class Binary {

	Scanner keyboard = new Scanner(System.in);
	String input = "";
	String inputType = "";
	int decimal = 0;
	String hexadecimal = "";
	String binary = "";
	String reverseBinary = "";
	int charToAdd = 0;
	String reverseHex = "";
	int toBeHex = 0;
	byte cp = 0;

	public void getInputs() {
		System.out.println("Please select input type: ");
		inputType = keyboard.next();
		System.out.println("Please input your number: ");
		input = keyboard.next();
		inputType = inputType.toLowerCase();
		inputType = inputType.replaceAll("\\s", "");
		input = input.replaceAll("\\s", "");
	}

	public void cp() {
		cp += 1;
		System.out.println("Checkpoint " + cp);
	}

	public void failGraceful() {
		try {
			Integer.parseInt("this should fail");
		} catch (NumberFormatException e) {
			System.out.println("Invalid Variable. Please re-run program and try again.");
			System.exit(0);
		}
	}

	public boolean checkType() {
		if (inputType.equals("binary")) {
			if (isBinary())
				return isBinary();
			else
				failGraceful();
		} else if (inputType.equals("hexadecimal")) {
			if (isHexadecimal())
				return isHexadecimal();
			else
				failGraceful();
		} else if (inputType.equals("decimal")) {
			if (isDecimal())
				return isDecimal();
			else
				failGraceful();
		} else
			return false;
		return false;
	}

	public boolean isBinary() {
		for (int i = input.length() - 1; i >= 0; i--) {
			if (input.charAt(i) == '1' || input.charAt(i) == '0') {
			} else {
				return false;
			}
		}
		return true;
	}

	public boolean isDecimal() {
		try {
			Integer.parseInt(input);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

	public boolean isHexadecimal() {
		for (int i = input.length() - 1; i > 0; i--) {
			if (input.charAt(i) == 'A' || input.charAt(i) == 'B'
					|| input.charAt(i) == 'C' || input.charAt(i) == 'D'
					|| input.charAt(i) == 'E' || input.charAt(i) == 'F'
					|| input.charAt(i) == '1' || input.charAt(i) == '2'
					|| input.charAt(i) == '3' || input.charAt(i) == '4'
					|| input.charAt(i) == '5' || input.charAt(i) == '6'
					|| input.charAt(i) == '7' || input.charAt(i) == '8'
					|| input.charAt(i) == '9' || input.charAt(i) == '0') {
				return true;
			} else
				return false;
		}
		return true;
	}

	public void binaryReverse() {
		reverseBinary = "";
		for (int i = input.length() - 1; i >= 0; i--) {
			reverseBinary = reverseBinary + input.charAt(i);
		}
	}

	public void hexReverse() {
		for (int i = hexadecimal.length() - 1; i >= 0; i--) {
			reverseHex = reverseHex + hexadecimal.charAt(i);
		}
		hexadecimal = reverseHex;
	}

	public String c2Decimal() {
		binaryReverse();
		if (inputType.equals("binary")) {
			for (int x = 0; x < input.length(); x++) {
				if (reverseBinary.charAt(x) == '1') {

					decimal = decimal + (int) (Math.pow(2, x));
				} else {
				}
			}
		} else if (inputType.equals("hexadecimal")) {
			for (int y = 0; y < input.length(); y++) {
				int z = input.length() - 1 - y;
				if (input.charAt(z) != 'A' && input.charAt(z) != 'B'
						&& input.charAt(z) != 'C' && input.charAt(z) != 'D'
						&& input.charAt(z) != 'E' && input.charAt(z) != 'F') {
					decimal = decimal
							+ Integer.parseInt(("" + input.charAt(z)));
				} else if (input.charAt(z) == 'A')
					charToAdd = 10;
				else if (input.charAt(z) == 'B')
					charToAdd = 11;
				else if (input.charAt(z) == 'C')
					charToAdd = 12;
				else if (input.charAt(z) == 'D')
					charToAdd = 13;
				else if (input.charAt(z) == 'E')
					charToAdd = 14;
				else if (input.charAt(z) == 'F')
					charToAdd = 15;
				decimal = decimal + (charToAdd * (int) Math.pow(16, y));
			}
		} else
			decimal = Integer.parseInt(input); // if the type isnt binary or
												// hexadecimal
		return ""+(decimal);
	}

	public char newHex(int nhex) {
		if (nhex == 10)
			return 'A';
		else if (nhex == 11)
			return 'B';
		else if (nhex == 12)
			return 'C';
		else if (nhex == 13)
			return 'D';
		else if (nhex == 14)
			return 'E';
		else if (nhex == 15)
			return 'F';
		else
			failGraceful();
		return 'Z';
	}

	public String c2Hexadecimal() {
		c2Decimal();
		int tempDec = decimal;
		for (int x = (int) decimal; x > 0; x = x / 16) {
			toBeHex = tempDec % 16;
			if (toBeHex > 9)
				hexadecimal = hexadecimal + "" + newHex(toBeHex);
			else
				hexadecimal = hexadecimal + "" + toBeHex;

			tempDec = tempDec / 16;
		}
		hexReverse();
		return ""+(hexadecimal);
	}

	public void reverseBinary() {
		reverseBinary = "";
		for (int i = binary.length() - 1; i >= 0; i--) {
			reverseBinary = reverseBinary + binary.charAt(i);
		}
	}

	public String c2Binary() {
		c2Decimal();
		for (int i = (int) decimal; i >= 0; i = (int) i / 2) {
			if (i % 2 == 0) {
				binary += "0";
			} else if (i % 2 == 1) {
				binary += "1";
			} else {
				failGraceful();
			}
			if (i == 0) {
				i = -5;
			}
		}
		reverseBinary();
		return ""+(reverseBinary);
	}
}