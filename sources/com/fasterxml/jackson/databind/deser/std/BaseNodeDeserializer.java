package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.StreamReadCapability;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ContainerNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.type.LogicalType;
import com.fasterxml.jackson.databind.util.RawValue;
import emu.grasscutter.net.packet.PacketOpcodes;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: JsonNodeDeserializer.java */
/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:com/fasterxml/jackson/databind/deser/std/BaseNodeDeserializer.class */
public abstract class BaseNodeDeserializer<T extends JsonNode> extends StdDeserializer<T> {
    protected final Boolean _supportsUpdates;

    public BaseNodeDeserializer(Class<T> vc, Boolean supportsUpdates) {
        super((Class<?>) vc);
        this._supportsUpdates = supportsUpdates;
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer, com.fasterxml.jackson.databind.JsonDeserializer
    public Object deserializeWithType(JsonParser p, DeserializationContext ctxt, TypeDeserializer typeDeserializer) throws IOException {
        return typeDeserializer.deserializeTypedFromAny(p, ctxt);
    }

    @Override // com.fasterxml.jackson.databind.JsonDeserializer
    public LogicalType logicalType() {
        return LogicalType.Untyped;
    }

    @Override // com.fasterxml.jackson.databind.JsonDeserializer
    public boolean isCachable() {
        return true;
    }

    @Override // com.fasterxml.jackson.databind.JsonDeserializer
    public Boolean supportsUpdate(DeserializationConfig config) {
        return this._supportsUpdates;
    }

    protected void _handleDuplicateField(JsonParser p, DeserializationContext ctxt, JsonNodeFactory nodeFactory, String fieldName, ObjectNode objectNode, JsonNode oldValue, JsonNode newValue) throws IOException {
        if (ctxt.isEnabled(DeserializationFeature.FAIL_ON_READING_DUP_TREE_KEY)) {
            ctxt.reportInputMismatch(JsonNode.class, "Duplicate field '%s' for `ObjectNode`: not allowed when `DeserializationFeature.FAIL_ON_READING_DUP_TREE_KEY` enabled", fieldName);
        }
        if (!ctxt.isEnabled(StreamReadCapability.DUPLICATE_PROPERTIES)) {
            return;
        }
        if (oldValue.isArray()) {
            ((ArrayNode) oldValue).add(newValue);
            objectNode.replace(fieldName, oldValue);
            return;
        }
        ArrayNode arr = nodeFactory.arrayNode();
        arr.add(oldValue);
        arr.add(newValue);
        objectNode.replace(fieldName, arr);
    }

    protected final ObjectNode _deserializeObjectAtName(JsonParser p, DeserializationContext ctxt, JsonNodeFactory nodeFactory, ContainerStack stack) throws IOException {
        JsonNode value;
        ObjectNode node = nodeFactory.objectNode();
        String key = p.currentName();
        while (key != null) {
            JsonToken t = p.nextToken();
            if (t == null) {
                t = JsonToken.NOT_AVAILABLE;
            }
            switch (t.m1480id()) {
                case 1:
                    value = _deserializeContainerNoRecursion(p, ctxt, nodeFactory, stack, nodeFactory.objectNode());
                    break;
                case 3:
                    value = _deserializeContainerNoRecursion(p, ctxt, nodeFactory, stack, nodeFactory.arrayNode());
                    break;
                default:
                    value = _deserializeAnyScalar(p, ctxt);
                    break;
            }
            JsonNode old = node.replace(key, value);
            if (old != null) {
                _handleDuplicateField(p, ctxt, nodeFactory, key, node, old, value);
            }
            key = p.nextFieldName();
        }
        return node;
    }

    protected final JsonNode updateObject(JsonParser p, DeserializationContext ctxt, ObjectNode node, ContainerStack stack) throws IOException {
        String key;
        JsonNode value;
        if (p.isExpectedStartObjectToken()) {
            key = p.nextFieldName();
        } else if (!p.hasToken(JsonToken.FIELD_NAME)) {
            return (JsonNode) deserialize(p, ctxt);
        } else {
            key = p.currentName();
        }
        JsonNodeFactory nodeFactory = ctxt.getNodeFactory();
        while (key != null) {
            JsonToken t = p.nextToken();
            JsonNode old = node.get(key);
            if (old != null) {
                if (old instanceof ObjectNode) {
                    if (t == JsonToken.START_OBJECT) {
                        JsonNode newValue = updateObject(p, ctxt, (ObjectNode) old, stack);
                        if (newValue != old) {
                            node.set(key, newValue);
                        }
                        key = p.nextFieldName();
                    }
                } else if ((old instanceof ArrayNode) && t == JsonToken.START_ARRAY) {
                    _deserializeContainerNoRecursion(p, ctxt, nodeFactory, stack, (ArrayNode) old);
                    key = p.nextFieldName();
                }
            }
            if (t == null) {
                t = JsonToken.NOT_AVAILABLE;
            }
            switch (t.m1480id()) {
                case 1:
                    value = _deserializeContainerNoRecursion(p, ctxt, nodeFactory, stack, nodeFactory.objectNode());
                    break;
                case 2:
                case 4:
                case 5:
                case 8:
                default:
                    value = _deserializeRareScalar(p, ctxt);
                    break;
                case 3:
                    value = _deserializeContainerNoRecursion(p, ctxt, nodeFactory, stack, nodeFactory.arrayNode());
                    break;
                case 6:
                    value = nodeFactory.textNode(p.getText());
                    break;
                case 7:
                    value = _fromInt(p, ctxt, nodeFactory);
                    break;
                case 9:
                    value = nodeFactory.booleanNode(true);
                    break;
                case 10:
                    value = nodeFactory.booleanNode(false);
                    break;
                case 11:
                    value = nodeFactory.nullNode();
                    break;
            }
            node.set(key, value);
            key = p.nextFieldName();
        }
        return node;
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x013c  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x014b A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected final com.fasterxml.jackson.databind.node.ContainerNode<?> _deserializeContainerNoRecursion(com.fasterxml.jackson.core.JsonParser r10, com.fasterxml.jackson.databind.DeserializationContext r11, com.fasterxml.jackson.databind.node.JsonNodeFactory r12, com.fasterxml.jackson.databind.deser.std.BaseNodeDeserializer.ContainerStack r13, com.fasterxml.jackson.databind.node.ContainerNode<?> r14) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 600
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.deser.std.BaseNodeDeserializer._deserializeContainerNoRecursion(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext, com.fasterxml.jackson.databind.node.JsonNodeFactory, com.fasterxml.jackson.databind.deser.std.BaseNodeDeserializer$ContainerStack, com.fasterxml.jackson.databind.node.ContainerNode):com.fasterxml.jackson.databind.node.ContainerNode");
    }

    protected final JsonNode _deserializeAnyScalar(JsonParser p, DeserializationContext ctxt) throws IOException {
        JsonNodeFactory nodeF = ctxt.getNodeFactory();
        switch (p.currentTokenId()) {
            case 2:
                return nodeF.objectNode();
            case 3:
            case 4:
            case 5:
            default:
                return (JsonNode) ctxt.handleUnexpectedToken(handledType(), p);
            case 6:
                return nodeF.textNode(p.getText());
            case 7:
                return _fromInt(p, ctxt, nodeF);
            case 8:
                return _fromFloat(p, ctxt, nodeF);
            case 9:
                return nodeF.booleanNode(true);
            case 10:
                return nodeF.booleanNode(false);
            case 11:
                return nodeF.nullNode();
            case 12:
                return _fromEmbedded(p, ctxt);
        }
    }

    protected final JsonNode _deserializeRareScalar(JsonParser p, DeserializationContext ctxt) throws IOException {
        switch (p.currentTokenId()) {
            case 2:
                return ctxt.getNodeFactory().objectNode();
            case 8:
                return _fromFloat(p, ctxt, ctxt.getNodeFactory());
            case 12:
                return _fromEmbedded(p, ctxt);
            default:
                return (JsonNode) ctxt.handleUnexpectedToken(handledType(), p);
        }
    }

    protected final JsonNode _fromInt(JsonParser p, int coercionFeatures, JsonNodeFactory nodeFactory) throws IOException {
        if (coercionFeatures == 0) {
            JsonParser.NumberType nt = p.getNumberType();
            if (nt == JsonParser.NumberType.INT) {
                return nodeFactory.numberNode(p.getIntValue());
            }
            if (nt == JsonParser.NumberType.LONG) {
                return nodeFactory.numberNode(p.getLongValue());
            }
            return nodeFactory.numberNode(p.getBigIntegerValue());
        } else if (DeserializationFeature.USE_BIG_INTEGER_FOR_INTS.enabledIn(coercionFeatures)) {
            return nodeFactory.numberNode(p.getBigIntegerValue());
        } else {
            return nodeFactory.numberNode(p.getLongValue());
        }
    }

    protected final JsonNode _fromInt(JsonParser p, DeserializationContext ctxt, JsonNodeFactory nodeFactory) throws IOException {
        JsonParser.NumberType nt;
        int feats = ctxt.getDeserializationFeatures();
        if ((feats & F_MASK_INT_COERCIONS) == 0) {
            nt = p.getNumberType();
        } else if (DeserializationFeature.USE_BIG_INTEGER_FOR_INTS.enabledIn(feats)) {
            nt = JsonParser.NumberType.BIG_INTEGER;
        } else if (DeserializationFeature.USE_LONG_FOR_INTS.enabledIn(feats)) {
            nt = JsonParser.NumberType.LONG;
        } else {
            nt = p.getNumberType();
        }
        if (nt == JsonParser.NumberType.INT) {
            return nodeFactory.numberNode(p.getIntValue());
        }
        if (nt == JsonParser.NumberType.LONG) {
            return nodeFactory.numberNode(p.getLongValue());
        }
        return nodeFactory.numberNode(p.getBigIntegerValue());
    }

    protected final JsonNode _fromFloat(JsonParser p, DeserializationContext ctxt, JsonNodeFactory nodeFactory) throws IOException {
        JsonParser.NumberType nt = p.getNumberType();
        if (nt == JsonParser.NumberType.BIG_DECIMAL) {
            return nodeFactory.numberNode(p.getDecimalValue());
        }
        if (ctxt.isEnabled(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS)) {
            if (p.isNaN()) {
                return nodeFactory.numberNode(p.getDoubleValue());
            }
            return nodeFactory.numberNode(p.getDecimalValue());
        } else if (nt == JsonParser.NumberType.FLOAT) {
            return nodeFactory.numberNode(p.getFloatValue());
        } else {
            return nodeFactory.numberNode(p.getDoubleValue());
        }
    }

    protected final JsonNode _fromEmbedded(JsonParser p, DeserializationContext ctxt) throws IOException {
        JsonNodeFactory nodeF = ctxt.getNodeFactory();
        Object ob = p.getEmbeddedObject();
        if (ob == null) {
            return nodeF.nullNode();
        }
        if (ob.getClass() == byte[].class) {
            return nodeF.binaryNode((byte[]) ob);
        }
        if (ob instanceof RawValue) {
            return nodeF.rawValueNode((RawValue) ob);
        }
        if (ob instanceof JsonNode) {
            return (JsonNode) ob;
        }
        return nodeF.pojoNode(ob);
    }

    /* compiled from: JsonNodeDeserializer.java */
    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:com/fasterxml/jackson/databind/deser/std/BaseNodeDeserializer$ContainerStack.class */
    public static final class ContainerStack {
        private ContainerNode[] _stack;
        private int _top;
        private int _end;

        public int size() {
            return this._top;
        }

        public void push(ContainerNode node) {
            if (this._top < this._end) {
                ContainerNode[] containerNodeArr = this._stack;
                int i = this._top;
                this._top = i + 1;
                containerNodeArr[i] = node;
                return;
            }
            if (this._stack == null) {
                this._end = 10;
                this._stack = new ContainerNode[this._end];
            } else {
                this._end += Math.min((int) PacketOpcodes.MechanicusOpenNotify, Math.max(20, this._end >> 1));
                this._stack = (ContainerNode[]) Arrays.copyOf(this._stack, this._end);
            }
            ContainerNode[] containerNodeArr2 = this._stack;
            int i2 = this._top;
            this._top = i2 + 1;
            containerNodeArr2[i2] = node;
        }

        public ContainerNode popOrNull() {
            if (this._top == 0) {
                return null;
            }
            ContainerNode[] containerNodeArr = this._stack;
            int i = this._top - 1;
            this._top = i;
            return containerNodeArr[i];
        }
    }
}
