package container;

import java.lang.annotation.ElementType;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ComponentFactory {
    public void configurerBeans(List<Definition<?>> definitionList, Map<Class<?>, Object> context) throws InvocationTargetException, InstantiationException, IllegalAccessException {
        for (Definition<?> definition : definitionList){
           configNewBean(definition, context, definitionList);
        }
    }


    private void configNewBean(Definition<?> definition, Map<Class<?>, Object> context, List<Definition<?>> definitionList) throws InvocationTargetException, InstantiationException, IllegalAccessException {
        if(ElementType.CONSTRUCTOR.equals(definition.getElementType())){
            if(definition.getParameters().isEmpty()) {
                Constructor<?> constructor = (Constructor<?>) definition.getMethodCreate();
                Object bean = constructor.newInstance();
                context.put(definition.getComponentType(), bean);
                return;
            }

            List<Object> args = new ArrayList<>();
            for (Class<?> parameter: definition.getParameters()){
                if(context.containsKey(parameter)){
                    args.add(context.get(parameter));
                }else {
                    for (Definition<?> def : definitionList){
                        if(def.getComponentType().equals(parameter)){
                          configNewBean(def, context, definitionList);
                          Object beanParam = context.get(def.getComponentType());
                          args.add(beanParam);
                        }
                    }
                }
            }

            Constructor<?> createMethod =(Constructor<?>) definition.getMethodCreate();
            Object bean = createMethod.newInstance(args.toArray());
            context.put(definition.getComponentType(), bean);
            return;
        }

        if(ElementType.METHOD.equals(definition.getElementType())){
            Object obj = definition.getComponentClass().getConstructors()[0].newInstance();
            if(definition.getParameters().isEmpty()){
                context.put(definition.getComponentType(), ((Method)definition.getMethodCreate()).invoke(obj));
                return;
            }

            List<Object> args = new ArrayList<>();
            for (Class<?> parameter: definition.getParameters()){
                if(context.containsKey(parameter)){
                    args.add(context.get(parameter));
                }else {
                    for (Definition<?> def : definitionList){
                        if(def.getComponentType().equals(parameter)){
                            configNewBean(def, context, definitionList);
                            Object beanParam = context.get(def.getComponentType());
                            args.add(beanParam);
                        }
                    }
                }
            }

            Constructor<?> createMethod = definition.getComponentType().getConstructors()[0];
            Object bean = createMethod.newInstance();
            Method methodCreate = (Method) definition.getMethodCreate();
            context.put(definition.getComponentType(), methodCreate.invoke(args));
            return;
        }


    }
}
