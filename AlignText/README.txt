CS5001 Practical1 2021.10.1

Author: Yujie Dai

1.Program File Structure
-----------------------------------
<AlignText.class>: Get user input and check validity with main method, and decide align mode.
<Paragraph.class>: Align all paragraphs in required mode according to file input.
<Help.class>: With some helpful method to help checking validity and printing spaces and lines
<FileUtil.class>: Aims to deal with reading a file.

2.My Own Tests
------------------------------------
I added two testing cases in MyTests directory.

1)MoreThanOneSpaces.txt
    This case has multiple blank spaces between two words.
2)SingleWord.txt
    This case has NO more than one word in each paragraph, even zero word in a paragraph.

3.Special Cases 
------------------------------------
1)Multiple blank spaces between two words
    In this case, I use String.split("\\s+") method to split words with multiple spaces, instead of only one blank space.
    This can prevent a space from being treated as a single word.
2)No more than one word in each paragraph
    In this case, I treat the "blank" paragraph as a paragraph still. The truth is that it's not blank at all, it consists a '\n'.
    Besides, if line_length is small enough, there might be a situation that the handhold and signpost can be separated.
3)Input line_length as a negative number or zero or not integer
    In this case, I regard the line_length be invalid, so print "usage: java AlignText file_name line_length [align_mode]"

4.Javadoc
------------------------------------
Javadoc can be seen in .class files. 
I also created the documentations in HTML form, which can be found in doc directory.





