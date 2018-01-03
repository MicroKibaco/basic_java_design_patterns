package com.design.patterns.proxy;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

public class Proxy {
    public static Object newProxyInstance(Class infce, InvocationHandler h) throws Exception {

        String rt = "\r\n";
        String methodStr = "";
        Object o = null;
        for (Method m : infce.getMethods()) {
            methodStr += "	@Override" + rt +
                    "	public void " + m.getName() + "() {" + rt +
                    "  try{" + rt +
                    "  Method md = " + infce.getName() + ".class.getMethod(\""
                    + m.getName() + "\");" + rt +
                    "  h.invoke(this,md);" + rt +
                    "  }catch(Exception e){ e.printStackTrace();}" + rt +
                    "	}";
        }

        String str =
                "package com.design.patterns.proxy;" + rt +
                        "import java.lang.reflect.Method;" + rt +
                        "import com.design.patterns.proxy.InvocationHandler;" + rt +
                        "public class $Proxy0 implements " + infce.getName() + " {" + rt +
                        "	public $Proxy0(InvocationHandler h) {" + rt +
                        "		this.h = h;" + rt +
                        "	}" + rt +
                        "  private InvocationHandler h;" + rt +
                        methodStr + rt +
                        "}";

        // 产生代理类的java文件
        String filename = System.getProperty("user.dir") + "/bin/com/design/patterns/proxy/$Proxy0.java";
        File file = new File(filename);

        FileUtils.writeStringToFile(file, str);
        // 编译
        // 拿到编译器
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();

        StandardJavaFileManager fileMgr = compiler.getStandardFileManager(null, null, null);

        // 获取文件
        Iterable units = fileMgr.getJavaFileObjects(filename);
        // 编译任务
        JavaCompiler.CompilationTask t = compiler.getTask(null, fileMgr, null, null, null, units);
        t.call();
        fileMgr.close();

        // load 到内存中
        ClassLoader cl = ClassLoader.getSystemClassLoader();

        Class c = cl.loadClass("com.design.patterns.proxy.Proxy");
        System.out.println(c.getName());

        Constructor ctr = c.getConstructor(InvocationHandler.class);
        return ctr.newInstance(h);
    }
}
