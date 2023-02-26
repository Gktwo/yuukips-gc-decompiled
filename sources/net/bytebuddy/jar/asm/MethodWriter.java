package net.bytebuddy.jar.asm;

import emu.grasscutter.net.packet.PacketOpcodes;
import javassist.bytecode.AnnotationDefaultAttribute;
import javassist.bytecode.CodeAttribute;
import javassist.bytecode.ExceptionsAttribute;
import javassist.bytecode.LineNumberAttribute;
import javassist.bytecode.LocalVariableAttribute;
import javassist.bytecode.MethodParametersAttribute;
import javassist.bytecode.ParameterAnnotationsAttribute;
import javassist.bytecode.StackMap;
import javassist.bytecode.StackMapTable;
import javassist.bytecode.TypeAnnotationsAttribute;
import net.bytebuddy.jar.asm.Attribute;
import p013io.netty.channel.SelectStrategy;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:net/bytebuddy/jar/asm/MethodWriter.class */
public final class MethodWriter extends MethodVisitor {
    static final int COMPUTE_NOTHING = 0;
    static final int COMPUTE_MAX_STACK_AND_LOCAL = 1;
    static final int COMPUTE_MAX_STACK_AND_LOCAL_FROM_FRAMES = 2;
    static final int COMPUTE_INSERTED_FRAMES = 3;
    static final int COMPUTE_ALL_FRAMES = 4;

    /* renamed from: NA */
    private static final int f3069NA = 0;
    private static final int[] STACK_SIZE_DELTA = {0, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 1, 1, 1, 2, 2, 1, 1, 1, 0, 0, 1, 2, 1, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, -1, 0, -1, -1, -1, -1, -1, -2, -1, -2, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -3, -4, -3, -4, -3, -3, -3, -3, -1, -2, 1, 1, 1, 2, 2, 2, 0, -1, -2, -1, -2, -1, -2, -1, -2, -1, -2, -1, -2, -1, -2, -1, -2, -1, -2, -1, -2, 0, 0, 0, 0, -1, -1, -1, -1, -1, -1, -1, -2, -1, -2, -1, -2, 0, 1, 0, 1, -1, -1, 0, 0, 1, 1, -1, 0, -1, 0, 0, 0, -3, -1, -1, -3, -3, -1, -1, -1, -1, -1, -1, -2, -2, -2, -2, -2, -2, -2, -2, 0, 1, 0, -1, -1, -1, -2, -1, -2, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, -1, -1, 0, 0, -1, -1, 0, 0};
    private final SymbolTable symbolTable;
    private final int accessFlags;
    private final int nameIndex;
    private final String name;
    private final int descriptorIndex;
    private final String descriptor;
    private int maxStack;
    private int maxLocals;
    private final ByteVector code = new ByteVector();
    private Handler firstHandler;
    private Handler lastHandler;
    private int lineNumberTableLength;
    private ByteVector lineNumberTable;
    private int localVariableTableLength;
    private ByteVector localVariableTable;
    private int localVariableTypeTableLength;
    private ByteVector localVariableTypeTable;
    private int stackMapTableNumberOfEntries;
    private ByteVector stackMapTableEntries;
    private AnnotationWriter lastCodeRuntimeVisibleTypeAnnotation;
    private AnnotationWriter lastCodeRuntimeInvisibleTypeAnnotation;
    private Attribute firstCodeAttribute;
    private final int numberOfExceptions;
    private final int[] exceptionIndexTable;
    private final int signatureIndex;
    private AnnotationWriter lastRuntimeVisibleAnnotation;
    private AnnotationWriter lastRuntimeInvisibleAnnotation;
    private int visibleAnnotableParameterCount;
    private AnnotationWriter[] lastRuntimeVisibleParameterAnnotations;
    private int invisibleAnnotableParameterCount;
    private AnnotationWriter[] lastRuntimeInvisibleParameterAnnotations;
    private AnnotationWriter lastRuntimeVisibleTypeAnnotation;
    private AnnotationWriter lastRuntimeInvisibleTypeAnnotation;
    private ByteVector defaultValue;
    private int parametersCount;
    private ByteVector parameters;
    private Attribute firstAttribute;
    private final int compute;
    private Label firstBasicBlock;
    private Label lastBasicBlock;
    private Label currentBasicBlock;
    private int relativeStackSize;
    private int maxRelativeStackSize;
    private int currentLocals;
    private int previousFrameOffset;
    private int[] previousFrame;
    private int[] currentFrame;
    private boolean hasSubroutines;
    private boolean hasAsmInstructions;
    private int lastBytecodeOffset;
    private int sourceOffset;
    private int sourceLength;

    /* access modifiers changed from: package-private */
    public MethodWriter(SymbolTable symbolTable, int access, String name, String descriptor, String signature, String[] exceptions, int compute) {
        super(Opcodes.ASM9);
        this.symbolTable = symbolTable;
        this.accessFlags = "<init>".equals(name) ? access | 262144 : access;
        this.nameIndex = symbolTable.addConstantUtf8(name);
        this.name = name;
        this.descriptorIndex = symbolTable.addConstantUtf8(descriptor);
        this.descriptor = descriptor;
        this.signatureIndex = signature == null ? 0 : symbolTable.addConstantUtf8(signature);
        if (exceptions == null || exceptions.length <= 0) {
            this.numberOfExceptions = 0;
            this.exceptionIndexTable = null;
        } else {
            this.numberOfExceptions = exceptions.length;
            this.exceptionIndexTable = new int[this.numberOfExceptions];
            for (int i = 0; i < this.numberOfExceptions; i++) {
                this.exceptionIndexTable[i] = symbolTable.addConstantClass(exceptions[i]).index;
            }
        }
        this.compute = compute;
        if (compute != 0) {
            int argumentsSize = Type.getArgumentsAndReturnSizes(descriptor) >> 2;
            argumentsSize = (access & 8) != 0 ? argumentsSize - 1 : argumentsSize;
            this.maxLocals = argumentsSize;
            this.currentLocals = argumentsSize;
            this.firstBasicBlock = new Label();
            visitLabel(this.firstBasicBlock);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean hasFrames() {
        return this.stackMapTableNumberOfEntries > 0;
    }

    /* access modifiers changed from: package-private */
    public boolean hasAsmInstructions() {
        return this.hasAsmInstructions;
    }

    @Override // net.bytebuddy.jar.asm.MethodVisitor
    public void visitParameter(String name, int access) {
        if (this.parameters == null) {
            this.parameters = new ByteVector();
        }
        this.parametersCount++;
        this.parameters.putShort(name == null ? 0 : this.symbolTable.addConstantUtf8(name)).putShort(access);
    }

    @Override // net.bytebuddy.jar.asm.MethodVisitor
    public AnnotationVisitor visitAnnotationDefault() {
        this.defaultValue = new ByteVector();
        return new AnnotationWriter(this.symbolTable, false, this.defaultValue, null);
    }

    @Override // net.bytebuddy.jar.asm.MethodVisitor
    public AnnotationVisitor visitAnnotation(String descriptor, boolean visible) {
        if (visible) {
            AnnotationWriter create = AnnotationWriter.create(this.symbolTable, descriptor, this.lastRuntimeVisibleAnnotation);
            this.lastRuntimeVisibleAnnotation = create;
            return create;
        }
        AnnotationWriter create2 = AnnotationWriter.create(this.symbolTable, descriptor, this.lastRuntimeInvisibleAnnotation);
        this.lastRuntimeInvisibleAnnotation = create2;
        return create2;
    }

    @Override // net.bytebuddy.jar.asm.MethodVisitor
    public AnnotationVisitor visitTypeAnnotation(int typeRef, TypePath typePath, String descriptor, boolean visible) {
        if (visible) {
            AnnotationWriter create = AnnotationWriter.create(this.symbolTable, typeRef, typePath, descriptor, this.lastRuntimeVisibleTypeAnnotation);
            this.lastRuntimeVisibleTypeAnnotation = create;
            return create;
        }
        AnnotationWriter create2 = AnnotationWriter.create(this.symbolTable, typeRef, typePath, descriptor, this.lastRuntimeInvisibleTypeAnnotation);
        this.lastRuntimeInvisibleTypeAnnotation = create2;
        return create2;
    }

    @Override // net.bytebuddy.jar.asm.MethodVisitor
    public void visitAnnotableParameterCount(int parameterCount, boolean visible) {
        if (visible) {
            this.visibleAnnotableParameterCount = parameterCount;
        } else {
            this.invisibleAnnotableParameterCount = parameterCount;
        }
    }

    @Override // net.bytebuddy.jar.asm.MethodVisitor
    public AnnotationVisitor visitParameterAnnotation(int parameter, String annotationDescriptor, boolean visible) {
        if (visible) {
            if (this.lastRuntimeVisibleParameterAnnotations == null) {
                this.lastRuntimeVisibleParameterAnnotations = new AnnotationWriter[Type.getArgumentTypes(this.descriptor).length];
            }
            AnnotationWriter[] annotationWriterArr = this.lastRuntimeVisibleParameterAnnotations;
            AnnotationWriter create = AnnotationWriter.create(this.symbolTable, annotationDescriptor, this.lastRuntimeVisibleParameterAnnotations[parameter]);
            annotationWriterArr[parameter] = create;
            return create;
        }
        if (this.lastRuntimeInvisibleParameterAnnotations == null) {
            this.lastRuntimeInvisibleParameterAnnotations = new AnnotationWriter[Type.getArgumentTypes(this.descriptor).length];
        }
        AnnotationWriter[] annotationWriterArr2 = this.lastRuntimeInvisibleParameterAnnotations;
        AnnotationWriter create2 = AnnotationWriter.create(this.symbolTable, annotationDescriptor, this.lastRuntimeInvisibleParameterAnnotations[parameter]);
        annotationWriterArr2[parameter] = create2;
        return create2;
    }

    @Override // net.bytebuddy.jar.asm.MethodVisitor
    public void visitAttribute(Attribute attribute) {
        if (attribute.isCodeAttribute()) {
            attribute.nextAttribute = this.firstCodeAttribute;
            this.firstCodeAttribute = attribute;
            return;
        }
        attribute.nextAttribute = this.firstAttribute;
        this.firstAttribute = attribute;
    }

    @Override // net.bytebuddy.jar.asm.MethodVisitor
    public void visitCode() {
    }

    @Override // net.bytebuddy.jar.asm.MethodVisitor
    public void visitFrame(int type, int numLocal, Object[] local, int numStack, Object[] stack) {
        int offsetDelta;
        if (this.compute != 4) {
            if (this.compute == 3) {
                if (this.currentBasicBlock.frame == null) {
                    this.currentBasicBlock.frame = new CurrentFrame(this.currentBasicBlock);
                    this.currentBasicBlock.frame.setInputFrameFromDescriptor(this.symbolTable, this.accessFlags, this.descriptor, numLocal);
                    this.currentBasicBlock.frame.accept(this);
                } else {
                    if (type == -1) {
                        this.currentBasicBlock.frame.setInputFrameFromApiFormat(this.symbolTable, numLocal, local, numStack, stack);
                    }
                    this.currentBasicBlock.frame.accept(this);
                }
            } else if (type == -1) {
                if (this.previousFrame == null) {
                    int argumentsSize = Type.getArgumentsAndReturnSizes(this.descriptor) >> 2;
                    Frame implicitFirstFrame = new Frame(new Label());
                    implicitFirstFrame.setInputFrameFromDescriptor(this.symbolTable, this.accessFlags, this.descriptor, argumentsSize);
                    implicitFirstFrame.accept(this);
                }
                this.currentLocals = numLocal;
                int frameIndex = visitFrameStart(this.code.length, numLocal, numStack);
                for (int i = 0; i < numLocal; i++) {
                    frameIndex++;
                    this.currentFrame[frameIndex] = Frame.getAbstractTypeFromApiFormat(this.symbolTable, local[i]);
                }
                for (int i2 = 0; i2 < numStack; i2++) {
                    frameIndex++;
                    this.currentFrame[frameIndex] = Frame.getAbstractTypeFromApiFormat(this.symbolTable, stack[i2]);
                }
                visitFrameEnd();
            } else if (this.symbolTable.getMajorVersion() < 50) {
                throw new IllegalArgumentException("Class versions V1_5 or less must use F_NEW frames.");
            } else {
                if (this.stackMapTableEntries == null) {
                    this.stackMapTableEntries = new ByteVector();
                    offsetDelta = this.code.length;
                } else {
                    offsetDelta = (this.code.length - this.previousFrameOffset) - 1;
                    if (offsetDelta < 0) {
                        if (type != 3) {
                            throw new IllegalStateException();
                        }
                        return;
                    }
                }
                switch (type) {
                    case 0:
                        this.currentLocals = numLocal;
                        this.stackMapTableEntries.putByte(255).putShort(offsetDelta).putShort(numLocal);
                        for (int i3 = 0; i3 < numLocal; i3++) {
                            putFrameType(local[i3]);
                        }
                        this.stackMapTableEntries.putShort(numStack);
                        for (int i4 = 0; i4 < numStack; i4++) {
                            putFrameType(stack[i4]);
                        }
                        break;
                    case 1:
                        this.currentLocals += numLocal;
                        this.stackMapTableEntries.putByte(PacketOpcodes.SceneForceLockNotify + numLocal).putShort(offsetDelta);
                        for (int i5 = 0; i5 < numLocal; i5++) {
                            putFrameType(local[i5]);
                        }
                        break;
                    case 2:
                        this.currentLocals -= numLocal;
                        this.stackMapTableEntries.putByte(PacketOpcodes.SceneForceLockNotify - numLocal).putShort(offsetDelta);
                        break;
                    case 3:
                        if (offsetDelta < 64) {
                            this.stackMapTableEntries.putByte(offsetDelta);
                            break;
                        } else {
                            this.stackMapTableEntries.putByte(PacketOpcodes.SceneForceLockNotify).putShort(offsetDelta);
                            break;
                        }
                    case 4:
                        if (offsetDelta < 64) {
                            this.stackMapTableEntries.putByte(64 + offsetDelta);
                        } else {
                            this.stackMapTableEntries.putByte(PacketOpcodes.ClientScriptEventNotify).putShort(offsetDelta);
                        }
                        putFrameType(stack[0]);
                        break;
                    default:
                        throw new IllegalArgumentException();
                }
                this.previousFrameOffset = this.code.length;
                this.stackMapTableNumberOfEntries++;
            }
            if (this.compute == 2) {
                this.relativeStackSize = numStack;
                for (int i6 = 0; i6 < numStack; i6++) {
                    if (stack[i6] == Opcodes.LONG || stack[i6] == Opcodes.DOUBLE) {
                        this.relativeStackSize++;
                    }
                }
                if (this.relativeStackSize > this.maxRelativeStackSize) {
                    this.maxRelativeStackSize = this.relativeStackSize;
                }
            }
            this.maxStack = Math.max(this.maxStack, numStack);
            this.maxLocals = Math.max(this.maxLocals, this.currentLocals);
        }
    }

    @Override // net.bytebuddy.jar.asm.MethodVisitor
    public void visitInsn(int opcode) {
        this.lastBytecodeOffset = this.code.length;
        this.code.putByte(opcode);
        if (this.currentBasicBlock != null) {
            if (this.compute == 4 || this.compute == 3) {
                this.currentBasicBlock.frame.execute(opcode, 0, null, null);
            } else {
                int size = this.relativeStackSize + STACK_SIZE_DELTA[opcode];
                if (size > this.maxRelativeStackSize) {
                    this.maxRelativeStackSize = size;
                }
                this.relativeStackSize = size;
            }
            if ((opcode >= 172 && opcode <= 177) || opcode == 191) {
                endCurrentBasicBlockWithNoSuccessor();
            }
        }
    }

    @Override // net.bytebuddy.jar.asm.MethodVisitor
    public void visitIntInsn(int opcode, int operand) {
        this.lastBytecodeOffset = this.code.length;
        if (opcode == 17) {
            this.code.put12(opcode, operand);
        } else {
            this.code.put11(opcode, operand);
        }
        if (this.currentBasicBlock == null) {
            return;
        }
        if (this.compute == 4 || this.compute == 3) {
            this.currentBasicBlock.frame.execute(opcode, operand, null, null);
        } else if (opcode != 188) {
            int size = this.relativeStackSize + 1;
            if (size > this.maxRelativeStackSize) {
                this.maxRelativeStackSize = size;
            }
            this.relativeStackSize = size;
        }
    }

    @Override // net.bytebuddy.jar.asm.MethodVisitor
    public void visitVarInsn(int opcode, int var) {
        int currentMaxLocals;
        int optimizedOpcode;
        this.lastBytecodeOffset = this.code.length;
        if (var < 4 && opcode != 169) {
            if (opcode < 54) {
                optimizedOpcode = 26 + ((opcode - 21) << 2) + var;
            } else {
                optimizedOpcode = 59 + ((opcode - 54) << 2) + var;
            }
            this.code.putByte(optimizedOpcode);
        } else if (var >= 256) {
            this.code.putByte(196).put12(opcode, var);
        } else {
            this.code.put11(opcode, var);
        }
        if (this.currentBasicBlock != null) {
            if (this.compute == 4 || this.compute == 3) {
                this.currentBasicBlock.frame.execute(opcode, var, null, null);
            } else if (opcode == 169) {
                Label label = this.currentBasicBlock;
                label.flags = (short) (label.flags | 64);
                this.currentBasicBlock.outputStackSize = (short) this.relativeStackSize;
                endCurrentBasicBlockWithNoSuccessor();
            } else {
                int size = this.relativeStackSize + STACK_SIZE_DELTA[opcode];
                if (size > this.maxRelativeStackSize) {
                    this.maxRelativeStackSize = size;
                }
                this.relativeStackSize = size;
            }
        }
        if (this.compute != 0) {
            if (opcode == 22 || opcode == 24 || opcode == 55 || opcode == 57) {
                currentMaxLocals = var + 2;
            } else {
                currentMaxLocals = var + 1;
            }
            if (currentMaxLocals > this.maxLocals) {
                this.maxLocals = currentMaxLocals;
            }
        }
        if (opcode >= 54 && this.compute == 4 && this.firstHandler != null) {
            visitLabel(new Label());
        }
    }

    @Override // net.bytebuddy.jar.asm.MethodVisitor
    public void visitTypeInsn(int opcode, String type) {
        this.lastBytecodeOffset = this.code.length;
        Symbol typeSymbol = this.symbolTable.addConstantClass(type);
        this.code.put12(opcode, typeSymbol.index);
        if (this.currentBasicBlock == null) {
            return;
        }
        if (this.compute == 4 || this.compute == 3) {
            this.currentBasicBlock.frame.execute(opcode, this.lastBytecodeOffset, typeSymbol, this.symbolTable);
        } else if (opcode == 187) {
            int size = this.relativeStackSize + 1;
            if (size > this.maxRelativeStackSize) {
                this.maxRelativeStackSize = size;
            }
            this.relativeStackSize = size;
        }
    }

    @Override // net.bytebuddy.jar.asm.MethodVisitor
    public void visitFieldInsn(int opcode, String owner, String name, String descriptor) {
        int size;
        this.lastBytecodeOffset = this.code.length;
        Symbol fieldrefSymbol = this.symbolTable.addConstantFieldref(owner, name, descriptor);
        this.code.put12(opcode, fieldrefSymbol.index);
        if (this.currentBasicBlock == null) {
            return;
        }
        if (this.compute == 4 || this.compute == 3) {
            this.currentBasicBlock.frame.execute(opcode, 0, fieldrefSymbol, this.symbolTable);
            return;
        }
        char firstDescChar = descriptor.charAt(0);
        switch (opcode) {
            case 178:
                size = this.relativeStackSize + ((firstDescChar == 'D' || firstDescChar == 'J') ? 2 : 1);
                break;
            case 179:
                size = this.relativeStackSize + ((firstDescChar == 'D' || firstDescChar == 'J') ? -2 : -1);
                break;
            case 180:
                size = this.relativeStackSize + ((firstDescChar == 'D' || firstDescChar == 'J') ? 1 : 0);
                break;
            case 181:
            default:
                size = this.relativeStackSize + ((firstDescChar == 'D' || firstDescChar == 'J') ? -3 : -2);
                break;
        }
        if (size > this.maxRelativeStackSize) {
            this.maxRelativeStackSize = size;
        }
        this.relativeStackSize = size;
    }

    @Override // net.bytebuddy.jar.asm.MethodVisitor
    public void visitMethodInsn(int opcode, String owner, String name, String descriptor, boolean isInterface) {
        int size;
        this.lastBytecodeOffset = this.code.length;
        Symbol methodrefSymbol = this.symbolTable.addConstantMethodref(owner, name, descriptor, isInterface);
        if (opcode == 185) {
            this.code.put12(185, methodrefSymbol.index).put11(methodrefSymbol.getArgumentsAndReturnSizes() >> 2, 0);
        } else {
            this.code.put12(opcode, methodrefSymbol.index);
        }
        if (this.currentBasicBlock == null) {
            return;
        }
        if (this.compute == 4 || this.compute == 3) {
            this.currentBasicBlock.frame.execute(opcode, 0, methodrefSymbol, this.symbolTable);
            return;
        }
        int argumentsAndReturnSize = methodrefSymbol.getArgumentsAndReturnSizes();
        int stackSizeDelta = (argumentsAndReturnSize & 3) - (argumentsAndReturnSize >> 2);
        if (opcode == 184) {
            size = this.relativeStackSize + stackSizeDelta + 1;
        } else {
            size = this.relativeStackSize + stackSizeDelta;
        }
        if (size > this.maxRelativeStackSize) {
            this.maxRelativeStackSize = size;
        }
        this.relativeStackSize = size;
    }

    @Override // net.bytebuddy.jar.asm.MethodVisitor
    public void visitInvokeDynamicInsn(String name, String descriptor, Handle bootstrapMethodHandle, Object... bootstrapMethodArguments) {
        this.lastBytecodeOffset = this.code.length;
        Symbol invokeDynamicSymbol = this.symbolTable.addConstantInvokeDynamic(name, descriptor, bootstrapMethodHandle, bootstrapMethodArguments);
        this.code.put12(186, invokeDynamicSymbol.index);
        this.code.putShort(0);
        if (this.currentBasicBlock == null) {
            return;
        }
        if (this.compute == 4 || this.compute == 3) {
            this.currentBasicBlock.frame.execute(186, 0, invokeDynamicSymbol, this.symbolTable);
            return;
        }
        int argumentsAndReturnSize = invokeDynamicSymbol.getArgumentsAndReturnSizes();
        int size = this.relativeStackSize + ((argumentsAndReturnSize & 3) - (argumentsAndReturnSize >> 2)) + 1;
        if (size > this.maxRelativeStackSize) {
            this.maxRelativeStackSize = size;
        }
        this.relativeStackSize = size;
    }

    @Override // net.bytebuddy.jar.asm.MethodVisitor
    public void visitJumpInsn(int opcode, Label label) {
        this.lastBytecodeOffset = this.code.length;
        int baseOpcode = opcode >= 200 ? opcode - 33 : opcode;
        boolean nextInsnIsJumpTarget = false;
        if ((label.flags & 4) != 0 && label.bytecodeOffset - this.code.length < -32768) {
            if (baseOpcode == 167) {
                this.code.putByte(200);
            } else if (baseOpcode == 168) {
                this.code.putByte(201);
            } else {
                this.code.putByte(baseOpcode >= 198 ? baseOpcode ^ 1 : ((baseOpcode + 1) ^ 1) - 1);
                this.code.putShort(8);
                this.code.putByte(PacketOpcodes.SceneInitFinishRsp);
                this.hasAsmInstructions = true;
                nextInsnIsJumpTarget = true;
            }
            label.put(this.code, this.code.length - 1, true);
        } else if (baseOpcode != opcode) {
            this.code.putByte(opcode);
            label.put(this.code, this.code.length - 1, true);
        } else {
            this.code.putByte(baseOpcode);
            label.put(this.code, this.code.length - 1, false);
        }
        if (this.currentBasicBlock != null) {
            Label nextBasicBlock = null;
            if (this.compute == 4) {
                this.currentBasicBlock.frame.execute(baseOpcode, 0, null, null);
                Label canonicalInstance = label.getCanonicalInstance();
                canonicalInstance.flags = (short) (canonicalInstance.flags | 2);
                addSuccessorToCurrentBasicBlock(0, label);
                if (baseOpcode != 167) {
                    nextBasicBlock = new Label();
                }
            } else if (this.compute == 3) {
                this.currentBasicBlock.frame.execute(baseOpcode, 0, null, null);
            } else if (this.compute == 2) {
                this.relativeStackSize += STACK_SIZE_DELTA[baseOpcode];
            } else if (baseOpcode == 168) {
                if ((label.flags & 32) == 0) {
                    label.flags = (short) (label.flags | 32);
                    this.hasSubroutines = true;
                }
                Label label2 = this.currentBasicBlock;
                label2.flags = (short) (label2.flags | 16);
                addSuccessorToCurrentBasicBlock(this.relativeStackSize + 1, label);
                nextBasicBlock = new Label();
            } else {
                this.relativeStackSize += STACK_SIZE_DELTA[baseOpcode];
                addSuccessorToCurrentBasicBlock(this.relativeStackSize, label);
            }
            if (nextBasicBlock != null) {
                if (nextInsnIsJumpTarget) {
                    nextBasicBlock.flags = (short) (nextBasicBlock.flags | 2);
                }
                visitLabel(nextBasicBlock);
            }
            if (baseOpcode == 167) {
                endCurrentBasicBlockWithNoSuccessor();
            }
        }
    }

    @Override // net.bytebuddy.jar.asm.MethodVisitor
    public void visitLabel(Label label) {
        this.hasAsmInstructions |= label.resolve(this.code.data, this.code.length);
        if ((label.flags & 1) == 0) {
            if (this.compute == 4) {
                if (this.currentBasicBlock != null) {
                    if (label.bytecodeOffset == this.currentBasicBlock.bytecodeOffset) {
                        Label label2 = this.currentBasicBlock;
                        label2.flags = (short) (label2.flags | (label.flags & 2));
                        label.frame = this.currentBasicBlock.frame;
                        return;
                    }
                    addSuccessorToCurrentBasicBlock(0, label);
                }
                if (this.lastBasicBlock != null) {
                    if (label.bytecodeOffset == this.lastBasicBlock.bytecodeOffset) {
                        Label label3 = this.lastBasicBlock;
                        label3.flags = (short) (label3.flags | (label.flags & 2));
                        label.frame = this.lastBasicBlock.frame;
                        this.currentBasicBlock = this.lastBasicBlock;
                        return;
                    }
                    this.lastBasicBlock.nextBasicBlock = label;
                }
                this.lastBasicBlock = label;
                this.currentBasicBlock = label;
                label.frame = new Frame(label);
            } else if (this.compute == 3) {
                if (this.currentBasicBlock == null) {
                    this.currentBasicBlock = label;
                } else {
                    this.currentBasicBlock.frame.owner = label;
                }
            } else if (this.compute == 1) {
                if (this.currentBasicBlock != null) {
                    this.currentBasicBlock.outputStackMax = (short) this.maxRelativeStackSize;
                    addSuccessorToCurrentBasicBlock(this.relativeStackSize, label);
                }
                this.currentBasicBlock = label;
                this.relativeStackSize = 0;
                this.maxRelativeStackSize = 0;
                if (this.lastBasicBlock != null) {
                    this.lastBasicBlock.nextBasicBlock = label;
                }
                this.lastBasicBlock = label;
            } else if (this.compute == 2 && this.currentBasicBlock == null) {
                this.currentBasicBlock = label;
            }
        }
    }

    @Override // net.bytebuddy.jar.asm.MethodVisitor
    public void visitLdcInsn(Object value) {
        char firstDescriptorChar;
        this.lastBytecodeOffset = this.code.length;
        Symbol constantSymbol = this.symbolTable.addConstant(value);
        int constantIndex = constantSymbol.index;
        boolean isLongOrDouble = constantSymbol.tag == 5 || constantSymbol.tag == 6 || (constantSymbol.tag == 17 && ((firstDescriptorChar = constantSymbol.value.charAt(0)) == 'J' || firstDescriptorChar == 'D'));
        if (isLongOrDouble) {
            this.code.put12(20, constantIndex);
        } else if (constantIndex >= 256) {
            this.code.put12(19, constantIndex);
        } else {
            this.code.put11(18, constantIndex);
        }
        if (this.currentBasicBlock == null) {
            return;
        }
        if (this.compute == 4 || this.compute == 3) {
            this.currentBasicBlock.frame.execute(18, 0, constantSymbol, this.symbolTable);
            return;
        }
        int size = this.relativeStackSize + (isLongOrDouble ? 2 : 1);
        if (size > this.maxRelativeStackSize) {
            this.maxRelativeStackSize = size;
        }
        this.relativeStackSize = size;
    }

    @Override // net.bytebuddy.jar.asm.MethodVisitor
    public void visitIincInsn(int var, int increment) {
        int currentMaxLocals;
        this.lastBytecodeOffset = this.code.length;
        if (var > 255 || increment > 127 || increment < -128) {
            this.code.putByte(196).put12(132, var).putShort(increment);
        } else {
            this.code.putByte(132).put11(var, increment);
        }
        if (this.currentBasicBlock != null && (this.compute == 4 || this.compute == 3)) {
            this.currentBasicBlock.frame.execute(132, var, null, null);
        }
        if (this.compute != 0 && (currentMaxLocals = var + 1) > this.maxLocals) {
            this.maxLocals = currentMaxLocals;
        }
    }

    @Override // net.bytebuddy.jar.asm.MethodVisitor
    public void visitTableSwitchInsn(int min, int max, Label dflt, Label... labels) {
        this.lastBytecodeOffset = this.code.length;
        this.code.putByte(170).putByteArray(null, 0, (4 - (this.code.length % 4)) % 4);
        dflt.put(this.code, this.lastBytecodeOffset, true);
        this.code.putInt(min).putInt(max);
        for (Label label : labels) {
            label.put(this.code, this.lastBytecodeOffset, true);
        }
        visitSwitchInsn(dflt, labels);
    }

    @Override // net.bytebuddy.jar.asm.MethodVisitor
    public void visitLookupSwitchInsn(Label dflt, int[] keys, Label[] labels) {
        this.lastBytecodeOffset = this.code.length;
        this.code.putByte(171).putByteArray(null, 0, (4 - (this.code.length % 4)) % 4);
        dflt.put(this.code, this.lastBytecodeOffset, true);
        this.code.putInt(labels.length);
        for (int i = 0; i < labels.length; i++) {
            this.code.putInt(keys[i]);
            labels[i].put(this.code, this.lastBytecodeOffset, true);
        }
        visitSwitchInsn(dflt, labels);
    }

    private void visitSwitchInsn(Label dflt, Label[] labels) {
        if (this.currentBasicBlock != null) {
            if (this.compute == 4) {
                this.currentBasicBlock.frame.execute(171, 0, null, null);
                addSuccessorToCurrentBasicBlock(0, dflt);
                Label canonicalInstance = dflt.getCanonicalInstance();
                canonicalInstance.flags = (short) (canonicalInstance.flags | 2);
                for (Label label : labels) {
                    addSuccessorToCurrentBasicBlock(0, label);
                    Label canonicalInstance2 = label.getCanonicalInstance();
                    canonicalInstance2.flags = (short) (canonicalInstance2.flags | 2);
                }
            } else if (this.compute == 1) {
                this.relativeStackSize--;
                addSuccessorToCurrentBasicBlock(this.relativeStackSize, dflt);
                for (Label label2 : labels) {
                    addSuccessorToCurrentBasicBlock(this.relativeStackSize, label2);
                }
            }
            endCurrentBasicBlockWithNoSuccessor();
        }
    }

    @Override // net.bytebuddy.jar.asm.MethodVisitor
    public void visitMultiANewArrayInsn(String descriptor, int numDimensions) {
        this.lastBytecodeOffset = this.code.length;
        Symbol descSymbol = this.symbolTable.addConstantClass(descriptor);
        this.code.put12(197, descSymbol.index).putByte(numDimensions);
        if (this.currentBasicBlock == null) {
            return;
        }
        if (this.compute == 4 || this.compute == 3) {
            this.currentBasicBlock.frame.execute(197, numDimensions, descSymbol, this.symbolTable);
        } else {
            this.relativeStackSize += 1 - numDimensions;
        }
    }

    @Override // net.bytebuddy.jar.asm.MethodVisitor
    public AnnotationVisitor visitInsnAnnotation(int typeRef, TypePath typePath, String descriptor, boolean visible) {
        if (visible) {
            AnnotationWriter create = AnnotationWriter.create(this.symbolTable, (typeRef & -16776961) | (this.lastBytecodeOffset << 8), typePath, descriptor, this.lastCodeRuntimeVisibleTypeAnnotation);
            this.lastCodeRuntimeVisibleTypeAnnotation = create;
            return create;
        }
        AnnotationWriter create2 = AnnotationWriter.create(this.symbolTable, (typeRef & -16776961) | (this.lastBytecodeOffset << 8), typePath, descriptor, this.lastCodeRuntimeInvisibleTypeAnnotation);
        this.lastCodeRuntimeInvisibleTypeAnnotation = create2;
        return create2;
    }

    @Override // net.bytebuddy.jar.asm.MethodVisitor
    public void visitTryCatchBlock(Label start, Label end, Label handler, String type) {
        Handler newHandler = new Handler(start, end, handler, type != null ? this.symbolTable.addConstantClass(type).index : 0, type);
        if (this.firstHandler == null) {
            this.firstHandler = newHandler;
        } else {
            this.lastHandler.nextHandler = newHandler;
        }
        this.lastHandler = newHandler;
    }

    @Override // net.bytebuddy.jar.asm.MethodVisitor
    public AnnotationVisitor visitTryCatchAnnotation(int typeRef, TypePath typePath, String descriptor, boolean visible) {
        if (visible) {
            AnnotationWriter create = AnnotationWriter.create(this.symbolTable, typeRef, typePath, descriptor, this.lastCodeRuntimeVisibleTypeAnnotation);
            this.lastCodeRuntimeVisibleTypeAnnotation = create;
            return create;
        }
        AnnotationWriter create2 = AnnotationWriter.create(this.symbolTable, typeRef, typePath, descriptor, this.lastCodeRuntimeInvisibleTypeAnnotation);
        this.lastCodeRuntimeInvisibleTypeAnnotation = create2;
        return create2;
    }

    @Override // net.bytebuddy.jar.asm.MethodVisitor
    public void visitLocalVariable(String name, String descriptor, String signature, Label start, Label end, int index) {
        if (signature != null) {
            if (this.localVariableTypeTable == null) {
                this.localVariableTypeTable = new ByteVector();
            }
            this.localVariableTypeTableLength++;
            this.localVariableTypeTable.putShort(start.bytecodeOffset).putShort(end.bytecodeOffset - start.bytecodeOffset).putShort(this.symbolTable.addConstantUtf8(name)).putShort(this.symbolTable.addConstantUtf8(signature)).putShort(index);
        }
        if (this.localVariableTable == null) {
            this.localVariableTable = new ByteVector();
        }
        this.localVariableTableLength++;
        this.localVariableTable.putShort(start.bytecodeOffset).putShort(end.bytecodeOffset - start.bytecodeOffset).putShort(this.symbolTable.addConstantUtf8(name)).putShort(this.symbolTable.addConstantUtf8(descriptor)).putShort(index);
        if (this.compute != 0) {
            char firstDescChar = descriptor.charAt(0);
            int currentMaxLocals = index + ((firstDescChar == 'J' || firstDescChar == 'D') ? 2 : 1);
            if (currentMaxLocals > this.maxLocals) {
                this.maxLocals = currentMaxLocals;
            }
        }
    }

    @Override // net.bytebuddy.jar.asm.MethodVisitor
    public AnnotationVisitor visitLocalVariableAnnotation(int typeRef, TypePath typePath, Label[] start, Label[] end, int[] index, String descriptor, boolean visible) {
        ByteVector typeAnnotation = new ByteVector();
        typeAnnotation.putByte(typeRef >>> 24).putShort(start.length);
        for (int i = 0; i < start.length; i++) {
            typeAnnotation.putShort(start[i].bytecodeOffset).putShort(end[i].bytecodeOffset - start[i].bytecodeOffset).putShort(index[i]);
        }
        TypePath.put(typePath, typeAnnotation);
        typeAnnotation.putShort(this.symbolTable.addConstantUtf8(descriptor)).putShort(0);
        if (visible) {
            AnnotationWriter annotationWriter = new AnnotationWriter(this.symbolTable, true, typeAnnotation, this.lastCodeRuntimeVisibleTypeAnnotation);
            this.lastCodeRuntimeVisibleTypeAnnotation = annotationWriter;
            return annotationWriter;
        }
        AnnotationWriter annotationWriter2 = new AnnotationWriter(this.symbolTable, true, typeAnnotation, this.lastCodeRuntimeInvisibleTypeAnnotation);
        this.lastCodeRuntimeInvisibleTypeAnnotation = annotationWriter2;
        return annotationWriter2;
    }

    @Override // net.bytebuddy.jar.asm.MethodVisitor
    public void visitLineNumber(int line, Label start) {
        if (this.lineNumberTable == null) {
            this.lineNumberTable = new ByteVector();
        }
        this.lineNumberTableLength++;
        this.lineNumberTable.putShort(start.bytecodeOffset);
        this.lineNumberTable.putShort(line);
    }

    @Override // net.bytebuddy.jar.asm.MethodVisitor
    public void visitMaxs(int maxStack, int maxLocals) {
        if (this.compute == 4) {
            computeAllFrames();
        } else if (this.compute == 1) {
            computeMaxStackAndLocal();
        } else if (this.compute == 2) {
            this.maxStack = this.maxRelativeStackSize;
        } else {
            this.maxStack = maxStack;
            this.maxLocals = maxLocals;
        }
    }

    private void computeAllFrames() {
        for (Handler handler = this.firstHandler; handler != null; handler = handler.nextHandler) {
            int catchType = Frame.getAbstractTypeFromInternalName(this.symbolTable, handler.catchTypeDescriptor == null ? "java/lang/Throwable" : handler.catchTypeDescriptor);
            Label handlerBlock = handler.handlerPc.getCanonicalInstance();
            handlerBlock.flags = (short) (handlerBlock.flags | 2);
            Label handlerRangeEnd = handler.endPc.getCanonicalInstance();
            for (Label handlerRangeBlock = handler.startPc.getCanonicalInstance(); handlerRangeBlock != handlerRangeEnd; handlerRangeBlock = handlerRangeBlock.nextBasicBlock) {
                handlerRangeBlock.outgoingEdges = new Edge(catchType, handlerBlock, handlerRangeBlock.outgoingEdges);
            }
        }
        Frame firstFrame = this.firstBasicBlock.frame;
        firstFrame.setInputFrameFromDescriptor(this.symbolTable, this.accessFlags, this.descriptor, this.maxLocals);
        firstFrame.accept(this);
        Label listOfBlocksToProcess = this.firstBasicBlock;
        listOfBlocksToProcess.nextListElement = Label.EMPTY_LIST;
        int maxStackSize = 0;
        while (listOfBlocksToProcess != Label.EMPTY_LIST) {
            listOfBlocksToProcess = listOfBlocksToProcess.nextListElement;
            listOfBlocksToProcess.nextListElement = null;
            listOfBlocksToProcess.flags = (short) (listOfBlocksToProcess.flags | 8);
            int maxBlockStackSize = listOfBlocksToProcess.frame.getInputStackSize() + listOfBlocksToProcess.outputStackMax;
            if (maxBlockStackSize > maxStackSize) {
                maxStackSize = maxBlockStackSize;
            }
            for (Edge outgoingEdge = listOfBlocksToProcess.outgoingEdges; outgoingEdge != null; outgoingEdge = outgoingEdge.nextEdge) {
                Label successorBlock = outgoingEdge.successor.getCanonicalInstance();
                if (listOfBlocksToProcess.frame.merge(this.symbolTable, successorBlock.frame, outgoingEdge.info) && successorBlock.nextListElement == null) {
                    successorBlock.nextListElement = listOfBlocksToProcess;
                    listOfBlocksToProcess = successorBlock;
                }
            }
        }
        for (Label basicBlock = this.firstBasicBlock; basicBlock != null; basicBlock = basicBlock.nextBasicBlock) {
            if ((basicBlock.flags & 10) == 10) {
                basicBlock.frame.accept(this);
            }
            if ((basicBlock.flags & 8) == 0) {
                Label nextBasicBlock = basicBlock.nextBasicBlock;
                int startOffset = basicBlock.bytecodeOffset;
                int endOffset = (nextBasicBlock == null ? this.code.length : nextBasicBlock.bytecodeOffset) - 1;
                if (endOffset >= startOffset) {
                    for (int i = startOffset; i < endOffset; i++) {
                        this.code.data[i] = 0;
                    }
                    this.code.data[endOffset] = -65;
                    this.currentFrame[visitFrameStart(startOffset, 0, 1)] = Frame.getAbstractTypeFromInternalName(this.symbolTable, "java/lang/Throwable");
                    visitFrameEnd();
                    this.firstHandler = Handler.removeRange(this.firstHandler, basicBlock, nextBasicBlock);
                    maxStackSize = Math.max(maxStackSize, 1);
                }
            }
        }
        this.maxStack = maxStackSize;
    }

    private void computeMaxStackAndLocal() {
        for (Handler handler = this.firstHandler; handler != null; handler = handler.nextHandler) {
            Label handlerBlock = handler.handlerPc;
            Label handlerRangeEnd = handler.endPc;
            for (Label handlerRangeBlock = handler.startPc; handlerRangeBlock != handlerRangeEnd; handlerRangeBlock = handlerRangeBlock.nextBasicBlock) {
                if ((handlerRangeBlock.flags & 16) == 0) {
                    handlerRangeBlock.outgoingEdges = new Edge(Integer.MAX_VALUE, handlerBlock, handlerRangeBlock.outgoingEdges);
                } else {
                    handlerRangeBlock.outgoingEdges.nextEdge.nextEdge = new Edge(Integer.MAX_VALUE, handlerBlock, handlerRangeBlock.outgoingEdges.nextEdge.nextEdge);
                }
            }
        }
        if (this.hasSubroutines) {
            short numSubroutines = 1;
            this.firstBasicBlock.markSubroutine(1);
            for (short currentSubroutine = 1; currentSubroutine <= numSubroutines; currentSubroutine = (short) (currentSubroutine + 1)) {
                for (Label basicBlock = this.firstBasicBlock; basicBlock != null; basicBlock = basicBlock.nextBasicBlock) {
                    if ((basicBlock.flags & 16) != 0 && basicBlock.subroutineId == currentSubroutine) {
                        Label jsrTarget = basicBlock.outgoingEdges.nextEdge.successor;
                        if (jsrTarget.subroutineId == 0) {
                            numSubroutines = (short) (numSubroutines + 1);
                            jsrTarget.markSubroutine(numSubroutines);
                        }
                    }
                }
            }
            for (Label basicBlock2 = this.firstBasicBlock; basicBlock2 != null; basicBlock2 = basicBlock2.nextBasicBlock) {
                if ((basicBlock2.flags & 16) != 0) {
                    basicBlock2.outgoingEdges.nextEdge.successor.addSubroutineRetSuccessors(basicBlock2);
                }
            }
        }
        Label listOfBlocksToProcess = this.firstBasicBlock;
        listOfBlocksToProcess.nextListElement = Label.EMPTY_LIST;
        int maxStackSize = this.maxStack;
        while (listOfBlocksToProcess != Label.EMPTY_LIST) {
            listOfBlocksToProcess = listOfBlocksToProcess.nextListElement;
            int inputStackTop = listOfBlocksToProcess.inputStackSize;
            int maxBlockStackSize = inputStackTop + listOfBlocksToProcess.outputStackMax;
            if (maxBlockStackSize > maxStackSize) {
                maxStackSize = maxBlockStackSize;
            }
            Edge outgoingEdge = listOfBlocksToProcess.outgoingEdges;
            if ((listOfBlocksToProcess.flags & 16) != 0) {
                outgoingEdge = outgoingEdge.nextEdge;
            }
            while (outgoingEdge != null) {
                Label successorBlock = outgoingEdge.successor;
                if (successorBlock.nextListElement == null) {
                    successorBlock.inputStackSize = (short) (outgoingEdge.info == Integer.MAX_VALUE ? 1 : inputStackTop + outgoingEdge.info);
                    successorBlock.nextListElement = listOfBlocksToProcess;
                    listOfBlocksToProcess = successorBlock;
                }
                outgoingEdge = outgoingEdge.nextEdge;
            }
        }
        this.maxStack = maxStackSize;
    }

    @Override // net.bytebuddy.jar.asm.MethodVisitor
    public void visitEnd() {
    }

    private void addSuccessorToCurrentBasicBlock(int info, Label successor) {
        this.currentBasicBlock.outgoingEdges = new Edge(info, successor, this.currentBasicBlock.outgoingEdges);
    }

    private void endCurrentBasicBlockWithNoSuccessor() {
        if (this.compute == 4) {
            Label nextBasicBlock = new Label();
            nextBasicBlock.frame = new Frame(nextBasicBlock);
            nextBasicBlock.resolve(this.code.data, this.code.length);
            this.lastBasicBlock.nextBasicBlock = nextBasicBlock;
            this.lastBasicBlock = nextBasicBlock;
            this.currentBasicBlock = null;
        } else if (this.compute == 1) {
            this.currentBasicBlock.outputStackMax = (short) this.maxRelativeStackSize;
            this.currentBasicBlock = null;
        }
    }

    /* access modifiers changed from: package-private */
    public int visitFrameStart(int offset, int numLocal, int numStack) {
        int frameLength = 3 + numLocal + numStack;
        if (this.currentFrame == null || this.currentFrame.length < frameLength) {
            this.currentFrame = new int[frameLength];
        }
        this.currentFrame[0] = offset;
        this.currentFrame[1] = numLocal;
        this.currentFrame[2] = numStack;
        return 3;
    }

    /* access modifiers changed from: package-private */
    public void visitAbstractType(int frameIndex, int abstractType) {
        this.currentFrame[frameIndex] = abstractType;
    }

    /* access modifiers changed from: package-private */
    public void visitFrameEnd() {
        if (this.previousFrame != null) {
            if (this.stackMapTableEntries == null) {
                this.stackMapTableEntries = new ByteVector();
            }
            putFrame();
            this.stackMapTableNumberOfEntries++;
        }
        this.previousFrame = this.currentFrame;
        this.currentFrame = null;
    }

    private void putFrame() {
        int offsetDelta;
        int numLocal = this.currentFrame[1];
        int numStack = this.currentFrame[2];
        if (this.symbolTable.getMajorVersion() < 50) {
            this.stackMapTableEntries.putShort(this.currentFrame[0]).putShort(numLocal);
            putAbstractTypes(3, 3 + numLocal);
            this.stackMapTableEntries.putShort(numStack);
            putAbstractTypes(3 + numLocal, 3 + numLocal + numStack);
            return;
        }
        if (this.stackMapTableNumberOfEntries == 0) {
            offsetDelta = this.currentFrame[0];
        } else {
            offsetDelta = (this.currentFrame[0] - this.previousFrame[0]) - 1;
        }
        int previousNumlocal = this.previousFrame[1];
        int numLocalDelta = numLocal - previousNumlocal;
        int type = 255;
        if (numStack == 0) {
            switch (numLocalDelta) {
                case SelectStrategy.BUSY_WAIT:
                case -2:
                case -1:
                    type = 248;
                    break;
                case 0:
                    type = offsetDelta < 64 ? 0 : PacketOpcodes.SceneForceLockNotify;
                    break;
                case 1:
                case 2:
                case 3:
                    type = 252;
                    break;
            }
        } else if (numLocalDelta == 0 && numStack == 1) {
            if (offsetDelta < 63) {
                type = 64;
            } else {
                type = PacketOpcodes.ClientScriptEventNotify;
            }
        }
        if (type != 255) {
            int frameIndex = 3;
            int i = 0;
            while (true) {
                if (i < previousNumlocal && i < numLocal) {
                    if (this.currentFrame[frameIndex] != this.previousFrame[frameIndex]) {
                        type = 255;
                    } else {
                        frameIndex++;
                        i++;
                    }
                }
            }
        }
        switch (type) {
            case 0:
                this.stackMapTableEntries.putByte(offsetDelta);
                return;
            case 64:
                this.stackMapTableEntries.putByte(64 + offsetDelta);
                putAbstractTypes(3 + numLocal, 4 + numLocal);
                return;
            case PacketOpcodes.ClientScriptEventNotify:
                this.stackMapTableEntries.putByte(PacketOpcodes.ClientScriptEventNotify).putShort(offsetDelta);
                putAbstractTypes(3 + numLocal, 4 + numLocal);
                return;
            case PacketOpcodes.EnterSceneDoneReq:
                this.stackMapTableEntries.putByte(PacketOpcodes.SceneForceLockNotify + numLocalDelta).putShort(offsetDelta);
                return;
            case PacketOpcodes.SceneForceLockNotify:
                this.stackMapTableEntries.putByte(PacketOpcodes.SceneForceLockNotify).putShort(offsetDelta);
                return;
            case 252:
                this.stackMapTableEntries.putByte(PacketOpcodes.SceneForceLockNotify + numLocalDelta).putShort(offsetDelta);
                putAbstractTypes(3 + previousNumlocal, 3 + numLocal);
                return;
            case 255:
            default:
                this.stackMapTableEntries.putByte(255).putShort(offsetDelta).putShort(numLocal);
                putAbstractTypes(3, 3 + numLocal);
                this.stackMapTableEntries.putShort(numStack);
                putAbstractTypes(3 + numLocal, 3 + numLocal + numStack);
                return;
        }
    }

    private void putAbstractTypes(int start, int end) {
        for (int i = start; i < end; i++) {
            Frame.putAbstractType(this.symbolTable, this.currentFrame[i], this.stackMapTableEntries);
        }
    }

    private void putFrameType(Object type) {
        if (type instanceof Integer) {
            this.stackMapTableEntries.putByte(((Integer) type).intValue());
        } else if (type instanceof String) {
            this.stackMapTableEntries.putByte(7).putShort(this.symbolTable.addConstantClass((String) type).index);
        } else {
            this.stackMapTableEntries.putByte(8).putShort(((Label) type).bytecodeOffset);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean canCopyMethodAttributes(ClassReader source, boolean hasSyntheticAttribute, boolean hasDeprecatedAttribute, int descriptorIndex, int signatureIndex, int exceptionsOffset) {
        if (!(source == this.symbolTable.getSource() && descriptorIndex == this.descriptorIndex && signatureIndex == this.signatureIndex)) {
            return false;
        }
        if (hasDeprecatedAttribute != ((this.accessFlags & 131072) != 0)) {
            return false;
        }
        if (hasSyntheticAttribute != (this.symbolTable.getMajorVersion() < 49 && (this.accessFlags & 4096) != 0)) {
            return false;
        }
        if (exceptionsOffset == 0) {
            if (this.numberOfExceptions != 0) {
                return false;
            }
            return true;
        } else if (source.readUnsignedShort(exceptionsOffset) != this.numberOfExceptions) {
            return true;
        } else {
            int currentExceptionOffset = exceptionsOffset + 2;
            for (int i = 0; i < this.numberOfExceptions; i++) {
                if (source.readUnsignedShort(currentExceptionOffset) != this.exceptionIndexTable[i]) {
                    return false;
                }
                currentExceptionOffset += 2;
            }
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public void setMethodAttributesSource(int methodInfoOffset, int methodInfoLength) {
        this.sourceOffset = methodInfoOffset + 6;
        this.sourceLength = methodInfoLength - 6;
    }

    /* access modifiers changed from: package-private */
    public int computeMethodInfoSize() {
        int i;
        int i2;
        if (this.sourceOffset != 0) {
            return 6 + this.sourceLength;
        }
        int size = 8;
        if (this.code.length > 0) {
            if (this.code.length > 65535) {
                throw new MethodTooLargeException(this.symbolTable.getClassName(), this.name, this.descriptor, this.code.length);
            }
            this.symbolTable.addConstantUtf8(CodeAttribute.tag);
            size = 8 + 16 + this.code.length + Handler.getExceptionTableSize(this.firstHandler);
            if (this.stackMapTableEntries != null) {
                this.symbolTable.addConstantUtf8(this.symbolTable.getMajorVersion() >= 50 ? StackMapTable.tag : StackMap.tag);
                size += 8 + this.stackMapTableEntries.length;
            }
            if (this.lineNumberTable != null) {
                this.symbolTable.addConstantUtf8(LineNumberAttribute.tag);
                size += 8 + this.lineNumberTable.length;
            }
            if (this.localVariableTable != null) {
                this.symbolTable.addConstantUtf8(LocalVariableAttribute.tag);
                size += 8 + this.localVariableTable.length;
            }
            if (this.localVariableTypeTable != null) {
                this.symbolTable.addConstantUtf8("LocalVariableTypeTable");
                size += 8 + this.localVariableTypeTable.length;
            }
            if (this.lastCodeRuntimeVisibleTypeAnnotation != null) {
                size += this.lastCodeRuntimeVisibleTypeAnnotation.computeAnnotationsSize(TypeAnnotationsAttribute.visibleTag);
            }
            if (this.lastCodeRuntimeInvisibleTypeAnnotation != null) {
                size += this.lastCodeRuntimeInvisibleTypeAnnotation.computeAnnotationsSize(TypeAnnotationsAttribute.invisibleTag);
            }
            if (this.firstCodeAttribute != null) {
                size += this.firstCodeAttribute.computeAttributesSize(this.symbolTable, this.code.data, this.code.length, this.maxStack, this.maxLocals);
            }
        }
        if (this.numberOfExceptions > 0) {
            this.symbolTable.addConstantUtf8(ExceptionsAttribute.tag);
            size += 8 + (2 * this.numberOfExceptions);
        }
        int size2 = size + Attribute.computeAttributesSize(this.symbolTable, this.accessFlags, this.signatureIndex) + AnnotationWriter.computeAnnotationsSize(this.lastRuntimeVisibleAnnotation, this.lastRuntimeInvisibleAnnotation, this.lastRuntimeVisibleTypeAnnotation, this.lastRuntimeInvisibleTypeAnnotation);
        if (this.lastRuntimeVisibleParameterAnnotations != null) {
            AnnotationWriter[] annotationWriterArr = this.lastRuntimeVisibleParameterAnnotations;
            if (this.visibleAnnotableParameterCount == 0) {
                i2 = this.lastRuntimeVisibleParameterAnnotations.length;
            } else {
                i2 = this.visibleAnnotableParameterCount;
            }
            size2 += AnnotationWriter.computeParameterAnnotationsSize(ParameterAnnotationsAttribute.visibleTag, annotationWriterArr, i2);
        }
        if (this.lastRuntimeInvisibleParameterAnnotations != null) {
            AnnotationWriter[] annotationWriterArr2 = this.lastRuntimeInvisibleParameterAnnotations;
            if (this.invisibleAnnotableParameterCount == 0) {
                i = this.lastRuntimeInvisibleParameterAnnotations.length;
            } else {
                i = this.invisibleAnnotableParameterCount;
            }
            size2 += AnnotationWriter.computeParameterAnnotationsSize(ParameterAnnotationsAttribute.invisibleTag, annotationWriterArr2, i);
        }
        if (this.defaultValue != null) {
            this.symbolTable.addConstantUtf8(AnnotationDefaultAttribute.tag);
            size2 += 6 + this.defaultValue.length;
        }
        if (this.parameters != null) {
            this.symbolTable.addConstantUtf8(MethodParametersAttribute.tag);
            size2 += 7 + this.parameters.length;
        }
        if (this.firstAttribute != null) {
            size2 += this.firstAttribute.computeAttributesSize(this.symbolTable);
        }
        return size2;
    }

    /* access modifiers changed from: package-private */
    public void putMethodInfo(ByteVector output) {
        int i;
        int i2;
        boolean useSyntheticAttribute = this.symbolTable.getMajorVersion() < 49;
        output.putShort(this.accessFlags & ((useSyntheticAttribute ? 4096 : 0) ^ -1)).putShort(this.nameIndex).putShort(this.descriptorIndex);
        if (this.sourceOffset != 0) {
            output.putByteArray(this.symbolTable.getSource().classFileBuffer, this.sourceOffset, this.sourceLength);
            return;
        }
        int attributeCount = 0;
        if (this.code.length > 0) {
            attributeCount = 0 + 1;
        }
        if (this.numberOfExceptions > 0) {
            attributeCount++;
        }
        if ((this.accessFlags & 4096) != 0 && useSyntheticAttribute) {
            attributeCount++;
        }
        if (this.signatureIndex != 0) {
            attributeCount++;
        }
        if ((this.accessFlags & 131072) != 0) {
            attributeCount++;
        }
        if (this.lastRuntimeVisibleAnnotation != null) {
            attributeCount++;
        }
        if (this.lastRuntimeInvisibleAnnotation != null) {
            attributeCount++;
        }
        if (this.lastRuntimeVisibleParameterAnnotations != null) {
            attributeCount++;
        }
        if (this.lastRuntimeInvisibleParameterAnnotations != null) {
            attributeCount++;
        }
        if (this.lastRuntimeVisibleTypeAnnotation != null) {
            attributeCount++;
        }
        if (this.lastRuntimeInvisibleTypeAnnotation != null) {
            attributeCount++;
        }
        if (this.defaultValue != null) {
            attributeCount++;
        }
        if (this.parameters != null) {
            attributeCount++;
        }
        if (this.firstAttribute != null) {
            attributeCount += this.firstAttribute.getAttributeCount();
        }
        output.putShort(attributeCount);
        if (this.code.length > 0) {
            int size = 10 + this.code.length + Handler.getExceptionTableSize(this.firstHandler);
            int codeAttributeCount = 0;
            if (this.stackMapTableEntries != null) {
                size += 8 + this.stackMapTableEntries.length;
                codeAttributeCount = 0 + 1;
            }
            if (this.lineNumberTable != null) {
                size += 8 + this.lineNumberTable.length;
                codeAttributeCount++;
            }
            if (this.localVariableTable != null) {
                size += 8 + this.localVariableTable.length;
                codeAttributeCount++;
            }
            if (this.localVariableTypeTable != null) {
                size += 8 + this.localVariableTypeTable.length;
                codeAttributeCount++;
            }
            if (this.lastCodeRuntimeVisibleTypeAnnotation != null) {
                size += this.lastCodeRuntimeVisibleTypeAnnotation.computeAnnotationsSize(TypeAnnotationsAttribute.visibleTag);
                codeAttributeCount++;
            }
            if (this.lastCodeRuntimeInvisibleTypeAnnotation != null) {
                size += this.lastCodeRuntimeInvisibleTypeAnnotation.computeAnnotationsSize(TypeAnnotationsAttribute.invisibleTag);
                codeAttributeCount++;
            }
            if (this.firstCodeAttribute != null) {
                size += this.firstCodeAttribute.computeAttributesSize(this.symbolTable, this.code.data, this.code.length, this.maxStack, this.maxLocals);
                codeAttributeCount += this.firstCodeAttribute.getAttributeCount();
            }
            output.putShort(this.symbolTable.addConstantUtf8(CodeAttribute.tag)).putInt(size).putShort(this.maxStack).putShort(this.maxLocals).putInt(this.code.length).putByteArray(this.code.data, 0, this.code.length);
            Handler.putExceptionTable(this.firstHandler, output);
            output.putShort(codeAttributeCount);
            if (this.stackMapTableEntries != null) {
                output.putShort(this.symbolTable.addConstantUtf8(this.symbolTable.getMajorVersion() >= 50 ? StackMapTable.tag : StackMap.tag)).putInt(2 + this.stackMapTableEntries.length).putShort(this.stackMapTableNumberOfEntries).putByteArray(this.stackMapTableEntries.data, 0, this.stackMapTableEntries.length);
            }
            if (this.lineNumberTable != null) {
                output.putShort(this.symbolTable.addConstantUtf8(LineNumberAttribute.tag)).putInt(2 + this.lineNumberTable.length).putShort(this.lineNumberTableLength).putByteArray(this.lineNumberTable.data, 0, this.lineNumberTable.length);
            }
            if (this.localVariableTable != null) {
                output.putShort(this.symbolTable.addConstantUtf8(LocalVariableAttribute.tag)).putInt(2 + this.localVariableTable.length).putShort(this.localVariableTableLength).putByteArray(this.localVariableTable.data, 0, this.localVariableTable.length);
            }
            if (this.localVariableTypeTable != null) {
                output.putShort(this.symbolTable.addConstantUtf8("LocalVariableTypeTable")).putInt(2 + this.localVariableTypeTable.length).putShort(this.localVariableTypeTableLength).putByteArray(this.localVariableTypeTable.data, 0, this.localVariableTypeTable.length);
            }
            if (this.lastCodeRuntimeVisibleTypeAnnotation != null) {
                this.lastCodeRuntimeVisibleTypeAnnotation.putAnnotations(this.symbolTable.addConstantUtf8(TypeAnnotationsAttribute.visibleTag), output);
            }
            if (this.lastCodeRuntimeInvisibleTypeAnnotation != null) {
                this.lastCodeRuntimeInvisibleTypeAnnotation.putAnnotations(this.symbolTable.addConstantUtf8(TypeAnnotationsAttribute.invisibleTag), output);
            }
            if (this.firstCodeAttribute != null) {
                this.firstCodeAttribute.putAttributes(this.symbolTable, this.code.data, this.code.length, this.maxStack, this.maxLocals, output);
            }
        }
        if (this.numberOfExceptions > 0) {
            output.putShort(this.symbolTable.addConstantUtf8(ExceptionsAttribute.tag)).putInt(2 + (2 * this.numberOfExceptions)).putShort(this.numberOfExceptions);
            for (int exceptionIndex : this.exceptionIndexTable) {
                output.putShort(exceptionIndex);
            }
        }
        Attribute.putAttributes(this.symbolTable, this.accessFlags, this.signatureIndex, output);
        AnnotationWriter.putAnnotations(this.symbolTable, this.lastRuntimeVisibleAnnotation, this.lastRuntimeInvisibleAnnotation, this.lastRuntimeVisibleTypeAnnotation, this.lastRuntimeInvisibleTypeAnnotation, output);
        if (this.lastRuntimeVisibleParameterAnnotations != null) {
            int addConstantUtf8 = this.symbolTable.addConstantUtf8(ParameterAnnotationsAttribute.visibleTag);
            AnnotationWriter[] annotationWriterArr = this.lastRuntimeVisibleParameterAnnotations;
            if (this.visibleAnnotableParameterCount == 0) {
                i2 = this.lastRuntimeVisibleParameterAnnotations.length;
            } else {
                i2 = this.visibleAnnotableParameterCount;
            }
            AnnotationWriter.putParameterAnnotations(addConstantUtf8, annotationWriterArr, i2, output);
        }
        if (this.lastRuntimeInvisibleParameterAnnotations != null) {
            int addConstantUtf82 = this.symbolTable.addConstantUtf8(ParameterAnnotationsAttribute.invisibleTag);
            AnnotationWriter[] annotationWriterArr2 = this.lastRuntimeInvisibleParameterAnnotations;
            if (this.invisibleAnnotableParameterCount == 0) {
                i = this.lastRuntimeInvisibleParameterAnnotations.length;
            } else {
                i = this.invisibleAnnotableParameterCount;
            }
            AnnotationWriter.putParameterAnnotations(addConstantUtf82, annotationWriterArr2, i, output);
        }
        if (this.defaultValue != null) {
            output.putShort(this.symbolTable.addConstantUtf8(AnnotationDefaultAttribute.tag)).putInt(this.defaultValue.length).putByteArray(this.defaultValue.data, 0, this.defaultValue.length);
        }
        if (this.parameters != null) {
            output.putShort(this.symbolTable.addConstantUtf8(MethodParametersAttribute.tag)).putInt(1 + this.parameters.length).putByte(this.parametersCount).putByteArray(this.parameters.data, 0, this.parameters.length);
        }
        if (this.firstAttribute != null) {
            this.firstAttribute.putAttributes(this.symbolTable, output);
        }
    }

    /* access modifiers changed from: package-private */
    public final void collectAttributePrototypes(Attribute.Set attributePrototypes) {
        attributePrototypes.addAttributes(this.firstAttribute);
        attributePrototypes.addAttributes(this.firstCodeAttribute);
    }
}
