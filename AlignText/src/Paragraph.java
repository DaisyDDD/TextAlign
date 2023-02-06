import java.util.ArrayList;

/**
 * This is a paragraph class for aligning text
 * 
 * @author Yujie Dai
 * @version 1
 * @since 24/09/2021
 */
public class Paragraph {

	/**
	 * Variable length is for required width from input, Array paragraphs is for
	 * storing text paragraphs
	 */
	int length;
	String[] paragraphs;

	/**
	 * A constructor to set values
	 * 
	 * @param paragraphs: Text paragraphs
	 * @param length:     Required width from input
	 */
	public Paragraph(String[] paragraphs, int length) {
		this.length = length;
		this.paragraphs = paragraphs;
	}

	/**
	 * A method to make left align
	 * 
	 */
	public void leftAlign() {

		for (String str : paragraphs) {
			// Dealing with paragraphs one by one
			// Split words with spaces and make them up to a line in required width
			// Finally print each line out.
			String[] words = str.split("\\s+");
			String line = "";

			for (int i = 0; i < words.length; i++) {
				line = "";

				if (words[i].length() >= length) {
					line = words[i];
					System.out.println(line);
				} else {
					for (int j = i;; j++) {
						line = line + words[j] + " ";

						if (j + 1 == words.length) {
							System.out.println(line);
							break;

						}
						if (line.length() + words[j + 1].length() > length) {
							System.out.println(line);
							break;

						}
						i++;

					}

				}

			}
		}

	}

	/**
	 * A method to make right align
	 * 
	 */
	public void rightAlign() {

		for (String str : paragraphs) {
			// Dealing with paragraphs one by one
			// Split words with spaces and make them up to a line in required width
			// Finally print spaces needed before printing each line out.
			String[] words = str.split("\\s+");
			String line = "";

			for (int i = 0; i < words.length; i++) {
				line = "";

				if (words[i].length() >= length) {
					line = words[i];
					System.out.println(line);
				} else {
					for (int j = i;; j++) {

						if (j + 1 == words.length) {// the last word

							line = line + words[j];
							Help.fillBlanks(length - line.length());// print blanks before line
							System.out.println(line);
							break;

						} else {
							if (line.length() + words[j].length() + words[j + 1].length() + 1 > length) {

								line = line + words[j];

								Help.fillBlanks(length - line.length());// print blanks before line
								System.out.println(line);
								break;

							} else {
								line = line + words[j] + " ";
							}
						}

						i++;

					}

				}
			}

		}

	}

	/**
	 * A method to make center align
	 * 
	 */
	public void centerAligh() {

		for (String str : paragraphs) {
			// Dealing with paragraphs one by one
			// Split words with spaces and make them up to a line in required width
			// Finally print needed spaces before and after printing each line .
			String[] words = str.split("\\s+");
			String line = "";

			for (int i = 0; i < words.length; i++) {
				line = "";

				if (words[i].length() >= length) {
					line = words[i];
					System.out.println(line);
				} else {
					for (int j = i;; j++) {

						if (j + 1 == words.length) {// the last word
							line = line + words[j];
							if ((length - line.length()) % 2 == 0) {
								Help.fillBlanks((length - line.length()) / 2);// print blanks before line
								System.out.print(line);
								Help.fillBlanks((length - line.length()) / 2);// print blanks after line
							} else {
								Help.fillBlanks((length - line.length() + 1) / 2);// print blanks before line
								System.out.print(line);
								Help.fillBlanks((length - line.length() - 1) / 2);// print blanks after line
							}
							System.out.println();
							break;

						} else {
							if (line.length() + words[j].length() + words[j + 1].length() + 1 > length) {
								line = line + words[j];
								if ((length - line.length()) % 2 == 0) {
									Help.fillBlanks((length - line.length()) / 2);// print blanks before line
									System.out.print(line);
									Help.fillBlanks((length - line.length()) / 2);// print blanks after line
								} else {
									Help.fillBlanks((length - line.length() + 1) / 2);// print blanks before line
									System.out.print(line);
									Help.fillBlanks((length - line.length() - 1) / 2);// print blanks after line
								}
								System.out.println();
								break;

							} else {
								line = line + words[j] + " ";
							}

						}
						i++;

					}

				}
			}

		}

	}

	/**
	 * A method to make signpost align
	 * 
	 */
	public void signPost() {

		int max = length - 4;// record the biggest width for text
		ArrayList<String> line = new ArrayList<String>();// record lines
		ArrayList<String> allLines = new ArrayList<String>();// store all lines in whole paragraphs
		String arrLine = "";
		int numberOfLine = 0;// record the line number(index of line)
		Boolean flag = true; // record whether it's the first paragraph

		for (String str : paragraphs) {
			// Dealing with paragraphs one by one
			// Split words with spaces and make them up to a line in required width
			// Store all lines in a arrayList
			// Finally, print the arrayList
			String[] words = str.split("\\s+");
			line.clear();
			numberOfLine = 0;
			for (int i = 0; i < words.length; i++) {
				arrLine = "";

				if (words[i].length() >= max) {
					max = words[i].length();
					arrLine = words[i];
					line.add(arrLine);
					allLines.add(line.get(numberOfLine));
					numberOfLine++;
				} else {
					for (int j = i;; j++) {
						arrLine = arrLine + words[j] + " ";

						if (j + 1 == words.length) {
							line.add(arrLine);
							allLines.add(line.get(numberOfLine));
							numberOfLine++;
							break;

						}
						if (arrLine.length() + words[j + 1].length() > length - 4) {
							line.add(arrLine);
							allLines.add(line.get(numberOfLine));
							numberOfLine++;
							break;

						}
						i++;

					}

				}

			}

		}
		Help.printSignLine(allLines, max, length, flag);
		flag = false;

		Help.printHandholding();

	}
}