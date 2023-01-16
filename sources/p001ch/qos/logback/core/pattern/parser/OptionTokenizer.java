package p001ch.qos.logback.core.pattern.parser;

import java.util.ArrayList;
import java.util.List;
import p001ch.qos.logback.core.pattern.parser.TokenStream;
import p001ch.qos.logback.core.pattern.util.AsIsEscapeUtil;
import p001ch.qos.logback.core.pattern.util.IEscapeUtil;
import p001ch.qos.logback.core.spi.ScanException;

/* renamed from: ch.qos.logback.core.pattern.parser.OptionTokenizer */
/* loaded from: grasscutter.jar:ch/qos/logback/core/pattern/parser/OptionTokenizer.class */
public class OptionTokenizer {
    private static final int EXPECTING_STATE = 0;
    private static final int RAW_COLLECTING_STATE = 1;
    private static final int QUOTED_COLLECTING_STATE = 2;
    final IEscapeUtil escapeUtil;
    final TokenStream tokenStream;
    final String pattern;
    final int patternLength;
    char quoteChar;
    int state;

    /* access modifiers changed from: package-private */
    public OptionTokenizer(TokenStream tokenStream) {
        this(tokenStream, new AsIsEscapeUtil());
    }

    OptionTokenizer(TokenStream tokenStream, IEscapeUtil escapeUtil) {
        this.state = 0;
        this.tokenStream = tokenStream;
        this.pattern = tokenStream.pattern;
        this.patternLength = tokenStream.patternLength;
        this.escapeUtil = escapeUtil;
    }

    /* access modifiers changed from: package-private */
    public void tokenize(char firstChar, List<Token> tokenList) throws ScanException {
        StringBuffer buf = new StringBuffer();
        List<String> optionList = new ArrayList<>();
        char c = firstChar;
        while (this.tokenStream.pointer < this.patternLength) {
            switch (this.state) {
                case 0:
                    switch (c) {
                        case '\t':
                        case '\n':
                        case '\r':
                        case ' ':
                        case ',':
                            break;
                        case '\"':
                        case '\'':
                            this.state = 2;
                            this.quoteChar = c;
                            continue;
                        case '}':
                            emitOptionToken(tokenList, optionList);
                            return;
                        default:
                            buf.append(c);
                            this.state = 1;
                            continue;
                    }
                case 1:
                    switch (c) {
                        case ',':
                            optionList.add(buf.toString().trim());
                            buf.setLength(0);
                            this.state = 0;
                            continue;
                        case '}':
                            optionList.add(buf.toString().trim());
                            emitOptionToken(tokenList, optionList);
                            return;
                        default:
                            buf.append(c);
                            continue;
                    }
                case 2:
                    if (c != this.quoteChar) {
                        if (c != '\\') {
                            buf.append(c);
                            break;
                        } else {
                            escape(String.valueOf(this.quoteChar), buf);
                            break;
                        }
                    } else {
                        optionList.add(buf.toString());
                        buf.setLength(0);
                        this.state = 0;
                        break;
                    }
            }
            c = this.pattern.charAt(this.tokenStream.pointer);
            this.tokenStream.pointer++;
        }
        if (c != '}') {
            throw new ScanException("Unexpected end of pattern string in OptionTokenizer");
        } else if (this.state == 0) {
            emitOptionToken(tokenList, optionList);
        } else if (this.state == 1) {
            optionList.add(buf.toString().trim());
            emitOptionToken(tokenList, optionList);
        } else {
            throw new ScanException("Unexpected end of pattern string in OptionTokenizer");
        }
    }

    void emitOptionToken(List<Token> tokenList, List<String> optionList) {
        tokenList.add(new Token(1006, optionList));
        this.tokenStream.state = TokenStream.TokenizerState.LITERAL_STATE;
    }

    void escape(String escapeChars, StringBuffer buf) {
        if (this.tokenStream.pointer < this.patternLength) {
            String str = this.pattern;
            TokenStream tokenStream = this.tokenStream;
            int i = tokenStream.pointer;
            tokenStream.pointer = i + 1;
            this.escapeUtil.escape(escapeChars, buf, str.charAt(i), this.tokenStream.pointer);
        }
    }
}
