import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;

public class ExpressionTester {
	public static final String THEDEFAULT = "postFixExpressions.txt";
	/* 
	 * @author WinstanleyA
	 * @Date 3/8/18
	 * @param fNme the name of the file your writing to
	 * @return input a PrintWriter which will be able to write to the file given in fNme
	 */
	public static PrintWriter writer(String fNme) {
		File scannable = new File( fNme );
		PrintWriter input = null;
		try {
			input = new PrintWriter(scannable);
		} catch (FileNotFoundException ex) {
			System.out.println("Cant open file: " + fNme);
			return null;
		}
		return input;
	}
	/* 
	 * @author WinstanleyA
	 * @Date 3/8/18
	 * @param fNme the name of the file you wish to read
	 * @return input a Scanner to read the file you gave as input
	 */
		public static Scanner reader(String fNme) {
		File scannable = new File( fNme );
		Scanner input = null;
		try {
			input = new Scanner(scannable);
		} catch (FileNotFoundException ex) {
			System.out.println("Cant open file: " + fNme);
			return null;
		}
		return input;
	}
		public static ArrayList<String[]> list(Scanner file){
			ArrayList<String[]> output = new ArrayList<String[]>();
			while(file.hasNextLine()) {
				String temp = file.nextLine();
				String[] tempArr = temp.split(" ");
			    output.add(tempArr);
			}
			return output;
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = null;
		PrintWriter output = writer("myAnswers.txt");
		if(args.length>0)
			input = reader(args[0]);
		else
			input = reader(THEDEFAULT);
		Scanner keyboard = new Scanner(System.in);
		while(input == null) {
			System.out.println("Please input a valid file");
			input = reader(keyboard.next());
		}
		keyboard.close();
		ArrayList<String[]> test = list(input);
		for(String[] post: test) {
			ExpressionTree example = new ExpressionTree(post);
			//output.println("Eval from tree");
			output.println(example.evalTree());
			//output.println("Prefix from tree");
			output.println(example.toPrefixNotation());
			//output.println("Infix from tree");
			output.println(example.toInfixNotation());
			//output.println("Postfix from tree");
			output.println(example.toPostfixNotation());
			//output.println("Eval from post");;
			output.println(example.postfixEval(post));
			output.println("");
			output.println("");
		}
		output.close();
		input.close();
		
		
		
	}

}
