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
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.AbilitySyncStateInfoOuterClass;
import emu.grasscutter.net.proto.AnimatorParameterValueInfoPairOuterClass;
import emu.grasscutter.net.proto.EntityClientExtraInfoOuterClass;
import emu.grasscutter.net.proto.EntityRendererChangedInfoOuterClass;
import emu.grasscutter.net.proto.SceneEntityAiInfoOuterClass;
import emu.grasscutter.net.proto.VectorOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EntityAuthorityInfoOuterClass.class */
public final class EntityAuthorityInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0019EntityAuthorityInfo.proto\u001a\u001aAbilitySyncStateInfo.proto\u001a\u001fEntityRendererChangedInfo.proto\u001a\u0017SceneEntityAiInfo.proto\u001a\fVector.proto\u001a\u001bEntityClientExtraInfo.proto\u001a$AnimatorParameterValueInfoPair.proto\" \u0002\n\u0013EntityAuthorityInfo\u0012*\n\u000babilityInfo\u0018\u0001 \u0001(\u000b2\u0015.AbilitySyncStateInfo\u00127\n\u0013rendererChangedInfo\u0018\u0002 \u0001(\u000b2\u001a.EntityRendererChangedInfo\u0012\"\n\u0006aiInfo\u0018\u0003 \u0001(\u000b2\u0012.SceneEntityAiInfo\u0012\u0018\n\u0007bornPos\u0018\u0004 \u0001(\u000b2\u0007.Vector\u00125\n\fposeParaList\u0018\u0005 \u0003(\u000b2\u001f.AnimatorParameterValueInfoPair\u0012/\n\u000fclientExtraInfo\u0018\u0006 \u0001(\u000b2\u0016.EntityClientExtraInfoB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{AbilitySyncStateInfoOuterClass.getDescriptor(), EntityRendererChangedInfoOuterClass.getDescriptor(), SceneEntityAiInfoOuterClass.getDescriptor(), VectorOuterClass.getDescriptor(), EntityClientExtraInfoOuterClass.getDescriptor(), AnimatorParameterValueInfoPairOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_EntityAuthorityInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_EntityAuthorityInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_EntityAuthorityInfo_descriptor, new String[]{"AbilityInfo", "RendererChangedInfo", "AiInfo", "BornPos", "PoseParaList", "ClientExtraInfo"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EntityAuthorityInfoOuterClass$EntityAuthorityInfoOrBuilder.class */
    public interface EntityAuthorityInfoOrBuilder extends MessageOrBuilder {
        boolean hasAbilityInfo();

        AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo getAbilityInfo();

        AbilitySyncStateInfoOuterClass.AbilitySyncStateInfoOrBuilder getAbilityInfoOrBuilder();

        boolean hasRendererChangedInfo();

        EntityRendererChangedInfoOuterClass.EntityRendererChangedInfo getRendererChangedInfo();

        EntityRendererChangedInfoOuterClass.EntityRendererChangedInfoOrBuilder getRendererChangedInfoOrBuilder();

        boolean hasAiInfo();

        SceneEntityAiInfoOuterClass.SceneEntityAiInfo getAiInfo();

        SceneEntityAiInfoOuterClass.SceneEntityAiInfoOrBuilder getAiInfoOrBuilder();

        boolean hasBornPos();

        VectorOuterClass.Vector getBornPos();

        VectorOuterClass.VectorOrBuilder getBornPosOrBuilder();

        List<AnimatorParameterValueInfoPairOuterClass.AnimatorParameterValueInfoPair> getPoseParaListList();

        AnimatorParameterValueInfoPairOuterClass.AnimatorParameterValueInfoPair getPoseParaList(int i);

        int getPoseParaListCount();

        List<? extends AnimatorParameterValueInfoPairOuterClass.AnimatorParameterValueInfoPairOrBuilder> getPoseParaListOrBuilderList();

        AnimatorParameterValueInfoPairOuterClass.AnimatorParameterValueInfoPairOrBuilder getPoseParaListOrBuilder(int i);

        boolean hasClientExtraInfo();

        EntityClientExtraInfoOuterClass.EntityClientExtraInfo getClientExtraInfo();

        EntityClientExtraInfoOuterClass.EntityClientExtraInfoOrBuilder getClientExtraInfoOrBuilder();
    }

    private EntityAuthorityInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EntityAuthorityInfoOuterClass$EntityAuthorityInfo.class */
    public static final class EntityAuthorityInfo extends GeneratedMessageV3 implements EntityAuthorityInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int ABILITYINFO_FIELD_NUMBER = 1;
        private AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo abilityInfo_;
        public static final int RENDERERCHANGEDINFO_FIELD_NUMBER = 2;
        private EntityRendererChangedInfoOuterClass.EntityRendererChangedInfo rendererChangedInfo_;
        public static final int AIINFO_FIELD_NUMBER = 3;
        private SceneEntityAiInfoOuterClass.SceneEntityAiInfo aiInfo_;
        public static final int BORNPOS_FIELD_NUMBER = 4;
        private VectorOuterClass.Vector bornPos_;
        public static final int POSEPARALIST_FIELD_NUMBER = 5;
        private List<AnimatorParameterValueInfoPairOuterClass.AnimatorParameterValueInfoPair> poseParaList_;
        public static final int CLIENTEXTRAINFO_FIELD_NUMBER = 6;
        private EntityClientExtraInfoOuterClass.EntityClientExtraInfo clientExtraInfo_;
        private byte memoizedIsInitialized;
        private static final EntityAuthorityInfo DEFAULT_INSTANCE = new EntityAuthorityInfo();
        private static final Parser<EntityAuthorityInfo> PARSER = new AbstractParser<EntityAuthorityInfo>() { // from class: emu.grasscutter.net.proto.EntityAuthorityInfoOuterClass.EntityAuthorityInfo.1
            @Override // com.google.protobuf.Parser
            public EntityAuthorityInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new EntityAuthorityInfo(input, extensionRegistry);
            }
        };

        private EntityAuthorityInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private EntityAuthorityInfo() {
            this.memoizedIsInitialized = -1;
            this.poseParaList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new EntityAuthorityInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private EntityAuthorityInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo.Builder subBuilder = this.abilityInfo_ != null ? this.abilityInfo_.toBuilder() : null;
                                this.abilityInfo_ = (AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo) input.readMessage(AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo.parser(), extensionRegistry);
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.mergeFrom(this.abilityInfo_);
                                    this.abilityInfo_ = subBuilder.buildPartial();
                                    break;
                                }
                            case 18:
                                EntityRendererChangedInfoOuterClass.EntityRendererChangedInfo.Builder subBuilder2 = this.rendererChangedInfo_ != null ? this.rendererChangedInfo_.toBuilder() : null;
                                this.rendererChangedInfo_ = (EntityRendererChangedInfoOuterClass.EntityRendererChangedInfo) input.readMessage(EntityRendererChangedInfoOuterClass.EntityRendererChangedInfo.parser(), extensionRegistry);
                                if (subBuilder2 == null) {
                                    break;
                                } else {
                                    subBuilder2.mergeFrom(this.rendererChangedInfo_);
                                    this.rendererChangedInfo_ = subBuilder2.buildPartial();
                                    break;
                                }
                            case 26:
                                SceneEntityAiInfoOuterClass.SceneEntityAiInfo.Builder subBuilder3 = this.aiInfo_ != null ? this.aiInfo_.toBuilder() : null;
                                this.aiInfo_ = (SceneEntityAiInfoOuterClass.SceneEntityAiInfo) input.readMessage(SceneEntityAiInfoOuterClass.SceneEntityAiInfo.parser(), extensionRegistry);
                                if (subBuilder3 == null) {
                                    break;
                                } else {
                                    subBuilder3.mergeFrom(this.aiInfo_);
                                    this.aiInfo_ = subBuilder3.buildPartial();
                                    break;
                                }
                            case 34:
                                VectorOuterClass.Vector.Builder subBuilder4 = this.bornPos_ != null ? this.bornPos_.toBuilder() : null;
                                this.bornPos_ = (VectorOuterClass.Vector) input.readMessage(VectorOuterClass.Vector.parser(), extensionRegistry);
                                if (subBuilder4 == null) {
                                    break;
                                } else {
                                    subBuilder4.mergeFrom(this.bornPos_);
                                    this.bornPos_ = subBuilder4.buildPartial();
                                    break;
                                }
                            case 42:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.poseParaList_ = new ArrayList();
                                    mutable_bitField0_ |= 1;
                                }
                                this.poseParaList_.add((AnimatorParameterValueInfoPairOuterClass.AnimatorParameterValueInfoPair) input.readMessage(AnimatorParameterValueInfoPairOuterClass.AnimatorParameterValueInfoPair.parser(), extensionRegistry));
                                break;
                            case 50:
                                EntityClientExtraInfoOuterClass.EntityClientExtraInfo.Builder subBuilder5 = this.clientExtraInfo_ != null ? this.clientExtraInfo_.toBuilder() : null;
                                this.clientExtraInfo_ = (EntityClientExtraInfoOuterClass.EntityClientExtraInfo) input.readMessage(EntityClientExtraInfoOuterClass.EntityClientExtraInfo.parser(), extensionRegistry);
                                if (subBuilder5 == null) {
                                    break;
                                } else {
                                    subBuilder5.mergeFrom(this.clientExtraInfo_);
                                    this.clientExtraInfo_ = subBuilder5.buildPartial();
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
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(this);
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    }
                }
            } finally {
                if ((mutable_bitField0_ & 1) != 0) {
                    this.poseParaList_ = Collections.unmodifiableList(this.poseParaList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return EntityAuthorityInfoOuterClass.internal_static_EntityAuthorityInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return EntityAuthorityInfoOuterClass.internal_static_EntityAuthorityInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(EntityAuthorityInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.EntityAuthorityInfoOuterClass.EntityAuthorityInfoOrBuilder
        public boolean hasAbilityInfo() {
            return this.abilityInfo_ != null;
        }

        @Override // emu.grasscutter.net.proto.EntityAuthorityInfoOuterClass.EntityAuthorityInfoOrBuilder
        public AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo getAbilityInfo() {
            return this.abilityInfo_ == null ? AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo.getDefaultInstance() : this.abilityInfo_;
        }

        @Override // emu.grasscutter.net.proto.EntityAuthorityInfoOuterClass.EntityAuthorityInfoOrBuilder
        public AbilitySyncStateInfoOuterClass.AbilitySyncStateInfoOrBuilder getAbilityInfoOrBuilder() {
            return getAbilityInfo();
        }

        @Override // emu.grasscutter.net.proto.EntityAuthorityInfoOuterClass.EntityAuthorityInfoOrBuilder
        public boolean hasRendererChangedInfo() {
            return this.rendererChangedInfo_ != null;
        }

        @Override // emu.grasscutter.net.proto.EntityAuthorityInfoOuterClass.EntityAuthorityInfoOrBuilder
        public EntityRendererChangedInfoOuterClass.EntityRendererChangedInfo getRendererChangedInfo() {
            return this.rendererChangedInfo_ == null ? EntityRendererChangedInfoOuterClass.EntityRendererChangedInfo.getDefaultInstance() : this.rendererChangedInfo_;
        }

        @Override // emu.grasscutter.net.proto.EntityAuthorityInfoOuterClass.EntityAuthorityInfoOrBuilder
        public EntityRendererChangedInfoOuterClass.EntityRendererChangedInfoOrBuilder getRendererChangedInfoOrBuilder() {
            return getRendererChangedInfo();
        }

        @Override // emu.grasscutter.net.proto.EntityAuthorityInfoOuterClass.EntityAuthorityInfoOrBuilder
        public boolean hasAiInfo() {
            return this.aiInfo_ != null;
        }

        @Override // emu.grasscutter.net.proto.EntityAuthorityInfoOuterClass.EntityAuthorityInfoOrBuilder
        public SceneEntityAiInfoOuterClass.SceneEntityAiInfo getAiInfo() {
            return this.aiInfo_ == null ? SceneEntityAiInfoOuterClass.SceneEntityAiInfo.getDefaultInstance() : this.aiInfo_;
        }

        @Override // emu.grasscutter.net.proto.EntityAuthorityInfoOuterClass.EntityAuthorityInfoOrBuilder
        public SceneEntityAiInfoOuterClass.SceneEntityAiInfoOrBuilder getAiInfoOrBuilder() {
            return getAiInfo();
        }

        @Override // emu.grasscutter.net.proto.EntityAuthorityInfoOuterClass.EntityAuthorityInfoOrBuilder
        public boolean hasBornPos() {
            return this.bornPos_ != null;
        }

        @Override // emu.grasscutter.net.proto.EntityAuthorityInfoOuterClass.EntityAuthorityInfoOrBuilder
        public VectorOuterClass.Vector getBornPos() {
            return this.bornPos_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.bornPos_;
        }

        @Override // emu.grasscutter.net.proto.EntityAuthorityInfoOuterClass.EntityAuthorityInfoOrBuilder
        public VectorOuterClass.VectorOrBuilder getBornPosOrBuilder() {
            return getBornPos();
        }

        @Override // emu.grasscutter.net.proto.EntityAuthorityInfoOuterClass.EntityAuthorityInfoOrBuilder
        public List<AnimatorParameterValueInfoPairOuterClass.AnimatorParameterValueInfoPair> getPoseParaListList() {
            return this.poseParaList_;
        }

        @Override // emu.grasscutter.net.proto.EntityAuthorityInfoOuterClass.EntityAuthorityInfoOrBuilder
        public List<? extends AnimatorParameterValueInfoPairOuterClass.AnimatorParameterValueInfoPairOrBuilder> getPoseParaListOrBuilderList() {
            return this.poseParaList_;
        }

        @Override // emu.grasscutter.net.proto.EntityAuthorityInfoOuterClass.EntityAuthorityInfoOrBuilder
        public int getPoseParaListCount() {
            return this.poseParaList_.size();
        }

        @Override // emu.grasscutter.net.proto.EntityAuthorityInfoOuterClass.EntityAuthorityInfoOrBuilder
        public AnimatorParameterValueInfoPairOuterClass.AnimatorParameterValueInfoPair getPoseParaList(int index) {
            return this.poseParaList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.EntityAuthorityInfoOuterClass.EntityAuthorityInfoOrBuilder
        public AnimatorParameterValueInfoPairOuterClass.AnimatorParameterValueInfoPairOrBuilder getPoseParaListOrBuilder(int index) {
            return this.poseParaList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.EntityAuthorityInfoOuterClass.EntityAuthorityInfoOrBuilder
        public boolean hasClientExtraInfo() {
            return this.clientExtraInfo_ != null;
        }

        @Override // emu.grasscutter.net.proto.EntityAuthorityInfoOuterClass.EntityAuthorityInfoOrBuilder
        public EntityClientExtraInfoOuterClass.EntityClientExtraInfo getClientExtraInfo() {
            return this.clientExtraInfo_ == null ? EntityClientExtraInfoOuterClass.EntityClientExtraInfo.getDefaultInstance() : this.clientExtraInfo_;
        }

        @Override // emu.grasscutter.net.proto.EntityAuthorityInfoOuterClass.EntityAuthorityInfoOrBuilder
        public EntityClientExtraInfoOuterClass.EntityClientExtraInfoOrBuilder getClientExtraInfoOrBuilder() {
            return getClientExtraInfo();
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
            if (this.abilityInfo_ != null) {
                output.writeMessage(1, getAbilityInfo());
            }
            if (this.rendererChangedInfo_ != null) {
                output.writeMessage(2, getRendererChangedInfo());
            }
            if (this.aiInfo_ != null) {
                output.writeMessage(3, getAiInfo());
            }
            if (this.bornPos_ != null) {
                output.writeMessage(4, getBornPos());
            }
            for (int i = 0; i < this.poseParaList_.size(); i++) {
                output.writeMessage(5, this.poseParaList_.get(i));
            }
            if (this.clientExtraInfo_ != null) {
                output.writeMessage(6, getClientExtraInfo());
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
            if (this.abilityInfo_ != null) {
                size2 = 0 + CodedOutputStream.computeMessageSize(1, getAbilityInfo());
            }
            if (this.rendererChangedInfo_ != null) {
                size2 += CodedOutputStream.computeMessageSize(2, getRendererChangedInfo());
            }
            if (this.aiInfo_ != null) {
                size2 += CodedOutputStream.computeMessageSize(3, getAiInfo());
            }
            if (this.bornPos_ != null) {
                size2 += CodedOutputStream.computeMessageSize(4, getBornPos());
            }
            for (int i = 0; i < this.poseParaList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(5, this.poseParaList_.get(i));
            }
            if (this.clientExtraInfo_ != null) {
                size2 += CodedOutputStream.computeMessageSize(6, getClientExtraInfo());
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
            if (!(obj instanceof EntityAuthorityInfo)) {
                return equals(obj);
            }
            EntityAuthorityInfo other = (EntityAuthorityInfo) obj;
            if (hasAbilityInfo() != other.hasAbilityInfo()) {
                return false;
            }
            if ((hasAbilityInfo() && !getAbilityInfo().equals(other.getAbilityInfo())) || hasRendererChangedInfo() != other.hasRendererChangedInfo()) {
                return false;
            }
            if ((hasRendererChangedInfo() && !getRendererChangedInfo().equals(other.getRendererChangedInfo())) || hasAiInfo() != other.hasAiInfo()) {
                return false;
            }
            if ((hasAiInfo() && !getAiInfo().equals(other.getAiInfo())) || hasBornPos() != other.hasBornPos()) {
                return false;
            }
            if ((!hasBornPos() || getBornPos().equals(other.getBornPos())) && getPoseParaListList().equals(other.getPoseParaListList()) && hasClientExtraInfo() == other.hasClientExtraInfo()) {
                return (!hasClientExtraInfo() || getClientExtraInfo().equals(other.getClientExtraInfo())) && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (hasAbilityInfo()) {
                hash = (53 * ((37 * hash) + 1)) + getAbilityInfo().hashCode();
            }
            if (hasRendererChangedInfo()) {
                hash = (53 * ((37 * hash) + 2)) + getRendererChangedInfo().hashCode();
            }
            if (hasAiInfo()) {
                hash = (53 * ((37 * hash) + 3)) + getAiInfo().hashCode();
            }
            if (hasBornPos()) {
                hash = (53 * ((37 * hash) + 4)) + getBornPos().hashCode();
            }
            if (getPoseParaListCount() > 0) {
                hash = (53 * ((37 * hash) + 5)) + getPoseParaListList().hashCode();
            }
            if (hasClientExtraInfo()) {
                hash = (53 * ((37 * hash) + 6)) + getClientExtraInfo().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static EntityAuthorityInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static EntityAuthorityInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static EntityAuthorityInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static EntityAuthorityInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static EntityAuthorityInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static EntityAuthorityInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static EntityAuthorityInfo parseFrom(InputStream input) throws IOException {
            return (EntityAuthorityInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static EntityAuthorityInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EntityAuthorityInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static EntityAuthorityInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (EntityAuthorityInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static EntityAuthorityInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EntityAuthorityInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static EntityAuthorityInfo parseFrom(CodedInputStream input) throws IOException {
            return (EntityAuthorityInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static EntityAuthorityInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EntityAuthorityInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(EntityAuthorityInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EntityAuthorityInfoOuterClass$EntityAuthorityInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements EntityAuthorityInfoOrBuilder {
            private int bitField0_;
            private AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo abilityInfo_;
            private SingleFieldBuilderV3<AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo, AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo.Builder, AbilitySyncStateInfoOuterClass.AbilitySyncStateInfoOrBuilder> abilityInfoBuilder_;
            private EntityRendererChangedInfoOuterClass.EntityRendererChangedInfo rendererChangedInfo_;
            private SingleFieldBuilderV3<EntityRendererChangedInfoOuterClass.EntityRendererChangedInfo, EntityRendererChangedInfoOuterClass.EntityRendererChangedInfo.Builder, EntityRendererChangedInfoOuterClass.EntityRendererChangedInfoOrBuilder> rendererChangedInfoBuilder_;
            private SceneEntityAiInfoOuterClass.SceneEntityAiInfo aiInfo_;
            private SingleFieldBuilderV3<SceneEntityAiInfoOuterClass.SceneEntityAiInfo, SceneEntityAiInfoOuterClass.SceneEntityAiInfo.Builder, SceneEntityAiInfoOuterClass.SceneEntityAiInfoOrBuilder> aiInfoBuilder_;
            private VectorOuterClass.Vector bornPos_;
            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> bornPosBuilder_;
            private List<AnimatorParameterValueInfoPairOuterClass.AnimatorParameterValueInfoPair> poseParaList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<AnimatorParameterValueInfoPairOuterClass.AnimatorParameterValueInfoPair, AnimatorParameterValueInfoPairOuterClass.AnimatorParameterValueInfoPair.Builder, AnimatorParameterValueInfoPairOuterClass.AnimatorParameterValueInfoPairOrBuilder> poseParaListBuilder_;
            private EntityClientExtraInfoOuterClass.EntityClientExtraInfo clientExtraInfo_;
            private SingleFieldBuilderV3<EntityClientExtraInfoOuterClass.EntityClientExtraInfo, EntityClientExtraInfoOuterClass.EntityClientExtraInfo.Builder, EntityClientExtraInfoOuterClass.EntityClientExtraInfoOrBuilder> clientExtraInfoBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return EntityAuthorityInfoOuterClass.internal_static_EntityAuthorityInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return EntityAuthorityInfoOuterClass.internal_static_EntityAuthorityInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(EntityAuthorityInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (EntityAuthorityInfo.alwaysUseFieldBuilders) {
                    getPoseParaListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.abilityInfoBuilder_ == null) {
                    this.abilityInfo_ = null;
                } else {
                    this.abilityInfo_ = null;
                    this.abilityInfoBuilder_ = null;
                }
                if (this.rendererChangedInfoBuilder_ == null) {
                    this.rendererChangedInfo_ = null;
                } else {
                    this.rendererChangedInfo_ = null;
                    this.rendererChangedInfoBuilder_ = null;
                }
                if (this.aiInfoBuilder_ == null) {
                    this.aiInfo_ = null;
                } else {
                    this.aiInfo_ = null;
                    this.aiInfoBuilder_ = null;
                }
                if (this.bornPosBuilder_ == null) {
                    this.bornPos_ = null;
                } else {
                    this.bornPos_ = null;
                    this.bornPosBuilder_ = null;
                }
                if (this.poseParaListBuilder_ == null) {
                    this.poseParaList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.poseParaListBuilder_.clear();
                }
                if (this.clientExtraInfoBuilder_ == null) {
                    this.clientExtraInfo_ = null;
                } else {
                    this.clientExtraInfo_ = null;
                    this.clientExtraInfoBuilder_ = null;
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return EntityAuthorityInfoOuterClass.internal_static_EntityAuthorityInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public EntityAuthorityInfo getDefaultInstanceForType() {
                return EntityAuthorityInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public EntityAuthorityInfo build() {
                EntityAuthorityInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public EntityAuthorityInfo buildPartial() {
                EntityAuthorityInfo result = new EntityAuthorityInfo(this);
                int i = this.bitField0_;
                if (this.abilityInfoBuilder_ == null) {
                    result.abilityInfo_ = this.abilityInfo_;
                } else {
                    result.abilityInfo_ = this.abilityInfoBuilder_.build();
                }
                if (this.rendererChangedInfoBuilder_ == null) {
                    result.rendererChangedInfo_ = this.rendererChangedInfo_;
                } else {
                    result.rendererChangedInfo_ = this.rendererChangedInfoBuilder_.build();
                }
                if (this.aiInfoBuilder_ == null) {
                    result.aiInfo_ = this.aiInfo_;
                } else {
                    result.aiInfo_ = this.aiInfoBuilder_.build();
                }
                if (this.bornPosBuilder_ == null) {
                    result.bornPos_ = this.bornPos_;
                } else {
                    result.bornPos_ = this.bornPosBuilder_.build();
                }
                if (this.poseParaListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.poseParaList_ = Collections.unmodifiableList(this.poseParaList_);
                        this.bitField0_ &= -2;
                    }
                    result.poseParaList_ = this.poseParaList_;
                } else {
                    result.poseParaList_ = this.poseParaListBuilder_.build();
                }
                if (this.clientExtraInfoBuilder_ == null) {
                    result.clientExtraInfo_ = this.clientExtraInfo_;
                } else {
                    result.clientExtraInfo_ = this.clientExtraInfoBuilder_.build();
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
                if (other instanceof EntityAuthorityInfo) {
                    return mergeFrom((EntityAuthorityInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(EntityAuthorityInfo other) {
                if (other == EntityAuthorityInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.hasAbilityInfo()) {
                    mergeAbilityInfo(other.getAbilityInfo());
                }
                if (other.hasRendererChangedInfo()) {
                    mergeRendererChangedInfo(other.getRendererChangedInfo());
                }
                if (other.hasAiInfo()) {
                    mergeAiInfo(other.getAiInfo());
                }
                if (other.hasBornPos()) {
                    mergeBornPos(other.getBornPos());
                }
                if (this.poseParaListBuilder_ == null) {
                    if (!other.poseParaList_.isEmpty()) {
                        if (this.poseParaList_.isEmpty()) {
                            this.poseParaList_ = other.poseParaList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensurePoseParaListIsMutable();
                            this.poseParaList_.addAll(other.poseParaList_);
                        }
                        onChanged();
                    }
                } else if (!other.poseParaList_.isEmpty()) {
                    if (this.poseParaListBuilder_.isEmpty()) {
                        this.poseParaListBuilder_.dispose();
                        this.poseParaListBuilder_ = null;
                        this.poseParaList_ = other.poseParaList_;
                        this.bitField0_ &= -2;
                        this.poseParaListBuilder_ = EntityAuthorityInfo.alwaysUseFieldBuilders ? getPoseParaListFieldBuilder() : null;
                    } else {
                        this.poseParaListBuilder_.addAllMessages(other.poseParaList_);
                    }
                }
                if (other.hasClientExtraInfo()) {
                    mergeClientExtraInfo(other.getClientExtraInfo());
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
                EntityAuthorityInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = EntityAuthorityInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (EntityAuthorityInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.EntityAuthorityInfoOuterClass.EntityAuthorityInfoOrBuilder
            public boolean hasAbilityInfo() {
                return (this.abilityInfoBuilder_ == null && this.abilityInfo_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.EntityAuthorityInfoOuterClass.EntityAuthorityInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.EntityAuthorityInfoOuterClass.EntityAuthorityInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.EntityAuthorityInfoOuterClass.EntityAuthorityInfoOrBuilder
            public boolean hasRendererChangedInfo() {
                return (this.rendererChangedInfoBuilder_ == null && this.rendererChangedInfo_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.EntityAuthorityInfoOuterClass.EntityAuthorityInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.EntityAuthorityInfoOuterClass.EntityAuthorityInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.EntityAuthorityInfoOuterClass.EntityAuthorityInfoOrBuilder
            public boolean hasAiInfo() {
                return (this.aiInfoBuilder_ == null && this.aiInfo_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.EntityAuthorityInfoOuterClass.EntityAuthorityInfoOrBuilder
            public SceneEntityAiInfoOuterClass.SceneEntityAiInfo getAiInfo() {
                if (this.aiInfoBuilder_ == null) {
                    return this.aiInfo_ == null ? SceneEntityAiInfoOuterClass.SceneEntityAiInfo.getDefaultInstance() : this.aiInfo_;
                }
                return this.aiInfoBuilder_.getMessage();
            }

            public Builder setAiInfo(SceneEntityAiInfoOuterClass.SceneEntityAiInfo value) {
                if (this.aiInfoBuilder_ != null) {
                    this.aiInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.aiInfo_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setAiInfo(SceneEntityAiInfoOuterClass.SceneEntityAiInfo.Builder builderForValue) {
                if (this.aiInfoBuilder_ == null) {
                    this.aiInfo_ = builderForValue.build();
                    onChanged();
                } else {
                    this.aiInfoBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeAiInfo(SceneEntityAiInfoOuterClass.SceneEntityAiInfo value) {
                if (this.aiInfoBuilder_ == null) {
                    if (this.aiInfo_ != null) {
                        this.aiInfo_ = SceneEntityAiInfoOuterClass.SceneEntityAiInfo.newBuilder(this.aiInfo_).mergeFrom(value).buildPartial();
                    } else {
                        this.aiInfo_ = value;
                    }
                    onChanged();
                } else {
                    this.aiInfoBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearAiInfo() {
                if (this.aiInfoBuilder_ == null) {
                    this.aiInfo_ = null;
                    onChanged();
                } else {
                    this.aiInfo_ = null;
                    this.aiInfoBuilder_ = null;
                }
                return this;
            }

            public SceneEntityAiInfoOuterClass.SceneEntityAiInfo.Builder getAiInfoBuilder() {
                onChanged();
                return getAiInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.EntityAuthorityInfoOuterClass.EntityAuthorityInfoOrBuilder
            public SceneEntityAiInfoOuterClass.SceneEntityAiInfoOrBuilder getAiInfoOrBuilder() {
                if (this.aiInfoBuilder_ != null) {
                    return this.aiInfoBuilder_.getMessageOrBuilder();
                }
                return this.aiInfo_ == null ? SceneEntityAiInfoOuterClass.SceneEntityAiInfo.getDefaultInstance() : this.aiInfo_;
            }

            private SingleFieldBuilderV3<SceneEntityAiInfoOuterClass.SceneEntityAiInfo, SceneEntityAiInfoOuterClass.SceneEntityAiInfo.Builder, SceneEntityAiInfoOuterClass.SceneEntityAiInfoOrBuilder> getAiInfoFieldBuilder() {
                if (this.aiInfoBuilder_ == null) {
                    this.aiInfoBuilder_ = new SingleFieldBuilderV3<>(getAiInfo(), getParentForChildren(), isClean());
                    this.aiInfo_ = null;
                }
                return this.aiInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.EntityAuthorityInfoOuterClass.EntityAuthorityInfoOrBuilder
            public boolean hasBornPos() {
                return (this.bornPosBuilder_ == null && this.bornPos_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.EntityAuthorityInfoOuterClass.EntityAuthorityInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.EntityAuthorityInfoOuterClass.EntityAuthorityInfoOrBuilder
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

            private void ensurePoseParaListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.poseParaList_ = new ArrayList(this.poseParaList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.EntityAuthorityInfoOuterClass.EntityAuthorityInfoOrBuilder
            public List<AnimatorParameterValueInfoPairOuterClass.AnimatorParameterValueInfoPair> getPoseParaListList() {
                if (this.poseParaListBuilder_ == null) {
                    return Collections.unmodifiableList(this.poseParaList_);
                }
                return this.poseParaListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.EntityAuthorityInfoOuterClass.EntityAuthorityInfoOrBuilder
            public int getPoseParaListCount() {
                if (this.poseParaListBuilder_ == null) {
                    return this.poseParaList_.size();
                }
                return this.poseParaListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.EntityAuthorityInfoOuterClass.EntityAuthorityInfoOrBuilder
            public AnimatorParameterValueInfoPairOuterClass.AnimatorParameterValueInfoPair getPoseParaList(int index) {
                if (this.poseParaListBuilder_ == null) {
                    return this.poseParaList_.get(index);
                }
                return this.poseParaListBuilder_.getMessage(index);
            }

            public Builder setPoseParaList(int index, AnimatorParameterValueInfoPairOuterClass.AnimatorParameterValueInfoPair value) {
                if (this.poseParaListBuilder_ != null) {
                    this.poseParaListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensurePoseParaListIsMutable();
                    this.poseParaList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setPoseParaList(int index, AnimatorParameterValueInfoPairOuterClass.AnimatorParameterValueInfoPair.Builder builderForValue) {
                if (this.poseParaListBuilder_ == null) {
                    ensurePoseParaListIsMutable();
                    this.poseParaList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.poseParaListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addPoseParaList(AnimatorParameterValueInfoPairOuterClass.AnimatorParameterValueInfoPair value) {
                if (this.poseParaListBuilder_ != null) {
                    this.poseParaListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensurePoseParaListIsMutable();
                    this.poseParaList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addPoseParaList(int index, AnimatorParameterValueInfoPairOuterClass.AnimatorParameterValueInfoPair value) {
                if (this.poseParaListBuilder_ != null) {
                    this.poseParaListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensurePoseParaListIsMutable();
                    this.poseParaList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addPoseParaList(AnimatorParameterValueInfoPairOuterClass.AnimatorParameterValueInfoPair.Builder builderForValue) {
                if (this.poseParaListBuilder_ == null) {
                    ensurePoseParaListIsMutable();
                    this.poseParaList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.poseParaListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addPoseParaList(int index, AnimatorParameterValueInfoPairOuterClass.AnimatorParameterValueInfoPair.Builder builderForValue) {
                if (this.poseParaListBuilder_ == null) {
                    ensurePoseParaListIsMutable();
                    this.poseParaList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.poseParaListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllPoseParaList(Iterable<? extends AnimatorParameterValueInfoPairOuterClass.AnimatorParameterValueInfoPair> values) {
                if (this.poseParaListBuilder_ == null) {
                    ensurePoseParaListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.poseParaList_);
                    onChanged();
                } else {
                    this.poseParaListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearPoseParaList() {
                if (this.poseParaListBuilder_ == null) {
                    this.poseParaList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.poseParaListBuilder_.clear();
                }
                return this;
            }

            public Builder removePoseParaList(int index) {
                if (this.poseParaListBuilder_ == null) {
                    ensurePoseParaListIsMutable();
                    this.poseParaList_.remove(index);
                    onChanged();
                } else {
                    this.poseParaListBuilder_.remove(index);
                }
                return this;
            }

            public AnimatorParameterValueInfoPairOuterClass.AnimatorParameterValueInfoPair.Builder getPoseParaListBuilder(int index) {
                return getPoseParaListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.EntityAuthorityInfoOuterClass.EntityAuthorityInfoOrBuilder
            public AnimatorParameterValueInfoPairOuterClass.AnimatorParameterValueInfoPairOrBuilder getPoseParaListOrBuilder(int index) {
                if (this.poseParaListBuilder_ == null) {
                    return this.poseParaList_.get(index);
                }
                return this.poseParaListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.EntityAuthorityInfoOuterClass.EntityAuthorityInfoOrBuilder
            public List<? extends AnimatorParameterValueInfoPairOuterClass.AnimatorParameterValueInfoPairOrBuilder> getPoseParaListOrBuilderList() {
                if (this.poseParaListBuilder_ != null) {
                    return this.poseParaListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.poseParaList_);
            }

            public AnimatorParameterValueInfoPairOuterClass.AnimatorParameterValueInfoPair.Builder addPoseParaListBuilder() {
                return getPoseParaListFieldBuilder().addBuilder(AnimatorParameterValueInfoPairOuterClass.AnimatorParameterValueInfoPair.getDefaultInstance());
            }

            public AnimatorParameterValueInfoPairOuterClass.AnimatorParameterValueInfoPair.Builder addPoseParaListBuilder(int index) {
                return getPoseParaListFieldBuilder().addBuilder(index, AnimatorParameterValueInfoPairOuterClass.AnimatorParameterValueInfoPair.getDefaultInstance());
            }

            public List<AnimatorParameterValueInfoPairOuterClass.AnimatorParameterValueInfoPair.Builder> getPoseParaListBuilderList() {
                return getPoseParaListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<AnimatorParameterValueInfoPairOuterClass.AnimatorParameterValueInfoPair, AnimatorParameterValueInfoPairOuterClass.AnimatorParameterValueInfoPair.Builder, AnimatorParameterValueInfoPairOuterClass.AnimatorParameterValueInfoPairOrBuilder> getPoseParaListFieldBuilder() {
                if (this.poseParaListBuilder_ == null) {
                    this.poseParaListBuilder_ = new RepeatedFieldBuilderV3<>(this.poseParaList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.poseParaList_ = null;
                }
                return this.poseParaListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.EntityAuthorityInfoOuterClass.EntityAuthorityInfoOrBuilder
            public boolean hasClientExtraInfo() {
                return (this.clientExtraInfoBuilder_ == null && this.clientExtraInfo_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.EntityAuthorityInfoOuterClass.EntityAuthorityInfoOrBuilder
            public EntityClientExtraInfoOuterClass.EntityClientExtraInfo getClientExtraInfo() {
                if (this.clientExtraInfoBuilder_ == null) {
                    return this.clientExtraInfo_ == null ? EntityClientExtraInfoOuterClass.EntityClientExtraInfo.getDefaultInstance() : this.clientExtraInfo_;
                }
                return this.clientExtraInfoBuilder_.getMessage();
            }

            public Builder setClientExtraInfo(EntityClientExtraInfoOuterClass.EntityClientExtraInfo value) {
                if (this.clientExtraInfoBuilder_ != null) {
                    this.clientExtraInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.clientExtraInfo_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setClientExtraInfo(EntityClientExtraInfoOuterClass.EntityClientExtraInfo.Builder builderForValue) {
                if (this.clientExtraInfoBuilder_ == null) {
                    this.clientExtraInfo_ = builderForValue.build();
                    onChanged();
                } else {
                    this.clientExtraInfoBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeClientExtraInfo(EntityClientExtraInfoOuterClass.EntityClientExtraInfo value) {
                if (this.clientExtraInfoBuilder_ == null) {
                    if (this.clientExtraInfo_ != null) {
                        this.clientExtraInfo_ = EntityClientExtraInfoOuterClass.EntityClientExtraInfo.newBuilder(this.clientExtraInfo_).mergeFrom(value).buildPartial();
                    } else {
                        this.clientExtraInfo_ = value;
                    }
                    onChanged();
                } else {
                    this.clientExtraInfoBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearClientExtraInfo() {
                if (this.clientExtraInfoBuilder_ == null) {
                    this.clientExtraInfo_ = null;
                    onChanged();
                } else {
                    this.clientExtraInfo_ = null;
                    this.clientExtraInfoBuilder_ = null;
                }
                return this;
            }

            public EntityClientExtraInfoOuterClass.EntityClientExtraInfo.Builder getClientExtraInfoBuilder() {
                onChanged();
                return getClientExtraInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.EntityAuthorityInfoOuterClass.EntityAuthorityInfoOrBuilder
            public EntityClientExtraInfoOuterClass.EntityClientExtraInfoOrBuilder getClientExtraInfoOrBuilder() {
                if (this.clientExtraInfoBuilder_ != null) {
                    return this.clientExtraInfoBuilder_.getMessageOrBuilder();
                }
                return this.clientExtraInfo_ == null ? EntityClientExtraInfoOuterClass.EntityClientExtraInfo.getDefaultInstance() : this.clientExtraInfo_;
            }

            private SingleFieldBuilderV3<EntityClientExtraInfoOuterClass.EntityClientExtraInfo, EntityClientExtraInfoOuterClass.EntityClientExtraInfo.Builder, EntityClientExtraInfoOuterClass.EntityClientExtraInfoOrBuilder> getClientExtraInfoFieldBuilder() {
                if (this.clientExtraInfoBuilder_ == null) {
                    this.clientExtraInfoBuilder_ = new SingleFieldBuilderV3<>(getClientExtraInfo(), getParentForChildren(), isClean());
                    this.clientExtraInfo_ = null;
                }
                return this.clientExtraInfoBuilder_;
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

        public static EntityAuthorityInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<EntityAuthorityInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<EntityAuthorityInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public EntityAuthorityInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        AbilitySyncStateInfoOuterClass.getDescriptor();
        EntityRendererChangedInfoOuterClass.getDescriptor();
        SceneEntityAiInfoOuterClass.getDescriptor();
        VectorOuterClass.getDescriptor();
        EntityClientExtraInfoOuterClass.getDescriptor();
        AnimatorParameterValueInfoPairOuterClass.getDescriptor();
    }
}
