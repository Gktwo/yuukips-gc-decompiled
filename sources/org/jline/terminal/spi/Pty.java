package org.jline.terminal.spi;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.jline.terminal.Attributes;
import org.jline.terminal.Size;

/* WARNING: Classes with same name are omitted:
  
 */
/* loaded from: grasscutter.jar:org/jline/terminal/spi/Pty.class */
public interface Pty extends Closeable {
    InputStream getMasterInput() throws IOException;

    OutputStream getMasterOutput() throws IOException;

    InputStream getSlaveInput() throws IOException;

    OutputStream getSlaveOutput() throws IOException;

    Attributes getAttr() throws IOException;

    void setAttr(Attributes attributes) throws IOException;

    Size getSize() throws IOException;

    void setSize(Size size) throws IOException;
}
