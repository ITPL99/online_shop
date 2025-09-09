package container;

import java.lang.reflect.Executable;
import java.util.List;

public class Definition <T extends Executable> {
    private Class<?> componentClass;
    private Class<?> componentType;
    private T methodCreate;
    private List<Class<?>> parameters;
 }
