package container;

import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApplicationContext {
    private static Map<Class<?>, Object> context = new HashMap<>();
    private Class<?> mainClass;

    public ApplicationContext(Class<?> mainClass) {
        this.mainClass = mainClass;
        context.put(ApplicationContext.class, this);
        configurerContext();
    }

    private void configurerContext(){
        try {
            List<Class<?>> classList = new ClassScanner(mainClass).getClasses();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    public void run(){
//        getBean(ApplicationRunner.class).run();
    }

    public static  <T> T getBean(Class<T> clazz) {
        return (T) context.get(clazz);
    }
}
