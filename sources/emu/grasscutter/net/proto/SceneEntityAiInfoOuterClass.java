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
import emu.grasscutter.net.proto.ServantInfoOuterClass;
import emu.grasscutter.net.proto.VectorOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Map;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SceneEntityAiInfoOuterClass.class */
public final class SceneEntityAiInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0017SceneEntityAiInfo.proto\u001a\u0011ServantInfo.proto\u001a\fVector.proto\"Ô\u0003\n\u0011SceneEntityAiInfo\u0012\u0012\n\nis_ai_open\u0018\u0001 \u0001(\b\u0012\u0019\n\bborn_pos\u0018\u0002 \u0001(\u000b2\u0007.Vector\u00128\n\fskill_cd_map\u0018\u0003 \u0003(\u000b2\".SceneEntityAiInfo.SkillCdMapEntry\u0012\"\n\fservant_info\u0018\u0004 \u0001(\u000b2\f.ServantInfo\u0012:\n\rai_threat_map\u0018\u0005 \u0003(\u000b2#.SceneEntityAiInfo.AiThreatMapEntry\u0012C\n\u0012skill_group_cd_map\u0018\u0006 \u0003(\u000b2'.SceneEntityAiInfo.SkillGroupCdMapEntry\u0012\u0012\n\ncur_tactic\u0018\u0007 \u0001(\r\u001a1\n\u000fSkillCdMapEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\r\u0012\r\n\u0005value\u0018\u0002 \u0001(\r:\u00028\u0001\u001a2\n\u0010AiThreatMapEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\r\u0012\r\n\u0005value\u0018\u0002 \u0001(\r:\u00028\u0001\u001a6\n\u0014SkillGroupCdMapEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\r\u0012\r\n\u0005value\u0018\u0002 \u0001(\r:\u00028\u0001B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{ServantInfoOuterClass.getDescriptor(), VectorOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_SceneEntityAiInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_SceneEntityAiInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_SceneEntityAiInfo_descriptor, new String[]{"IsAiOpen", "BornPos", "SkillCdMap", "ServantInfo", "AiThreatMap", "SkillGroupCdMap", "CurTactic"});
    private static final Descriptors.Descriptor internal_static_SceneEntityAiInfo_SkillCdMapEntry_descriptor = internal_static_SceneEntityAiInfo_descriptor.getNestedTypes().get(0);

    /* renamed from: internal_static_SceneEntityAiInfo_SkillCdMapEntry_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f860xdba1676d = new GeneratedMessageV3.FieldAccessorTable(internal_static_SceneEntityAiInfo_SkillCdMapEntry_descriptor, new String[]{"Key", "Value"});
    private static final Descriptors.Descriptor internal_static_SceneEntityAiInfo_AiThreatMapEntry_descriptor = internal_static_SceneEntityAiInfo_descriptor.getNestedTypes().get(1);

    /* renamed from: internal_static_SceneEntityAiInfo_AiThreatMapEntry_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f861xd266f0ab = new GeneratedMessageV3.FieldAccessorTable(internal_static_SceneEntityAiInfo_AiThreatMapEntry_descriptor, new String[]{"Key", "Value"});

    /* renamed from: internal_static_SceneEntityAiInfo_SkillGroupCdMapEntry_descriptor */
    private static final Descriptors.Descriptor f862xce992b40 = internal_static_SceneEntityAiInfo_descriptor.getNestedTypes().get(2);

    /* renamed from: internal_static_SceneEntityAiInfo_SkillGroupCdMapEntry_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f863xd8c911be = new GeneratedMessageV3.FieldAccessorTable(f862xce992b40, new String[]{"Key", "Value"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SceneEntityAiInfoOuterClass$SceneEntityAiInfoOrBuilder.class */
    public interface SceneEntityAiInfoOrBuilder extends MessageOrBuilder {
        boolean getIsAiOpen();

        boolean hasBornPos();

        VectorOuterClass.Vector getBornPos();

        VectorOuterClass.VectorOrBuilder getBornPosOrBuilder();

        int getSkillCdMapCount();

        boolean containsSkillCdMap(int i);

        @Deprecated
        Map<Integer, Integer> getSkillCdMap();

        Map<Integer, Integer> getSkillCdMapMap();

        int getSkillCdMapOrDefault(int i, int i2);

        int getSkillCdMapOrThrow(int i);

        boolean hasServantInfo();

        ServantInfoOuterClass.ServantInfo getServantInfo();

        ServantInfoOuterClass.ServantInfoOrBuilder getServantInfoOrBuilder();

        int getAiThreatMapCount();

        boolean containsAiThreatMap(int i);

        @Deprecated
        Map<Integer, Integer> getAiThreatMap();

        Map<Integer, Integer> getAiThreatMapMap();

        int getAiThreatMapOrDefault(int i, int i2);

        int getAiThreatMapOrThrow(int i);

        int getSkillGroupCdMapCount();

        boolean containsSkillGroupCdMap(int i);

        @Deprecated
        Map<Integer, Integer> getSkillGroupCdMap();

        Map<Integer, Integer> getSkillGroupCdMapMap();

        int getSkillGroupCdMapOrDefault(int i, int i2);

        int getSkillGroupCdMapOrThrow(int i);

        int getCurTactic();
    }

    private SceneEntityAiInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SceneEntityAiInfoOuterClass$SceneEntityAiInfo.class */
    public static final class SceneEntityAiInfo extends GeneratedMessageV3 implements SceneEntityAiInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int IS_AI_OPEN_FIELD_NUMBER = 1;
        private boolean isAiOpen_;
        public static final int BORN_POS_FIELD_NUMBER = 2;
        private VectorOuterClass.Vector bornPos_;
        public static final int SKILL_CD_MAP_FIELD_NUMBER = 3;
        private MapField<Integer, Integer> skillCdMap_;
        public static final int SERVANT_INFO_FIELD_NUMBER = 4;
        private ServantInfoOuterClass.ServantInfo servantInfo_;
        public static final int AI_THREAT_MAP_FIELD_NUMBER = 5;
        private MapField<Integer, Integer> aiThreatMap_;
        public static final int SKILL_GROUP_CD_MAP_FIELD_NUMBER = 6;
        private MapField<Integer, Integer> skillGroupCdMap_;
        public static final int CUR_TACTIC_FIELD_NUMBER = 7;
        private int curTactic_;
        private byte memoizedIsInitialized;
        private static final SceneEntityAiInfo DEFAULT_INSTANCE = new SceneEntityAiInfo();
        private static final Parser<SceneEntityAiInfo> PARSER = new AbstractParser<SceneEntityAiInfo>() { // from class: emu.grasscutter.net.proto.SceneEntityAiInfoOuterClass.SceneEntityAiInfo.1
            @Override // com.google.protobuf.Parser
            public SceneEntityAiInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new SceneEntityAiInfo(input, extensionRegistry);
            }
        };

        /*  JADX ERROR: Dependency scan failed at insn: 0x0034: INVOKE_CUSTOM r0
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
        /*  JADX ERROR: Failed to decode insn: 0x0034: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.SceneEntityAiInfoOuterClass.SceneEntityAiInfo.internalGetMapField(int):com.google.protobuf.MapField
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
                    case 3: goto L_0x0020;
                    case 4: goto L_0x002f;
                    case 5: goto L_0x0025;
                    case 6: goto L_0x002a;
                    default: goto L_0x002f;
                }
                r0 = r4
                com.google.protobuf.MapField r0 = r0.internalGetSkillCdMap()
                return r0
                r0 = r4
                com.google.protobuf.MapField r0 = r0.internalGetAiThreatMap()
                return r0
                r0 = r4
                com.google.protobuf.MapField r0 = r0.internalGetSkillGroupCdMap()
                return r0
                java.lang.RuntimeException r0 = new java.lang.RuntimeException
                r1 = r0
                r2 = r5
                // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                r1.<init>(r2)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.SceneEntityAiInfoOuterClass.SceneEntityAiInfo.internalGetMapField(int):com.google.protobuf.MapField");
        }

        private SceneEntityAiInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private SceneEntityAiInfo() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new SceneEntityAiInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private SceneEntityAiInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 8:
                                this.isAiOpen_ = input.readBool();
                                break;
                            case 18:
                                VectorOuterClass.Vector.Builder subBuilder = this.bornPos_ != null ? this.bornPos_.toBuilder() : null;
                                this.bornPos_ = (VectorOuterClass.Vector) input.readMessage(VectorOuterClass.Vector.parser(), extensionRegistry);
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.mergeFrom(this.bornPos_);
                                    this.bornPos_ = subBuilder.buildPartial();
                                    break;
                                }
                            case 26:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.skillCdMap_ = MapField.newMapField(SkillCdMapDefaultEntryHolder.defaultEntry);
                                    mutable_bitField0_ |= 1;
                                }
                                MapEntry<Integer, Integer> skillCdMap__ = (MapEntry) input.readMessage(SkillCdMapDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
                                this.skillCdMap_.getMutableMap().put(skillCdMap__.getKey(), skillCdMap__.getValue());
                                break;
                            case 34:
                                ServantInfoOuterClass.ServantInfo.Builder subBuilder2 = this.servantInfo_ != null ? this.servantInfo_.toBuilder() : null;
                                this.servantInfo_ = (ServantInfoOuterClass.ServantInfo) input.readMessage(ServantInfoOuterClass.ServantInfo.parser(), extensionRegistry);
                                if (subBuilder2 == null) {
                                    break;
                                } else {
                                    subBuilder2.mergeFrom(this.servantInfo_);
                                    this.servantInfo_ = subBuilder2.buildPartial();
                                    break;
                                }
                            case 42:
                                if ((mutable_bitField0_ & 2) == 0) {
                                    this.aiThreatMap_ = MapField.newMapField(AiThreatMapDefaultEntryHolder.defaultEntry);
                                    mutable_bitField0_ |= 2;
                                }
                                MapEntry<Integer, Integer> aiThreatMap__ = (MapEntry) input.readMessage(AiThreatMapDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
                                this.aiThreatMap_.getMutableMap().put(aiThreatMap__.getKey(), aiThreatMap__.getValue());
                                break;
                            case 50:
                                if ((mutable_bitField0_ & 4) == 0) {
                                    this.skillGroupCdMap_ = MapField.newMapField(SkillGroupCdMapDefaultEntryHolder.defaultEntry);
                                    mutable_bitField0_ |= 4;
                                }
                                MapEntry<Integer, Integer> skillGroupCdMap__ = (MapEntry) input.readMessage(SkillGroupCdMapDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
                                this.skillGroupCdMap_.getMutableMap().put(skillGroupCdMap__.getKey(), skillGroupCdMap__.getValue());
                                break;
                            case 56:
                                this.curTactic_ = input.readUInt32();
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
            return SceneEntityAiInfoOuterClass.internal_static_SceneEntityAiInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return SceneEntityAiInfoOuterClass.internal_static_SceneEntityAiInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(SceneEntityAiInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.SceneEntityAiInfoOuterClass.SceneEntityAiInfoOrBuilder
        public boolean getIsAiOpen() {
            return this.isAiOpen_;
        }

        @Override // emu.grasscutter.net.proto.SceneEntityAiInfoOuterClass.SceneEntityAiInfoOrBuilder
        public boolean hasBornPos() {
            return this.bornPos_ != null;
        }

        @Override // emu.grasscutter.net.proto.SceneEntityAiInfoOuterClass.SceneEntityAiInfoOrBuilder
        public VectorOuterClass.Vector getBornPos() {
            return this.bornPos_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.bornPos_;
        }

        @Override // emu.grasscutter.net.proto.SceneEntityAiInfoOuterClass.SceneEntityAiInfoOrBuilder
        public VectorOuterClass.VectorOrBuilder getBornPosOrBuilder() {
            return getBornPos();
        }

        /* access modifiers changed from: private */
        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SceneEntityAiInfoOuterClass$SceneEntityAiInfo$SkillCdMapDefaultEntryHolder.class */
        public static final class SkillCdMapDefaultEntryHolder {
            static final MapEntry<Integer, Integer> defaultEntry = MapEntry.newDefaultInstance(SceneEntityAiInfoOuterClass.internal_static_SceneEntityAiInfo_SkillCdMapEntry_descriptor, WireFormat.FieldType.UINT32, 0, WireFormat.FieldType.UINT32, 0);

            private SkillCdMapDefaultEntryHolder() {
            }
        }

        private MapField<Integer, Integer> internalGetSkillCdMap() {
            if (this.skillCdMap_ == null) {
                return MapField.emptyMapField(SkillCdMapDefaultEntryHolder.defaultEntry);
            }
            return this.skillCdMap_;
        }

        @Override // emu.grasscutter.net.proto.SceneEntityAiInfoOuterClass.SceneEntityAiInfoOrBuilder
        public int getSkillCdMapCount() {
            return internalGetSkillCdMap().getMap().size();
        }

        @Override // emu.grasscutter.net.proto.SceneEntityAiInfoOuterClass.SceneEntityAiInfoOrBuilder
        public boolean containsSkillCdMap(int key) {
            return internalGetSkillCdMap().getMap().containsKey(Integer.valueOf(key));
        }

        @Override // emu.grasscutter.net.proto.SceneEntityAiInfoOuterClass.SceneEntityAiInfoOrBuilder
        @Deprecated
        public Map<Integer, Integer> getSkillCdMap() {
            return getSkillCdMapMap();
        }

        @Override // emu.grasscutter.net.proto.SceneEntityAiInfoOuterClass.SceneEntityAiInfoOrBuilder
        public Map<Integer, Integer> getSkillCdMapMap() {
            return internalGetSkillCdMap().getMap();
        }

        @Override // emu.grasscutter.net.proto.SceneEntityAiInfoOuterClass.SceneEntityAiInfoOrBuilder
        public int getSkillCdMapOrDefault(int key, int defaultValue) {
            Map<Integer, Integer> map = internalGetSkillCdMap().getMap();
            return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)).intValue() : defaultValue;
        }

        @Override // emu.grasscutter.net.proto.SceneEntityAiInfoOuterClass.SceneEntityAiInfoOrBuilder
        public int getSkillCdMapOrThrow(int key) {
            Map<Integer, Integer> map = internalGetSkillCdMap().getMap();
            if (map.containsKey(Integer.valueOf(key))) {
                return map.get(Integer.valueOf(key)).intValue();
            }
            throw new IllegalArgumentException();
        }

        @Override // emu.grasscutter.net.proto.SceneEntityAiInfoOuterClass.SceneEntityAiInfoOrBuilder
        public boolean hasServantInfo() {
            return this.servantInfo_ != null;
        }

        @Override // emu.grasscutter.net.proto.SceneEntityAiInfoOuterClass.SceneEntityAiInfoOrBuilder
        public ServantInfoOuterClass.ServantInfo getServantInfo() {
            return this.servantInfo_ == null ? ServantInfoOuterClass.ServantInfo.getDefaultInstance() : this.servantInfo_;
        }

        @Override // emu.grasscutter.net.proto.SceneEntityAiInfoOuterClass.SceneEntityAiInfoOrBuilder
        public ServantInfoOuterClass.ServantInfoOrBuilder getServantInfoOrBuilder() {
            return getServantInfo();
        }

        /* access modifiers changed from: private */
        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SceneEntityAiInfoOuterClass$SceneEntityAiInfo$AiThreatMapDefaultEntryHolder.class */
        public static final class AiThreatMapDefaultEntryHolder {
            static final MapEntry<Integer, Integer> defaultEntry = MapEntry.newDefaultInstance(SceneEntityAiInfoOuterClass.internal_static_SceneEntityAiInfo_AiThreatMapEntry_descriptor, WireFormat.FieldType.UINT32, 0, WireFormat.FieldType.UINT32, 0);

            private AiThreatMapDefaultEntryHolder() {
            }
        }

        private MapField<Integer, Integer> internalGetAiThreatMap() {
            if (this.aiThreatMap_ == null) {
                return MapField.emptyMapField(AiThreatMapDefaultEntryHolder.defaultEntry);
            }
            return this.aiThreatMap_;
        }

        @Override // emu.grasscutter.net.proto.SceneEntityAiInfoOuterClass.SceneEntityAiInfoOrBuilder
        public int getAiThreatMapCount() {
            return internalGetAiThreatMap().getMap().size();
        }

        @Override // emu.grasscutter.net.proto.SceneEntityAiInfoOuterClass.SceneEntityAiInfoOrBuilder
        public boolean containsAiThreatMap(int key) {
            return internalGetAiThreatMap().getMap().containsKey(Integer.valueOf(key));
        }

        @Override // emu.grasscutter.net.proto.SceneEntityAiInfoOuterClass.SceneEntityAiInfoOrBuilder
        @Deprecated
        public Map<Integer, Integer> getAiThreatMap() {
            return getAiThreatMapMap();
        }

        @Override // emu.grasscutter.net.proto.SceneEntityAiInfoOuterClass.SceneEntityAiInfoOrBuilder
        public Map<Integer, Integer> getAiThreatMapMap() {
            return internalGetAiThreatMap().getMap();
        }

        @Override // emu.grasscutter.net.proto.SceneEntityAiInfoOuterClass.SceneEntityAiInfoOrBuilder
        public int getAiThreatMapOrDefault(int key, int defaultValue) {
            Map<Integer, Integer> map = internalGetAiThreatMap().getMap();
            return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)).intValue() : defaultValue;
        }

        @Override // emu.grasscutter.net.proto.SceneEntityAiInfoOuterClass.SceneEntityAiInfoOrBuilder
        public int getAiThreatMapOrThrow(int key) {
            Map<Integer, Integer> map = internalGetAiThreatMap().getMap();
            if (map.containsKey(Integer.valueOf(key))) {
                return map.get(Integer.valueOf(key)).intValue();
            }
            throw new IllegalArgumentException();
        }

        /* access modifiers changed from: private */
        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SceneEntityAiInfoOuterClass$SceneEntityAiInfo$SkillGroupCdMapDefaultEntryHolder.class */
        public static final class SkillGroupCdMapDefaultEntryHolder {
            static final MapEntry<Integer, Integer> defaultEntry = MapEntry.newDefaultInstance(SceneEntityAiInfoOuterClass.f862xce992b40, WireFormat.FieldType.UINT32, 0, WireFormat.FieldType.UINT32, 0);

            private SkillGroupCdMapDefaultEntryHolder() {
            }
        }

        private MapField<Integer, Integer> internalGetSkillGroupCdMap() {
            if (this.skillGroupCdMap_ == null) {
                return MapField.emptyMapField(SkillGroupCdMapDefaultEntryHolder.defaultEntry);
            }
            return this.skillGroupCdMap_;
        }

        @Override // emu.grasscutter.net.proto.SceneEntityAiInfoOuterClass.SceneEntityAiInfoOrBuilder
        public int getSkillGroupCdMapCount() {
            return internalGetSkillGroupCdMap().getMap().size();
        }

        @Override // emu.grasscutter.net.proto.SceneEntityAiInfoOuterClass.SceneEntityAiInfoOrBuilder
        public boolean containsSkillGroupCdMap(int key) {
            return internalGetSkillGroupCdMap().getMap().containsKey(Integer.valueOf(key));
        }

        @Override // emu.grasscutter.net.proto.SceneEntityAiInfoOuterClass.SceneEntityAiInfoOrBuilder
        @Deprecated
        public Map<Integer, Integer> getSkillGroupCdMap() {
            return getSkillGroupCdMapMap();
        }

        @Override // emu.grasscutter.net.proto.SceneEntityAiInfoOuterClass.SceneEntityAiInfoOrBuilder
        public Map<Integer, Integer> getSkillGroupCdMapMap() {
            return internalGetSkillGroupCdMap().getMap();
        }

        @Override // emu.grasscutter.net.proto.SceneEntityAiInfoOuterClass.SceneEntityAiInfoOrBuilder
        public int getSkillGroupCdMapOrDefault(int key, int defaultValue) {
            Map<Integer, Integer> map = internalGetSkillGroupCdMap().getMap();
            return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)).intValue() : defaultValue;
        }

        @Override // emu.grasscutter.net.proto.SceneEntityAiInfoOuterClass.SceneEntityAiInfoOrBuilder
        public int getSkillGroupCdMapOrThrow(int key) {
            Map<Integer, Integer> map = internalGetSkillGroupCdMap().getMap();
            if (map.containsKey(Integer.valueOf(key))) {
                return map.get(Integer.valueOf(key)).intValue();
            }
            throw new IllegalArgumentException();
        }

        @Override // emu.grasscutter.net.proto.SceneEntityAiInfoOuterClass.SceneEntityAiInfoOrBuilder
        public int getCurTactic() {
            return this.curTactic_;
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
            if (this.isAiOpen_) {
                output.writeBool(1, this.isAiOpen_);
            }
            if (this.bornPos_ != null) {
                output.writeMessage(2, getBornPos());
            }
            GeneratedMessageV3.serializeIntegerMapTo(output, internalGetSkillCdMap(), SkillCdMapDefaultEntryHolder.defaultEntry, 3);
            if (this.servantInfo_ != null) {
                output.writeMessage(4, getServantInfo());
            }
            GeneratedMessageV3.serializeIntegerMapTo(output, internalGetAiThreatMap(), AiThreatMapDefaultEntryHolder.defaultEntry, 5);
            GeneratedMessageV3.serializeIntegerMapTo(output, internalGetSkillGroupCdMap(), SkillGroupCdMapDefaultEntryHolder.defaultEntry, 6);
            if (this.curTactic_ != 0) {
                output.writeUInt32(7, this.curTactic_);
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
            if (this.isAiOpen_) {
                size2 = 0 + CodedOutputStream.computeBoolSize(1, this.isAiOpen_);
            }
            if (this.bornPos_ != null) {
                size2 += CodedOutputStream.computeMessageSize(2, getBornPos());
            }
            for (Map.Entry<Integer, Integer> entry : internalGetSkillCdMap().getMap().entrySet()) {
                size2 += CodedOutputStream.computeMessageSize(3, SkillCdMapDefaultEntryHolder.defaultEntry.newBuilderForType().setKey(entry.getKey()).setValue(entry.getValue()).build());
            }
            if (this.servantInfo_ != null) {
                size2 += CodedOutputStream.computeMessageSize(4, getServantInfo());
            }
            for (Map.Entry<Integer, Integer> entry2 : internalGetAiThreatMap().getMap().entrySet()) {
                size2 += CodedOutputStream.computeMessageSize(5, AiThreatMapDefaultEntryHolder.defaultEntry.newBuilderForType().setKey(entry2.getKey()).setValue(entry2.getValue()).build());
            }
            for (Map.Entry<Integer, Integer> entry3 : internalGetSkillGroupCdMap().getMap().entrySet()) {
                size2 += CodedOutputStream.computeMessageSize(6, SkillGroupCdMapDefaultEntryHolder.defaultEntry.newBuilderForType().setKey(entry3.getKey()).setValue(entry3.getValue()).build());
            }
            if (this.curTactic_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(7, this.curTactic_);
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
            if (!(obj instanceof SceneEntityAiInfo)) {
                return equals(obj);
            }
            SceneEntityAiInfo other = (SceneEntityAiInfo) obj;
            if (getIsAiOpen() != other.getIsAiOpen() || hasBornPos() != other.hasBornPos()) {
                return false;
            }
            if ((!hasBornPos() || getBornPos().equals(other.getBornPos())) && internalGetSkillCdMap().equals(other.internalGetSkillCdMap()) && hasServantInfo() == other.hasServantInfo()) {
                return (!hasServantInfo() || getServantInfo().equals(other.getServantInfo())) && internalGetAiThreatMap().equals(other.internalGetAiThreatMap()) && internalGetSkillGroupCdMap().equals(other.internalGetSkillGroupCdMap()) && getCurTactic() == other.getCurTactic() && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + Internal.hashBoolean(getIsAiOpen());
            if (hasBornPos()) {
                hash = (53 * ((37 * hash) + 2)) + getBornPos().hashCode();
            }
            if (!internalGetSkillCdMap().getMap().isEmpty()) {
                hash = (53 * ((37 * hash) + 3)) + internalGetSkillCdMap().hashCode();
            }
            if (hasServantInfo()) {
                hash = (53 * ((37 * hash) + 4)) + getServantInfo().hashCode();
            }
            if (!internalGetAiThreatMap().getMap().isEmpty()) {
                hash = (53 * ((37 * hash) + 5)) + internalGetAiThreatMap().hashCode();
            }
            if (!internalGetSkillGroupCdMap().getMap().isEmpty()) {
                hash = (53 * ((37 * hash) + 6)) + internalGetSkillGroupCdMap().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * hash) + 7)) + getCurTactic())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static SceneEntityAiInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SceneEntityAiInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SceneEntityAiInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SceneEntityAiInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SceneEntityAiInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SceneEntityAiInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SceneEntityAiInfo parseFrom(InputStream input) throws IOException {
            return (SceneEntityAiInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SceneEntityAiInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SceneEntityAiInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static SceneEntityAiInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (SceneEntityAiInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static SceneEntityAiInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SceneEntityAiInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static SceneEntityAiInfo parseFrom(CodedInputStream input) throws IOException {
            return (SceneEntityAiInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SceneEntityAiInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SceneEntityAiInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(SceneEntityAiInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SceneEntityAiInfoOuterClass$SceneEntityAiInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements SceneEntityAiInfoOrBuilder {
            private int bitField0_;
            private boolean isAiOpen_;
            private VectorOuterClass.Vector bornPos_;
            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> bornPosBuilder_;
            private MapField<Integer, Integer> skillCdMap_;
            private ServantInfoOuterClass.ServantInfo servantInfo_;
            private SingleFieldBuilderV3<ServantInfoOuterClass.ServantInfo, ServantInfoOuterClass.ServantInfo.Builder, ServantInfoOuterClass.ServantInfoOrBuilder> servantInfoBuilder_;
            private MapField<Integer, Integer> aiThreatMap_;
            private MapField<Integer, Integer> skillGroupCdMap_;
            private int curTactic_;

            /*  JADX ERROR: Dependency scan failed at insn: 0x0034: INVOKE_CUSTOM r0
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
            /*  JADX ERROR: Failed to decode insn: 0x0034: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.SceneEntityAiInfoOuterClass.SceneEntityAiInfo.Builder.internalGetMapField(int):com.google.protobuf.MapField
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
                        case 3: goto L_0x0020;
                        case 4: goto L_0x002f;
                        case 5: goto L_0x0025;
                        case 6: goto L_0x002a;
                        default: goto L_0x002f;
                    }
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetSkillCdMap()
                    return r0
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetAiThreatMap()
                    return r0
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetSkillGroupCdMap()
                    return r0
                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                    r1 = r0
                    r2 = r5
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    r1.<init>(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.SceneEntityAiInfoOuterClass.SceneEntityAiInfo.Builder.internalGetMapField(int):com.google.protobuf.MapField");
            }

            /*  JADX ERROR: Dependency scan failed at insn: 0x0034: INVOKE_CUSTOM r0
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
            /*  JADX ERROR: Failed to decode insn: 0x0034: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.SceneEntityAiInfoOuterClass.SceneEntityAiInfo.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField
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
                        case 3: goto L_0x0020;
                        case 4: goto L_0x002f;
                        case 5: goto L_0x0025;
                        case 6: goto L_0x002a;
                        default: goto L_0x002f;
                    }
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetMutableSkillCdMap()
                    return r0
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetMutableAiThreatMap()
                    return r0
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetMutableSkillGroupCdMap()
                    return r0
                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                    r1 = r0
                    r2 = r5
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    r1.<init>(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.SceneEntityAiInfoOuterClass.SceneEntityAiInfo.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField");
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return SceneEntityAiInfoOuterClass.internal_static_SceneEntityAiInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return SceneEntityAiInfoOuterClass.internal_static_SceneEntityAiInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(SceneEntityAiInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (SceneEntityAiInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.isAiOpen_ = false;
                if (this.bornPosBuilder_ == null) {
                    this.bornPos_ = null;
                } else {
                    this.bornPos_ = null;
                    this.bornPosBuilder_ = null;
                }
                internalGetMutableSkillCdMap().clear();
                if (this.servantInfoBuilder_ == null) {
                    this.servantInfo_ = null;
                } else {
                    this.servantInfo_ = null;
                    this.servantInfoBuilder_ = null;
                }
                internalGetMutableAiThreatMap().clear();
                internalGetMutableSkillGroupCdMap().clear();
                this.curTactic_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return SceneEntityAiInfoOuterClass.internal_static_SceneEntityAiInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public SceneEntityAiInfo getDefaultInstanceForType() {
                return SceneEntityAiInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SceneEntityAiInfo build() {
                SceneEntityAiInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SceneEntityAiInfo buildPartial() {
                SceneEntityAiInfo result = new SceneEntityAiInfo(this);
                int i = this.bitField0_;
                result.isAiOpen_ = this.isAiOpen_;
                if (this.bornPosBuilder_ == null) {
                    result.bornPos_ = this.bornPos_;
                } else {
                    result.bornPos_ = this.bornPosBuilder_.build();
                }
                result.skillCdMap_ = internalGetSkillCdMap();
                result.skillCdMap_.makeImmutable();
                if (this.servantInfoBuilder_ == null) {
                    result.servantInfo_ = this.servantInfo_;
                } else {
                    result.servantInfo_ = this.servantInfoBuilder_.build();
                }
                result.aiThreatMap_ = internalGetAiThreatMap();
                result.aiThreatMap_.makeImmutable();
                result.skillGroupCdMap_ = internalGetSkillGroupCdMap();
                result.skillGroupCdMap_.makeImmutable();
                result.curTactic_ = this.curTactic_;
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
                if (other instanceof SceneEntityAiInfo) {
                    return mergeFrom((SceneEntityAiInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(SceneEntityAiInfo other) {
                if (other == SceneEntityAiInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getIsAiOpen()) {
                    setIsAiOpen(other.getIsAiOpen());
                }
                if (other.hasBornPos()) {
                    mergeBornPos(other.getBornPos());
                }
                internalGetMutableSkillCdMap().mergeFrom(other.internalGetSkillCdMap());
                if (other.hasServantInfo()) {
                    mergeServantInfo(other.getServantInfo());
                }
                internalGetMutableAiThreatMap().mergeFrom(other.internalGetAiThreatMap());
                internalGetMutableSkillGroupCdMap().mergeFrom(other.internalGetSkillGroupCdMap());
                if (other.getCurTactic() != 0) {
                    setCurTactic(other.getCurTactic());
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
                SceneEntityAiInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = SceneEntityAiInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (SceneEntityAiInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.SceneEntityAiInfoOuterClass.SceneEntityAiInfoOrBuilder
            public boolean getIsAiOpen() {
                return this.isAiOpen_;
            }

            public Builder setIsAiOpen(boolean value) {
                this.isAiOpen_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsAiOpen() {
                this.isAiOpen_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SceneEntityAiInfoOuterClass.SceneEntityAiInfoOrBuilder
            public boolean hasBornPos() {
                return (this.bornPosBuilder_ == null && this.bornPos_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.SceneEntityAiInfoOuterClass.SceneEntityAiInfoOrBuilder
            public VectorOuterClass.Vector getBornPos() {
                if (this.bornPosBuilder_ == null) {
                    return this.bornPos_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.bornPos_;
                }
                return this.bornPosBuilder_.getMessage();
            }

            public Builder setBornPos(VectorOuterClass.Vector value) {
                if (this.bornPosBuilder_ != null) {
                    this.bornPosBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.bornPos_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setBornPos(VectorOuterClass.Vector.Builder builderForValue) {
                if (this.bornPosBuilder_ == null) {
                    this.bornPos_ = builderForValue.build();
                    onChanged();
                } else {
                    this.bornPosBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeBornPos(VectorOuterClass.Vector value) {
                if (this.bornPosBuilder_ == null) {
                    if (this.bornPos_ != null) {
                        this.bornPos_ = VectorOuterClass.Vector.newBuilder(this.bornPos_).mergeFrom(value).buildPartial();
                    } else {
                        this.bornPos_ = value;
                    }
                    onChanged();
                } else {
                    this.bornPosBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearBornPos() {
                if (this.bornPosBuilder_ == null) {
                    this.bornPos_ = null;
                    onChanged();
                } else {
                    this.bornPos_ = null;
                    this.bornPosBuilder_ = null;
                }
                return this;
            }

            public VectorOuterClass.Vector.Builder getBornPosBuilder() {
                onChanged();
                return getBornPosFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.SceneEntityAiInfoOuterClass.SceneEntityAiInfoOrBuilder
            public VectorOuterClass.VectorOrBuilder getBornPosOrBuilder() {
                if (this.bornPosBuilder_ != null) {
                    return this.bornPosBuilder_.getMessageOrBuilder();
                }
                return this.bornPos_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.bornPos_;
            }

            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> getBornPosFieldBuilder() {
                if (this.bornPosBuilder_ == null) {
                    this.bornPosBuilder_ = new SingleFieldBuilderV3<>(getBornPos(), getParentForChildren(), isClean());
                    this.bornPos_ = null;
                }
                return this.bornPosBuilder_;
            }

            private MapField<Integer, Integer> internalGetSkillCdMap() {
                if (this.skillCdMap_ == null) {
                    return MapField.emptyMapField(SkillCdMapDefaultEntryHolder.defaultEntry);
                }
                return this.skillCdMap_;
            }

            private MapField<Integer, Integer> internalGetMutableSkillCdMap() {
                onChanged();
                if (this.skillCdMap_ == null) {
                    this.skillCdMap_ = MapField.newMapField(SkillCdMapDefaultEntryHolder.defaultEntry);
                }
                if (!this.skillCdMap_.isMutable()) {
                    this.skillCdMap_ = this.skillCdMap_.copy();
                }
                return this.skillCdMap_;
            }

            @Override // emu.grasscutter.net.proto.SceneEntityAiInfoOuterClass.SceneEntityAiInfoOrBuilder
            public int getSkillCdMapCount() {
                return internalGetSkillCdMap().getMap().size();
            }

            @Override // emu.grasscutter.net.proto.SceneEntityAiInfoOuterClass.SceneEntityAiInfoOrBuilder
            public boolean containsSkillCdMap(int key) {
                return internalGetSkillCdMap().getMap().containsKey(Integer.valueOf(key));
            }

            @Override // emu.grasscutter.net.proto.SceneEntityAiInfoOuterClass.SceneEntityAiInfoOrBuilder
            @Deprecated
            public Map<Integer, Integer> getSkillCdMap() {
                return getSkillCdMapMap();
            }

            @Override // emu.grasscutter.net.proto.SceneEntityAiInfoOuterClass.SceneEntityAiInfoOrBuilder
            public Map<Integer, Integer> getSkillCdMapMap() {
                return internalGetSkillCdMap().getMap();
            }

            @Override // emu.grasscutter.net.proto.SceneEntityAiInfoOuterClass.SceneEntityAiInfoOrBuilder
            public int getSkillCdMapOrDefault(int key, int defaultValue) {
                Map<Integer, Integer> map = internalGetSkillCdMap().getMap();
                return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)).intValue() : defaultValue;
            }

            @Override // emu.grasscutter.net.proto.SceneEntityAiInfoOuterClass.SceneEntityAiInfoOrBuilder
            public int getSkillCdMapOrThrow(int key) {
                Map<Integer, Integer> map = internalGetSkillCdMap().getMap();
                if (map.containsKey(Integer.valueOf(key))) {
                    return map.get(Integer.valueOf(key)).intValue();
                }
                throw new IllegalArgumentException();
            }

            public Builder clearSkillCdMap() {
                internalGetMutableSkillCdMap().getMutableMap().clear();
                return this;
            }

            public Builder removeSkillCdMap(int key) {
                internalGetMutableSkillCdMap().getMutableMap().remove(Integer.valueOf(key));
                return this;
            }

            @Deprecated
            public Map<Integer, Integer> getMutableSkillCdMap() {
                return internalGetMutableSkillCdMap().getMutableMap();
            }

            public Builder putSkillCdMap(int key, int value) {
                internalGetMutableSkillCdMap().getMutableMap().put(Integer.valueOf(key), Integer.valueOf(value));
                return this;
            }

            public Builder putAllSkillCdMap(Map<Integer, Integer> values) {
                internalGetMutableSkillCdMap().getMutableMap().putAll(values);
                return this;
            }

            @Override // emu.grasscutter.net.proto.SceneEntityAiInfoOuterClass.SceneEntityAiInfoOrBuilder
            public boolean hasServantInfo() {
                return (this.servantInfoBuilder_ == null && this.servantInfo_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.SceneEntityAiInfoOuterClass.SceneEntityAiInfoOrBuilder
            public ServantInfoOuterClass.ServantInfo getServantInfo() {
                if (this.servantInfoBuilder_ == null) {
                    return this.servantInfo_ == null ? ServantInfoOuterClass.ServantInfo.getDefaultInstance() : this.servantInfo_;
                }
                return this.servantInfoBuilder_.getMessage();
            }

            public Builder setServantInfo(ServantInfoOuterClass.ServantInfo value) {
                if (this.servantInfoBuilder_ != null) {
                    this.servantInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.servantInfo_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setServantInfo(ServantInfoOuterClass.ServantInfo.Builder builderForValue) {
                if (this.servantInfoBuilder_ == null) {
                    this.servantInfo_ = builderForValue.build();
                    onChanged();
                } else {
                    this.servantInfoBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeServantInfo(ServantInfoOuterClass.ServantInfo value) {
                if (this.servantInfoBuilder_ == null) {
                    if (this.servantInfo_ != null) {
                        this.servantInfo_ = ServantInfoOuterClass.ServantInfo.newBuilder(this.servantInfo_).mergeFrom(value).buildPartial();
                    } else {
                        this.servantInfo_ = value;
                    }
                    onChanged();
                } else {
                    this.servantInfoBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearServantInfo() {
                if (this.servantInfoBuilder_ == null) {
                    this.servantInfo_ = null;
                    onChanged();
                } else {
                    this.servantInfo_ = null;
                    this.servantInfoBuilder_ = null;
                }
                return this;
            }

            public ServantInfoOuterClass.ServantInfo.Builder getServantInfoBuilder() {
                onChanged();
                return getServantInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.SceneEntityAiInfoOuterClass.SceneEntityAiInfoOrBuilder
            public ServantInfoOuterClass.ServantInfoOrBuilder getServantInfoOrBuilder() {
                if (this.servantInfoBuilder_ != null) {
                    return this.servantInfoBuilder_.getMessageOrBuilder();
                }
                return this.servantInfo_ == null ? ServantInfoOuterClass.ServantInfo.getDefaultInstance() : this.servantInfo_;
            }

            private SingleFieldBuilderV3<ServantInfoOuterClass.ServantInfo, ServantInfoOuterClass.ServantInfo.Builder, ServantInfoOuterClass.ServantInfoOrBuilder> getServantInfoFieldBuilder() {
                if (this.servantInfoBuilder_ == null) {
                    this.servantInfoBuilder_ = new SingleFieldBuilderV3<>(getServantInfo(), getParentForChildren(), isClean());
                    this.servantInfo_ = null;
                }
                return this.servantInfoBuilder_;
            }

            private MapField<Integer, Integer> internalGetAiThreatMap() {
                if (this.aiThreatMap_ == null) {
                    return MapField.emptyMapField(AiThreatMapDefaultEntryHolder.defaultEntry);
                }
                return this.aiThreatMap_;
            }

            private MapField<Integer, Integer> internalGetMutableAiThreatMap() {
                onChanged();
                if (this.aiThreatMap_ == null) {
                    this.aiThreatMap_ = MapField.newMapField(AiThreatMapDefaultEntryHolder.defaultEntry);
                }
                if (!this.aiThreatMap_.isMutable()) {
                    this.aiThreatMap_ = this.aiThreatMap_.copy();
                }
                return this.aiThreatMap_;
            }

            @Override // emu.grasscutter.net.proto.SceneEntityAiInfoOuterClass.SceneEntityAiInfoOrBuilder
            public int getAiThreatMapCount() {
                return internalGetAiThreatMap().getMap().size();
            }

            @Override // emu.grasscutter.net.proto.SceneEntityAiInfoOuterClass.SceneEntityAiInfoOrBuilder
            public boolean containsAiThreatMap(int key) {
                return internalGetAiThreatMap().getMap().containsKey(Integer.valueOf(key));
            }

            @Override // emu.grasscutter.net.proto.SceneEntityAiInfoOuterClass.SceneEntityAiInfoOrBuilder
            @Deprecated
            public Map<Integer, Integer> getAiThreatMap() {
                return getAiThreatMapMap();
            }

            @Override // emu.grasscutter.net.proto.SceneEntityAiInfoOuterClass.SceneEntityAiInfoOrBuilder
            public Map<Integer, Integer> getAiThreatMapMap() {
                return internalGetAiThreatMap().getMap();
            }

            @Override // emu.grasscutter.net.proto.SceneEntityAiInfoOuterClass.SceneEntityAiInfoOrBuilder
            public int getAiThreatMapOrDefault(int key, int defaultValue) {
                Map<Integer, Integer> map = internalGetAiThreatMap().getMap();
                return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)).intValue() : defaultValue;
            }

            @Override // emu.grasscutter.net.proto.SceneEntityAiInfoOuterClass.SceneEntityAiInfoOrBuilder
            public int getAiThreatMapOrThrow(int key) {
                Map<Integer, Integer> map = internalGetAiThreatMap().getMap();
                if (map.containsKey(Integer.valueOf(key))) {
                    return map.get(Integer.valueOf(key)).intValue();
                }
                throw new IllegalArgumentException();
            }

            public Builder clearAiThreatMap() {
                internalGetMutableAiThreatMap().getMutableMap().clear();
                return this;
            }

            public Builder removeAiThreatMap(int key) {
                internalGetMutableAiThreatMap().getMutableMap().remove(Integer.valueOf(key));
                return this;
            }

            @Deprecated
            public Map<Integer, Integer> getMutableAiThreatMap() {
                return internalGetMutableAiThreatMap().getMutableMap();
            }

            public Builder putAiThreatMap(int key, int value) {
                internalGetMutableAiThreatMap().getMutableMap().put(Integer.valueOf(key), Integer.valueOf(value));
                return this;
            }

            public Builder putAllAiThreatMap(Map<Integer, Integer> values) {
                internalGetMutableAiThreatMap().getMutableMap().putAll(values);
                return this;
            }

            private MapField<Integer, Integer> internalGetSkillGroupCdMap() {
                if (this.skillGroupCdMap_ == null) {
                    return MapField.emptyMapField(SkillGroupCdMapDefaultEntryHolder.defaultEntry);
                }
                return this.skillGroupCdMap_;
            }

            private MapField<Integer, Integer> internalGetMutableSkillGroupCdMap() {
                onChanged();
                if (this.skillGroupCdMap_ == null) {
                    this.skillGroupCdMap_ = MapField.newMapField(SkillGroupCdMapDefaultEntryHolder.defaultEntry);
                }
                if (!this.skillGroupCdMap_.isMutable()) {
                    this.skillGroupCdMap_ = this.skillGroupCdMap_.copy();
                }
                return this.skillGroupCdMap_;
            }

            @Override // emu.grasscutter.net.proto.SceneEntityAiInfoOuterClass.SceneEntityAiInfoOrBuilder
            public int getSkillGroupCdMapCount() {
                return internalGetSkillGroupCdMap().getMap().size();
            }

            @Override // emu.grasscutter.net.proto.SceneEntityAiInfoOuterClass.SceneEntityAiInfoOrBuilder
            public boolean containsSkillGroupCdMap(int key) {
                return internalGetSkillGroupCdMap().getMap().containsKey(Integer.valueOf(key));
            }

            @Override // emu.grasscutter.net.proto.SceneEntityAiInfoOuterClass.SceneEntityAiInfoOrBuilder
            @Deprecated
            public Map<Integer, Integer> getSkillGroupCdMap() {
                return getSkillGroupCdMapMap();
            }

            @Override // emu.grasscutter.net.proto.SceneEntityAiInfoOuterClass.SceneEntityAiInfoOrBuilder
            public Map<Integer, Integer> getSkillGroupCdMapMap() {
                return internalGetSkillGroupCdMap().getMap();
            }

            @Override // emu.grasscutter.net.proto.SceneEntityAiInfoOuterClass.SceneEntityAiInfoOrBuilder
            public int getSkillGroupCdMapOrDefault(int key, int defaultValue) {
                Map<Integer, Integer> map = internalGetSkillGroupCdMap().getMap();
                return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)).intValue() : defaultValue;
            }

            @Override // emu.grasscutter.net.proto.SceneEntityAiInfoOuterClass.SceneEntityAiInfoOrBuilder
            public int getSkillGroupCdMapOrThrow(int key) {
                Map<Integer, Integer> map = internalGetSkillGroupCdMap().getMap();
                if (map.containsKey(Integer.valueOf(key))) {
                    return map.get(Integer.valueOf(key)).intValue();
                }
                throw new IllegalArgumentException();
            }

            public Builder clearSkillGroupCdMap() {
                internalGetMutableSkillGroupCdMap().getMutableMap().clear();
                return this;
            }

            public Builder removeSkillGroupCdMap(int key) {
                internalGetMutableSkillGroupCdMap().getMutableMap().remove(Integer.valueOf(key));
                return this;
            }

            @Deprecated
            public Map<Integer, Integer> getMutableSkillGroupCdMap() {
                return internalGetMutableSkillGroupCdMap().getMutableMap();
            }

            public Builder putSkillGroupCdMap(int key, int value) {
                internalGetMutableSkillGroupCdMap().getMutableMap().put(Integer.valueOf(key), Integer.valueOf(value));
                return this;
            }

            public Builder putAllSkillGroupCdMap(Map<Integer, Integer> values) {
                internalGetMutableSkillGroupCdMap().getMutableMap().putAll(values);
                return this;
            }

            @Override // emu.grasscutter.net.proto.SceneEntityAiInfoOuterClass.SceneEntityAiInfoOrBuilder
            public int getCurTactic() {
                return this.curTactic_;
            }

            public Builder setCurTactic(int value) {
                this.curTactic_ = value;
                onChanged();
                return this;
            }

            public Builder clearCurTactic() {
                this.curTactic_ = 0;
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

        public static SceneEntityAiInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<SceneEntityAiInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<SceneEntityAiInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public SceneEntityAiInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        ServantInfoOuterClass.getDescriptor();
        VectorOuterClass.getDescriptor();
    }
}
