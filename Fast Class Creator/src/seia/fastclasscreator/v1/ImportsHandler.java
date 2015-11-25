package seia.fastclasscreator.v1;

import java.util.List;

public class ImportsHandler 
{
	public List<String> importsList;
	
	public ImportsHandler(List<String> imports)
	{
		this.importsList = imports;
	}
	
	/**
	 * @param path -> import path <br> e.g.:  <br> addImport("java.util.List");
	 */
	public void addImport(String path)
	{
		String _import = KeyWords._import + " " + path + ";";
		importsList.add(_import);
	}
}
