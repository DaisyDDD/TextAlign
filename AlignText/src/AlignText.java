/**
 * This is a class with main method for aligning text
 * 
 * @author Yujie Dai
 * @version 1
 * @since 24/09/2021
 */
public class AlignText {

	/**
	 * Get user input, check validity and decide align method according to input
	 * 
	 * @param args[0]: filename. args[1]: expected length. args[3]: align ways
	 */
	public static void main(String[] args) {

		Boolean isValid = Help.checkValid(args); // check whether input args is valid or not

		if (isValid) {
			// If valid, get file text & required width (and align method)
			String[] paragraphs = FileUtil.readFile(args[0]);
			int len = Integer.valueOf(args[1]);
			String alignWay = "";

			if (args.length == 2) {// Default to be left align
				alignWay = "L";
			} else
				alignWay = args[2];

			// Call different align method according to user input
			Paragraph para = new Paragraph(paragraphs, len);
			if (alignWay.equals("L")) {
				para.leftAlign();
			} else if (alignWay.equals("R")) {
				para.rightAlign();
			} else if (alignWay.equals("C")) {
				para.centerAligh();
			} else if (alignWay.equals("S")) {
				para.signPost();
			} else {// invalid align method
				System.out.println("usage: java AlignText file_name line_length [align_mode]");
			}
		}

	}
}
