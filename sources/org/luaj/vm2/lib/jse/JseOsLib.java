package org.luaj.vm2.lib.jse;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import org.luaj.vm2.Varargs;
import org.luaj.vm2.lib.OsLib;

/* loaded from: grasscutter.jar:org/luaj/vm2/lib/jse/JseOsLib.class */
public class JseOsLib extends OsLib {
    public static int EXEC_IOEXCEPTION = 1;
    public static int EXEC_INTERRUPTED = -2;
    public static int EXEC_ERROR = -3;

    @Override // org.luaj.vm2.lib.OsLib
    protected String getenv(String str) {
        String str2 = System.getenv(str);
        return str2 != null ? str2 : System.getProperty(str);
    }

    @Override // org.luaj.vm2.lib.OsLib
    protected Varargs execute(String str) {
        int i;
        try {
            i = new JseProcess(str, (InputStream) null, this.globals.STDOUT, this.globals.STDERR).waitFor();
        } catch (IOException e) {
            i = EXEC_IOEXCEPTION;
        } catch (InterruptedException e2) {
            i = EXEC_INTERRUPTED;
        } catch (Throwable th) {
            i = EXEC_ERROR;
        }
        return i == 0 ? varargsOf(TRUE, valueOf("exit"), ZERO) : varargsOf(NIL, valueOf("signal"), valueOf(i));
    }

    @Override // org.luaj.vm2.lib.OsLib
    protected void remove(String str) throws IOException {
        File file = new File(str);
        if (!file.exists()) {
            throw new IOException("No such file or directory");
        } else if (!file.delete()) {
            throw new IOException("Failed to delete");
        }
    }

    @Override // org.luaj.vm2.lib.OsLib
    protected void rename(String str, String str2) throws IOException {
        File file = new File(str);
        if (!file.exists()) {
            throw new IOException("No such file or directory");
        } else if (!file.renameTo(new File(str2))) {
            throw new IOException("Failed to delete");
        }
    }

    /* access modifiers changed from: protected */
    @Override // org.luaj.vm2.lib.OsLib
    public String tmpname() {
        try {
            return File.createTempFile(TMP_PREFIX, TMP_SUFFIX).getName();
        } catch (IOException e) {
            return tmpname();
        }
    }
}
