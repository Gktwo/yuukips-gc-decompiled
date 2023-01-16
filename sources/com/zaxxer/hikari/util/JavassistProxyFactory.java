package com.zaxxer.hikari.util;

import com.zaxxer.hikari.pool.ProxyCallableStatement;
import com.zaxxer.hikari.pool.ProxyConnection;
import com.zaxxer.hikari.pool.ProxyPreparedStatement;
import com.zaxxer.hikari.pool.ProxyResultSet;
import com.zaxxer.hikari.pool.ProxyStatement;
import java.lang.reflect.Array;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.CtNewMethod;
import javassist.LoaderClassPath;
import javassist.NotFoundException;
import net.bytebuddy.implementation.MethodDelegation;
import okhttp3.HttpUrl;
import org.quartz.jobs.p027ee.ejb.EJBInvokerJob;

/* loaded from: grasscutter.jar:com/zaxxer/hikari/util/JavassistProxyFactory.class */
public final class JavassistProxyFactory {
    private static ClassPool classPool;

    public static void main(String... args) {
        classPool = new ClassPool();
        classPool.importPackage("java.sql");
        classPool.appendClassPath(new LoaderClassPath(JavassistProxyFactory.class.getClassLoader()));
        try {
            generateProxyClass(Connection.class, ProxyConnection.class.getName(), "{ try { return delegate.method($$); } catch (SQLException e) { throw checkException(e); } }");
            generateProxyClass(Statement.class, ProxyStatement.class.getName(), "{ try { return delegate.method($$); } catch (SQLException e) { throw checkException(e); } }");
            generateProxyClass(ResultSet.class, ProxyResultSet.class.getName(), "{ try { return delegate.method($$); } catch (SQLException e) { throw checkException(e); } }");
            generateProxyClass(PreparedStatement.class, ProxyPreparedStatement.class.getName(), "{ try { return ((cast) delegate).method($$); } catch (SQLException e) { throw checkException(e); } }");
            generateProxyClass(CallableStatement.class, ProxyCallableStatement.class.getName(), "{ try { return ((cast) delegate).method($$); } catch (SQLException e) { throw checkException(e); } }");
            modifyProxyFactory();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void modifyProxyFactory() throws Exception {
        System.out.println("Generating method bodies for com.zaxxer.hikari.proxy.ProxyFactory");
        String packageName = ProxyConnection.class.getPackage().getName();
        CtClass proxyCt = classPool.getCtClass("com.zaxxer.hikari.pool.ProxyFactory");
        CtMethod[] methods = proxyCt.getMethods();
        for (CtMethod method : methods) {
            String name = method.getName();
            char c = 65535;
            switch (name.hashCode()) {
                case -1995233385:
                    if (name.equals("getProxyStatement")) {
                        c = 1;
                        break;
                    }
                    break;
                case -1729648339:
                    if (name.equals("getProxyResultSet")) {
                        c = 4;
                        break;
                    }
                    break;
                case -443793985:
                    if (name.equals("getProxyCallableStatement")) {
                        c = 3;
                        break;
                    }
                    break;
                case 2011710902:
                    if (name.equals("getProxyConnection")) {
                        c = 0;
                        break;
                    }
                    break;
                case 2145615834:
                    if (name.equals("getProxyPreparedStatement")) {
                        c = 2;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    method.setBody("{return new " + packageName + ".HikariProxyConnection($$);}");
                    break;
                case 1:
                    method.setBody("{return new " + packageName + ".HikariProxyStatement($$);}");
                    break;
                case 2:
                    method.setBody("{return new " + packageName + ".HikariProxyPreparedStatement($$);}");
                    break;
                case 3:
                    method.setBody("{return new " + packageName + ".HikariProxyCallableStatement($$);}");
                    break;
                case 4:
                    method.setBody("{return new " + packageName + ".HikariProxyResultSet($$);}");
                    break;
            }
        }
        proxyCt.writeFile("target/classes");
    }

    private static <T> void generateProxyClass(Class<T> primaryInterface, String superClassName, String methodBody) throws Exception {
        String modifiedBody;
        String newClassName = superClassName.replaceAll("(.+)\\.(\\w+)", "$1.Hikari$2");
        CtClass superCt = classPool.getCtClass(superClassName);
        CtClass targetCt = classPool.makeClass(newClassName, superCt);
        targetCt.setModifiers(16);
        System.out.println("Generating " + newClassName);
        targetCt.setModifiers(1);
        Set<String> superSigs = new HashSet<>();
        CtMethod[] methods = superCt.getMethods();
        for (CtMethod method : methods) {
            if ((method.getModifiers() & 16) == 16) {
                superSigs.add(method.getName() + method.getSignature());
            }
        }
        Set<String> methods2 = new HashSet<>();
        for (Class<?> intf : getAllInterfaces(primaryInterface)) {
            CtClass intfCt = classPool.getCtClass(intf.getName());
            targetCt.addInterface(intfCt);
            CtMethod[] declaredMethods = intfCt.getDeclaredMethods();
            for (CtMethod intfMethod : declaredMethods) {
                String signature = intfMethod.getName() + intfMethod.getSignature();
                if (!superSigs.contains(signature) && !methods2.contains(signature) && !isDefaultMethod(intf, intfCt, intfMethod)) {
                    methods2.add(signature);
                    CtMethod method2 = CtNewMethod.copy(intfMethod, targetCt, null);
                    String modifiedBody2 = methodBody;
                    if ((superCt.getMethod(intfMethod.getName(), intfMethod.getSignature()).getModifiers() & 1024) != 1024) {
                        modifiedBody2 = modifiedBody2.replace("((cast) ", "").replace(MethodDelegation.ImplementationDelegate.FIELD_NAME_PREFIX, "super").replace("super)", "super");
                    }
                    String modifiedBody3 = modifiedBody2.replace("cast", primaryInterface.getName());
                    if (isThrowsSqlException(intfMethod)) {
                        modifiedBody = modifiedBody3.replace(EJBInvokerJob.EJB_METHOD_KEY, method2.getName());
                    } else {
                        modifiedBody = "{ return ((cast) delegate).method($$); }".replace(EJBInvokerJob.EJB_METHOD_KEY, method2.getName()).replace("cast", primaryInterface.getName());
                    }
                    if (method2.getReturnType() == CtClass.voidType) {
                        modifiedBody = modifiedBody.replace("return", "");
                    }
                    method2.setBody(modifiedBody);
                    targetCt.addMethod(method2);
                }
            }
        }
        targetCt.getClassFile().setMajorVersion(51);
        targetCt.writeFile("target/classes");
    }

    private static boolean isThrowsSqlException(CtMethod method) {
        try {
            for (CtClass clazz : method.getExceptionTypes()) {
                if (clazz.getSimpleName().equals("SQLException")) {
                    return true;
                }
            }
            return false;
        } catch (NotFoundException e) {
            return false;
        }
    }

    private static boolean isDefaultMethod(Class<?> intf, CtClass intfCt, CtMethod intfMethod) throws Exception {
        List<Class<?>> paramTypes = new ArrayList<>();
        for (CtClass pt : intfMethod.getParameterTypes()) {
            paramTypes.add(toJavaClass(pt));
        }
        return intf.getDeclaredMethod(intfMethod.getName(), (Class[]) paramTypes.toArray(new Class[paramTypes.size()])).toString().contains("default ");
    }

    private static Set<Class<?>> getAllInterfaces(Class<?> clazz) {
        Set<Class<?>> interfaces = new HashSet<>();
        for (Class<?> intf : Arrays.asList(clazz.getInterfaces())) {
            if (intf.getInterfaces().length > 0) {
                interfaces.addAll(getAllInterfaces(intf));
            }
            interfaces.add(intf);
        }
        if (clazz.getSuperclass() != null) {
            interfaces.addAll(getAllInterfaces(clazz.getSuperclass()));
        }
        if (clazz.isInterface()) {
            interfaces.add(clazz);
        }
        return interfaces;
    }

    private static Class<?> toJavaClass(CtClass cls) throws Exception {
        if (cls.getName().endsWith(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI)) {
            return Array.newInstance(toJavaClass(cls.getName().replace(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI, "")), 0).getClass();
        }
        return toJavaClass(cls.getName());
    }

    private static Class<?> toJavaClass(String cn) throws Exception {
        char c = 65535;
        switch (cn.hashCode()) {
            case -1325958191:
                if (cn.equals("double")) {
                    c = 5;
                    break;
                }
                break;
            case 104431:
                if (cn.equals("int")) {
                    c = 0;
                    break;
                }
                break;
            case 3039496:
                if (cn.equals("byte")) {
                    c = 3;
                    break;
                }
                break;
            case 3052374:
                if (cn.equals("char")) {
                    c = 7;
                    break;
                }
                break;
            case 3327612:
                if (cn.equals("long")) {
                    c = 1;
                    break;
                }
                break;
            case 3625364:
                if (cn.equals("void")) {
                    c = '\b';
                    break;
                }
                break;
            case 64711720:
                if (cn.equals("boolean")) {
                    c = 6;
                    break;
                }
                break;
            case 97526364:
                if (cn.equals("float")) {
                    c = 4;
                    break;
                }
                break;
            case 109413500:
                if (cn.equals("short")) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return Integer.TYPE;
            case 1:
                return Long.TYPE;
            case 2:
                return Short.TYPE;
            case 3:
                return Byte.TYPE;
            case 4:
                return Float.TYPE;
            case 5:
                return Double.TYPE;
            case 6:
                return Boolean.TYPE;
            case 7:
                return Character.TYPE;
            case '\b':
                return Void.TYPE;
            default:
                return Class.forName(cn);
        }
    }
}
