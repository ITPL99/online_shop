package application.service;


import container.Autowired;
import container.Component;

import java.util.Scanner;

@Component
public class Service {

    private TestComponent component;
    private final Scanner scanner; // TODO Как быть с ошибкой если над компонентом нельзя поставить аннотацию @Component

    @Autowired
    public Service(
            TestComponent component,
            Scanner scanner
    ) {
        this.component = component;
        this.scanner = scanner;
    }
}
