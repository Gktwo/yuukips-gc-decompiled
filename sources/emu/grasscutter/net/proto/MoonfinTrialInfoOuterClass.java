package emu.grasscutter.net.proto;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MapEntry;
import com.google.protobuf.MapField;
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.WireFormat;
import emu.grasscutter.net.proto.MoonfinTrialLevelInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Map;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MoonfinTrialInfoOuterClass.class */
public final class MoonfinTrialInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0016MoonfinTrialInfo.proto\u001a\u001bMoonfinTrialLevelInfo.proto\"´\u0001\n\u0010MoonfinTrialInfo\u00129\n\flevelInfoMap\u0018\u0007 \u0003(\u000b2#.MoonfinTrialInfo.LevelInfoMapEntry\u0012\u0018\n\u0010specialFishCount\u0018\u0002 \u0001(\r\u001aK\n\u0011LevelInfoMapEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\r\u0012%\n\u0005value\u0018\u0002 \u0001(\u000b2\u0016.MoonfinTrialLevelInfo:\u00028\u0001B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{MoonfinTrialLevelInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_MoonfinTrialInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_MoonfinTrialInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_MoonfinTrialInfo_descriptor, new String[]{"LevelInfoMap", "SpecialFishCount"});
    private static final Descriptors.Descriptor internal_static_MoonfinTrialInfo_LevelInfoMapEntry_descriptor = internal_static_MoonfinTrialInfo_descriptor.getNestedTypes().get(0);

    /* renamed from: internal_static_MoonfinTrialInfo_LevelInfoMapEntry_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f783x2d80315a = new GeneratedMessageV3.FieldAccessorTable(internal_static_MoonfinTrialInfo_LevelInfoMapEntry_descriptor, new String[]{"Key", "Value"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MoonfinTrialInfoOuterClass$MoonfinTrialInfoOrBuilder.class */
    public interface MoonfinTrialInfoOrBuilder extends MessageOrBuilder {
        int getLevelInfoMapCount();

        boolean containsLevelInfoMap(int i);

        @Deprecated
        Map<Integer, MoonfinTrialLevelInfoOuterClass.MoonfinTrialLevelInfo> getLevelInfoMap();

        Map<Integer, MoonfinTrialLevelInfoOuterClass.MoonfinTrialLevelInfo> getLevelInfoMapMap();

        MoonfinTrialLevelInfoOuterClass.MoonfinTrialLevelInfo getLevelInfoMapOrDefault(int i, MoonfinTrialLevelInfoOuterClass.MoonfinTrialLevelInfo moonfinTrialLevelInfo);

        MoonfinTrialLevelInfoOuterClass.MoonfinTrialLevelInfo getLevelInfoMapOrThrow(int i);

        int getSpecialFishCount();
    }

    private MoonfinTrialInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MoonfinTrialInfoOuterClass$MoonfinTrialInfo.class */
    public static final class MoonfinTrialInfo extends GeneratedMessageV3 implements MoonfinTrialInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int LEVELINFOMAP_FIELD_NUMBER = 7;
        private MapField<Integer, MoonfinTrialLevelInfoOuterClass.MoonfinTrialLevelInfo> levelInfoMap_;
        public static final int SPECIALFISHCOUNT_FIELD_NUMBER = 2;
        private int specialFishCount_;
        private byte memoizedIsInitialized;
        private static final MoonfinTrialInfo DEFAULT_INSTANCE = new MoonfinTrialInfo();
        private static final Parser<MoonfinTrialInfo> PARSER = new AbstractParser<MoonfinTrialInfo>() { // from class: emu.grasscutter.net.proto.MoonfinTrialInfoOuterClass.MoonfinTrialInfo.1
            @Override // com.google.protobuf.Parser
            public MoonfinTrialInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new MoonfinTrialInfo(input, extensionRegistry);
            }
        };

        /*  JADX ERROR: Dependency scan failed at insn: 0x001E: INVOKE_CUSTOM r0
            java.lang.IndexOutOfBoundsException: Index 4 out of bounds for length 4
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
            	at java.base/java.util.Objects.checkIndex(Objects.java:359)
            	at java.base/java.util.ArrayList.get(ArrayList.java:427)
            	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processInsn(UsageInfoVisitor.java:130)
            	at jadx.core.dex.visitors.usage.UsageInfoVisitor.lambda$processInstructions$0(UsageInfoVisitor.java:79)
            	at jadx.plugins.input.java.data.code.JavaCodeReader.visitInstructions(JavaCodeReader.java:82)
            	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processInstructions(UsageInfoVisitor.java:77)
            	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processMethod(UsageInfoVisitor.java:62)
            	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processClass(UsageInfoVisitor.java:51)
            	at jadx.core.dex.visitors.usage.UsageInfoVisitor.init(UsageInfoVisitor.java:36)
            	at jadx.core.dex.nodes.RootNode.runPreDecompileStage(RootNode.java:267)
            */
        /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.MoonfinTrialInfoOuterClass.MoonfinTrialInfo.internalGetMapField(int):com.google.protobuf.MapField
            jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
            	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:55)
            	at jadx.core.dex.instructions.InsnDecoder.invoke(InsnDecoder.java:568)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:438)
            	at jadx.core.dex.instructions.InsnDecoder.lambda$process$0(InsnDecoder.java:48)
            	at jadx.plugins.input.java.data.code.JavaCodeReader.visitInstructions(JavaCodeReader.java:82)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:43)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:194)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:309)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:315)
            	at jadx.core.ProcessClass.process(ProcessClass.java:53)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:85)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:300)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:265)
            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
            	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
            	... 12 more
            */
        @Override // com.google.protobuf.GeneratedMessageV3
        protected com.google.protobuf.MapField internalGetMapField(int r5) {
            /*
                r4 = this;
                r0 = r5
                switch(r0) {
                    case 7: goto L_0x0014;
                    default: goto L_0x0019;
                }
                r0 = r4
                com.google.protobuf.MapField r0 = r0.internalGetLevelInfoMap()
                return r0
                java.lang.RuntimeException r0 = new java.lang.RuntimeException
                r1 = r0
                r2 = r5
                // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                r1.<init>(r2)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.MoonfinTrialInfoOuterClass.MoonfinTrialInfo.internalGetMapField(int):com.google.protobuf.MapField");
        }

        private MoonfinTrialInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private MoonfinTrialInfo() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new MoonfinTrialInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private MoonfinTrialInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this();
            UnknownFieldSet.Builder unknownFields;
            if (extensionRegistry == null) {
                throw new NullPointerException();
            }
            try {
                int mutable_bitField0_ = 0;
                unknownFields = UnknownFieldSet.newBuilder();
                boolean done = false;
                while (!done) {
                    try {
                        int tag = input.readTag();
                        switch (tag) {
                            case 0:
                                done = true;
                                break;
                            case 16:
                                this.specialFishCount_ = input.readUInt32();
                                break;
                            case 58:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.levelInfoMap_ = MapField.newMapField(LevelInfoMapDefaultEntryHolder.defaultEntry);
                                    mutable_bitField0_ |= 1;
                                }
                                MapEntry<Integer, MoonfinTrialLevelInfoOuterClass.MoonfinTrialLevelInfo> levelInfoMap__ = (MapEntry) input.readMessage(LevelInfoMapDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
                                this.levelInfoMap_.getMutableMap().put(levelInfoMap__.getKey(), levelInfoMap__.getValue());
                                break;
                            default:
                                if (parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                                    break;
                                } else {
                                    done = true;
                                    break;
                                }
                        }
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(this);
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    }
                }
            } finally {
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return MoonfinTrialInfoOuterClass.internal_static_MoonfinTrialInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return MoonfinTrialInfoOuterClass.internal_static_MoonfinTrialInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(MoonfinTrialInfo.class, Builder.class);
        }

        /* access modifiers changed from: private */
        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MoonfinTrialInfoOuterClass$MoonfinTrialInfo$LevelInfoMapDefaultEntryHolder.class */
        public static final class LevelInfoMapDefaultEntryHolder {
            static final MapEntry<Integer, MoonfinTrialLevelInfoOuterClass.MoonfinTrialLevelInfo> defaultEntry = MapEntry.newDefaultInstance(MoonfinTrialInfoOuterClass.internal_static_MoonfinTrialInfo_LevelInfoMapEntry_descriptor, WireFormat.FieldType.UINT32, 0, WireFormat.FieldType.MESSAGE, MoonfinTrialLevelInfoOuterClass.MoonfinTrialLevelInfo.getDefaultInstance());

            private LevelInfoMapDefaultEntryHolder() {
            }
        }

        private MapField<Integer, MoonfinTrialLevelInfoOuterClass.MoonfinTrialLevelInfo> internalGetLevelInfoMap() {
            if (this.levelInfoMap_ == null) {
                return MapField.emptyMapField(LevelInfoMapDefaultEntryHolder.defaultEntry);
            }
            return this.levelInfoMap_;
        }

        @Override // emu.grasscutter.net.proto.MoonfinTrialInfoOuterClass.MoonfinTrialInfoOrBuilder
        public int getLevelInfoMapCount() {
            return internalGetLevelInfoMap().getMap().size();
        }

        @Override // emu.grasscutter.net.proto.MoonfinTrialInfoOuterClass.MoonfinTrialInfoOrBuilder
        public boolean containsLevelInfoMap(int key) {
            return internalGetLevelInfoMap().getMap().containsKey(Integer.valueOf(key));
        }

        @Override // emu.grasscutter.net.proto.MoonfinTrialInfoOuterClass.MoonfinTrialInfoOrBuilder
        @Deprecated
        public Map<Integer, MoonfinTrialLevelInfoOuterClass.MoonfinTrialLevelInfo> getLevelInfoMap() {
            return getLevelInfoMapMap();
        }

        @Override // emu.grasscutter.net.proto.MoonfinTrialInfoOuterClass.MoonfinTrialInfoOrBuilder
        public Map<Integer, MoonfinTrialLevelInfoOuterClass.MoonfinTrialLevelInfo> getLevelInfoMapMap() {
            return internalGetLevelInfoMap().getMap();
        }

        @Override // emu.grasscutter.net.proto.MoonfinTrialInfoOuterClass.MoonfinTrialInfoOrBuilder
        public MoonfinTrialLevelInfoOuterClass.MoonfinTrialLevelInfo getLevelInfoMapOrDefault(int key, MoonfinTrialLevelInfoOuterClass.MoonfinTrialLevelInfo defaultValue) {
            Map<Integer, MoonfinTrialLevelInfoOuterClass.MoonfinTrialLevelInfo> map = internalGetLevelInfoMap().getMap();
            return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)) : defaultValue;
        }

        @Override // emu.grasscutter.net.proto.MoonfinTrialInfoOuterClass.MoonfinTrialInfoOrBuilder
        public MoonfinTrialLevelInfoOuterClass.MoonfinTrialLevelInfo getLevelInfoMapOrThrow(int key) {
            Map<Integer, MoonfinTrialLevelInfoOuterClass.MoonfinTrialLevelInfo> map = internalGetLevelInfoMap().getMap();
            if (map.containsKey(Integer.valueOf(key))) {
                return map.get(Integer.valueOf(key));
            }
            throw new IllegalArgumentException();
        }

        @Override // emu.grasscutter.net.proto.MoonfinTrialInfoOuterClass.MoonfinTrialInfoOrBuilder
        public int getSpecialFishCount() {
            return this.specialFishCount_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) {
                return true;
            }
            if (isInitialized == 0) {
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream output) throws IOException {
            if (this.specialFishCount_ != 0) {
                output.writeUInt32(2, this.specialFishCount_);
            }
            GeneratedMessageV3.serializeIntegerMapTo(output, internalGetLevelInfoMap(), LevelInfoMapDefaultEntryHolder.defaultEntry, 7);
            this.unknownFields.writeTo(output);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int size = this.memoizedSize;
            if (size != -1) {
                return size;
            }
            int size2 = 0;
            if (this.specialFishCount_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(2, this.specialFishCount_);
            }
            for (Map.Entry<Integer, MoonfinTrialLevelInfoOuterClass.MoonfinTrialLevelInfo> entry : internalGetLevelInfoMap().getMap().entrySet()) {
                size2 += CodedOutputStream.computeMessageSize(7, LevelInfoMapDefaultEntryHolder.defaultEntry.newBuilderForType().setKey(entry.getKey()).setValue(entry.getValue()).build());
            }
            int size3 = size2 + this.unknownFields.getSerializedSize();
            this.memoizedSize = size3;
            return size3;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof MoonfinTrialInfo)) {
                return equals(obj);
            }
            MoonfinTrialInfo other = (MoonfinTrialInfo) obj;
            return internalGetLevelInfoMap().equals(other.internalGetLevelInfoMap()) && getSpecialFishCount() == other.getSpecialFishCount() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (!internalGetLevelInfoMap().getMap().isEmpty()) {
                hash = (53 * ((37 * hash) + 7)) + internalGetLevelInfoMap().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * hash) + 2)) + getSpecialFishCount())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static MoonfinTrialInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MoonfinTrialInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MoonfinTrialInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MoonfinTrialInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MoonfinTrialInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MoonfinTrialInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MoonfinTrialInfo parseFrom(InputStream input) throws IOException {
            return (MoonfinTrialInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static MoonfinTrialInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MoonfinTrialInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static MoonfinTrialInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (MoonfinTrialInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static MoonfinTrialInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MoonfinTrialInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static MoonfinTrialInfo parseFrom(CodedInputStream input) throws IOException {
            return (MoonfinTrialInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static MoonfinTrialInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MoonfinTrialInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(MoonfinTrialInfo prototype) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.BuilderParent parent) {
            return new Builder(parent);
        }

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MoonfinTrialInfoOuterClass$MoonfinTrialInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements MoonfinTrialInfoOrBuilder {
            private int bitField0_;
            private MapField<Integer, MoonfinTrialLevelInfoOuterClass.MoonfinTrialLevelInfo> levelInfoMap_;
            private int specialFishCount_;

            /*  JADX ERROR: Dependency scan failed at insn: 0x001E: INVOKE_CUSTOM r0
                java.lang.IndexOutOfBoundsException: Index 4 out of bounds for length 4
                	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
                	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
                	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
                	at java.base/java.util.Objects.checkIndex(Objects.java:359)
                	at java.base/java.util.ArrayList.get(ArrayList.java:427)
                	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processInsn(UsageInfoVisitor.java:130)
                	at jadx.core.dex.visitors.usage.UsageInfoVisitor.lambda$processInstructions$0(UsageInfoVisitor.java:79)
                	at jadx.plugins.input.java.data.code.JavaCodeReader.visitInstructions(JavaCodeReader.java:82)
                	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processInstructions(UsageInfoVisitor.java:77)
                	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processMethod(UsageInfoVisitor.java:62)
                	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processClass(UsageInfoVisitor.java:51)
                	at jadx.core.dex.visitors.usage.UsageInfoVisitor.init(UsageInfoVisitor.java:36)
                	at jadx.core.dex.nodes.RootNode.runPreDecompileStage(RootNode.java:267)
                */
            /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.MoonfinTrialInfoOuterClass.MoonfinTrialInfo.Builder.internalGetMapField(int):com.google.protobuf.MapField
                jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:55)
                	at jadx.core.dex.instructions.InsnDecoder.invoke(InsnDecoder.java:568)
                	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:438)
                	at jadx.core.dex.instructions.InsnDecoder.lambda$process$0(InsnDecoder.java:48)
                	at jadx.plugins.input.java.data.code.JavaCodeReader.visitInstructions(JavaCodeReader.java:82)
                	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:43)
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:194)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:309)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:315)
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
                	... 8 more
                */
            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected com.google.protobuf.MapField internalGetMapField(int r5) {
                /*
                    r4 = this;
                    r0 = r5
                    switch(r0) {
                        case 7: goto L_0x0014;
                        default: goto L_0x0019;
                    }
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetLevelInfoMap()
                    return r0
                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                    r1 = r0
                    r2 = r5
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    r1.<init>(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.MoonfinTrialInfoOuterClass.MoonfinTrialInfo.Builder.internalGetMapField(int):com.google.protobuf.MapField");
            }

            /*  JADX ERROR: Dependency scan failed at insn: 0x001E: INVOKE_CUSTOM r0
                java.lang.IndexOutOfBoundsException: Index 4 out of bounds for length 4
                	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
                	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
                	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
                	at java.base/java.util.Objects.checkIndex(Objects.java:359)
                	at java.base/java.util.ArrayList.get(ArrayList.java:427)
                	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processInsn(UsageInfoVisitor.java:130)
                	at jadx.core.dex.visitors.usage.UsageInfoVisitor.lambda$processInstructions$0(UsageInfoVisitor.java:79)
                	at jadx.plugins.input.java.data.code.JavaCodeReader.visitInstructions(JavaCodeReader.java:82)
                	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processInstructions(UsageInfoVisitor.java:77)
                	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processMethod(UsageInfoVisitor.java:62)
                	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processClass(UsageInfoVisitor.java:51)
                	at jadx.core.dex.visitors.usage.UsageInfoVisitor.init(UsageInfoVisitor.java:36)
                	at jadx.core.dex.nodes.RootNode.runPreDecompileStage(RootNode.java:267)
                */
            /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.MoonfinTrialInfoOuterClass.MoonfinTrialInfo.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField
                jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:55)
                	at jadx.core.dex.instructions.InsnDecoder.invoke(InsnDecoder.java:568)
                	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:438)
                	at jadx.core.dex.instructions.InsnDecoder.lambda$process$0(InsnDecoder.java:48)
                	at jadx.plugins.input.java.data.code.JavaCodeReader.visitInstructions(JavaCodeReader.java:82)
                	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:43)
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:194)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:309)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:315)
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
                	... 8 more
                */
            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected com.google.protobuf.MapField internalGetMutableMapField(int r5) {
                /*
                    r4 = this;
                    r0 = r5
                    switch(r0) {
                        case 7: goto L_0x0014;
                        default: goto L_0x0019;
                    }
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetMutableLevelInfoMap()
                    return r0
                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                    r1 = r0
                    r2 = r5
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    r1.<init>(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.MoonfinTrialInfoOuterClass.MoonfinTrialInfo.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField");
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return MoonfinTrialInfoOuterClass.internal_static_MoonfinTrialInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return MoonfinTrialInfoOuterClass.internal_static_MoonfinTrialInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(MoonfinTrialInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (MoonfinTrialInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                internalGetMutableLevelInfoMap().clear();
                this.specialFishCount_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return MoonfinTrialInfoOuterClass.internal_static_MoonfinTrialInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public MoonfinTrialInfo getDefaultInstanceForType() {
                return MoonfinTrialInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public MoonfinTrialInfo build() {
                MoonfinTrialInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public MoonfinTrialInfo buildPartial() {
                MoonfinTrialInfo result = new MoonfinTrialInfo(this);
                int i = this.bitField0_;
                result.levelInfoMap_ = internalGetLevelInfoMap();
                result.levelInfoMap_.makeImmutable();
                result.specialFishCount_ = this.specialFishCount_;
                onBuilt();
                return result;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, java.lang.Object, com.google.protobuf.Message.Builder
            public Builder clone() {
                return clone();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setField(Descriptors.FieldDescriptor field, Object value) {
                return setField(field, value);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder clearField(Descriptors.FieldDescriptor field) {
                return clearField(field);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder clearOneof(Descriptors.OneofDescriptor oneof) {
                return clearOneof(oneof);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setRepeatedField(Descriptors.FieldDescriptor field, int index, Object value) {
                return setRepeatedField(field, index, value);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor field, Object value) {
                return addRepeatedField(field, value);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message other) {
                if (other instanceof MoonfinTrialInfo) {
                    return mergeFrom((MoonfinTrialInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(MoonfinTrialInfo other) {
                if (other == MoonfinTrialInfo.getDefaultInstance()) {
                    return this;
                }
                internalGetMutableLevelInfoMap().mergeFrom(other.internalGetLevelInfoMap());
                if (other.getSpecialFishCount() != 0) {
                    setSpecialFishCount(other.getSpecialFishCount());
                }
                mergeUnknownFields(other.unknownFields);
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                MoonfinTrialInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = MoonfinTrialInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (MoonfinTrialInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private MapField<Integer, MoonfinTrialLevelInfoOuterClass.MoonfinTrialLevelInfo> internalGetLevelInfoMap() {
                if (this.levelInfoMap_ == null) {
                    return MapField.emptyMapField(LevelInfoMapDefaultEntryHolder.defaultEntry);
                }
                return this.levelInfoMap_;
            }

            private MapField<Integer, MoonfinTrialLevelInfoOuterClass.MoonfinTrialLevelInfo> internalGetMutableLevelInfoMap() {
                onChanged();
                if (this.levelInfoMap_ == null) {
                    this.levelInfoMap_ = MapField.newMapField(LevelInfoMapDefaultEntryHolder.defaultEntry);
                }
                if (!this.levelInfoMap_.isMutable()) {
                    this.levelInfoMap_ = this.levelInfoMap_.copy();
                }
                return this.levelInfoMap_;
            }

            @Override // emu.grasscutter.net.proto.MoonfinTrialInfoOuterClass.MoonfinTrialInfoOrBuilder
            public int getLevelInfoMapCount() {
                return internalGetLevelInfoMap().getMap().size();
            }

            @Override // emu.grasscutter.net.proto.MoonfinTrialInfoOuterClass.MoonfinTrialInfoOrBuilder
            public boolean containsLevelInfoMap(int key) {
                return internalGetLevelInfoMap().getMap().containsKey(Integer.valueOf(key));
            }

            @Override // emu.grasscutter.net.proto.MoonfinTrialInfoOuterClass.MoonfinTrialInfoOrBuilder
            @Deprecated
            public Map<Integer, MoonfinTrialLevelInfoOuterClass.MoonfinTrialLevelInfo> getLevelInfoMap() {
                return getLevelInfoMapMap();
            }

            @Override // emu.grasscutter.net.proto.MoonfinTrialInfoOuterClass.MoonfinTrialInfoOrBuilder
            public Map<Integer, MoonfinTrialLevelInfoOuterClass.MoonfinTrialLevelInfo> getLevelInfoMapMap() {
                return internalGetLevelInfoMap().getMap();
            }

            @Override // emu.grasscutter.net.proto.MoonfinTrialInfoOuterClass.MoonfinTrialInfoOrBuilder
            public MoonfinTrialLevelInfoOuterClass.MoonfinTrialLevelInfo getLevelInfoMapOrDefault(int key, MoonfinTrialLevelInfoOuterClass.MoonfinTrialLevelInfo defaultValue) {
                Map<Integer, MoonfinTrialLevelInfoOuterClass.MoonfinTrialLevelInfo> map = internalGetLevelInfoMap().getMap();
                return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)) : defaultValue;
            }

            @Override // emu.grasscutter.net.proto.MoonfinTrialInfoOuterClass.MoonfinTrialInfoOrBuilder
            public MoonfinTrialLevelInfoOuterClass.MoonfinTrialLevelInfo getLevelInfoMapOrThrow(int key) {
                Map<Integer, MoonfinTrialLevelInfoOuterClass.MoonfinTrialLevelInfo> map = internalGetLevelInfoMap().getMap();
                if (map.containsKey(Integer.valueOf(key))) {
                    return map.get(Integer.valueOf(key));
                }
                throw new IllegalArgumentException();
            }

            public Builder clearLevelInfoMap() {
                internalGetMutableLevelInfoMap().getMutableMap().clear();
                return this;
            }

            public Builder removeLevelInfoMap(int key) {
                internalGetMutableLevelInfoMap().getMutableMap().remove(Integer.valueOf(key));
                return this;
            }

            @Deprecated
            public Map<Integer, MoonfinTrialLevelInfoOuterClass.MoonfinTrialLevelInfo> getMutableLevelInfoMap() {
                return internalGetMutableLevelInfoMap().getMutableMap();
            }

            public Builder putLevelInfoMap(int key, MoonfinTrialLevelInfoOuterClass.MoonfinTrialLevelInfo value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                internalGetMutableLevelInfoMap().getMutableMap().put(Integer.valueOf(key), value);
                return this;
            }

            public Builder putAllLevelInfoMap(Map<Integer, MoonfinTrialLevelInfoOuterClass.MoonfinTrialLevelInfo> values) {
                internalGetMutableLevelInfoMap().getMutableMap().putAll(values);
                return this;
            }

            @Override // emu.grasscutter.net.proto.MoonfinTrialInfoOuterClass.MoonfinTrialInfoOrBuilder
            public int getSpecialFishCount() {
                return this.specialFishCount_;
            }

            public Builder setSpecialFishCount(int value) {
                this.specialFishCount_ = value;
                onChanged();
                return this;
            }

            public Builder clearSpecialFishCount() {
                this.specialFishCount_ = 0;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFields) {
                return setUnknownFields(unknownFields);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
                return mergeUnknownFields(unknownFields);
            }
        }

        public static MoonfinTrialInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<MoonfinTrialInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<MoonfinTrialInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public MoonfinTrialInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        MoonfinTrialLevelInfoOuterClass.getDescriptor();
    }
}
