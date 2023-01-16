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
import emu.grasscutter.net.proto.AbilityScalarValueEntryOuterClass;
import emu.grasscutter.net.proto.AbilityStringOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AbilityAppliedAbilityOuterClass.class */
public final class AbilityAppliedAbilityOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001bAbilityAppliedAbility.proto\u001a\u001dAbilityScalarValueEntry.proto\u001a\u0013AbilityString.proto\"µ\u0001\n\u0015AbilityAppliedAbility\u0012$\n\fability_name\u0018\u0001 \u0001(\u000b2\u000e.AbilityString\u0012(\n\u0010ability_override\u0018\u0002 \u0001(\u000b2\u000e.AbilityString\u0012.\n\foverride_map\u0018\u0003 \u0003(\u000b2\u0018.AbilityScalarValueEntry\u0012\u001c\n\u0014instanced_ability_id\u0018\u0004 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{AbilityScalarValueEntryOuterClass.getDescriptor(), AbilityStringOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_AbilityAppliedAbility_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_AbilityAppliedAbility_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_AbilityAppliedAbility_descriptor, new String[]{"AbilityName", "AbilityOverride", "OverrideMap", "InstancedAbilityId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AbilityAppliedAbilityOuterClass$AbilityAppliedAbilityOrBuilder.class */
    public interface AbilityAppliedAbilityOrBuilder extends MessageOrBuilder {
        boolean hasAbilityName();

        AbilityStringOuterClass.AbilityString getAbilityName();

        AbilityStringOuterClass.AbilityStringOrBuilder getAbilityNameOrBuilder();

        boolean hasAbilityOverride();

        AbilityStringOuterClass.AbilityString getAbilityOverride();

        AbilityStringOuterClass.AbilityStringOrBuilder getAbilityOverrideOrBuilder();

        List<AbilityScalarValueEntryOuterClass.AbilityScalarValueEntry> getOverrideMapList();

        AbilityScalarValueEntryOuterClass.AbilityScalarValueEntry getOverrideMap(int i);

        int getOverrideMapCount();

        List<? extends AbilityScalarValueEntryOuterClass.AbilityScalarValueEntryOrBuilder> getOverrideMapOrBuilderList();

        AbilityScalarValueEntryOuterClass.AbilityScalarValueEntryOrBuilder getOverrideMapOrBuilder(int i);

        int getInstancedAbilityId();
    }

    private AbilityAppliedAbilityOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AbilityAppliedAbilityOuterClass$AbilityAppliedAbility.class */
    public static final class AbilityAppliedAbility extends GeneratedMessageV3 implements AbilityAppliedAbilityOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int ABILITY_NAME_FIELD_NUMBER = 1;
        private AbilityStringOuterClass.AbilityString abilityName_;
        public static final int ABILITY_OVERRIDE_FIELD_NUMBER = 2;
        private AbilityStringOuterClass.AbilityString abilityOverride_;
        public static final int OVERRIDE_MAP_FIELD_NUMBER = 3;
        private List<AbilityScalarValueEntryOuterClass.AbilityScalarValueEntry> overrideMap_;
        public static final int INSTANCED_ABILITY_ID_FIELD_NUMBER = 4;
        private int instancedAbilityId_;
        private byte memoizedIsInitialized;
        private static final AbilityAppliedAbility DEFAULT_INSTANCE = new AbilityAppliedAbility();
        private static final Parser<AbilityAppliedAbility> PARSER = new AbstractParser<AbilityAppliedAbility>() { // from class: emu.grasscutter.net.proto.AbilityAppliedAbilityOuterClass.AbilityAppliedAbility.1
            @Override // com.google.protobuf.Parser
            public AbilityAppliedAbility parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new AbilityAppliedAbility(input, extensionRegistry);
            }
        };

        private AbilityAppliedAbility(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private AbilityAppliedAbility() {
            this.memoizedIsInitialized = -1;
            this.overrideMap_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new AbilityAppliedAbility();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private AbilityAppliedAbility(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                AbilityStringOuterClass.AbilityString.Builder subBuilder = this.abilityName_ != null ? this.abilityName_.toBuilder() : null;
                                this.abilityName_ = (AbilityStringOuterClass.AbilityString) input.readMessage(AbilityStringOuterClass.AbilityString.parser(), extensionRegistry);
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.mergeFrom(this.abilityName_);
                                    this.abilityName_ = subBuilder.buildPartial();
                                    break;
                                }
                            case 18:
                                AbilityStringOuterClass.AbilityString.Builder subBuilder2 = this.abilityOverride_ != null ? this.abilityOverride_.toBuilder() : null;
                                this.abilityOverride_ = (AbilityStringOuterClass.AbilityString) input.readMessage(AbilityStringOuterClass.AbilityString.parser(), extensionRegistry);
                                if (subBuilder2 == null) {
                                    break;
                                } else {
                                    subBuilder2.mergeFrom(this.abilityOverride_);
                                    this.abilityOverride_ = subBuilder2.buildPartial();
                                    break;
                                }
                            case 26:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.overrideMap_ = new ArrayList();
                                    mutable_bitField0_ |= 1;
                                }
                                this.overrideMap_.add((AbilityScalarValueEntryOuterClass.AbilityScalarValueEntry) input.readMessage(AbilityScalarValueEntryOuterClass.AbilityScalarValueEntry.parser(), extensionRegistry));
                                break;
                            case 32:
                                this.instancedAbilityId_ = input.readUInt32();
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
                if ((mutable_bitField0_ & 1) != 0) {
                    this.overrideMap_ = Collections.unmodifiableList(this.overrideMap_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return AbilityAppliedAbilityOuterClass.internal_static_AbilityAppliedAbility_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AbilityAppliedAbilityOuterClass.internal_static_AbilityAppliedAbility_fieldAccessorTable.ensureFieldAccessorsInitialized(AbilityAppliedAbility.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.AbilityAppliedAbilityOuterClass.AbilityAppliedAbilityOrBuilder
        public boolean hasAbilityName() {
            return this.abilityName_ != null;
        }

        @Override // emu.grasscutter.net.proto.AbilityAppliedAbilityOuterClass.AbilityAppliedAbilityOrBuilder
        public AbilityStringOuterClass.AbilityString getAbilityName() {
            return this.abilityName_ == null ? AbilityStringOuterClass.AbilityString.getDefaultInstance() : this.abilityName_;
        }

        @Override // emu.grasscutter.net.proto.AbilityAppliedAbilityOuterClass.AbilityAppliedAbilityOrBuilder
        public AbilityStringOuterClass.AbilityStringOrBuilder getAbilityNameOrBuilder() {
            return getAbilityName();
        }

        @Override // emu.grasscutter.net.proto.AbilityAppliedAbilityOuterClass.AbilityAppliedAbilityOrBuilder
        public boolean hasAbilityOverride() {
            return this.abilityOverride_ != null;
        }

        @Override // emu.grasscutter.net.proto.AbilityAppliedAbilityOuterClass.AbilityAppliedAbilityOrBuilder
        public AbilityStringOuterClass.AbilityString getAbilityOverride() {
            return this.abilityOverride_ == null ? AbilityStringOuterClass.AbilityString.getDefaultInstance() : this.abilityOverride_;
        }

        @Override // emu.grasscutter.net.proto.AbilityAppliedAbilityOuterClass.AbilityAppliedAbilityOrBuilder
        public AbilityStringOuterClass.AbilityStringOrBuilder getAbilityOverrideOrBuilder() {
            return getAbilityOverride();
        }

        @Override // emu.grasscutter.net.proto.AbilityAppliedAbilityOuterClass.AbilityAppliedAbilityOrBuilder
        public List<AbilityScalarValueEntryOuterClass.AbilityScalarValueEntry> getOverrideMapList() {
            return this.overrideMap_;
        }

        @Override // emu.grasscutter.net.proto.AbilityAppliedAbilityOuterClass.AbilityAppliedAbilityOrBuilder
        public List<? extends AbilityScalarValueEntryOuterClass.AbilityScalarValueEntryOrBuilder> getOverrideMapOrBuilderList() {
            return this.overrideMap_;
        }

        @Override // emu.grasscutter.net.proto.AbilityAppliedAbilityOuterClass.AbilityAppliedAbilityOrBuilder
        public int getOverrideMapCount() {
            return this.overrideMap_.size();
        }

        @Override // emu.grasscutter.net.proto.AbilityAppliedAbilityOuterClass.AbilityAppliedAbilityOrBuilder
        public AbilityScalarValueEntryOuterClass.AbilityScalarValueEntry getOverrideMap(int index) {
            return this.overrideMap_.get(index);
        }

        @Override // emu.grasscutter.net.proto.AbilityAppliedAbilityOuterClass.AbilityAppliedAbilityOrBuilder
        public AbilityScalarValueEntryOuterClass.AbilityScalarValueEntryOrBuilder getOverrideMapOrBuilder(int index) {
            return this.overrideMap_.get(index);
        }

        @Override // emu.grasscutter.net.proto.AbilityAppliedAbilityOuterClass.AbilityAppliedAbilityOrBuilder
        public int getInstancedAbilityId() {
            return this.instancedAbilityId_;
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
            if (this.abilityName_ != null) {
                output.writeMessage(1, getAbilityName());
            }
            if (this.abilityOverride_ != null) {
                output.writeMessage(2, getAbilityOverride());
            }
            for (int i = 0; i < this.overrideMap_.size(); i++) {
                output.writeMessage(3, this.overrideMap_.get(i));
            }
            if (this.instancedAbilityId_ != 0) {
                output.writeUInt32(4, this.instancedAbilityId_);
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
            if (this.abilityName_ != null) {
                size2 = 0 + CodedOutputStream.computeMessageSize(1, getAbilityName());
            }
            if (this.abilityOverride_ != null) {
                size2 += CodedOutputStream.computeMessageSize(2, getAbilityOverride());
            }
            for (int i = 0; i < this.overrideMap_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(3, this.overrideMap_.get(i));
            }
            if (this.instancedAbilityId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(4, this.instancedAbilityId_);
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
            if (!(obj instanceof AbilityAppliedAbility)) {
                return equals(obj);
            }
            AbilityAppliedAbility other = (AbilityAppliedAbility) obj;
            if (hasAbilityName() != other.hasAbilityName()) {
                return false;
            }
            if ((!hasAbilityName() || getAbilityName().equals(other.getAbilityName())) && hasAbilityOverride() == other.hasAbilityOverride()) {
                return (!hasAbilityOverride() || getAbilityOverride().equals(other.getAbilityOverride())) && getOverrideMapList().equals(other.getOverrideMapList()) && getInstancedAbilityId() == other.getInstancedAbilityId() && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (hasAbilityName()) {
                hash = (53 * ((37 * hash) + 1)) + getAbilityName().hashCode();
            }
            if (hasAbilityOverride()) {
                hash = (53 * ((37 * hash) + 2)) + getAbilityOverride().hashCode();
            }
            if (getOverrideMapCount() > 0) {
                hash = (53 * ((37 * hash) + 3)) + getOverrideMapList().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * hash) + 4)) + getInstancedAbilityId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static AbilityAppliedAbility parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AbilityAppliedAbility parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AbilityAppliedAbility parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AbilityAppliedAbility parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AbilityAppliedAbility parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AbilityAppliedAbility parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AbilityAppliedAbility parseFrom(InputStream input) throws IOException {
            return (AbilityAppliedAbility) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AbilityAppliedAbility parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AbilityAppliedAbility) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static AbilityAppliedAbility parseDelimitedFrom(InputStream input) throws IOException {
            return (AbilityAppliedAbility) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static AbilityAppliedAbility parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AbilityAppliedAbility) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static AbilityAppliedAbility parseFrom(CodedInputStream input) throws IOException {
            return (AbilityAppliedAbility) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AbilityAppliedAbility parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AbilityAppliedAbility) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(AbilityAppliedAbility prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AbilityAppliedAbilityOuterClass$AbilityAppliedAbility$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AbilityAppliedAbilityOrBuilder {
            private int bitField0_;
            private AbilityStringOuterClass.AbilityString abilityName_;
            private SingleFieldBuilderV3<AbilityStringOuterClass.AbilityString, AbilityStringOuterClass.AbilityString.Builder, AbilityStringOuterClass.AbilityStringOrBuilder> abilityNameBuilder_;
            private AbilityStringOuterClass.AbilityString abilityOverride_;
            private SingleFieldBuilderV3<AbilityStringOuterClass.AbilityString, AbilityStringOuterClass.AbilityString.Builder, AbilityStringOuterClass.AbilityStringOrBuilder> abilityOverrideBuilder_;
            private List<AbilityScalarValueEntryOuterClass.AbilityScalarValueEntry> overrideMap_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<AbilityScalarValueEntryOuterClass.AbilityScalarValueEntry, AbilityScalarValueEntryOuterClass.AbilityScalarValueEntry.Builder, AbilityScalarValueEntryOuterClass.AbilityScalarValueEntryOrBuilder> overrideMapBuilder_;
            private int instancedAbilityId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return AbilityAppliedAbilityOuterClass.internal_static_AbilityAppliedAbility_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return AbilityAppliedAbilityOuterClass.internal_static_AbilityAppliedAbility_fieldAccessorTable.ensureFieldAccessorsInitialized(AbilityAppliedAbility.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (AbilityAppliedAbility.alwaysUseFieldBuilders) {
                    getOverrideMapFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.abilityNameBuilder_ == null) {
                    this.abilityName_ = null;
                } else {
                    this.abilityName_ = null;
                    this.abilityNameBuilder_ = null;
                }
                if (this.abilityOverrideBuilder_ == null) {
                    this.abilityOverride_ = null;
                } else {
                    this.abilityOverride_ = null;
                    this.abilityOverrideBuilder_ = null;
                }
                if (this.overrideMapBuilder_ == null) {
                    this.overrideMap_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.overrideMapBuilder_.clear();
                }
                this.instancedAbilityId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return AbilityAppliedAbilityOuterClass.internal_static_AbilityAppliedAbility_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public AbilityAppliedAbility getDefaultInstanceForType() {
                return AbilityAppliedAbility.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AbilityAppliedAbility build() {
                AbilityAppliedAbility result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AbilityAppliedAbility buildPartial() {
                AbilityAppliedAbility result = new AbilityAppliedAbility(this);
                int i = this.bitField0_;
                if (this.abilityNameBuilder_ == null) {
                    result.abilityName_ = this.abilityName_;
                } else {
                    result.abilityName_ = this.abilityNameBuilder_.build();
                }
                if (this.abilityOverrideBuilder_ == null) {
                    result.abilityOverride_ = this.abilityOverride_;
                } else {
                    result.abilityOverride_ = this.abilityOverrideBuilder_.build();
                }
                if (this.overrideMapBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.overrideMap_ = Collections.unmodifiableList(this.overrideMap_);
                        this.bitField0_ &= -2;
                    }
                    result.overrideMap_ = this.overrideMap_;
                } else {
                    result.overrideMap_ = this.overrideMapBuilder_.build();
                }
                result.instancedAbilityId_ = this.instancedAbilityId_;
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
                if (other instanceof AbilityAppliedAbility) {
                    return mergeFrom((AbilityAppliedAbility) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(AbilityAppliedAbility other) {
                if (other == AbilityAppliedAbility.getDefaultInstance()) {
                    return this;
                }
                if (other.hasAbilityName()) {
                    mergeAbilityName(other.getAbilityName());
                }
                if (other.hasAbilityOverride()) {
                    mergeAbilityOverride(other.getAbilityOverride());
                }
                if (this.overrideMapBuilder_ == null) {
                    if (!other.overrideMap_.isEmpty()) {
                        if (this.overrideMap_.isEmpty()) {
                            this.overrideMap_ = other.overrideMap_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureOverrideMapIsMutable();
                            this.overrideMap_.addAll(other.overrideMap_);
                        }
                        onChanged();
                    }
                } else if (!other.overrideMap_.isEmpty()) {
                    if (this.overrideMapBuilder_.isEmpty()) {
                        this.overrideMapBuilder_.dispose();
                        this.overrideMapBuilder_ = null;
                        this.overrideMap_ = other.overrideMap_;
                        this.bitField0_ &= -2;
                        this.overrideMapBuilder_ = AbilityAppliedAbility.alwaysUseFieldBuilders ? getOverrideMapFieldBuilder() : null;
                    } else {
                        this.overrideMapBuilder_.addAllMessages(other.overrideMap_);
                    }
                }
                if (other.getInstancedAbilityId() != 0) {
                    setInstancedAbilityId(other.getInstancedAbilityId());
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
                AbilityAppliedAbility parsedMessage = null;
                try {
                    try {
                        parsedMessage = AbilityAppliedAbility.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (AbilityAppliedAbility) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.AbilityAppliedAbilityOuterClass.AbilityAppliedAbilityOrBuilder
            public boolean hasAbilityName() {
                return (this.abilityNameBuilder_ == null && this.abilityName_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.AbilityAppliedAbilityOuterClass.AbilityAppliedAbilityOrBuilder
            public AbilityStringOuterClass.AbilityString getAbilityName() {
                if (this.abilityNameBuilder_ == null) {
                    return this.abilityName_ == null ? AbilityStringOuterClass.AbilityString.getDefaultInstance() : this.abilityName_;
                }
                return this.abilityNameBuilder_.getMessage();
            }

            public Builder setAbilityName(AbilityStringOuterClass.AbilityString value) {
                if (this.abilityNameBuilder_ != null) {
                    this.abilityNameBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.abilityName_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setAbilityName(AbilityStringOuterClass.AbilityString.Builder builderForValue) {
                if (this.abilityNameBuilder_ == null) {
                    this.abilityName_ = builderForValue.build();
                    onChanged();
                } else {
                    this.abilityNameBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeAbilityName(AbilityStringOuterClass.AbilityString value) {
                if (this.abilityNameBuilder_ == null) {
                    if (this.abilityName_ != null) {
                        this.abilityName_ = AbilityStringOuterClass.AbilityString.newBuilder(this.abilityName_).mergeFrom(value).buildPartial();
                    } else {
                        this.abilityName_ = value;
                    }
                    onChanged();
                } else {
                    this.abilityNameBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearAbilityName() {
                if (this.abilityNameBuilder_ == null) {
                    this.abilityName_ = null;
                    onChanged();
                } else {
                    this.abilityName_ = null;
                    this.abilityNameBuilder_ = null;
                }
                return this;
            }

            public AbilityStringOuterClass.AbilityString.Builder getAbilityNameBuilder() {
                onChanged();
                return getAbilityNameFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.AbilityAppliedAbilityOuterClass.AbilityAppliedAbilityOrBuilder
            public AbilityStringOuterClass.AbilityStringOrBuilder getAbilityNameOrBuilder() {
                if (this.abilityNameBuilder_ != null) {
                    return this.abilityNameBuilder_.getMessageOrBuilder();
                }
                return this.abilityName_ == null ? AbilityStringOuterClass.AbilityString.getDefaultInstance() : this.abilityName_;
            }

            private SingleFieldBuilderV3<AbilityStringOuterClass.AbilityString, AbilityStringOuterClass.AbilityString.Builder, AbilityStringOuterClass.AbilityStringOrBuilder> getAbilityNameFieldBuilder() {
                if (this.abilityNameBuilder_ == null) {
                    this.abilityNameBuilder_ = new SingleFieldBuilderV3<>(getAbilityName(), getParentForChildren(), isClean());
                    this.abilityName_ = null;
                }
                return this.abilityNameBuilder_;
            }

            @Override // emu.grasscutter.net.proto.AbilityAppliedAbilityOuterClass.AbilityAppliedAbilityOrBuilder
            public boolean hasAbilityOverride() {
                return (this.abilityOverrideBuilder_ == null && this.abilityOverride_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.AbilityAppliedAbilityOuterClass.AbilityAppliedAbilityOrBuilder
            public AbilityStringOuterClass.AbilityString getAbilityOverride() {
                if (this.abilityOverrideBuilder_ == null) {
                    return this.abilityOverride_ == null ? AbilityStringOuterClass.AbilityString.getDefaultInstance() : this.abilityOverride_;
                }
                return this.abilityOverrideBuilder_.getMessage();
            }

            public Builder setAbilityOverride(AbilityStringOuterClass.AbilityString value) {
                if (this.abilityOverrideBuilder_ != null) {
                    this.abilityOverrideBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.abilityOverride_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setAbilityOverride(AbilityStringOuterClass.AbilityString.Builder builderForValue) {
                if (this.abilityOverrideBuilder_ == null) {
                    this.abilityOverride_ = builderForValue.build();
                    onChanged();
                } else {
                    this.abilityOverrideBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeAbilityOverride(AbilityStringOuterClass.AbilityString value) {
                if (this.abilityOverrideBuilder_ == null) {
                    if (this.abilityOverride_ != null) {
                        this.abilityOverride_ = AbilityStringOuterClass.AbilityString.newBuilder(this.abilityOverride_).mergeFrom(value).buildPartial();
                    } else {
                        this.abilityOverride_ = value;
                    }
                    onChanged();
                } else {
                    this.abilityOverrideBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearAbilityOverride() {
                if (this.abilityOverrideBuilder_ == null) {
                    this.abilityOverride_ = null;
                    onChanged();
                } else {
                    this.abilityOverride_ = null;
                    this.abilityOverrideBuilder_ = null;
                }
                return this;
            }

            public AbilityStringOuterClass.AbilityString.Builder getAbilityOverrideBuilder() {
                onChanged();
                return getAbilityOverrideFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.AbilityAppliedAbilityOuterClass.AbilityAppliedAbilityOrBuilder
            public AbilityStringOuterClass.AbilityStringOrBuilder getAbilityOverrideOrBuilder() {
                if (this.abilityOverrideBuilder_ != null) {
                    return this.abilityOverrideBuilder_.getMessageOrBuilder();
                }
                return this.abilityOverride_ == null ? AbilityStringOuterClass.AbilityString.getDefaultInstance() : this.abilityOverride_;
            }

            private SingleFieldBuilderV3<AbilityStringOuterClass.AbilityString, AbilityStringOuterClass.AbilityString.Builder, AbilityStringOuterClass.AbilityStringOrBuilder> getAbilityOverrideFieldBuilder() {
                if (this.abilityOverrideBuilder_ == null) {
                    this.abilityOverrideBuilder_ = new SingleFieldBuilderV3<>(getAbilityOverride(), getParentForChildren(), isClean());
                    this.abilityOverride_ = null;
                }
                return this.abilityOverrideBuilder_;
            }

            private void ensureOverrideMapIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.overrideMap_ = new ArrayList(this.overrideMap_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.AbilityAppliedAbilityOuterClass.AbilityAppliedAbilityOrBuilder
            public List<AbilityScalarValueEntryOuterClass.AbilityScalarValueEntry> getOverrideMapList() {
                if (this.overrideMapBuilder_ == null) {
                    return Collections.unmodifiableList(this.overrideMap_);
                }
                return this.overrideMapBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.AbilityAppliedAbilityOuterClass.AbilityAppliedAbilityOrBuilder
            public int getOverrideMapCount() {
                if (this.overrideMapBuilder_ == null) {
                    return this.overrideMap_.size();
                }
                return this.overrideMapBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.AbilityAppliedAbilityOuterClass.AbilityAppliedAbilityOrBuilder
            public AbilityScalarValueEntryOuterClass.AbilityScalarValueEntry getOverrideMap(int index) {
                if (this.overrideMapBuilder_ == null) {
                    return this.overrideMap_.get(index);
                }
                return this.overrideMapBuilder_.getMessage(index);
            }

            public Builder setOverrideMap(int index, AbilityScalarValueEntryOuterClass.AbilityScalarValueEntry value) {
                if (this.overrideMapBuilder_ != null) {
                    this.overrideMapBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureOverrideMapIsMutable();
                    this.overrideMap_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setOverrideMap(int index, AbilityScalarValueEntryOuterClass.AbilityScalarValueEntry.Builder builderForValue) {
                if (this.overrideMapBuilder_ == null) {
                    ensureOverrideMapIsMutable();
                    this.overrideMap_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.overrideMapBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addOverrideMap(AbilityScalarValueEntryOuterClass.AbilityScalarValueEntry value) {
                if (this.overrideMapBuilder_ != null) {
                    this.overrideMapBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureOverrideMapIsMutable();
                    this.overrideMap_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addOverrideMap(int index, AbilityScalarValueEntryOuterClass.AbilityScalarValueEntry value) {
                if (this.overrideMapBuilder_ != null) {
                    this.overrideMapBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureOverrideMapIsMutable();
                    this.overrideMap_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addOverrideMap(AbilityScalarValueEntryOuterClass.AbilityScalarValueEntry.Builder builderForValue) {
                if (this.overrideMapBuilder_ == null) {
                    ensureOverrideMapIsMutable();
                    this.overrideMap_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.overrideMapBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addOverrideMap(int index, AbilityScalarValueEntryOuterClass.AbilityScalarValueEntry.Builder builderForValue) {
                if (this.overrideMapBuilder_ == null) {
                    ensureOverrideMapIsMutable();
                    this.overrideMap_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.overrideMapBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllOverrideMap(Iterable<? extends AbilityScalarValueEntryOuterClass.AbilityScalarValueEntry> values) {
                if (this.overrideMapBuilder_ == null) {
                    ensureOverrideMapIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.overrideMap_);
                    onChanged();
                } else {
                    this.overrideMapBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearOverrideMap() {
                if (this.overrideMapBuilder_ == null) {
                    this.overrideMap_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.overrideMapBuilder_.clear();
                }
                return this;
            }

            public Builder removeOverrideMap(int index) {
                if (this.overrideMapBuilder_ == null) {
                    ensureOverrideMapIsMutable();
                    this.overrideMap_.remove(index);
                    onChanged();
                } else {
                    this.overrideMapBuilder_.remove(index);
                }
                return this;
            }

            public AbilityScalarValueEntryOuterClass.AbilityScalarValueEntry.Builder getOverrideMapBuilder(int index) {
                return getOverrideMapFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.AbilityAppliedAbilityOuterClass.AbilityAppliedAbilityOrBuilder
            public AbilityScalarValueEntryOuterClass.AbilityScalarValueEntryOrBuilder getOverrideMapOrBuilder(int index) {
                if (this.overrideMapBuilder_ == null) {
                    return this.overrideMap_.get(index);
                }
                return this.overrideMapBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.AbilityAppliedAbilityOuterClass.AbilityAppliedAbilityOrBuilder
            public List<? extends AbilityScalarValueEntryOuterClass.AbilityScalarValueEntryOrBuilder> getOverrideMapOrBuilderList() {
                if (this.overrideMapBuilder_ != null) {
                    return this.overrideMapBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.overrideMap_);
            }

            public AbilityScalarValueEntryOuterClass.AbilityScalarValueEntry.Builder addOverrideMapBuilder() {
                return getOverrideMapFieldBuilder().addBuilder(AbilityScalarValueEntryOuterClass.AbilityScalarValueEntry.getDefaultInstance());
            }

            public AbilityScalarValueEntryOuterClass.AbilityScalarValueEntry.Builder addOverrideMapBuilder(int index) {
                return getOverrideMapFieldBuilder().addBuilder(index, AbilityScalarValueEntryOuterClass.AbilityScalarValueEntry.getDefaultInstance());
            }

            public List<AbilityScalarValueEntryOuterClass.AbilityScalarValueEntry.Builder> getOverrideMapBuilderList() {
                return getOverrideMapFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<AbilityScalarValueEntryOuterClass.AbilityScalarValueEntry, AbilityScalarValueEntryOuterClass.AbilityScalarValueEntry.Builder, AbilityScalarValueEntryOuterClass.AbilityScalarValueEntryOrBuilder> getOverrideMapFieldBuilder() {
                if (this.overrideMapBuilder_ == null) {
                    this.overrideMapBuilder_ = new RepeatedFieldBuilderV3<>(this.overrideMap_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.overrideMap_ = null;
                }
                return this.overrideMapBuilder_;
            }

            @Override // emu.grasscutter.net.proto.AbilityAppliedAbilityOuterClass.AbilityAppliedAbilityOrBuilder
            public int getInstancedAbilityId() {
                return this.instancedAbilityId_;
            }

            public Builder setInstancedAbilityId(int value) {
                this.instancedAbilityId_ = value;
                onChanged();
                return this;
            }

            public Builder clearInstancedAbilityId() {
                this.instancedAbilityId_ = 0;
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

        public static AbilityAppliedAbility getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<AbilityAppliedAbility> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<AbilityAppliedAbility> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public AbilityAppliedAbility getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        AbilityScalarValueEntryOuterClass.getDescriptor();
        AbilityStringOuterClass.getDescriptor();
    }
}
