package org.luaj.vm2.script;

import java.util.Arrays;
import java.util.List;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineFactory;
import p013io.javalin.http.sse.EmitterKt;

/* loaded from: grasscutter.jar:org/luaj/vm2/script/LuaScriptEngineFactory.class */
public class LuaScriptEngineFactory implements ScriptEngineFactory {
    private static final String[] EXTENSIONS = {"lua", ".lua"};
    private static final String[] MIMETYPES = {"text/lua", "application/lua"};
    private static final String[] NAMES = {"lua", "luaj"};
    private List extensions = Arrays.asList(EXTENSIONS);
    private List mimeTypes = Arrays.asList(MIMETYPES);
    private List names = Arrays.asList(NAMES);

    public String getEngineName() {
        return getScriptEngine().get("javax.script.engine").toString();
    }

    public String getEngineVersion() {
        return getScriptEngine().get("javax.script.engine_version").toString();
    }

    public List getExtensions() {
        return this.extensions;
    }

    public List getMimeTypes() {
        return this.mimeTypes;
    }

    public List getNames() {
        return this.names;
    }

    public String getLanguageName() {
        return getScriptEngine().get("javax.script.language").toString();
    }

    public String getLanguageVersion() {
        return getScriptEngine().get("javax.script.language_version").toString();
    }

    public Object getParameter(String str) {
        return getScriptEngine().get(str).toString();
    }

    public String getMethodCallSyntax(String str, String str2, String... strArr) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str + EmitterKt.COMMENT_PREFIX + str2 + "(");
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            if (i > 0) {
                stringBuffer.append(',');
            }
            stringBuffer.append(strArr[i]);
        }
        stringBuffer.append(")");
        return stringBuffer.toString();
    }

    public String getOutputStatement(String str) {
        return "print(" + str + ")";
    }

    public String getProgram(String... strArr) {
        StringBuffer stringBuffer = new StringBuffer();
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            if (i > 0) {
                stringBuffer.append('\n');
            }
            stringBuffer.append(strArr[i]);
        }
        return stringBuffer.toString();
    }

    public ScriptEngine getScriptEngine() {
        return new LuaScriptEngine();
    }
}
