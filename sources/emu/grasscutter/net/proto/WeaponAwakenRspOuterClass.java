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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WeaponAwakenRspOuterClass.class */
public final class WeaponAwakenRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0015WeaponAwakenRsp.proto\"ó\u0002\n\u000fWeaponAwakenRsp\u0012C\n\u0013cur_affix_level_map\u0018\u0003 \u0003(\u000b2&.WeaponAwakenRsp.CurAffixLevelMapEntry\u0012\u0013\n\u000bavatar_guid\u0018\b \u0001(\u0004\u0012\u000f\n\u0007retcode\u0018\t \u0001(\u0005\u0012\u001a\n\u0012target_weapon_guid\u0018\u000e \u0001(\u0004\u0012C\n\u0013old_affix_level_map\u0018\u000f \u0003(\u000b2&.WeaponAwakenRsp.OldAffixLevelMapEntry\u0012\"\n\u001atarget_weapon_awaken_level\u0018\u0002 \u0001(\r\u001a7\n\u0015CurAffixLevelMapEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\r\u0012\r\n\u0005value\u0018\u0002 \u0001(\r:\u00028\u0001\u001a7\n\u0015OldAffixLevelMapEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\r\u0012\r\n\u0005value\u0018\u0002 \u0001(\r:\u00028\u0001B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_WeaponAwakenRsp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_WeaponAwakenRsp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_WeaponAwakenRsp_descriptor, new String[]{"CurAffixLevelMap", "AvatarGuid", "Retcode", "TargetWeaponGuid", "OldAffixLevelMap", "TargetWeaponAwakenLevel"});
    private static final Descriptors.Descriptor internal_static_WeaponAwakenRsp_CurAffixLevelMapEntry_descriptor = internal_static_WeaponAwakenRsp_descriptor.getNestedTypes().get(0);

    /* renamed from: internal_static_WeaponAwakenRsp_CurAffixLevelMapEntry_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f939x67bcdb86 = new GeneratedMessageV3.FieldAccessorTable(internal_static_WeaponAwakenRsp_CurAffixLevelMapEntry_descriptor, new String[]{"Key", "Value"});
    private static final Descriptors.Descriptor internal_static_WeaponAwakenRsp_OldAffixLevelMapEntry_descriptor = internal_static_WeaponAwakenRsp_descriptor.getNestedTypes().get(1);

    /* renamed from: internal_static_WeaponAwakenRsp_OldAffixLevelMapEntry_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f940x1996e3ff = new GeneratedMessageV3.FieldAccessorTable(internal_static_WeaponAwakenRsp_OldAffixLevelMapEntry_descriptor, new String[]{"Key", "Value"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WeaponAwakenRspOuterClass$WeaponAwakenRspOrBuilder.class */
    public interface WeaponAwakenRspOrBuilder extends MessageOrBuilder {
        int getCurAffixLevelMapCount();

        boolean containsCurAffixLevelMap(int i);

        @Deprecated
        Map<Integer, Integer> getCurAffixLevelMap();

        Map<Integer, Integer> getCurAffixLevelMapMap();

        int getCurAffixLevelMapOrDefault(int i, int i2);

        int getCurAffixLevelMapOrThrow(int i);

        long getAvatarGuid();

        int getRetcode();

        long getTargetWeaponGuid();

        int getOldAffixLevelMapCount();

        boolean containsOldAffixLevelMap(int i);

        @Deprecated
        Map<Integer, Integer> getOldAffixLevelMap();

        Map<Integer, Integer> getOldAffixLevelMapMap();

        int getOldAffixLevelMapOrDefault(int i, int i2);

        int getOldAffixLevelMapOrThrow(int i);

        int getTargetWeaponAwakenLevel();
    }

    private WeaponAwakenRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WeaponAwakenRspOuterClass$WeaponAwakenRsp.class */
    public static final class WeaponAwakenRsp extends GeneratedMessageV3 implements WeaponAwakenRspOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int CUR_AFFIX_LEVEL_MAP_FIELD_NUMBER = 3;
        private MapField<Integer, Integer> curAffixLevelMap_;
        public static final int AVATAR_GUID_FIELD_NUMBER = 8;
        private long avatarGuid_;
        public static final int RETCODE_FIELD_NUMBER = 9;
        private int retcode_;
        public static final int TARGET_WEAPON_GUID_FIELD_NUMBER = 14;
        private long targetWeaponGuid_;
        public static final int OLD_AFFIX_LEVEL_MAP_FIELD_NUMBER = 15;
        private MapField<Integer, Integer> oldAffixLevelMap_;
        public static final int TARGET_WEAPON_AWAKEN_LEVEL_FIELD_NUMBER = 2;
        private int targetWeaponAwakenLevel_;
        private byte memoizedIsInitialized;
        private static final WeaponAwakenRsp DEFAULT_INSTANCE = new WeaponAwakenRsp();
        private static final Parser<WeaponAwakenRsp> PARSER = new AbstractParser<WeaponAwakenRsp>() { // from class: emu.grasscutter.net.proto.WeaponAwakenRspOuterClass.WeaponAwakenRsp.1
            @Override // com.google.protobuf.Parser
            public WeaponAwakenRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new WeaponAwakenRsp(input, extensionRegistry);
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
        /*  JADX ERROR: Failed to decode insn: 0x002B: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.WeaponAwakenRspOuterClass.WeaponAwakenRsp.internalGetMapField(int):com.google.protobuf.MapField
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
                    case 3: goto L_0x001c;
                    case 15: goto L_0x0021;
                    default: goto L_0x0026;
                }
                r0 = r4
                com.google.protobuf.MapField r0 = r0.internalGetCurAffixLevelMap()
                return r0
                r0 = r4
                com.google.protobuf.MapField r0 = r0.internalGetOldAffixLevelMap()
                return r0
                java.lang.RuntimeException r0 = new java.lang.RuntimeException
                r1 = r0
                r2 = r5
                // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                r1.<init>(r2)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.WeaponAwakenRspOuterClass.WeaponAwakenRsp.internalGetMapField(int):com.google.protobuf.MapField");
        }

        private WeaponAwakenRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private WeaponAwakenRsp() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new WeaponAwakenRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private WeaponAwakenRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.targetWeaponAwakenLevel_ = input.readUInt32();
                                break;
                            case 26:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.curAffixLevelMap_ = MapField.newMapField(CurAffixLevelMapDefaultEntryHolder.defaultEntry);
                                    mutable_bitField0_ |= 1;
                                }
                                MapEntry<Integer, Integer> curAffixLevelMap__ = (MapEntry) input.readMessage(CurAffixLevelMapDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
                                this.curAffixLevelMap_.getMutableMap().put(curAffixLevelMap__.getKey(), curAffixLevelMap__.getValue());
                                break;
                            case 64:
                                this.avatarGuid_ = input.readUInt64();
                                break;
                            case 72:
                                this.retcode_ = input.readInt32();
                                break;
                            case 112:
                                this.targetWeaponGuid_ = input.readUInt64();
                                break;
                            case 122:
                                if ((mutable_bitField0_ & 2) == 0) {
                                    this.oldAffixLevelMap_ = MapField.newMapField(OldAffixLevelMapDefaultEntryHolder.defaultEntry);
                                    mutable_bitField0_ |= 2;
                                }
                                MapEntry<Integer, Integer> oldAffixLevelMap__ = (MapEntry) input.readMessage(OldAffixLevelMapDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
                                this.oldAffixLevelMap_.getMutableMap().put(oldAffixLevelMap__.getKey(), oldAffixLevelMap__.getValue());
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
            return WeaponAwakenRspOuterClass.internal_static_WeaponAwakenRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return WeaponAwakenRspOuterClass.internal_static_WeaponAwakenRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(WeaponAwakenRsp.class, Builder.class);
        }

        /* access modifiers changed from: private */
        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WeaponAwakenRspOuterClass$WeaponAwakenRsp$CurAffixLevelMapDefaultEntryHolder.class */
        public static final class CurAffixLevelMapDefaultEntryHolder {
            static final MapEntry<Integer, Integer> defaultEntry = MapEntry.newDefaultInstance(WeaponAwakenRspOuterClass.internal_static_WeaponAwakenRsp_CurAffixLevelMapEntry_descriptor, WireFormat.FieldType.UINT32, 0, WireFormat.FieldType.UINT32, 0);

            private CurAffixLevelMapDefaultEntryHolder() {
            }
        }

        private MapField<Integer, Integer> internalGetCurAffixLevelMap() {
            if (this.curAffixLevelMap_ == null) {
                return MapField.emptyMapField(CurAffixLevelMapDefaultEntryHolder.defaultEntry);
            }
            return this.curAffixLevelMap_;
        }

        @Override // emu.grasscutter.net.proto.WeaponAwakenRspOuterClass.WeaponAwakenRspOrBuilder
        public int getCurAffixLevelMapCount() {
            return internalGetCurAffixLevelMap().getMap().size();
        }

        @Override // emu.grasscutter.net.proto.WeaponAwakenRspOuterClass.WeaponAwakenRspOrBuilder
        public boolean containsCurAffixLevelMap(int key) {
            return internalGetCurAffixLevelMap().getMap().containsKey(Integer.valueOf(key));
        }

        @Override // emu.grasscutter.net.proto.WeaponAwakenRspOuterClass.WeaponAwakenRspOrBuilder
        @Deprecated
        public Map<Integer, Integer> getCurAffixLevelMap() {
            return getCurAffixLevelMapMap();
        }

        @Override // emu.grasscutter.net.proto.WeaponAwakenRspOuterClass.WeaponAwakenRspOrBuilder
        public Map<Integer, Integer> getCurAffixLevelMapMap() {
            return internalGetCurAffixLevelMap().getMap();
        }

        @Override // emu.grasscutter.net.proto.WeaponAwakenRspOuterClass.WeaponAwakenRspOrBuilder
        public int getCurAffixLevelMapOrDefault(int key, int defaultValue) {
            Map<Integer, Integer> map = internalGetCurAffixLevelMap().getMap();
            return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)).intValue() : defaultValue;
        }

        @Override // emu.grasscutter.net.proto.WeaponAwakenRspOuterClass.WeaponAwakenRspOrBuilder
        public int getCurAffixLevelMapOrThrow(int key) {
            Map<Integer, Integer> map = internalGetCurAffixLevelMap().getMap();
            if (map.containsKey(Integer.valueOf(key))) {
                return map.get(Integer.valueOf(key)).intValue();
            }
            throw new IllegalArgumentException();
        }

        @Override // emu.grasscutter.net.proto.WeaponAwakenRspOuterClass.WeaponAwakenRspOrBuilder
        public long getAvatarGuid() {
            return this.avatarGuid_;
        }

        @Override // emu.grasscutter.net.proto.WeaponAwakenRspOuterClass.WeaponAwakenRspOrBuilder
        public int getRetcode() {
            return this.retcode_;
        }

        @Override // emu.grasscutter.net.proto.WeaponAwakenRspOuterClass.WeaponAwakenRspOrBuilder
        public long getTargetWeaponGuid() {
            return this.targetWeaponGuid_;
        }

        /* access modifiers changed from: private */
        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WeaponAwakenRspOuterClass$WeaponAwakenRsp$OldAffixLevelMapDefaultEntryHolder.class */
        public static final class OldAffixLevelMapDefaultEntryHolder {
            static final MapEntry<Integer, Integer> defaultEntry = MapEntry.newDefaultInstance(WeaponAwakenRspOuterClass.internal_static_WeaponAwakenRsp_OldAffixLevelMapEntry_descriptor, WireFormat.FieldType.UINT32, 0, WireFormat.FieldType.UINT32, 0);

            private OldAffixLevelMapDefaultEntryHolder() {
            }
        }

        private MapField<Integer, Integer> internalGetOldAffixLevelMap() {
            if (this.oldAffixLevelMap_ == null) {
                return MapField.emptyMapField(OldAffixLevelMapDefaultEntryHolder.defaultEntry);
            }
            return this.oldAffixLevelMap_;
        }

        @Override // emu.grasscutter.net.proto.WeaponAwakenRspOuterClass.WeaponAwakenRspOrBuilder
        public int getOldAffixLevelMapCount() {
            return internalGetOldAffixLevelMap().getMap().size();
        }

        @Override // emu.grasscutter.net.proto.WeaponAwakenRspOuterClass.WeaponAwakenRspOrBuilder
        public boolean containsOldAffixLevelMap(int key) {
            return internalGetOldAffixLevelMap().getMap().containsKey(Integer.valueOf(key));
        }

        @Override // emu.grasscutter.net.proto.WeaponAwakenRspOuterClass.WeaponAwakenRspOrBuilder
        @Deprecated
        public Map<Integer, Integer> getOldAffixLevelMap() {
            return getOldAffixLevelMapMap();
        }

        @Override // emu.grasscutter.net.proto.WeaponAwakenRspOuterClass.WeaponAwakenRspOrBuilder
        public Map<Integer, Integer> getOldAffixLevelMapMap() {
            return internalGetOldAffixLevelMap().getMap();
        }

        @Override // emu.grasscutter.net.proto.WeaponAwakenRspOuterClass.WeaponAwakenRspOrBuilder
        public int getOldAffixLevelMapOrDefault(int key, int defaultValue) {
            Map<Integer, Integer> map = internalGetOldAffixLevelMap().getMap();
            return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)).intValue() : defaultValue;
        }

        @Override // emu.grasscutter.net.proto.WeaponAwakenRspOuterClass.WeaponAwakenRspOrBuilder
        public int getOldAffixLevelMapOrThrow(int key) {
            Map<Integer, Integer> map = internalGetOldAffixLevelMap().getMap();
            if (map.containsKey(Integer.valueOf(key))) {
                return map.get(Integer.valueOf(key)).intValue();
            }
            throw new IllegalArgumentException();
        }

        @Override // emu.grasscutter.net.proto.WeaponAwakenRspOuterClass.WeaponAwakenRspOrBuilder
        public int getTargetWeaponAwakenLevel() {
            return this.targetWeaponAwakenLevel_;
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
            if (this.targetWeaponAwakenLevel_ != 0) {
                output.writeUInt32(2, this.targetWeaponAwakenLevel_);
            }
            GeneratedMessageV3.serializeIntegerMapTo(output, internalGetCurAffixLevelMap(), CurAffixLevelMapDefaultEntryHolder.defaultEntry, 3);
            if (this.avatarGuid_ != 0) {
                output.writeUInt64(8, this.avatarGuid_);
            }
            if (this.retcode_ != 0) {
                output.writeInt32(9, this.retcode_);
            }
            if (this.targetWeaponGuid_ != 0) {
                output.writeUInt64(14, this.targetWeaponGuid_);
            }
            GeneratedMessageV3.serializeIntegerMapTo(output, internalGetOldAffixLevelMap(), OldAffixLevelMapDefaultEntryHolder.defaultEntry, 15);
            this.unknownFields.writeTo(output);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int size = this.memoizedSize;
            if (size != -1) {
                return size;
            }
            int size2 = 0;
            if (this.targetWeaponAwakenLevel_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(2, this.targetWeaponAwakenLevel_);
            }
            for (Map.Entry<Integer, Integer> entry : internalGetCurAffixLevelMap().getMap().entrySet()) {
                size2 += CodedOutputStream.computeMessageSize(3, CurAffixLevelMapDefaultEntryHolder.defaultEntry.newBuilderForType().setKey(entry.getKey()).setValue(entry.getValue()).build());
            }
            if (this.avatarGuid_ != 0) {
                size2 += CodedOutputStream.computeUInt64Size(8, this.avatarGuid_);
            }
            if (this.retcode_ != 0) {
                size2 += CodedOutputStream.computeInt32Size(9, this.retcode_);
            }
            if (this.targetWeaponGuid_ != 0) {
                size2 += CodedOutputStream.computeUInt64Size(14, this.targetWeaponGuid_);
            }
            for (Map.Entry<Integer, Integer> entry2 : internalGetOldAffixLevelMap().getMap().entrySet()) {
                size2 += CodedOutputStream.computeMessageSize(15, OldAffixLevelMapDefaultEntryHolder.defaultEntry.newBuilderForType().setKey(entry2.getKey()).setValue(entry2.getValue()).build());
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
            if (!(obj instanceof WeaponAwakenRsp)) {
                return equals(obj);
            }
            WeaponAwakenRsp other = (WeaponAwakenRsp) obj;
            return internalGetCurAffixLevelMap().equals(other.internalGetCurAffixLevelMap()) && getAvatarGuid() == other.getAvatarGuid() && getRetcode() == other.getRetcode() && getTargetWeaponGuid() == other.getTargetWeaponGuid() && internalGetOldAffixLevelMap().equals(other.internalGetOldAffixLevelMap()) && getTargetWeaponAwakenLevel() == other.getTargetWeaponAwakenLevel() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (!internalGetCurAffixLevelMap().getMap().isEmpty()) {
                hash = (53 * ((37 * hash) + 3)) + internalGetCurAffixLevelMap().hashCode();
            }
            int hash2 = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * hash) + 8)) + Internal.hashLong(getAvatarGuid()))) + 9)) + getRetcode())) + 14)) + Internal.hashLong(getTargetWeaponGuid());
            if (!internalGetOldAffixLevelMap().getMap().isEmpty()) {
                hash2 = (53 * ((37 * hash2) + 15)) + internalGetOldAffixLevelMap().hashCode();
            }
            int hash3 = (29 * ((53 * ((37 * hash2) + 2)) + getTargetWeaponAwakenLevel())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash3;
            return hash3;
        }

        public static WeaponAwakenRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static WeaponAwakenRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static WeaponAwakenRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static WeaponAwakenRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static WeaponAwakenRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static WeaponAwakenRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static WeaponAwakenRsp parseFrom(InputStream input) throws IOException {
            return (WeaponAwakenRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static WeaponAwakenRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WeaponAwakenRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static WeaponAwakenRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (WeaponAwakenRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static WeaponAwakenRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WeaponAwakenRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static WeaponAwakenRsp parseFrom(CodedInputStream input) throws IOException {
            return (WeaponAwakenRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static WeaponAwakenRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WeaponAwakenRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(WeaponAwakenRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WeaponAwakenRspOuterClass$WeaponAwakenRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements WeaponAwakenRspOrBuilder {
            private int bitField0_;
            private MapField<Integer, Integer> curAffixLevelMap_;
            private long avatarGuid_;
            private int retcode_;
            private long targetWeaponGuid_;
            private MapField<Integer, Integer> oldAffixLevelMap_;
            private int targetWeaponAwakenLevel_;

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
            /*  JADX ERROR: Failed to decode insn: 0x002B: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.WeaponAwakenRspOuterClass.WeaponAwakenRsp.Builder.internalGetMapField(int):com.google.protobuf.MapField
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
                        case 3: goto L_0x001c;
                        case 15: goto L_0x0021;
                        default: goto L_0x0026;
                    }
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetCurAffixLevelMap()
                    return r0
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetOldAffixLevelMap()
                    return r0
                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                    r1 = r0
                    r2 = r5
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    r1.<init>(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.WeaponAwakenRspOuterClass.WeaponAwakenRsp.Builder.internalGetMapField(int):com.google.protobuf.MapField");
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
            /*  JADX ERROR: Failed to decode insn: 0x002B: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.WeaponAwakenRspOuterClass.WeaponAwakenRsp.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField
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
                        case 3: goto L_0x001c;
                        case 15: goto L_0x0021;
                        default: goto L_0x0026;
                    }
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetMutableCurAffixLevelMap()
                    return r0
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetMutableOldAffixLevelMap()
                    return r0
                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                    r1 = r0
                    r2 = r5
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    r1.<init>(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.WeaponAwakenRspOuterClass.WeaponAwakenRsp.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField");
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return WeaponAwakenRspOuterClass.internal_static_WeaponAwakenRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return WeaponAwakenRspOuterClass.internal_static_WeaponAwakenRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(WeaponAwakenRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (WeaponAwakenRsp.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                internalGetMutableCurAffixLevelMap().clear();
                this.avatarGuid_ = 0;
                this.retcode_ = 0;
                this.targetWeaponGuid_ = 0;
                internalGetMutableOldAffixLevelMap().clear();
                this.targetWeaponAwakenLevel_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return WeaponAwakenRspOuterClass.internal_static_WeaponAwakenRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public WeaponAwakenRsp getDefaultInstanceForType() {
                return WeaponAwakenRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public WeaponAwakenRsp build() {
                WeaponAwakenRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public WeaponAwakenRsp buildPartial() {
                WeaponAwakenRsp result = new WeaponAwakenRsp(this);
                int i = this.bitField0_;
                result.curAffixLevelMap_ = internalGetCurAffixLevelMap();
                result.curAffixLevelMap_.makeImmutable();
                result.avatarGuid_ = this.avatarGuid_;
                result.retcode_ = this.retcode_;
                result.targetWeaponGuid_ = this.targetWeaponGuid_;
                result.oldAffixLevelMap_ = internalGetOldAffixLevelMap();
                result.oldAffixLevelMap_.makeImmutable();
                result.targetWeaponAwakenLevel_ = this.targetWeaponAwakenLevel_;
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
                if (other instanceof WeaponAwakenRsp) {
                    return mergeFrom((WeaponAwakenRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(WeaponAwakenRsp other) {
                if (other == WeaponAwakenRsp.getDefaultInstance()) {
                    return this;
                }
                internalGetMutableCurAffixLevelMap().mergeFrom(other.internalGetCurAffixLevelMap());
                if (other.getAvatarGuid() != 0) {
                    setAvatarGuid(other.getAvatarGuid());
                }
                if (other.getRetcode() != 0) {
                    setRetcode(other.getRetcode());
                }
                if (other.getTargetWeaponGuid() != 0) {
                    setTargetWeaponGuid(other.getTargetWeaponGuid());
                }
                internalGetMutableOldAffixLevelMap().mergeFrom(other.internalGetOldAffixLevelMap());
                if (other.getTargetWeaponAwakenLevel() != 0) {
                    setTargetWeaponAwakenLevel(other.getTargetWeaponAwakenLevel());
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
                WeaponAwakenRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = WeaponAwakenRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (WeaponAwakenRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private MapField<Integer, Integer> internalGetCurAffixLevelMap() {
                if (this.curAffixLevelMap_ == null) {
                    return MapField.emptyMapField(CurAffixLevelMapDefaultEntryHolder.defaultEntry);
                }
                return this.curAffixLevelMap_;
            }

            private MapField<Integer, Integer> internalGetMutableCurAffixLevelMap() {
                onChanged();
                if (this.curAffixLevelMap_ == null) {
                    this.curAffixLevelMap_ = MapField.newMapField(CurAffixLevelMapDefaultEntryHolder.defaultEntry);
                }
                if (!this.curAffixLevelMap_.isMutable()) {
                    this.curAffixLevelMap_ = this.curAffixLevelMap_.copy();
                }
                return this.curAffixLevelMap_;
            }

            @Override // emu.grasscutter.net.proto.WeaponAwakenRspOuterClass.WeaponAwakenRspOrBuilder
            public int getCurAffixLevelMapCount() {
                return internalGetCurAffixLevelMap().getMap().size();
            }

            @Override // emu.grasscutter.net.proto.WeaponAwakenRspOuterClass.WeaponAwakenRspOrBuilder
            public boolean containsCurAffixLevelMap(int key) {
                return internalGetCurAffixLevelMap().getMap().containsKey(Integer.valueOf(key));
            }

            @Override // emu.grasscutter.net.proto.WeaponAwakenRspOuterClass.WeaponAwakenRspOrBuilder
            @Deprecated
            public Map<Integer, Integer> getCurAffixLevelMap() {
                return getCurAffixLevelMapMap();
            }

            @Override // emu.grasscutter.net.proto.WeaponAwakenRspOuterClass.WeaponAwakenRspOrBuilder
            public Map<Integer, Integer> getCurAffixLevelMapMap() {
                return internalGetCurAffixLevelMap().getMap();
            }

            @Override // emu.grasscutter.net.proto.WeaponAwakenRspOuterClass.WeaponAwakenRspOrBuilder
            public int getCurAffixLevelMapOrDefault(int key, int defaultValue) {
                Map<Integer, Integer> map = internalGetCurAffixLevelMap().getMap();
                return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)).intValue() : defaultValue;
            }

            @Override // emu.grasscutter.net.proto.WeaponAwakenRspOuterClass.WeaponAwakenRspOrBuilder
            public int getCurAffixLevelMapOrThrow(int key) {
                Map<Integer, Integer> map = internalGetCurAffixLevelMap().getMap();
                if (map.containsKey(Integer.valueOf(key))) {
                    return map.get(Integer.valueOf(key)).intValue();
                }
                throw new IllegalArgumentException();
            }

            public Builder clearCurAffixLevelMap() {
                internalGetMutableCurAffixLevelMap().getMutableMap().clear();
                return this;
            }

            public Builder removeCurAffixLevelMap(int key) {
                internalGetMutableCurAffixLevelMap().getMutableMap().remove(Integer.valueOf(key));
                return this;
            }

            @Deprecated
            public Map<Integer, Integer> getMutableCurAffixLevelMap() {
                return internalGetMutableCurAffixLevelMap().getMutableMap();
            }

            public Builder putCurAffixLevelMap(int key, int value) {
                internalGetMutableCurAffixLevelMap().getMutableMap().put(Integer.valueOf(key), Integer.valueOf(value));
                return this;
            }

            public Builder putAllCurAffixLevelMap(Map<Integer, Integer> values) {
                internalGetMutableCurAffixLevelMap().getMutableMap().putAll(values);
                return this;
            }

            @Override // emu.grasscutter.net.proto.WeaponAwakenRspOuterClass.WeaponAwakenRspOrBuilder
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

            @Override // emu.grasscutter.net.proto.WeaponAwakenRspOuterClass.WeaponAwakenRspOrBuilder
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

            @Override // emu.grasscutter.net.proto.WeaponAwakenRspOuterClass.WeaponAwakenRspOrBuilder
            public long getTargetWeaponGuid() {
                return this.targetWeaponGuid_;
            }

            public Builder setTargetWeaponGuid(long value) {
                this.targetWeaponGuid_ = value;
                onChanged();
                return this;
            }

            public Builder clearTargetWeaponGuid() {
                this.targetWeaponGuid_ = 0;
                onChanged();
                return this;
            }

            private MapField<Integer, Integer> internalGetOldAffixLevelMap() {
                if (this.oldAffixLevelMap_ == null) {
                    return MapField.emptyMapField(OldAffixLevelMapDefaultEntryHolder.defaultEntry);
                }
                return this.oldAffixLevelMap_;
            }

            private MapField<Integer, Integer> internalGetMutableOldAffixLevelMap() {
                onChanged();
                if (this.oldAffixLevelMap_ == null) {
                    this.oldAffixLevelMap_ = MapField.newMapField(OldAffixLevelMapDefaultEntryHolder.defaultEntry);
                }
                if (!this.oldAffixLevelMap_.isMutable()) {
                    this.oldAffixLevelMap_ = this.oldAffixLevelMap_.copy();
                }
                return this.oldAffixLevelMap_;
            }

            @Override // emu.grasscutter.net.proto.WeaponAwakenRspOuterClass.WeaponAwakenRspOrBuilder
            public int getOldAffixLevelMapCount() {
                return internalGetOldAffixLevelMap().getMap().size();
            }

            @Override // emu.grasscutter.net.proto.WeaponAwakenRspOuterClass.WeaponAwakenRspOrBuilder
            public boolean containsOldAffixLevelMap(int key) {
                return internalGetOldAffixLevelMap().getMap().containsKey(Integer.valueOf(key));
            }

            @Override // emu.grasscutter.net.proto.WeaponAwakenRspOuterClass.WeaponAwakenRspOrBuilder
            @Deprecated
            public Map<Integer, Integer> getOldAffixLevelMap() {
                return getOldAffixLevelMapMap();
            }

            @Override // emu.grasscutter.net.proto.WeaponAwakenRspOuterClass.WeaponAwakenRspOrBuilder
            public Map<Integer, Integer> getOldAffixLevelMapMap() {
                return internalGetOldAffixLevelMap().getMap();
            }

            @Override // emu.grasscutter.net.proto.WeaponAwakenRspOuterClass.WeaponAwakenRspOrBuilder
            public int getOldAffixLevelMapOrDefault(int key, int defaultValue) {
                Map<Integer, Integer> map = internalGetOldAffixLevelMap().getMap();
                return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)).intValue() : defaultValue;
            }

            @Override // emu.grasscutter.net.proto.WeaponAwakenRspOuterClass.WeaponAwakenRspOrBuilder
            public int getOldAffixLevelMapOrThrow(int key) {
                Map<Integer, Integer> map = internalGetOldAffixLevelMap().getMap();
                if (map.containsKey(Integer.valueOf(key))) {
                    return map.get(Integer.valueOf(key)).intValue();
                }
                throw new IllegalArgumentException();
            }

            public Builder clearOldAffixLevelMap() {
                internalGetMutableOldAffixLevelMap().getMutableMap().clear();
                return this;
            }

            public Builder removeOldAffixLevelMap(int key) {
                internalGetMutableOldAffixLevelMap().getMutableMap().remove(Integer.valueOf(key));
                return this;
            }

            @Deprecated
            public Map<Integer, Integer> getMutableOldAffixLevelMap() {
                return internalGetMutableOldAffixLevelMap().getMutableMap();
            }

            public Builder putOldAffixLevelMap(int key, int value) {
                internalGetMutableOldAffixLevelMap().getMutableMap().put(Integer.valueOf(key), Integer.valueOf(value));
                return this;
            }

            public Builder putAllOldAffixLevelMap(Map<Integer, Integer> values) {
                internalGetMutableOldAffixLevelMap().getMutableMap().putAll(values);
                return this;
            }

            @Override // emu.grasscutter.net.proto.WeaponAwakenRspOuterClass.WeaponAwakenRspOrBuilder
            public int getTargetWeaponAwakenLevel() {
                return this.targetWeaponAwakenLevel_;
            }

            public Builder setTargetWeaponAwakenLevel(int value) {
                this.targetWeaponAwakenLevel_ = value;
                onChanged();
                return this;
            }

            public Builder clearTargetWeaponAwakenLevel() {
                this.targetWeaponAwakenLevel_ = 0;
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

        public static WeaponAwakenRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<WeaponAwakenRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<WeaponAwakenRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public WeaponAwakenRsp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
