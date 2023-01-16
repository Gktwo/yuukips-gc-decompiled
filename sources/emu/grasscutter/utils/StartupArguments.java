package emu.grasscutter.utils;

import emu.grasscutter.Grasscutter;
import emu.grasscutter.net.packet.PacketOpcodesUtils;
import java.util.Map;
import java.util.function.Function;
import org.jline.console.Printer;
import org.slf4j.LoggerFactory;
import p001ch.qos.logback.classic.Level;
import p001ch.qos.logback.classic.Logger;

/* loaded from: grasscutter.jar:emu/grasscutter/utils/StartupArguments.class */
public final class StartupArguments {
    private static final Map<String, Function<String, Boolean>> argumentHandlers = Map.of("-dumppacketids", parameter -> {
        PacketOpcodesUtils.dumpPacketIds();
        return true;
    }, "-version", StartupArguments::printVersion, "-debug", StartupArguments::enableDebug, "-lang", parameter -> {
        Grasscutter.setPreferredLanguage(parameter);
        return false;
    }, "-game", parameter -> {
        Grasscutter.setRunModeOverride(Grasscutter.ServerRunMode.GAME_ONLY);
        return false;
    }, "-dispatch", parameter -> {
        Grasscutter.setRunModeOverride(Grasscutter.ServerRunMode.DISPATCH_ONLY);
        return false;
    }, "-v", StartupArguments::printVersion, "-boot", StartupArguments::printVersion, "-debugall", parameter -> {
        enableDebug(Printer.ALL);
        return false;
    });

    /*  JADX ERROR: Dependency scan failed at insn: 0x0006: INVOKE_CUSTOM r1
        java.lang.IndexOutOfBoundsException: Index 4 out of bounds for length 4
        	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
        	at java.base/java.util.Objects.checkIndex(Objects.java:359)
        	at java.base/java.util.ArrayList.get(ArrayList.java:427)
        	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processInsn(UsageInfoVisitor.java:130)
        	at jadx.core.dex.visitors.usage.UsageInfoVisitor.lambda$processInstructions$0(UsageInfoVisitor.java:79)
        	at jadx.plugins.input.java.data.code.JavaCodeReader.visitInstructions(JavaCodeReader.java:82)
        	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processInstructions(UsageInfoVisitor.java:77)
        	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processMethod(UsageInfoVisitor.java:62)
        	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processClass(UsageInfoVisitor.java:51)
        	at jadx.core.dex.visitors.usage.UsageInfoVisitor.init(UsageInfoVisitor.java:36)
        	at jadx.core.dex.nodes.RootNode.runPreDecompileStage(RootNode.java:267)
        */
    /*  JADX ERROR: Failed to decode insn: 0x0006: INVOKE_CUSTOM r1, method: emu.grasscutter.utils.StartupArguments.printVersion(java.lang.String):boolean
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, DockerGS version: ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:55)
        	at jadx.core.dex.instructions.InsnDecoder.invoke(InsnDecoder.java:568)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:438)
        	at jadx.core.dex.instructions.InsnDecoder.lambda$process$0(InsnDecoder.java:48)
        	at jadx.plugins.input.java.data.code.JavaCodeReader.visitInstructions(JavaCodeReader.java:82)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:43)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:194)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:309)
        	at jadx.core.ProcessClass.process(ProcessClass.java:53)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:85)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:300)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:265)
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, DockerGS version: ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    private static boolean printVersion(java.lang.String r3) {
        /*
            java.io.PrintStream r0 = java.lang.System.out
            java.lang.String r1 = emu.grasscutter.config.ConfigContainer.dockergs_v
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, DockerGS version: ]}
            r0.println(r1)
            r0 = 1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.utils.StartupArguments.printVersion(java.lang.String):boolean");
    }

    private StartupArguments() {
    }

    public static boolean parse(String[] args) {
        boolean exitEarly = false;
        for (String input : args) {
            boolean containsParameter = input.contains("=");
            Function<String, Boolean> handler = argumentHandlers.get((containsParameter ? input.split("=")[0] : input).toLowerCase());
            if (handler != null) {
                exitEarly |= handler.apply(containsParameter ? input.split("=")[1] : null).booleanValue();
            }
        }
        return exitEarly;
    }

    private static boolean enableDebug(String parameter) {
        Level loggerLevel = (parameter == null || !parameter.equals(Printer.ALL)) ? Level.INFO : Level.DEBUG;
        Grasscutter.getLogger().setLevel(Level.DEBUG);
        Grasscutter.getLogger().debug("The logger is now running in debug mode.");
        ((Logger) LoggerFactory.getLogger("io.javalin")).setLevel(loggerLevel);
        ((Logger) LoggerFactory.getLogger("org.quartz")).setLevel(loggerLevel);
        ((Logger) LoggerFactory.getLogger("org.reflections")).setLevel(loggerLevel);
        ((Logger) LoggerFactory.getLogger("org.eclipse.jetty")).setLevel(loggerLevel);
        ((Logger) LoggerFactory.getLogger("org.mongodb.driver")).setLevel(loggerLevel);
        ((Logger) LoggerFactory.getLogger("emu.grasscutter.scripts")).setLevel(loggerLevel);
        return false;
    }
}
