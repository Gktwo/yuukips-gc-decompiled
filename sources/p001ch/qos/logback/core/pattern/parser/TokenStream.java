package p001ch.qos.logback.core.pattern.parser;

import java.util.ArrayList;
import java.util.List;
import p001ch.qos.logback.core.pattern.util.IEscapeUtil;
import p001ch.qos.logback.core.pattern.util.RegularEscapeUtil;
import p001ch.qos.logback.core.pattern.util.RestrictedEscapeUtil;
import p001ch.qos.logback.core.spi.ScanException;

/* access modifiers changed from: package-private */
/* renamed from: ch.qos.logback.core.pattern.parser.TokenStream */
/* loaded from: grasscutter.jar:ch/qos/logback/core/pattern/parser/TokenStream.class */
public class TokenStream {
    final String pattern;
    final int patternLength;
    final IEscapeUtil escapeUtil;
    final IEscapeUtil optionEscapeUtil;
    TokenizerState state;
    int pointer;

    /* access modifiers changed from: package-private */
    /* renamed from: ch.qos.logback.core.pattern.parser.TokenStream$TokenizerState */
    /* loaded from: grasscutter.jar:ch/qos/logback/core/pattern/parser/TokenStream$TokenizerState.class */
    public enum TokenizerState {
        LITERAL_STATE,
        FORMAT_MODIFIER_STATE,
        KEYWORD_STATE,
        OPTION_STATE,
        RIGHT_PARENTHESIS_STATE
    }

    TokenStream(String pattern) {
        this(pattern, new RegularEscapeUtil());
    }

    /* access modifiers changed from: package-private */
    public TokenStream(String pattern, IEscapeUtil escapeUtil) {
        this.optionEscapeUtil = new RestrictedEscapeUtil();
        this.state = TokenizerState.LITERAL_STATE;
        this.pointer = 0;
        if (pattern == null || pattern.length() == 0) {
            throw new IllegalArgumentException("null or empty pattern string not allowed");
        }
        this.pattern = pattern;
        this.patternLength = pattern.length();
        this.escapeUtil = escapeUtil;
    }

    /* access modifiers changed from: package-private */
    public List tokenize() throws ScanException {
        List<Token> tokenList = new ArrayList<>();
        StringBuffer buf = new StringBuffer();
        while (this.pointer < this.patternLength) {
            char c = this.pattern.charAt(this.pointer);
            this.pointer++;
            switch (this.state) {
                case LITERAL_STATE:
                    handleLiteralState(c, tokenList, buf);
                    break;
                case FORMAT_MODIFIER_STATE:
                    handleFormatModifierState(c, tokenList, buf);
                    break;
                case OPTION_STATE:
                    processOption(c, tokenList, buf);
                    break;
                case KEYWORD_STATE:
                    handleKeywordState(c, tokenList, buf);
                    break;
                case RIGHT_PARENTHESIS_STATE:
                    handleRightParenthesisState(c, tokenList, buf);
                    break;
            }
        }
        switch (this.state) {
            case LITERAL_STATE:
                addValuedToken(1000, buf, tokenList);
                break;
            case FORMAT_MODIFIER_STATE:
            case OPTION_STATE:
                throw new ScanException("Unexpected end of pattern string");
            case KEYWORD_STATE:
                tokenList.add(new Token(1004, buf.toString()));
                break;
            case RIGHT_PARENTHESIS_STATE:
                tokenList.add(Token.RIGHT_PARENTHESIS_TOKEN);
                break;
        }
        return tokenList;
    }

    private void handleRightParenthesisState(char c, List<Token> tokenList, StringBuffer buf) {
        tokenList.add(Token.RIGHT_PARENTHESIS_TOKEN);
        switch (c) {
            case ')':
                return;
            case '\\':
                escape("%{}", buf);
                this.state = TokenizerState.LITERAL_STATE;
                return;
            case '{':
                this.state = TokenizerState.OPTION_STATE;
                return;
            default:
                buf.append(c);
                this.state = TokenizerState.LITERAL_STATE;
                return;
        }
    }

    private void processOption(char c, List<Token> tokenList, StringBuffer buf) throws ScanException {
        new OptionTokenizer(this).tokenize(c, tokenList);
    }

    private void handleFormatModifierState(char c, List<Token> tokenList, StringBuffer buf) {
        if (c == '(') {
            addValuedToken(1002, buf, tokenList);
            tokenList.add(Token.BARE_COMPOSITE_KEYWORD_TOKEN);
            this.state = TokenizerState.LITERAL_STATE;
        } else if (Character.isJavaIdentifierStart(c)) {
            addValuedToken(1002, buf, tokenList);
            this.state = TokenizerState.KEYWORD_STATE;
            buf.append(c);
        } else {
            buf.append(c);
        }
    }

    private void handleLiteralState(char c, List<Token> tokenList, StringBuffer buf) {
        switch (c) {
            case '%':
                addValuedToken(1000, buf, tokenList);
                tokenList.add(Token.PERCENT_TOKEN);
                this.state = TokenizerState.FORMAT_MODIFIER_STATE;
                return;
            case ')':
                addValuedToken(1000, buf, tokenList);
                this.state = TokenizerState.RIGHT_PARENTHESIS_STATE;
                return;
            case '\\':
                escape("%()", buf);
                return;
            default:
                buf.append(c);
                return;
        }
    }

    private void handleKeywordState(char c, List<Token> tokenList, StringBuffer buf) {
        if (Character.isJavaIdentifierPart(c)) {
            buf.append(c);
        } else if (c == '{') {
            addValuedToken(1004, buf, tokenList);
            this.state = TokenizerState.OPTION_STATE;
        } else if (c == '(') {
            addValuedToken(1005, buf, tokenList);
            this.state = TokenizerState.LITERAL_STATE;
        } else if (c == '%') {
            addValuedToken(1004, buf, tokenList);
            tokenList.add(Token.PERCENT_TOKEN);
            this.state = TokenizerState.FORMAT_MODIFIER_STATE;
        } else if (c == ')') {
            addValuedToken(1004, buf, tokenList);
            this.state = TokenizerState.RIGHT_PARENTHESIS_STATE;
        } else {
            addValuedToken(1004, buf, tokenList);
            if (c != '\\') {
                buf.append(c);
            } else if (this.pointer < this.patternLength) {
                String str = this.pattern;
                int i = this.pointer;
                this.pointer = i + 1;
                this.escapeUtil.escape("%()", buf, str.charAt(i), this.pointer);
            }
            this.state = TokenizerState.LITERAL_STATE;
        }
    }

    void escape(String escapeChars, StringBuffer buf) {
        if (this.pointer < this.patternLength) {
            String str = this.pattern;
            int i = this.pointer;
            this.pointer = i + 1;
            this.escapeUtil.escape(escapeChars, buf, str.charAt(i), this.pointer);
        }
    }

    void optionEscape(String escapeChars, StringBuffer buf) {
        if (this.pointer < this.patternLength) {
            String str = this.pattern;
            int i = this.pointer;
            this.pointer = i + 1;
            this.optionEscapeUtil.escape(escapeChars, buf, str.charAt(i), this.pointer);
        }
    }

    private void addValuedToken(int type, StringBuffer buf, List<Token> tokenList) {
        if (buf.length() > 0) {
            tokenList.add(new Token(type, buf.toString()));
            buf.setLength(0);
        }
    }
}
