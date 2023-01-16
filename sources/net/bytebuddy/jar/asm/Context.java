package net.bytebuddy.jar.asm;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:net/bytebuddy/jar/asm/Context.class */
public final class Context {
    Attribute[] attributePrototypes;
    int parsingOptions;
    char[] charBuffer;
    int currentMethodAccessFlags;
    String currentMethodName;
    String currentMethodDescriptor;
    Label[] currentMethodLabels;
    int currentTypeAnnotationTarget;
    TypePath currentTypeAnnotationTargetPath;
    Label[] currentLocalVariableAnnotationRangeStarts;
    Label[] currentLocalVariableAnnotationRangeEnds;
    int[] currentLocalVariableAnnotationRangeIndices;
    int currentFrameOffset;
    int currentFrameType;
    int currentFrameLocalCount;
    int currentFrameLocalCountDelta;
    Object[] currentFrameLocalTypes;
    int currentFrameStackCount;
    Object[] currentFrameStackTypes;
}
