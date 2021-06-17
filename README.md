# 演示 SpringBoot 中 AOP 的代理情况

主分支无内容，请切换分支查看不同组合下的不同情况

- spring.aop.proxy-target-class=true & 注入接口
- spring.aop.proxy-target-class=true & 实现接口的 bean 有意注入其实现类
- spring.aop.proxy-target-class=false & 注入接口
- spring.aop.proxy-target-class=false & 实现接口的 bean 有意注入其实现类

## DEBUG

- 断点打在 com.nevertrouble.demo.aopdebug.aspect.ServiceAspect 中的 point.proceed() 行
- 运行 test 中的 SpringAopTest#print() 即可
