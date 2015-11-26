package seia.fastclasscreator.v1;

import java.util.ArrayList;

/**
 * Just for testing.
 * @author Krzysztof "SeiA" Dobrzyñski
 */
public class MainClassFCC 
{
	public static ComponentBodyCreator cc = new ComponentBodyCreator(new ArrayList<String>());
	public static String PATH = "C:\\";
	
	public static void main(String[] args)
	{
		String newVariable = cc.declareNewVariable("float", "f1", "156f");
		System.out.println(newVariable); System.out.println();
		
		String newObject = cc.declareNewObject("Goat", "goat", new String[]{
				"1", cc.createNewObject("Farma", new String[]{"1", "2", "Stefan"}), "3"
		});
		System.out.println(newObject); System.out.println();
		
		String psfi = cc.addPart(KeyWords._public) + 
				cc.addPart(KeyWords._static) + 
				cc.addPart(KeyWords._final) +
				cc.declareNewVariable("int", "var1", "123");
		System.out.println(psfi); System.out.println();
		
		String _if = cc.buildFunction("if", "x == 1", "return 1;");
		System.out.println(_if); System.out.println();
		
		String _void = cc.buildMethod(new String[]{"public", "abstract"}, "void", "getVoid", 
				new String[]{"int x"},
				new String[]{
						cc.buildFunction("if", "x > 0", "return x;")
				});
		System.out.println(_void); System.out.println();
	}
}
