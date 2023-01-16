package emu.grasscutter;

import emu.grasscutter.auth.AuthenticationSystem;
import emu.grasscutter.command.CommandMap;
import emu.grasscutter.command.PermissionHandler;
import emu.grasscutter.config.ConfigContainer;
import emu.grasscutter.config.Configuration;
import emu.grasscutter.plugin.PluginManager;
import emu.grasscutter.server.game.GameServer;
import emu.grasscutter.server.http.HttpServer;
import emu.grasscutter.utils.JsonUtils;
import emu.grasscutter.utils.Language;
import emu.grasscutter.utils.Utils;
import java.io.File;
import java.io.IOError;
import org.jline.reader.EndOfFileException;
import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.reader.UserInterruptException;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
import org.reflections.Reflections;
import org.reflections.scanners.Scanner;
import org.slf4j.LoggerFactory;
import p001ch.qos.logback.classic.Level;
import p001ch.qos.logback.classic.Logger;
import p001ch.qos.logback.classic.util.ContextInitializer;

/* loaded from: grasscutter.jar:emu/grasscutter/Grasscutter.class */
public final class Grasscutter {
    private static Language language;
    private static int currentDayOfWeek;
    private static String preferredLanguage;
    private static HttpServer httpServer;
    private static GameServer gameServer;
    private static PluginManager pluginManager;
    private static CommandMap commandMap;
    private static AuthenticationSystem authenticationSystem;
    private static PermissionHandler permissionHandler;
    public static ConfigContainer config;
    private static final Logger logger = (Logger) LoggerFactory.getLogger(Grasscutter.class);
    private static LineReader consoleLineReader = null;
    public static final File configFile = new File("./config.json");
    private static ServerRunMode runModeOverride = null;
    public static final Reflections reflector = new Reflections("emu.grasscutter", new Scanner[0]);

    /* loaded from: grasscutter.jar:emu/grasscutter/Grasscutter$ServerDebugMode.class */
    public enum ServerDebugMode {
        ALL,
        MISSING,
        WHITELIST,
        BLACKLIST,
        NONE
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/Grasscutter$ServerRunMode.class */
    public enum ServerRunMode {
        HYBRID,
        DISPATCH_ONLY,
        GAME_ONLY
    }

    /*  JADX ERROR: Dependency scan failed at insn: 0x001A: INVOKE_CUSTOM r1
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
    /*  JADX ERROR: Dependency scan failed at insn: 0x0026: INVOKE_CUSTOM r0, r0
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
    /*  JADX ERROR: Failed to decode insn: 0x001A: INVOKE_CUSTOM r1, method: emu.grasscutter.Grasscutter.main(java.lang.String[]):void
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Cores : ]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Cores : ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    /*  JADX ERROR: Failed to decode insn: 0x0026: INVOKE_CUSTOM r1, r0, method: emu.grasscutter.Grasscutter.main(java.lang.String[]):void
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (J)Ljava/lang/String;}, Memory: ]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (J)Ljava/lang/String;}, Memory: ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    public static void main(java.lang.String[] r7) throws java.lang.Exception {
        /*
        // Method dump skipped, instructions count: 498
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.Grasscutter.main(java.lang.String[]):void");
    }

    /*  JADX ERROR: Dependency scan failed at insn: 0x0013: INVOKE_CUSTOM r0
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
    /*  JADX ERROR: Failed to decode insn: 0x0013: INVOKE_CUSTOM r1, method: emu.grasscutter.Grasscutter.updateDayOfWeek():void
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Set day of week to ]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Set day of week to ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    public static void updateDayOfWeek() {
        /*
            java.util.Calendar r0 = java.util.Calendar.getInstance()
            r3 = r0
            r0 = r3
            r1 = 7
            int r0 = r0.get(r1)
            emu.grasscutter.Grasscutter.currentDayOfWeek = r0
            ch.qos.logback.classic.Logger r0 = getLogger()
            int r1 = emu.grasscutter.Grasscutter.currentDayOfWeek
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Set day of week to ]}
            r0.info(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.Grasscutter.updateDayOfWeek():void");
    }

    public static Logger getLogger() {
        return logger;
    }

    static {
        System.setProperty(ContextInitializer.CONFIG_FILE_PROPERTY, "src/main/resources/logback.xml");
        ((Logger) LoggerFactory.getLogger("org.mongodb.driver")).setLevel(Level.OFF);
        loadConfig();
        ConfigContainer.updateConfig();
        loadLanguage();
        Utils.startupCheck();
    }

    public static Language getLanguage() {
        return language;
    }

    public static void setLanguage(Language language2) {
        language = language2;
    }

    public static void setRunModeOverride(ServerRunMode runModeOverride2) {
        runModeOverride = runModeOverride2;
    }

    public static int getCurrentDayOfWeek() {
        return currentDayOfWeek;
    }

    public static String getPreferredLanguage() {
        return preferredLanguage;
    }

    public static void setPreferredLanguage(String preferredLanguage2) {
        preferredLanguage = preferredLanguage2;
    }

    public static HttpServer getHttpServer() {
        return httpServer;
    }

    public static GameServer getGameServer() {
        return gameServer;
    }

    public static PluginManager getPluginManager() {
        return pluginManager;
    }

    public static CommandMap getCommandMap() {
        return commandMap;
    }

    public static AuthenticationSystem getAuthenticationSystem() {
        return authenticationSystem;
    }

    public static void setAuthenticationSystem(AuthenticationSystem authenticationSystem2) {
        authenticationSystem = authenticationSystem2;
    }

    public static PermissionHandler getPermissionHandler() {
        return permissionHandler;
    }

    public static void setPermissionHandler(PermissionHandler permissionHandler2) {
        permissionHandler = permissionHandler2;
    }

    public static ConfigContainer getConfig() {
        return config;
    }

    private static void onShutdown() {
        if (pluginManager != null) {
            pluginManager.disablePlugins();
        }
    }

    public static void loadLanguage() {
        language = Language.getLanguage(Utils.getLanguageCode(config.language.language));
    }

    public static void loadConfig() {
        if (!configFile.exists()) {
            getLogger().info("config.json could not be found. Generating a default configuration ...");
            config = new ConfigContainer();
            saveConfig(config);
            return;
        }
        try {
            config = (ConfigContainer) JsonUtils.loadToClass(configFile.toPath(), ConfigContainer.class);
        } catch (Exception e) {
            GameServer.doExit(0, "There was an error while trying to load the configuration from config.json. Please make sure that there are no syntax errors. If you want to start with a default configuration, delete your existing config.json.");
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:8:0x0026
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    public static void saveConfig(@javax.annotation.Nullable emu.grasscutter.config.ConfigContainer r4) {
        /*
            r0 = r4
            if (r0 != 0) goto L_0x000c
            emu.grasscutter.config.ConfigContainer r0 = new emu.grasscutter.config.ConfigContainer
            r1 = r0
            r1.<init>()
            r4 = r0
        L_0x000c:
            java.io.FileWriter r0 = new java.io.FileWriter     // Catch: IOException -> 0x0039, Exception -> 0x0046
            r1 = r0
            java.io.File r2 = emu.grasscutter.Grasscutter.configFile     // Catch: IOException -> 0x0039, Exception -> 0x0046
            r1.<init>(r2)     // Catch: IOException -> 0x0039, Exception -> 0x0046
            r5 = r0
            r0 = r5
            r1 = r4
            java.lang.String r1 = emu.grasscutter.utils.JsonUtils.encode(r1)     // Catch: Throwable -> 0x0026, IOException -> 0x0039, Exception -> 0x0046
            r0.write(r1)     // Catch: Throwable -> 0x0026, IOException -> 0x0039, Exception -> 0x0046
            r0 = r5
            r0.close()     // Catch: IOException -> 0x0039, Exception -> 0x0046
            goto L_0x0036
        L_0x0026:
            r6 = move-exception
            r0 = r5
            r0.close()     // Catch: Throwable -> 0x002e, IOException -> 0x0039, Exception -> 0x0046
            goto L_0x0034
        L_0x002e:
            r7 = move-exception
            r0 = r6
            r1 = r7
            r0.addSuppressed(r1)     // Catch: IOException -> 0x0039, Exception -> 0x0046
        L_0x0034:
            r0 = r6
            throw r0     // Catch: IOException -> 0x0039, Exception -> 0x0046
        L_0x0036:
            goto L_0x0051
        L_0x0039:
            r5 = move-exception
            ch.qos.logback.classic.Logger r0 = getLogger()
            java.lang.String r1 = "Unable to write to config file."
            r0.error(r1)
            goto L_0x0051
        L_0x0046:
            r5 = move-exception
            ch.qos.logback.classic.Logger r0 = getLogger()
            java.lang.String r1 = "Unable to save config file."
            r2 = r5
            r0.error(r1, r2)
        L_0x0051:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.Grasscutter.saveConfig(emu.grasscutter.config.ConfigContainer):void");
    }

    public static Language getLanguage(String langCode) {
        return Language.getLanguage(langCode);
    }

    public static ServerRunMode getRunMode() {
        return runModeOverride != null ? runModeOverride : Configuration.SERVER.runMode;
    }

    public static LineReader getConsole() {
        if (consoleLineReader == null) {
            Terminal terminal = null;
            try {
                terminal = TerminalBuilder.builder().jna(true).build();
            } catch (Exception e) {
                try {
                    terminal = TerminalBuilder.builder().dumb(true).build();
                } catch (Exception e2) {
                }
            }
            consoleLineReader = LineReaderBuilder.builder().terminal(terminal).build();
        }
        return consoleLineReader;
    }

    public static void startConsole() {
        if (Configuration.SERVER.runMode == ServerRunMode.DISPATCH_ONLY) {
            getLogger().info(Language.translate("messages.dispatch.no_commands_error", new Object[0]));
            return;
        }
        getLogger().info(Language.translate("messages.status.done", new Object[0]));
        String input = null;
        boolean isLastInterrupted = false;
        while (config.server.game.enableConsole) {
            try {
                input = consoleLineReader.readLine("> ");
            } catch (IOError e) {
                getLogger().error("An IO error occurred while trying to read from console.", (Throwable) e);
                return;
            } catch (EndOfFileException e2) {
                if (!(input == null || input.length() == 0)) {
                    getLogger().info("EOF detected.");
                }
            } catch (UserInterruptException e3) {
                if (!isLastInterrupted) {
                    isLastInterrupted = true;
                    getLogger().info("Press Ctrl-C again to shutdown.");
                } else {
                    GameServer.doExit(0, "Exit By Press");
                }
            }
            isLastInterrupted = false;
            try {
                CommandMap.getInstance().invoke(null, null, input);
            } catch (Exception e4) {
                getLogger().error(Language.translate("messages.game.command_error", new Object[0]), (Throwable) e4);
            }
        }
    }
}
