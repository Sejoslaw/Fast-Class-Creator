package seia.fastclasscreator.v2.component;

import java.util.List;

/**
 * It can be class, interface, enum, etc.
 * @author Krzysztof "SeiA" Dobrzyñski
 */
public interface IComponent 
{
	String[] getComponentAccess();
	String getComponentType();
	String getComponentName();
	List<String> getComponentBody();
	List<IComponent> getInsideComponents();
	List<String> buildComponent();
}