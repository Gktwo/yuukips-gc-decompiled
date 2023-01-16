package net.bytebuddy.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.AccessController;
import net.bytebuddy.utility.dispatcher.JavaDispatcher;

/* loaded from: grasscutter.jar:net/bytebuddy/utility/FileSystem.class */
public enum FileSystem {
    INSTANCE;
    
    private static final Dispatcher DISPATCHER = (Dispatcher) AccessController.doPrivileged(JavaDispatcher.m62of(Dispatcher.class));
    private static final Files FILES = (Files) AccessController.doPrivileged(JavaDispatcher.m62of(Files.class));
    private static final StandardCopyOption STANDARD_COPY_OPTION = (StandardCopyOption) AccessController.doPrivileged(JavaDispatcher.m62of(StandardCopyOption.class));

    /* access modifiers changed from: protected */
    @JavaDispatcher.Proxied("java.io.File")
    /* loaded from: grasscutter.jar:net/bytebuddy/utility/FileSystem$Dispatcher.class */
    public interface Dispatcher {
        Object toPath(File file) throws IOException;
    }

    /* access modifiers changed from: protected */
    @JavaDispatcher.Proxied("java.nio.file.Files")
    /* loaded from: grasscutter.jar:net/bytebuddy/utility/FileSystem$Files.class */
    public interface Files {
        @JavaDispatcher.IsStatic
        Object copy(@JavaDispatcher.Proxied("java.nio.file.Path") Object obj, @JavaDispatcher.Proxied("java.nio.file.Path") Object obj2, @JavaDispatcher.Proxied("java.nio.file.CopyOption") Object[] objArr) throws IOException;

        @JavaDispatcher.IsStatic
        Object move(@JavaDispatcher.Proxied("java.nio.file.Path") Object obj, @JavaDispatcher.Proxied("java.nio.file.Path") Object obj2, @JavaDispatcher.Proxied("java.nio.file.CopyOption") Object[] objArr) throws IOException;
    }

    /* access modifiers changed from: protected */
    @JavaDispatcher.Proxied("java.nio.file.StandardCopyOption")
    /* loaded from: grasscutter.jar:net/bytebuddy/utility/FileSystem$StandardCopyOption.class */
    public interface StandardCopyOption {
        @JavaDispatcher.Defaults
        @JavaDispatcher.Container
        Object[] toArray(int i);

        @JavaDispatcher.IsStatic
        Object valueOf(String str);
    }

    public void copy(File source, File target) throws IOException {
        Object[] option = STANDARD_COPY_OPTION.toArray(1);
        if (option.length == 0) {
            InputStream inputStream = new FileInputStream(source);
            try {
                OutputStream outputStream = new FileOutputStream(target);
                byte[] buffer = new byte[1024];
                while (true) {
                    int length = inputStream.read(buffer);
                    if (length != -1) {
                        outputStream.write(buffer, 0, length);
                    } else {
                        outputStream.close();
                        return;
                    }
                }
            } finally {
                inputStream.close();
            }
        } else {
            option[0] = STANDARD_COPY_OPTION.valueOf("REPLACE_EXISTING");
            FILES.copy(DISPATCHER.toPath(source), DISPATCHER.toPath(target), option);
        }
    }

    public void move(File source, File target) throws IOException {
        Object[] option = STANDARD_COPY_OPTION.toArray(1);
        if (option.length == 0) {
            InputStream inputStream = new FileInputStream(source);
            try {
                OutputStream outputStream = new FileOutputStream(target);
                byte[] buffer = new byte[1024];
                while (true) {
                    int length = inputStream.read(buffer);
                    if (length == -1) {
                        break;
                    }
                    outputStream.write(buffer, 0, length);
                }
                outputStream.close();
                if (!source.delete()) {
                    source.deleteOnExit();
                }
            } finally {
                inputStream.close();
            }
        } else {
            option[0] = STANDARD_COPY_OPTION.valueOf("REPLACE_EXISTING");
            FILES.move(DISPATCHER.toPath(source), DISPATCHER.toPath(target), option);
        }
    }
}
