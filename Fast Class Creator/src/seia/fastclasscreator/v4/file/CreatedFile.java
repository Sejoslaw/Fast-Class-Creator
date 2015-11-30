package seia.fastclasscreator.v4.file;

import java.io.File;
import java.util.List;

import seia.fastclasscreator.v4.api.IComponent;
import seia.fastclasscreator.v4.api.IFile;

public class CreatedFile implements IFile
{
	private String _fileName;
	private String _whatExtends;
	private String _package;
	private File _file;
	private List<String> _imports;
	private List<String> _fileBody;
	private String[] _mainComponentAccess;
	private String _mainComponentType;
	private List<IComponent> _additionalComponents;
	
	public CreatedFile(String fileName, String whatExtends, String _package, File file, List<String> _imports,
			List<String> fileBody, String[] mainCompAcc, String mainCompType, List<IComponent> additionalComps)
	{
		_fileName = fileName;
		_whatExtends = whatExtends;
		this._package = _package;
		_file = file;
		this._imports = _imports;
		_fileBody = fileBody;
		_mainComponentAccess = mainCompAcc;
		_mainComponentType = mainCompType;
		_additionalComponents = additionalComps;
	}
	
	@Override
	public String getFileName() 
	{
		return _fileName;
	}

	@Override
	public String getWhatExtends() 
	{
		return _whatExtends;
	}

	@Override
	public String getPackage() 
	{
		return _package;
	}

	@Override
	public File getFile() 
	{
		return _file;
	}

	@Override
	public List<String> getImports() 
	{
		return _imports;
	}

	@Override
	public List<String> getFileBody() 
	{
		return _fileBody;
	}

	@Override
	public String[] getMainComponentAccess() 
	{
		return _mainComponentAccess;
	}

	@Override
	public String getMainComponentType() 
	{
		return _mainComponentType;
	}

	@Override
	public List<IComponent> getAdditionalComponents() 
	{
		return _additionalComponents;
	}
}