package emu.grasscutter.net.proto;

import com.google.protobuf.AbstractMessageLite;
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
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarSkillDepotChangeNotifyOuterClass.class */
public final class AvatarSkillDepotChangeNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\"AvatarSkillDepotChangeNotify.proto\"Ò\u0003\n\u001cAvatarSkillDepotChangeNotify\u0012_\n\u001bproud_skill_extra_level_map\u0018\t \u0003(\u000b2:.AvatarSkillDepotChangeNotify.ProudSkillExtraLevelMapEntry\u0012\u0018\n\u0010proud_skill_list\u0018\u0003 \u0003(\r\u0012\u0011\n\tentity_id\u0018\u0005 \u0001(\r\u0012\u0013\n\u000bavatar_guid\u0018\u0007 \u0001(\u0004\u0012I\n\u000fskill_level_map\u0018\u0001 \u0003(\u000b20.AvatarSkillDepotChangeNotify.SkillLevelMapEntry\u0012\u0016\n\u000eskill_depot_id\u0018\r \u0001(\r\u0012\u0016\n\u000etalent_id_list\u0018\u000e \u0003(\r\u0012\u001e\n\u0016core_proud_skill_level\u0018\u000f \u0001(\r\u001a>\n\u001cProudSkillExtraLevelMapEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\r\u0012\r\n\u0005value\u0018\u0002 \u0001(\r:\u00028\u0001\u001a4\n\u0012SkillLevelMapEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\r\u0012\r\n\u0005value\u0018\u0002 \u0001(\r:\u00028\u0001B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_AvatarSkillDepotChangeNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_AvatarSkillDepotChangeNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_AvatarSkillDepotChangeNotify_descriptor, new String[]{"ProudSkillExtraLevelMap", "ProudSkillList", "EntityId", "AvatarGuid", "SkillLevelMap", "SkillDepotId", "TalentIdList", "CoreProudSkillLevel"});

    /* renamed from: internal_static_AvatarSkillDepotChangeNotify_ProudSkillExtraLevelMapEntry_descriptor */
    private static final Descriptors.Descriptor f645xe8f6f774 = internal_static_AvatarSkillDepotChangeNotify_descriptor.getNestedTypes().get(0);

    /* renamed from: internal_static_AvatarSkillDepotChangeNotify_ProudSkillExtraLevelMapEntry_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f646xec8169f2 = new GeneratedMessageV3.FieldAccessorTable(f645xe8f6f774, new String[]{"Key", "Value"});

    /* renamed from: internal_static_AvatarSkillDepotChangeNotify_SkillLevelMapEntry_descriptor */
    private static final Descriptors.Descriptor f647x463e62aa = internal_static_AvatarSkillDepotChangeNotify_descriptor.getNestedTypes().get(1);

    /* renamed from: internal_static_AvatarSkillDepotChangeNotify_SkillLevelMapEntry_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f648xf39d3f28 = new GeneratedMessageV3.FieldAccessorTable(f647x463e62aa, new String[]{"Key", "Value"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarSkillDepotChangeNotifyOuterClass$AvatarSkillDepotChangeNotifyOrBuilder.class */
    public interface AvatarSkillDepotChangeNotifyOrBuilder extends MessageOrBuilder {
        int getProudSkillExtraLevelMapCount();

        boolean containsProudSkillExtraLevelMap(int i);

        @Deprecated
        Map<Integer, Integer> getProudSkillExtraLevelMap();

        Map<Integer, Integer> getProudSkillExtraLevelMapMap();

        int getProudSkillExtraLevelMapOrDefault(int i, int i2);

        int getProudSkillExtraLevelMapOrThrow(int i);

        List<Integer> getProudSkillListList();

        int getProudSkillListCount();

        int getProudSkillList(int i);

        int getEntityId();

        long getAvatarGuid();

        int getSkillLevelMapCount();

        boolean containsSkillLevelMap(int i);

        @Deprecated
        Map<Integer, Integer> getSkillLevelMap();

        Map<Integer, Integer> getSkillLevelMapMap();

        int getSkillLevelMapOrDefault(int i, int i2);

        int getSkillLevelMapOrThrow(int i);

        int getSkillDepotId();

        List<Integer> getTalentIdListList();

        int getTalentIdListCount();

        int getTalentIdList(int i);

        int getCoreProudSkillLevel();
    }

    private AvatarSkillDepotChangeNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarSkillDepotChangeNotifyOuterClass$AvatarSkillDepotChangeNotify.class */
    public static final class AvatarSkillDepotChangeNotify extends GeneratedMessageV3 implements AvatarSkillDepotChangeNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int PROUD_SKILL_EXTRA_LEVEL_MAP_FIELD_NUMBER = 9;
        private MapField<Integer, Integer> proudSkillExtraLevelMap_;
        public static final int PROUD_SKILL_LIST_FIELD_NUMBER = 3;
        private Internal.IntList proudSkillList_;
        private int proudSkillListMemoizedSerializedSize;
        public static final int ENTITY_ID_FIELD_NUMBER = 5;
        private int entityId_;
        public static final int AVATAR_GUID_FIELD_NUMBER = 7;
        private long avatarGuid_;
        public static final int SKILL_LEVEL_MAP_FIELD_NUMBER = 1;
        private MapField<Integer, Integer> skillLevelMap_;
        public static final int SKILL_DEPOT_ID_FIELD_NUMBER = 13;
        private int skillDepotId_;
        public static final int TALENT_ID_LIST_FIELD_NUMBER = 14;
        private Internal.IntList talentIdList_;
        private int talentIdListMemoizedSerializedSize;
        public static final int CORE_PROUD_SKILL_LEVEL_FIELD_NUMBER = 15;
        private int coreProudSkillLevel_;
        private byte memoizedIsInitialized;
        private static final AvatarSkillDepotChangeNotify DEFAULT_INSTANCE = new AvatarSkillDepotChangeNotify();
        private static final Parser<AvatarSkillDepotChangeNotify> PARSER = new AbstractParser<AvatarSkillDepotChangeNotify>() { // from class: emu.grasscutter.net.proto.AvatarSkillDepotChangeNotifyOuterClass.AvatarSkillDepotChangeNotify.1
            @Override // com.google.protobuf.Parser
            public AvatarSkillDepotChangeNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new AvatarSkillDepotChangeNotify(input, extensionRegistry);
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
        /*  JADX ERROR: Failed to decode insn: 0x002B: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.AvatarSkillDepotChangeNotifyOuterClass.AvatarSkillDepotChangeNotify.internalGetMapField(int):com.google.protobuf.MapField
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
                    case 1: goto L_0x0021;
                    case 9: goto L_0x001c;
                    default: goto L_0x0026;
                }
                r0 = r4
                com.google.protobuf.MapField r0 = r0.internalGetProudSkillExtraLevelMap()
                return r0
                r0 = r4
                com.google.protobuf.MapField r0 = r0.internalGetSkillLevelMap()
                return r0
                java.lang.RuntimeException r0 = new java.lang.RuntimeException
                r1 = r0
                r2 = r5
                // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                r1.<init>(r2)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.AvatarSkillDepotChangeNotifyOuterClass.AvatarSkillDepotChangeNotify.internalGetMapField(int):com.google.protobuf.MapField");
        }

        private AvatarSkillDepotChangeNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.proudSkillListMemoizedSerializedSize = -1;
            this.talentIdListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private AvatarSkillDepotChangeNotify() {
            this.proudSkillListMemoizedSerializedSize = -1;
            this.talentIdListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.proudSkillList_ = emptyIntList();
            this.talentIdList_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new AvatarSkillDepotChangeNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:96:0x0224 */
        private AvatarSkillDepotChangeNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this();
            int mutable_bitField0_;
            UnknownFieldSet.Builder unknownFields;
            if (extensionRegistry == null) {
                throw new NullPointerException();
            }
            try {
                mutable_bitField0_ = 0;
                unknownFields = UnknownFieldSet.newBuilder();
                boolean done = false;
                while (!done) {
                    try {
                        int tag = input.readTag();
                        switch (tag) {
                            case 0:
                                done = true;
                                break;
                            case 10:
                                if ((mutable_bitField0_ & 4) == 0) {
                                    this.skillLevelMap_ = MapField.newMapField(SkillLevelMapDefaultEntryHolder.defaultEntry);
                                    mutable_bitField0_ = (mutable_bitField0_ | 4) == 1 ? 1 : 0;
                                }
                                MapEntry<Integer, Integer> skillLevelMap__ = (MapEntry) input.readMessage(SkillLevelMapDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
                                this.skillLevelMap_.getMutableMap().put(skillLevelMap__.getKey(), skillLevelMap__.getValue());
                                break;
                            case 24:
                                if ((mutable_bitField0_ & 2) == 0) {
                                    this.proudSkillList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                this.proudSkillList_.addInt(input.readUInt32());
                                break;
                            case 26:
                                int limit = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 2) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.proudSkillList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.proudSkillList_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit);
                                break;
                            case 40:
                                this.entityId_ = input.readUInt32();
                                break;
                            case 56:
                                this.avatarGuid_ = input.readUInt64();
                                break;
                            case 74:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.proudSkillExtraLevelMap_ = MapField.newMapField(ProudSkillExtraLevelMapDefaultEntryHolder.defaultEntry);
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                MapEntry<Integer, Integer> proudSkillExtraLevelMap__ = (MapEntry) input.readMessage(ProudSkillExtraLevelMapDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
                                this.proudSkillExtraLevelMap_.getMutableMap().put(proudSkillExtraLevelMap__.getKey(), proudSkillExtraLevelMap__.getValue());
                                break;
                            case 104:
                                this.skillDepotId_ = input.readUInt32();
                                break;
                            case 112:
                                if ((mutable_bitField0_ & 8) == 0) {
                                    this.talentIdList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 8) == 1 ? 1 : 0;
                                }
                                this.talentIdList_.addInt(input.readUInt32());
                                break;
                            case 114:
                                int limit2 = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 8) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.talentIdList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 8) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.talentIdList_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit2);
                                break;
                            case 120:
                                this.coreProudSkillLevel_ = input.readUInt32();
                                break;
                            default:
                                if (parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                                    break;
                                } else {
                                    done = true;
                                    break;
                                }
                        }
                        done = done;
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(this);
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    }
                }
            } finally {
                if ((mutable_bitField0_ & 2) != 0) {
                    this.proudSkillList_.makeImmutable();
                }
                if ((mutable_bitField0_ & 8) != 0) {
                    this.talentIdList_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return AvatarSkillDepotChangeNotifyOuterClass.internal_static_AvatarSkillDepotChangeNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AvatarSkillDepotChangeNotifyOuterClass.internal_static_AvatarSkillDepotChangeNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(AvatarSkillDepotChangeNotify.class, Builder.class);
        }

        /* access modifiers changed from: private */
        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarSkillDepotChangeNotifyOuterClass$AvatarSkillDepotChangeNotify$ProudSkillExtraLevelMapDefaultEntryHolder.class */
        public static final class ProudSkillExtraLevelMapDefaultEntryHolder {
            static final MapEntry<Integer, Integer> defaultEntry = MapEntry.newDefaultInstance(AvatarSkillDepotChangeNotifyOuterClass.f645xe8f6f774, WireFormat.FieldType.UINT32, 0, WireFormat.FieldType.UINT32, 0);

            private ProudSkillExtraLevelMapDefaultEntryHolder() {
            }
        }

        private MapField<Integer, Integer> internalGetProudSkillExtraLevelMap() {
            if (this.proudSkillExtraLevelMap_ == null) {
                return MapField.emptyMapField(ProudSkillExtraLevelMapDefaultEntryHolder.defaultEntry);
            }
            return this.proudSkillExtraLevelMap_;
        }

        @Override // emu.grasscutter.net.proto.AvatarSkillDepotChangeNotifyOuterClass.AvatarSkillDepotChangeNotifyOrBuilder
        public int getProudSkillExtraLevelMapCount() {
            return internalGetProudSkillExtraLevelMap().getMap().size();
        }

        @Override // emu.grasscutter.net.proto.AvatarSkillDepotChangeNotifyOuterClass.AvatarSkillDepotChangeNotifyOrBuilder
        public boolean containsProudSkillExtraLevelMap(int key) {
            return internalGetProudSkillExtraLevelMap().getMap().containsKey(Integer.valueOf(key));
        }

        @Override // emu.grasscutter.net.proto.AvatarSkillDepotChangeNotifyOuterClass.AvatarSkillDepotChangeNotifyOrBuilder
        @Deprecated
        public Map<Integer, Integer> getProudSkillExtraLevelMap() {
            return getProudSkillExtraLevelMapMap();
        }

        @Override // emu.grasscutter.net.proto.AvatarSkillDepotChangeNotifyOuterClass.AvatarSkillDepotChangeNotifyOrBuilder
        public Map<Integer, Integer> getProudSkillExtraLevelMapMap() {
            return internalGetProudSkillExtraLevelMap().getMap();
        }

        @Override // emu.grasscutter.net.proto.AvatarSkillDepotChangeNotifyOuterClass.AvatarSkillDepotChangeNotifyOrBuilder
        public int getProudSkillExtraLevelMapOrDefault(int key, int defaultValue) {
            Map<Integer, Integer> map = internalGetProudSkillExtraLevelMap().getMap();
            return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)).intValue() : defaultValue;
        }

        @Override // emu.grasscutter.net.proto.AvatarSkillDepotChangeNotifyOuterClass.AvatarSkillDepotChangeNotifyOrBuilder
        public int getProudSkillExtraLevelMapOrThrow(int key) {
            Map<Integer, Integer> map = internalGetProudSkillExtraLevelMap().getMap();
            if (map.containsKey(Integer.valueOf(key))) {
                return map.get(Integer.valueOf(key)).intValue();
            }
            throw new IllegalArgumentException();
        }

        @Override // emu.grasscutter.net.proto.AvatarSkillDepotChangeNotifyOuterClass.AvatarSkillDepotChangeNotifyOrBuilder
        public List<Integer> getProudSkillListList() {
            return this.proudSkillList_;
        }

        @Override // emu.grasscutter.net.proto.AvatarSkillDepotChangeNotifyOuterClass.AvatarSkillDepotChangeNotifyOrBuilder
        public int getProudSkillListCount() {
            return this.proudSkillList_.size();
        }

        @Override // emu.grasscutter.net.proto.AvatarSkillDepotChangeNotifyOuterClass.AvatarSkillDepotChangeNotifyOrBuilder
        public int getProudSkillList(int index) {
            return this.proudSkillList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.AvatarSkillDepotChangeNotifyOuterClass.AvatarSkillDepotChangeNotifyOrBuilder
        public int getEntityId() {
            return this.entityId_;
        }

        @Override // emu.grasscutter.net.proto.AvatarSkillDepotChangeNotifyOuterClass.AvatarSkillDepotChangeNotifyOrBuilder
        public long getAvatarGuid() {
            return this.avatarGuid_;
        }

        /* access modifiers changed from: private */
        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarSkillDepotChangeNotifyOuterClass$AvatarSkillDepotChangeNotify$SkillLevelMapDefaultEntryHolder.class */
        public static final class SkillLevelMapDefaultEntryHolder {
            static final MapEntry<Integer, Integer> defaultEntry = MapEntry.newDefaultInstance(AvatarSkillDepotChangeNotifyOuterClass.f647x463e62aa, WireFormat.FieldType.UINT32, 0, WireFormat.FieldType.UINT32, 0);

            private SkillLevelMapDefaultEntryHolder() {
            }
        }

        private MapField<Integer, Integer> internalGetSkillLevelMap() {
            if (this.skillLevelMap_ == null) {
                return MapField.emptyMapField(SkillLevelMapDefaultEntryHolder.defaultEntry);
            }
            return this.skillLevelMap_;
        }

        @Override // emu.grasscutter.net.proto.AvatarSkillDepotChangeNotifyOuterClass.AvatarSkillDepotChangeNotifyOrBuilder
        public int getSkillLevelMapCount() {
            return internalGetSkillLevelMap().getMap().size();
        }

        @Override // emu.grasscutter.net.proto.AvatarSkillDepotChangeNotifyOuterClass.AvatarSkillDepotChangeNotifyOrBuilder
        public boolean containsSkillLevelMap(int key) {
            return internalGetSkillLevelMap().getMap().containsKey(Integer.valueOf(key));
        }

        @Override // emu.grasscutter.net.proto.AvatarSkillDepotChangeNotifyOuterClass.AvatarSkillDepotChangeNotifyOrBuilder
        @Deprecated
        public Map<Integer, Integer> getSkillLevelMap() {
            return getSkillLevelMapMap();
        }

        @Override // emu.grasscutter.net.proto.AvatarSkillDepotChangeNotifyOuterClass.AvatarSkillDepotChangeNotifyOrBuilder
        public Map<Integer, Integer> getSkillLevelMapMap() {
            return internalGetSkillLevelMap().getMap();
        }

        @Override // emu.grasscutter.net.proto.AvatarSkillDepotChangeNotifyOuterClass.AvatarSkillDepotChangeNotifyOrBuilder
        public int getSkillLevelMapOrDefault(int key, int defaultValue) {
            Map<Integer, Integer> map = internalGetSkillLevelMap().getMap();
            return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)).intValue() : defaultValue;
        }

        @Override // emu.grasscutter.net.proto.AvatarSkillDepotChangeNotifyOuterClass.AvatarSkillDepotChangeNotifyOrBuilder
        public int getSkillLevelMapOrThrow(int key) {
            Map<Integer, Integer> map = internalGetSkillLevelMap().getMap();
            if (map.containsKey(Integer.valueOf(key))) {
                return map.get(Integer.valueOf(key)).intValue();
            }
            throw new IllegalArgumentException();
        }

        @Override // emu.grasscutter.net.proto.AvatarSkillDepotChangeNotifyOuterClass.AvatarSkillDepotChangeNotifyOrBuilder
        public int getSkillDepotId() {
            return this.skillDepotId_;
        }

        @Override // emu.grasscutter.net.proto.AvatarSkillDepotChangeNotifyOuterClass.AvatarSkillDepotChangeNotifyOrBuilder
        public List<Integer> getTalentIdListList() {
            return this.talentIdList_;
        }

        @Override // emu.grasscutter.net.proto.AvatarSkillDepotChangeNotifyOuterClass.AvatarSkillDepotChangeNotifyOrBuilder
        public int getTalentIdListCount() {
            return this.talentIdList_.size();
        }

        @Override // emu.grasscutter.net.proto.AvatarSkillDepotChangeNotifyOuterClass.AvatarSkillDepotChangeNotifyOrBuilder
        public int getTalentIdList(int index) {
            return this.talentIdList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.AvatarSkillDepotChangeNotifyOuterClass.AvatarSkillDepotChangeNotifyOrBuilder
        public int getCoreProudSkillLevel() {
            return this.coreProudSkillLevel_;
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
            getSerializedSize();
            GeneratedMessageV3.serializeIntegerMapTo(output, internalGetSkillLevelMap(), SkillLevelMapDefaultEntryHolder.defaultEntry, 1);
            if (getProudSkillListList().size() > 0) {
                output.writeUInt32NoTag(26);
                output.writeUInt32NoTag(this.proudSkillListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.proudSkillList_.size(); i++) {
                output.writeUInt32NoTag(this.proudSkillList_.getInt(i));
            }
            if (this.entityId_ != 0) {
                output.writeUInt32(5, this.entityId_);
            }
            if (this.avatarGuid_ != 0) {
                output.writeUInt64(7, this.avatarGuid_);
            }
            GeneratedMessageV3.serializeIntegerMapTo(output, internalGetProudSkillExtraLevelMap(), ProudSkillExtraLevelMapDefaultEntryHolder.defaultEntry, 9);
            if (this.skillDepotId_ != 0) {
                output.writeUInt32(13, this.skillDepotId_);
            }
            if (getTalentIdListList().size() > 0) {
                output.writeUInt32NoTag(114);
                output.writeUInt32NoTag(this.talentIdListMemoizedSerializedSize);
            }
            for (int i2 = 0; i2 < this.talentIdList_.size(); i2++) {
                output.writeUInt32NoTag(this.talentIdList_.getInt(i2));
            }
            if (this.coreProudSkillLevel_ != 0) {
                output.writeUInt32(15, this.coreProudSkillLevel_);
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
            for (Map.Entry<Integer, Integer> entry : internalGetSkillLevelMap().getMap().entrySet()) {
                size2 += CodedOutputStream.computeMessageSize(1, SkillLevelMapDefaultEntryHolder.defaultEntry.newBuilderForType().setKey(entry.getKey()).setValue(entry.getValue()).build());
            }
            int dataSize = 0;
            for (int i = 0; i < this.proudSkillList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.proudSkillList_.getInt(i));
            }
            int size3 = size2 + dataSize;
            if (!getProudSkillListList().isEmpty()) {
                size3 = size3 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.proudSkillListMemoizedSerializedSize = dataSize;
            if (this.entityId_ != 0) {
                size3 += CodedOutputStream.computeUInt32Size(5, this.entityId_);
            }
            if (this.avatarGuid_ != 0) {
                size3 += CodedOutputStream.computeUInt64Size(7, this.avatarGuid_);
            }
            for (Map.Entry<Integer, Integer> entry2 : internalGetProudSkillExtraLevelMap().getMap().entrySet()) {
                size3 += CodedOutputStream.computeMessageSize(9, ProudSkillExtraLevelMapDefaultEntryHolder.defaultEntry.newBuilderForType().setKey(entry2.getKey()).setValue(entry2.getValue()).build());
            }
            if (this.skillDepotId_ != 0) {
                size3 += CodedOutputStream.computeUInt32Size(13, this.skillDepotId_);
            }
            int dataSize2 = 0;
            for (int i2 = 0; i2 < this.talentIdList_.size(); i2++) {
                dataSize2 += CodedOutputStream.computeUInt32SizeNoTag(this.talentIdList_.getInt(i2));
            }
            int size4 = size3 + dataSize2;
            if (!getTalentIdListList().isEmpty()) {
                size4 = size4 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize2);
            }
            this.talentIdListMemoizedSerializedSize = dataSize2;
            if (this.coreProudSkillLevel_ != 0) {
                size4 += CodedOutputStream.computeUInt32Size(15, this.coreProudSkillLevel_);
            }
            int size5 = size4 + this.unknownFields.getSerializedSize();
            this.memoizedSize = size5;
            return size5;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof AvatarSkillDepotChangeNotify)) {
                return equals(obj);
            }
            AvatarSkillDepotChangeNotify other = (AvatarSkillDepotChangeNotify) obj;
            return internalGetProudSkillExtraLevelMap().equals(other.internalGetProudSkillExtraLevelMap()) && getProudSkillListList().equals(other.getProudSkillListList()) && getEntityId() == other.getEntityId() && getAvatarGuid() == other.getAvatarGuid() && internalGetSkillLevelMap().equals(other.internalGetSkillLevelMap()) && getSkillDepotId() == other.getSkillDepotId() && getTalentIdListList().equals(other.getTalentIdListList()) && getCoreProudSkillLevel() == other.getCoreProudSkillLevel() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (!internalGetProudSkillExtraLevelMap().getMap().isEmpty()) {
                hash = (53 * ((37 * hash) + 9)) + internalGetProudSkillExtraLevelMap().hashCode();
            }
            if (getProudSkillListCount() > 0) {
                hash = (53 * ((37 * hash) + 3)) + getProudSkillListList().hashCode();
            }
            int hash2 = (53 * ((37 * ((53 * ((37 * hash) + 5)) + getEntityId())) + 7)) + Internal.hashLong(getAvatarGuid());
            if (!internalGetSkillLevelMap().getMap().isEmpty()) {
                hash2 = (53 * ((37 * hash2) + 1)) + internalGetSkillLevelMap().hashCode();
            }
            int hash3 = (53 * ((37 * hash2) + 13)) + getSkillDepotId();
            if (getTalentIdListCount() > 0) {
                hash3 = (53 * ((37 * hash3) + 14)) + getTalentIdListList().hashCode();
            }
            int hash4 = (29 * ((53 * ((37 * hash3) + 15)) + getCoreProudSkillLevel())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash4;
            return hash4;
        }

        public static AvatarSkillDepotChangeNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AvatarSkillDepotChangeNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AvatarSkillDepotChangeNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AvatarSkillDepotChangeNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AvatarSkillDepotChangeNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AvatarSkillDepotChangeNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AvatarSkillDepotChangeNotify parseFrom(InputStream input) throws IOException {
            return (AvatarSkillDepotChangeNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AvatarSkillDepotChangeNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AvatarSkillDepotChangeNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static AvatarSkillDepotChangeNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (AvatarSkillDepotChangeNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static AvatarSkillDepotChangeNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AvatarSkillDepotChangeNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static AvatarSkillDepotChangeNotify parseFrom(CodedInputStream input) throws IOException {
            return (AvatarSkillDepotChangeNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AvatarSkillDepotChangeNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AvatarSkillDepotChangeNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(AvatarSkillDepotChangeNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarSkillDepotChangeNotifyOuterClass$AvatarSkillDepotChangeNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AvatarSkillDepotChangeNotifyOrBuilder {
            private int bitField0_;
            private MapField<Integer, Integer> proudSkillExtraLevelMap_;
            private int entityId_;
            private long avatarGuid_;
            private MapField<Integer, Integer> skillLevelMap_;
            private int skillDepotId_;
            private int coreProudSkillLevel_;
            private Internal.IntList proudSkillList_ = AvatarSkillDepotChangeNotify.emptyIntList();
            private Internal.IntList talentIdList_ = AvatarSkillDepotChangeNotify.emptyIntList();

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
            /*  JADX ERROR: Failed to decode insn: 0x002B: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.AvatarSkillDepotChangeNotifyOuterClass.AvatarSkillDepotChangeNotify.Builder.internalGetMapField(int):com.google.protobuf.MapField
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
                        case 1: goto L_0x0021;
                        case 9: goto L_0x001c;
                        default: goto L_0x0026;
                    }
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetProudSkillExtraLevelMap()
                    return r0
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetSkillLevelMap()
                    return r0
                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                    r1 = r0
                    r2 = r5
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    r1.<init>(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.AvatarSkillDepotChangeNotifyOuterClass.AvatarSkillDepotChangeNotify.Builder.internalGetMapField(int):com.google.protobuf.MapField");
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
            /*  JADX ERROR: Failed to decode insn: 0x002B: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.AvatarSkillDepotChangeNotifyOuterClass.AvatarSkillDepotChangeNotify.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField
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
                        case 1: goto L_0x0021;
                        case 9: goto L_0x001c;
                        default: goto L_0x0026;
                    }
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetMutableProudSkillExtraLevelMap()
                    return r0
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetMutableSkillLevelMap()
                    return r0
                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                    r1 = r0
                    r2 = r5
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    r1.<init>(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.AvatarSkillDepotChangeNotifyOuterClass.AvatarSkillDepotChangeNotify.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField");
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return AvatarSkillDepotChangeNotifyOuterClass.internal_static_AvatarSkillDepotChangeNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return AvatarSkillDepotChangeNotifyOuterClass.internal_static_AvatarSkillDepotChangeNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(AvatarSkillDepotChangeNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (AvatarSkillDepotChangeNotify.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                internalGetMutableProudSkillExtraLevelMap().clear();
                this.proudSkillList_ = AvatarSkillDepotChangeNotify.emptyIntList();
                this.bitField0_ &= -3;
                this.entityId_ = 0;
                this.avatarGuid_ = 0;
                internalGetMutableSkillLevelMap().clear();
                this.skillDepotId_ = 0;
                this.talentIdList_ = AvatarSkillDepotChangeNotify.emptyIntList();
                this.bitField0_ &= -9;
                this.coreProudSkillLevel_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return AvatarSkillDepotChangeNotifyOuterClass.internal_static_AvatarSkillDepotChangeNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public AvatarSkillDepotChangeNotify getDefaultInstanceForType() {
                return AvatarSkillDepotChangeNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AvatarSkillDepotChangeNotify build() {
                AvatarSkillDepotChangeNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AvatarSkillDepotChangeNotify buildPartial() {
                AvatarSkillDepotChangeNotify result = new AvatarSkillDepotChangeNotify(this);
                int i = this.bitField0_;
                result.proudSkillExtraLevelMap_ = internalGetProudSkillExtraLevelMap();
                result.proudSkillExtraLevelMap_.makeImmutable();
                if ((this.bitField0_ & 2) != 0) {
                    this.proudSkillList_.makeImmutable();
                    this.bitField0_ &= -3;
                }
                result.proudSkillList_ = this.proudSkillList_;
                result.entityId_ = this.entityId_;
                result.avatarGuid_ = this.avatarGuid_;
                result.skillLevelMap_ = internalGetSkillLevelMap();
                result.skillLevelMap_.makeImmutable();
                result.skillDepotId_ = this.skillDepotId_;
                if ((this.bitField0_ & 8) != 0) {
                    this.talentIdList_.makeImmutable();
                    this.bitField0_ &= -9;
                }
                result.talentIdList_ = this.talentIdList_;
                result.coreProudSkillLevel_ = this.coreProudSkillLevel_;
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
                if (other instanceof AvatarSkillDepotChangeNotify) {
                    return mergeFrom((AvatarSkillDepotChangeNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(AvatarSkillDepotChangeNotify other) {
                if (other == AvatarSkillDepotChangeNotify.getDefaultInstance()) {
                    return this;
                }
                internalGetMutableProudSkillExtraLevelMap().mergeFrom(other.internalGetProudSkillExtraLevelMap());
                if (!other.proudSkillList_.isEmpty()) {
                    if (this.proudSkillList_.isEmpty()) {
                        this.proudSkillList_ = other.proudSkillList_;
                        this.bitField0_ &= -3;
                    } else {
                        ensureProudSkillListIsMutable();
                        this.proudSkillList_.addAll(other.proudSkillList_);
                    }
                    onChanged();
                }
                if (other.getEntityId() != 0) {
                    setEntityId(other.getEntityId());
                }
                if (other.getAvatarGuid() != 0) {
                    setAvatarGuid(other.getAvatarGuid());
                }
                internalGetMutableSkillLevelMap().mergeFrom(other.internalGetSkillLevelMap());
                if (other.getSkillDepotId() != 0) {
                    setSkillDepotId(other.getSkillDepotId());
                }
                if (!other.talentIdList_.isEmpty()) {
                    if (this.talentIdList_.isEmpty()) {
                        this.talentIdList_ = other.talentIdList_;
                        this.bitField0_ &= -9;
                    } else {
                        ensureTalentIdListIsMutable();
                        this.talentIdList_.addAll(other.talentIdList_);
                    }
                    onChanged();
                }
                if (other.getCoreProudSkillLevel() != 0) {
                    setCoreProudSkillLevel(other.getCoreProudSkillLevel());
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
                AvatarSkillDepotChangeNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = AvatarSkillDepotChangeNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (AvatarSkillDepotChangeNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private MapField<Integer, Integer> internalGetProudSkillExtraLevelMap() {
                if (this.proudSkillExtraLevelMap_ == null) {
                    return MapField.emptyMapField(ProudSkillExtraLevelMapDefaultEntryHolder.defaultEntry);
                }
                return this.proudSkillExtraLevelMap_;
            }

            private MapField<Integer, Integer> internalGetMutableProudSkillExtraLevelMap() {
                onChanged();
                if (this.proudSkillExtraLevelMap_ == null) {
                    this.proudSkillExtraLevelMap_ = MapField.newMapField(ProudSkillExtraLevelMapDefaultEntryHolder.defaultEntry);
                }
                if (!this.proudSkillExtraLevelMap_.isMutable()) {
                    this.proudSkillExtraLevelMap_ = this.proudSkillExtraLevelMap_.copy();
                }
                return this.proudSkillExtraLevelMap_;
            }

            @Override // emu.grasscutter.net.proto.AvatarSkillDepotChangeNotifyOuterClass.AvatarSkillDepotChangeNotifyOrBuilder
            public int getProudSkillExtraLevelMapCount() {
                return internalGetProudSkillExtraLevelMap().getMap().size();
            }

            @Override // emu.grasscutter.net.proto.AvatarSkillDepotChangeNotifyOuterClass.AvatarSkillDepotChangeNotifyOrBuilder
            public boolean containsProudSkillExtraLevelMap(int key) {
                return internalGetProudSkillExtraLevelMap().getMap().containsKey(Integer.valueOf(key));
            }

            @Override // emu.grasscutter.net.proto.AvatarSkillDepotChangeNotifyOuterClass.AvatarSkillDepotChangeNotifyOrBuilder
            @Deprecated
            public Map<Integer, Integer> getProudSkillExtraLevelMap() {
                return getProudSkillExtraLevelMapMap();
            }

            @Override // emu.grasscutter.net.proto.AvatarSkillDepotChangeNotifyOuterClass.AvatarSkillDepotChangeNotifyOrBuilder
            public Map<Integer, Integer> getProudSkillExtraLevelMapMap() {
                return internalGetProudSkillExtraLevelMap().getMap();
            }

            @Override // emu.grasscutter.net.proto.AvatarSkillDepotChangeNotifyOuterClass.AvatarSkillDepotChangeNotifyOrBuilder
            public int getProudSkillExtraLevelMapOrDefault(int key, int defaultValue) {
                Map<Integer, Integer> map = internalGetProudSkillExtraLevelMap().getMap();
                return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)).intValue() : defaultValue;
            }

            @Override // emu.grasscutter.net.proto.AvatarSkillDepotChangeNotifyOuterClass.AvatarSkillDepotChangeNotifyOrBuilder
            public int getProudSkillExtraLevelMapOrThrow(int key) {
                Map<Integer, Integer> map = internalGetProudSkillExtraLevelMap().getMap();
                if (map.containsKey(Integer.valueOf(key))) {
                    return map.get(Integer.valueOf(key)).intValue();
                }
                throw new IllegalArgumentException();
            }

            public Builder clearProudSkillExtraLevelMap() {
                internalGetMutableProudSkillExtraLevelMap().getMutableMap().clear();
                return this;
            }

            public Builder removeProudSkillExtraLevelMap(int key) {
                internalGetMutableProudSkillExtraLevelMap().getMutableMap().remove(Integer.valueOf(key));
                return this;
            }

            @Deprecated
            public Map<Integer, Integer> getMutableProudSkillExtraLevelMap() {
                return internalGetMutableProudSkillExtraLevelMap().getMutableMap();
            }

            public Builder putProudSkillExtraLevelMap(int key, int value) {
                internalGetMutableProudSkillExtraLevelMap().getMutableMap().put(Integer.valueOf(key), Integer.valueOf(value));
                return this;
            }

            public Builder putAllProudSkillExtraLevelMap(Map<Integer, Integer> values) {
                internalGetMutableProudSkillExtraLevelMap().getMutableMap().putAll(values);
                return this;
            }

            private void ensureProudSkillListIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.proudSkillList_ = AvatarSkillDepotChangeNotify.mutableCopy(this.proudSkillList_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.AvatarSkillDepotChangeNotifyOuterClass.AvatarSkillDepotChangeNotifyOrBuilder
            public List<Integer> getProudSkillListList() {
                return (this.bitField0_ & 2) != 0 ? Collections.unmodifiableList(this.proudSkillList_) : this.proudSkillList_;
            }

            @Override // emu.grasscutter.net.proto.AvatarSkillDepotChangeNotifyOuterClass.AvatarSkillDepotChangeNotifyOrBuilder
            public int getProudSkillListCount() {
                return this.proudSkillList_.size();
            }

            @Override // emu.grasscutter.net.proto.AvatarSkillDepotChangeNotifyOuterClass.AvatarSkillDepotChangeNotifyOrBuilder
            public int getProudSkillList(int index) {
                return this.proudSkillList_.getInt(index);
            }

            public Builder setProudSkillList(int index, int value) {
                ensureProudSkillListIsMutable();
                this.proudSkillList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addProudSkillList(int value) {
                ensureProudSkillListIsMutable();
                this.proudSkillList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllProudSkillList(Iterable<? extends Integer> values) {
                ensureProudSkillListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.proudSkillList_);
                onChanged();
                return this;
            }

            public Builder clearProudSkillList() {
                this.proudSkillList_ = AvatarSkillDepotChangeNotify.emptyIntList();
                this.bitField0_ &= -3;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AvatarSkillDepotChangeNotifyOuterClass.AvatarSkillDepotChangeNotifyOrBuilder
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

            @Override // emu.grasscutter.net.proto.AvatarSkillDepotChangeNotifyOuterClass.AvatarSkillDepotChangeNotifyOrBuilder
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

            private MapField<Integer, Integer> internalGetSkillLevelMap() {
                if (this.skillLevelMap_ == null) {
                    return MapField.emptyMapField(SkillLevelMapDefaultEntryHolder.defaultEntry);
                }
                return this.skillLevelMap_;
            }

            private MapField<Integer, Integer> internalGetMutableSkillLevelMap() {
                onChanged();
                if (this.skillLevelMap_ == null) {
                    this.skillLevelMap_ = MapField.newMapField(SkillLevelMapDefaultEntryHolder.defaultEntry);
                }
                if (!this.skillLevelMap_.isMutable()) {
                    this.skillLevelMap_ = this.skillLevelMap_.copy();
                }
                return this.skillLevelMap_;
            }

            @Override // emu.grasscutter.net.proto.AvatarSkillDepotChangeNotifyOuterClass.AvatarSkillDepotChangeNotifyOrBuilder
            public int getSkillLevelMapCount() {
                return internalGetSkillLevelMap().getMap().size();
            }

            @Override // emu.grasscutter.net.proto.AvatarSkillDepotChangeNotifyOuterClass.AvatarSkillDepotChangeNotifyOrBuilder
            public boolean containsSkillLevelMap(int key) {
                return internalGetSkillLevelMap().getMap().containsKey(Integer.valueOf(key));
            }

            @Override // emu.grasscutter.net.proto.AvatarSkillDepotChangeNotifyOuterClass.AvatarSkillDepotChangeNotifyOrBuilder
            @Deprecated
            public Map<Integer, Integer> getSkillLevelMap() {
                return getSkillLevelMapMap();
            }

            @Override // emu.grasscutter.net.proto.AvatarSkillDepotChangeNotifyOuterClass.AvatarSkillDepotChangeNotifyOrBuilder
            public Map<Integer, Integer> getSkillLevelMapMap() {
                return internalGetSkillLevelMap().getMap();
            }

            @Override // emu.grasscutter.net.proto.AvatarSkillDepotChangeNotifyOuterClass.AvatarSkillDepotChangeNotifyOrBuilder
            public int getSkillLevelMapOrDefault(int key, int defaultValue) {
                Map<Integer, Integer> map = internalGetSkillLevelMap().getMap();
                return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)).intValue() : defaultValue;
            }

            @Override // emu.grasscutter.net.proto.AvatarSkillDepotChangeNotifyOuterClass.AvatarSkillDepotChangeNotifyOrBuilder
            public int getSkillLevelMapOrThrow(int key) {
                Map<Integer, Integer> map = internalGetSkillLevelMap().getMap();
                if (map.containsKey(Integer.valueOf(key))) {
                    return map.get(Integer.valueOf(key)).intValue();
                }
                throw new IllegalArgumentException();
            }

            public Builder clearSkillLevelMap() {
                internalGetMutableSkillLevelMap().getMutableMap().clear();
                return this;
            }

            public Builder removeSkillLevelMap(int key) {
                internalGetMutableSkillLevelMap().getMutableMap().remove(Integer.valueOf(key));
                return this;
            }

            @Deprecated
            public Map<Integer, Integer> getMutableSkillLevelMap() {
                return internalGetMutableSkillLevelMap().getMutableMap();
            }

            public Builder putSkillLevelMap(int key, int value) {
                internalGetMutableSkillLevelMap().getMutableMap().put(Integer.valueOf(key), Integer.valueOf(value));
                return this;
            }

            public Builder putAllSkillLevelMap(Map<Integer, Integer> values) {
                internalGetMutableSkillLevelMap().getMutableMap().putAll(values);
                return this;
            }

            @Override // emu.grasscutter.net.proto.AvatarSkillDepotChangeNotifyOuterClass.AvatarSkillDepotChangeNotifyOrBuilder
            public int getSkillDepotId() {
                return this.skillDepotId_;
            }

            public Builder setSkillDepotId(int value) {
                this.skillDepotId_ = value;
                onChanged();
                return this;
            }

            public Builder clearSkillDepotId() {
                this.skillDepotId_ = 0;
                onChanged();
                return this;
            }

            private void ensureTalentIdListIsMutable() {
                if ((this.bitField0_ & 8) == 0) {
                    this.talentIdList_ = AvatarSkillDepotChangeNotify.mutableCopy(this.talentIdList_);
                    this.bitField0_ |= 8;
                }
            }

            @Override // emu.grasscutter.net.proto.AvatarSkillDepotChangeNotifyOuterClass.AvatarSkillDepotChangeNotifyOrBuilder
            public List<Integer> getTalentIdListList() {
                return (this.bitField0_ & 8) != 0 ? Collections.unmodifiableList(this.talentIdList_) : this.talentIdList_;
            }

            @Override // emu.grasscutter.net.proto.AvatarSkillDepotChangeNotifyOuterClass.AvatarSkillDepotChangeNotifyOrBuilder
            public int getTalentIdListCount() {
                return this.talentIdList_.size();
            }

            @Override // emu.grasscutter.net.proto.AvatarSkillDepotChangeNotifyOuterClass.AvatarSkillDepotChangeNotifyOrBuilder
            public int getTalentIdList(int index) {
                return this.talentIdList_.getInt(index);
            }

            public Builder setTalentIdList(int index, int value) {
                ensureTalentIdListIsMutable();
                this.talentIdList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addTalentIdList(int value) {
                ensureTalentIdListIsMutable();
                this.talentIdList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllTalentIdList(Iterable<? extends Integer> values) {
                ensureTalentIdListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.talentIdList_);
                onChanged();
                return this;
            }

            public Builder clearTalentIdList() {
                this.talentIdList_ = AvatarSkillDepotChangeNotify.emptyIntList();
                this.bitField0_ &= -9;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AvatarSkillDepotChangeNotifyOuterClass.AvatarSkillDepotChangeNotifyOrBuilder
            public int getCoreProudSkillLevel() {
                return this.coreProudSkillLevel_;
            }

            public Builder setCoreProudSkillLevel(int value) {
                this.coreProudSkillLevel_ = value;
                onChanged();
                return this;
            }

            public Builder clearCoreProudSkillLevel() {
                this.coreProudSkillLevel_ = 0;
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

        public static AvatarSkillDepotChangeNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<AvatarSkillDepotChangeNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<AvatarSkillDepotChangeNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public AvatarSkillDepotChangeNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
