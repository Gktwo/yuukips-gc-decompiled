package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.p003io.CharacterEscapes;
import com.fasterxml.jackson.core.p003io.SerializedString;

/* loaded from: grasscutter.jar:com/fasterxml/jackson/core/JsonpCharacterEscapes.class */
public class JsonpCharacterEscapes extends CharacterEscapes {
    private static final long serialVersionUID = 1;
    private static final int[] asciiEscapes = CharacterEscapes.standardAsciiEscapesForJSON();
    private static final SerializedString escapeFor2028 = new SerializedString("\\u2028");
    private static final SerializedString escapeFor2029 = new SerializedString("\\u2029");
    private static final JsonpCharacterEscapes sInstance = new JsonpCharacterEscapes();

    public static JsonpCharacterEscapes instance() {
        return sInstance;
    }

    @Override // com.fasterxml.jackson.core.p003io.CharacterEscapes
    public SerializableString getEscapeSequence(int ch) {
        switch (ch) {
            case 8232:
                return escapeFor2028;
            case 8233:
                return escapeFor2029;
            default:
                return null;
        }
    }

    @Override // com.fasterxml.jackson.core.p003io.CharacterEscapes
    public int[] getEscapeCodesForAscii() {
        return asciiEscapes;
    }
}
