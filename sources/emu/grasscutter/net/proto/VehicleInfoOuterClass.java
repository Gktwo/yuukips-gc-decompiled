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
import emu.grasscutter.net.proto.VehicleMemberOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/VehicleInfoOuterClass.class */
public final class VehicleInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0011VehicleInfo.proto\u001a\u0013VehicleMember.proto\"Z\n\u000bVehicleInfo\u0012#\n\u000bmember_list\u0018\u0001 \u0003(\u000b2\u000e.VehicleMember\u0012\u0011\n\towner_uid\u0018\u0002 \u0001(\r\u0012\u0013\n\u000bcur_stamina\u0018\u0003 \u0001(\u0002B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{VehicleMemberOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_VehicleInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_VehicleInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_VehicleInfo_descriptor, new String[]{"MemberList", "OwnerUid", "CurStamina"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/VehicleInfoOuterClass$VehicleInfoOrBuilder.class */
    public interface VehicleInfoOrBuilder extends MessageOrBuilder {
        List<VehicleMemberOuterClass.VehicleMember> getMemberListList();

        VehicleMemberOuterClass.VehicleMember getMemberList(int i);

        int getMemberListCount();

        List<? extends VehicleMemberOuterClass.VehicleMemberOrBuilder> getMemberListOrBuilderList();

        VehicleMemberOuterClass.VehicleMemberOrBuilder getMemberListOrBuilder(int i);

        int getOwnerUid();

        float getCurStamina();
    }

    private VehicleInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/VehicleInfoOuterClass$VehicleInfo.class */
    public static final class VehicleInfo extends GeneratedMessageV3 implements VehicleInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int MEMBER_LIST_FIELD_NUMBER = 1;
        private List<VehicleMemberOuterClass.VehicleMember> memberList_;
        public static final int OWNER_UID_FIELD_NUMBER = 2;
        private int ownerUid_;
        public static final int CUR_STAMINA_FIELD_NUMBER = 3;
        private float curStamina_;
        private byte memoizedIsInitialized;
        private static final VehicleInfo DEFAULT_INSTANCE = new VehicleInfo();
        private static final Parser<VehicleInfo> PARSER = new AbstractParser<VehicleInfo>() { // from class: emu.grasscutter.net.proto.VehicleInfoOuterClass.VehicleInfo.1
            @Override // com.google.protobuf.Parser
            public VehicleInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new VehicleInfo(input, extensionRegistry);
            }
        };

        private VehicleInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private VehicleInfo() {
            this.memoizedIsInitialized = -1;
            this.memberList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new VehicleInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private VehicleInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.memberList_ = new ArrayList();
                                    mutable_bitField0_ |= 1;
                                }
                                this.memberList_.add((VehicleMemberOuterClass.VehicleMember) input.readMessage(VehicleMemberOuterClass.VehicleMember.parser(), extensionRegistry));
                                break;
                            case 16:
                                this.ownerUid_ = input.readUInt32();
                                break;
                            case 29:
                                this.curStamina_ = input.readFloat();
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
                    this.memberList_ = Collections.unmodifiableList(this.memberList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return VehicleInfoOuterClass.internal_static_VehicleInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return VehicleInfoOuterClass.internal_static_VehicleInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(VehicleInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.VehicleInfoOuterClass.VehicleInfoOrBuilder
        public List<VehicleMemberOuterClass.VehicleMember> getMemberListList() {
            return this.memberList_;
        }

        @Override // emu.grasscutter.net.proto.VehicleInfoOuterClass.VehicleInfoOrBuilder
        public List<? extends VehicleMemberOuterClass.VehicleMemberOrBuilder> getMemberListOrBuilderList() {
            return this.memberList_;
        }

        @Override // emu.grasscutter.net.proto.VehicleInfoOuterClass.VehicleInfoOrBuilder
        public int getMemberListCount() {
            return this.memberList_.size();
        }

        @Override // emu.grasscutter.net.proto.VehicleInfoOuterClass.VehicleInfoOrBuilder
        public VehicleMemberOuterClass.VehicleMember getMemberList(int index) {
            return this.memberList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.VehicleInfoOuterClass.VehicleInfoOrBuilder
        public VehicleMemberOuterClass.VehicleMemberOrBuilder getMemberListOrBuilder(int index) {
            return this.memberList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.VehicleInfoOuterClass.VehicleInfoOrBuilder
        public int getOwnerUid() {
            return this.ownerUid_;
        }

        @Override // emu.grasscutter.net.proto.VehicleInfoOuterClass.VehicleInfoOrBuilder
        public float getCurStamina() {
            return this.curStamina_;
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
            for (int i = 0; i < this.memberList_.size(); i++) {
                output.writeMessage(1, this.memberList_.get(i));
            }
            if (this.ownerUid_ != 0) {
                output.writeUInt32(2, this.ownerUid_);
            }
            if (this.curStamina_ != 0.0f) {
                output.writeFloat(3, this.curStamina_);
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
            for (int i = 0; i < this.memberList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(1, this.memberList_.get(i));
            }
            if (this.ownerUid_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(2, this.ownerUid_);
            }
            if (this.curStamina_ != 0.0f) {
                size2 += CodedOutputStream.computeFloatSize(3, this.curStamina_);
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
            if (!(obj instanceof VehicleInfo)) {
                return equals(obj);
            }
            VehicleInfo other = (VehicleInfo) obj;
            return getMemberListList().equals(other.getMemberListList()) && getOwnerUid() == other.getOwnerUid() && Float.floatToIntBits(getCurStamina()) == Float.floatToIntBits(other.getCurStamina()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getMemberListCount() > 0) {
                hash = (53 * ((37 * hash) + 1)) + getMemberListList().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * ((53 * ((37 * hash) + 2)) + getOwnerUid())) + 3)) + Float.floatToIntBits(getCurStamina()))) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static VehicleInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static VehicleInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static VehicleInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static VehicleInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static VehicleInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static VehicleInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static VehicleInfo parseFrom(InputStream input) throws IOException {
            return (VehicleInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static VehicleInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (VehicleInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static VehicleInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (VehicleInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static VehicleInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (VehicleInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static VehicleInfo parseFrom(CodedInputStream input) throws IOException {
            return (VehicleInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static VehicleInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (VehicleInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(VehicleInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/VehicleInfoOuterClass$VehicleInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements VehicleInfoOrBuilder {
            private int bitField0_;
            private List<VehicleMemberOuterClass.VehicleMember> memberList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<VehicleMemberOuterClass.VehicleMember, VehicleMemberOuterClass.VehicleMember.Builder, VehicleMemberOuterClass.VehicleMemberOrBuilder> memberListBuilder_;
            private int ownerUid_;
            private float curStamina_;

            public static final Descriptors.Descriptor getDescriptor() {
                return VehicleInfoOuterClass.internal_static_VehicleInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return VehicleInfoOuterClass.internal_static_VehicleInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(VehicleInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (VehicleInfo.alwaysUseFieldBuilders) {
                    getMemberListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.memberListBuilder_ == null) {
                    this.memberList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.memberListBuilder_.clear();
                }
                this.ownerUid_ = 0;
                this.curStamina_ = 0.0f;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return VehicleInfoOuterClass.internal_static_VehicleInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public VehicleInfo getDefaultInstanceForType() {
                return VehicleInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public VehicleInfo build() {
                VehicleInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public VehicleInfo buildPartial() {
                VehicleInfo result = new VehicleInfo(this);
                int i = this.bitField0_;
                if (this.memberListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.memberList_ = Collections.unmodifiableList(this.memberList_);
                        this.bitField0_ &= -2;
                    }
                    result.memberList_ = this.memberList_;
                } else {
                    result.memberList_ = this.memberListBuilder_.build();
                }
                result.ownerUid_ = this.ownerUid_;
                result.curStamina_ = this.curStamina_;
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
                if (other instanceof VehicleInfo) {
                    return mergeFrom((VehicleInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(VehicleInfo other) {
                if (other == VehicleInfo.getDefaultInstance()) {
                    return this;
                }
                if (this.memberListBuilder_ == null) {
                    if (!other.memberList_.isEmpty()) {
                        if (this.memberList_.isEmpty()) {
                            this.memberList_ = other.memberList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureMemberListIsMutable();
                            this.memberList_.addAll(other.memberList_);
                        }
                        onChanged();
                    }
                } else if (!other.memberList_.isEmpty()) {
                    if (this.memberListBuilder_.isEmpty()) {
                        this.memberListBuilder_.dispose();
                        this.memberListBuilder_ = null;
                        this.memberList_ = other.memberList_;
                        this.bitField0_ &= -2;
                        this.memberListBuilder_ = VehicleInfo.alwaysUseFieldBuilders ? getMemberListFieldBuilder() : null;
                    } else {
                        this.memberListBuilder_.addAllMessages(other.memberList_);
                    }
                }
                if (other.getOwnerUid() != 0) {
                    setOwnerUid(other.getOwnerUid());
                }
                if (other.getCurStamina() != 0.0f) {
                    setCurStamina(other.getCurStamina());
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
                VehicleInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = VehicleInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (VehicleInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureMemberListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.memberList_ = new ArrayList(this.memberList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.VehicleInfoOuterClass.VehicleInfoOrBuilder
            public List<VehicleMemberOuterClass.VehicleMember> getMemberListList() {
                if (this.memberListBuilder_ == null) {
                    return Collections.unmodifiableList(this.memberList_);
                }
                return this.memberListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.VehicleInfoOuterClass.VehicleInfoOrBuilder
            public int getMemberListCount() {
                if (this.memberListBuilder_ == null) {
                    return this.memberList_.size();
                }
                return this.memberListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.VehicleInfoOuterClass.VehicleInfoOrBuilder
            public VehicleMemberOuterClass.VehicleMember getMemberList(int index) {
                if (this.memberListBuilder_ == null) {
                    return this.memberList_.get(index);
                }
                return this.memberListBuilder_.getMessage(index);
            }

            public Builder setMemberList(int index, VehicleMemberOuterClass.VehicleMember value) {
                if (this.memberListBuilder_ != null) {
                    this.memberListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureMemberListIsMutable();
                    this.memberList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setMemberList(int index, VehicleMemberOuterClass.VehicleMember.Builder builderForValue) {
                if (this.memberListBuilder_ == null) {
                    ensureMemberListIsMutable();
                    this.memberList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.memberListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addMemberList(VehicleMemberOuterClass.VehicleMember value) {
                if (this.memberListBuilder_ != null) {
                    this.memberListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureMemberListIsMutable();
                    this.memberList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addMemberList(int index, VehicleMemberOuterClass.VehicleMember value) {
                if (this.memberListBuilder_ != null) {
                    this.memberListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureMemberListIsMutable();
                    this.memberList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addMemberList(VehicleMemberOuterClass.VehicleMember.Builder builderForValue) {
                if (this.memberListBuilder_ == null) {
                    ensureMemberListIsMutable();
                    this.memberList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.memberListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addMemberList(int index, VehicleMemberOuterClass.VehicleMember.Builder builderForValue) {
                if (this.memberListBuilder_ == null) {
                    ensureMemberListIsMutable();
                    this.memberList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.memberListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllMemberList(Iterable<? extends VehicleMemberOuterClass.VehicleMember> values) {
                if (this.memberListBuilder_ == null) {
                    ensureMemberListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.memberList_);
                    onChanged();
                } else {
                    this.memberListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearMemberList() {
                if (this.memberListBuilder_ == null) {
                    this.memberList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.memberListBuilder_.clear();
                }
                return this;
            }

            public Builder removeMemberList(int index) {
                if (this.memberListBuilder_ == null) {
                    ensureMemberListIsMutable();
                    this.memberList_.remove(index);
                    onChanged();
                } else {
                    this.memberListBuilder_.remove(index);
                }
                return this;
            }

            public VehicleMemberOuterClass.VehicleMember.Builder getMemberListBuilder(int index) {
                return getMemberListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.VehicleInfoOuterClass.VehicleInfoOrBuilder
            public VehicleMemberOuterClass.VehicleMemberOrBuilder getMemberListOrBuilder(int index) {
                if (this.memberListBuilder_ == null) {
                    return this.memberList_.get(index);
                }
                return this.memberListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.VehicleInfoOuterClass.VehicleInfoOrBuilder
            public List<? extends VehicleMemberOuterClass.VehicleMemberOrBuilder> getMemberListOrBuilderList() {
                if (this.memberListBuilder_ != null) {
                    return this.memberListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.memberList_);
            }

            public VehicleMemberOuterClass.VehicleMember.Builder addMemberListBuilder() {
                return getMemberListFieldBuilder().addBuilder(VehicleMemberOuterClass.VehicleMember.getDefaultInstance());
            }

            public VehicleMemberOuterClass.VehicleMember.Builder addMemberListBuilder(int index) {
                return getMemberListFieldBuilder().addBuilder(index, VehicleMemberOuterClass.VehicleMember.getDefaultInstance());
            }

            public List<VehicleMemberOuterClass.VehicleMember.Builder> getMemberListBuilderList() {
                return getMemberListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<VehicleMemberOuterClass.VehicleMember, VehicleMemberOuterClass.VehicleMember.Builder, VehicleMemberOuterClass.VehicleMemberOrBuilder> getMemberListFieldBuilder() {
                if (this.memberListBuilder_ == null) {
                    this.memberListBuilder_ = new RepeatedFieldBuilderV3<>(this.memberList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.memberList_ = null;
                }
                return this.memberListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.VehicleInfoOuterClass.VehicleInfoOrBuilder
            public int getOwnerUid() {
                return this.ownerUid_;
            }

            public Builder setOwnerUid(int value) {
                this.ownerUid_ = value;
                onChanged();
                return this;
            }

            public Builder clearOwnerUid() {
                this.ownerUid_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.VehicleInfoOuterClass.VehicleInfoOrBuilder
            public float getCurStamina() {
                return this.curStamina_;
            }

            public Builder setCurStamina(float value) {
                this.curStamina_ = value;
                onChanged();
                return this;
            }

            public Builder clearCurStamina() {
                this.curStamina_ = 0.0f;
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

        public static VehicleInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<VehicleInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<VehicleInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public VehicleInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        VehicleMemberOuterClass.getDescriptor();
    }
}
