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
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.BreakoutActionTypeOuterClass;
import emu.grasscutter.net.proto.BreakoutVector2OuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BreakoutActionOuterClass.class */
public final class BreakoutActionOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0014BreakoutAction.proto\u001a\u0018BreakoutActionType.proto\u001a\u0015BreakoutVector2.proto\"Â\u0003\n\u000eBreakoutAction\u0012'\n\nactionType\u0018\u0001 \u0001(\u000e2\u0013.BreakoutActionType\u0012\u0016\n\u000eclientGameTime\u0018\u0002 \u0001(\u0004\u0012\u0016\n\u000eserverGameTime\u0018\u0003 \u0001(\u0004\u0012\u0013\n\u000bmbfjjacbmck\u0018\u0004 \u0001(\b\u0012\u0013\n\u000bgddolpoemjk\u0018\u0005 \u0001(\r\u0012\u0013\n\u000bjoandihiadc\u0018\u0006 \u0001(\r\u0012\u001d\n\u0003pos\u0018\u0007 \u0001(\u000b2\u0010.BreakoutVector2\u0012%\n\u000bmjehpphliia\u0018\b \u0001(\u000b2\u0010.BreakoutVector2\u0012\r\n\u0005speed\u0018\t \u0001(\u0005\u0012\u000e\n\u0006peerId\u0018\n \u0001(\r\u0012\u0013\n\u000belementType\u0018\u000b \u0001(\r\u0012\u0013\n\u000binhflokdoal\u0018\f \u0001(\r\u0012\u0013\n\u000bapiembahlab\u0018\r \u0001(\r\u0012\u0013\n\u000bmhkdmdjeaan\u0018\u000e \u0001(\b\u0012%\n\u000bcjegmomlbck\u0018\u000f \u0001(\u000b2\u0010.BreakoutVector2\u0012\u0013\n\u000bidngdpalicj\u0018\u0010 \u0001(\r\u0012\u000e\n\u0006offset\u0018\u0011 \u0001(\u0005\u0012\u0013\n\u000blccmdkibdpf\u0018\u0012 \u0001(\u0004B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{BreakoutActionTypeOuterClass.getDescriptor(), BreakoutVector2OuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_BreakoutAction_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_BreakoutAction_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_BreakoutAction_descriptor, new String[]{"ActionType", "ClientGameTime", "ServerGameTime", "Mbfjjacbmck", "Gddolpoemjk", "Joandihiadc", "Pos", "Mjehpphliia", "Speed", "PeerId", "ElementType", "Inhflokdoal", "Apiembahlab", "Mhkdmdjeaan", "Cjegmomlbck", "Idngdpalicj", "Offset", "Lccmdkibdpf"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BreakoutActionOuterClass$BreakoutActionOrBuilder.class */
    public interface BreakoutActionOrBuilder extends MessageOrBuilder {
        int getActionTypeValue();

        BreakoutActionTypeOuterClass.BreakoutActionType getActionType();

        long getClientGameTime();

        long getServerGameTime();

        boolean getMbfjjacbmck();

        int getGddolpoemjk();

        int getJoandihiadc();

        boolean hasPos();

        BreakoutVector2OuterClass.BreakoutVector2 getPos();

        BreakoutVector2OuterClass.BreakoutVector2OrBuilder getPosOrBuilder();

        boolean hasMjehpphliia();

        BreakoutVector2OuterClass.BreakoutVector2 getMjehpphliia();

        BreakoutVector2OuterClass.BreakoutVector2OrBuilder getMjehpphliiaOrBuilder();

        int getSpeed();

        int getPeerId();

        int getElementType();

        int getInhflokdoal();

        int getApiembahlab();

        boolean getMhkdmdjeaan();

        boolean hasCjegmomlbck();

        BreakoutVector2OuterClass.BreakoutVector2 getCjegmomlbck();

        BreakoutVector2OuterClass.BreakoutVector2OrBuilder getCjegmomlbckOrBuilder();

        int getIdngdpalicj();

        int getOffset();

        long getLccmdkibdpf();
    }

    private BreakoutActionOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BreakoutActionOuterClass$BreakoutAction.class */
    public static final class BreakoutAction extends GeneratedMessageV3 implements BreakoutActionOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int ACTIONTYPE_FIELD_NUMBER = 1;
        private int actionType_;
        public static final int CLIENTGAMETIME_FIELD_NUMBER = 2;
        private long clientGameTime_;
        public static final int SERVERGAMETIME_FIELD_NUMBER = 3;
        private long serverGameTime_;
        public static final int MBFJJACBMCK_FIELD_NUMBER = 4;
        private boolean mbfjjacbmck_;
        public static final int GDDOLPOEMJK_FIELD_NUMBER = 5;
        private int gddolpoemjk_;
        public static final int JOANDIHIADC_FIELD_NUMBER = 6;
        private int joandihiadc_;
        public static final int POS_FIELD_NUMBER = 7;
        private BreakoutVector2OuterClass.BreakoutVector2 pos_;
        public static final int MJEHPPHLIIA_FIELD_NUMBER = 8;
        private BreakoutVector2OuterClass.BreakoutVector2 mjehpphliia_;
        public static final int SPEED_FIELD_NUMBER = 9;
        private int speed_;
        public static final int PEERID_FIELD_NUMBER = 10;
        private int peerId_;
        public static final int ELEMENTTYPE_FIELD_NUMBER = 11;
        private int elementType_;
        public static final int INHFLOKDOAL_FIELD_NUMBER = 12;
        private int inhflokdoal_;
        public static final int APIEMBAHLAB_FIELD_NUMBER = 13;
        private int apiembahlab_;
        public static final int MHKDMDJEAAN_FIELD_NUMBER = 14;
        private boolean mhkdmdjeaan_;
        public static final int CJEGMOMLBCK_FIELD_NUMBER = 15;
        private BreakoutVector2OuterClass.BreakoutVector2 cjegmomlbck_;
        public static final int IDNGDPALICJ_FIELD_NUMBER = 16;
        private int idngdpalicj_;
        public static final int OFFSET_FIELD_NUMBER = 17;
        private int offset_;
        public static final int LCCMDKIBDPF_FIELD_NUMBER = 18;
        private long lccmdkibdpf_;
        private byte memoizedIsInitialized;
        private static final BreakoutAction DEFAULT_INSTANCE = new BreakoutAction();
        private static final Parser<BreakoutAction> PARSER = new AbstractParser<BreakoutAction>() { // from class: emu.grasscutter.net.proto.BreakoutActionOuterClass.BreakoutAction.1
            @Override // com.google.protobuf.Parser
            public BreakoutAction parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new BreakoutAction(input, extensionRegistry);
            }
        };

        private BreakoutAction(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private BreakoutAction() {
            this.memoizedIsInitialized = -1;
            this.actionType_ = 0;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new BreakoutAction();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private BreakoutAction(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 8:
                                this.actionType_ = input.readEnum();
                                break;
                            case 16:
                                this.clientGameTime_ = input.readUInt64();
                                break;
                            case 24:
                                this.serverGameTime_ = input.readUInt64();
                                break;
                            case 32:
                                this.mbfjjacbmck_ = input.readBool();
                                break;
                            case 40:
                                this.gddolpoemjk_ = input.readUInt32();
                                break;
                            case 48:
                                this.joandihiadc_ = input.readUInt32();
                                break;
                            case 58:
                                BreakoutVector2OuterClass.BreakoutVector2.Builder subBuilder = this.pos_ != null ? this.pos_.toBuilder() : null;
                                this.pos_ = (BreakoutVector2OuterClass.BreakoutVector2) input.readMessage(BreakoutVector2OuterClass.BreakoutVector2.parser(), extensionRegistry);
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.mergeFrom(this.pos_);
                                    this.pos_ = subBuilder.buildPartial();
                                    break;
                                }
                            case 66:
                                BreakoutVector2OuterClass.BreakoutVector2.Builder subBuilder2 = this.mjehpphliia_ != null ? this.mjehpphliia_.toBuilder() : null;
                                this.mjehpphliia_ = (BreakoutVector2OuterClass.BreakoutVector2) input.readMessage(BreakoutVector2OuterClass.BreakoutVector2.parser(), extensionRegistry);
                                if (subBuilder2 == null) {
                                    break;
                                } else {
                                    subBuilder2.mergeFrom(this.mjehpphliia_);
                                    this.mjehpphliia_ = subBuilder2.buildPartial();
                                    break;
                                }
                            case 72:
                                this.speed_ = input.readInt32();
                                break;
                            case 80:
                                this.peerId_ = input.readUInt32();
                                break;
                            case 88:
                                this.elementType_ = input.readUInt32();
                                break;
                            case 96:
                                this.inhflokdoal_ = input.readUInt32();
                                break;
                            case 104:
                                this.apiembahlab_ = input.readUInt32();
                                break;
                            case 112:
                                this.mhkdmdjeaan_ = input.readBool();
                                break;
                            case 122:
                                BreakoutVector2OuterClass.BreakoutVector2.Builder subBuilder3 = this.cjegmomlbck_ != null ? this.cjegmomlbck_.toBuilder() : null;
                                this.cjegmomlbck_ = (BreakoutVector2OuterClass.BreakoutVector2) input.readMessage(BreakoutVector2OuterClass.BreakoutVector2.parser(), extensionRegistry);
                                if (subBuilder3 == null) {
                                    break;
                                } else {
                                    subBuilder3.mergeFrom(this.cjegmomlbck_);
                                    this.cjegmomlbck_ = subBuilder3.buildPartial();
                                    break;
                                }
                            case 128:
                                this.idngdpalicj_ = input.readUInt32();
                                break;
                            case 136:
                                this.offset_ = input.readInt32();
                                break;
                            case 144:
                                this.lccmdkibdpf_ = input.readUInt64();
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
            return BreakoutActionOuterClass.internal_static_BreakoutAction_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return BreakoutActionOuterClass.internal_static_BreakoutAction_fieldAccessorTable.ensureFieldAccessorsInitialized(BreakoutAction.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.BreakoutActionOuterClass.BreakoutActionOrBuilder
        public int getActionTypeValue() {
            return this.actionType_;
        }

        @Override // emu.grasscutter.net.proto.BreakoutActionOuterClass.BreakoutActionOrBuilder
        public BreakoutActionTypeOuterClass.BreakoutActionType getActionType() {
            BreakoutActionTypeOuterClass.BreakoutActionType result = BreakoutActionTypeOuterClass.BreakoutActionType.valueOf(this.actionType_);
            return result == null ? BreakoutActionTypeOuterClass.BreakoutActionType.UNRECOGNIZED : result;
        }

        @Override // emu.grasscutter.net.proto.BreakoutActionOuterClass.BreakoutActionOrBuilder
        public long getClientGameTime() {
            return this.clientGameTime_;
        }

        @Override // emu.grasscutter.net.proto.BreakoutActionOuterClass.BreakoutActionOrBuilder
        public long getServerGameTime() {
            return this.serverGameTime_;
        }

        @Override // emu.grasscutter.net.proto.BreakoutActionOuterClass.BreakoutActionOrBuilder
        public boolean getMbfjjacbmck() {
            return this.mbfjjacbmck_;
        }

        @Override // emu.grasscutter.net.proto.BreakoutActionOuterClass.BreakoutActionOrBuilder
        public int getGddolpoemjk() {
            return this.gddolpoemjk_;
        }

        @Override // emu.grasscutter.net.proto.BreakoutActionOuterClass.BreakoutActionOrBuilder
        public int getJoandihiadc() {
            return this.joandihiadc_;
        }

        @Override // emu.grasscutter.net.proto.BreakoutActionOuterClass.BreakoutActionOrBuilder
        public boolean hasPos() {
            return this.pos_ != null;
        }

        @Override // emu.grasscutter.net.proto.BreakoutActionOuterClass.BreakoutActionOrBuilder
        public BreakoutVector2OuterClass.BreakoutVector2 getPos() {
            return this.pos_ == null ? BreakoutVector2OuterClass.BreakoutVector2.getDefaultInstance() : this.pos_;
        }

        @Override // emu.grasscutter.net.proto.BreakoutActionOuterClass.BreakoutActionOrBuilder
        public BreakoutVector2OuterClass.BreakoutVector2OrBuilder getPosOrBuilder() {
            return getPos();
        }

        @Override // emu.grasscutter.net.proto.BreakoutActionOuterClass.BreakoutActionOrBuilder
        public boolean hasMjehpphliia() {
            return this.mjehpphliia_ != null;
        }

        @Override // emu.grasscutter.net.proto.BreakoutActionOuterClass.BreakoutActionOrBuilder
        public BreakoutVector2OuterClass.BreakoutVector2 getMjehpphliia() {
            return this.mjehpphliia_ == null ? BreakoutVector2OuterClass.BreakoutVector2.getDefaultInstance() : this.mjehpphliia_;
        }

        @Override // emu.grasscutter.net.proto.BreakoutActionOuterClass.BreakoutActionOrBuilder
        public BreakoutVector2OuterClass.BreakoutVector2OrBuilder getMjehpphliiaOrBuilder() {
            return getMjehpphliia();
        }

        @Override // emu.grasscutter.net.proto.BreakoutActionOuterClass.BreakoutActionOrBuilder
        public int getSpeed() {
            return this.speed_;
        }

        @Override // emu.grasscutter.net.proto.BreakoutActionOuterClass.BreakoutActionOrBuilder
        public int getPeerId() {
            return this.peerId_;
        }

        @Override // emu.grasscutter.net.proto.BreakoutActionOuterClass.BreakoutActionOrBuilder
        public int getElementType() {
            return this.elementType_;
        }

        @Override // emu.grasscutter.net.proto.BreakoutActionOuterClass.BreakoutActionOrBuilder
        public int getInhflokdoal() {
            return this.inhflokdoal_;
        }

        @Override // emu.grasscutter.net.proto.BreakoutActionOuterClass.BreakoutActionOrBuilder
        public int getApiembahlab() {
            return this.apiembahlab_;
        }

        @Override // emu.grasscutter.net.proto.BreakoutActionOuterClass.BreakoutActionOrBuilder
        public boolean getMhkdmdjeaan() {
            return this.mhkdmdjeaan_;
        }

        @Override // emu.grasscutter.net.proto.BreakoutActionOuterClass.BreakoutActionOrBuilder
        public boolean hasCjegmomlbck() {
            return this.cjegmomlbck_ != null;
        }

        @Override // emu.grasscutter.net.proto.BreakoutActionOuterClass.BreakoutActionOrBuilder
        public BreakoutVector2OuterClass.BreakoutVector2 getCjegmomlbck() {
            return this.cjegmomlbck_ == null ? BreakoutVector2OuterClass.BreakoutVector2.getDefaultInstance() : this.cjegmomlbck_;
        }

        @Override // emu.grasscutter.net.proto.BreakoutActionOuterClass.BreakoutActionOrBuilder
        public BreakoutVector2OuterClass.BreakoutVector2OrBuilder getCjegmomlbckOrBuilder() {
            return getCjegmomlbck();
        }

        @Override // emu.grasscutter.net.proto.BreakoutActionOuterClass.BreakoutActionOrBuilder
        public int getIdngdpalicj() {
            return this.idngdpalicj_;
        }

        @Override // emu.grasscutter.net.proto.BreakoutActionOuterClass.BreakoutActionOrBuilder
        public int getOffset() {
            return this.offset_;
        }

        @Override // emu.grasscutter.net.proto.BreakoutActionOuterClass.BreakoutActionOrBuilder
        public long getLccmdkibdpf() {
            return this.lccmdkibdpf_;
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
            if (this.actionType_ != BreakoutActionTypeOuterClass.BreakoutActionType.BREAKOUT_ACTION_TYPE_NONE.getNumber()) {
                output.writeEnum(1, this.actionType_);
            }
            if (this.clientGameTime_ != 0) {
                output.writeUInt64(2, this.clientGameTime_);
            }
            if (this.serverGameTime_ != 0) {
                output.writeUInt64(3, this.serverGameTime_);
            }
            if (this.mbfjjacbmck_) {
                output.writeBool(4, this.mbfjjacbmck_);
            }
            if (this.gddolpoemjk_ != 0) {
                output.writeUInt32(5, this.gddolpoemjk_);
            }
            if (this.joandihiadc_ != 0) {
                output.writeUInt32(6, this.joandihiadc_);
            }
            if (this.pos_ != null) {
                output.writeMessage(7, getPos());
            }
            if (this.mjehpphliia_ != null) {
                output.writeMessage(8, getMjehpphliia());
            }
            if (this.speed_ != 0) {
                output.writeInt32(9, this.speed_);
            }
            if (this.peerId_ != 0) {
                output.writeUInt32(10, this.peerId_);
            }
            if (this.elementType_ != 0) {
                output.writeUInt32(11, this.elementType_);
            }
            if (this.inhflokdoal_ != 0) {
                output.writeUInt32(12, this.inhflokdoal_);
            }
            if (this.apiembahlab_ != 0) {
                output.writeUInt32(13, this.apiembahlab_);
            }
            if (this.mhkdmdjeaan_) {
                output.writeBool(14, this.mhkdmdjeaan_);
            }
            if (this.cjegmomlbck_ != null) {
                output.writeMessage(15, getCjegmomlbck());
            }
            if (this.idngdpalicj_ != 0) {
                output.writeUInt32(16, this.idngdpalicj_);
            }
            if (this.offset_ != 0) {
                output.writeInt32(17, this.offset_);
            }
            if (this.lccmdkibdpf_ != 0) {
                output.writeUInt64(18, this.lccmdkibdpf_);
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
            if (this.actionType_ != BreakoutActionTypeOuterClass.BreakoutActionType.BREAKOUT_ACTION_TYPE_NONE.getNumber()) {
                size2 = 0 + CodedOutputStream.computeEnumSize(1, this.actionType_);
            }
            if (this.clientGameTime_ != 0) {
                size2 += CodedOutputStream.computeUInt64Size(2, this.clientGameTime_);
            }
            if (this.serverGameTime_ != 0) {
                size2 += CodedOutputStream.computeUInt64Size(3, this.serverGameTime_);
            }
            if (this.mbfjjacbmck_) {
                size2 += CodedOutputStream.computeBoolSize(4, this.mbfjjacbmck_);
            }
            if (this.gddolpoemjk_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(5, this.gddolpoemjk_);
            }
            if (this.joandihiadc_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(6, this.joandihiadc_);
            }
            if (this.pos_ != null) {
                size2 += CodedOutputStream.computeMessageSize(7, getPos());
            }
            if (this.mjehpphliia_ != null) {
                size2 += CodedOutputStream.computeMessageSize(8, getMjehpphliia());
            }
            if (this.speed_ != 0) {
                size2 += CodedOutputStream.computeInt32Size(9, this.speed_);
            }
            if (this.peerId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(10, this.peerId_);
            }
            if (this.elementType_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(11, this.elementType_);
            }
            if (this.inhflokdoal_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(12, this.inhflokdoal_);
            }
            if (this.apiembahlab_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(13, this.apiembahlab_);
            }
            if (this.mhkdmdjeaan_) {
                size2 += CodedOutputStream.computeBoolSize(14, this.mhkdmdjeaan_);
            }
            if (this.cjegmomlbck_ != null) {
                size2 += CodedOutputStream.computeMessageSize(15, getCjegmomlbck());
            }
            if (this.idngdpalicj_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(16, this.idngdpalicj_);
            }
            if (this.offset_ != 0) {
                size2 += CodedOutputStream.computeInt32Size(17, this.offset_);
            }
            if (this.lccmdkibdpf_ != 0) {
                size2 += CodedOutputStream.computeUInt64Size(18, this.lccmdkibdpf_);
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
            if (!(obj instanceof BreakoutAction)) {
                return equals(obj);
            }
            BreakoutAction other = (BreakoutAction) obj;
            if (this.actionType_ != other.actionType_ || getClientGameTime() != other.getClientGameTime() || getServerGameTime() != other.getServerGameTime() || getMbfjjacbmck() != other.getMbfjjacbmck() || getGddolpoemjk() != other.getGddolpoemjk() || getJoandihiadc() != other.getJoandihiadc() || hasPos() != other.hasPos()) {
                return false;
            }
            if ((hasPos() && !getPos().equals(other.getPos())) || hasMjehpphliia() != other.hasMjehpphliia()) {
                return false;
            }
            if ((!hasMjehpphliia() || getMjehpphliia().equals(other.getMjehpphliia())) && getSpeed() == other.getSpeed() && getPeerId() == other.getPeerId() && getElementType() == other.getElementType() && getInhflokdoal() == other.getInhflokdoal() && getApiembahlab() == other.getApiembahlab() && getMhkdmdjeaan() == other.getMhkdmdjeaan() && hasCjegmomlbck() == other.hasCjegmomlbck()) {
                return (!hasCjegmomlbck() || getCjegmomlbck().equals(other.getCjegmomlbck())) && getIdngdpalicj() == other.getIdngdpalicj() && getOffset() == other.getOffset() && getLccmdkibdpf() == other.getLccmdkibdpf() && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + this.actionType_)) + 2)) + Internal.hashLong(getClientGameTime()))) + 3)) + Internal.hashLong(getServerGameTime()))) + 4)) + Internal.hashBoolean(getMbfjjacbmck()))) + 5)) + getGddolpoemjk())) + 6)) + getJoandihiadc();
            if (hasPos()) {
                hash = (53 * ((37 * hash) + 7)) + getPos().hashCode();
            }
            if (hasMjehpphliia()) {
                hash = (53 * ((37 * hash) + 8)) + getMjehpphliia().hashCode();
            }
            int hash2 = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * hash) + 9)) + getSpeed())) + 10)) + getPeerId())) + 11)) + getElementType())) + 12)) + getInhflokdoal())) + 13)) + getApiembahlab())) + 14)) + Internal.hashBoolean(getMhkdmdjeaan());
            if (hasCjegmomlbck()) {
                hash2 = (53 * ((37 * hash2) + 15)) + getCjegmomlbck().hashCode();
            }
            int hash3 = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * hash2) + 16)) + getIdngdpalicj())) + 17)) + getOffset())) + 18)) + Internal.hashLong(getLccmdkibdpf()))) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash3;
            return hash3;
        }

        public static BreakoutAction parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BreakoutAction parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BreakoutAction parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BreakoutAction parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BreakoutAction parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BreakoutAction parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BreakoutAction parseFrom(InputStream input) throws IOException {
            return (BreakoutAction) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static BreakoutAction parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BreakoutAction) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static BreakoutAction parseDelimitedFrom(InputStream input) throws IOException {
            return (BreakoutAction) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static BreakoutAction parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BreakoutAction) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static BreakoutAction parseFrom(CodedInputStream input) throws IOException {
            return (BreakoutAction) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static BreakoutAction parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BreakoutAction) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(BreakoutAction prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BreakoutActionOuterClass$BreakoutAction$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements BreakoutActionOrBuilder {
            private int actionType_ = 0;
            private long clientGameTime_;
            private long serverGameTime_;
            private boolean mbfjjacbmck_;
            private int gddolpoemjk_;
            private int joandihiadc_;
            private BreakoutVector2OuterClass.BreakoutVector2 pos_;
            private SingleFieldBuilderV3<BreakoutVector2OuterClass.BreakoutVector2, BreakoutVector2OuterClass.BreakoutVector2.Builder, BreakoutVector2OuterClass.BreakoutVector2OrBuilder> posBuilder_;
            private BreakoutVector2OuterClass.BreakoutVector2 mjehpphliia_;
            private SingleFieldBuilderV3<BreakoutVector2OuterClass.BreakoutVector2, BreakoutVector2OuterClass.BreakoutVector2.Builder, BreakoutVector2OuterClass.BreakoutVector2OrBuilder> mjehpphliiaBuilder_;
            private int speed_;
            private int peerId_;
            private int elementType_;
            private int inhflokdoal_;
            private int apiembahlab_;
            private boolean mhkdmdjeaan_;
            private BreakoutVector2OuterClass.BreakoutVector2 cjegmomlbck_;
            private SingleFieldBuilderV3<BreakoutVector2OuterClass.BreakoutVector2, BreakoutVector2OuterClass.BreakoutVector2.Builder, BreakoutVector2OuterClass.BreakoutVector2OrBuilder> cjegmomlbckBuilder_;
            private int idngdpalicj_;
            private int offset_;
            private long lccmdkibdpf_;

            public static final Descriptors.Descriptor getDescriptor() {
                return BreakoutActionOuterClass.internal_static_BreakoutAction_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return BreakoutActionOuterClass.internal_static_BreakoutAction_fieldAccessorTable.ensureFieldAccessorsInitialized(BreakoutAction.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (BreakoutAction.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.actionType_ = 0;
                this.clientGameTime_ = 0;
                this.serverGameTime_ = 0;
                this.mbfjjacbmck_ = false;
                this.gddolpoemjk_ = 0;
                this.joandihiadc_ = 0;
                if (this.posBuilder_ == null) {
                    this.pos_ = null;
                } else {
                    this.pos_ = null;
                    this.posBuilder_ = null;
                }
                if (this.mjehpphliiaBuilder_ == null) {
                    this.mjehpphliia_ = null;
                } else {
                    this.mjehpphliia_ = null;
                    this.mjehpphliiaBuilder_ = null;
                }
                this.speed_ = 0;
                this.peerId_ = 0;
                this.elementType_ = 0;
                this.inhflokdoal_ = 0;
                this.apiembahlab_ = 0;
                this.mhkdmdjeaan_ = false;
                if (this.cjegmomlbckBuilder_ == null) {
                    this.cjegmomlbck_ = null;
                } else {
                    this.cjegmomlbck_ = null;
                    this.cjegmomlbckBuilder_ = null;
                }
                this.idngdpalicj_ = 0;
                this.offset_ = 0;
                this.lccmdkibdpf_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return BreakoutActionOuterClass.internal_static_BreakoutAction_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public BreakoutAction getDefaultInstanceForType() {
                return BreakoutAction.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public BreakoutAction build() {
                BreakoutAction result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public BreakoutAction buildPartial() {
                BreakoutAction result = new BreakoutAction(this);
                result.actionType_ = this.actionType_;
                result.clientGameTime_ = this.clientGameTime_;
                result.serverGameTime_ = this.serverGameTime_;
                result.mbfjjacbmck_ = this.mbfjjacbmck_;
                result.gddolpoemjk_ = this.gddolpoemjk_;
                result.joandihiadc_ = this.joandihiadc_;
                if (this.posBuilder_ == null) {
                    result.pos_ = this.pos_;
                } else {
                    result.pos_ = this.posBuilder_.build();
                }
                if (this.mjehpphliiaBuilder_ == null) {
                    result.mjehpphliia_ = this.mjehpphliia_;
                } else {
                    result.mjehpphliia_ = this.mjehpphliiaBuilder_.build();
                }
                result.speed_ = this.speed_;
                result.peerId_ = this.peerId_;
                result.elementType_ = this.elementType_;
                result.inhflokdoal_ = this.inhflokdoal_;
                result.apiembahlab_ = this.apiembahlab_;
                result.mhkdmdjeaan_ = this.mhkdmdjeaan_;
                if (this.cjegmomlbckBuilder_ == null) {
                    result.cjegmomlbck_ = this.cjegmomlbck_;
                } else {
                    result.cjegmomlbck_ = this.cjegmomlbckBuilder_.build();
                }
                result.idngdpalicj_ = this.idngdpalicj_;
                result.offset_ = this.offset_;
                result.lccmdkibdpf_ = this.lccmdkibdpf_;
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
                if (other instanceof BreakoutAction) {
                    return mergeFrom((BreakoutAction) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(BreakoutAction other) {
                if (other == BreakoutAction.getDefaultInstance()) {
                    return this;
                }
                if (other.actionType_ != 0) {
                    setActionTypeValue(other.getActionTypeValue());
                }
                if (other.getClientGameTime() != 0) {
                    setClientGameTime(other.getClientGameTime());
                }
                if (other.getServerGameTime() != 0) {
                    setServerGameTime(other.getServerGameTime());
                }
                if (other.getMbfjjacbmck()) {
                    setMbfjjacbmck(other.getMbfjjacbmck());
                }
                if (other.getGddolpoemjk() != 0) {
                    setGddolpoemjk(other.getGddolpoemjk());
                }
                if (other.getJoandihiadc() != 0) {
                    setJoandihiadc(other.getJoandihiadc());
                }
                if (other.hasPos()) {
                    mergePos(other.getPos());
                }
                if (other.hasMjehpphliia()) {
                    mergeMjehpphliia(other.getMjehpphliia());
                }
                if (other.getSpeed() != 0) {
                    setSpeed(other.getSpeed());
                }
                if (other.getPeerId() != 0) {
                    setPeerId(other.getPeerId());
                }
                if (other.getElementType() != 0) {
                    setElementType(other.getElementType());
                }
                if (other.getInhflokdoal() != 0) {
                    setInhflokdoal(other.getInhflokdoal());
                }
                if (other.getApiembahlab() != 0) {
                    setApiembahlab(other.getApiembahlab());
                }
                if (other.getMhkdmdjeaan()) {
                    setMhkdmdjeaan(other.getMhkdmdjeaan());
                }
                if (other.hasCjegmomlbck()) {
                    mergeCjegmomlbck(other.getCjegmomlbck());
                }
                if (other.getIdngdpalicj() != 0) {
                    setIdngdpalicj(other.getIdngdpalicj());
                }
                if (other.getOffset() != 0) {
                    setOffset(other.getOffset());
                }
                if (other.getLccmdkibdpf() != 0) {
                    setLccmdkibdpf(other.getLccmdkibdpf());
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
                BreakoutAction parsedMessage = null;
                try {
                    try {
                        parsedMessage = BreakoutAction.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (BreakoutAction) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.BreakoutActionOuterClass.BreakoutActionOrBuilder
            public int getActionTypeValue() {
                return this.actionType_;
            }

            public Builder setActionTypeValue(int value) {
                this.actionType_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BreakoutActionOuterClass.BreakoutActionOrBuilder
            public BreakoutActionTypeOuterClass.BreakoutActionType getActionType() {
                BreakoutActionTypeOuterClass.BreakoutActionType result = BreakoutActionTypeOuterClass.BreakoutActionType.valueOf(this.actionType_);
                return result == null ? BreakoutActionTypeOuterClass.BreakoutActionType.UNRECOGNIZED : result;
            }

            public Builder setActionType(BreakoutActionTypeOuterClass.BreakoutActionType value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.actionType_ = value.getNumber();
                onChanged();
                return this;
            }

            public Builder clearActionType() {
                this.actionType_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BreakoutActionOuterClass.BreakoutActionOrBuilder
            public long getClientGameTime() {
                return this.clientGameTime_;
            }

            public Builder setClientGameTime(long value) {
                this.clientGameTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearClientGameTime() {
                this.clientGameTime_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BreakoutActionOuterClass.BreakoutActionOrBuilder
            public long getServerGameTime() {
                return this.serverGameTime_;
            }

            public Builder setServerGameTime(long value) {
                this.serverGameTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearServerGameTime() {
                this.serverGameTime_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BreakoutActionOuterClass.BreakoutActionOrBuilder
            public boolean getMbfjjacbmck() {
                return this.mbfjjacbmck_;
            }

            public Builder setMbfjjacbmck(boolean value) {
                this.mbfjjacbmck_ = value;
                onChanged();
                return this;
            }

            public Builder clearMbfjjacbmck() {
                this.mbfjjacbmck_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BreakoutActionOuterClass.BreakoutActionOrBuilder
            public int getGddolpoemjk() {
                return this.gddolpoemjk_;
            }

            public Builder setGddolpoemjk(int value) {
                this.gddolpoemjk_ = value;
                onChanged();
                return this;
            }

            public Builder clearGddolpoemjk() {
                this.gddolpoemjk_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BreakoutActionOuterClass.BreakoutActionOrBuilder
            public int getJoandihiadc() {
                return this.joandihiadc_;
            }

            public Builder setJoandihiadc(int value) {
                this.joandihiadc_ = value;
                onChanged();
                return this;
            }

            public Builder clearJoandihiadc() {
                this.joandihiadc_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BreakoutActionOuterClass.BreakoutActionOrBuilder
            public boolean hasPos() {
                return (this.posBuilder_ == null && this.pos_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.BreakoutActionOuterClass.BreakoutActionOrBuilder
            public BreakoutVector2OuterClass.BreakoutVector2 getPos() {
                if (this.posBuilder_ == null) {
                    return this.pos_ == null ? BreakoutVector2OuterClass.BreakoutVector2.getDefaultInstance() : this.pos_;
                }
                return this.posBuilder_.getMessage();
            }

            public Builder setPos(BreakoutVector2OuterClass.BreakoutVector2 value) {
                if (this.posBuilder_ != null) {
                    this.posBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.pos_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setPos(BreakoutVector2OuterClass.BreakoutVector2.Builder builderForValue) {
                if (this.posBuilder_ == null) {
                    this.pos_ = builderForValue.build();
                    onChanged();
                } else {
                    this.posBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergePos(BreakoutVector2OuterClass.BreakoutVector2 value) {
                if (this.posBuilder_ == null) {
                    if (this.pos_ != null) {
                        this.pos_ = BreakoutVector2OuterClass.BreakoutVector2.newBuilder(this.pos_).mergeFrom(value).buildPartial();
                    } else {
                        this.pos_ = value;
                    }
                    onChanged();
                } else {
                    this.posBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearPos() {
                if (this.posBuilder_ == null) {
                    this.pos_ = null;
                    onChanged();
                } else {
                    this.pos_ = null;
                    this.posBuilder_ = null;
                }
                return this;
            }

            public BreakoutVector2OuterClass.BreakoutVector2.Builder getPosBuilder() {
                onChanged();
                return getPosFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.BreakoutActionOuterClass.BreakoutActionOrBuilder
            public BreakoutVector2OuterClass.BreakoutVector2OrBuilder getPosOrBuilder() {
                if (this.posBuilder_ != null) {
                    return this.posBuilder_.getMessageOrBuilder();
                }
                return this.pos_ == null ? BreakoutVector2OuterClass.BreakoutVector2.getDefaultInstance() : this.pos_;
            }

            private SingleFieldBuilderV3<BreakoutVector2OuterClass.BreakoutVector2, BreakoutVector2OuterClass.BreakoutVector2.Builder, BreakoutVector2OuterClass.BreakoutVector2OrBuilder> getPosFieldBuilder() {
                if (this.posBuilder_ == null) {
                    this.posBuilder_ = new SingleFieldBuilderV3<>(getPos(), getParentForChildren(), isClean());
                    this.pos_ = null;
                }
                return this.posBuilder_;
            }

            @Override // emu.grasscutter.net.proto.BreakoutActionOuterClass.BreakoutActionOrBuilder
            public boolean hasMjehpphliia() {
                return (this.mjehpphliiaBuilder_ == null && this.mjehpphliia_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.BreakoutActionOuterClass.BreakoutActionOrBuilder
            public BreakoutVector2OuterClass.BreakoutVector2 getMjehpphliia() {
                if (this.mjehpphliiaBuilder_ == null) {
                    return this.mjehpphliia_ == null ? BreakoutVector2OuterClass.BreakoutVector2.getDefaultInstance() : this.mjehpphliia_;
                }
                return this.mjehpphliiaBuilder_.getMessage();
            }

            public Builder setMjehpphliia(BreakoutVector2OuterClass.BreakoutVector2 value) {
                if (this.mjehpphliiaBuilder_ != null) {
                    this.mjehpphliiaBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.mjehpphliia_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setMjehpphliia(BreakoutVector2OuterClass.BreakoutVector2.Builder builderForValue) {
                if (this.mjehpphliiaBuilder_ == null) {
                    this.mjehpphliia_ = builderForValue.build();
                    onChanged();
                } else {
                    this.mjehpphliiaBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeMjehpphliia(BreakoutVector2OuterClass.BreakoutVector2 value) {
                if (this.mjehpphliiaBuilder_ == null) {
                    if (this.mjehpphliia_ != null) {
                        this.mjehpphliia_ = BreakoutVector2OuterClass.BreakoutVector2.newBuilder(this.mjehpphliia_).mergeFrom(value).buildPartial();
                    } else {
                        this.mjehpphliia_ = value;
                    }
                    onChanged();
                } else {
                    this.mjehpphliiaBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearMjehpphliia() {
                if (this.mjehpphliiaBuilder_ == null) {
                    this.mjehpphliia_ = null;
                    onChanged();
                } else {
                    this.mjehpphliia_ = null;
                    this.mjehpphliiaBuilder_ = null;
                }
                return this;
            }

            public BreakoutVector2OuterClass.BreakoutVector2.Builder getMjehpphliiaBuilder() {
                onChanged();
                return getMjehpphliiaFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.BreakoutActionOuterClass.BreakoutActionOrBuilder
            public BreakoutVector2OuterClass.BreakoutVector2OrBuilder getMjehpphliiaOrBuilder() {
                if (this.mjehpphliiaBuilder_ != null) {
                    return this.mjehpphliiaBuilder_.getMessageOrBuilder();
                }
                return this.mjehpphliia_ == null ? BreakoutVector2OuterClass.BreakoutVector2.getDefaultInstance() : this.mjehpphliia_;
            }

            private SingleFieldBuilderV3<BreakoutVector2OuterClass.BreakoutVector2, BreakoutVector2OuterClass.BreakoutVector2.Builder, BreakoutVector2OuterClass.BreakoutVector2OrBuilder> getMjehpphliiaFieldBuilder() {
                if (this.mjehpphliiaBuilder_ == null) {
                    this.mjehpphliiaBuilder_ = new SingleFieldBuilderV3<>(getMjehpphliia(), getParentForChildren(), isClean());
                    this.mjehpphliia_ = null;
                }
                return this.mjehpphliiaBuilder_;
            }

            @Override // emu.grasscutter.net.proto.BreakoutActionOuterClass.BreakoutActionOrBuilder
            public int getSpeed() {
                return this.speed_;
            }

            public Builder setSpeed(int value) {
                this.speed_ = value;
                onChanged();
                return this;
            }

            public Builder clearSpeed() {
                this.speed_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BreakoutActionOuterClass.BreakoutActionOrBuilder
            public int getPeerId() {
                return this.peerId_;
            }

            public Builder setPeerId(int value) {
                this.peerId_ = value;
                onChanged();
                return this;
            }

            public Builder clearPeerId() {
                this.peerId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BreakoutActionOuterClass.BreakoutActionOrBuilder
            public int getElementType() {
                return this.elementType_;
            }

            public Builder setElementType(int value) {
                this.elementType_ = value;
                onChanged();
                return this;
            }

            public Builder clearElementType() {
                this.elementType_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BreakoutActionOuterClass.BreakoutActionOrBuilder
            public int getInhflokdoal() {
                return this.inhflokdoal_;
            }

            public Builder setInhflokdoal(int value) {
                this.inhflokdoal_ = value;
                onChanged();
                return this;
            }

            public Builder clearInhflokdoal() {
                this.inhflokdoal_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BreakoutActionOuterClass.BreakoutActionOrBuilder
            public int getApiembahlab() {
                return this.apiembahlab_;
            }

            public Builder setApiembahlab(int value) {
                this.apiembahlab_ = value;
                onChanged();
                return this;
            }

            public Builder clearApiembahlab() {
                this.apiembahlab_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BreakoutActionOuterClass.BreakoutActionOrBuilder
            public boolean getMhkdmdjeaan() {
                return this.mhkdmdjeaan_;
            }

            public Builder setMhkdmdjeaan(boolean value) {
                this.mhkdmdjeaan_ = value;
                onChanged();
                return this;
            }

            public Builder clearMhkdmdjeaan() {
                this.mhkdmdjeaan_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BreakoutActionOuterClass.BreakoutActionOrBuilder
            public boolean hasCjegmomlbck() {
                return (this.cjegmomlbckBuilder_ == null && this.cjegmomlbck_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.BreakoutActionOuterClass.BreakoutActionOrBuilder
            public BreakoutVector2OuterClass.BreakoutVector2 getCjegmomlbck() {
                if (this.cjegmomlbckBuilder_ == null) {
                    return this.cjegmomlbck_ == null ? BreakoutVector2OuterClass.BreakoutVector2.getDefaultInstance() : this.cjegmomlbck_;
                }
                return this.cjegmomlbckBuilder_.getMessage();
            }

            public Builder setCjegmomlbck(BreakoutVector2OuterClass.BreakoutVector2 value) {
                if (this.cjegmomlbckBuilder_ != null) {
                    this.cjegmomlbckBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.cjegmomlbck_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setCjegmomlbck(BreakoutVector2OuterClass.BreakoutVector2.Builder builderForValue) {
                if (this.cjegmomlbckBuilder_ == null) {
                    this.cjegmomlbck_ = builderForValue.build();
                    onChanged();
                } else {
                    this.cjegmomlbckBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeCjegmomlbck(BreakoutVector2OuterClass.BreakoutVector2 value) {
                if (this.cjegmomlbckBuilder_ == null) {
                    if (this.cjegmomlbck_ != null) {
                        this.cjegmomlbck_ = BreakoutVector2OuterClass.BreakoutVector2.newBuilder(this.cjegmomlbck_).mergeFrom(value).buildPartial();
                    } else {
                        this.cjegmomlbck_ = value;
                    }
                    onChanged();
                } else {
                    this.cjegmomlbckBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearCjegmomlbck() {
                if (this.cjegmomlbckBuilder_ == null) {
                    this.cjegmomlbck_ = null;
                    onChanged();
                } else {
                    this.cjegmomlbck_ = null;
                    this.cjegmomlbckBuilder_ = null;
                }
                return this;
            }

            public BreakoutVector2OuterClass.BreakoutVector2.Builder getCjegmomlbckBuilder() {
                onChanged();
                return getCjegmomlbckFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.BreakoutActionOuterClass.BreakoutActionOrBuilder
            public BreakoutVector2OuterClass.BreakoutVector2OrBuilder getCjegmomlbckOrBuilder() {
                if (this.cjegmomlbckBuilder_ != null) {
                    return this.cjegmomlbckBuilder_.getMessageOrBuilder();
                }
                return this.cjegmomlbck_ == null ? BreakoutVector2OuterClass.BreakoutVector2.getDefaultInstance() : this.cjegmomlbck_;
            }

            private SingleFieldBuilderV3<BreakoutVector2OuterClass.BreakoutVector2, BreakoutVector2OuterClass.BreakoutVector2.Builder, BreakoutVector2OuterClass.BreakoutVector2OrBuilder> getCjegmomlbckFieldBuilder() {
                if (this.cjegmomlbckBuilder_ == null) {
                    this.cjegmomlbckBuilder_ = new SingleFieldBuilderV3<>(getCjegmomlbck(), getParentForChildren(), isClean());
                    this.cjegmomlbck_ = null;
                }
                return this.cjegmomlbckBuilder_;
            }

            @Override // emu.grasscutter.net.proto.BreakoutActionOuterClass.BreakoutActionOrBuilder
            public int getIdngdpalicj() {
                return this.idngdpalicj_;
            }

            public Builder setIdngdpalicj(int value) {
                this.idngdpalicj_ = value;
                onChanged();
                return this;
            }

            public Builder clearIdngdpalicj() {
                this.idngdpalicj_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BreakoutActionOuterClass.BreakoutActionOrBuilder
            public int getOffset() {
                return this.offset_;
            }

            public Builder setOffset(int value) {
                this.offset_ = value;
                onChanged();
                return this;
            }

            public Builder clearOffset() {
                this.offset_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BreakoutActionOuterClass.BreakoutActionOrBuilder
            public long getLccmdkibdpf() {
                return this.lccmdkibdpf_;
            }

            public Builder setLccmdkibdpf(long value) {
                this.lccmdkibdpf_ = value;
                onChanged();
                return this;
            }

            public Builder clearLccmdkibdpf() {
                this.lccmdkibdpf_ = 0;
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

        public static BreakoutAction getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<BreakoutAction> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<BreakoutAction> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public BreakoutAction getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        BreakoutActionTypeOuterClass.getDescriptor();
        BreakoutVector2OuterClass.getDescriptor();
    }
}
