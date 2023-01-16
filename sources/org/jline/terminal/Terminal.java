package org.jline.terminal;

import java.io.Closeable;
import java.io.Flushable;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.function.IntConsumer;
import java.util.function.IntSupplier;
import org.jline.terminal.impl.NativeSignalHandler;
import org.jline.utils.ColorPalette;
import org.jline.utils.InfoCmp;
import org.jline.utils.NonBlockingReader;

/* WARNING: Classes with same name are omitted:
  
 */
/* loaded from: grasscutter.jar:org/jline/terminal/Terminal.class */
public interface Terminal extends Closeable, Flushable {
    public static final String TYPE_DUMB = "dumb";
    public static final String TYPE_DUMB_COLOR = "dumb-color";

    /* WARNING: Classes with same name are omitted:
  
 */
    /* loaded from: grasscutter.jar:org/jline/terminal/Terminal$MouseTracking.class */
    public enum MouseTracking {
        Off,
        Normal,
        Button,
        Any
    }

    /* WARNING: Classes with same name are omitted:
  
 */
    /* loaded from: grasscutter.jar:org/jline/terminal/Terminal$Signal.class */
    public enum Signal {
        INT,
        QUIT,
        TSTP,
        CONT,
        INFO,
        WINCH
    }

    /* WARNING: Classes with same name are omitted:
  
 */
    /* loaded from: grasscutter.jar:org/jline/terminal/Terminal$SignalHandler.class */
    public interface SignalHandler {
        public static final SignalHandler SIG_DFL = NativeSignalHandler.SIG_DFL;
        public static final SignalHandler SIG_IGN = NativeSignalHandler.SIG_IGN;

        void handle(Signal signal);
    }

    String getName();

    SignalHandler handle(Signal signal, SignalHandler signalHandler);

    void raise(Signal signal);

    NonBlockingReader reader();

    PrintWriter writer();

    Charset encoding();

    InputStream input();

    OutputStream output();

    boolean canPauseResume();

    void pause();

    void pause(boolean z) throws InterruptedException;

    void resume();

    boolean paused();

    Attributes enterRawMode();

    boolean echo();

    boolean echo(boolean z);

    Attributes getAttributes();

    void setAttributes(Attributes attributes);

    Size getSize();

    void setSize(Size size);

    @Override // java.io.Flushable
    void flush();

    String getType();

    boolean puts(InfoCmp.Capability capability, Object... objArr);

    boolean getBooleanCapability(InfoCmp.Capability capability);

    Integer getNumericCapability(InfoCmp.Capability capability);

    String getStringCapability(InfoCmp.Capability capability);

    Cursor getCursorPosition(IntConsumer intConsumer);

    boolean hasMouseSupport();

    boolean trackMouse(MouseTracking mouseTracking);

    MouseEvent readMouseEvent();

    MouseEvent readMouseEvent(IntSupplier intSupplier);

    boolean hasFocusSupport();

    boolean trackFocus(boolean z);

    ColorPalette getPalette();

    default int getWidth() {
        return getSize().getColumns();
    }

    default int getHeight() {
        return getSize().getRows();
    }

    default Size getBufferSize() {
        return getSize();
    }
}
