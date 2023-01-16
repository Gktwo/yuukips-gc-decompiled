package org.jline.widget;

import org.jline.reader.Buffer;
import org.jline.reader.LineReader;
import org.jline.reader.impl.BufferImpl;

/* loaded from: grasscutter.jar:org/jline/widget/AutosuggestionWidgets.class */
public class AutosuggestionWidgets extends Widgets {
    private boolean enabled = false;

    public AutosuggestionWidgets(LineReader reader) {
        super(reader);
        if (existsWidget("_autosuggest-forward-char")) {
            throw new IllegalStateException("AutosuggestionWidgets already created!");
        }
        addWidget("_autosuggest-forward-char", this::autosuggestForwardChar);
        addWidget("_autosuggest-end-of-line", this::autosuggestEndOfLine);
        addWidget("_autosuggest-forward-word", this::partialAccept);
        addWidget(Widgets.AUTOSUGGEST_TOGGLE, this::toggleKeyBindings);
    }

    public void disable() {
        defaultBindings();
    }

    public void enable() {
        customBindings();
    }

    public boolean partialAccept() {
        Buffer buffer = buffer();
        if (buffer.cursor() == buffer.length()) {
            int curPos = buffer.cursor();
            buffer.write(tailTip());
            buffer.cursor(curPos);
            replaceBuffer(buffer);
            callWidget(LineReader.FORWARD_WORD);
            Buffer newBuf = new BufferImpl();
            newBuf.write(buffer().substring(0, buffer().cursor()));
            replaceBuffer(newBuf);
            return true;
        }
        callWidget(LineReader.FORWARD_WORD);
        return true;
    }

    public boolean autosuggestForwardChar() {
        return accept(LineReader.FORWARD_CHAR);
    }

    public boolean autosuggestEndOfLine() {
        return accept(LineReader.END_OF_LINE);
    }

    public boolean toggleKeyBindings() {
        if (this.enabled) {
            defaultBindings();
        } else {
            customBindings();
        }
        return this.enabled;
    }

    private boolean accept(String widget) {
        Buffer buffer = buffer();
        if (buffer.cursor() == buffer.length()) {
            putString(tailTip());
            return true;
        }
        callWidget(widget);
        return true;
    }

    private void customBindings() {
        if (!this.enabled) {
            aliasWidget("_autosuggest-forward-char", LineReader.FORWARD_CHAR);
            aliasWidget("_autosuggest-end-of-line", LineReader.END_OF_LINE);
            aliasWidget("_autosuggest-forward-word", LineReader.FORWARD_WORD);
            this.enabled = true;
            setSuggestionType(LineReader.SuggestionType.HISTORY);
        }
    }

    private void defaultBindings() {
        if (this.enabled) {
            aliasWidget(".forward-char", LineReader.FORWARD_CHAR);
            aliasWidget(".end-of-line", LineReader.END_OF_LINE);
            aliasWidget(".forward-word", LineReader.FORWARD_WORD);
            this.enabled = false;
            setSuggestionType(LineReader.SuggestionType.NONE);
        }
    }
}
