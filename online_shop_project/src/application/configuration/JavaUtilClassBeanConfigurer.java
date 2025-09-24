package application.configuration;

import container.Bean;
import container.Configurer;


import java.util.Scanner;

@Configurer
public class JavaUtilClassBeanConfigurer {

    @Bean
    public Scanner scanner(){
        return new Scanner(System.in);
    }


    public Object object(){
        return new Object();
    }


}
