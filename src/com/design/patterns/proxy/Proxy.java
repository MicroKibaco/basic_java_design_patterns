package com.design.patterns.proxy;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class Proxy {
    public static Object newProxyInstance(Class infce, InvocationHandler h)  {

        String rt = "\r\n";
        String methodStr = "";
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
                "package com.imooc.proxy;" + rt +
                        "import java.lang.reflect.Method;" + rt +
                        "import com.imooc.proxy.InvocationHandler;" + rt +
                        "public class $Proxy0 implements " + infce.getName() + " {" + rt +
                        "	public $Proxy0(InvocationHandler h) {" + rt +
                        "		this.h = h;" + rt +
                        "	}" + rt +
                        "  private InvocationHandler h;" + rt +
                        methodStr + rt +
                        "}";
        String filename = System.getProperty("user.dir") + "/bin/com/design/patterns/proxy/$Proxy0.java";
        File file = new File(filename);
        try {
            FileUtils.writeStringToFile(file, str);
        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }
}
