package p001ch.qos.logback.core.pattern.parser;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import p001ch.qos.logback.core.pattern.Converter;
import p001ch.qos.logback.core.pattern.FormatInfo;
import p001ch.qos.logback.core.pattern.IdentityCompositeConverter;
import p001ch.qos.logback.core.pattern.ReplacingCompositeConverter;
import p001ch.qos.logback.core.pattern.util.IEscapeUtil;
import p001ch.qos.logback.core.pattern.util.RegularEscapeUtil;
import p001ch.qos.logback.core.spi.ContextAwareBase;
import p001ch.qos.logback.core.spi.ScanException;

/* renamed from: ch.qos.logback.core.pattern.parser.Parser */
/* loaded from: grasscutter.jar:ch/qos/logback/core/pattern/parser/Parser.class */
public class Parser<E> extends ContextAwareBase {
    public static final String MISSING_RIGHT_PARENTHESIS = "http://logback.qos.ch/codes.html#missingRightParenthesis";
    public static final Map<String, String> DEFAULT_COMPOSITE_CONVERTER_MAP = new HashMap();
    public static final String REPLACE_CONVERTER_WORD = "replace";
    final List tokenList;
    int pointer;

    static {
        DEFAULT_COMPOSITE_CONVERTER_MAP.put(Token.BARE_COMPOSITE_KEYWORD_TOKEN.getValue().toString(), IdentityCompositeConverter.class.getName());
        DEFAULT_COMPOSITE_CONVERTER_MAP.put(REPLACE_CONVERTER_WORD, ReplacingCompositeConverter.class.getName());
    }

    Parser(TokenStream ts) throws ScanException {
        this.pointer = 0;
        this.tokenList = ts.tokenize();
    }

    public Parser(String pattern) throws ScanException {
        this(pattern, new RegularEscapeUtil());
    }

    public Parser(String pattern, IEscapeUtil escapeUtil) throws ScanException {
        this.pointer = 0;
        try {
            this.tokenList = new TokenStream(pattern, escapeUtil).tokenize();
        } catch (IllegalArgumentException npe) {
            throw new ScanException("Failed to initialize Parser", npe);
        }
    }

    public Converter<E> compile(Node top, Map converterMap) {
        Compiler<E> compiler = new Compiler<>(top, converterMap);
        compiler.setContext(this.context);
        return compiler.compile();
    }

    public Node parse() throws ScanException {
        return m1590E();
    }

    /* renamed from: E */
    Node m1590E() throws ScanException {
        Node t = m1589T();
        if (t == null) {
            return null;
        }
        Node eOpt = Eopt();
        if (eOpt != null) {
            t.setNext(eOpt);
        }
        return t;
    }

    Node Eopt() throws ScanException {
        if (getCurentToken() == null) {
            return null;
        }
        return m1590E();
    }

    /* renamed from: T */
    Node m1589T() throws ScanException {
        FormattingNode c;
        Token t = getCurentToken();
        expectNotNull(t, "a LITERAL or '%'");
        switch (t.getType()) {
            case 37:
                advanceTokenPointer();
                Token u = getCurentToken();
                expectNotNull(u, "a FORMAT_MODIFIER, SIMPLE_KEYWORD or COMPOUND_KEYWORD");
                if (u.getType() == 1002) {
                    FormatInfo fi = FormatInfo.valueOf((String) u.getValue());
                    advanceTokenPointer();
                    c = m1591C();
                    c.setFormatInfo(fi);
                } else {
                    c = m1591C();
                }
                return c;
            case 1000:
                advanceTokenPointer();
                return new Node(0, t.getValue());
            default:
                return null;
        }
    }

    /* renamed from: C */
    FormattingNode m1591C() throws ScanException {
        Token t = getCurentToken();
        expectNotNull(t, "a LEFT_PARENTHESIS or KEYWORD");
        switch (t.getType()) {
            case 1004:
                return SINGLE();
            case 1005:
                advanceTokenPointer();
                return COMPOSITE(t.getValue().toString());
            default:
                throw new IllegalStateException("Unexpected token " + t);
        }
    }

    FormattingNode SINGLE() throws ScanException {
        SimpleKeywordNode keywordNode = new SimpleKeywordNode(getNextToken().getValue());
        Token ot = getCurentToken();
        if (ot != null && ot.getType() == 1006) {
            keywordNode.setOptions((List) ot.getValue());
            advanceTokenPointer();
        }
        return keywordNode;
    }

    FormattingNode COMPOSITE(String keyword) throws ScanException {
        CompositeNode compositeNode = new CompositeNode(keyword);
        compositeNode.setChildNode(m1590E());
        Token t = getNextToken();
        if (t == null || t.getType() != 41) {
            String msg = "Expecting RIGHT_PARENTHESIS token but got " + t;
            addError(msg);
            addError("See also http://logback.qos.ch/codes.html#missingRightParenthesis");
            throw new ScanException(msg);
        }
        Token ot = getCurentToken();
        if (ot != null && ot.getType() == 1006) {
            compositeNode.setOptions((List) ot.getValue());
            advanceTokenPointer();
        }
        return compositeNode;
    }

    Token getNextToken() {
        if (this.pointer >= this.tokenList.size()) {
            return null;
        }
        List list = this.tokenList;
        int i = this.pointer;
        this.pointer = i + 1;
        return (Token) list.get(i);
    }

    Token getCurentToken() {
        if (this.pointer < this.tokenList.size()) {
            return (Token) this.tokenList.get(this.pointer);
        }
        return null;
    }

    void advanceTokenPointer() {
        this.pointer++;
    }

    void expectNotNull(Token t, String expected) {
        if (t == null) {
            throw new IllegalStateException("All tokens consumed but was expecting " + expected);
        }
    }
}
