package container;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.reflect.Executable;
import java.util.List;

/**
 * Этот класс представляет собой определение компонента в контейнере.
 * Он содержит всю необходимую информацию для создания и внедрения экземпляра компонента.
 * @param <T> Тип исполняемого элемента (конструктор или метод), который создает компонент.
 */
public class Definition <T extends Executable> {
    /**
     * Класс, в котором определен компонент.
     */
    private Class<?> componentClass;
    /**
     * Тип (класс или интерфейс), под которым компонент будет зарегистрирован в контейнере.
     */
    private Class<?> componentType;
    /**
     * Метод или конструктор, который используется для создания экземпляра компонента.
     */
    private T methodCreate;
    /**
     * Список типов параметров, необходимых для вызова метода или конструктора создания компонента.
     */
    private List<Class<?>> parameters;
    /**
     * Тип элемента (например, TYPE для класса или METHOD для метода), к которому применяется аннотация.
     */
    private ElementType elementType;

    public Definition(
            Class<?> componentClass, Class<?> componentType,
            T methodCreate, List<Class<?>> parameters,
            ElementType elementType
    ) {
        this.componentClass = componentClass;
        this.componentType = componentType;
        this.methodCreate = methodCreate;
        this.parameters = parameters;
        this.elementType = elementType;
    }

    public Class<?> getComponentClass() {
        return componentClass;
    }

    public Class<?> getComponentType() {
        return componentType;
    }

    public T getMethodCreate() {
        return methodCreate;
    }

    public List<Class<?>> getParameters() {
        return parameters;
    }

    public ElementType getElementType() {
        return elementType;
    }
}
