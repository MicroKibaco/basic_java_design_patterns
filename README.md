## java设计模式秘密
### 懒汉模式 与 饿汉式的区别
1. 饿汉模式的特点是加载类的时候比较慢,但运行时获取对象的速度比较快,线程安全
2. 懒汉模式的特点是加载类的时候比较快,但运行时获取对象的速度比较慢,线程不安全
