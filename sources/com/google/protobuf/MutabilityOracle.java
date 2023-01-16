package com.google.protobuf;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:com/google/protobuf/MutabilityOracle.class */
public interface MutabilityOracle {
    public static final MutabilityOracle IMMUTABLE = new MutabilityOracle() { // from class: com.google.protobuf.MutabilityOracle.1
        @Override // com.google.protobuf.MutabilityOracle
        public void ensureMutable() {
            throw new UnsupportedOperationException();
        }
    };

    void ensureMutable();
}
