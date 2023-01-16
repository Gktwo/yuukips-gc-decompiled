package p001ch.qos.logback.core.subst;

import java.util.Iterator;
import java.util.Stack;
import p001ch.qos.logback.core.CoreConstants;
import p001ch.qos.logback.core.spi.PropertyContainer;
import p001ch.qos.logback.core.spi.ScanException;
import p001ch.qos.logback.core.util.OptionHelper;

/* renamed from: ch.qos.logback.core.subst.NodeToStringTransformer */
/* loaded from: grasscutter.jar:ch/qos/logback/core/subst/NodeToStringTransformer.class */
public class NodeToStringTransformer {
    final Node node;
    final PropertyContainer propertyContainer0;
    final PropertyContainer propertyContainer1;

    public NodeToStringTransformer(Node node, PropertyContainer propertyContainer0, PropertyContainer propertyContainer1) {
        this.node = node;
        this.propertyContainer0 = propertyContainer0;
        this.propertyContainer1 = propertyContainer1;
    }

    public NodeToStringTransformer(Node node, PropertyContainer propertyContainer0) {
        this(node, propertyContainer0, null);
    }

    public static String substituteVariable(String input, PropertyContainer pc0, PropertyContainer pc1) throws ScanException {
        return new NodeToStringTransformer(tokenizeAndParseString(input), pc0, pc1).transform();
    }

    private static Node tokenizeAndParseString(String value) throws ScanException {
        return new Parser(new Tokenizer(value).tokenize()).parse();
    }

    public String transform() throws ScanException {
        StringBuilder stringBuilder = new StringBuilder();
        compileNode(this.node, stringBuilder, new Stack<>());
        return stringBuilder.toString();
    }

    private void compileNode(Node inputNode, StringBuilder stringBuilder, Stack<Node> cycleCheckStack) throws ScanException {
        for (Node n = inputNode; n != null; n = n.next) {
            switch (n.type) {
                case LITERAL:
                    handleLiteral(n, stringBuilder);
                    break;
                case VARIABLE:
                    handleVariable(n, stringBuilder, cycleCheckStack);
                    break;
            }
        }
    }

    private void handleVariable(Node n, StringBuilder stringBuilder, Stack<Node> cycleCheckStack) throws ScanException {
        if (haveVisitedNodeAlready(n, cycleCheckStack)) {
            cycleCheckStack.push(n);
            throw new IllegalArgumentException(constructRecursionErrorMessage(cycleCheckStack));
        }
        cycleCheckStack.push(n);
        StringBuilder keyBuffer = new StringBuilder();
        compileNode((Node) n.payload, keyBuffer, cycleCheckStack);
        String key = keyBuffer.toString();
        String value = lookupKey(key);
        if (value != null) {
            compileNode(tokenizeAndParseString(value), stringBuilder, cycleCheckStack);
            cycleCheckStack.pop();
        } else if (n.defaultPart == null) {
            stringBuilder.append(key + CoreConstants.UNDEFINED_PROPERTY_SUFFIX);
            cycleCheckStack.pop();
        } else {
            Node defaultPart = (Node) n.defaultPart;
            StringBuilder defaultPartBuffer = new StringBuilder();
            compileNode(defaultPart, defaultPartBuffer, cycleCheckStack);
            cycleCheckStack.pop();
            stringBuilder.append(defaultPartBuffer.toString());
        }
    }

    private String lookupKey(String key) {
        String value;
        String value2 = this.propertyContainer0.getProperty(key);
        if (value2 != null) {
            return value2;
        }
        if (this.propertyContainer1 != null && (value = this.propertyContainer1.getProperty(key)) != null) {
            return value;
        }
        String value3 = OptionHelper.getSystemProperty(key, null);
        if (value3 != null) {
            return value3;
        }
        String value4 = OptionHelper.getEnv(key);
        if (value4 != null) {
            return value4;
        }
        return null;
    }

    private void handleLiteral(Node n, StringBuilder stringBuilder) {
        stringBuilder.append((String) n.payload);
    }

    private String variableNodeValue(Node variableNode) {
        return (String) ((Node) variableNode.payload).payload;
    }

    private String constructRecursionErrorMessage(Stack<Node> recursionNodes) {
        StringBuilder errorBuilder = new StringBuilder("Circular variable reference detected while parsing input [");
        Iterator<Node> it = recursionNodes.iterator();
        while (it.hasNext()) {
            Node stackNode = it.next();
            errorBuilder.append("${").append(variableNodeValue(stackNode)).append("}");
            if (recursionNodes.lastElement() != stackNode) {
                errorBuilder.append(" --> ");
            }
        }
        errorBuilder.append("]");
        return errorBuilder.toString();
    }

    private boolean haveVisitedNodeAlready(Node node, Stack<Node> cycleDetectionStack) {
        Iterator<Node> it = cycleDetectionStack.iterator();
        while (it.hasNext()) {
            if (equalNodes(node, it.next())) {
                return true;
            }
        }
        return false;
    }

    private boolean equalNodes(Node node1, Node node2) {
        if (node1.type != null && !node1.type.equals(node2.type)) {
            return false;
        }
        if (node1.payload != null && !node1.payload.equals(node2.payload)) {
            return false;
        }
        if (node1.defaultPart == null || node1.defaultPart.equals(node2.defaultPart)) {
            return true;
        }
        return false;
    }
}
