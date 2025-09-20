package container;

import application.service.CommandHendel;

import java.lang.annotation.ElementType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Executable;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class DefinitionScanner {
    public List<Definition<?>> getDefinitions(List<Class<?>> classList) {
        List<Definition<?>> definitionList = new LinkedList<>();

        for (Class<?> clazz : classList){
            if(clazz.isInterface() || clazz.isAnnotation() || clazz.isEnum() ){
                continue;
            }

            if(clazz.isAnnotationPresent(Component.class)){

                if(clazz.equals(CommandHendel.class)) System.out.println(); //TODO УДалить
                List<Class<?>> interfaces = List.of(clazz.getInterfaces());
                Class<?> componentType = null;
                if(interfaces.isEmpty()) componentType = clazz;
                else {
                    componentType = interfaces.get(0);
                }

                List<Constructor<?>> constructors = List.of(clazz.getConstructors());
                Executable methodCreate = null;
                if(constructors.size() == 1 && constructors.get(0).getParameters().length == 0){
                    methodCreate = constructors.get(0);
                }else {
                    for (Constructor<?> constructor : constructors){
                        if(constructor.isAnnotationPresent(Autowired.class)){
                            methodCreate = constructor;
                            break;
                        }
                    }

                    if(Objects.isNull(methodCreate)){
                        System.out.println("Не найден конструктор с аннотацией @Autowired у класса: " +  clazz.getSimpleName());
                        System.exit(1);
                    }
                }


                Definition<?> definition = new Definition<>(
                        clazz,
                        componentType,
                        methodCreate,
                        List.of(methodCreate.getParameterTypes()),
                        ElementType.CONSTRUCTOR

                );

                definitionList.add(definition);
            }
        }



        return definitionList;
    }
}
