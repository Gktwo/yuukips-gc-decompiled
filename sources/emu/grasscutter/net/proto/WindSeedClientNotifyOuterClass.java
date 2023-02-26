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
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.VectorOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WindSeedClientNotifyOuterClass.class */
public final class WindSeedClientNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001aWindSeedClientNotify.proto\u001a\fVector.proto\"·\u0003\n\u0014WindSeedClientNotify\u0012=\n\u000erefresh_notify\u0018\u000b \u0001(\u000b2#.WindSeedClientNotify.RefreshNotifyH��\u0012K\n\u0016add_wind_bullet_notify\u0018\b \u0001(\u000b2).WindSeedClientNotify.AddWindBulletNotifyH��\u00127\n\u000barea_notify\u0018\u0002 \u0001(\u000b2 .WindSeedClientNotify.AreaNotifyH��\u001a#\n\rRefreshNotify\u0012\u0012\n\nrefreshNum\u0018\r \u0001(\r\u001ai\n\u0013AddWindBulletNotify\u0012\u001b\n\u0013Unk3300_CKIKKCAFJBC\u0018\u0001 \u0001(\r\u0012\u0018\n\u0007seedPos\u0018\n \u0001(\u000b2\u0007.Vector\u0012\u001b\n\u0013Unk3300_MPDFAPBDJAH\u0018\r \u0001(\r\u001a@\n\nAreaNotify\u0012\u0010\n\bareaType\u0018\u0005 \u0001(\r\u0012\u000e\n\u0006areaId\u0018\f \u0001(\r\u0012\u0010\n\bareaCode\u0018\u0001 \u0001(\fB\b\n\u0006notifyB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{VectorOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_WindSeedClientNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_WindSeedClientNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_WindSeedClientNotify_descriptor, new String[]{"RefreshNotify", "AddWindBulletNotify", "AreaNotify", "Notify"});
    private static final Descriptors.Descriptor internal_static_WindSeedClientNotify_RefreshNotify_descriptor = internal_static_WindSeedClientNotify_descriptor.getNestedTypes().get(0);

    /* renamed from: internal_static_WindSeedClientNotify_RefreshNotify_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f907x84898e0b = new GeneratedMessageV3.FieldAccessorTable(internal_static_WindSeedClientNotify_RefreshNotify_descriptor, new String[]{"RefreshNum"});

    /* renamed from: internal_static_WindSeedClientNotify_AddWindBulletNotify_descriptor */
    private static final Descriptors.Descriptor f908x4955887d = internal_static_WindSeedClientNotify_descriptor.getNestedTypes().get(1);

    /* renamed from: internal_static_WindSeedClientNotify_AddWindBulletNotify_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f909x826e1fb = new GeneratedMessageV3.FieldAccessorTable(f908x4955887d, new String[]{"Unk3300CKIKKCAFJBC", "SeedPos", "Unk3300MPDFAPBDJAH"});
    private static final Descriptors.Descriptor internal_static_WindSeedClientNotify_AreaNotify_descriptor = internal_static_WindSeedClientNotify_descriptor.getNestedTypes().get(2);

    /* renamed from: internal_static_WindSeedClientNotify_AreaNotify_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f910xee7a6173 = new GeneratedMessageV3.FieldAccessorTable(internal_static_WindSeedClientNotify_AreaNotify_descriptor, new String[]{"AreaType", "AreaId", "AreaCode"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WindSeedClientNotifyOuterClass$WindSeedClientNotifyOrBuilder.class */
    public interface WindSeedClientNotifyOrBuilder extends MessageOrBuilder {
        boolean hasRefreshNotify();

        WindSeedClientNotify.RefreshNotify getRefreshNotify();

        WindSeedClientNotify.RefreshNotifyOrBuilder getRefreshNotifyOrBuilder();

        boolean hasAddWindBulletNotify();

        WindSeedClientNotify.AddWindBulletNotify getAddWindBulletNotify();

        WindSeedClientNotify.AddWindBulletNotifyOrBuilder getAddWindBulletNotifyOrBuilder();

        boolean hasAreaNotify();

        WindSeedClientNotify.AreaNotify getAreaNotify();

        WindSeedClientNotify.AreaNotifyOrBuilder getAreaNotifyOrBuilder();

        WindSeedClientNotify.NotifyCase getNotifyCase();
    }

    private WindSeedClientNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WindSeedClientNotifyOuterClass$WindSeedClientNotify.class */
    public static final class WindSeedClientNotify extends GeneratedMessageV3 implements WindSeedClientNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        private int notifyCase_;
        private Object notify_;
        public static final int REFRESH_NOTIFY_FIELD_NUMBER = 11;
        public static final int ADD_WIND_BULLET_NOTIFY_FIELD_NUMBER = 8;
        public static final int AREA_NOTIFY_FIELD_NUMBER = 2;
        private byte memoizedIsInitialized;
        private static final WindSeedClientNotify DEFAULT_INSTANCE = new WindSeedClientNotify();
        private static final Parser<WindSeedClientNotify> PARSER = new AbstractParser<WindSeedClientNotify>() { // from class: emu.grasscutter.net.proto.WindSeedClientNotifyOuterClass.WindSeedClientNotify.1
            @Override // com.google.protobuf.Parser
            public WindSeedClientNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new WindSeedClientNotify(input, extensionRegistry);
            }
        };

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WindSeedClientNotifyOuterClass$WindSeedClientNotify$AddWindBulletNotifyOrBuilder.class */
        public interface AddWindBulletNotifyOrBuilder extends MessageOrBuilder {
            int getUnk3300CKIKKCAFJBC();

            boolean hasSeedPos();

            VectorOuterClass.Vector getSeedPos();

            VectorOuterClass.VectorOrBuilder getSeedPosOrBuilder();

            int getUnk3300MPDFAPBDJAH();
        }

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WindSeedClientNotifyOuterClass$WindSeedClientNotify$AreaNotifyOrBuilder.class */
        public interface AreaNotifyOrBuilder extends MessageOrBuilder {
            int getAreaType();

            int getAreaId();

            ByteString getAreaCode();
        }

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WindSeedClientNotifyOuterClass$WindSeedClientNotify$RefreshNotifyOrBuilder.class */
        public interface RefreshNotifyOrBuilder extends MessageOrBuilder {
            int getRefreshNum();
        }

        private WindSeedClientNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.notifyCase_ = 0;
            this.memoizedIsInitialized = -1;
        }

        private WindSeedClientNotify() {
            this.notifyCase_ = 0;
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new WindSeedClientNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private WindSeedClientNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this();
            UnknownFieldSet.Builder unknownFields;
            if (extensionRegistry == null) {
                throw new NullPointerException();
            }
            try {
                unknownFields = UnknownFieldSet.newBuilder();
                boolean done = false;
                while (!done) {
                    try {
                        int tag = input.readTag();
                        switch (tag) {
                            case 0:
                                done = true;
                                break;
                            case 18:
                                AreaNotify.Builder subBuilder = this.notifyCase_ == 2 ? ((AreaNotify) this.notify_).toBuilder() : null;
                                this.notify_ = input.readMessage(AreaNotify.parser(), extensionRegistry);
                                if (subBuilder != null) {
                                    subBuilder.mergeFrom((AreaNotify) this.notify_);
                                    this.notify_ = subBuilder.buildPartial();
                                }
                                this.notifyCase_ = 2;
                                break;
                            case 66:
                                AddWindBulletNotify.Builder subBuilder2 = this.notifyCase_ == 8 ? ((AddWindBulletNotify) this.notify_).toBuilder() : null;
                                this.notify_ = input.readMessage(AddWindBulletNotify.parser(), extensionRegistry);
                                if (subBuilder2 != null) {
                                    subBuilder2.mergeFrom((AddWindBulletNotify) this.notify_);
                                    this.notify_ = subBuilder2.buildPartial();
                                }
                                this.notifyCase_ = 8;
                                break;
                            case 90:
                                RefreshNotify.Builder subBuilder3 = this.notifyCase_ == 11 ? ((RefreshNotify) this.notify_).toBuilder() : null;
                                this.notify_ = input.readMessage(RefreshNotify.parser(), extensionRegistry);
                                if (subBuilder3 != null) {
                                    subBuilder3.mergeFrom((RefreshNotify) this.notify_);
                                    this.notify_ = subBuilder3.buildPartial();
                                }
                                this.notifyCase_ = 11;
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
            return WindSeedClientNotifyOuterClass.internal_static_WindSeedClientNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return WindSeedClientNotifyOuterClass.internal_static_WindSeedClientNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(WindSeedClientNotify.class, Builder.class);
        }

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WindSeedClientNotifyOuterClass$WindSeedClientNotify$RefreshNotify.class */
        public static final class RefreshNotify extends GeneratedMessageV3 implements RefreshNotifyOrBuilder {
            private static final long serialVersionUID = 0;
            public static final int REFRESHNUM_FIELD_NUMBER = 13;
            private int refreshNum_;
            private byte memoizedIsInitialized;
            private static final RefreshNotify DEFAULT_INSTANCE = new RefreshNotify();
            private static final Parser<RefreshNotify> PARSER = new AbstractParser<RefreshNotify>() { // from class: emu.grasscutter.net.proto.WindSeedClientNotifyOuterClass.WindSeedClientNotify.RefreshNotify.1
                @Override // com.google.protobuf.Parser
                public RefreshNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                    return new RefreshNotify(input, extensionRegistry);
                }
            };

            private RefreshNotify(GeneratedMessageV3.Builder<?> builder) {
                super(builder);
                this.memoizedIsInitialized = -1;
            }

            private RefreshNotify() {
                this.memoizedIsInitialized = -1;
            }

            /* access modifiers changed from: protected */
            @Override // com.google.protobuf.GeneratedMessageV3
            public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
                return new RefreshNotify();
            }

            @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
            public final UnknownFieldSet getUnknownFields() {
                return this.unknownFields;
            }

            private RefreshNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                this();
                UnknownFieldSet.Builder unknownFields;
                if (extensionRegistry == null) {
                    throw new NullPointerException();
                }
                try {
                    unknownFields = UnknownFieldSet.newBuilder();
                    boolean done = false;
                    while (!done) {
                        try {
                            int tag = input.readTag();
                            switch (tag) {
                                case 0:
                                    done = true;
                                    break;
                                case 104:
                                    this.refreshNum_ = input.readUInt32();
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
                return WindSeedClientNotifyOuterClass.internal_static_WindSeedClientNotify_RefreshNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return WindSeedClientNotifyOuterClass.f907x84898e0b.ensureFieldAccessorsInitialized(RefreshNotify.class, Builder.class);
            }

            @Override // emu.grasscutter.net.proto.WindSeedClientNotifyOuterClass.WindSeedClientNotify.RefreshNotifyOrBuilder
            public int getRefreshNum() {
                return this.refreshNum_;
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
                if (this.refreshNum_ != 0) {
                    output.writeUInt32(13, this.refreshNum_);
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
                if (this.refreshNum_ != 0) {
                    size2 = 0 + CodedOutputStream.computeUInt32Size(13, this.refreshNum_);
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
                if (!(obj instanceof RefreshNotify)) {
                    return equals(obj);
                }
                RefreshNotify other = (RefreshNotify) obj;
                return getRefreshNum() == other.getRefreshNum() && this.unknownFields.equals(other.unknownFields);
            }

            @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
            public int hashCode() {
                if (this.memoizedHashCode != 0) {
                    return this.memoizedHashCode;
                }
                int hash = (29 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 13)) + getRefreshNum())) + this.unknownFields.hashCode();
                this.memoizedHashCode = hash;
                return hash;
            }

            public static RefreshNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(data);
            }

            public static RefreshNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(data, extensionRegistry);
            }

            public static RefreshNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(data);
            }

            public static RefreshNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(data, extensionRegistry);
            }

            public static RefreshNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(data);
            }

            public static RefreshNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(data, extensionRegistry);
            }

            public static RefreshNotify parseFrom(InputStream input) throws IOException {
                return (RefreshNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
            }

            public static RefreshNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (RefreshNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
            }

            public static RefreshNotify parseDelimitedFrom(InputStream input) throws IOException {
                return (RefreshNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
            }

            public static RefreshNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (RefreshNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
            }

            public static RefreshNotify parseFrom(CodedInputStream input) throws IOException {
                return (RefreshNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
            }

            public static RefreshNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (RefreshNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
            }

            @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
            public Builder newBuilderForType() {
                return newBuilder();
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.toBuilder();
            }

            public static Builder newBuilder(RefreshNotify prototype) {
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

            /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WindSeedClientNotifyOuterClass$WindSeedClientNotify$RefreshNotify$Builder.class */
            public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements RefreshNotifyOrBuilder {
                private int refreshNum_;

                public static final Descriptors.Descriptor getDescriptor() {
                    return WindSeedClientNotifyOuterClass.internal_static_WindSeedClientNotify_RefreshNotify_descriptor;
                }

                @Override // com.google.protobuf.GeneratedMessageV3.Builder
                protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                    return WindSeedClientNotifyOuterClass.f907x84898e0b.ensureFieldAccessorsInitialized(RefreshNotify.class, Builder.class);
                }

                private Builder() {
                    maybeForceBuilderInitialization();
                }

                private Builder(GeneratedMessageV3.BuilderParent parent) {
                    super(parent);
                    maybeForceBuilderInitialization();
                }

                private void maybeForceBuilderInitialization() {
                    if (RefreshNotify.alwaysUseFieldBuilders) {
                    }
                }

                @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public Builder clear() {
                    clear();
                    this.refreshNum_ = 0;
                    return this;
                }

                @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
                public Descriptors.Descriptor getDescriptorForType() {
                    return WindSeedClientNotifyOuterClass.internal_static_WindSeedClientNotify_RefreshNotify_descriptor;
                }

                @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
                public RefreshNotify getDefaultInstanceForType() {
                    return RefreshNotify.getDefaultInstance();
                }

                @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public RefreshNotify build() {
                    RefreshNotify result = buildPartial();
                    if (result.isInitialized()) {
                        return result;
                    }
                    throw newUninitializedMessageException((Message) result);
                }

                @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public RefreshNotify buildPartial() {
                    RefreshNotify result = new RefreshNotify(this);
                    result.refreshNum_ = this.refreshNum_;
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
                    if (other instanceof RefreshNotify) {
                        return mergeFrom((RefreshNotify) other);
                    }
                    mergeFrom(other);
                    return this;
                }

                public Builder mergeFrom(RefreshNotify other) {
                    if (other == RefreshNotify.getDefaultInstance()) {
                        return this;
                    }
                    if (other.getRefreshNum() != 0) {
                        setRefreshNum(other.getRefreshNum());
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
                    RefreshNotify parsedMessage = null;
                    try {
                        try {
                            parsedMessage = RefreshNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                            if (parsedMessage != null) {
                                mergeFrom(parsedMessage);
                            }
                            return this;
                        } catch (InvalidProtocolBufferException e) {
                            parsedMessage = (RefreshNotify) e.getUnfinishedMessage();
                            throw e.unwrapIOException();
                        }
                    } catch (Throwable th) {
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        throw th;
                    }
                }

                @Override // emu.grasscutter.net.proto.WindSeedClientNotifyOuterClass.WindSeedClientNotify.RefreshNotifyOrBuilder
                public int getRefreshNum() {
                    return this.refreshNum_;
                }

                public Builder setRefreshNum(int value) {
                    this.refreshNum_ = value;
                    onChanged();
                    return this;
                }

                public Builder clearRefreshNum() {
                    this.refreshNum_ = 0;
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

            public static RefreshNotify getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Parser<RefreshNotify> parser() {
                return PARSER;
            }

            @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
            public Parser<RefreshNotify> getParserForType() {
                return PARSER;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public RefreshNotify getDefaultInstanceForType() {
                return DEFAULT_INSTANCE;
            }
        }

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WindSeedClientNotifyOuterClass$WindSeedClientNotify$AddWindBulletNotify.class */
        public static final class AddWindBulletNotify extends GeneratedMessageV3 implements AddWindBulletNotifyOrBuilder {
            private static final long serialVersionUID = 0;
            public static final int UNK3300_CKIKKCAFJBC_FIELD_NUMBER = 1;
            private int unk3300CKIKKCAFJBC_;
            public static final int SEEDPOS_FIELD_NUMBER = 10;
            private VectorOuterClass.Vector seedPos_;
            public static final int UNK3300_MPDFAPBDJAH_FIELD_NUMBER = 13;
            private int unk3300MPDFAPBDJAH_;
            private byte memoizedIsInitialized;
            private static final AddWindBulletNotify DEFAULT_INSTANCE = new AddWindBulletNotify();
            private static final Parser<AddWindBulletNotify> PARSER = new AbstractParser<AddWindBulletNotify>() { // from class: emu.grasscutter.net.proto.WindSeedClientNotifyOuterClass.WindSeedClientNotify.AddWindBulletNotify.1
                @Override // com.google.protobuf.Parser
                public AddWindBulletNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                    return new AddWindBulletNotify(input, extensionRegistry);
                }
            };

            private AddWindBulletNotify(GeneratedMessageV3.Builder<?> builder) {
                super(builder);
                this.memoizedIsInitialized = -1;
            }

            private AddWindBulletNotify() {
                this.memoizedIsInitialized = -1;
            }

            /* access modifiers changed from: protected */
            @Override // com.google.protobuf.GeneratedMessageV3
            public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
                return new AddWindBulletNotify();
            }

            @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
            public final UnknownFieldSet getUnknownFields() {
                return this.unknownFields;
            }

            private AddWindBulletNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                this();
                UnknownFieldSet.Builder unknownFields;
                if (extensionRegistry == null) {
                    throw new NullPointerException();
                }
                try {
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
                                        this.unk3300CKIKKCAFJBC_ = input.readUInt32();
                                        break;
                                    case 82:
                                        VectorOuterClass.Vector.Builder subBuilder = this.seedPos_ != null ? this.seedPos_.toBuilder() : null;
                                        this.seedPos_ = (VectorOuterClass.Vector) input.readMessage(VectorOuterClass.Vector.parser(), extensionRegistry);
                                        if (subBuilder == null) {
                                            break;
                                        } else {
                                            subBuilder.mergeFrom(this.seedPos_);
                                            this.seedPos_ = subBuilder.buildPartial();
                                            break;
                                        }
                                    case 104:
                                        this.unk3300MPDFAPBDJAH_ = input.readUInt32();
                                        break;
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
                return WindSeedClientNotifyOuterClass.f908x4955887d;
            }

            @Override // com.google.protobuf.GeneratedMessageV3
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return WindSeedClientNotifyOuterClass.f909x826e1fb.ensureFieldAccessorsInitialized(AddWindBulletNotify.class, Builder.class);
            }

            @Override // emu.grasscutter.net.proto.WindSeedClientNotifyOuterClass.WindSeedClientNotify.AddWindBulletNotifyOrBuilder
            public int getUnk3300CKIKKCAFJBC() {
                return this.unk3300CKIKKCAFJBC_;
            }

            @Override // emu.grasscutter.net.proto.WindSeedClientNotifyOuterClass.WindSeedClientNotify.AddWindBulletNotifyOrBuilder
            public boolean hasSeedPos() {
                return this.seedPos_ != null;
            }

            @Override // emu.grasscutter.net.proto.WindSeedClientNotifyOuterClass.WindSeedClientNotify.AddWindBulletNotifyOrBuilder
            public VectorOuterClass.Vector getSeedPos() {
                return this.seedPos_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.seedPos_;
            }

            @Override // emu.grasscutter.net.proto.WindSeedClientNotifyOuterClass.WindSeedClientNotify.AddWindBulletNotifyOrBuilder
            public VectorOuterClass.VectorOrBuilder getSeedPosOrBuilder() {
                return getSeedPos();
            }

            @Override // emu.grasscutter.net.proto.WindSeedClientNotifyOuterClass.WindSeedClientNotify.AddWindBulletNotifyOrBuilder
            public int getUnk3300MPDFAPBDJAH() {
                return this.unk3300MPDFAPBDJAH_;
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
                if (this.unk3300CKIKKCAFJBC_ != 0) {
                    output.writeUInt32(1, this.unk3300CKIKKCAFJBC_);
                }
                if (this.seedPos_ != null) {
                    output.writeMessage(10, getSeedPos());
                }
                if (this.unk3300MPDFAPBDJAH_ != 0) {
                    output.writeUInt32(13, this.unk3300MPDFAPBDJAH_);
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
                if (this.unk3300CKIKKCAFJBC_ != 0) {
                    size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.unk3300CKIKKCAFJBC_);
                }
                if (this.seedPos_ != null) {
                    size2 += CodedOutputStream.computeMessageSize(10, getSeedPos());
                }
                if (this.unk3300MPDFAPBDJAH_ != 0) {
                    size2 += CodedOutputStream.computeUInt32Size(13, this.unk3300MPDFAPBDJAH_);
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
                if (!(obj instanceof AddWindBulletNotify)) {
                    return equals(obj);
                }
                AddWindBulletNotify other = (AddWindBulletNotify) obj;
                if (getUnk3300CKIKKCAFJBC() == other.getUnk3300CKIKKCAFJBC() && hasSeedPos() == other.hasSeedPos()) {
                    return (!hasSeedPos() || getSeedPos().equals(other.getSeedPos())) && getUnk3300MPDFAPBDJAH() == other.getUnk3300MPDFAPBDJAH() && this.unknownFields.equals(other.unknownFields);
                }
                return false;
            }

            @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
            public int hashCode() {
                if (this.memoizedHashCode != 0) {
                    return this.memoizedHashCode;
                }
                int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + getUnk3300CKIKKCAFJBC();
                if (hasSeedPos()) {
                    hash = (53 * ((37 * hash) + 10)) + getSeedPos().hashCode();
                }
                int hash2 = (29 * ((53 * ((37 * hash) + 13)) + getUnk3300MPDFAPBDJAH())) + this.unknownFields.hashCode();
                this.memoizedHashCode = hash2;
                return hash2;
            }

            public static AddWindBulletNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(data);
            }

            public static AddWindBulletNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(data, extensionRegistry);
            }

            public static AddWindBulletNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(data);
            }

            public static AddWindBulletNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(data, extensionRegistry);
            }

            public static AddWindBulletNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(data);
            }

            public static AddWindBulletNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(data, extensionRegistry);
            }

            public static AddWindBulletNotify parseFrom(InputStream input) throws IOException {
                return (AddWindBulletNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
            }

            public static AddWindBulletNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (AddWindBulletNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
            }

            public static AddWindBulletNotify parseDelimitedFrom(InputStream input) throws IOException {
                return (AddWindBulletNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
            }

            public static AddWindBulletNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (AddWindBulletNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
            }

            public static AddWindBulletNotify parseFrom(CodedInputStream input) throws IOException {
                return (AddWindBulletNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
            }

            public static AddWindBulletNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (AddWindBulletNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
            }

            @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
            public Builder newBuilderForType() {
                return newBuilder();
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.toBuilder();
            }

            public static Builder newBuilder(AddWindBulletNotify prototype) {
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

            /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WindSeedClientNotifyOuterClass$WindSeedClientNotify$AddWindBulletNotify$Builder.class */
            public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AddWindBulletNotifyOrBuilder {
                private int unk3300CKIKKCAFJBC_;
                private VectorOuterClass.Vector seedPos_;
                private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> seedPosBuilder_;
                private int unk3300MPDFAPBDJAH_;

                public static final Descriptors.Descriptor getDescriptor() {
                    return WindSeedClientNotifyOuterClass.f908x4955887d;
                }

                @Override // com.google.protobuf.GeneratedMessageV3.Builder
                protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                    return WindSeedClientNotifyOuterClass.f909x826e1fb.ensureFieldAccessorsInitialized(AddWindBulletNotify.class, Builder.class);
                }

                private Builder() {
                    maybeForceBuilderInitialization();
                }

                private Builder(GeneratedMessageV3.BuilderParent parent) {
                    super(parent);
                    maybeForceBuilderInitialization();
                }

                private void maybeForceBuilderInitialization() {
                    if (AddWindBulletNotify.alwaysUseFieldBuilders) {
                    }
                }

                @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public Builder clear() {
                    clear();
                    this.unk3300CKIKKCAFJBC_ = 0;
                    if (this.seedPosBuilder_ == null) {
                        this.seedPos_ = null;
                    } else {
                        this.seedPos_ = null;
                        this.seedPosBuilder_ = null;
                    }
                    this.unk3300MPDFAPBDJAH_ = 0;
                    return this;
                }

                @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
                public Descriptors.Descriptor getDescriptorForType() {
                    return WindSeedClientNotifyOuterClass.f908x4955887d;
                }

                @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
                public AddWindBulletNotify getDefaultInstanceForType() {
                    return AddWindBulletNotify.getDefaultInstance();
                }

                @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public AddWindBulletNotify build() {
                    AddWindBulletNotify result = buildPartial();
                    if (result.isInitialized()) {
                        return result;
                    }
                    throw newUninitializedMessageException((Message) result);
                }

                @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public AddWindBulletNotify buildPartial() {
                    AddWindBulletNotify result = new AddWindBulletNotify(this);
                    result.unk3300CKIKKCAFJBC_ = this.unk3300CKIKKCAFJBC_;
                    if (this.seedPosBuilder_ == null) {
                        result.seedPos_ = this.seedPos_;
                    } else {
                        result.seedPos_ = this.seedPosBuilder_.build();
                    }
                    result.unk3300MPDFAPBDJAH_ = this.unk3300MPDFAPBDJAH_;
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
                    if (other instanceof AddWindBulletNotify) {
                        return mergeFrom((AddWindBulletNotify) other);
                    }
                    mergeFrom(other);
                    return this;
                }

                public Builder mergeFrom(AddWindBulletNotify other) {
                    if (other == AddWindBulletNotify.getDefaultInstance()) {
                        return this;
                    }
                    if (other.getUnk3300CKIKKCAFJBC() != 0) {
                        setUnk3300CKIKKCAFJBC(other.getUnk3300CKIKKCAFJBC());
                    }
                    if (other.hasSeedPos()) {
                        mergeSeedPos(other.getSeedPos());
                    }
                    if (other.getUnk3300MPDFAPBDJAH() != 0) {
                        setUnk3300MPDFAPBDJAH(other.getUnk3300MPDFAPBDJAH());
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
                    AddWindBulletNotify parsedMessage = null;
                    try {
                        try {
                            parsedMessage = AddWindBulletNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                            if (parsedMessage != null) {
                                mergeFrom(parsedMessage);
                            }
                            return this;
                        } catch (InvalidProtocolBufferException e) {
                            parsedMessage = (AddWindBulletNotify) e.getUnfinishedMessage();
                            throw e.unwrapIOException();
                        }
                    } catch (Throwable th) {
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        throw th;
                    }
                }

                @Override // emu.grasscutter.net.proto.WindSeedClientNotifyOuterClass.WindSeedClientNotify.AddWindBulletNotifyOrBuilder
                public int getUnk3300CKIKKCAFJBC() {
                    return this.unk3300CKIKKCAFJBC_;
                }

                public Builder setUnk3300CKIKKCAFJBC(int value) {
                    this.unk3300CKIKKCAFJBC_ = value;
                    onChanged();
                    return this;
                }

                public Builder clearUnk3300CKIKKCAFJBC() {
                    this.unk3300CKIKKCAFJBC_ = 0;
                    onChanged();
                    return this;
                }

                @Override // emu.grasscutter.net.proto.WindSeedClientNotifyOuterClass.WindSeedClientNotify.AddWindBulletNotifyOrBuilder
                public boolean hasSeedPos() {
                    return (this.seedPosBuilder_ == null && this.seedPos_ == null) ? false : true;
                }

                @Override // emu.grasscutter.net.proto.WindSeedClientNotifyOuterClass.WindSeedClientNotify.AddWindBulletNotifyOrBuilder
                public VectorOuterClass.Vector getSeedPos() {
                    if (this.seedPosBuilder_ == null) {
                        return this.seedPos_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.seedPos_;
                    }
                    return this.seedPosBuilder_.getMessage();
                }

                public Builder setSeedPos(VectorOuterClass.Vector value) {
                    if (this.seedPosBuilder_ != null) {
                        this.seedPosBuilder_.setMessage(value);
                    } else if (value == null) {
                        throw new NullPointerException();
                    } else {
                        this.seedPos_ = value;
                        onChanged();
                    }
                    return this;
                }

                public Builder setSeedPos(VectorOuterClass.Vector.Builder builderForValue) {
                    if (this.seedPosBuilder_ == null) {
                        this.seedPos_ = builderForValue.build();
                        onChanged();
                    } else {
                        this.seedPosBuilder_.setMessage(builderForValue.build());
                    }
                    return this;
                }

                public Builder mergeSeedPos(VectorOuterClass.Vector value) {
                    if (this.seedPosBuilder_ == null) {
                        if (this.seedPos_ != null) {
                            this.seedPos_ = VectorOuterClass.Vector.newBuilder(this.seedPos_).mergeFrom(value).buildPartial();
                        } else {
                            this.seedPos_ = value;
                        }
                        onChanged();
                    } else {
                        this.seedPosBuilder_.mergeFrom(value);
                    }
                    return this;
                }

                public Builder clearSeedPos() {
                    if (this.seedPosBuilder_ == null) {
                        this.seedPos_ = null;
                        onChanged();
                    } else {
                        this.seedPos_ = null;
                        this.seedPosBuilder_ = null;
                    }
                    return this;
                }

                public VectorOuterClass.Vector.Builder getSeedPosBuilder() {
                    onChanged();
                    return getSeedPosFieldBuilder().getBuilder();
                }

                @Override // emu.grasscutter.net.proto.WindSeedClientNotifyOuterClass.WindSeedClientNotify.AddWindBulletNotifyOrBuilder
                public VectorOuterClass.VectorOrBuilder getSeedPosOrBuilder() {
                    if (this.seedPosBuilder_ != null) {
                        return this.seedPosBuilder_.getMessageOrBuilder();
                    }
                    return this.seedPos_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.seedPos_;
                }

                private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> getSeedPosFieldBuilder() {
                    if (this.seedPosBuilder_ == null) {
                        this.seedPosBuilder_ = new SingleFieldBuilderV3<>(getSeedPos(), getParentForChildren(), isClean());
                        this.seedPos_ = null;
                    }
                    return this.seedPosBuilder_;
                }

                @Override // emu.grasscutter.net.proto.WindSeedClientNotifyOuterClass.WindSeedClientNotify.AddWindBulletNotifyOrBuilder
                public int getUnk3300MPDFAPBDJAH() {
                    return this.unk3300MPDFAPBDJAH_;
                }

                public Builder setUnk3300MPDFAPBDJAH(int value) {
                    this.unk3300MPDFAPBDJAH_ = value;
                    onChanged();
                    return this;
                }

                public Builder clearUnk3300MPDFAPBDJAH() {
                    this.unk3300MPDFAPBDJAH_ = 0;
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

            public static AddWindBulletNotify getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Parser<AddWindBulletNotify> parser() {
                return PARSER;
            }

            @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
            public Parser<AddWindBulletNotify> getParserForType() {
                return PARSER;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public AddWindBulletNotify getDefaultInstanceForType() {
                return DEFAULT_INSTANCE;
            }
        }

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WindSeedClientNotifyOuterClass$WindSeedClientNotify$AreaNotify.class */
        public static final class AreaNotify extends GeneratedMessageV3 implements AreaNotifyOrBuilder {
            private static final long serialVersionUID = 0;
            public static final int AREATYPE_FIELD_NUMBER = 5;
            private int areaType_;
            public static final int AREAID_FIELD_NUMBER = 12;
            private int areaId_;
            public static final int AREACODE_FIELD_NUMBER = 1;
            private ByteString areaCode_;
            private byte memoizedIsInitialized;
            private static final AreaNotify DEFAULT_INSTANCE = new AreaNotify();
            private static final Parser<AreaNotify> PARSER = new AbstractParser<AreaNotify>() { // from class: emu.grasscutter.net.proto.WindSeedClientNotifyOuterClass.WindSeedClientNotify.AreaNotify.1
                @Override // com.google.protobuf.Parser
                public AreaNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                    return new AreaNotify(input, extensionRegistry);
                }
            };

            private AreaNotify(GeneratedMessageV3.Builder<?> builder) {
                super(builder);
                this.memoizedIsInitialized = -1;
            }

            private AreaNotify() {
                this.memoizedIsInitialized = -1;
                this.areaCode_ = ByteString.EMPTY;
            }

            /* access modifiers changed from: protected */
            @Override // com.google.protobuf.GeneratedMessageV3
            public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
                return new AreaNotify();
            }

            @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
            public final UnknownFieldSet getUnknownFields() {
                return this.unknownFields;
            }

            private AreaNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                this();
                UnknownFieldSet.Builder unknownFields;
                if (extensionRegistry == null) {
                    throw new NullPointerException();
                }
                try {
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
                                    case 10:
                                        this.areaCode_ = input.readBytes();
                                        break;
                                    case 40:
                                        this.areaType_ = input.readUInt32();
                                        break;
                                    case 96:
                                        this.areaId_ = input.readUInt32();
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
                            }
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
                return WindSeedClientNotifyOuterClass.internal_static_WindSeedClientNotify_AreaNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return WindSeedClientNotifyOuterClass.f910xee7a6173.ensureFieldAccessorsInitialized(AreaNotify.class, Builder.class);
            }

            @Override // emu.grasscutter.net.proto.WindSeedClientNotifyOuterClass.WindSeedClientNotify.AreaNotifyOrBuilder
            public int getAreaType() {
                return this.areaType_;
            }

            @Override // emu.grasscutter.net.proto.WindSeedClientNotifyOuterClass.WindSeedClientNotify.AreaNotifyOrBuilder
            public int getAreaId() {
                return this.areaId_;
            }

            @Override // emu.grasscutter.net.proto.WindSeedClientNotifyOuterClass.WindSeedClientNotify.AreaNotifyOrBuilder
            public ByteString getAreaCode() {
                return this.areaCode_;
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
                if (!this.areaCode_.isEmpty()) {
                    output.writeBytes(1, this.areaCode_);
                }
                if (this.areaType_ != 0) {
                    output.writeUInt32(5, this.areaType_);
                }
                if (this.areaId_ != 0) {
                    output.writeUInt32(12, this.areaId_);
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
                if (!this.areaCode_.isEmpty()) {
                    size2 = 0 + CodedOutputStream.computeBytesSize(1, this.areaCode_);
                }
                if (this.areaType_ != 0) {
                    size2 += CodedOutputStream.computeUInt32Size(5, this.areaType_);
                }
                if (this.areaId_ != 0) {
                    size2 += CodedOutputStream.computeUInt32Size(12, this.areaId_);
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
                if (!(obj instanceof AreaNotify)) {
                    return equals(obj);
                }
                AreaNotify other = (AreaNotify) obj;
                return getAreaType() == other.getAreaType() && getAreaId() == other.getAreaId() && getAreaCode().equals(other.getAreaCode()) && this.unknownFields.equals(other.unknownFields);
            }

            @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
            public int hashCode() {
                if (this.memoizedHashCode != 0) {
                    return this.memoizedHashCode;
                }
                int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 5)) + getAreaType())) + 12)) + getAreaId())) + 1)) + getAreaCode().hashCode())) + this.unknownFields.hashCode();
                this.memoizedHashCode = hash;
                return hash;
            }

            public static AreaNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(data);
            }

            public static AreaNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(data, extensionRegistry);
            }

            public static AreaNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(data);
            }

            public static AreaNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(data, extensionRegistry);
            }

            public static AreaNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(data);
            }

            public static AreaNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(data, extensionRegistry);
            }

            public static AreaNotify parseFrom(InputStream input) throws IOException {
                return (AreaNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
            }

            public static AreaNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (AreaNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
            }

            public static AreaNotify parseDelimitedFrom(InputStream input) throws IOException {
                return (AreaNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
            }

            public static AreaNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (AreaNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
            }

            public static AreaNotify parseFrom(CodedInputStream input) throws IOException {
                return (AreaNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
            }

            public static AreaNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (AreaNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
            }

            @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
            public Builder newBuilderForType() {
                return newBuilder();
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.toBuilder();
            }

            public static Builder newBuilder(AreaNotify prototype) {
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

            /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WindSeedClientNotifyOuterClass$WindSeedClientNotify$AreaNotify$Builder.class */
            public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AreaNotifyOrBuilder {
                private int areaType_;
                private int areaId_;
                private ByteString areaCode_ = ByteString.EMPTY;

                public static final Descriptors.Descriptor getDescriptor() {
                    return WindSeedClientNotifyOuterClass.internal_static_WindSeedClientNotify_AreaNotify_descriptor;
                }

                @Override // com.google.protobuf.GeneratedMessageV3.Builder
                protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                    return WindSeedClientNotifyOuterClass.f910xee7a6173.ensureFieldAccessorsInitialized(AreaNotify.class, Builder.class);
                }

                private Builder() {
                    maybeForceBuilderInitialization();
                }

                private Builder(GeneratedMessageV3.BuilderParent parent) {
                    super(parent);
                    maybeForceBuilderInitialization();
                }

                private void maybeForceBuilderInitialization() {
                    if (AreaNotify.alwaysUseFieldBuilders) {
                    }
                }

                @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public Builder clear() {
                    clear();
                    this.areaType_ = 0;
                    this.areaId_ = 0;
                    this.areaCode_ = ByteString.EMPTY;
                    return this;
                }

                @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
                public Descriptors.Descriptor getDescriptorForType() {
                    return WindSeedClientNotifyOuterClass.internal_static_WindSeedClientNotify_AreaNotify_descriptor;
                }

                @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
                public AreaNotify getDefaultInstanceForType() {
                    return AreaNotify.getDefaultInstance();
                }

                @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public AreaNotify build() {
                    AreaNotify result = buildPartial();
                    if (result.isInitialized()) {
                        return result;
                    }
                    throw newUninitializedMessageException((Message) result);
                }

                @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public AreaNotify buildPartial() {
                    AreaNotify result = new AreaNotify(this);
                    result.areaType_ = this.areaType_;
                    result.areaId_ = this.areaId_;
                    result.areaCode_ = this.areaCode_;
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
                    if (other instanceof AreaNotify) {
                        return mergeFrom((AreaNotify) other);
                    }
                    mergeFrom(other);
                    return this;
                }

                public Builder mergeFrom(AreaNotify other) {
                    if (other == AreaNotify.getDefaultInstance()) {
                        return this;
                    }
                    if (other.getAreaType() != 0) {
                        setAreaType(other.getAreaType());
                    }
                    if (other.getAreaId() != 0) {
                        setAreaId(other.getAreaId());
                    }
                    if (other.getAreaCode() != ByteString.EMPTY) {
                        setAreaCode(other.getAreaCode());
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
                    AreaNotify parsedMessage = null;
                    try {
                        try {
                            parsedMessage = AreaNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                            if (parsedMessage != null) {
                                mergeFrom(parsedMessage);
                            }
                            return this;
                        } catch (InvalidProtocolBufferException e) {
                            parsedMessage = (AreaNotify) e.getUnfinishedMessage();
                            throw e.unwrapIOException();
                        }
                    } catch (Throwable th) {
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        throw th;
                    }
                }

                @Override // emu.grasscutter.net.proto.WindSeedClientNotifyOuterClass.WindSeedClientNotify.AreaNotifyOrBuilder
                public int getAreaType() {
                    return this.areaType_;
                }

                public Builder setAreaType(int value) {
                    this.areaType_ = value;
                    onChanged();
                    return this;
                }

                public Builder clearAreaType() {
                    this.areaType_ = 0;
                    onChanged();
                    return this;
                }

                @Override // emu.grasscutter.net.proto.WindSeedClientNotifyOuterClass.WindSeedClientNotify.AreaNotifyOrBuilder
                public int getAreaId() {
                    return this.areaId_;
                }

                public Builder setAreaId(int value) {
                    this.areaId_ = value;
                    onChanged();
                    return this;
                }

                public Builder clearAreaId() {
                    this.areaId_ = 0;
                    onChanged();
                    return this;
                }

                @Override // emu.grasscutter.net.proto.WindSeedClientNotifyOuterClass.WindSeedClientNotify.AreaNotifyOrBuilder
                public ByteString getAreaCode() {
                    return this.areaCode_;
                }

                public Builder setAreaCode(ByteString value) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    this.areaCode_ = value;
                    onChanged();
                    return this;
                }

                public Builder clearAreaCode() {
                    this.areaCode_ = AreaNotify.getDefaultInstance().getAreaCode();
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

            public static AreaNotify getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Parser<AreaNotify> parser() {
                return PARSER;
            }

            @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
            public Parser<AreaNotify> getParserForType() {
                return PARSER;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public AreaNotify getDefaultInstanceForType() {
                return DEFAULT_INSTANCE;
            }
        }

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WindSeedClientNotifyOuterClass$WindSeedClientNotify$NotifyCase.class */
        public enum NotifyCase implements Internal.EnumLite, AbstractMessageLite.InternalOneOfEnum {
            REFRESH_NOTIFY(11),
            ADD_WIND_BULLET_NOTIFY(8),
            AREA_NOTIFY(2),
            NOTIFY_NOT_SET(0);
            
            private final int value;

            NotifyCase(int value) {
                this.value = value;
            }

            @Deprecated
            public static NotifyCase valueOf(int value) {
                return forNumber(value);
            }

            public static NotifyCase forNumber(int value) {
                switch (value) {
                    case 0:
                        return NOTIFY_NOT_SET;
                    case 2:
                        return AREA_NOTIFY;
                    case 8:
                        return ADD_WIND_BULLET_NOTIFY;
                    case 11:
                        return REFRESH_NOTIFY;
                    default:
                        return null;
                }
            }

            @Override // com.google.protobuf.Internal.EnumLite
            public int getNumber() {
                return this.value;
            }
        }

        @Override // emu.grasscutter.net.proto.WindSeedClientNotifyOuterClass.WindSeedClientNotifyOrBuilder
        public NotifyCase getNotifyCase() {
            return NotifyCase.forNumber(this.notifyCase_);
        }

        @Override // emu.grasscutter.net.proto.WindSeedClientNotifyOuterClass.WindSeedClientNotifyOrBuilder
        public boolean hasRefreshNotify() {
            return this.notifyCase_ == 11;
        }

        @Override // emu.grasscutter.net.proto.WindSeedClientNotifyOuterClass.WindSeedClientNotifyOrBuilder
        public RefreshNotify getRefreshNotify() {
            if (this.notifyCase_ == 11) {
                return (RefreshNotify) this.notify_;
            }
            return RefreshNotify.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.WindSeedClientNotifyOuterClass.WindSeedClientNotifyOrBuilder
        public RefreshNotifyOrBuilder getRefreshNotifyOrBuilder() {
            if (this.notifyCase_ == 11) {
                return (RefreshNotify) this.notify_;
            }
            return RefreshNotify.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.WindSeedClientNotifyOuterClass.WindSeedClientNotifyOrBuilder
        public boolean hasAddWindBulletNotify() {
            return this.notifyCase_ == 8;
        }

        @Override // emu.grasscutter.net.proto.WindSeedClientNotifyOuterClass.WindSeedClientNotifyOrBuilder
        public AddWindBulletNotify getAddWindBulletNotify() {
            if (this.notifyCase_ == 8) {
                return (AddWindBulletNotify) this.notify_;
            }
            return AddWindBulletNotify.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.WindSeedClientNotifyOuterClass.WindSeedClientNotifyOrBuilder
        public AddWindBulletNotifyOrBuilder getAddWindBulletNotifyOrBuilder() {
            if (this.notifyCase_ == 8) {
                return (AddWindBulletNotify) this.notify_;
            }
            return AddWindBulletNotify.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.WindSeedClientNotifyOuterClass.WindSeedClientNotifyOrBuilder
        public boolean hasAreaNotify() {
            return this.notifyCase_ == 2;
        }

        @Override // emu.grasscutter.net.proto.WindSeedClientNotifyOuterClass.WindSeedClientNotifyOrBuilder
        public AreaNotify getAreaNotify() {
            if (this.notifyCase_ == 2) {
                return (AreaNotify) this.notify_;
            }
            return AreaNotify.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.WindSeedClientNotifyOuterClass.WindSeedClientNotifyOrBuilder
        public AreaNotifyOrBuilder getAreaNotifyOrBuilder() {
            if (this.notifyCase_ == 2) {
                return (AreaNotify) this.notify_;
            }
            return AreaNotify.getDefaultInstance();
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
            if (this.notifyCase_ == 2) {
                output.writeMessage(2, (AreaNotify) this.notify_);
            }
            if (this.notifyCase_ == 8) {
                output.writeMessage(8, (AddWindBulletNotify) this.notify_);
            }
            if (this.notifyCase_ == 11) {
                output.writeMessage(11, (RefreshNotify) this.notify_);
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
            if (this.notifyCase_ == 2) {
                size2 = 0 + CodedOutputStream.computeMessageSize(2, (AreaNotify) this.notify_);
            }
            if (this.notifyCase_ == 8) {
                size2 += CodedOutputStream.computeMessageSize(8, (AddWindBulletNotify) this.notify_);
            }
            if (this.notifyCase_ == 11) {
                size2 += CodedOutputStream.computeMessageSize(11, (RefreshNotify) this.notify_);
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
            if (!(obj instanceof WindSeedClientNotify)) {
                return equals(obj);
            }
            WindSeedClientNotify other = (WindSeedClientNotify) obj;
            if (!getNotifyCase().equals(other.getNotifyCase())) {
                return false;
            }
            switch (this.notifyCase_) {
                case 2:
                    if (!getAreaNotify().equals(other.getAreaNotify())) {
                        return false;
                    }
                    break;
                case 8:
                    if (!getAddWindBulletNotify().equals(other.getAddWindBulletNotify())) {
                        return false;
                    }
                    break;
                case 11:
                    if (!getRefreshNotify().equals(other.getRefreshNotify())) {
                        return false;
                    }
                    break;
            }
            return this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            switch (this.notifyCase_) {
                case 2:
                    hash = (53 * ((37 * hash) + 2)) + getAreaNotify().hashCode();
                    break;
                case 8:
                    hash = (53 * ((37 * hash) + 8)) + getAddWindBulletNotify().hashCode();
                    break;
                case 11:
                    hash = (53 * ((37 * hash) + 11)) + getRefreshNotify().hashCode();
                    break;
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static WindSeedClientNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static WindSeedClientNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static WindSeedClientNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static WindSeedClientNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static WindSeedClientNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static WindSeedClientNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static WindSeedClientNotify parseFrom(InputStream input) throws IOException {
            return (WindSeedClientNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static WindSeedClientNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WindSeedClientNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static WindSeedClientNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (WindSeedClientNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static WindSeedClientNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WindSeedClientNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static WindSeedClientNotify parseFrom(CodedInputStream input) throws IOException {
            return (WindSeedClientNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static WindSeedClientNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WindSeedClientNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(WindSeedClientNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WindSeedClientNotifyOuterClass$WindSeedClientNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements WindSeedClientNotifyOrBuilder {
            private int notifyCase_ = 0;
            private Object notify_;
            private SingleFieldBuilderV3<RefreshNotify, RefreshNotify.Builder, RefreshNotifyOrBuilder> refreshNotifyBuilder_;
            private SingleFieldBuilderV3<AddWindBulletNotify, AddWindBulletNotify.Builder, AddWindBulletNotifyOrBuilder> addWindBulletNotifyBuilder_;
            private SingleFieldBuilderV3<AreaNotify, AreaNotify.Builder, AreaNotifyOrBuilder> areaNotifyBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return WindSeedClientNotifyOuterClass.internal_static_WindSeedClientNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return WindSeedClientNotifyOuterClass.internal_static_WindSeedClientNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(WindSeedClientNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (WindSeedClientNotify.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.notifyCase_ = 0;
                this.notify_ = null;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return WindSeedClientNotifyOuterClass.internal_static_WindSeedClientNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public WindSeedClientNotify getDefaultInstanceForType() {
                return WindSeedClientNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public WindSeedClientNotify build() {
                WindSeedClientNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public WindSeedClientNotify buildPartial() {
                WindSeedClientNotify result = new WindSeedClientNotify(this);
                if (this.notifyCase_ == 11) {
                    if (this.refreshNotifyBuilder_ == null) {
                        result.notify_ = this.notify_;
                    } else {
                        result.notify_ = this.refreshNotifyBuilder_.build();
                    }
                }
                if (this.notifyCase_ == 8) {
                    if (this.addWindBulletNotifyBuilder_ == null) {
                        result.notify_ = this.notify_;
                    } else {
                        result.notify_ = this.addWindBulletNotifyBuilder_.build();
                    }
                }
                if (this.notifyCase_ == 2) {
                    if (this.areaNotifyBuilder_ == null) {
                        result.notify_ = this.notify_;
                    } else {
                        result.notify_ = this.areaNotifyBuilder_.build();
                    }
                }
                result.notifyCase_ = this.notifyCase_;
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
                if (other instanceof WindSeedClientNotify) {
                    return mergeFrom((WindSeedClientNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(WindSeedClientNotify other) {
                if (other == WindSeedClientNotify.getDefaultInstance()) {
                    return this;
                }
                switch (other.getNotifyCase()) {
                    case REFRESH_NOTIFY:
                        mergeRefreshNotify(other.getRefreshNotify());
                        break;
                    case ADD_WIND_BULLET_NOTIFY:
                        mergeAddWindBulletNotify(other.getAddWindBulletNotify());
                        break;
                    case AREA_NOTIFY:
                        mergeAreaNotify(other.getAreaNotify());
                        break;
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
                WindSeedClientNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = WindSeedClientNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (WindSeedClientNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.WindSeedClientNotifyOuterClass.WindSeedClientNotifyOrBuilder
            public NotifyCase getNotifyCase() {
                return NotifyCase.forNumber(this.notifyCase_);
            }

            public Builder clearNotify() {
                this.notifyCase_ = 0;
                this.notify_ = null;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.WindSeedClientNotifyOuterClass.WindSeedClientNotifyOrBuilder
            public boolean hasRefreshNotify() {
                return this.notifyCase_ == 11;
            }

            @Override // emu.grasscutter.net.proto.WindSeedClientNotifyOuterClass.WindSeedClientNotifyOrBuilder
            public RefreshNotify getRefreshNotify() {
                if (this.refreshNotifyBuilder_ == null) {
                    if (this.notifyCase_ == 11) {
                        return (RefreshNotify) this.notify_;
                    }
                    return RefreshNotify.getDefaultInstance();
                } else if (this.notifyCase_ == 11) {
                    return this.refreshNotifyBuilder_.getMessage();
                } else {
                    return RefreshNotify.getDefaultInstance();
                }
            }

            public Builder setRefreshNotify(RefreshNotify value) {
                if (this.refreshNotifyBuilder_ != null) {
                    this.refreshNotifyBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.notify_ = value;
                    onChanged();
                }
                this.notifyCase_ = 11;
                return this;
            }

            public Builder setRefreshNotify(RefreshNotify.Builder builderForValue) {
                if (this.refreshNotifyBuilder_ == null) {
                    this.notify_ = builderForValue.build();
                    onChanged();
                } else {
                    this.refreshNotifyBuilder_.setMessage(builderForValue.build());
                }
                this.notifyCase_ = 11;
                return this;
            }

            public Builder mergeRefreshNotify(RefreshNotify value) {
                if (this.refreshNotifyBuilder_ == null) {
                    if (this.notifyCase_ != 11 || this.notify_ == RefreshNotify.getDefaultInstance()) {
                        this.notify_ = value;
                    } else {
                        this.notify_ = RefreshNotify.newBuilder((RefreshNotify) this.notify_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.notifyCase_ == 11) {
                        this.refreshNotifyBuilder_.mergeFrom(value);
                    }
                    this.refreshNotifyBuilder_.setMessage(value);
                }
                this.notifyCase_ = 11;
                return this;
            }

            public Builder clearRefreshNotify() {
                if (this.refreshNotifyBuilder_ != null) {
                    if (this.notifyCase_ == 11) {
                        this.notifyCase_ = 0;
                        this.notify_ = null;
                    }
                    this.refreshNotifyBuilder_.clear();
                } else if (this.notifyCase_ == 11) {
                    this.notifyCase_ = 0;
                    this.notify_ = null;
                    onChanged();
                }
                return this;
            }

            public RefreshNotify.Builder getRefreshNotifyBuilder() {
                return getRefreshNotifyFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.WindSeedClientNotifyOuterClass.WindSeedClientNotifyOrBuilder
            public RefreshNotifyOrBuilder getRefreshNotifyOrBuilder() {
                if (this.notifyCase_ == 11 && this.refreshNotifyBuilder_ != null) {
                    return this.refreshNotifyBuilder_.getMessageOrBuilder();
                }
                if (this.notifyCase_ == 11) {
                    return (RefreshNotify) this.notify_;
                }
                return RefreshNotify.getDefaultInstance();
            }

            private SingleFieldBuilderV3<RefreshNotify, RefreshNotify.Builder, RefreshNotifyOrBuilder> getRefreshNotifyFieldBuilder() {
                if (this.refreshNotifyBuilder_ == null) {
                    if (this.notifyCase_ != 11) {
                        this.notify_ = RefreshNotify.getDefaultInstance();
                    }
                    this.refreshNotifyBuilder_ = new SingleFieldBuilderV3<>((RefreshNotify) this.notify_, getParentForChildren(), isClean());
                    this.notify_ = null;
                }
                this.notifyCase_ = 11;
                onChanged();
                return this.refreshNotifyBuilder_;
            }

            @Override // emu.grasscutter.net.proto.WindSeedClientNotifyOuterClass.WindSeedClientNotifyOrBuilder
            public boolean hasAddWindBulletNotify() {
                return this.notifyCase_ == 8;
            }

            @Override // emu.grasscutter.net.proto.WindSeedClientNotifyOuterClass.WindSeedClientNotifyOrBuilder
            public AddWindBulletNotify getAddWindBulletNotify() {
                if (this.addWindBulletNotifyBuilder_ == null) {
                    if (this.notifyCase_ == 8) {
                        return (AddWindBulletNotify) this.notify_;
                    }
                    return AddWindBulletNotify.getDefaultInstance();
                } else if (this.notifyCase_ == 8) {
                    return this.addWindBulletNotifyBuilder_.getMessage();
                } else {
                    return AddWindBulletNotify.getDefaultInstance();
                }
            }

            public Builder setAddWindBulletNotify(AddWindBulletNotify value) {
                if (this.addWindBulletNotifyBuilder_ != null) {
                    this.addWindBulletNotifyBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.notify_ = value;
                    onChanged();
                }
                this.notifyCase_ = 8;
                return this;
            }

            public Builder setAddWindBulletNotify(AddWindBulletNotify.Builder builderForValue) {
                if (this.addWindBulletNotifyBuilder_ == null) {
                    this.notify_ = builderForValue.build();
                    onChanged();
                } else {
                    this.addWindBulletNotifyBuilder_.setMessage(builderForValue.build());
                }
                this.notifyCase_ = 8;
                return this;
            }

            public Builder mergeAddWindBulletNotify(AddWindBulletNotify value) {
                if (this.addWindBulletNotifyBuilder_ == null) {
                    if (this.notifyCase_ != 8 || this.notify_ == AddWindBulletNotify.getDefaultInstance()) {
                        this.notify_ = value;
                    } else {
                        this.notify_ = AddWindBulletNotify.newBuilder((AddWindBulletNotify) this.notify_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.notifyCase_ == 8) {
                        this.addWindBulletNotifyBuilder_.mergeFrom(value);
                    }
                    this.addWindBulletNotifyBuilder_.setMessage(value);
                }
                this.notifyCase_ = 8;
                return this;
            }

            public Builder clearAddWindBulletNotify() {
                if (this.addWindBulletNotifyBuilder_ != null) {
                    if (this.notifyCase_ == 8) {
                        this.notifyCase_ = 0;
                        this.notify_ = null;
                    }
                    this.addWindBulletNotifyBuilder_.clear();
                } else if (this.notifyCase_ == 8) {
                    this.notifyCase_ = 0;
                    this.notify_ = null;
                    onChanged();
                }
                return this;
            }

            public AddWindBulletNotify.Builder getAddWindBulletNotifyBuilder() {
                return getAddWindBulletNotifyFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.WindSeedClientNotifyOuterClass.WindSeedClientNotifyOrBuilder
            public AddWindBulletNotifyOrBuilder getAddWindBulletNotifyOrBuilder() {
                if (this.notifyCase_ == 8 && this.addWindBulletNotifyBuilder_ != null) {
                    return this.addWindBulletNotifyBuilder_.getMessageOrBuilder();
                }
                if (this.notifyCase_ == 8) {
                    return (AddWindBulletNotify) this.notify_;
                }
                return AddWindBulletNotify.getDefaultInstance();
            }

            private SingleFieldBuilderV3<AddWindBulletNotify, AddWindBulletNotify.Builder, AddWindBulletNotifyOrBuilder> getAddWindBulletNotifyFieldBuilder() {
                if (this.addWindBulletNotifyBuilder_ == null) {
                    if (this.notifyCase_ != 8) {
                        this.notify_ = AddWindBulletNotify.getDefaultInstance();
                    }
                    this.addWindBulletNotifyBuilder_ = new SingleFieldBuilderV3<>((AddWindBulletNotify) this.notify_, getParentForChildren(), isClean());
                    this.notify_ = null;
                }
                this.notifyCase_ = 8;
                onChanged();
                return this.addWindBulletNotifyBuilder_;
            }

            @Override // emu.grasscutter.net.proto.WindSeedClientNotifyOuterClass.WindSeedClientNotifyOrBuilder
            public boolean hasAreaNotify() {
                return this.notifyCase_ == 2;
            }

            @Override // emu.grasscutter.net.proto.WindSeedClientNotifyOuterClass.WindSeedClientNotifyOrBuilder
            public AreaNotify getAreaNotify() {
                if (this.areaNotifyBuilder_ == null) {
                    if (this.notifyCase_ == 2) {
                        return (AreaNotify) this.notify_;
                    }
                    return AreaNotify.getDefaultInstance();
                } else if (this.notifyCase_ == 2) {
                    return this.areaNotifyBuilder_.getMessage();
                } else {
                    return AreaNotify.getDefaultInstance();
                }
            }

            public Builder setAreaNotify(AreaNotify value) {
                if (this.areaNotifyBuilder_ != null) {
                    this.areaNotifyBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.notify_ = value;
                    onChanged();
                }
                this.notifyCase_ = 2;
                return this;
            }

            public Builder setAreaNotify(AreaNotify.Builder builderForValue) {
                if (this.areaNotifyBuilder_ == null) {
                    this.notify_ = builderForValue.build();
                    onChanged();
                } else {
                    this.areaNotifyBuilder_.setMessage(builderForValue.build());
                }
                this.notifyCase_ = 2;
                return this;
            }

            public Builder mergeAreaNotify(AreaNotify value) {
                if (this.areaNotifyBuilder_ == null) {
                    if (this.notifyCase_ != 2 || this.notify_ == AreaNotify.getDefaultInstance()) {
                        this.notify_ = value;
                    } else {
                        this.notify_ = AreaNotify.newBuilder((AreaNotify) this.notify_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.notifyCase_ == 2) {
                        this.areaNotifyBuilder_.mergeFrom(value);
                    }
                    this.areaNotifyBuilder_.setMessage(value);
                }
                this.notifyCase_ = 2;
                return this;
            }

            public Builder clearAreaNotify() {
                if (this.areaNotifyBuilder_ != null) {
                    if (this.notifyCase_ == 2) {
                        this.notifyCase_ = 0;
                        this.notify_ = null;
                    }
                    this.areaNotifyBuilder_.clear();
                } else if (this.notifyCase_ == 2) {
                    this.notifyCase_ = 0;
                    this.notify_ = null;
                    onChanged();
                }
                return this;
            }

            public AreaNotify.Builder getAreaNotifyBuilder() {
                return getAreaNotifyFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.WindSeedClientNotifyOuterClass.WindSeedClientNotifyOrBuilder
            public AreaNotifyOrBuilder getAreaNotifyOrBuilder() {
                if (this.notifyCase_ == 2 && this.areaNotifyBuilder_ != null) {
                    return this.areaNotifyBuilder_.getMessageOrBuilder();
                }
                if (this.notifyCase_ == 2) {
                    return (AreaNotify) this.notify_;
                }
                return AreaNotify.getDefaultInstance();
            }

            private SingleFieldBuilderV3<AreaNotify, AreaNotify.Builder, AreaNotifyOrBuilder> getAreaNotifyFieldBuilder() {
                if (this.areaNotifyBuilder_ == null) {
                    if (this.notifyCase_ != 2) {
                        this.notify_ = AreaNotify.getDefaultInstance();
                    }
                    this.areaNotifyBuilder_ = new SingleFieldBuilderV3<>((AreaNotify) this.notify_, getParentForChildren(), isClean());
                    this.notify_ = null;
                }
                this.notifyCase_ = 2;
                onChanged();
                return this.areaNotifyBuilder_;
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

        public static WindSeedClientNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<WindSeedClientNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<WindSeedClientNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public WindSeedClientNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        VectorOuterClass.getDescriptor();
    }
}
