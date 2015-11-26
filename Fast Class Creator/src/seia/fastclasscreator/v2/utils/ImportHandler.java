package seia.fastclasscreator.v2.utils;

import java.util.List;

public class ImportHandler 
{
	public List<String> importsList;
	
	public ImportHandler(List<String> imports)
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
