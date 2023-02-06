import java.util.ArrayList;

/**
 * This is a help class for accomplishing some auxiliary functions
 * 
 * @author Yujie Dai
 * @version 1
 * @since 24/09/2021
 */
public class Help {

	/**
	 * A variable created to record the max width for text
	 */
	public static int max;

	/**
	 * Attempts to check the validity of input.
	 * 
	 * @param args: User input array
	 * @return Check whether the input is valid or not.If it's valid, returns true.
	 *         Otherwise, returns false.
	 */
	public static Boolean checkValid(String[] args) {
		if (args.length <= 1 || args.length > 3) {
			System.out.println("usage: java AlignText file_name line_length [align_mode]");
			return false;
		} else if (isInt(args[1])) {
			return true;
		} else {
			System.out.println("usage: java AlignText file_name line_length [align_mode]");
			return false;
		}

	}

	/**
	 * Attempts to check the validity of input align width.
	 * 
	 * @param str: User input width
	 * @return Check whether the input is a positive integer or not.If it's, returns
	 *         true. Otherwise, returns false.
	 */
	public static Boolean isInt(String str) {
		try {
			int i = Integer.parseInt(str);

			if (i > 0) {
				return true;
			} else {
				return false;
			}

		} catch (NumberFormatException e) {
			return false;
		}

	}

	/**
	 * Attempts to print spaces.
	 * 
	 * @param number: Number of spaces that need to print
	 */
	public static void fillBlanks(int number) {

		for (int i = 0; i < number; i++) {
			System.out.print(" ");
		}
	}

	/**
	 * Attempts to print lines in required width for signpost align and upper part
	 * of signpost.
	 * 
	 * @param line:   Lines formed with required number of words and spaces
	 * @param max:    The max width for the text part
	 * @param length: Required width by user input
	 * @param flag:   aims to check whether it's the first line(if true, print the
	 *                upper part)
	 *
	 */
	public static void printSignLine(ArrayList<String> line, int max, int length, Boolean flag) {
		Help.max = max;

		if (flag == true) {// print the up signpost
			System.out.print(" ");
			for (int i = 0; i < max + 2; i++) {
				System.out.print("_");
			}
			System.out.println(" ");

			System.out.print("/");
			for (int i = 0; i < max + 2; i++) {
				System.out.print(" ");
			}
			System.out.println("\\");

		}

		for (int i = 0; i < line.size(); i++) {// print the whole text by lines

			String str = line.get(i);

			System.out.print("| ");
			System.out.print(line.get(i));
			for (int j = 0; j < max - str.length(); j++) {
				System.out.print(" ");
			}
			if (str.length() == max + 1) {
				System.out.println("|");
			} else {
				System.out.println(" |");
			}

		}

	}

	/**
	 * Attempts to print lower part of signpost.
	 * 
	 */
	public static void printHandholding() {

		System.out.print("\\");
		for (int i = 0; i < max + 2; i++) {// print the down signpost
			System.out.print("_");
		}
		System.out.println("/");

		System.out.println("        |  |");
		System.out.println("        |  |");
		System.out.println("        L_ |");
		System.out.println("       / _)|");
		System.out.println("      / /__L");
		System.out.println("_____/ (____)");
		System.out.println("       (____)");
		System.out.println("_____  (____)");
		System.out.println("     \\_(____)");
		System.out.println("        |  |");
		System.out.println("        |  |");
		System.out.println("        \\__/");

	}

}
