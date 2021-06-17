package com.nevertrouble.demo.aopdebug.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cglib.core.DebuggingClassWriter;

@SpringBootTest
class SpringAopTest {

    static {
        String version = System.getProperty("java.version");

        // 实际此设置在 Junit 中不生效，需要在运行里添加
        // 1.8 及以下
        // -Dsun.misc.ProxyGenerator.saveGeneratedFiles=true

        // 1.8 以上
        // -Djdk.proxy.ProxyGenerator.saveGeneratedFiles=true
        if (version.compareTo("1.8") < 0) {
            System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        } else {
            System.setProperty("jdk.proxy.ProxyGenerator.saveGeneratedFiles", "true");
        }

        // CGlib 生成的类
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, ".\\class");
    }

    // 此分支 application.properties 中的
    // spring.aop.proxy-target-class=true
    // 即，aop 下全走 CGlib 代理

    // 断点打在 ServiceAspect 中 point.proceed() 处，运行测试，即可查看到两者都为 CGlib 代理类

    // 注入接口类型
    @Autowired
    private PrintService printService; // 此情况下，注入的是 CGlib 代理类

    // 注入无接口的类
    @Autowired
    private DirectPrintWithoutImpl directPrint; // 此情况下，注入的是 CGlib 代理类

    @Test
    void print() {
        printService.print();
        directPrint.print();
    }
}
