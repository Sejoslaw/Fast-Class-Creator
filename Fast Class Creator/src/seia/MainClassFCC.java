package seia;

import seia.fastclasscreator.ClassCreator;

/**
 * Just for testing.
 * @author Krzysztof "SeiA" Dobrzyñski
 */
public class MainClassFCC 
{
	public static ClassCreator cc = ClassCreator.INSTANCE;
	
	public static void main(String[] args) 
	{
		String s = cc.declareValue("float", "f1", "156f");
		System.out.println(s);
		
		String tmp = cc.declareNewObject("Goat", "goat", new String[]{
				"1",
				cc.createNewObject("Farma", new String[]{"1", "2", "Stefan"}),
				"3"
		});
		System.out.println(tmp);
	}
}
