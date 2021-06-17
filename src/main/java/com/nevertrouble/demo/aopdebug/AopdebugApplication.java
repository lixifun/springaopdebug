package com.nevertrouble.demo.aopdebug;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class AopdebugApplication {
    static {
        String version = System.getProperty("java.version");

        if (version.compareTo("1.8") < 0) {
            System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        } else {
            System.setProperty("jdk.proxy.ProxyGenerator.saveGeneratedFiles", "true");
        }

        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, ".\\class");
    }

    public static void main(String[] args) {
        SpringApplication.run(AopdebugApplication.class, args);
    }

}
