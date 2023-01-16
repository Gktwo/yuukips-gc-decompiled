package p001ch.qos.logback.core.subst;

import java.util.List;
import p001ch.qos.logback.core.CoreConstants;
import p001ch.qos.logback.core.spi.ScanException;
import p001ch.qos.logback.core.subst.Node;
import p001ch.qos.logback.core.subst.Token;

/* renamed from: ch.qos.logback.core.subst.Parser */
/* loaded from: grasscutter.jar:ch/qos/logback/core/subst/Parser.class */
public class Parser {
    final List<Token> tokenList;
    int pointer = 0;

    public Parser(List<Token> tokenList) {
        this.tokenList = tokenList;
    }

    public Node parse() throws ScanException {
        if (this.tokenList == null || this.tokenList.isEmpty()) {
            return null;
        }
        return m1587E();
    }

    /* renamed from: E */
    private Node m1587E() throws ScanException {
        Node t = m1586T();
        if (t == null) {
            return null;
        }
        Node eOpt = Eopt();
        if (eOpt != null) {
            t.append(eOpt);
        }
        return t;
    }

    private Node Eopt() throws ScanException {
        if (peekAtCurentToken() == null) {
            return null;
        }
        return m1587E();
    }

    /* renamed from: T */
    private Node m1586T() throws ScanException {
        Token t;
        switch (peekAtCurentToken().type) {
            case LITERAL:
                advanceTokenPointer();
                return makeNewLiteralNode(t.payload);
            case CURLY_LEFT:
                advanceTokenPointer();
                Node innerNode = m1588C();
                expectCurlyRight(peekAtCurentToken());
                advanceTokenPointer();
                Node curlyLeft = makeNewLiteralNode(CoreConstants.LEFT_ACCOLADE);
                curlyLeft.append(innerNode);
                curlyLeft.append(makeNewLiteralNode(CoreConstants.RIGHT_ACCOLADE));
                return curlyLeft;
            case START:
                advanceTokenPointer();
                Node v = m1585V();
                expectCurlyRight(peekAtCurentToken());
                advanceTokenPointer();
                return v;
            default:
                return null;
        }
    }

    private Node makeNewLiteralNode(String s) {
        return new Node(Node.Type.LITERAL, s);
    }

    /* renamed from: V */
    private Node m1585V() throws ScanException {
        Node variable = new Node(Node.Type.VARIABLE, m1587E());
        if (isDefaultToken(peekAtCurentToken())) {
            advanceTokenPointer();
            variable.defaultPart = m1587E();
        }
        return variable;
    }

    /* renamed from: C */
    private Node m1588C() throws ScanException {
        Node e0 = m1587E();
        if (isDefaultToken(peekAtCurentToken())) {
            advanceTokenPointer();
            e0.append(makeNewLiteralNode(CoreConstants.DEFAULT_VALUE_SEPARATOR));
            e0.append(m1587E());
        }
        return e0;
    }

    private boolean isDefaultToken(Token t) {
        return t != null && t.type == Token.Type.DEFAULT;
    }

    void advanceTokenPointer() {
        this.pointer++;
    }

    void expectNotNull(Token t, String expected) {
        if (t == null) {
            throw new IllegalArgumentException("All tokens consumed but was expecting \"" + expected + "\"");
        }
    }

    void expectCurlyRight(Token t) throws ScanException {
        expectNotNull(t, "}");
        if (t.type != Token.Type.CURLY_RIGHT) {
            throw new ScanException("Expecting }");
        }
    }

    Token peekAtCurentToken() {
        if (this.pointer < this.tokenList.size()) {
            return this.tokenList.get(this.pointer);
        }
        return null;
    }
}
