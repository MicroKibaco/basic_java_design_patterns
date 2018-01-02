## java设计模式秘密
### 懒汉设计模式 与 饿汉式的区别
1. 饿汉模式的特点是加载类的时候比较慢,但运行时获取对象的速度比较快,线程安全
2. 懒汉模式的特点是加载类的时候比较快,但运行时获取对象的速度比较慢,线程不安全
### 观察者设计模式
### 代理模式
- **概念:** 为其他对象提供一种代理以控制对这个对象的访问
- **代理模式定义:** 为其他一种代理以控制d对这个对象的访问.代理对象起到中介作用,可以去掉功能服务或增加额外的服务
- **常见的代理模式:** 
  - 远程代理
  - 虚拟代理
  - 保护代理
  - 智能引用代理
- **两种实现方式:** 

一. 静态代理
 
  
```
代理和被代理对象在代理之前是确定的.他们都是实现相同的接口或者继承相同的类
```
![静态代理](docs/static-proxy.png)
   二. 动态代理  
  > java动态代理类位于java.lang.reflect包下,一般涉及到以下两个类:
  
(I)Interface InvocationHandler: 该接口中仅定义了一个方法

```
public object invoke(Object obj,Method method,Object[] args)在实际使用时,
第一个参数obj一般指的是代理类,method是被代理的方法,args为该方法的参数数组这个抽象方法在代理类中动态实现
```  
(II)Proxy:该类即为动态代理类
```
static Object newProxyInstance(ClassLoader loader,Class[] interface,InvocationHandler h):
返回代理类的实例,返回后的代理类可以当作被代理类使用(可使用被代理类的在接口中声明过的方法)
```

#### 步骤
1. 创建一个实现接口 InvocationHandler 的类,它必须实现invoke方法
2. 创建被代理的类和接口
3. 调用proxy的静态方法,创建一个代理类
```java
newProxyInstance(ClassLoader loader,Class[] interfaces,InvocationHandler h)
```
4. 通过代理调用方法
  
![动态代理](docs/dynamic-proxy.png)  