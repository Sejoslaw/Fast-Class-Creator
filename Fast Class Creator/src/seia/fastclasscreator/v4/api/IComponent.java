package seia.fastclasscreator.v4.api;

import java.util.List;

/**
 * It can be class, interface, enum, etc.
 * @author Krzysztof "SeiA" Dobrzy�ski
 */
public interface IComponent 
{
	String[] getComponentAccess();
	String getComponentType();
	String getComponentName();
	void addToComponentBody(String whatToAdd);
	List<String> getComponentBody();
	//List<IComponent> getInsideComponents();
	List<String> buildComponent();
}