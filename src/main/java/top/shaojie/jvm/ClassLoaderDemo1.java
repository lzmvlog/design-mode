package top.shaojie.jvm;

import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * @author ShaoJie zhang1591313226@163.com
 * @Date 2021年02月11日 23:34
 * @Description:
 */
public class ClassLoaderDemo1 {

    public static void main(String[] args) {

//        // 双亲委派模型
//        // 父子关系  Bootstrap ClassLoader -> ExtClassLoader  -> AppClassLoader
//        ClassLoader classLoader1 = ClassLoaderDemo1.class.getClassLoader();
//        System.out.println("classLoader1 -> " + classLoader1);
//        System.out.println("parent of classLoader1 -> " + classLoader1.getParent());
//        // Bootstrap ClassLoader 由 C++ 开发，是 jvm 的一部分，本身并不是java类
//        System.out.println("Grandfather of classLoader1 -> " + classLoader1.getParent().getParent());
//
//        // String 、Int 等基础类型由 Bootstrap ClassLoader 加载
//        ClassLoader classLoader2 = String.class.getClassLoader();
//        System.out.println("classLoader2 -> " + classLoader2);
//        try {
//            System.out.println(classLoader1.loadClass("java.util.List").getClass().getClassLoader());
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }

        // JDK 类加载对象
        // classLoader -> SecureClassLoader -> URLClassLoader -> ExtClassLoader，AppClassLoader


        // idea`如何将Java文件打成Jar？
        // jar -cvf 【打包后的文件名】.jar 【要打包的目录】

//        ClassLoader classLoader = null;
        URL url = null;
        try {
            url = new URL("file:D:\\work\\design-mode\\ClassLoaderDemo.jar");
            // 类加载器用于从引用JAR文件和目录的URL搜索路径中加载类和资源。假定所有以''结尾的URL均指目录。
            // 否则，假定该URL指向将根据需要打开的JAR文件。 <p>在随后加载类和资源时将使用创建URLClassLoader实例的线程的AccessControlContext。
            // 默认情况下，仅向加载的类授予权限，以访问创建URLClassLoader时指定的URL。
            URLClassLoader loader = new URLClassLoader(new URL[]{url});
            Class<?> aClass = loader.loadClass("top.shaojie.jvm.ClassLoaderDemo");
            Object o = aClass.newInstance();
            String newUrl = (String) aClass.getMethod("url", String.class).invoke(o, "/submit");
            System.out.println(newUrl);
        } catch (MalformedURLException | ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    public String url(String url) {
        String login = "/login" + url;
        return login;
    }
}
