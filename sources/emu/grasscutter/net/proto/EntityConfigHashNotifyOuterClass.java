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
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.EntityConfigHashEntryOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EntityConfigHashNotifyOuterClass.class */
public final class EntityConfigHashNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001cEntityConfigHashNotify.proto\u001a\u001bEntityConfigHashEntry.proto\"¬\u0001\n\u0016EntityConfigHashNotify\u0012/\n\u000favatarEntryList\u0018\f \u0003(\u000b2\u0016.EntityConfigHashEntry\u00120\n\u0010abilityEntryList\u0018\u0007 \u0003(\u000b2\u0016.EntityConfigHashEntry\u0012/\n\u000fcombatEntryList\u0018\u0001 \u0003(\u000b2\u0016.EntityConfigHashEntryB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{EntityConfigHashEntryOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_EntityConfigHashNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_EntityConfigHashNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_EntityConfigHashNotify_descriptor, new String[]{"AvatarEntryList", "AbilityEntryList", "CombatEntryList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EntityConfigHashNotifyOuterClass$EntityConfigHashNotifyOrBuilder.class */
    public interface EntityConfigHashNotifyOrBuilder extends MessageOrBuilder {
        List<EntityConfigHashEntryOuterClass.EntityConfigHashEntry> getAvatarEntryListList();

        EntityConfigHashEntryOuterClass.EntityConfigHashEntry getAvatarEntryList(int i);

        int getAvatarEntryListCount();

        List<? extends EntityConfigHashEntryOuterClass.EntityConfigHashEntryOrBuilder> getAvatarEntryListOrBuilderList();

        EntityConfigHashEntryOuterClass.EntityConfigHashEntryOrBuilder getAvatarEntryListOrBuilder(int i);

        List<EntityConfigHashEntryOuterClass.EntityConfigHashEntry> getAbilityEntryListList();

        EntityConfigHashEntryOuterClass.EntityConfigHashEntry getAbilityEntryList(int i);

        int getAbilityEntryListCount();

        List<? extends EntityConfigHashEntryOuterClass.EntityConfigHashEntryOrBuilder> getAbilityEntryListOrBuilderList();

        EntityConfigHashEntryOuterClass.EntityConfigHashEntryOrBuilder getAbilityEntryListOrBuilder(int i);

        List<EntityConfigHashEntryOuterClass.EntityConfigHashEntry> getCombatEntryListList();

        EntityConfigHashEntryOuterClass.EntityConfigHashEntry getCombatEntryList(int i);

        int getCombatEntryListCount();

        List<? extends EntityConfigHashEntryOuterClass.EntityConfigHashEntryOrBuilder> getCombatEntryListOrBuilderList();

        EntityConfigHashEntryOuterClass.EntityConfigHashEntryOrBuilder getCombatEntryListOrBuilder(int i);
    }

    private EntityConfigHashNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EntityConfigHashNotifyOuterClass$EntityConfigHashNotify.class */
    public static final class EntityConfigHashNotify extends GeneratedMessageV3 implements EntityConfigHashNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int AVATARENTRYLIST_FIELD_NUMBER = 12;
        private List<EntityConfigHashEntryOuterClass.EntityConfigHashEntry> avatarEntryList_;
        public static final int ABILITYENTRYLIST_FIELD_NUMBER = 7;
        private List<EntityConfigHashEntryOuterClass.EntityConfigHashEntry> abilityEntryList_;
        public static final int COMBATENTRYLIST_FIELD_NUMBER = 1;
        private List<EntityConfigHashEntryOuterClass.EntityConfigHashEntry> combatEntryList_;
        private byte memoizedIsInitialized;
        private static final EntityConfigHashNotify DEFAULT_INSTANCE = new EntityConfigHashNotify();
        private static final Parser<EntityConfigHashNotify> PARSER = new AbstractParser<EntityConfigHashNotify>() { // from class: emu.grasscutter.net.proto.EntityConfigHashNotifyOuterClass.EntityConfigHashNotify.1
            @Override // com.google.protobuf.Parser
            public EntityConfigHashNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new EntityConfigHashNotify(input, extensionRegistry);
            }
        };

        private EntityConfigHashNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private EntityConfigHashNotify() {
            this.memoizedIsInitialized = -1;
            this.avatarEntryList_ = Collections.emptyList();
            this.abilityEntryList_ = Collections.emptyList();
            this.combatEntryList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new EntityConfigHashNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:69:0x00ed */
        private EntityConfigHashNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                    this.combatEntryList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 4) == 1 ? 1 : 0;
                                }
                                this.combatEntryList_.add((EntityConfigHashEntryOuterClass.EntityConfigHashEntry) input.readMessage(EntityConfigHashEntryOuterClass.EntityConfigHashEntry.parser(), extensionRegistry));
                                break;
                            case 58:
                                if ((mutable_bitField0_ & 2) == 0) {
                                    this.abilityEntryList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                this.abilityEntryList_.add((EntityConfigHashEntryOuterClass.EntityConfigHashEntry) input.readMessage(EntityConfigHashEntryOuterClass.EntityConfigHashEntry.parser(), extensionRegistry));
                                break;
                            case 98:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.avatarEntryList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                this.avatarEntryList_.add((EntityConfigHashEntryOuterClass.EntityConfigHashEntry) input.readMessage(EntityConfigHashEntryOuterClass.EntityConfigHashEntry.parser(), extensionRegistry));
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
                if ((mutable_bitField0_ & 4) != 0) {
                    this.combatEntryList_ = Collections.unmodifiableList(this.combatEntryList_);
                }
                if ((mutable_bitField0_ & 2) != 0) {
                    this.abilityEntryList_ = Collections.unmodifiableList(this.abilityEntryList_);
                }
                if ((mutable_bitField0_ & 1) != 0) {
                    this.avatarEntryList_ = Collections.unmodifiableList(this.avatarEntryList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return EntityConfigHashNotifyOuterClass.internal_static_EntityConfigHashNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return EntityConfigHashNotifyOuterClass.internal_static_EntityConfigHashNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(EntityConfigHashNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.EntityConfigHashNotifyOuterClass.EntityConfigHashNotifyOrBuilder
        public List<EntityConfigHashEntryOuterClass.EntityConfigHashEntry> getAvatarEntryListList() {
            return this.avatarEntryList_;
        }

        @Override // emu.grasscutter.net.proto.EntityConfigHashNotifyOuterClass.EntityConfigHashNotifyOrBuilder
        public List<? extends EntityConfigHashEntryOuterClass.EntityConfigHashEntryOrBuilder> getAvatarEntryListOrBuilderList() {
            return this.avatarEntryList_;
        }

        @Override // emu.grasscutter.net.proto.EntityConfigHashNotifyOuterClass.EntityConfigHashNotifyOrBuilder
        public int getAvatarEntryListCount() {
            return this.avatarEntryList_.size();
        }

        @Override // emu.grasscutter.net.proto.EntityConfigHashNotifyOuterClass.EntityConfigHashNotifyOrBuilder
        public EntityConfigHashEntryOuterClass.EntityConfigHashEntry getAvatarEntryList(int index) {
            return this.avatarEntryList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.EntityConfigHashNotifyOuterClass.EntityConfigHashNotifyOrBuilder
        public EntityConfigHashEntryOuterClass.EntityConfigHashEntryOrBuilder getAvatarEntryListOrBuilder(int index) {
            return this.avatarEntryList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.EntityConfigHashNotifyOuterClass.EntityConfigHashNotifyOrBuilder
        public List<EntityConfigHashEntryOuterClass.EntityConfigHashEntry> getAbilityEntryListList() {
            return this.abilityEntryList_;
        }

        @Override // emu.grasscutter.net.proto.EntityConfigHashNotifyOuterClass.EntityConfigHashNotifyOrBuilder
        public List<? extends EntityConfigHashEntryOuterClass.EntityConfigHashEntryOrBuilder> getAbilityEntryListOrBuilderList() {
            return this.abilityEntryList_;
        }

        @Override // emu.grasscutter.net.proto.EntityConfigHashNotifyOuterClass.EntityConfigHashNotifyOrBuilder
        public int getAbilityEntryListCount() {
            return this.abilityEntryList_.size();
        }

        @Override // emu.grasscutter.net.proto.EntityConfigHashNotifyOuterClass.EntityConfigHashNotifyOrBuilder
        public EntityConfigHashEntryOuterClass.EntityConfigHashEntry getAbilityEntryList(int index) {
            return this.abilityEntryList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.EntityConfigHashNotifyOuterClass.EntityConfigHashNotifyOrBuilder
        public EntityConfigHashEntryOuterClass.EntityConfigHashEntryOrBuilder getAbilityEntryListOrBuilder(int index) {
            return this.abilityEntryList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.EntityConfigHashNotifyOuterClass.EntityConfigHashNotifyOrBuilder
        public List<EntityConfigHashEntryOuterClass.EntityConfigHashEntry> getCombatEntryListList() {
            return this.combatEntryList_;
        }

        @Override // emu.grasscutter.net.proto.EntityConfigHashNotifyOuterClass.EntityConfigHashNotifyOrBuilder
        public List<? extends EntityConfigHashEntryOuterClass.EntityConfigHashEntryOrBuilder> getCombatEntryListOrBuilderList() {
            return this.combatEntryList_;
        }

        @Override // emu.grasscutter.net.proto.EntityConfigHashNotifyOuterClass.EntityConfigHashNotifyOrBuilder
        public int getCombatEntryListCount() {
            return this.combatEntryList_.size();
        }

        @Override // emu.grasscutter.net.proto.EntityConfigHashNotifyOuterClass.EntityConfigHashNotifyOrBuilder
        public EntityConfigHashEntryOuterClass.EntityConfigHashEntry getCombatEntryList(int index) {
            return this.combatEntryList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.EntityConfigHashNotifyOuterClass.EntityConfigHashNotifyOrBuilder
        public EntityConfigHashEntryOuterClass.EntityConfigHashEntryOrBuilder getCombatEntryListOrBuilder(int index) {
            return this.combatEntryList_.get(index);
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
            for (int i = 0; i < this.combatEntryList_.size(); i++) {
                output.writeMessage(1, this.combatEntryList_.get(i));
            }
            for (int i2 = 0; i2 < this.abilityEntryList_.size(); i2++) {
                output.writeMessage(7, this.abilityEntryList_.get(i2));
            }
            for (int i3 = 0; i3 < this.avatarEntryList_.size(); i3++) {
                output.writeMessage(12, this.avatarEntryList_.get(i3));
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
            for (int i = 0; i < this.combatEntryList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(1, this.combatEntryList_.get(i));
            }
            for (int i2 = 0; i2 < this.abilityEntryList_.size(); i2++) {
                size2 += CodedOutputStream.computeMessageSize(7, this.abilityEntryList_.get(i2));
            }
            for (int i3 = 0; i3 < this.avatarEntryList_.size(); i3++) {
                size2 += CodedOutputStream.computeMessageSize(12, this.avatarEntryList_.get(i3));
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
            if (!(obj instanceof EntityConfigHashNotify)) {
                return equals(obj);
            }
            EntityConfigHashNotify other = (EntityConfigHashNotify) obj;
            return getAvatarEntryListList().equals(other.getAvatarEntryListList()) && getAbilityEntryListList().equals(other.getAbilityEntryListList()) && getCombatEntryListList().equals(other.getCombatEntryListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getAvatarEntryListCount() > 0) {
                hash = (53 * ((37 * hash) + 12)) + getAvatarEntryListList().hashCode();
            }
            if (getAbilityEntryListCount() > 0) {
                hash = (53 * ((37 * hash) + 7)) + getAbilityEntryListList().hashCode();
            }
            if (getCombatEntryListCount() > 0) {
                hash = (53 * ((37 * hash) + 1)) + getCombatEntryListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static EntityConfigHashNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static EntityConfigHashNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static EntityConfigHashNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static EntityConfigHashNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static EntityConfigHashNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static EntityConfigHashNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static EntityConfigHashNotify parseFrom(InputStream input) throws IOException {
            return (EntityConfigHashNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static EntityConfigHashNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EntityConfigHashNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static EntityConfigHashNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (EntityConfigHashNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static EntityConfigHashNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EntityConfigHashNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static EntityConfigHashNotify parseFrom(CodedInputStream input) throws IOException {
            return (EntityConfigHashNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static EntityConfigHashNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EntityConfigHashNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(EntityConfigHashNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EntityConfigHashNotifyOuterClass$EntityConfigHashNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements EntityConfigHashNotifyOrBuilder {
            private int bitField0_;
            private RepeatedFieldBuilderV3<EntityConfigHashEntryOuterClass.EntityConfigHashEntry, EntityConfigHashEntryOuterClass.EntityConfigHashEntry.Builder, EntityConfigHashEntryOuterClass.EntityConfigHashEntryOrBuilder> avatarEntryListBuilder_;
            private RepeatedFieldBuilderV3<EntityConfigHashEntryOuterClass.EntityConfigHashEntry, EntityConfigHashEntryOuterClass.EntityConfigHashEntry.Builder, EntityConfigHashEntryOuterClass.EntityConfigHashEntryOrBuilder> abilityEntryListBuilder_;
            private RepeatedFieldBuilderV3<EntityConfigHashEntryOuterClass.EntityConfigHashEntry, EntityConfigHashEntryOuterClass.EntityConfigHashEntry.Builder, EntityConfigHashEntryOuterClass.EntityConfigHashEntryOrBuilder> combatEntryListBuilder_;
            private List<EntityConfigHashEntryOuterClass.EntityConfigHashEntry> avatarEntryList_ = Collections.emptyList();
            private List<EntityConfigHashEntryOuterClass.EntityConfigHashEntry> abilityEntryList_ = Collections.emptyList();
            private List<EntityConfigHashEntryOuterClass.EntityConfigHashEntry> combatEntryList_ = Collections.emptyList();

            public static final Descriptors.Descriptor getDescriptor() {
                return EntityConfigHashNotifyOuterClass.internal_static_EntityConfigHashNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return EntityConfigHashNotifyOuterClass.internal_static_EntityConfigHashNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(EntityConfigHashNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (EntityConfigHashNotify.alwaysUseFieldBuilders) {
                    getAvatarEntryListFieldBuilder();
                    getAbilityEntryListFieldBuilder();
                    getCombatEntryListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.avatarEntryListBuilder_ == null) {
                    this.avatarEntryList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.avatarEntryListBuilder_.clear();
                }
                if (this.abilityEntryListBuilder_ == null) {
                    this.abilityEntryList_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                } else {
                    this.abilityEntryListBuilder_.clear();
                }
                if (this.combatEntryListBuilder_ == null) {
                    this.combatEntryList_ = Collections.emptyList();
                    this.bitField0_ &= -5;
                } else {
                    this.combatEntryListBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return EntityConfigHashNotifyOuterClass.internal_static_EntityConfigHashNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public EntityConfigHashNotify getDefaultInstanceForType() {
                return EntityConfigHashNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public EntityConfigHashNotify build() {
                EntityConfigHashNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public EntityConfigHashNotify buildPartial() {
                EntityConfigHashNotify result = new EntityConfigHashNotify(this);
                int i = this.bitField0_;
                if (this.avatarEntryListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.avatarEntryList_ = Collections.unmodifiableList(this.avatarEntryList_);
                        this.bitField0_ &= -2;
                    }
                    result.avatarEntryList_ = this.avatarEntryList_;
                } else {
                    result.avatarEntryList_ = this.avatarEntryListBuilder_.build();
                }
                if (this.abilityEntryListBuilder_ == null) {
                    if ((this.bitField0_ & 2) != 0) {
                        this.abilityEntryList_ = Collections.unmodifiableList(this.abilityEntryList_);
                        this.bitField0_ &= -3;
                    }
                    result.abilityEntryList_ = this.abilityEntryList_;
                } else {
                    result.abilityEntryList_ = this.abilityEntryListBuilder_.build();
                }
                if (this.combatEntryListBuilder_ == null) {
                    if ((this.bitField0_ & 4) != 0) {
                        this.combatEntryList_ = Collections.unmodifiableList(this.combatEntryList_);
                        this.bitField0_ &= -5;
                    }
                    result.combatEntryList_ = this.combatEntryList_;
                } else {
                    result.combatEntryList_ = this.combatEntryListBuilder_.build();
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
                if (other instanceof EntityConfigHashNotify) {
                    return mergeFrom((EntityConfigHashNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(EntityConfigHashNotify other) {
                if (other == EntityConfigHashNotify.getDefaultInstance()) {
                    return this;
                }
                if (this.avatarEntryListBuilder_ == null) {
                    if (!other.avatarEntryList_.isEmpty()) {
                        if (this.avatarEntryList_.isEmpty()) {
                            this.avatarEntryList_ = other.avatarEntryList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureAvatarEntryListIsMutable();
                            this.avatarEntryList_.addAll(other.avatarEntryList_);
                        }
                        onChanged();
                    }
                } else if (!other.avatarEntryList_.isEmpty()) {
                    if (this.avatarEntryListBuilder_.isEmpty()) {
                        this.avatarEntryListBuilder_.dispose();
                        this.avatarEntryListBuilder_ = null;
                        this.avatarEntryList_ = other.avatarEntryList_;
                        this.bitField0_ &= -2;
                        this.avatarEntryListBuilder_ = EntityConfigHashNotify.alwaysUseFieldBuilders ? getAvatarEntryListFieldBuilder() : null;
                    } else {
                        this.avatarEntryListBuilder_.addAllMessages(other.avatarEntryList_);
                    }
                }
                if (this.abilityEntryListBuilder_ == null) {
                    if (!other.abilityEntryList_.isEmpty()) {
                        if (this.abilityEntryList_.isEmpty()) {
                            this.abilityEntryList_ = other.abilityEntryList_;
                            this.bitField0_ &= -3;
                        } else {
                            ensureAbilityEntryListIsMutable();
                            this.abilityEntryList_.addAll(other.abilityEntryList_);
                        }
                        onChanged();
                    }
                } else if (!other.abilityEntryList_.isEmpty()) {
                    if (this.abilityEntryListBuilder_.isEmpty()) {
                        this.abilityEntryListBuilder_.dispose();
                        this.abilityEntryListBuilder_ = null;
                        this.abilityEntryList_ = other.abilityEntryList_;
                        this.bitField0_ &= -3;
                        this.abilityEntryListBuilder_ = EntityConfigHashNotify.alwaysUseFieldBuilders ? getAbilityEntryListFieldBuilder() : null;
                    } else {
                        this.abilityEntryListBuilder_.addAllMessages(other.abilityEntryList_);
                    }
                }
                if (this.combatEntryListBuilder_ == null) {
                    if (!other.combatEntryList_.isEmpty()) {
                        if (this.combatEntryList_.isEmpty()) {
                            this.combatEntryList_ = other.combatEntryList_;
                            this.bitField0_ &= -5;
                        } else {
                            ensureCombatEntryListIsMutable();
                            this.combatEntryList_.addAll(other.combatEntryList_);
                        }
                        onChanged();
                    }
                } else if (!other.combatEntryList_.isEmpty()) {
                    if (this.combatEntryListBuilder_.isEmpty()) {
                        this.combatEntryListBuilder_.dispose();
                        this.combatEntryListBuilder_ = null;
                        this.combatEntryList_ = other.combatEntryList_;
                        this.bitField0_ &= -5;
                        this.combatEntryListBuilder_ = EntityConfigHashNotify.alwaysUseFieldBuilders ? getCombatEntryListFieldBuilder() : null;
                    } else {
                        this.combatEntryListBuilder_.addAllMessages(other.combatEntryList_);
                    }
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
                EntityConfigHashNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = EntityConfigHashNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (EntityConfigHashNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureAvatarEntryListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.avatarEntryList_ = new ArrayList(this.avatarEntryList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.EntityConfigHashNotifyOuterClass.EntityConfigHashNotifyOrBuilder
            public List<EntityConfigHashEntryOuterClass.EntityConfigHashEntry> getAvatarEntryListList() {
                if (this.avatarEntryListBuilder_ == null) {
                    return Collections.unmodifiableList(this.avatarEntryList_);
                }
                return this.avatarEntryListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.EntityConfigHashNotifyOuterClass.EntityConfigHashNotifyOrBuilder
            public int getAvatarEntryListCount() {
                if (this.avatarEntryListBuilder_ == null) {
                    return this.avatarEntryList_.size();
                }
                return this.avatarEntryListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.EntityConfigHashNotifyOuterClass.EntityConfigHashNotifyOrBuilder
            public EntityConfigHashEntryOuterClass.EntityConfigHashEntry getAvatarEntryList(int index) {
                if (this.avatarEntryListBuilder_ == null) {
                    return this.avatarEntryList_.get(index);
                }
                return this.avatarEntryListBuilder_.getMessage(index);
            }

            public Builder setAvatarEntryList(int index, EntityConfigHashEntryOuterClass.EntityConfigHashEntry value) {
                if (this.avatarEntryListBuilder_ != null) {
                    this.avatarEntryListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureAvatarEntryListIsMutable();
                    this.avatarEntryList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setAvatarEntryList(int index, EntityConfigHashEntryOuterClass.EntityConfigHashEntry.Builder builderForValue) {
                if (this.avatarEntryListBuilder_ == null) {
                    ensureAvatarEntryListIsMutable();
                    this.avatarEntryList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.avatarEntryListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAvatarEntryList(EntityConfigHashEntryOuterClass.EntityConfigHashEntry value) {
                if (this.avatarEntryListBuilder_ != null) {
                    this.avatarEntryListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureAvatarEntryListIsMutable();
                    this.avatarEntryList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addAvatarEntryList(int index, EntityConfigHashEntryOuterClass.EntityConfigHashEntry value) {
                if (this.avatarEntryListBuilder_ != null) {
                    this.avatarEntryListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureAvatarEntryListIsMutable();
                    this.avatarEntryList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addAvatarEntryList(EntityConfigHashEntryOuterClass.EntityConfigHashEntry.Builder builderForValue) {
                if (this.avatarEntryListBuilder_ == null) {
                    ensureAvatarEntryListIsMutable();
                    this.avatarEntryList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.avatarEntryListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addAvatarEntryList(int index, EntityConfigHashEntryOuterClass.EntityConfigHashEntry.Builder builderForValue) {
                if (this.avatarEntryListBuilder_ == null) {
                    ensureAvatarEntryListIsMutable();
                    this.avatarEntryList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.avatarEntryListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllAvatarEntryList(Iterable<? extends EntityConfigHashEntryOuterClass.EntityConfigHashEntry> values) {
                if (this.avatarEntryListBuilder_ == null) {
                    ensureAvatarEntryListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.avatarEntryList_);
                    onChanged();
                } else {
                    this.avatarEntryListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearAvatarEntryList() {
                if (this.avatarEntryListBuilder_ == null) {
                    this.avatarEntryList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.avatarEntryListBuilder_.clear();
                }
                return this;
            }

            public Builder removeAvatarEntryList(int index) {
                if (this.avatarEntryListBuilder_ == null) {
                    ensureAvatarEntryListIsMutable();
                    this.avatarEntryList_.remove(index);
                    onChanged();
                } else {
                    this.avatarEntryListBuilder_.remove(index);
                }
                return this;
            }

            public EntityConfigHashEntryOuterClass.EntityConfigHashEntry.Builder getAvatarEntryListBuilder(int index) {
                return getAvatarEntryListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.EntityConfigHashNotifyOuterClass.EntityConfigHashNotifyOrBuilder
            public EntityConfigHashEntryOuterClass.EntityConfigHashEntryOrBuilder getAvatarEntryListOrBuilder(int index) {
                if (this.avatarEntryListBuilder_ == null) {
                    return this.avatarEntryList_.get(index);
                }
                return this.avatarEntryListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.EntityConfigHashNotifyOuterClass.EntityConfigHashNotifyOrBuilder
            public List<? extends EntityConfigHashEntryOuterClass.EntityConfigHashEntryOrBuilder> getAvatarEntryListOrBuilderList() {
                if (this.avatarEntryListBuilder_ != null) {
                    return this.avatarEntryListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.avatarEntryList_);
            }

            public EntityConfigHashEntryOuterClass.EntityConfigHashEntry.Builder addAvatarEntryListBuilder() {
                return getAvatarEntryListFieldBuilder().addBuilder(EntityConfigHashEntryOuterClass.EntityConfigHashEntry.getDefaultInstance());
            }

            public EntityConfigHashEntryOuterClass.EntityConfigHashEntry.Builder addAvatarEntryListBuilder(int index) {
                return getAvatarEntryListFieldBuilder().addBuilder(index, EntityConfigHashEntryOuterClass.EntityConfigHashEntry.getDefaultInstance());
            }

            public List<EntityConfigHashEntryOuterClass.EntityConfigHashEntry.Builder> getAvatarEntryListBuilderList() {
                return getAvatarEntryListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<EntityConfigHashEntryOuterClass.EntityConfigHashEntry, EntityConfigHashEntryOuterClass.EntityConfigHashEntry.Builder, EntityConfigHashEntryOuterClass.EntityConfigHashEntryOrBuilder> getAvatarEntryListFieldBuilder() {
                if (this.avatarEntryListBuilder_ == null) {
                    this.avatarEntryListBuilder_ = new RepeatedFieldBuilderV3<>(this.avatarEntryList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.avatarEntryList_ = null;
                }
                return this.avatarEntryListBuilder_;
            }

            private void ensureAbilityEntryListIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.abilityEntryList_ = new ArrayList(this.abilityEntryList_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.EntityConfigHashNotifyOuterClass.EntityConfigHashNotifyOrBuilder
            public List<EntityConfigHashEntryOuterClass.EntityConfigHashEntry> getAbilityEntryListList() {
                if (this.abilityEntryListBuilder_ == null) {
                    return Collections.unmodifiableList(this.abilityEntryList_);
                }
                return this.abilityEntryListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.EntityConfigHashNotifyOuterClass.EntityConfigHashNotifyOrBuilder
            public int getAbilityEntryListCount() {
                if (this.abilityEntryListBuilder_ == null) {
                    return this.abilityEntryList_.size();
                }
                return this.abilityEntryListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.EntityConfigHashNotifyOuterClass.EntityConfigHashNotifyOrBuilder
            public EntityConfigHashEntryOuterClass.EntityConfigHashEntry getAbilityEntryList(int index) {
                if (this.abilityEntryListBuilder_ == null) {
                    return this.abilityEntryList_.get(index);
                }
                return this.abilityEntryListBuilder_.getMessage(index);
            }

            public Builder setAbilityEntryList(int index, EntityConfigHashEntryOuterClass.EntityConfigHashEntry value) {
                if (this.abilityEntryListBuilder_ != null) {
                    this.abilityEntryListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureAbilityEntryListIsMutable();
                    this.abilityEntryList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setAbilityEntryList(int index, EntityConfigHashEntryOuterClass.EntityConfigHashEntry.Builder builderForValue) {
                if (this.abilityEntryListBuilder_ == null) {
                    ensureAbilityEntryListIsMutable();
                    this.abilityEntryList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.abilityEntryListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAbilityEntryList(EntityConfigHashEntryOuterClass.EntityConfigHashEntry value) {
                if (this.abilityEntryListBuilder_ != null) {
                    this.abilityEntryListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureAbilityEntryListIsMutable();
                    this.abilityEntryList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addAbilityEntryList(int index, EntityConfigHashEntryOuterClass.EntityConfigHashEntry value) {
                if (this.abilityEntryListBuilder_ != null) {
                    this.abilityEntryListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureAbilityEntryListIsMutable();
                    this.abilityEntryList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addAbilityEntryList(EntityConfigHashEntryOuterClass.EntityConfigHashEntry.Builder builderForValue) {
                if (this.abilityEntryListBuilder_ == null) {
                    ensureAbilityEntryListIsMutable();
                    this.abilityEntryList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.abilityEntryListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addAbilityEntryList(int index, EntityConfigHashEntryOuterClass.EntityConfigHashEntry.Builder builderForValue) {
                if (this.abilityEntryListBuilder_ == null) {
                    ensureAbilityEntryListIsMutable();
                    this.abilityEntryList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.abilityEntryListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllAbilityEntryList(Iterable<? extends EntityConfigHashEntryOuterClass.EntityConfigHashEntry> values) {
                if (this.abilityEntryListBuilder_ == null) {
                    ensureAbilityEntryListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.abilityEntryList_);
                    onChanged();
                } else {
                    this.abilityEntryListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearAbilityEntryList() {
                if (this.abilityEntryListBuilder_ == null) {
                    this.abilityEntryList_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                    onChanged();
                } else {
                    this.abilityEntryListBuilder_.clear();
                }
                return this;
            }

            public Builder removeAbilityEntryList(int index) {
                if (this.abilityEntryListBuilder_ == null) {
                    ensureAbilityEntryListIsMutable();
                    this.abilityEntryList_.remove(index);
                    onChanged();
                } else {
                    this.abilityEntryListBuilder_.remove(index);
                }
                return this;
            }

            public EntityConfigHashEntryOuterClass.EntityConfigHashEntry.Builder getAbilityEntryListBuilder(int index) {
                return getAbilityEntryListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.EntityConfigHashNotifyOuterClass.EntityConfigHashNotifyOrBuilder
            public EntityConfigHashEntryOuterClass.EntityConfigHashEntryOrBuilder getAbilityEntryListOrBuilder(int index) {
                if (this.abilityEntryListBuilder_ == null) {
                    return this.abilityEntryList_.get(index);
                }
                return this.abilityEntryListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.EntityConfigHashNotifyOuterClass.EntityConfigHashNotifyOrBuilder
            public List<? extends EntityConfigHashEntryOuterClass.EntityConfigHashEntryOrBuilder> getAbilityEntryListOrBuilderList() {
                if (this.abilityEntryListBuilder_ != null) {
                    return this.abilityEntryListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.abilityEntryList_);
            }

            public EntityConfigHashEntryOuterClass.EntityConfigHashEntry.Builder addAbilityEntryListBuilder() {
                return getAbilityEntryListFieldBuilder().addBuilder(EntityConfigHashEntryOuterClass.EntityConfigHashEntry.getDefaultInstance());
            }

            public EntityConfigHashEntryOuterClass.EntityConfigHashEntry.Builder addAbilityEntryListBuilder(int index) {
                return getAbilityEntryListFieldBuilder().addBuilder(index, EntityConfigHashEntryOuterClass.EntityConfigHashEntry.getDefaultInstance());
            }

            public List<EntityConfigHashEntryOuterClass.EntityConfigHashEntry.Builder> getAbilityEntryListBuilderList() {
                return getAbilityEntryListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<EntityConfigHashEntryOuterClass.EntityConfigHashEntry, EntityConfigHashEntryOuterClass.EntityConfigHashEntry.Builder, EntityConfigHashEntryOuterClass.EntityConfigHashEntryOrBuilder> getAbilityEntryListFieldBuilder() {
                if (this.abilityEntryListBuilder_ == null) {
                    this.abilityEntryListBuilder_ = new RepeatedFieldBuilderV3<>(this.abilityEntryList_, (this.bitField0_ & 2) != 0, getParentForChildren(), isClean());
                    this.abilityEntryList_ = null;
                }
                return this.abilityEntryListBuilder_;
            }

            private void ensureCombatEntryListIsMutable() {
                if ((this.bitField0_ & 4) == 0) {
                    this.combatEntryList_ = new ArrayList(this.combatEntryList_);
                    this.bitField0_ |= 4;
                }
            }

            @Override // emu.grasscutter.net.proto.EntityConfigHashNotifyOuterClass.EntityConfigHashNotifyOrBuilder
            public List<EntityConfigHashEntryOuterClass.EntityConfigHashEntry> getCombatEntryListList() {
                if (this.combatEntryListBuilder_ == null) {
                    return Collections.unmodifiableList(this.combatEntryList_);
                }
                return this.combatEntryListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.EntityConfigHashNotifyOuterClass.EntityConfigHashNotifyOrBuilder
            public int getCombatEntryListCount() {
                if (this.combatEntryListBuilder_ == null) {
                    return this.combatEntryList_.size();
                }
                return this.combatEntryListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.EntityConfigHashNotifyOuterClass.EntityConfigHashNotifyOrBuilder
            public EntityConfigHashEntryOuterClass.EntityConfigHashEntry getCombatEntryList(int index) {
                if (this.combatEntryListBuilder_ == null) {
                    return this.combatEntryList_.get(index);
                }
                return this.combatEntryListBuilder_.getMessage(index);
            }

            public Builder setCombatEntryList(int index, EntityConfigHashEntryOuterClass.EntityConfigHashEntry value) {
                if (this.combatEntryListBuilder_ != null) {
                    this.combatEntryListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureCombatEntryListIsMutable();
                    this.combatEntryList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setCombatEntryList(int index, EntityConfigHashEntryOuterClass.EntityConfigHashEntry.Builder builderForValue) {
                if (this.combatEntryListBuilder_ == null) {
                    ensureCombatEntryListIsMutable();
                    this.combatEntryList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.combatEntryListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addCombatEntryList(EntityConfigHashEntryOuterClass.EntityConfigHashEntry value) {
                if (this.combatEntryListBuilder_ != null) {
                    this.combatEntryListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureCombatEntryListIsMutable();
                    this.combatEntryList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addCombatEntryList(int index, EntityConfigHashEntryOuterClass.EntityConfigHashEntry value) {
                if (this.combatEntryListBuilder_ != null) {
                    this.combatEntryListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureCombatEntryListIsMutable();
                    this.combatEntryList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addCombatEntryList(EntityConfigHashEntryOuterClass.EntityConfigHashEntry.Builder builderForValue) {
                if (this.combatEntryListBuilder_ == null) {
                    ensureCombatEntryListIsMutable();
                    this.combatEntryList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.combatEntryListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addCombatEntryList(int index, EntityConfigHashEntryOuterClass.EntityConfigHashEntry.Builder builderForValue) {
                if (this.combatEntryListBuilder_ == null) {
                    ensureCombatEntryListIsMutable();
                    this.combatEntryList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.combatEntryListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllCombatEntryList(Iterable<? extends EntityConfigHashEntryOuterClass.EntityConfigHashEntry> values) {
                if (this.combatEntryListBuilder_ == null) {
                    ensureCombatEntryListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.combatEntryList_);
                    onChanged();
                } else {
                    this.combatEntryListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearCombatEntryList() {
                if (this.combatEntryListBuilder_ == null) {
                    this.combatEntryList_ = Collections.emptyList();
                    this.bitField0_ &= -5;
                    onChanged();
                } else {
                    this.combatEntryListBuilder_.clear();
                }
                return this;
            }

            public Builder removeCombatEntryList(int index) {
                if (this.combatEntryListBuilder_ == null) {
                    ensureCombatEntryListIsMutable();
                    this.combatEntryList_.remove(index);
                    onChanged();
                } else {
                    this.combatEntryListBuilder_.remove(index);
                }
                return this;
            }

            public EntityConfigHashEntryOuterClass.EntityConfigHashEntry.Builder getCombatEntryListBuilder(int index) {
                return getCombatEntryListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.EntityConfigHashNotifyOuterClass.EntityConfigHashNotifyOrBuilder
            public EntityConfigHashEntryOuterClass.EntityConfigHashEntryOrBuilder getCombatEntryListOrBuilder(int index) {
                if (this.combatEntryListBuilder_ == null) {
                    return this.combatEntryList_.get(index);
                }
                return this.combatEntryListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.EntityConfigHashNotifyOuterClass.EntityConfigHashNotifyOrBuilder
            public List<? extends EntityConfigHashEntryOuterClass.EntityConfigHashEntryOrBuilder> getCombatEntryListOrBuilderList() {
                if (this.combatEntryListBuilder_ != null) {
                    return this.combatEntryListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.combatEntryList_);
            }

            public EntityConfigHashEntryOuterClass.EntityConfigHashEntry.Builder addCombatEntryListBuilder() {
                return getCombatEntryListFieldBuilder().addBuilder(EntityConfigHashEntryOuterClass.EntityConfigHashEntry.getDefaultInstance());
            }

            public EntityConfigHashEntryOuterClass.EntityConfigHashEntry.Builder addCombatEntryListBuilder(int index) {
                return getCombatEntryListFieldBuilder().addBuilder(index, EntityConfigHashEntryOuterClass.EntityConfigHashEntry.getDefaultInstance());
            }

            public List<EntityConfigHashEntryOuterClass.EntityConfigHashEntry.Builder> getCombatEntryListBuilderList() {
                return getCombatEntryListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<EntityConfigHashEntryOuterClass.EntityConfigHashEntry, EntityConfigHashEntryOuterClass.EntityConfigHashEntry.Builder, EntityConfigHashEntryOuterClass.EntityConfigHashEntryOrBuilder> getCombatEntryListFieldBuilder() {
                if (this.combatEntryListBuilder_ == null) {
                    this.combatEntryListBuilder_ = new RepeatedFieldBuilderV3<>(this.combatEntryList_, (this.bitField0_ & 4) != 0, getParentForChildren(), isClean());
                    this.combatEntryList_ = null;
                }
                return this.combatEntryListBuilder_;
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

        public static EntityConfigHashNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<EntityConfigHashNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<EntityConfigHashNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public EntityConfigHashNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        EntityConfigHashEntryOuterClass.getDescriptor();
    }
}
