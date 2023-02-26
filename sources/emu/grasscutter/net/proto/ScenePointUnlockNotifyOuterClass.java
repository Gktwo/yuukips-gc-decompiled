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
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ScenePointUnlockNotifyOuterClass.class */
public final class ScenePointUnlockNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001cScenePointUnlockNotify.proto\"\u0001\n\u0016ScenePointUnlockNotify\u0012\u0017\n\u000flockedPointList\u0018\u0005 \u0003(\r\u0012\u000f\n\u0007sceneId\u0018\f \u0001(\r\u0012\u0011\n\tpointList\u0018\t \u0003(\r\u0012\u0015\n\rhidePointList\u0018\u000f \u0003(\r\u0012\u0017\n\u000funhidePointList\u0018\u0007 \u0003(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_ScenePointUnlockNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_ScenePointUnlockNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_ScenePointUnlockNotify_descriptor, new String[]{"LockedPointList", "SceneId", "PointList", "HidePointList", "UnhidePointList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ScenePointUnlockNotifyOuterClass$ScenePointUnlockNotifyOrBuilder.class */
    public interface ScenePointUnlockNotifyOrBuilder extends MessageOrBuilder {
        List<Integer> getLockedPointListList();

        int getLockedPointListCount();

        int getLockedPointList(int i);

        int getSceneId();

        List<Integer> getPointListList();

        int getPointListCount();

        int getPointList(int i);

        List<Integer> getHidePointListList();

        int getHidePointListCount();

        int getHidePointList(int i);

        List<Integer> getUnhidePointListList();

        int getUnhidePointListCount();

        int getUnhidePointList(int i);
    }

    private ScenePointUnlockNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ScenePointUnlockNotifyOuterClass$ScenePointUnlockNotify.class */
    public static final class ScenePointUnlockNotify extends GeneratedMessageV3 implements ScenePointUnlockNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int LOCKEDPOINTLIST_FIELD_NUMBER = 5;
        private Internal.IntList lockedPointList_;
        private int lockedPointListMemoizedSerializedSize;
        public static final int SCENEID_FIELD_NUMBER = 12;
        private int sceneId_;
        public static final int POINTLIST_FIELD_NUMBER = 9;
        private Internal.IntList pointList_;
        private int pointListMemoizedSerializedSize;
        public static final int HIDEPOINTLIST_FIELD_NUMBER = 15;
        private Internal.IntList hidePointList_;
        private int hidePointListMemoizedSerializedSize;
        public static final int UNHIDEPOINTLIST_FIELD_NUMBER = 7;
        private Internal.IntList unhidePointList_;
        private int unhidePointListMemoizedSerializedSize;
        private byte memoizedIsInitialized;
        private static final ScenePointUnlockNotify DEFAULT_INSTANCE = new ScenePointUnlockNotify();
        private static final Parser<ScenePointUnlockNotify> PARSER = new AbstractParser<ScenePointUnlockNotify>() { // from class: emu.grasscutter.net.proto.ScenePointUnlockNotifyOuterClass.ScenePointUnlockNotify.1
            @Override // com.google.protobuf.Parser
            public ScenePointUnlockNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ScenePointUnlockNotify(input, extensionRegistry);
            }
        };

        private ScenePointUnlockNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.lockedPointListMemoizedSerializedSize = -1;
            this.pointListMemoizedSerializedSize = -1;
            this.hidePointListMemoizedSerializedSize = -1;
            this.unhidePointListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private ScenePointUnlockNotify() {
            this.lockedPointListMemoizedSerializedSize = -1;
            this.pointListMemoizedSerializedSize = -1;
            this.hidePointListMemoizedSerializedSize = -1;
            this.unhidePointListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.lockedPointList_ = emptyIntList();
            this.pointList_ = emptyIntList();
            this.hidePointList_ = emptyIntList();
            this.unhidePointList_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new ScenePointUnlockNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:122:0x0241 */
        private ScenePointUnlockNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 40:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.lockedPointList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                this.lockedPointList_.addInt(input.readUInt32());
                                break;
                            case 42:
                                int limit = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.lockedPointList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.lockedPointList_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit);
                                break;
                            case 56:
                                if ((mutable_bitField0_ & 8) == 0) {
                                    this.unhidePointList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 8) == 1 ? 1 : 0;
                                }
                                this.unhidePointList_.addInt(input.readUInt32());
                                break;
                            case 58:
                                int limit2 = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 8) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.unhidePointList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 8) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.unhidePointList_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit2);
                                break;
                            case 72:
                                if ((mutable_bitField0_ & 2) == 0) {
                                    this.pointList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                this.pointList_.addInt(input.readUInt32());
                                break;
                            case 74:
                                int limit3 = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 2) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.pointList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.pointList_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit3);
                                break;
                            case 96:
                                this.sceneId_ = input.readUInt32();
                                break;
                            case 120:
                                if ((mutable_bitField0_ & 4) == 0) {
                                    this.hidePointList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 4) == 1 ? 1 : 0;
                                }
                                this.hidePointList_.addInt(input.readUInt32());
                                break;
                            case 122:
                                int limit4 = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 4) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.hidePointList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 4) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.hidePointList_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit4);
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
                if ((mutable_bitField0_ & 1) != 0) {
                    this.lockedPointList_.makeImmutable();
                }
                if ((mutable_bitField0_ & 8) != 0) {
                    this.unhidePointList_.makeImmutable();
                }
                if ((mutable_bitField0_ & 2) != 0) {
                    this.pointList_.makeImmutable();
                }
                if ((mutable_bitField0_ & 4) != 0) {
                    this.hidePointList_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return ScenePointUnlockNotifyOuterClass.internal_static_ScenePointUnlockNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ScenePointUnlockNotifyOuterClass.internal_static_ScenePointUnlockNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(ScenePointUnlockNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.ScenePointUnlockNotifyOuterClass.ScenePointUnlockNotifyOrBuilder
        public List<Integer> getLockedPointListList() {
            return this.lockedPointList_;
        }

        @Override // emu.grasscutter.net.proto.ScenePointUnlockNotifyOuterClass.ScenePointUnlockNotifyOrBuilder
        public int getLockedPointListCount() {
            return this.lockedPointList_.size();
        }

        @Override // emu.grasscutter.net.proto.ScenePointUnlockNotifyOuterClass.ScenePointUnlockNotifyOrBuilder
        public int getLockedPointList(int index) {
            return this.lockedPointList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.ScenePointUnlockNotifyOuterClass.ScenePointUnlockNotifyOrBuilder
        public int getSceneId() {
            return this.sceneId_;
        }

        @Override // emu.grasscutter.net.proto.ScenePointUnlockNotifyOuterClass.ScenePointUnlockNotifyOrBuilder
        public List<Integer> getPointListList() {
            return this.pointList_;
        }

        @Override // emu.grasscutter.net.proto.ScenePointUnlockNotifyOuterClass.ScenePointUnlockNotifyOrBuilder
        public int getPointListCount() {
            return this.pointList_.size();
        }

        @Override // emu.grasscutter.net.proto.ScenePointUnlockNotifyOuterClass.ScenePointUnlockNotifyOrBuilder
        public int getPointList(int index) {
            return this.pointList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.ScenePointUnlockNotifyOuterClass.ScenePointUnlockNotifyOrBuilder
        public List<Integer> getHidePointListList() {
            return this.hidePointList_;
        }

        @Override // emu.grasscutter.net.proto.ScenePointUnlockNotifyOuterClass.ScenePointUnlockNotifyOrBuilder
        public int getHidePointListCount() {
            return this.hidePointList_.size();
        }

        @Override // emu.grasscutter.net.proto.ScenePointUnlockNotifyOuterClass.ScenePointUnlockNotifyOrBuilder
        public int getHidePointList(int index) {
            return this.hidePointList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.ScenePointUnlockNotifyOuterClass.ScenePointUnlockNotifyOrBuilder
        public List<Integer> getUnhidePointListList() {
            return this.unhidePointList_;
        }

        @Override // emu.grasscutter.net.proto.ScenePointUnlockNotifyOuterClass.ScenePointUnlockNotifyOrBuilder
        public int getUnhidePointListCount() {
            return this.unhidePointList_.size();
        }

        @Override // emu.grasscutter.net.proto.ScenePointUnlockNotifyOuterClass.ScenePointUnlockNotifyOrBuilder
        public int getUnhidePointList(int index) {
            return this.unhidePointList_.getInt(index);
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
            if (getLockedPointListList().size() > 0) {
                output.writeUInt32NoTag(42);
                output.writeUInt32NoTag(this.lockedPointListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.lockedPointList_.size(); i++) {
                output.writeUInt32NoTag(this.lockedPointList_.getInt(i));
            }
            if (getUnhidePointListList().size() > 0) {
                output.writeUInt32NoTag(58);
                output.writeUInt32NoTag(this.unhidePointListMemoizedSerializedSize);
            }
            for (int i2 = 0; i2 < this.unhidePointList_.size(); i2++) {
                output.writeUInt32NoTag(this.unhidePointList_.getInt(i2));
            }
            if (getPointListList().size() > 0) {
                output.writeUInt32NoTag(74);
                output.writeUInt32NoTag(this.pointListMemoizedSerializedSize);
            }
            for (int i3 = 0; i3 < this.pointList_.size(); i3++) {
                output.writeUInt32NoTag(this.pointList_.getInt(i3));
            }
            if (this.sceneId_ != 0) {
                output.writeUInt32(12, this.sceneId_);
            }
            if (getHidePointListList().size() > 0) {
                output.writeUInt32NoTag(122);
                output.writeUInt32NoTag(this.hidePointListMemoizedSerializedSize);
            }
            for (int i4 = 0; i4 < this.hidePointList_.size(); i4++) {
                output.writeUInt32NoTag(this.hidePointList_.getInt(i4));
            }
            this.unknownFields.writeTo(output);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int size = this.memoizedSize;
            if (size != -1) {
                return size;
            }
            int dataSize = 0;
            for (int i = 0; i < this.lockedPointList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.lockedPointList_.getInt(i));
            }
            int size2 = 0 + dataSize;
            if (!getLockedPointListList().isEmpty()) {
                size2 = size2 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.lockedPointListMemoizedSerializedSize = dataSize;
            int dataSize2 = 0;
            for (int i2 = 0; i2 < this.unhidePointList_.size(); i2++) {
                dataSize2 += CodedOutputStream.computeUInt32SizeNoTag(this.unhidePointList_.getInt(i2));
            }
            int size3 = size2 + dataSize2;
            if (!getUnhidePointListList().isEmpty()) {
                size3 = size3 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize2);
            }
            this.unhidePointListMemoizedSerializedSize = dataSize2;
            int dataSize3 = 0;
            for (int i3 = 0; i3 < this.pointList_.size(); i3++) {
                dataSize3 += CodedOutputStream.computeUInt32SizeNoTag(this.pointList_.getInt(i3));
            }
            int size4 = size3 + dataSize3;
            if (!getPointListList().isEmpty()) {
                size4 = size4 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize3);
            }
            this.pointListMemoizedSerializedSize = dataSize3;
            if (this.sceneId_ != 0) {
                size4 += CodedOutputStream.computeUInt32Size(12, this.sceneId_);
            }
            int dataSize4 = 0;
            for (int i4 = 0; i4 < this.hidePointList_.size(); i4++) {
                dataSize4 += CodedOutputStream.computeUInt32SizeNoTag(this.hidePointList_.getInt(i4));
            }
            int size5 = size4 + dataSize4;
            if (!getHidePointListList().isEmpty()) {
                size5 = size5 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize4);
            }
            this.hidePointListMemoizedSerializedSize = dataSize4;
            int size6 = size5 + this.unknownFields.getSerializedSize();
            this.memoizedSize = size6;
            return size6;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ScenePointUnlockNotify)) {
                return equals(obj);
            }
            ScenePointUnlockNotify other = (ScenePointUnlockNotify) obj;
            return getLockedPointListList().equals(other.getLockedPointListList()) && getSceneId() == other.getSceneId() && getPointListList().equals(other.getPointListList()) && getHidePointListList().equals(other.getHidePointListList()) && getUnhidePointListList().equals(other.getUnhidePointListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getLockedPointListCount() > 0) {
                hash = (53 * ((37 * hash) + 5)) + getLockedPointListList().hashCode();
            }
            int hash2 = (53 * ((37 * hash) + 12)) + getSceneId();
            if (getPointListCount() > 0) {
                hash2 = (53 * ((37 * hash2) + 9)) + getPointListList().hashCode();
            }
            if (getHidePointListCount() > 0) {
                hash2 = (53 * ((37 * hash2) + 15)) + getHidePointListList().hashCode();
            }
            if (getUnhidePointListCount() > 0) {
                hash2 = (53 * ((37 * hash2) + 7)) + getUnhidePointListList().hashCode();
            }
            int hash3 = (29 * hash2) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash3;
            return hash3;
        }

        public static ScenePointUnlockNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ScenePointUnlockNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ScenePointUnlockNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ScenePointUnlockNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ScenePointUnlockNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ScenePointUnlockNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ScenePointUnlockNotify parseFrom(InputStream input) throws IOException {
            return (ScenePointUnlockNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ScenePointUnlockNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ScenePointUnlockNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static ScenePointUnlockNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (ScenePointUnlockNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static ScenePointUnlockNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ScenePointUnlockNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static ScenePointUnlockNotify parseFrom(CodedInputStream input) throws IOException {
            return (ScenePointUnlockNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ScenePointUnlockNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ScenePointUnlockNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ScenePointUnlockNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ScenePointUnlockNotifyOuterClass$ScenePointUnlockNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ScenePointUnlockNotifyOrBuilder {
            private int bitField0_;
            private int sceneId_;
            private Internal.IntList lockedPointList_ = ScenePointUnlockNotify.emptyIntList();
            private Internal.IntList pointList_ = ScenePointUnlockNotify.emptyIntList();
            private Internal.IntList hidePointList_ = ScenePointUnlockNotify.emptyIntList();
            private Internal.IntList unhidePointList_ = ScenePointUnlockNotify.emptyIntList();

            public static final Descriptors.Descriptor getDescriptor() {
                return ScenePointUnlockNotifyOuterClass.internal_static_ScenePointUnlockNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return ScenePointUnlockNotifyOuterClass.internal_static_ScenePointUnlockNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(ScenePointUnlockNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ScenePointUnlockNotify.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.lockedPointList_ = ScenePointUnlockNotify.emptyIntList();
                this.bitField0_ &= -2;
                this.sceneId_ = 0;
                this.pointList_ = ScenePointUnlockNotify.emptyIntList();
                this.bitField0_ &= -3;
                this.hidePointList_ = ScenePointUnlockNotify.emptyIntList();
                this.bitField0_ &= -5;
                this.unhidePointList_ = ScenePointUnlockNotify.emptyIntList();
                this.bitField0_ &= -9;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return ScenePointUnlockNotifyOuterClass.internal_static_ScenePointUnlockNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public ScenePointUnlockNotify getDefaultInstanceForType() {
                return ScenePointUnlockNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ScenePointUnlockNotify build() {
                ScenePointUnlockNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ScenePointUnlockNotify buildPartial() {
                ScenePointUnlockNotify result = new ScenePointUnlockNotify(this);
                int i = this.bitField0_;
                if ((this.bitField0_ & 1) != 0) {
                    this.lockedPointList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.lockedPointList_ = this.lockedPointList_;
                result.sceneId_ = this.sceneId_;
                if ((this.bitField0_ & 2) != 0) {
                    this.pointList_.makeImmutable();
                    this.bitField0_ &= -3;
                }
                result.pointList_ = this.pointList_;
                if ((this.bitField0_ & 4) != 0) {
                    this.hidePointList_.makeImmutable();
                    this.bitField0_ &= -5;
                }
                result.hidePointList_ = this.hidePointList_;
                if ((this.bitField0_ & 8) != 0) {
                    this.unhidePointList_.makeImmutable();
                    this.bitField0_ &= -9;
                }
                result.unhidePointList_ = this.unhidePointList_;
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
                if (other instanceof ScenePointUnlockNotify) {
                    return mergeFrom((ScenePointUnlockNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ScenePointUnlockNotify other) {
                if (other == ScenePointUnlockNotify.getDefaultInstance()) {
                    return this;
                }
                if (!other.lockedPointList_.isEmpty()) {
                    if (this.lockedPointList_.isEmpty()) {
                        this.lockedPointList_ = other.lockedPointList_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureLockedPointListIsMutable();
                        this.lockedPointList_.addAll(other.lockedPointList_);
                    }
                    onChanged();
                }
                if (other.getSceneId() != 0) {
                    setSceneId(other.getSceneId());
                }
                if (!other.pointList_.isEmpty()) {
                    if (this.pointList_.isEmpty()) {
                        this.pointList_ = other.pointList_;
                        this.bitField0_ &= -3;
                    } else {
                        ensurePointListIsMutable();
                        this.pointList_.addAll(other.pointList_);
                    }
                    onChanged();
                }
                if (!other.hidePointList_.isEmpty()) {
                    if (this.hidePointList_.isEmpty()) {
                        this.hidePointList_ = other.hidePointList_;
                        this.bitField0_ &= -5;
                    } else {
                        ensureHidePointListIsMutable();
                        this.hidePointList_.addAll(other.hidePointList_);
                    }
                    onChanged();
                }
                if (!other.unhidePointList_.isEmpty()) {
                    if (this.unhidePointList_.isEmpty()) {
                        this.unhidePointList_ = other.unhidePointList_;
                        this.bitField0_ &= -9;
                    } else {
                        ensureUnhidePointListIsMutable();
                        this.unhidePointList_.addAll(other.unhidePointList_);
                    }
                    onChanged();
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
                ScenePointUnlockNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = ScenePointUnlockNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (ScenePointUnlockNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureLockedPointListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.lockedPointList_ = ScenePointUnlockNotify.mutableCopy(this.lockedPointList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.ScenePointUnlockNotifyOuterClass.ScenePointUnlockNotifyOrBuilder
            public List<Integer> getLockedPointListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.lockedPointList_) : this.lockedPointList_;
            }

            @Override // emu.grasscutter.net.proto.ScenePointUnlockNotifyOuterClass.ScenePointUnlockNotifyOrBuilder
            public int getLockedPointListCount() {
                return this.lockedPointList_.size();
            }

            @Override // emu.grasscutter.net.proto.ScenePointUnlockNotifyOuterClass.ScenePointUnlockNotifyOrBuilder
            public int getLockedPointList(int index) {
                return this.lockedPointList_.getInt(index);
            }

            public Builder setLockedPointList(int index, int value) {
                ensureLockedPointListIsMutable();
                this.lockedPointList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addLockedPointList(int value) {
                ensureLockedPointListIsMutable();
                this.lockedPointList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllLockedPointList(Iterable<? extends Integer> values) {
                ensureLockedPointListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.lockedPointList_);
                onChanged();
                return this;
            }

            public Builder clearLockedPointList() {
                this.lockedPointList_ = ScenePointUnlockNotify.emptyIntList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ScenePointUnlockNotifyOuterClass.ScenePointUnlockNotifyOrBuilder
            public int getSceneId() {
                return this.sceneId_;
            }

            public Builder setSceneId(int value) {
                this.sceneId_ = value;
                onChanged();
                return this;
            }

            public Builder clearSceneId() {
                this.sceneId_ = 0;
                onChanged();
                return this;
            }

            private void ensurePointListIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.pointList_ = ScenePointUnlockNotify.mutableCopy(this.pointList_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.ScenePointUnlockNotifyOuterClass.ScenePointUnlockNotifyOrBuilder
            public List<Integer> getPointListList() {
                return (this.bitField0_ & 2) != 0 ? Collections.unmodifiableList(this.pointList_) : this.pointList_;
            }

            @Override // emu.grasscutter.net.proto.ScenePointUnlockNotifyOuterClass.ScenePointUnlockNotifyOrBuilder
            public int getPointListCount() {
                return this.pointList_.size();
            }

            @Override // emu.grasscutter.net.proto.ScenePointUnlockNotifyOuterClass.ScenePointUnlockNotifyOrBuilder
            public int getPointList(int index) {
                return this.pointList_.getInt(index);
            }

            public Builder setPointList(int index, int value) {
                ensurePointListIsMutable();
                this.pointList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addPointList(int value) {
                ensurePointListIsMutable();
                this.pointList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllPointList(Iterable<? extends Integer> values) {
                ensurePointListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.pointList_);
                onChanged();
                return this;
            }

            public Builder clearPointList() {
                this.pointList_ = ScenePointUnlockNotify.emptyIntList();
                this.bitField0_ &= -3;
                onChanged();
                return this;
            }

            private void ensureHidePointListIsMutable() {
                if ((this.bitField0_ & 4) == 0) {
                    this.hidePointList_ = ScenePointUnlockNotify.mutableCopy(this.hidePointList_);
                    this.bitField0_ |= 4;
                }
            }

            @Override // emu.grasscutter.net.proto.ScenePointUnlockNotifyOuterClass.ScenePointUnlockNotifyOrBuilder
            public List<Integer> getHidePointListList() {
                return (this.bitField0_ & 4) != 0 ? Collections.unmodifiableList(this.hidePointList_) : this.hidePointList_;
            }

            @Override // emu.grasscutter.net.proto.ScenePointUnlockNotifyOuterClass.ScenePointUnlockNotifyOrBuilder
            public int getHidePointListCount() {
                return this.hidePointList_.size();
            }

            @Override // emu.grasscutter.net.proto.ScenePointUnlockNotifyOuterClass.ScenePointUnlockNotifyOrBuilder
            public int getHidePointList(int index) {
                return this.hidePointList_.getInt(index);
            }

            public Builder setHidePointList(int index, int value) {
                ensureHidePointListIsMutable();
                this.hidePointList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addHidePointList(int value) {
                ensureHidePointListIsMutable();
                this.hidePointList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllHidePointList(Iterable<? extends Integer> values) {
                ensureHidePointListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.hidePointList_);
                onChanged();
                return this;
            }

            public Builder clearHidePointList() {
                this.hidePointList_ = ScenePointUnlockNotify.emptyIntList();
                this.bitField0_ &= -5;
                onChanged();
                return this;
            }

            private void ensureUnhidePointListIsMutable() {
                if ((this.bitField0_ & 8) == 0) {
                    this.unhidePointList_ = ScenePointUnlockNotify.mutableCopy(this.unhidePointList_);
                    this.bitField0_ |= 8;
                }
            }

            @Override // emu.grasscutter.net.proto.ScenePointUnlockNotifyOuterClass.ScenePointUnlockNotifyOrBuilder
            public List<Integer> getUnhidePointListList() {
                return (this.bitField0_ & 8) != 0 ? Collections.unmodifiableList(this.unhidePointList_) : this.unhidePointList_;
            }

            @Override // emu.grasscutter.net.proto.ScenePointUnlockNotifyOuterClass.ScenePointUnlockNotifyOrBuilder
            public int getUnhidePointListCount() {
                return this.unhidePointList_.size();
            }

            @Override // emu.grasscutter.net.proto.ScenePointUnlockNotifyOuterClass.ScenePointUnlockNotifyOrBuilder
            public int getUnhidePointList(int index) {
                return this.unhidePointList_.getInt(index);
            }

            public Builder setUnhidePointList(int index, int value) {
                ensureUnhidePointListIsMutable();
                this.unhidePointList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addUnhidePointList(int value) {
                ensureUnhidePointListIsMutable();
                this.unhidePointList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllUnhidePointList(Iterable<? extends Integer> values) {
                ensureUnhidePointListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.unhidePointList_);
                onChanged();
                return this;
            }

            public Builder clearUnhidePointList() {
                this.unhidePointList_ = ScenePointUnlockNotify.emptyIntList();
                this.bitField0_ &= -9;
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

        public static ScenePointUnlockNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ScenePointUnlockNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<ScenePointUnlockNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ScenePointUnlockNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
