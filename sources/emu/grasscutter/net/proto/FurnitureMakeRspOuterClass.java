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
import emu.grasscutter.net.proto.FurnitureMakeBeHelpedDataOuterClass;
import emu.grasscutter.net.proto.FurnitureMakeHelpDataOuterClass;
import emu.grasscutter.net.proto.FurnitureMakeInfoOuterClass;
import emu.grasscutter.net.proto.FurnitureMakeSlotOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FurnitureMakeRspOuterClass.class */
public final class FurnitureMakeRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0016FurnitureMakeRsp.proto\u001a\u0017FurnitureMakeSlot.proto\u001a\u001bFurnitureMakeHelpData.proto\u001a\u0017FurnitureMakeInfo.proto\u001a\u001fFurnitureMakeBeHelpedData.proto\"Þ\u0001\n\u0010FurnitureMakeRsp\u0012\u000f\n\u0007retcode\u0018\u0005 \u0001(\u0005\u0012-\n\u0011furnitureMakeSlot\u0018\u0003 \u0001(\u000b2\u0012.FurnitureMakeSlot\u0012,\n\fhelpDataList\u0018\u0007 \u0003(\u000b2\u0016.FurnitureMakeHelpData\u0012(\n\fmakeInfoList\u0018\b \u0003(\u000b2\u0012.FurnitureMakeInfo\u00122\n\u000ehelpedDataList\u0018\u000e \u0003(\u000b2\u001a.FurnitureMakeBeHelpedDataB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{FurnitureMakeSlotOuterClass.getDescriptor(), FurnitureMakeHelpDataOuterClass.getDescriptor(), FurnitureMakeInfoOuterClass.getDescriptor(), FurnitureMakeBeHelpedDataOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_FurnitureMakeRsp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_FurnitureMakeRsp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_FurnitureMakeRsp_descriptor, new String[]{"Retcode", "FurnitureMakeSlot", "HelpDataList", "MakeInfoList", "HelpedDataList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FurnitureMakeRspOuterClass$FurnitureMakeRspOrBuilder.class */
    public interface FurnitureMakeRspOrBuilder extends MessageOrBuilder {
        int getRetcode();

        boolean hasFurnitureMakeSlot();

        FurnitureMakeSlotOuterClass.FurnitureMakeSlot getFurnitureMakeSlot();

        FurnitureMakeSlotOuterClass.FurnitureMakeSlotOrBuilder getFurnitureMakeSlotOrBuilder();

        List<FurnitureMakeHelpDataOuterClass.FurnitureMakeHelpData> getHelpDataListList();

        FurnitureMakeHelpDataOuterClass.FurnitureMakeHelpData getHelpDataList(int i);

        int getHelpDataListCount();

        List<? extends FurnitureMakeHelpDataOuterClass.FurnitureMakeHelpDataOrBuilder> getHelpDataListOrBuilderList();

        FurnitureMakeHelpDataOuterClass.FurnitureMakeHelpDataOrBuilder getHelpDataListOrBuilder(int i);

        List<FurnitureMakeInfoOuterClass.FurnitureMakeInfo> getMakeInfoListList();

        FurnitureMakeInfoOuterClass.FurnitureMakeInfo getMakeInfoList(int i);

        int getMakeInfoListCount();

        List<? extends FurnitureMakeInfoOuterClass.FurnitureMakeInfoOrBuilder> getMakeInfoListOrBuilderList();

        FurnitureMakeInfoOuterClass.FurnitureMakeInfoOrBuilder getMakeInfoListOrBuilder(int i);

        List<FurnitureMakeBeHelpedDataOuterClass.FurnitureMakeBeHelpedData> getHelpedDataListList();

        FurnitureMakeBeHelpedDataOuterClass.FurnitureMakeBeHelpedData getHelpedDataList(int i);

        int getHelpedDataListCount();

        List<? extends FurnitureMakeBeHelpedDataOuterClass.FurnitureMakeBeHelpedDataOrBuilder> getHelpedDataListOrBuilderList();

        FurnitureMakeBeHelpedDataOuterClass.FurnitureMakeBeHelpedDataOrBuilder getHelpedDataListOrBuilder(int i);
    }

    private FurnitureMakeRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FurnitureMakeRspOuterClass$FurnitureMakeRsp.class */
    public static final class FurnitureMakeRsp extends GeneratedMessageV3 implements FurnitureMakeRspOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int RETCODE_FIELD_NUMBER = 5;
        private int retcode_;
        public static final int FURNITUREMAKESLOT_FIELD_NUMBER = 3;
        private FurnitureMakeSlotOuterClass.FurnitureMakeSlot furnitureMakeSlot_;
        public static final int HELPDATALIST_FIELD_NUMBER = 7;
        private List<FurnitureMakeHelpDataOuterClass.FurnitureMakeHelpData> helpDataList_;
        public static final int MAKEINFOLIST_FIELD_NUMBER = 8;
        private List<FurnitureMakeInfoOuterClass.FurnitureMakeInfo> makeInfoList_;
        public static final int HELPEDDATALIST_FIELD_NUMBER = 14;
        private List<FurnitureMakeBeHelpedDataOuterClass.FurnitureMakeBeHelpedData> helpedDataList_;
        private byte memoizedIsInitialized;
        private static final FurnitureMakeRsp DEFAULT_INSTANCE = new FurnitureMakeRsp();
        private static final Parser<FurnitureMakeRsp> PARSER = new AbstractParser<FurnitureMakeRsp>() { // from class: emu.grasscutter.net.proto.FurnitureMakeRspOuterClass.FurnitureMakeRsp.1
            @Override // com.google.protobuf.Parser
            public FurnitureMakeRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new FurnitureMakeRsp(input, extensionRegistry);
            }
        };

        private FurnitureMakeRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private FurnitureMakeRsp() {
            this.memoizedIsInitialized = -1;
            this.helpDataList_ = Collections.emptyList();
            this.makeInfoList_ = Collections.emptyList();
            this.helpedDataList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new FurnitureMakeRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:79:0x0145 */
        private FurnitureMakeRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                        try {
                            int tag = input.readTag();
                            switch (tag) {
                                case 0:
                                    done = true;
                                    break;
                                case 26:
                                    FurnitureMakeSlotOuterClass.FurnitureMakeSlot.Builder subBuilder = this.furnitureMakeSlot_ != null ? this.furnitureMakeSlot_.toBuilder() : null;
                                    this.furnitureMakeSlot_ = (FurnitureMakeSlotOuterClass.FurnitureMakeSlot) input.readMessage(FurnitureMakeSlotOuterClass.FurnitureMakeSlot.parser(), extensionRegistry);
                                    if (subBuilder == null) {
                                        break;
                                    } else {
                                        subBuilder.mergeFrom(this.furnitureMakeSlot_);
                                        this.furnitureMakeSlot_ = subBuilder.buildPartial();
                                        break;
                                    }
                                case 40:
                                    this.retcode_ = input.readInt32();
                                    break;
                                case 58:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.helpDataList_ = new ArrayList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                    }
                                    this.helpDataList_.add((FurnitureMakeHelpDataOuterClass.FurnitureMakeHelpData) input.readMessage(FurnitureMakeHelpDataOuterClass.FurnitureMakeHelpData.parser(), extensionRegistry));
                                    break;
                                case 66:
                                    if ((mutable_bitField0_ & 2) == 0) {
                                        this.makeInfoList_ = new ArrayList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                    }
                                    this.makeInfoList_.add((FurnitureMakeInfoOuterClass.FurnitureMakeInfo) input.readMessage(FurnitureMakeInfoOuterClass.FurnitureMakeInfo.parser(), extensionRegistry));
                                    break;
                                case 114:
                                    if ((mutable_bitField0_ & 4) == 0) {
                                        this.helpedDataList_ = new ArrayList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 4) == 1 ? 1 : 0;
                                    }
                                    this.helpedDataList_.add((FurnitureMakeBeHelpedDataOuterClass.FurnitureMakeBeHelpedData) input.readMessage(FurnitureMakeBeHelpedDataOuterClass.FurnitureMakeBeHelpedData.parser(), extensionRegistry));
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
                        } catch (IOException e) {
                            throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
                        }
                    } catch (InvalidProtocolBufferException e2) {
                        throw e2.setUnfinishedMessage(this);
                    }
                }
            } finally {
                if ((mutable_bitField0_ & 1) != 0) {
                    this.helpDataList_ = Collections.unmodifiableList(this.helpDataList_);
                }
                if ((mutable_bitField0_ & 2) != 0) {
                    this.makeInfoList_ = Collections.unmodifiableList(this.makeInfoList_);
                }
                if ((mutable_bitField0_ & 4) != 0) {
                    this.helpedDataList_ = Collections.unmodifiableList(this.helpedDataList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return FurnitureMakeRspOuterClass.internal_static_FurnitureMakeRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return FurnitureMakeRspOuterClass.internal_static_FurnitureMakeRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(FurnitureMakeRsp.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.FurnitureMakeRspOuterClass.FurnitureMakeRspOrBuilder
        public int getRetcode() {
            return this.retcode_;
        }

        @Override // emu.grasscutter.net.proto.FurnitureMakeRspOuterClass.FurnitureMakeRspOrBuilder
        public boolean hasFurnitureMakeSlot() {
            return this.furnitureMakeSlot_ != null;
        }

        @Override // emu.grasscutter.net.proto.FurnitureMakeRspOuterClass.FurnitureMakeRspOrBuilder
        public FurnitureMakeSlotOuterClass.FurnitureMakeSlot getFurnitureMakeSlot() {
            return this.furnitureMakeSlot_ == null ? FurnitureMakeSlotOuterClass.FurnitureMakeSlot.getDefaultInstance() : this.furnitureMakeSlot_;
        }

        @Override // emu.grasscutter.net.proto.FurnitureMakeRspOuterClass.FurnitureMakeRspOrBuilder
        public FurnitureMakeSlotOuterClass.FurnitureMakeSlotOrBuilder getFurnitureMakeSlotOrBuilder() {
            return getFurnitureMakeSlot();
        }

        @Override // emu.grasscutter.net.proto.FurnitureMakeRspOuterClass.FurnitureMakeRspOrBuilder
        public List<FurnitureMakeHelpDataOuterClass.FurnitureMakeHelpData> getHelpDataListList() {
            return this.helpDataList_;
        }

        @Override // emu.grasscutter.net.proto.FurnitureMakeRspOuterClass.FurnitureMakeRspOrBuilder
        public List<? extends FurnitureMakeHelpDataOuterClass.FurnitureMakeHelpDataOrBuilder> getHelpDataListOrBuilderList() {
            return this.helpDataList_;
        }

        @Override // emu.grasscutter.net.proto.FurnitureMakeRspOuterClass.FurnitureMakeRspOrBuilder
        public int getHelpDataListCount() {
            return this.helpDataList_.size();
        }

        @Override // emu.grasscutter.net.proto.FurnitureMakeRspOuterClass.FurnitureMakeRspOrBuilder
        public FurnitureMakeHelpDataOuterClass.FurnitureMakeHelpData getHelpDataList(int index) {
            return this.helpDataList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.FurnitureMakeRspOuterClass.FurnitureMakeRspOrBuilder
        public FurnitureMakeHelpDataOuterClass.FurnitureMakeHelpDataOrBuilder getHelpDataListOrBuilder(int index) {
            return this.helpDataList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.FurnitureMakeRspOuterClass.FurnitureMakeRspOrBuilder
        public List<FurnitureMakeInfoOuterClass.FurnitureMakeInfo> getMakeInfoListList() {
            return this.makeInfoList_;
        }

        @Override // emu.grasscutter.net.proto.FurnitureMakeRspOuterClass.FurnitureMakeRspOrBuilder
        public List<? extends FurnitureMakeInfoOuterClass.FurnitureMakeInfoOrBuilder> getMakeInfoListOrBuilderList() {
            return this.makeInfoList_;
        }

        @Override // emu.grasscutter.net.proto.FurnitureMakeRspOuterClass.FurnitureMakeRspOrBuilder
        public int getMakeInfoListCount() {
            return this.makeInfoList_.size();
        }

        @Override // emu.grasscutter.net.proto.FurnitureMakeRspOuterClass.FurnitureMakeRspOrBuilder
        public FurnitureMakeInfoOuterClass.FurnitureMakeInfo getMakeInfoList(int index) {
            return this.makeInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.FurnitureMakeRspOuterClass.FurnitureMakeRspOrBuilder
        public FurnitureMakeInfoOuterClass.FurnitureMakeInfoOrBuilder getMakeInfoListOrBuilder(int index) {
            return this.makeInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.FurnitureMakeRspOuterClass.FurnitureMakeRspOrBuilder
        public List<FurnitureMakeBeHelpedDataOuterClass.FurnitureMakeBeHelpedData> getHelpedDataListList() {
            return this.helpedDataList_;
        }

        @Override // emu.grasscutter.net.proto.FurnitureMakeRspOuterClass.FurnitureMakeRspOrBuilder
        public List<? extends FurnitureMakeBeHelpedDataOuterClass.FurnitureMakeBeHelpedDataOrBuilder> getHelpedDataListOrBuilderList() {
            return this.helpedDataList_;
        }

        @Override // emu.grasscutter.net.proto.FurnitureMakeRspOuterClass.FurnitureMakeRspOrBuilder
        public int getHelpedDataListCount() {
            return this.helpedDataList_.size();
        }

        @Override // emu.grasscutter.net.proto.FurnitureMakeRspOuterClass.FurnitureMakeRspOrBuilder
        public FurnitureMakeBeHelpedDataOuterClass.FurnitureMakeBeHelpedData getHelpedDataList(int index) {
            return this.helpedDataList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.FurnitureMakeRspOuterClass.FurnitureMakeRspOrBuilder
        public FurnitureMakeBeHelpedDataOuterClass.FurnitureMakeBeHelpedDataOrBuilder getHelpedDataListOrBuilder(int index) {
            return this.helpedDataList_.get(index);
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
            if (this.furnitureMakeSlot_ != null) {
                output.writeMessage(3, getFurnitureMakeSlot());
            }
            if (this.retcode_ != 0) {
                output.writeInt32(5, this.retcode_);
            }
            for (int i = 0; i < this.helpDataList_.size(); i++) {
                output.writeMessage(7, this.helpDataList_.get(i));
            }
            for (int i2 = 0; i2 < this.makeInfoList_.size(); i2++) {
                output.writeMessage(8, this.makeInfoList_.get(i2));
            }
            for (int i3 = 0; i3 < this.helpedDataList_.size(); i3++) {
                output.writeMessage(14, this.helpedDataList_.get(i3));
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
            if (this.furnitureMakeSlot_ != null) {
                size2 = 0 + CodedOutputStream.computeMessageSize(3, getFurnitureMakeSlot());
            }
            if (this.retcode_ != 0) {
                size2 += CodedOutputStream.computeInt32Size(5, this.retcode_);
            }
            for (int i = 0; i < this.helpDataList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(7, this.helpDataList_.get(i));
            }
            for (int i2 = 0; i2 < this.makeInfoList_.size(); i2++) {
                size2 += CodedOutputStream.computeMessageSize(8, this.makeInfoList_.get(i2));
            }
            for (int i3 = 0; i3 < this.helpedDataList_.size(); i3++) {
                size2 += CodedOutputStream.computeMessageSize(14, this.helpedDataList_.get(i3));
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
            if (!(obj instanceof FurnitureMakeRsp)) {
                return equals(obj);
            }
            FurnitureMakeRsp other = (FurnitureMakeRsp) obj;
            if (getRetcode() == other.getRetcode() && hasFurnitureMakeSlot() == other.hasFurnitureMakeSlot()) {
                return (!hasFurnitureMakeSlot() || getFurnitureMakeSlot().equals(other.getFurnitureMakeSlot())) && getHelpDataListList().equals(other.getHelpDataListList()) && getMakeInfoListList().equals(other.getMakeInfoListList()) && getHelpedDataListList().equals(other.getHelpedDataListList()) && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 5)) + getRetcode();
            if (hasFurnitureMakeSlot()) {
                hash = (53 * ((37 * hash) + 3)) + getFurnitureMakeSlot().hashCode();
            }
            if (getHelpDataListCount() > 0) {
                hash = (53 * ((37 * hash) + 7)) + getHelpDataListList().hashCode();
            }
            if (getMakeInfoListCount() > 0) {
                hash = (53 * ((37 * hash) + 8)) + getMakeInfoListList().hashCode();
            }
            if (getHelpedDataListCount() > 0) {
                hash = (53 * ((37 * hash) + 14)) + getHelpedDataListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static FurnitureMakeRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static FurnitureMakeRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static FurnitureMakeRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static FurnitureMakeRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static FurnitureMakeRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static FurnitureMakeRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static FurnitureMakeRsp parseFrom(InputStream input) throws IOException {
            return (FurnitureMakeRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static FurnitureMakeRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FurnitureMakeRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static FurnitureMakeRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (FurnitureMakeRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static FurnitureMakeRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FurnitureMakeRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static FurnitureMakeRsp parseFrom(CodedInputStream input) throws IOException {
            return (FurnitureMakeRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static FurnitureMakeRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FurnitureMakeRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(FurnitureMakeRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FurnitureMakeRspOuterClass$FurnitureMakeRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements FurnitureMakeRspOrBuilder {
            private int bitField0_;
            private int retcode_;
            private FurnitureMakeSlotOuterClass.FurnitureMakeSlot furnitureMakeSlot_;
            private SingleFieldBuilderV3<FurnitureMakeSlotOuterClass.FurnitureMakeSlot, FurnitureMakeSlotOuterClass.FurnitureMakeSlot.Builder, FurnitureMakeSlotOuterClass.FurnitureMakeSlotOrBuilder> furnitureMakeSlotBuilder_;
            private RepeatedFieldBuilderV3<FurnitureMakeHelpDataOuterClass.FurnitureMakeHelpData, FurnitureMakeHelpDataOuterClass.FurnitureMakeHelpData.Builder, FurnitureMakeHelpDataOuterClass.FurnitureMakeHelpDataOrBuilder> helpDataListBuilder_;
            private RepeatedFieldBuilderV3<FurnitureMakeInfoOuterClass.FurnitureMakeInfo, FurnitureMakeInfoOuterClass.FurnitureMakeInfo.Builder, FurnitureMakeInfoOuterClass.FurnitureMakeInfoOrBuilder> makeInfoListBuilder_;
            private RepeatedFieldBuilderV3<FurnitureMakeBeHelpedDataOuterClass.FurnitureMakeBeHelpedData, FurnitureMakeBeHelpedDataOuterClass.FurnitureMakeBeHelpedData.Builder, FurnitureMakeBeHelpedDataOuterClass.FurnitureMakeBeHelpedDataOrBuilder> helpedDataListBuilder_;
            private List<FurnitureMakeHelpDataOuterClass.FurnitureMakeHelpData> helpDataList_ = Collections.emptyList();
            private List<FurnitureMakeInfoOuterClass.FurnitureMakeInfo> makeInfoList_ = Collections.emptyList();
            private List<FurnitureMakeBeHelpedDataOuterClass.FurnitureMakeBeHelpedData> helpedDataList_ = Collections.emptyList();

            public static final Descriptors.Descriptor getDescriptor() {
                return FurnitureMakeRspOuterClass.internal_static_FurnitureMakeRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return FurnitureMakeRspOuterClass.internal_static_FurnitureMakeRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(FurnitureMakeRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (FurnitureMakeRsp.alwaysUseFieldBuilders) {
                    getHelpDataListFieldBuilder();
                    getMakeInfoListFieldBuilder();
                    getHelpedDataListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.retcode_ = 0;
                if (this.furnitureMakeSlotBuilder_ == null) {
                    this.furnitureMakeSlot_ = null;
                } else {
                    this.furnitureMakeSlot_ = null;
                    this.furnitureMakeSlotBuilder_ = null;
                }
                if (this.helpDataListBuilder_ == null) {
                    this.helpDataList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.helpDataListBuilder_.clear();
                }
                if (this.makeInfoListBuilder_ == null) {
                    this.makeInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                } else {
                    this.makeInfoListBuilder_.clear();
                }
                if (this.helpedDataListBuilder_ == null) {
                    this.helpedDataList_ = Collections.emptyList();
                    this.bitField0_ &= -5;
                } else {
                    this.helpedDataListBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return FurnitureMakeRspOuterClass.internal_static_FurnitureMakeRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public FurnitureMakeRsp getDefaultInstanceForType() {
                return FurnitureMakeRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public FurnitureMakeRsp build() {
                FurnitureMakeRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public FurnitureMakeRsp buildPartial() {
                FurnitureMakeRsp result = new FurnitureMakeRsp(this);
                int i = this.bitField0_;
                result.retcode_ = this.retcode_;
                if (this.furnitureMakeSlotBuilder_ == null) {
                    result.furnitureMakeSlot_ = this.furnitureMakeSlot_;
                } else {
                    result.furnitureMakeSlot_ = this.furnitureMakeSlotBuilder_.build();
                }
                if (this.helpDataListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.helpDataList_ = Collections.unmodifiableList(this.helpDataList_);
                        this.bitField0_ &= -2;
                    }
                    result.helpDataList_ = this.helpDataList_;
                } else {
                    result.helpDataList_ = this.helpDataListBuilder_.build();
                }
                if (this.makeInfoListBuilder_ == null) {
                    if ((this.bitField0_ & 2) != 0) {
                        this.makeInfoList_ = Collections.unmodifiableList(this.makeInfoList_);
                        this.bitField0_ &= -3;
                    }
                    result.makeInfoList_ = this.makeInfoList_;
                } else {
                    result.makeInfoList_ = this.makeInfoListBuilder_.build();
                }
                if (this.helpedDataListBuilder_ == null) {
                    if ((this.bitField0_ & 4) != 0) {
                        this.helpedDataList_ = Collections.unmodifiableList(this.helpedDataList_);
                        this.bitField0_ &= -5;
                    }
                    result.helpedDataList_ = this.helpedDataList_;
                } else {
                    result.helpedDataList_ = this.helpedDataListBuilder_.build();
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
                if (other instanceof FurnitureMakeRsp) {
                    return mergeFrom((FurnitureMakeRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(FurnitureMakeRsp other) {
                if (other == FurnitureMakeRsp.getDefaultInstance()) {
                    return this;
                }
                if (other.getRetcode() != 0) {
                    setRetcode(other.getRetcode());
                }
                if (other.hasFurnitureMakeSlot()) {
                    mergeFurnitureMakeSlot(other.getFurnitureMakeSlot());
                }
                if (this.helpDataListBuilder_ == null) {
                    if (!other.helpDataList_.isEmpty()) {
                        if (this.helpDataList_.isEmpty()) {
                            this.helpDataList_ = other.helpDataList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureHelpDataListIsMutable();
                            this.helpDataList_.addAll(other.helpDataList_);
                        }
                        onChanged();
                    }
                } else if (!other.helpDataList_.isEmpty()) {
                    if (this.helpDataListBuilder_.isEmpty()) {
                        this.helpDataListBuilder_.dispose();
                        this.helpDataListBuilder_ = null;
                        this.helpDataList_ = other.helpDataList_;
                        this.bitField0_ &= -2;
                        this.helpDataListBuilder_ = FurnitureMakeRsp.alwaysUseFieldBuilders ? getHelpDataListFieldBuilder() : null;
                    } else {
                        this.helpDataListBuilder_.addAllMessages(other.helpDataList_);
                    }
                }
                if (this.makeInfoListBuilder_ == null) {
                    if (!other.makeInfoList_.isEmpty()) {
                        if (this.makeInfoList_.isEmpty()) {
                            this.makeInfoList_ = other.makeInfoList_;
                            this.bitField0_ &= -3;
                        } else {
                            ensureMakeInfoListIsMutable();
                            this.makeInfoList_.addAll(other.makeInfoList_);
                        }
                        onChanged();
                    }
                } else if (!other.makeInfoList_.isEmpty()) {
                    if (this.makeInfoListBuilder_.isEmpty()) {
                        this.makeInfoListBuilder_.dispose();
                        this.makeInfoListBuilder_ = null;
                        this.makeInfoList_ = other.makeInfoList_;
                        this.bitField0_ &= -3;
                        this.makeInfoListBuilder_ = FurnitureMakeRsp.alwaysUseFieldBuilders ? getMakeInfoListFieldBuilder() : null;
                    } else {
                        this.makeInfoListBuilder_.addAllMessages(other.makeInfoList_);
                    }
                }
                if (this.helpedDataListBuilder_ == null) {
                    if (!other.helpedDataList_.isEmpty()) {
                        if (this.helpedDataList_.isEmpty()) {
                            this.helpedDataList_ = other.helpedDataList_;
                            this.bitField0_ &= -5;
                        } else {
                            ensureHelpedDataListIsMutable();
                            this.helpedDataList_.addAll(other.helpedDataList_);
                        }
                        onChanged();
                    }
                } else if (!other.helpedDataList_.isEmpty()) {
                    if (this.helpedDataListBuilder_.isEmpty()) {
                        this.helpedDataListBuilder_.dispose();
                        this.helpedDataListBuilder_ = null;
                        this.helpedDataList_ = other.helpedDataList_;
                        this.bitField0_ &= -5;
                        this.helpedDataListBuilder_ = FurnitureMakeRsp.alwaysUseFieldBuilders ? getHelpedDataListFieldBuilder() : null;
                    } else {
                        this.helpedDataListBuilder_.addAllMessages(other.helpedDataList_);
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
                FurnitureMakeRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = FurnitureMakeRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (FurnitureMakeRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.FurnitureMakeRspOuterClass.FurnitureMakeRspOrBuilder
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

            @Override // emu.grasscutter.net.proto.FurnitureMakeRspOuterClass.FurnitureMakeRspOrBuilder
            public boolean hasFurnitureMakeSlot() {
                return (this.furnitureMakeSlotBuilder_ == null && this.furnitureMakeSlot_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.FurnitureMakeRspOuterClass.FurnitureMakeRspOrBuilder
            public FurnitureMakeSlotOuterClass.FurnitureMakeSlot getFurnitureMakeSlot() {
                if (this.furnitureMakeSlotBuilder_ == null) {
                    return this.furnitureMakeSlot_ == null ? FurnitureMakeSlotOuterClass.FurnitureMakeSlot.getDefaultInstance() : this.furnitureMakeSlot_;
                }
                return this.furnitureMakeSlotBuilder_.getMessage();
            }

            public Builder setFurnitureMakeSlot(FurnitureMakeSlotOuterClass.FurnitureMakeSlot value) {
                if (this.furnitureMakeSlotBuilder_ != null) {
                    this.furnitureMakeSlotBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.furnitureMakeSlot_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setFurnitureMakeSlot(FurnitureMakeSlotOuterClass.FurnitureMakeSlot.Builder builderForValue) {
                if (this.furnitureMakeSlotBuilder_ == null) {
                    this.furnitureMakeSlot_ = builderForValue.build();
                    onChanged();
                } else {
                    this.furnitureMakeSlotBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeFurnitureMakeSlot(FurnitureMakeSlotOuterClass.FurnitureMakeSlot value) {
                if (this.furnitureMakeSlotBuilder_ == null) {
                    if (this.furnitureMakeSlot_ != null) {
                        this.furnitureMakeSlot_ = FurnitureMakeSlotOuterClass.FurnitureMakeSlot.newBuilder(this.furnitureMakeSlot_).mergeFrom(value).buildPartial();
                    } else {
                        this.furnitureMakeSlot_ = value;
                    }
                    onChanged();
                } else {
                    this.furnitureMakeSlotBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearFurnitureMakeSlot() {
                if (this.furnitureMakeSlotBuilder_ == null) {
                    this.furnitureMakeSlot_ = null;
                    onChanged();
                } else {
                    this.furnitureMakeSlot_ = null;
                    this.furnitureMakeSlotBuilder_ = null;
                }
                return this;
            }

            public FurnitureMakeSlotOuterClass.FurnitureMakeSlot.Builder getFurnitureMakeSlotBuilder() {
                onChanged();
                return getFurnitureMakeSlotFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.FurnitureMakeRspOuterClass.FurnitureMakeRspOrBuilder
            public FurnitureMakeSlotOuterClass.FurnitureMakeSlotOrBuilder getFurnitureMakeSlotOrBuilder() {
                if (this.furnitureMakeSlotBuilder_ != null) {
                    return this.furnitureMakeSlotBuilder_.getMessageOrBuilder();
                }
                return this.furnitureMakeSlot_ == null ? FurnitureMakeSlotOuterClass.FurnitureMakeSlot.getDefaultInstance() : this.furnitureMakeSlot_;
            }

            private SingleFieldBuilderV3<FurnitureMakeSlotOuterClass.FurnitureMakeSlot, FurnitureMakeSlotOuterClass.FurnitureMakeSlot.Builder, FurnitureMakeSlotOuterClass.FurnitureMakeSlotOrBuilder> getFurnitureMakeSlotFieldBuilder() {
                if (this.furnitureMakeSlotBuilder_ == null) {
                    this.furnitureMakeSlotBuilder_ = new SingleFieldBuilderV3<>(getFurnitureMakeSlot(), getParentForChildren(), isClean());
                    this.furnitureMakeSlot_ = null;
                }
                return this.furnitureMakeSlotBuilder_;
            }

            private void ensureHelpDataListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.helpDataList_ = new ArrayList(this.helpDataList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.FurnitureMakeRspOuterClass.FurnitureMakeRspOrBuilder
            public List<FurnitureMakeHelpDataOuterClass.FurnitureMakeHelpData> getHelpDataListList() {
                if (this.helpDataListBuilder_ == null) {
                    return Collections.unmodifiableList(this.helpDataList_);
                }
                return this.helpDataListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.FurnitureMakeRspOuterClass.FurnitureMakeRspOrBuilder
            public int getHelpDataListCount() {
                if (this.helpDataListBuilder_ == null) {
                    return this.helpDataList_.size();
                }
                return this.helpDataListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.FurnitureMakeRspOuterClass.FurnitureMakeRspOrBuilder
            public FurnitureMakeHelpDataOuterClass.FurnitureMakeHelpData getHelpDataList(int index) {
                if (this.helpDataListBuilder_ == null) {
                    return this.helpDataList_.get(index);
                }
                return this.helpDataListBuilder_.getMessage(index);
            }

            public Builder setHelpDataList(int index, FurnitureMakeHelpDataOuterClass.FurnitureMakeHelpData value) {
                if (this.helpDataListBuilder_ != null) {
                    this.helpDataListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureHelpDataListIsMutable();
                    this.helpDataList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setHelpDataList(int index, FurnitureMakeHelpDataOuterClass.FurnitureMakeHelpData.Builder builderForValue) {
                if (this.helpDataListBuilder_ == null) {
                    ensureHelpDataListIsMutable();
                    this.helpDataList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.helpDataListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addHelpDataList(FurnitureMakeHelpDataOuterClass.FurnitureMakeHelpData value) {
                if (this.helpDataListBuilder_ != null) {
                    this.helpDataListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureHelpDataListIsMutable();
                    this.helpDataList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addHelpDataList(int index, FurnitureMakeHelpDataOuterClass.FurnitureMakeHelpData value) {
                if (this.helpDataListBuilder_ != null) {
                    this.helpDataListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureHelpDataListIsMutable();
                    this.helpDataList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addHelpDataList(FurnitureMakeHelpDataOuterClass.FurnitureMakeHelpData.Builder builderForValue) {
                if (this.helpDataListBuilder_ == null) {
                    ensureHelpDataListIsMutable();
                    this.helpDataList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.helpDataListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addHelpDataList(int index, FurnitureMakeHelpDataOuterClass.FurnitureMakeHelpData.Builder builderForValue) {
                if (this.helpDataListBuilder_ == null) {
                    ensureHelpDataListIsMutable();
                    this.helpDataList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.helpDataListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllHelpDataList(Iterable<? extends FurnitureMakeHelpDataOuterClass.FurnitureMakeHelpData> values) {
                if (this.helpDataListBuilder_ == null) {
                    ensureHelpDataListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.helpDataList_);
                    onChanged();
                } else {
                    this.helpDataListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearHelpDataList() {
                if (this.helpDataListBuilder_ == null) {
                    this.helpDataList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.helpDataListBuilder_.clear();
                }
                return this;
            }

            public Builder removeHelpDataList(int index) {
                if (this.helpDataListBuilder_ == null) {
                    ensureHelpDataListIsMutable();
                    this.helpDataList_.remove(index);
                    onChanged();
                } else {
                    this.helpDataListBuilder_.remove(index);
                }
                return this;
            }

            public FurnitureMakeHelpDataOuterClass.FurnitureMakeHelpData.Builder getHelpDataListBuilder(int index) {
                return getHelpDataListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.FurnitureMakeRspOuterClass.FurnitureMakeRspOrBuilder
            public FurnitureMakeHelpDataOuterClass.FurnitureMakeHelpDataOrBuilder getHelpDataListOrBuilder(int index) {
                if (this.helpDataListBuilder_ == null) {
                    return this.helpDataList_.get(index);
                }
                return this.helpDataListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.FurnitureMakeRspOuterClass.FurnitureMakeRspOrBuilder
            public List<? extends FurnitureMakeHelpDataOuterClass.FurnitureMakeHelpDataOrBuilder> getHelpDataListOrBuilderList() {
                if (this.helpDataListBuilder_ != null) {
                    return this.helpDataListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.helpDataList_);
            }

            public FurnitureMakeHelpDataOuterClass.FurnitureMakeHelpData.Builder addHelpDataListBuilder() {
                return getHelpDataListFieldBuilder().addBuilder(FurnitureMakeHelpDataOuterClass.FurnitureMakeHelpData.getDefaultInstance());
            }

            public FurnitureMakeHelpDataOuterClass.FurnitureMakeHelpData.Builder addHelpDataListBuilder(int index) {
                return getHelpDataListFieldBuilder().addBuilder(index, FurnitureMakeHelpDataOuterClass.FurnitureMakeHelpData.getDefaultInstance());
            }

            public List<FurnitureMakeHelpDataOuterClass.FurnitureMakeHelpData.Builder> getHelpDataListBuilderList() {
                return getHelpDataListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<FurnitureMakeHelpDataOuterClass.FurnitureMakeHelpData, FurnitureMakeHelpDataOuterClass.FurnitureMakeHelpData.Builder, FurnitureMakeHelpDataOuterClass.FurnitureMakeHelpDataOrBuilder> getHelpDataListFieldBuilder() {
                if (this.helpDataListBuilder_ == null) {
                    this.helpDataListBuilder_ = new RepeatedFieldBuilderV3<>(this.helpDataList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.helpDataList_ = null;
                }
                return this.helpDataListBuilder_;
            }

            private void ensureMakeInfoListIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.makeInfoList_ = new ArrayList(this.makeInfoList_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.FurnitureMakeRspOuterClass.FurnitureMakeRspOrBuilder
            public List<FurnitureMakeInfoOuterClass.FurnitureMakeInfo> getMakeInfoListList() {
                if (this.makeInfoListBuilder_ == null) {
                    return Collections.unmodifiableList(this.makeInfoList_);
                }
                return this.makeInfoListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.FurnitureMakeRspOuterClass.FurnitureMakeRspOrBuilder
            public int getMakeInfoListCount() {
                if (this.makeInfoListBuilder_ == null) {
                    return this.makeInfoList_.size();
                }
                return this.makeInfoListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.FurnitureMakeRspOuterClass.FurnitureMakeRspOrBuilder
            public FurnitureMakeInfoOuterClass.FurnitureMakeInfo getMakeInfoList(int index) {
                if (this.makeInfoListBuilder_ == null) {
                    return this.makeInfoList_.get(index);
                }
                return this.makeInfoListBuilder_.getMessage(index);
            }

            public Builder setMakeInfoList(int index, FurnitureMakeInfoOuterClass.FurnitureMakeInfo value) {
                if (this.makeInfoListBuilder_ != null) {
                    this.makeInfoListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureMakeInfoListIsMutable();
                    this.makeInfoList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setMakeInfoList(int index, FurnitureMakeInfoOuterClass.FurnitureMakeInfo.Builder builderForValue) {
                if (this.makeInfoListBuilder_ == null) {
                    ensureMakeInfoListIsMutable();
                    this.makeInfoList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.makeInfoListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addMakeInfoList(FurnitureMakeInfoOuterClass.FurnitureMakeInfo value) {
                if (this.makeInfoListBuilder_ != null) {
                    this.makeInfoListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureMakeInfoListIsMutable();
                    this.makeInfoList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addMakeInfoList(int index, FurnitureMakeInfoOuterClass.FurnitureMakeInfo value) {
                if (this.makeInfoListBuilder_ != null) {
                    this.makeInfoListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureMakeInfoListIsMutable();
                    this.makeInfoList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addMakeInfoList(FurnitureMakeInfoOuterClass.FurnitureMakeInfo.Builder builderForValue) {
                if (this.makeInfoListBuilder_ == null) {
                    ensureMakeInfoListIsMutable();
                    this.makeInfoList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.makeInfoListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addMakeInfoList(int index, FurnitureMakeInfoOuterClass.FurnitureMakeInfo.Builder builderForValue) {
                if (this.makeInfoListBuilder_ == null) {
                    ensureMakeInfoListIsMutable();
                    this.makeInfoList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.makeInfoListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllMakeInfoList(Iterable<? extends FurnitureMakeInfoOuterClass.FurnitureMakeInfo> values) {
                if (this.makeInfoListBuilder_ == null) {
                    ensureMakeInfoListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.makeInfoList_);
                    onChanged();
                } else {
                    this.makeInfoListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearMakeInfoList() {
                if (this.makeInfoListBuilder_ == null) {
                    this.makeInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                    onChanged();
                } else {
                    this.makeInfoListBuilder_.clear();
                }
                return this;
            }

            public Builder removeMakeInfoList(int index) {
                if (this.makeInfoListBuilder_ == null) {
                    ensureMakeInfoListIsMutable();
                    this.makeInfoList_.remove(index);
                    onChanged();
                } else {
                    this.makeInfoListBuilder_.remove(index);
                }
                return this;
            }

            public FurnitureMakeInfoOuterClass.FurnitureMakeInfo.Builder getMakeInfoListBuilder(int index) {
                return getMakeInfoListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.FurnitureMakeRspOuterClass.FurnitureMakeRspOrBuilder
            public FurnitureMakeInfoOuterClass.FurnitureMakeInfoOrBuilder getMakeInfoListOrBuilder(int index) {
                if (this.makeInfoListBuilder_ == null) {
                    return this.makeInfoList_.get(index);
                }
                return this.makeInfoListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.FurnitureMakeRspOuterClass.FurnitureMakeRspOrBuilder
            public List<? extends FurnitureMakeInfoOuterClass.FurnitureMakeInfoOrBuilder> getMakeInfoListOrBuilderList() {
                if (this.makeInfoListBuilder_ != null) {
                    return this.makeInfoListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.makeInfoList_);
            }

            public FurnitureMakeInfoOuterClass.FurnitureMakeInfo.Builder addMakeInfoListBuilder() {
                return getMakeInfoListFieldBuilder().addBuilder(FurnitureMakeInfoOuterClass.FurnitureMakeInfo.getDefaultInstance());
            }

            public FurnitureMakeInfoOuterClass.FurnitureMakeInfo.Builder addMakeInfoListBuilder(int index) {
                return getMakeInfoListFieldBuilder().addBuilder(index, FurnitureMakeInfoOuterClass.FurnitureMakeInfo.getDefaultInstance());
            }

            public List<FurnitureMakeInfoOuterClass.FurnitureMakeInfo.Builder> getMakeInfoListBuilderList() {
                return getMakeInfoListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<FurnitureMakeInfoOuterClass.FurnitureMakeInfo, FurnitureMakeInfoOuterClass.FurnitureMakeInfo.Builder, FurnitureMakeInfoOuterClass.FurnitureMakeInfoOrBuilder> getMakeInfoListFieldBuilder() {
                if (this.makeInfoListBuilder_ == null) {
                    this.makeInfoListBuilder_ = new RepeatedFieldBuilderV3<>(this.makeInfoList_, (this.bitField0_ & 2) != 0, getParentForChildren(), isClean());
                    this.makeInfoList_ = null;
                }
                return this.makeInfoListBuilder_;
            }

            private void ensureHelpedDataListIsMutable() {
                if ((this.bitField0_ & 4) == 0) {
                    this.helpedDataList_ = new ArrayList(this.helpedDataList_);
                    this.bitField0_ |= 4;
                }
            }

            @Override // emu.grasscutter.net.proto.FurnitureMakeRspOuterClass.FurnitureMakeRspOrBuilder
            public List<FurnitureMakeBeHelpedDataOuterClass.FurnitureMakeBeHelpedData> getHelpedDataListList() {
                if (this.helpedDataListBuilder_ == null) {
                    return Collections.unmodifiableList(this.helpedDataList_);
                }
                return this.helpedDataListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.FurnitureMakeRspOuterClass.FurnitureMakeRspOrBuilder
            public int getHelpedDataListCount() {
                if (this.helpedDataListBuilder_ == null) {
                    return this.helpedDataList_.size();
                }
                return this.helpedDataListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.FurnitureMakeRspOuterClass.FurnitureMakeRspOrBuilder
            public FurnitureMakeBeHelpedDataOuterClass.FurnitureMakeBeHelpedData getHelpedDataList(int index) {
                if (this.helpedDataListBuilder_ == null) {
                    return this.helpedDataList_.get(index);
                }
                return this.helpedDataListBuilder_.getMessage(index);
            }

            public Builder setHelpedDataList(int index, FurnitureMakeBeHelpedDataOuterClass.FurnitureMakeBeHelpedData value) {
                if (this.helpedDataListBuilder_ != null) {
                    this.helpedDataListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureHelpedDataListIsMutable();
                    this.helpedDataList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setHelpedDataList(int index, FurnitureMakeBeHelpedDataOuterClass.FurnitureMakeBeHelpedData.Builder builderForValue) {
                if (this.helpedDataListBuilder_ == null) {
                    ensureHelpedDataListIsMutable();
                    this.helpedDataList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.helpedDataListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addHelpedDataList(FurnitureMakeBeHelpedDataOuterClass.FurnitureMakeBeHelpedData value) {
                if (this.helpedDataListBuilder_ != null) {
                    this.helpedDataListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureHelpedDataListIsMutable();
                    this.helpedDataList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addHelpedDataList(int index, FurnitureMakeBeHelpedDataOuterClass.FurnitureMakeBeHelpedData value) {
                if (this.helpedDataListBuilder_ != null) {
                    this.helpedDataListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureHelpedDataListIsMutable();
                    this.helpedDataList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addHelpedDataList(FurnitureMakeBeHelpedDataOuterClass.FurnitureMakeBeHelpedData.Builder builderForValue) {
                if (this.helpedDataListBuilder_ == null) {
                    ensureHelpedDataListIsMutable();
                    this.helpedDataList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.helpedDataListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addHelpedDataList(int index, FurnitureMakeBeHelpedDataOuterClass.FurnitureMakeBeHelpedData.Builder builderForValue) {
                if (this.helpedDataListBuilder_ == null) {
                    ensureHelpedDataListIsMutable();
                    this.helpedDataList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.helpedDataListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllHelpedDataList(Iterable<? extends FurnitureMakeBeHelpedDataOuterClass.FurnitureMakeBeHelpedData> values) {
                if (this.helpedDataListBuilder_ == null) {
                    ensureHelpedDataListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.helpedDataList_);
                    onChanged();
                } else {
                    this.helpedDataListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearHelpedDataList() {
                if (this.helpedDataListBuilder_ == null) {
                    this.helpedDataList_ = Collections.emptyList();
                    this.bitField0_ &= -5;
                    onChanged();
                } else {
                    this.helpedDataListBuilder_.clear();
                }
                return this;
            }

            public Builder removeHelpedDataList(int index) {
                if (this.helpedDataListBuilder_ == null) {
                    ensureHelpedDataListIsMutable();
                    this.helpedDataList_.remove(index);
                    onChanged();
                } else {
                    this.helpedDataListBuilder_.remove(index);
                }
                return this;
            }

            public FurnitureMakeBeHelpedDataOuterClass.FurnitureMakeBeHelpedData.Builder getHelpedDataListBuilder(int index) {
                return getHelpedDataListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.FurnitureMakeRspOuterClass.FurnitureMakeRspOrBuilder
            public FurnitureMakeBeHelpedDataOuterClass.FurnitureMakeBeHelpedDataOrBuilder getHelpedDataListOrBuilder(int index) {
                if (this.helpedDataListBuilder_ == null) {
                    return this.helpedDataList_.get(index);
                }
                return this.helpedDataListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.FurnitureMakeRspOuterClass.FurnitureMakeRspOrBuilder
            public List<? extends FurnitureMakeBeHelpedDataOuterClass.FurnitureMakeBeHelpedDataOrBuilder> getHelpedDataListOrBuilderList() {
                if (this.helpedDataListBuilder_ != null) {
                    return this.helpedDataListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.helpedDataList_);
            }

            public FurnitureMakeBeHelpedDataOuterClass.FurnitureMakeBeHelpedData.Builder addHelpedDataListBuilder() {
                return getHelpedDataListFieldBuilder().addBuilder(FurnitureMakeBeHelpedDataOuterClass.FurnitureMakeBeHelpedData.getDefaultInstance());
            }

            public FurnitureMakeBeHelpedDataOuterClass.FurnitureMakeBeHelpedData.Builder addHelpedDataListBuilder(int index) {
                return getHelpedDataListFieldBuilder().addBuilder(index, FurnitureMakeBeHelpedDataOuterClass.FurnitureMakeBeHelpedData.getDefaultInstance());
            }

            public List<FurnitureMakeBeHelpedDataOuterClass.FurnitureMakeBeHelpedData.Builder> getHelpedDataListBuilderList() {
                return getHelpedDataListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<FurnitureMakeBeHelpedDataOuterClass.FurnitureMakeBeHelpedData, FurnitureMakeBeHelpedDataOuterClass.FurnitureMakeBeHelpedData.Builder, FurnitureMakeBeHelpedDataOuterClass.FurnitureMakeBeHelpedDataOrBuilder> getHelpedDataListFieldBuilder() {
                if (this.helpedDataListBuilder_ == null) {
                    this.helpedDataListBuilder_ = new RepeatedFieldBuilderV3<>(this.helpedDataList_, (this.bitField0_ & 4) != 0, getParentForChildren(), isClean());
                    this.helpedDataList_ = null;
                }
                return this.helpedDataListBuilder_;
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

        public static FurnitureMakeRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<FurnitureMakeRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<FurnitureMakeRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public FurnitureMakeRsp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        FurnitureMakeSlotOuterClass.getDescriptor();
        FurnitureMakeHelpDataOuterClass.getDescriptor();
        FurnitureMakeInfoOuterClass.getDescriptor();
        FurnitureMakeBeHelpedDataOuterClass.getDescriptor();
    }
}
