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
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.WireFormat;
import emu.grasscutter.net.proto.AbilitySyncStateInfoOuterClass;
import emu.grasscutter.net.proto.EntityRendererChangedInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Map;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SceneWeaponInfoOuterClass.class */
public final class SceneWeaponInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0015SceneWeaponInfo.proto\u001a\u001aAbilitySyncStateInfo.proto\u001a\u001fEntityRendererChangedInfo.proto\"À\u0002\n\u000fSceneWeaponInfo\u0012\u0010\n\bentityId\u0018\u0001 \u0001(\r\u0012\u0010\n\bgadgetId\u0018\u0002 \u0001(\r\u0012\u000e\n\u0006itemId\u0018\u0003 \u0001(\r\u0012\f\n\u0004guid\u0018\u0004 \u0001(\u0004\u0012\r\n\u0005level\u0018\u0005 \u0001(\r\u0012\u0014\n\fpromoteLevel\u0018\u0006 \u0001(\r\u0012*\n\u000babilityInfo\u0018\u0007 \u0001(\u000b2\u0015.AbilitySyncStateInfo\u00120\n\baffixMap\u0018\b \u0003(\u000b2\u001e.SceneWeaponInfo.AffixMapEntry\u00127\n\u0013rendererChangedInfo\u0018\t \u0001(\u000b2\u001a.EntityRendererChangedInfo\u001a/\n\rAffixMapEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\r\u0012\r\n\u0005value\u0018\u0002 \u0001(\r:\u00028\u0001B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{AbilitySyncStateInfoOuterClass.getDescriptor(), EntityRendererChangedInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_SceneWeaponInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_SceneWeaponInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_SceneWeaponInfo_descriptor, new String[]{"EntityId", "GadgetId", "ItemId", "Guid", "Level", "PromoteLevel", "AbilityInfo", "AffixMap", "RendererChangedInfo"});
    private static final Descriptors.Descriptor internal_static_SceneWeaponInfo_AffixMapEntry_descriptor = internal_static_SceneWeaponInfo_descriptor.getNestedTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_SceneWeaponInfo_AffixMapEntry_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_SceneWeaponInfo_AffixMapEntry_descriptor, new String[]{"Key", "Value"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SceneWeaponInfoOuterClass$SceneWeaponInfoOrBuilder.class */
    public interface SceneWeaponInfoOrBuilder extends MessageOrBuilder {
        int getEntityId();

        int getGadgetId();

        int getItemId();

        long getGuid();

        int getLevel();

        int getPromoteLevel();

        boolean hasAbilityInfo();

        AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo getAbilityInfo();

        AbilitySyncStateInfoOuterClass.AbilitySyncStateInfoOrBuilder getAbilityInfoOrBuilder();

        int getAffixMapCount();

        boolean containsAffixMap(int i);

        @Deprecated
        Map<Integer, Integer> getAffixMap();

        Map<Integer, Integer> getAffixMapMap();

        int getAffixMapOrDefault(int i, int i2);

        int getAffixMapOrThrow(int i);

        boolean hasRendererChangedInfo();

        EntityRendererChangedInfoOuterClass.EntityRendererChangedInfo getRendererChangedInfo();

        EntityRendererChangedInfoOuterClass.EntityRendererChangedInfoOrBuilder getRendererChangedInfoOrBuilder();
    }

    private SceneWeaponInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SceneWeaponInfoOuterClass$SceneWeaponInfo.class */
    public static final class SceneWeaponInfo extends GeneratedMessageV3 implements SceneWeaponInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int ENTITYID_FIELD_NUMBER = 1;
        private int entityId_;
        public static final int GADGETID_FIELD_NUMBER = 2;
        private int gadgetId_;
        public static final int ITEMID_FIELD_NUMBER = 3;
        private int itemId_;
        public static final int GUID_FIELD_NUMBER = 4;
        private long guid_;
        public static final int LEVEL_FIELD_NUMBER = 5;
        private int level_;
        public static final int PROMOTELEVEL_FIELD_NUMBER = 6;
        private int promoteLevel_;
        public static final int ABILITYINFO_FIELD_NUMBER = 7;
        private AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo abilityInfo_;
        public static final int AFFIXMAP_FIELD_NUMBER = 8;
        private MapField<Integer, Integer> affixMap_;
        public static final int RENDERERCHANGEDINFO_FIELD_NUMBER = 9;
        private EntityRendererChangedInfoOuterClass.EntityRendererChangedInfo rendererChangedInfo_;
        private byte memoizedIsInitialized;
        private static final SceneWeaponInfo DEFAULT_INSTANCE = new SceneWeaponInfo();
        private static final Parser<SceneWeaponInfo> PARSER = new AbstractParser<SceneWeaponInfo>() { // from class: emu.grasscutter.net.proto.SceneWeaponInfoOuterClass.SceneWeaponInfo.1
            @Override // com.google.protobuf.Parser
            public SceneWeaponInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new SceneWeaponInfo(input, extensionRegistry);
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
        /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.SceneWeaponInfoOuterClass.SceneWeaponInfo.internalGetMapField(int):com.google.protobuf.MapField
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
                    case 8: goto L_0x0014;
                    default: goto L_0x0019;
                }
                r0 = r4
                com.google.protobuf.MapField r0 = r0.internalGetAffixMap()
                return r0
                java.lang.RuntimeException r0 = new java.lang.RuntimeException
                r1 = r0
                r2 = r5
                // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                r1.<init>(r2)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.SceneWeaponInfoOuterClass.SceneWeaponInfo.internalGetMapField(int):com.google.protobuf.MapField");
        }

        private SceneWeaponInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private SceneWeaponInfo() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new SceneWeaponInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private SceneWeaponInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                        try {
                            int tag = input.readTag();
                            switch (tag) {
                                case 0:
                                    done = true;
                                    break;
                                case 8:
                                    this.entityId_ = input.readUInt32();
                                    break;
                                case 16:
                                    this.gadgetId_ = input.readUInt32();
                                    break;
                                case 24:
                                    this.itemId_ = input.readUInt32();
                                    break;
                                case 32:
                                    this.guid_ = input.readUInt64();
                                    break;
                                case 40:
                                    this.level_ = input.readUInt32();
                                    break;
                                case 48:
                                    this.promoteLevel_ = input.readUInt32();
                                    break;
                                case 58:
                                    AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo.Builder subBuilder = this.abilityInfo_ != null ? this.abilityInfo_.toBuilder() : null;
                                    this.abilityInfo_ = (AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo) input.readMessage(AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo.parser(), extensionRegistry);
                                    if (subBuilder == null) {
                                        break;
                                    } else {
                                        subBuilder.mergeFrom(this.abilityInfo_);
                                        this.abilityInfo_ = subBuilder.buildPartial();
                                        break;
                                    }
                                case 66:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.affixMap_ = MapField.newMapField(AffixMapDefaultEntryHolder.defaultEntry);
                                        mutable_bitField0_ |= 1;
                                    }
                                    MapEntry<Integer, Integer> affixMap__ = (MapEntry) input.readMessage(AffixMapDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
                                    this.affixMap_.getMutableMap().put(affixMap__.getKey(), affixMap__.getValue());
                                    break;
                                case 74:
                                    EntityRendererChangedInfoOuterClass.EntityRendererChangedInfo.Builder subBuilder2 = this.rendererChangedInfo_ != null ? this.rendererChangedInfo_.toBuilder() : null;
                                    this.rendererChangedInfo_ = (EntityRendererChangedInfoOuterClass.EntityRendererChangedInfo) input.readMessage(EntityRendererChangedInfoOuterClass.EntityRendererChangedInfo.parser(), extensionRegistry);
                                    if (subBuilder2 == null) {
                                        break;
                                    } else {
                                        subBuilder2.mergeFrom(this.rendererChangedInfo_);
                                        this.rendererChangedInfo_ = subBuilder2.buildPartial();
                                        break;
                                    }
                                default:
                                    if (parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                                        break;
                                    } else {
                                        done = true;
                                        break;
                                    }
                            }
                        } catch (IOException e) {
                            throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
                        }
                    } catch (InvalidProtocolBufferException e2) {
                        throw e2.setUnfinishedMessage(this);
                    }
                }
            } finally {
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return SceneWeaponInfoOuterClass.internal_static_SceneWeaponInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return SceneWeaponInfoOuterClass.internal_static_SceneWeaponInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(SceneWeaponInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.SceneWeaponInfoOuterClass.SceneWeaponInfoOrBuilder
        public int getEntityId() {
            return this.entityId_;
        }

        @Override // emu.grasscutter.net.proto.SceneWeaponInfoOuterClass.SceneWeaponInfoOrBuilder
        public int getGadgetId() {
            return this.gadgetId_;
        }

        @Override // emu.grasscutter.net.proto.SceneWeaponInfoOuterClass.SceneWeaponInfoOrBuilder
        public int getItemId() {
            return this.itemId_;
        }

        @Override // emu.grasscutter.net.proto.SceneWeaponInfoOuterClass.SceneWeaponInfoOrBuilder
        public long getGuid() {
            return this.guid_;
        }

        @Override // emu.grasscutter.net.proto.SceneWeaponInfoOuterClass.SceneWeaponInfoOrBuilder
        public int getLevel() {
            return this.level_;
        }

        @Override // emu.grasscutter.net.proto.SceneWeaponInfoOuterClass.SceneWeaponInfoOrBuilder
        public int getPromoteLevel() {
            return this.promoteLevel_;
        }

        @Override // emu.grasscutter.net.proto.SceneWeaponInfoOuterClass.SceneWeaponInfoOrBuilder
        public boolean hasAbilityInfo() {
            return this.abilityInfo_ != null;
        }

        @Override // emu.grasscutter.net.proto.SceneWeaponInfoOuterClass.SceneWeaponInfoOrBuilder
        public AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo getAbilityInfo() {
            return this.abilityInfo_ == null ? AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo.getDefaultInstance() : this.abilityInfo_;
        }

        @Override // emu.grasscutter.net.proto.SceneWeaponInfoOuterClass.SceneWeaponInfoOrBuilder
        public AbilitySyncStateInfoOuterClass.AbilitySyncStateInfoOrBuilder getAbilityInfoOrBuilder() {
            return getAbilityInfo();
        }

        /* access modifiers changed from: private */
        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SceneWeaponInfoOuterClass$SceneWeaponInfo$AffixMapDefaultEntryHolder.class */
        public static final class AffixMapDefaultEntryHolder {
            static final MapEntry<Integer, Integer> defaultEntry = MapEntry.newDefaultInstance(SceneWeaponInfoOuterClass.internal_static_SceneWeaponInfo_AffixMapEntry_descriptor, WireFormat.FieldType.UINT32, 0, WireFormat.FieldType.UINT32, 0);

            private AffixMapDefaultEntryHolder() {
            }
        }

        private MapField<Integer, Integer> internalGetAffixMap() {
            if (this.affixMap_ == null) {
                return MapField.emptyMapField(AffixMapDefaultEntryHolder.defaultEntry);
            }
            return this.affixMap_;
        }

        @Override // emu.grasscutter.net.proto.SceneWeaponInfoOuterClass.SceneWeaponInfoOrBuilder
        public int getAffixMapCount() {
            return internalGetAffixMap().getMap().size();
        }

        @Override // emu.grasscutter.net.proto.SceneWeaponInfoOuterClass.SceneWeaponInfoOrBuilder
        public boolean containsAffixMap(int key) {
            return internalGetAffixMap().getMap().containsKey(Integer.valueOf(key));
        }

        @Override // emu.grasscutter.net.proto.SceneWeaponInfoOuterClass.SceneWeaponInfoOrBuilder
        @Deprecated
        public Map<Integer, Integer> getAffixMap() {
            return getAffixMapMap();
        }

        @Override // emu.grasscutter.net.proto.SceneWeaponInfoOuterClass.SceneWeaponInfoOrBuilder
        public Map<Integer, Integer> getAffixMapMap() {
            return internalGetAffixMap().getMap();
        }

        @Override // emu.grasscutter.net.proto.SceneWeaponInfoOuterClass.SceneWeaponInfoOrBuilder
        public int getAffixMapOrDefault(int key, int defaultValue) {
            Map<Integer, Integer> map = internalGetAffixMap().getMap();
            return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)).intValue() : defaultValue;
        }

        @Override // emu.grasscutter.net.proto.SceneWeaponInfoOuterClass.SceneWeaponInfoOrBuilder
        public int getAffixMapOrThrow(int key) {
            Map<Integer, Integer> map = internalGetAffixMap().getMap();
            if (map.containsKey(Integer.valueOf(key))) {
                return map.get(Integer.valueOf(key)).intValue();
            }
            throw new IllegalArgumentException();
        }

        @Override // emu.grasscutter.net.proto.SceneWeaponInfoOuterClass.SceneWeaponInfoOrBuilder
        public boolean hasRendererChangedInfo() {
            return this.rendererChangedInfo_ != null;
        }

        @Override // emu.grasscutter.net.proto.SceneWeaponInfoOuterClass.SceneWeaponInfoOrBuilder
        public EntityRendererChangedInfoOuterClass.EntityRendererChangedInfo getRendererChangedInfo() {
            return this.rendererChangedInfo_ == null ? EntityRendererChangedInfoOuterClass.EntityRendererChangedInfo.getDefaultInstance() : this.rendererChangedInfo_;
        }

        @Override // emu.grasscutter.net.proto.SceneWeaponInfoOuterClass.SceneWeaponInfoOrBuilder
        public EntityRendererChangedInfoOuterClass.EntityRendererChangedInfoOrBuilder getRendererChangedInfoOrBuilder() {
            return getRendererChangedInfo();
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
            if (this.entityId_ != 0) {
                output.writeUInt32(1, this.entityId_);
            }
            if (this.gadgetId_ != 0) {
                output.writeUInt32(2, this.gadgetId_);
            }
            if (this.itemId_ != 0) {
                output.writeUInt32(3, this.itemId_);
            }
            if (this.guid_ != 0) {
                output.writeUInt64(4, this.guid_);
            }
            if (this.level_ != 0) {
                output.writeUInt32(5, this.level_);
            }
            if (this.promoteLevel_ != 0) {
                output.writeUInt32(6, this.promoteLevel_);
            }
            if (this.abilityInfo_ != null) {
                output.writeMessage(7, getAbilityInfo());
            }
            GeneratedMessageV3.serializeIntegerMapTo(output, internalGetAffixMap(), AffixMapDefaultEntryHolder.defaultEntry, 8);
            if (this.rendererChangedInfo_ != null) {
                output.writeMessage(9, getRendererChangedInfo());
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
            if (this.entityId_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.entityId_);
            }
            if (this.gadgetId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(2, this.gadgetId_);
            }
            if (this.itemId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(3, this.itemId_);
            }
            if (this.guid_ != 0) {
                size2 += CodedOutputStream.computeUInt64Size(4, this.guid_);
            }
            if (this.level_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(5, this.level_);
            }
            if (this.promoteLevel_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(6, this.promoteLevel_);
            }
            if (this.abilityInfo_ != null) {
                size2 += CodedOutputStream.computeMessageSize(7, getAbilityInfo());
            }
            for (Map.Entry<Integer, Integer> entry : internalGetAffixMap().getMap().entrySet()) {
                size2 += CodedOutputStream.computeMessageSize(8, AffixMapDefaultEntryHolder.defaultEntry.newBuilderForType().setKey(entry.getKey()).setValue(entry.getValue()).build());
            }
            if (this.rendererChangedInfo_ != null) {
                size2 += CodedOutputStream.computeMessageSize(9, getRendererChangedInfo());
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
            if (!(obj instanceof SceneWeaponInfo)) {
                return equals(obj);
            }
            SceneWeaponInfo other = (SceneWeaponInfo) obj;
            if (getEntityId() != other.getEntityId() || getGadgetId() != other.getGadgetId() || getItemId() != other.getItemId() || getGuid() != other.getGuid() || getLevel() != other.getLevel() || getPromoteLevel() != other.getPromoteLevel() || hasAbilityInfo() != other.hasAbilityInfo()) {
                return false;
            }
            if ((!hasAbilityInfo() || getAbilityInfo().equals(other.getAbilityInfo())) && internalGetAffixMap().equals(other.internalGetAffixMap()) && hasRendererChangedInfo() == other.hasRendererChangedInfo()) {
                return (!hasRendererChangedInfo() || getRendererChangedInfo().equals(other.getRendererChangedInfo())) && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + getEntityId())) + 2)) + getGadgetId())) + 3)) + getItemId())) + 4)) + Internal.hashLong(getGuid()))) + 5)) + getLevel())) + 6)) + getPromoteLevel();
            if (hasAbilityInfo()) {
                hash = (53 * ((37 * hash) + 7)) + getAbilityInfo().hashCode();
            }
            if (!internalGetAffixMap().getMap().isEmpty()) {
                hash = (53 * ((37 * hash) + 8)) + internalGetAffixMap().hashCode();
            }
            if (hasRendererChangedInfo()) {
                hash = (53 * ((37 * hash) + 9)) + getRendererChangedInfo().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static SceneWeaponInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SceneWeaponInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SceneWeaponInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SceneWeaponInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SceneWeaponInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SceneWeaponInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SceneWeaponInfo parseFrom(InputStream input) throws IOException {
            return (SceneWeaponInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SceneWeaponInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SceneWeaponInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static SceneWeaponInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (SceneWeaponInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static SceneWeaponInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SceneWeaponInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static SceneWeaponInfo parseFrom(CodedInputStream input) throws IOException {
            return (SceneWeaponInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SceneWeaponInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SceneWeaponInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(SceneWeaponInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SceneWeaponInfoOuterClass$SceneWeaponInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements SceneWeaponInfoOrBuilder {
            private int bitField0_;
            private int entityId_;
            private int gadgetId_;
            private int itemId_;
            private long guid_;
            private int level_;
            private int promoteLevel_;
            private AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo abilityInfo_;
            private SingleFieldBuilderV3<AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo, AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo.Builder, AbilitySyncStateInfoOuterClass.AbilitySyncStateInfoOrBuilder> abilityInfoBuilder_;
            private MapField<Integer, Integer> affixMap_;
            private EntityRendererChangedInfoOuterClass.EntityRendererChangedInfo rendererChangedInfo_;
            private SingleFieldBuilderV3<EntityRendererChangedInfoOuterClass.EntityRendererChangedInfo, EntityRendererChangedInfoOuterClass.EntityRendererChangedInfo.Builder, EntityRendererChangedInfoOuterClass.EntityRendererChangedInfoOrBuilder> rendererChangedInfoBuilder_;

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
            /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.SceneWeaponInfoOuterClass.SceneWeaponInfo.Builder.internalGetMapField(int):com.google.protobuf.MapField
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
                        case 8: goto L_0x0014;
                        default: goto L_0x0019;
                    }
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetAffixMap()
                    return r0
                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                    r1 = r0
                    r2 = r5
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    r1.<init>(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.SceneWeaponInfoOuterClass.SceneWeaponInfo.Builder.internalGetMapField(int):com.google.protobuf.MapField");
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
            /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.SceneWeaponInfoOuterClass.SceneWeaponInfo.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField
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
                        case 8: goto L_0x0014;
                        default: goto L_0x0019;
                    }
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetMutableAffixMap()
                    return r0
                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                    r1 = r0
                    r2 = r5
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    r1.<init>(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.SceneWeaponInfoOuterClass.SceneWeaponInfo.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField");
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return SceneWeaponInfoOuterClass.internal_static_SceneWeaponInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return SceneWeaponInfoOuterClass.internal_static_SceneWeaponInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(SceneWeaponInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (SceneWeaponInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.entityId_ = 0;
                this.gadgetId_ = 0;
                this.itemId_ = 0;
                this.guid_ = 0;
                this.level_ = 0;
                this.promoteLevel_ = 0;
                if (this.abilityInfoBuilder_ == null) {
                    this.abilityInfo_ = null;
                } else {
                    this.abilityInfo_ = null;
                    this.abilityInfoBuilder_ = null;
                }
                internalGetMutableAffixMap().clear();
                if (this.rendererChangedInfoBuilder_ == null) {
                    this.rendererChangedInfo_ = null;
                } else {
                    this.rendererChangedInfo_ = null;
                    this.rendererChangedInfoBuilder_ = null;
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return SceneWeaponInfoOuterClass.internal_static_SceneWeaponInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public SceneWeaponInfo getDefaultInstanceForType() {
                return SceneWeaponInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SceneWeaponInfo build() {
                SceneWeaponInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SceneWeaponInfo buildPartial() {
                SceneWeaponInfo result = new SceneWeaponInfo(this);
                int i = this.bitField0_;
                result.entityId_ = this.entityId_;
                result.gadgetId_ = this.gadgetId_;
                result.itemId_ = this.itemId_;
                result.guid_ = this.guid_;
                result.level_ = this.level_;
                result.promoteLevel_ = this.promoteLevel_;
                if (this.abilityInfoBuilder_ == null) {
                    result.abilityInfo_ = this.abilityInfo_;
                } else {
                    result.abilityInfo_ = this.abilityInfoBuilder_.build();
                }
                result.affixMap_ = internalGetAffixMap();
                result.affixMap_.makeImmutable();
                if (this.rendererChangedInfoBuilder_ == null) {
                    result.rendererChangedInfo_ = this.rendererChangedInfo_;
                } else {
                    result.rendererChangedInfo_ = this.rendererChangedInfoBuilder_.build();
                }
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
                if (other instanceof SceneWeaponInfo) {
                    return mergeFrom((SceneWeaponInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(SceneWeaponInfo other) {
                if (other == SceneWeaponInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getEntityId() != 0) {
                    setEntityId(other.getEntityId());
                }
                if (other.getGadgetId() != 0) {
                    setGadgetId(other.getGadgetId());
                }
                if (other.getItemId() != 0) {
                    setItemId(other.getItemId());
                }
                if (other.getGuid() != 0) {
                    setGuid(other.getGuid());
                }
                if (other.getLevel() != 0) {
                    setLevel(other.getLevel());
                }
                if (other.getPromoteLevel() != 0) {
                    setPromoteLevel(other.getPromoteLevel());
                }
                if (other.hasAbilityInfo()) {
                    mergeAbilityInfo(other.getAbilityInfo());
                }
                internalGetMutableAffixMap().mergeFrom(other.internalGetAffixMap());
                if (other.hasRendererChangedInfo()) {
                    mergeRendererChangedInfo(other.getRendererChangedInfo());
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
                SceneWeaponInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = SceneWeaponInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (SceneWeaponInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.SceneWeaponInfoOuterClass.SceneWeaponInfoOrBuilder
            public int getEntityId() {
                return this.entityId_;
            }

            public Builder setEntityId(int value) {
                this.entityId_ = value;
                onChanged();
                return this;
            }

            public Builder clearEntityId() {
                this.entityId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SceneWeaponInfoOuterClass.SceneWeaponInfoOrBuilder
            public int getGadgetId() {
                return this.gadgetId_;
            }

            public Builder setGadgetId(int value) {
                this.gadgetId_ = value;
                onChanged();
                return this;
            }

            public Builder clearGadgetId() {
                this.gadgetId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SceneWeaponInfoOuterClass.SceneWeaponInfoOrBuilder
            public int getItemId() {
                return this.itemId_;
            }

            public Builder setItemId(int value) {
                this.itemId_ = value;
                onChanged();
                return this;
            }

            public Builder clearItemId() {
                this.itemId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SceneWeaponInfoOuterClass.SceneWeaponInfoOrBuilder
            public long getGuid() {
                return this.guid_;
            }

            public Builder setGuid(long value) {
                this.guid_ = value;
                onChanged();
                return this;
            }

            public Builder clearGuid() {
                this.guid_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SceneWeaponInfoOuterClass.SceneWeaponInfoOrBuilder
            public int getLevel() {
                return this.level_;
            }

            public Builder setLevel(int value) {
                this.level_ = value;
                onChanged();
                return this;
            }

            public Builder clearLevel() {
                this.level_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SceneWeaponInfoOuterClass.SceneWeaponInfoOrBuilder
            public int getPromoteLevel() {
                return this.promoteLevel_;
            }

            public Builder setPromoteLevel(int value) {
                this.promoteLevel_ = value;
                onChanged();
                return this;
            }

            public Builder clearPromoteLevel() {
                this.promoteLevel_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SceneWeaponInfoOuterClass.SceneWeaponInfoOrBuilder
            public boolean hasAbilityInfo() {
                return (this.abilityInfoBuilder_ == null && this.abilityInfo_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.SceneWeaponInfoOuterClass.SceneWeaponInfoOrBuilder
            public AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo getAbilityInfo() {
                if (this.abilityInfoBuilder_ == null) {
                    return this.abilityInfo_ == null ? AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo.getDefaultInstance() : this.abilityInfo_;
                }
                return this.abilityInfoBuilder_.getMessage();
            }

            public Builder setAbilityInfo(AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo value) {
                if (this.abilityInfoBuilder_ != null) {
                    this.abilityInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.abilityInfo_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setAbilityInfo(AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo.Builder builderForValue) {
                if (this.abilityInfoBuilder_ == null) {
                    this.abilityInfo_ = builderForValue.build();
                    onChanged();
                } else {
                    this.abilityInfoBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeAbilityInfo(AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo value) {
                if (this.abilityInfoBuilder_ == null) {
                    if (this.abilityInfo_ != null) {
                        this.abilityInfo_ = AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo.newBuilder(this.abilityInfo_).mergeFrom(value).buildPartial();
                    } else {
                        this.abilityInfo_ = value;
                    }
                    onChanged();
                } else {
                    this.abilityInfoBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearAbilityInfo() {
                if (this.abilityInfoBuilder_ == null) {
                    this.abilityInfo_ = null;
                    onChanged();
                } else {
                    this.abilityInfo_ = null;
                    this.abilityInfoBuilder_ = null;
                }
                return this;
            }

            public AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo.Builder getAbilityInfoBuilder() {
                onChanged();
                return getAbilityInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.SceneWeaponInfoOuterClass.SceneWeaponInfoOrBuilder
            public AbilitySyncStateInfoOuterClass.AbilitySyncStateInfoOrBuilder getAbilityInfoOrBuilder() {
                if (this.abilityInfoBuilder_ != null) {
                    return this.abilityInfoBuilder_.getMessageOrBuilder();
                }
                return this.abilityInfo_ == null ? AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo.getDefaultInstance() : this.abilityInfo_;
            }

            private SingleFieldBuilderV3<AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo, AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo.Builder, AbilitySyncStateInfoOuterClass.AbilitySyncStateInfoOrBuilder> getAbilityInfoFieldBuilder() {
                if (this.abilityInfoBuilder_ == null) {
                    this.abilityInfoBuilder_ = new SingleFieldBuilderV3<>(getAbilityInfo(), getParentForChildren(), isClean());
                    this.abilityInfo_ = null;
                }
                return this.abilityInfoBuilder_;
            }

            private MapField<Integer, Integer> internalGetAffixMap() {
                if (this.affixMap_ == null) {
                    return MapField.emptyMapField(AffixMapDefaultEntryHolder.defaultEntry);
                }
                return this.affixMap_;
            }

            private MapField<Integer, Integer> internalGetMutableAffixMap() {
                onChanged();
                if (this.affixMap_ == null) {
                    this.affixMap_ = MapField.newMapField(AffixMapDefaultEntryHolder.defaultEntry);
                }
                if (!this.affixMap_.isMutable()) {
                    this.affixMap_ = this.affixMap_.copy();
                }
                return this.affixMap_;
            }

            @Override // emu.grasscutter.net.proto.SceneWeaponInfoOuterClass.SceneWeaponInfoOrBuilder
            public int getAffixMapCount() {
                return internalGetAffixMap().getMap().size();
            }

            @Override // emu.grasscutter.net.proto.SceneWeaponInfoOuterClass.SceneWeaponInfoOrBuilder
            public boolean containsAffixMap(int key) {
                return internalGetAffixMap().getMap().containsKey(Integer.valueOf(key));
            }

            @Override // emu.grasscutter.net.proto.SceneWeaponInfoOuterClass.SceneWeaponInfoOrBuilder
            @Deprecated
            public Map<Integer, Integer> getAffixMap() {
                return getAffixMapMap();
            }

            @Override // emu.grasscutter.net.proto.SceneWeaponInfoOuterClass.SceneWeaponInfoOrBuilder
            public Map<Integer, Integer> getAffixMapMap() {
                return internalGetAffixMap().getMap();
            }

            @Override // emu.grasscutter.net.proto.SceneWeaponInfoOuterClass.SceneWeaponInfoOrBuilder
            public int getAffixMapOrDefault(int key, int defaultValue) {
                Map<Integer, Integer> map = internalGetAffixMap().getMap();
                return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)).intValue() : defaultValue;
            }

            @Override // emu.grasscutter.net.proto.SceneWeaponInfoOuterClass.SceneWeaponInfoOrBuilder
            public int getAffixMapOrThrow(int key) {
                Map<Integer, Integer> map = internalGetAffixMap().getMap();
                if (map.containsKey(Integer.valueOf(key))) {
                    return map.get(Integer.valueOf(key)).intValue();
                }
                throw new IllegalArgumentException();
            }

            public Builder clearAffixMap() {
                internalGetMutableAffixMap().getMutableMap().clear();
                return this;
            }

            public Builder removeAffixMap(int key) {
                internalGetMutableAffixMap().getMutableMap().remove(Integer.valueOf(key));
                return this;
            }

            @Deprecated
            public Map<Integer, Integer> getMutableAffixMap() {
                return internalGetMutableAffixMap().getMutableMap();
            }

            public Builder putAffixMap(int key, int value) {
                internalGetMutableAffixMap().getMutableMap().put(Integer.valueOf(key), Integer.valueOf(value));
                return this;
            }

            public Builder putAllAffixMap(Map<Integer, Integer> values) {
                internalGetMutableAffixMap().getMutableMap().putAll(values);
                return this;
            }

            @Override // emu.grasscutter.net.proto.SceneWeaponInfoOuterClass.SceneWeaponInfoOrBuilder
            public boolean hasRendererChangedInfo() {
                return (this.rendererChangedInfoBuilder_ == null && this.rendererChangedInfo_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.SceneWeaponInfoOuterClass.SceneWeaponInfoOrBuilder
            public EntityRendererChangedInfoOuterClass.EntityRendererChangedInfo getRendererChangedInfo() {
                if (this.rendererChangedInfoBuilder_ == null) {
                    return this.rendererChangedInfo_ == null ? EntityRendererChangedInfoOuterClass.EntityRendererChangedInfo.getDefaultInstance() : this.rendererChangedInfo_;
                }
                return this.rendererChangedInfoBuilder_.getMessage();
            }

            public Builder setRendererChangedInfo(EntityRendererChangedInfoOuterClass.EntityRendererChangedInfo value) {
                if (this.rendererChangedInfoBuilder_ != null) {
                    this.rendererChangedInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.rendererChangedInfo_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setRendererChangedInfo(EntityRendererChangedInfoOuterClass.EntityRendererChangedInfo.Builder builderForValue) {
                if (this.rendererChangedInfoBuilder_ == null) {
                    this.rendererChangedInfo_ = builderForValue.build();
                    onChanged();
                } else {
                    this.rendererChangedInfoBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeRendererChangedInfo(EntityRendererChangedInfoOuterClass.EntityRendererChangedInfo value) {
                if (this.rendererChangedInfoBuilder_ == null) {
                    if (this.rendererChangedInfo_ != null) {
                        this.rendererChangedInfo_ = EntityRendererChangedInfoOuterClass.EntityRendererChangedInfo.newBuilder(this.rendererChangedInfo_).mergeFrom(value).buildPartial();
                    } else {
                        this.rendererChangedInfo_ = value;
                    }
                    onChanged();
                } else {
                    this.rendererChangedInfoBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearRendererChangedInfo() {
                if (this.rendererChangedInfoBuilder_ == null) {
                    this.rendererChangedInfo_ = null;
                    onChanged();
                } else {
                    this.rendererChangedInfo_ = null;
                    this.rendererChangedInfoBuilder_ = null;
                }
                return this;
            }

            public EntityRendererChangedInfoOuterClass.EntityRendererChangedInfo.Builder getRendererChangedInfoBuilder() {
                onChanged();
                return getRendererChangedInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.SceneWeaponInfoOuterClass.SceneWeaponInfoOrBuilder
            public EntityRendererChangedInfoOuterClass.EntityRendererChangedInfoOrBuilder getRendererChangedInfoOrBuilder() {
                if (this.rendererChangedInfoBuilder_ != null) {
                    return this.rendererChangedInfoBuilder_.getMessageOrBuilder();
                }
                return this.rendererChangedInfo_ == null ? EntityRendererChangedInfoOuterClass.EntityRendererChangedInfo.getDefaultInstance() : this.rendererChangedInfo_;
            }

            private SingleFieldBuilderV3<EntityRendererChangedInfoOuterClass.EntityRendererChangedInfo, EntityRendererChangedInfoOuterClass.EntityRendererChangedInfo.Builder, EntityRendererChangedInfoOuterClass.EntityRendererChangedInfoOrBuilder> getRendererChangedInfoFieldBuilder() {
                if (this.rendererChangedInfoBuilder_ == null) {
                    this.rendererChangedInfoBuilder_ = new SingleFieldBuilderV3<>(getRendererChangedInfo(), getParentForChildren(), isClean());
                    this.rendererChangedInfo_ = null;
                }
                return this.rendererChangedInfoBuilder_;
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

        public static SceneWeaponInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<SceneWeaponInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<SceneWeaponInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public SceneWeaponInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        AbilitySyncStateInfoOuterClass.getDescriptor();
        EntityRendererChangedInfoOuterClass.getDescriptor();
    }
}
