package seia.fastclasscreator.v4.component;

import java.util.ArrayList;
import java.util.List;

import seia.fastclasscreator.v4.KeyWords;

public class Component implements IComponent 
{
	private String[] _componentAccess;
	private String _componentType;
	private String _componentName;
	private List<String> _componentBody;
	
	public Component(String[] componentAccess, String componentType, String componentName, 
			List<String> componentBody)
	{
		_componentAccess = componentAccess;
		_componentType = componentType;
		_componentName = componentName;
		_componentBody = componentBody;
	}
	
	@Override
	public String[] getComponentAccess() 
	{
		return _componentAccess;
	}

	@Override
	public String getComponentType() 
	{
		return _componentType;
	}

	@Override
	public String getComponentName() 
	{
		return _componentName;
	}
	
	@Override
	public void addToComponentBody(String whatToAdd)
	{
		_componentBody.add(whatToAdd);
	}

	@Override
	public List<String> getComponentBody() 
	{
		return _componentBody;
	}

	@Override
	public List<String> buildComponent() 
	{
		List<String> _component = new ArrayList<String>();
		_component.add("");
		String _class = "";
		for(int i = 0; i < _componentAccess.length; i++)
			_class += _componentAccess[i] + " ";
		_class += _componentType + " ";
		_class += _componentName;
		_component.add(_class);
		_component.add(KeyWords.FUNCTION_START);
		for(int i = 0; i < _componentBody.size(); i++)
			_component.add(KeyWords.TAB + _componentBody.get(i));
		_component.add(KeyWords.FUNCTION_END);
		return _component;
	}
}
