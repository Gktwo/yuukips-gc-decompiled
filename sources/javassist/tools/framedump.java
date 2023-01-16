package javassist.tools;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.bytecode.analysis.FramePrinter;
import p013io.javalin.http.sse.EmitterKt;

/* loaded from: grasscutter.jar:javassist/tools/framedump.class */
public class framedump {
    private framedump() {
    }

    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.err.println("Usage: java javassist.tools.framedump <fully-qualified class name>");
            return;
        }
        CtClass clazz = ClassPool.getDefault().get(args[0]);
        System.out.println("Frame Dump of " + clazz.getName() + EmitterKt.COMMENT_PREFIX);
        FramePrinter.print(clazz, System.out);
    }
}
