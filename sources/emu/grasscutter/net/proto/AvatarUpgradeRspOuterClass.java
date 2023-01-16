package emu.grasscutter.net.proto;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MapEntry;
import com.google.protobuf.MapField;
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.WireFormat;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Map;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarUpgradeRspOuterClass.class */
public final class AvatarUpgradeRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0016AvatarUpgradeRsp.proto\"Ö\u0002\n\u0010AvatarUpgradeRsp\u0012\u000f\n\u0007retcode\u0018\b \u0001(\u0005\u0012\u0013\n\u000bavatar_guid\u0018\u000e \u0001(\u0004\u0012\u0011\n\tcur_level\u0018\t \u0001(\r\u0012B\n\u0012cur_fight_prop_map\u0018\r \u0003(\u000b2&.AvatarUpgradeRsp.CurFightPropMapEntry\u0012B\n\u0012old_fight_prop_map\u0018\u0006 \u0003(\u000b2&.AvatarUpgradeRsp.OldFightPropMapEntry\u0012\u0011\n\told_level\u0018\f \u0001(\r\u001a6\n\u0014CurFightPropMapEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\r\u0012\r\n\u0005value\u0018\u0002 \u0001(\u0002:\u00028\u0001\u001a6\n\u0014OldFightPropMapEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\r\u0012\r\n\u0005value\u0018\u0002 \u0001(\u0002:\u00028\u0001B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_AvatarUpgradeRsp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_AvatarUpgradeRsp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_AvatarUpgradeRsp_descriptor, new String[]{"Retcode", "AvatarGuid", "CurLevel", "CurFightPropMap", "OldFightPropMap", "OldLevel"});
    private static final Descriptors.Descriptor internal_static_AvatarUpgradeRsp_CurFightPropMapEntry_descriptor = internal_static_AvatarUpgradeRsp_descriptor.getNestedTypes().get(0);

    /* renamed from: internal_static_AvatarUpgradeRsp_CurFightPropMapEntry_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f655x187f36df = new GeneratedMessageV3.FieldAccessorTable(internal_static_AvatarUpgradeRsp_CurFightPropMapEntry_descriptor, new String[]{"Key", "Value"});
    private static final Descriptors.Descriptor internal_static_AvatarUpgradeRsp_OldFightPropMapEntry_descriptor = internal_static_AvatarUpgradeRsp_descriptor.getNestedTypes().get(1);

    /* renamed from: internal_static_AvatarUpgradeRsp_OldFightPropMapEntry_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f656x575bb46 = new GeneratedMessageV3.FieldAccessorTable(internal_static_AvatarUpgradeRsp_OldFightPropMapEntry_descriptor, new String[]{"Key", "Value"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarUpgradeRspOuterClass$AvatarUpgradeRspOrBuilder.class */
    public interface AvatarUpgradeRspOrBuilder extends MessageOrBuilder {
        int getRetcode();

        long getAvatarGuid();

        int getCurLevel();

        int getCurFightPropMapCount();

        boolean containsCurFightPropMap(int i);

        @Deprecated
        Map<Integer, Float> getCurFightPropMap();

        Map<Integer, Float> getCurFightPropMapMap();

        float getCurFightPropMapOrDefault(int i, float f);

        float getCurFightPropMapOrThrow(int i);

        int getOldFightPropMapCount();

        boolean containsOldFightPropMap(int i);

        @Deprecated
        Map<Integer, Float> getOldFightPropMap();

        Map<Integer, Float> getOldFightPropMapMap();

        float getOldFightPropMapOrDefault(int i, float f);

        float getOldFightPropMapOrThrow(int i);

        int getOldLevel();
    }

    private AvatarUpgradeRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarUpgradeRspOuterClass$AvatarUpgradeRsp.class */
    public static final class AvatarUpgradeRsp extends GeneratedMessageV3 implements AvatarUpgradeRspOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int RETCODE_FIELD_NUMBER = 8;
        private int retcode_;
        public static final int AVATAR_GUID_FIELD_NUMBER = 14;
        private long avatarGuid_;
        public static final int CUR_LEVEL_FIELD_NUMBER = 9;
        private int curLevel_;
        public static final int CUR_FIGHT_PROP_MAP_FIELD_NUMBER = 13;
        private MapField<Integer, Float> curFightPropMap_;
        public static final int OLD_FIGHT_PROP_MAP_FIELD_NUMBER = 6;
        private MapField<Integer, Float> oldFightPropMap_;
        public static final int OLD_LEVEL_FIELD_NUMBER = 12;
        private int oldLevel_;
        private byte memoizedIsInitialized;
        private static final AvatarUpgradeRsp DEFAULT_INSTANCE = new AvatarUpgradeRsp();
        private static final Parser<AvatarUpgradeRsp> PARSER = new AbstractParser<AvatarUpgradeRsp>() { // from class: emu.grasscutter.net.proto.AvatarUpgradeRspOuterClass.AvatarUpgradeRsp.1
            @Override // com.google.protobuf.Parser
            public AvatarUpgradeRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new AvatarUpgradeRsp(input, extensionRegistry);
            }
        };

        /*  JADX ERROR: Dependency scan failed at insn: 0x002B: INVOKE_CUSTOM r0
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
        /*  JADX ERROR: Failed to decode insn: 0x002B: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.AvatarUpgradeRspOuterClass.AvatarUpgradeRsp.internalGetMapField(int):com.google.protobuf.MapField
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
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:87)
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
                    case 6: goto L_0x0021;
                    case 13: goto L_0x001c;
                    default: goto L_0x0026;
                }
                r0 = r4
                com.google.protobuf.MapField r0 = r0.internalGetCurFightPropMap()
                return r0
                r0 = r4
                com.google.protobuf.MapField r0 = r0.internalGetOldFightPropMap()
                return r0
                java.lang.RuntimeException r0 = new java.lang.RuntimeException
                r1 = r0
                r2 = r5
                // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                r1.<init>(r2)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.AvatarUpgradeRspOuterClass.AvatarUpgradeRsp.internalGetMapField(int):com.google.protobuf.MapField");
        }

        private AvatarUpgradeRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private AvatarUpgradeRsp() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new AvatarUpgradeRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private AvatarUpgradeRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 50:
                                if ((mutable_bitField0_ & 2) == 0) {
                                    this.oldFightPropMap_ = MapField.newMapField(OldFightPropMapDefaultEntryHolder.defaultEntry);
                                    mutable_bitField0_ |= 2;
                                }
                                MapEntry<Integer, Float> oldFightPropMap__ = (MapEntry) input.readMessage(OldFightPropMapDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
                                this.oldFightPropMap_.getMutableMap().put(oldFightPropMap__.getKey(), oldFightPropMap__.getValue());
                                break;
                            case 64:
                                this.retcode_ = input.readInt32();
                                break;
                            case 72:
                                this.curLevel_ = input.readUInt32();
                                break;
                            case 96:
                                this.oldLevel_ = input.readUInt32();
                                break;
                            case 106:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.curFightPropMap_ = MapField.newMapField(CurFightPropMapDefaultEntryHolder.defaultEntry);
                                    mutable_bitField0_ |= 1;
                                }
                                MapEntry<Integer, Float> curFightPropMap__ = (MapEntry) input.readMessage(CurFightPropMapDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
                                this.curFightPropMap_.getMutableMap().put(curFightPropMap__.getKey(), curFightPropMap__.getValue());
                                break;
                            case 112:
                                this.avatarGuid_ = input.readUInt64();
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
            return AvatarUpgradeRspOuterClass.internal_static_AvatarUpgradeRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AvatarUpgradeRspOuterClass.internal_static_AvatarUpgradeRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(AvatarUpgradeRsp.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.AvatarUpgradeRspOuterClass.AvatarUpgradeRspOrBuilder
        public int getRetcode() {
            return this.retcode_;
        }

        @Override // emu.grasscutter.net.proto.AvatarUpgradeRspOuterClass.AvatarUpgradeRspOrBuilder
        public long getAvatarGuid() {
            return this.avatarGuid_;
        }

        @Override // emu.grasscutter.net.proto.AvatarUpgradeRspOuterClass.AvatarUpgradeRspOrBuilder
        public int getCurLevel() {
            return this.curLevel_;
        }

        /* access modifiers changed from: private */
        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarUpgradeRspOuterClass$AvatarUpgradeRsp$CurFightPropMapDefaultEntryHolder.class */
        public static final class CurFightPropMapDefaultEntryHolder {
            static final MapEntry<Integer, Float> defaultEntry = MapEntry.newDefaultInstance(AvatarUpgradeRspOuterClass.internal_static_AvatarUpgradeRsp_CurFightPropMapEntry_descriptor, WireFormat.FieldType.UINT32, 0, WireFormat.FieldType.FLOAT, Float.valueOf(0.0f));

            private CurFightPropMapDefaultEntryHolder() {
            }
        }

        private MapField<Integer, Float> internalGetCurFightPropMap() {
            if (this.curFightPropMap_ == null) {
                return MapField.emptyMapField(CurFightPropMapDefaultEntryHolder.defaultEntry);
            }
            return this.curFightPropMap_;
        }

        @Override // emu.grasscutter.net.proto.AvatarUpgradeRspOuterClass.AvatarUpgradeRspOrBuilder
        public int getCurFightPropMapCount() {
            return internalGetCurFightPropMap().getMap().size();
        }

        @Override // emu.grasscutter.net.proto.AvatarUpgradeRspOuterClass.AvatarUpgradeRspOrBuilder
        public boolean containsCurFightPropMap(int key) {
            return internalGetCurFightPropMap().getMap().containsKey(Integer.valueOf(key));
        }

        @Override // emu.grasscutter.net.proto.AvatarUpgradeRspOuterClass.AvatarUpgradeRspOrBuilder
        @Deprecated
        public Map<Integer, Float> getCurFightPropMap() {
            return getCurFightPropMapMap();
        }

        @Override // emu.grasscutter.net.proto.AvatarUpgradeRspOuterClass.AvatarUpgradeRspOrBuilder
        public Map<Integer, Float> getCurFightPropMapMap() {
            return internalGetCurFightPropMap().getMap();
        }

        @Override // emu.grasscutter.net.proto.AvatarUpgradeRspOuterClass.AvatarUpgradeRspOrBuilder
        public float getCurFightPropMapOrDefault(int key, float defaultValue) {
            Map<Integer, Float> map = internalGetCurFightPropMap().getMap();
            return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)).floatValue() : defaultValue;
        }

        @Override // emu.grasscutter.net.proto.AvatarUpgradeRspOuterClass.AvatarUpgradeRspOrBuilder
        public float getCurFightPropMapOrThrow(int key) {
            Map<Integer, Float> map = internalGetCurFightPropMap().getMap();
            if (map.containsKey(Integer.valueOf(key))) {
                return map.get(Integer.valueOf(key)).floatValue();
            }
            throw new IllegalArgumentException();
        }

        /* access modifiers changed from: private */
        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarUpgradeRspOuterClass$AvatarUpgradeRsp$OldFightPropMapDefaultEntryHolder.class */
        public static final class OldFightPropMapDefaultEntryHolder {
            static final MapEntry<Integer, Float> defaultEntry = MapEntry.newDefaultInstance(AvatarUpgradeRspOuterClass.internal_static_AvatarUpgradeRsp_OldFightPropMapEntry_descriptor, WireFormat.FieldType.UINT32, 0, WireFormat.FieldType.FLOAT, Float.valueOf(0.0f));

            private OldFightPropMapDefaultEntryHolder() {
            }
        }

        private MapField<Integer, Float> internalGetOldFightPropMap() {
            if (this.oldFightPropMap_ == null) {
                return MapField.emptyMapField(OldFightPropMapDefaultEntryHolder.defaultEntry);
            }
            return this.oldFightPropMap_;
        }

        @Override // emu.grasscutter.net.proto.AvatarUpgradeRspOuterClass.AvatarUpgradeRspOrBuilder
        public int getOldFightPropMapCount() {
            return internalGetOldFightPropMap().getMap().size();
        }

        @Override // emu.grasscutter.net.proto.AvatarUpgradeRspOuterClass.AvatarUpgradeRspOrBuilder
        public boolean containsOldFightPropMap(int key) {
            return internalGetOldFightPropMap().getMap().containsKey(Integer.valueOf(key));
        }

        @Override // emu.grasscutter.net.proto.AvatarUpgradeRspOuterClass.AvatarUpgradeRspOrBuilder
        @Deprecated
        public Map<Integer, Float> getOldFightPropMap() {
            return getOldFightPropMapMap();
        }

        @Override // emu.grasscutter.net.proto.AvatarUpgradeRspOuterClass.AvatarUpgradeRspOrBuilder
        public Map<Integer, Float> getOldFightPropMapMap() {
            return internalGetOldFightPropMap().getMap();
        }

        @Override // emu.grasscutter.net.proto.AvatarUpgradeRspOuterClass.AvatarUpgradeRspOrBuilder
        public float getOldFightPropMapOrDefault(int key, float defaultValue) {
            Map<Integer, Float> map = internalGetOldFightPropMap().getMap();
            return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)).floatValue() : defaultValue;
        }

        @Override // emu.grasscutter.net.proto.AvatarUpgradeRspOuterClass.AvatarUpgradeRspOrBuilder
        public float getOldFightPropMapOrThrow(int key) {
            Map<Integer, Float> map = internalGetOldFightPropMap().getMap();
            if (map.containsKey(Integer.valueOf(key))) {
                return map.get(Integer.valueOf(key)).floatValue();
            }
            throw new IllegalArgumentException();
        }

        @Override // emu.grasscutter.net.proto.AvatarUpgradeRspOuterClass.AvatarUpgradeRspOrBuilder
        public int getOldLevel() {
            return this.oldLevel_;
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
            GeneratedMessageV3.serializeIntegerMapTo(output, internalGetOldFightPropMap(), OldFightPropMapDefaultEntryHolder.defaultEntry, 6);
            if (this.retcode_ != 0) {
                output.writeInt32(8, this.retcode_);
            }
            if (this.curLevel_ != 0) {
                output.writeUInt32(9, this.curLevel_);
            }
            if (this.oldLevel_ != 0) {
                output.writeUInt32(12, this.oldLevel_);
            }
            GeneratedMessageV3.serializeIntegerMapTo(output, internalGetCurFightPropMap(), CurFightPropMapDefaultEntryHolder.defaultEntry, 13);
            if (this.avatarGuid_ != 0) {
                output.writeUInt64(14, this.avatarGuid_);
            }
            this.unknownFields.writeTo(output);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int size = this.memoizedSize;
            if (size != -1) {
                return size;
            }
            int size2 = 0;
            for (Map.Entry<Integer, Float> entry : internalGetOldFightPropMap().getMap().entrySet()) {
                size2 += CodedOutputStream.computeMessageSize(6, OldFightPropMapDefaultEntryHolder.defaultEntry.newBuilderForType().setKey(entry.getKey()).setValue(entry.getValue()).build());
            }
            if (this.retcode_ != 0) {
                size2 += CodedOutputStream.computeInt32Size(8, this.retcode_);
            }
            if (this.curLevel_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(9, this.curLevel_);
            }
            if (this.oldLevel_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(12, this.oldLevel_);
            }
            for (Map.Entry<Integer, Float> entry2 : internalGetCurFightPropMap().getMap().entrySet()) {
                size2 += CodedOutputStream.computeMessageSize(13, CurFightPropMapDefaultEntryHolder.defaultEntry.newBuilderForType().setKey(entry2.getKey()).setValue(entry2.getValue()).build());
            }
            if (this.avatarGuid_ != 0) {
                size2 += CodedOutputStream.computeUInt64Size(14, this.avatarGuid_);
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
            if (!(obj instanceof AvatarUpgradeRsp)) {
                return equals(obj);
            }
            AvatarUpgradeRsp other = (AvatarUpgradeRsp) obj;
            return getRetcode() == other.getRetcode() && getAvatarGuid() == other.getAvatarGuid() && getCurLevel() == other.getCurLevel() && internalGetCurFightPropMap().equals(other.internalGetCurFightPropMap()) && internalGetOldFightPropMap().equals(other.internalGetOldFightPropMap()) && getOldLevel() == other.getOldLevel() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 8)) + getRetcode())) + 14)) + Internal.hashLong(getAvatarGuid()))) + 9)) + getCurLevel();
            if (!internalGetCurFightPropMap().getMap().isEmpty()) {
                hash = (53 * ((37 * hash) + 13)) + internalGetCurFightPropMap().hashCode();
            }
            if (!internalGetOldFightPropMap().getMap().isEmpty()) {
                hash = (53 * ((37 * hash) + 6)) + internalGetOldFightPropMap().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * hash) + 12)) + getOldLevel())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static AvatarUpgradeRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AvatarUpgradeRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AvatarUpgradeRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AvatarUpgradeRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AvatarUpgradeRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AvatarUpgradeRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AvatarUpgradeRsp parseFrom(InputStream input) throws IOException {
            return (AvatarUpgradeRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AvatarUpgradeRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AvatarUpgradeRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static AvatarUpgradeRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (AvatarUpgradeRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static AvatarUpgradeRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AvatarUpgradeRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static AvatarUpgradeRsp parseFrom(CodedInputStream input) throws IOException {
            return (AvatarUpgradeRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AvatarUpgradeRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AvatarUpgradeRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(AvatarUpgradeRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarUpgradeRspOuterClass$AvatarUpgradeRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AvatarUpgradeRspOrBuilder {
            private int bitField0_;
            private int retcode_;
            private long avatarGuid_;
            private int curLevel_;
            private MapField<Integer, Float> curFightPropMap_;
            private MapField<Integer, Float> oldFightPropMap_;
            private int oldLevel_;

            /*  JADX ERROR: Dependency scan failed at insn: 0x002B: INVOKE_CUSTOM r0
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
            /*  JADX ERROR: Failed to decode insn: 0x002B: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.AvatarUpgradeRspOuterClass.AvatarUpgradeRsp.Builder.internalGetMapField(int):com.google.protobuf.MapField
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
                        case 6: goto L_0x0021;
                        case 13: goto L_0x001c;
                        default: goto L_0x0026;
                    }
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetCurFightPropMap()
                    return r0
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetOldFightPropMap()
                    return r0
                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                    r1 = r0
                    r2 = r5
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    r1.<init>(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.AvatarUpgradeRspOuterClass.AvatarUpgradeRsp.Builder.internalGetMapField(int):com.google.protobuf.MapField");
            }

            /*  JADX ERROR: Dependency scan failed at insn: 0x002B: INVOKE_CUSTOM r0
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
            /*  JADX ERROR: Failed to decode insn: 0x002B: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.AvatarUpgradeRspOuterClass.AvatarUpgradeRsp.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField
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
                        case 6: goto L_0x0021;
                        case 13: goto L_0x001c;
                        default: goto L_0x0026;
                    }
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetMutableCurFightPropMap()
                    return r0
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetMutableOldFightPropMap()
                    return r0
                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                    r1 = r0
                    r2 = r5
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    r1.<init>(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.AvatarUpgradeRspOuterClass.AvatarUpgradeRsp.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField");
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return AvatarUpgradeRspOuterClass.internal_static_AvatarUpgradeRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return AvatarUpgradeRspOuterClass.internal_static_AvatarUpgradeRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(AvatarUpgradeRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (AvatarUpgradeRsp.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.retcode_ = 0;
                this.avatarGuid_ = 0;
                this.curLevel_ = 0;
                internalGetMutableCurFightPropMap().clear();
                internalGetMutableOldFightPropMap().clear();
                this.oldLevel_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return AvatarUpgradeRspOuterClass.internal_static_AvatarUpgradeRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public AvatarUpgradeRsp getDefaultInstanceForType() {
                return AvatarUpgradeRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AvatarUpgradeRsp build() {
                AvatarUpgradeRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AvatarUpgradeRsp buildPartial() {
                AvatarUpgradeRsp result = new AvatarUpgradeRsp(this);
                int i = this.bitField0_;
                result.retcode_ = this.retcode_;
                result.avatarGuid_ = this.avatarGuid_;
                result.curLevel_ = this.curLevel_;
                result.curFightPropMap_ = internalGetCurFightPropMap();
                result.curFightPropMap_.makeImmutable();
                result.oldFightPropMap_ = internalGetOldFightPropMap();
                result.oldFightPropMap_.makeImmutable();
                result.oldLevel_ = this.oldLevel_;
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
                if (other instanceof AvatarUpgradeRsp) {
                    return mergeFrom((AvatarUpgradeRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(AvatarUpgradeRsp other) {
                if (other == AvatarUpgradeRsp.getDefaultInstance()) {
                    return this;
                }
                if (other.getRetcode() != 0) {
                    setRetcode(other.getRetcode());
                }
                if (other.getAvatarGuid() != 0) {
                    setAvatarGuid(other.getAvatarGuid());
                }
                if (other.getCurLevel() != 0) {
                    setCurLevel(other.getCurLevel());
                }
                internalGetMutableCurFightPropMap().mergeFrom(other.internalGetCurFightPropMap());
                internalGetMutableOldFightPropMap().mergeFrom(other.internalGetOldFightPropMap());
                if (other.getOldLevel() != 0) {
                    setOldLevel(other.getOldLevel());
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
                AvatarUpgradeRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = AvatarUpgradeRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (AvatarUpgradeRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.AvatarUpgradeRspOuterClass.AvatarUpgradeRspOrBuilder
            public int getRetcode() {
                return this.retcode_;
            }

            public Builder setRetcode(int value) {
                this.retcode_ = value;
                onChanged();
                return this;
            }

            public Builder clearRetcode() {
                this.retcode_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AvatarUpgradeRspOuterClass.AvatarUpgradeRspOrBuilder
            public long getAvatarGuid() {
                return this.avatarGuid_;
            }

            public Builder setAvatarGuid(long value) {
                this.avatarGuid_ = value;
                onChanged();
                return this;
            }

            public Builder clearAvatarGuid() {
                this.avatarGuid_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AvatarUpgradeRspOuterClass.AvatarUpgradeRspOrBuilder
            public int getCurLevel() {
                return this.curLevel_;
            }

            public Builder setCurLevel(int value) {
                this.curLevel_ = value;
                onChanged();
                return this;
            }

            public Builder clearCurLevel() {
                this.curLevel_ = 0;
                onChanged();
                return this;
            }

            private MapField<Integer, Float> internalGetCurFightPropMap() {
                if (this.curFightPropMap_ == null) {
                    return MapField.emptyMapField(CurFightPropMapDefaultEntryHolder.defaultEntry);
                }
                return this.curFightPropMap_;
            }

            private MapField<Integer, Float> internalGetMutableCurFightPropMap() {
                onChanged();
                if (this.curFightPropMap_ == null) {
                    this.curFightPropMap_ = MapField.newMapField(CurFightPropMapDefaultEntryHolder.defaultEntry);
                }
                if (!this.curFightPropMap_.isMutable()) {
                    this.curFightPropMap_ = this.curFightPropMap_.copy();
                }
                return this.curFightPropMap_;
            }

            @Override // emu.grasscutter.net.proto.AvatarUpgradeRspOuterClass.AvatarUpgradeRspOrBuilder
            public int getCurFightPropMapCount() {
                return internalGetCurFightPropMap().getMap().size();
            }

            @Override // emu.grasscutter.net.proto.AvatarUpgradeRspOuterClass.AvatarUpgradeRspOrBuilder
            public boolean containsCurFightPropMap(int key) {
                return internalGetCurFightPropMap().getMap().containsKey(Integer.valueOf(key));
            }

            @Override // emu.grasscutter.net.proto.AvatarUpgradeRspOuterClass.AvatarUpgradeRspOrBuilder
            @Deprecated
            public Map<Integer, Float> getCurFightPropMap() {
                return getCurFightPropMapMap();
            }

            @Override // emu.grasscutter.net.proto.AvatarUpgradeRspOuterClass.AvatarUpgradeRspOrBuilder
            public Map<Integer, Float> getCurFightPropMapMap() {
                return internalGetCurFightPropMap().getMap();
            }

            @Override // emu.grasscutter.net.proto.AvatarUpgradeRspOuterClass.AvatarUpgradeRspOrBuilder
            public float getCurFightPropMapOrDefault(int key, float defaultValue) {
                Map<Integer, Float> map = internalGetCurFightPropMap().getMap();
                return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)).floatValue() : defaultValue;
            }

            @Override // emu.grasscutter.net.proto.AvatarUpgradeRspOuterClass.AvatarUpgradeRspOrBuilder
            public float getCurFightPropMapOrThrow(int key) {
                Map<Integer, Float> map = internalGetCurFightPropMap().getMap();
                if (map.containsKey(Integer.valueOf(key))) {
                    return map.get(Integer.valueOf(key)).floatValue();
                }
                throw new IllegalArgumentException();
            }

            public Builder clearCurFightPropMap() {
                internalGetMutableCurFightPropMap().getMutableMap().clear();
                return this;
            }

            public Builder removeCurFightPropMap(int key) {
                internalGetMutableCurFightPropMap().getMutableMap().remove(Integer.valueOf(key));
                return this;
            }

            @Deprecated
            public Map<Integer, Float> getMutableCurFightPropMap() {
                return internalGetMutableCurFightPropMap().getMutableMap();
            }

            public Builder putCurFightPropMap(int key, float value) {
                internalGetMutableCurFightPropMap().getMutableMap().put(Integer.valueOf(key), Float.valueOf(value));
                return this;
            }

            public Builder putAllCurFightPropMap(Map<Integer, Float> values) {
                internalGetMutableCurFightPropMap().getMutableMap().putAll(values);
                return this;
            }

            private MapField<Integer, Float> internalGetOldFightPropMap() {
                if (this.oldFightPropMap_ == null) {
                    return MapField.emptyMapField(OldFightPropMapDefaultEntryHolder.defaultEntry);
                }
                return this.oldFightPropMap_;
            }

            private MapField<Integer, Float> internalGetMutableOldFightPropMap() {
                onChanged();
                if (this.oldFightPropMap_ == null) {
                    this.oldFightPropMap_ = MapField.newMapField(OldFightPropMapDefaultEntryHolder.defaultEntry);
                }
                if (!this.oldFightPropMap_.isMutable()) {
                    this.oldFightPropMap_ = this.oldFightPropMap_.copy();
                }
                return this.oldFightPropMap_;
            }

            @Override // emu.grasscutter.net.proto.AvatarUpgradeRspOuterClass.AvatarUpgradeRspOrBuilder
            public int getOldFightPropMapCount() {
                return internalGetOldFightPropMap().getMap().size();
            }

            @Override // emu.grasscutter.net.proto.AvatarUpgradeRspOuterClass.AvatarUpgradeRspOrBuilder
            public boolean containsOldFightPropMap(int key) {
                return internalGetOldFightPropMap().getMap().containsKey(Integer.valueOf(key));
            }

            @Override // emu.grasscutter.net.proto.AvatarUpgradeRspOuterClass.AvatarUpgradeRspOrBuilder
            @Deprecated
            public Map<Integer, Float> getOldFightPropMap() {
                return getOldFightPropMapMap();
            }

            @Override // emu.grasscutter.net.proto.AvatarUpgradeRspOuterClass.AvatarUpgradeRspOrBuilder
            public Map<Integer, Float> getOldFightPropMapMap() {
                return internalGetOldFightPropMap().getMap();
            }

            @Override // emu.grasscutter.net.proto.AvatarUpgradeRspOuterClass.AvatarUpgradeRspOrBuilder
            public float getOldFightPropMapOrDefault(int key, float defaultValue) {
                Map<Integer, Float> map = internalGetOldFightPropMap().getMap();
                return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)).floatValue() : defaultValue;
            }

            @Override // emu.grasscutter.net.proto.AvatarUpgradeRspOuterClass.AvatarUpgradeRspOrBuilder
            public float getOldFightPropMapOrThrow(int key) {
                Map<Integer, Float> map = internalGetOldFightPropMap().getMap();
                if (map.containsKey(Integer.valueOf(key))) {
                    return map.get(Integer.valueOf(key)).floatValue();
                }
                throw new IllegalArgumentException();
            }

            public Builder clearOldFightPropMap() {
                internalGetMutableOldFightPropMap().getMutableMap().clear();
                return this;
            }

            public Builder removeOldFightPropMap(int key) {
                internalGetMutableOldFightPropMap().getMutableMap().remove(Integer.valueOf(key));
                return this;
            }

            @Deprecated
            public Map<Integer, Float> getMutableOldFightPropMap() {
                return internalGetMutableOldFightPropMap().getMutableMap();
            }

            public Builder putOldFightPropMap(int key, float value) {
                internalGetMutableOldFightPropMap().getMutableMap().put(Integer.valueOf(key), Float.valueOf(value));
                return this;
            }

            public Builder putAllOldFightPropMap(Map<Integer, Float> values) {
                internalGetMutableOldFightPropMap().getMutableMap().putAll(values);
                return this;
            }

            @Override // emu.grasscutter.net.proto.AvatarUpgradeRspOuterClass.AvatarUpgradeRspOrBuilder
            public int getOldLevel() {
                return this.oldLevel_;
            }

            public Builder setOldLevel(int value) {
                this.oldLevel_ = value;
                onChanged();
                return this;
            }

            public Builder clearOldLevel() {
                this.oldLevel_ = 0;
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

        public static AvatarUpgradeRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<AvatarUpgradeRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<AvatarUpgradeRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public AvatarUpgradeRsp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
