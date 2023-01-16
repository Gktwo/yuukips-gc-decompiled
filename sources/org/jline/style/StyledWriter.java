package org.jline.style;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Locale;
import java.util.Objects;
import javax.annotation.Nonnull;
import org.jline.terminal.Terminal;

/* loaded from: grasscutter.jar:org/jline/style/StyledWriter.class */
public class StyledWriter extends PrintWriter {
    private final Terminal terminal;
    private final StyleExpression expression;

    public StyledWriter(Writer out, Terminal terminal, StyleResolver resolver, boolean autoFlush) {
        super(out, autoFlush);
        this.terminal = (Terminal) Objects.requireNonNull(terminal);
        this.expression = new StyleExpression(resolver);
    }

    public StyledWriter(OutputStream out, Terminal terminal, StyleResolver resolver, boolean autoFlush) {
        super(out, autoFlush);
        this.terminal = (Terminal) Objects.requireNonNull(terminal);
        this.expression = new StyleExpression(resolver);
    }

    @Override // java.io.PrintWriter, java.io.Writer
    public void write(@Nonnull String value) {
        write(this.expression.evaluate(value).toAnsi(this.terminal));
    }

    @Override // java.io.PrintWriter
    public PrintWriter format(@Nonnull String format, Object... args) {
        print(String.format(format, args));
        return this;
    }

    @Override // java.io.PrintWriter
    public PrintWriter format(Locale locale, @Nonnull String format, Object... args) {
        print(String.format(locale, format, args));
        return this;
    }
}
