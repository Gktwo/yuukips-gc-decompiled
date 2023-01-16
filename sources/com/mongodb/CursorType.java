package com.mongodb;

/* loaded from: grasscutter.jar:com/mongodb/CursorType.class */
public enum CursorType {
    NonTailable {
        @Override // com.mongodb.CursorType
        public boolean isTailable() {
            return false;
        }
    },
    Tailable {
        @Override // com.mongodb.CursorType
        public boolean isTailable() {
            return true;
        }
    },
    TailableAwait {
        @Override // com.mongodb.CursorType
        public boolean isTailable() {
            return true;
        }
    };

    public abstract boolean isTailable();
}
