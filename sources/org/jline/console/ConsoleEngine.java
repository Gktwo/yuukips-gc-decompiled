package org.jline.console;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import org.jline.reader.Completer;
import org.jline.reader.LineReader;
import org.jline.reader.Widget;
import p013io.javalin.http.sse.EmitterKt;

/* loaded from: grasscutter.jar:org/jline/console/ConsoleEngine.class */
public interface ConsoleEngine extends CommandRegistry {
    void setLineReader(LineReader lineReader);

    void setSystemRegistry(SystemRegistry systemRegistry);

    Object[] expandParameters(String[] strArr) throws Exception;

    String expandCommandLine(String str);

    String expandToList(List<String> list);

    Map<String, Boolean> scripts();

    void setScriptExtension(String str);

    boolean hasAlias(String str);

    String getAlias(String str);

    Map<String, List<String>> getPipes();

    List<String> getNamedPipes();

    List<Completer> scriptCompleters();

    void persist(Path path, Object obj);

    Object slurp(Path path) throws IOException;

    <T> T consoleOption(String str, T t);

    Object execute(String str, String str2, String[] strArr) throws Exception;

    Object execute(File file, String str, String[] strArr) throws Exception;

    ExecutionResult postProcess(String str, Object obj, String str2);

    ExecutionResult postProcess(Object obj);

    void trace(Object obj);

    void println(Object obj);

    void putVariable(String str, Object obj);

    Object getVariable(String str);

    boolean hasVariable(String str);

    void purge();

    boolean executeWidget(Object obj);

    boolean isExecuting();

    static String plainCommand(String command) {
        return command.startsWith(EmitterKt.COMMENT_PREFIX) ? command.substring(1) : command;
    }

    default Object execute(File script) throws Exception {
        return execute(script, "", new String[0]);
    }

    /* loaded from: grasscutter.jar:org/jline/console/ConsoleEngine$ExecutionResult.class */
    public static class ExecutionResult {
        final int status;
        final Object result;

        public ExecutionResult(int status, Object result) {
            this.status = status;
            this.result = result;
        }

        public int status() {
            return this.status;
        }

        public Object result() {
            return this.result;
        }
    }

    /* loaded from: grasscutter.jar:org/jline/console/ConsoleEngine$WidgetCreator.class */
    public static class WidgetCreator implements Widget {
        private final ConsoleEngine consoleEngine;
        private final Object function;
        private final String name;

        public WidgetCreator(ConsoleEngine consoleEngine, String function) {
            this.consoleEngine = consoleEngine;
            this.name = function;
            this.function = consoleEngine.getVariable(function);
        }

        @Override // org.jline.reader.Widget
        public boolean apply() {
            return this.consoleEngine.executeWidget(this.function);
        }

        public String toString() {
            return this.name;
        }
    }
}
