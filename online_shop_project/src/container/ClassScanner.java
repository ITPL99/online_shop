package container;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ClassScanner {

    private Class<?> mainClass;

    public ClassScanner(Class<?> mainClass) {
        this.mainClass = mainClass;
    }

    public List<Class<?>> getClasses() throws URISyntaxException {
        List<Class<?>> classes = new ArrayList<>();
        URL resourse = mainClass.getResource(mainClass.getSimpleName() + ".class");
        if (resourse == null) {
            System.out.println("ошибка поиска корневого коталога");
            System.exit(1);
        }

       if(resourse.getProtocol().equals("file")) {
           File dir = new File(mainClass.getProtectionDomain().getCodeSource().getLocation().toURI());
           File[] files = dir.listFiles();
           for (File file : files) {
               System.out.println(file.getName());
           }

       }


        return classes;
    }
}
