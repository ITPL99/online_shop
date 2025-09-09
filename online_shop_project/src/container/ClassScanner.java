package container;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ClassScanner {

    private Class<?> mainClass;

    public ClassScanner(Class<?> mainClass) {
        this.mainClass = mainClass;
    }

    public List<Class<?>> getClasses() throws URISyntaxException, ClassNotFoundException {
        List<Class<?>> classes = new ArrayList<>();
        URL resourse = mainClass.getResource(mainClass.getSimpleName() + ".class");
        if (resourse == null) {
            System.exit(1);
        }

        if (resourse.getProtocol().equals("file")) {
            File dir = new File(mainClass.getProtectionDomain().getCodeSource().getLocation().toURI());
            File[] files = dir.listFiles();
            for (File file : files) {
                scanPackages(file,file.getName(), classes);
            }
        } else if (resourse.getProtocol().equals("jar")) {}


        return classes;
    }

    private void scanPackages(File file, String packageUrl,List<Class<?>> classes ) throws ClassNotFoundException {
        File[] files = file.listFiles();

        if(Objects.isNull(files) || files.length == 0) {
            String fileUrl = file.getName().substring(0, file.getName().length() - 6);
            Class<?> classFile = Class.forName(fileUrl);
            classes.add(classFile);
            return;
        }

        for (File fileInFile : files) {
            if (fileInFile.isDirectory()) {
                scanPackages(fileInFile, packageUrl + "." + fileInFile.getName(), classes);
            } else if (fileInFile.getName().endsWith(".class")) {
                String fileUrl = packageUrl+"."+ fileInFile.getName().substring(0, fileInFile.getName().length() - 6);
                Class<?> classFile = Class.forName(fileUrl);
                classes.add(classFile);
            }
        }
    }
}
