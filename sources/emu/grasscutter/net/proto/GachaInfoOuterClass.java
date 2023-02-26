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
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.GachaUpInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GachaInfoOuterClass.class */
public final class GachaInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u000fGachaInfo.proto\u001a\u0011GachaUpInfo.proto\"\u0005\n\tGachaInfo\u0012\u0017\n\u000fgachaPrefabPath\u0018\t \u0001(\t\u0012\u0012\n\nscheduleId\u0018\u0002 \u0001(\r\u0012\u001b\n\u0012displayUp5ItemList\u0018»\u000e \u0003(\r\u0012\u0013\n\u000bgachaSortId\u0018\u0006 \u0001(\r\u0012\u001b\n\u0012displayUp4ItemList\u0018\u0002 \u0003(\r\u0012\u0012\n\tisNewWish\u0018å\u0006 \u0001(\b\u0012\u0017\n\u000fgachaTimesLimit\u0018\u000b \u0001(\r\u0012\u0013\n\u000bcostItemNum\u0018\u000e \u0001(\r\u0012\u0016\n\u000egachaRecordUrl\u0018\u0007 \u0001(\t\u0012\u0015\n\ftitleTextmap\u0018Ì\t \u0001(\t\u0012&\n\u000fgachaUpInfoList\u0018¬\u000e \u0003(\u000b2\f.GachaUpInfo\u0012\u001e\n\u0016gachaPreviewPrefabPath\u0018\b \u0001(\t\u0012\"\n\u001acurScheduleDailyGachaTimes\u00180 \u0001(\r\u0012\u0011\n\tgachaType\u0018\u0001 \u0001(\r\u0012\u0015\n\rtenCostItemId\u0018\u0004 \u0001(\r\u0012\u0016\n\u000eleftGachaTimes\u0018\f \u0001(\r\u0012\u0014\n\fgachaProbUrl\u0018\u0005 \u0001(\t\u0012\u001c\n\u0013gachaProbUrlOversea\u0018ý\u0005 \u0001(\t\u0012\u0013\n\nwishItemId\u0018µ\u0002 \u0001(\r\u0012\u0016\n\u000etenCostItemNum\u0018\n \u0001(\r\u0012\u0018\n\u000fwishMaxProgress\u0018\r \u0001(\r\u0012\u0012\n\ncostItemId\u0018\r \u0001(\r\u0012\u0011\n\tbeginTime\u0018\u000f \u0001(\r\u0012\u001e\n\u0015gachaRecordUrlOversea\u0018ì\u0007 \u0001(\t\u0012\u0015\n\fwishProgress\u0018ö\u0001 \u0001(\r\u0012\u000f\n\u0007endTime\u0018\u0003 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{GachaUpInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_GachaInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_GachaInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_GachaInfo_descriptor, new String[]{"GachaPrefabPath", "ScheduleId", "DisplayUp5ItemList", "GachaSortId", "DisplayUp4ItemList", "IsNewWish", "GachaTimesLimit", "CostItemNum", "GachaRecordUrl", "TitleTextmap", "GachaUpInfoList", "GachaPreviewPrefabPath", "CurScheduleDailyGachaTimes", "GachaType", "TenCostItemId", "LeftGachaTimes", "GachaProbUrl", "GachaProbUrlOversea", "WishItemId", "TenCostItemNum", "WishMaxProgress", "CostItemId", "BeginTime", "GachaRecordUrlOversea", "WishProgress", "EndTime"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GachaInfoOuterClass$GachaInfoOrBuilder.class */
    public interface GachaInfoOrBuilder extends MessageOrBuilder {
        String getGachaPrefabPath();

        ByteString getGachaPrefabPathBytes();

        int getScheduleId();

        List<Integer> getDisplayUp5ItemListList();

        int getDisplayUp5ItemListCount();

        int getDisplayUp5ItemList(int i);

        int getGachaSortId();

        List<Integer> getDisplayUp4ItemListList();

        int getDisplayUp4ItemListCount();

        int getDisplayUp4ItemList(int i);

        boolean getIsNewWish();

        int getGachaTimesLimit();

        int getCostItemNum();

        String getGachaRecordUrl();

        ByteString getGachaRecordUrlBytes();

        String getTitleTextmap();

        ByteString getTitleTextmapBytes();

        List<GachaUpInfoOuterClass.GachaUpInfo> getGachaUpInfoListList();

        GachaUpInfoOuterClass.GachaUpInfo getGachaUpInfoList(int i);

        int getGachaUpInfoListCount();

        List<? extends GachaUpInfoOuterClass.GachaUpInfoOrBuilder> getGachaUpInfoListOrBuilderList();

        GachaUpInfoOuterClass.GachaUpInfoOrBuilder getGachaUpInfoListOrBuilder(int i);

        String getGachaPreviewPrefabPath();

        ByteString getGachaPreviewPrefabPathBytes();

        int getCurScheduleDailyGachaTimes();

        int getGachaType();

        int getTenCostItemId();

        int getLeftGachaTimes();

        String getGachaProbUrl();

        ByteString getGachaProbUrlBytes();

        String getGachaProbUrlOversea();

        ByteString getGachaProbUrlOverseaBytes();

        int getWishItemId();

        int getTenCostItemNum();

        int getWishMaxProgress();

        int getCostItemId();

        int getBeginTime();

        String getGachaRecordUrlOversea();

        ByteString getGachaRecordUrlOverseaBytes();

        int getWishProgress();

        int getEndTime();
    }

    private GachaInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GachaInfoOuterClass$GachaInfo.class */
    public static final class GachaInfo extends GeneratedMessageV3 implements GachaInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int GACHAPREFABPATH_FIELD_NUMBER = 9;
        private volatile Object gachaPrefabPath_;
        public static final int SCHEDULEID_FIELD_NUMBER = 2;
        private int scheduleId_;
        public static final int DISPLAYUP5ITEMLIST_FIELD_NUMBER = 1851;
        private Internal.IntList displayUp5ItemList_;
        private int displayUp5ItemListMemoizedSerializedSize;
        public static final int GACHASORTID_FIELD_NUMBER = 6;
        private int gachaSortId_;
        public static final int DISPLAYUP4ITEMLIST_FIELD_NUMBER = 279;
        private Internal.IntList displayUp4ItemList_;
        private int displayUp4ItemListMemoizedSerializedSize;
        public static final int ISNEWWISH_FIELD_NUMBER = 869;
        private boolean isNewWish_;
        public static final int GACHATIMESLIMIT_FIELD_NUMBER = 11;
        private int gachaTimesLimit_;
        public static final int COSTITEMNUM_FIELD_NUMBER = 14;
        private int costItemNum_;
        public static final int GACHARECORDURL_FIELD_NUMBER = 7;
        private volatile Object gachaRecordUrl_;
        public static final int TITLETEXTMAP_FIELD_NUMBER = 1228;
        private volatile Object titleTextmap_;
        public static final int GACHAUPINFOLIST_FIELD_NUMBER = 1836;
        private List<GachaUpInfoOuterClass.GachaUpInfo> gachaUpInfoList_;
        public static final int GACHAPREVIEWPREFABPATH_FIELD_NUMBER = 8;
        private volatile Object gachaPreviewPrefabPath_;
        public static final int CURSCHEDULEDAILYGACHATIMES_FIELD_NUMBER = 48;
        private int curScheduleDailyGachaTimes_;
        public static final int GACHATYPE_FIELD_NUMBER = 1;
        private int gachaType_;
        public static final int TENCOSTITEMID_FIELD_NUMBER = 4;
        private int tenCostItemId_;
        public static final int LEFTGACHATIMES_FIELD_NUMBER = 12;
        private int leftGachaTimes_;
        public static final int GACHAPROBURL_FIELD_NUMBER = 5;
        private volatile Object gachaProbUrl_;
        public static final int GACHAPROBURLOVERSEA_FIELD_NUMBER = 765;
        private volatile Object gachaProbUrlOversea_;
        public static final int WISHITEMID_FIELD_NUMBER = 309;
        private int wishItemId_;
        public static final int TENCOSTITEMNUM_FIELD_NUMBER = 10;
        private int tenCostItemNum_;
        public static final int WISHMAXPROGRESS_FIELD_NUMBER = 1669;
        private int wishMaxProgress_;
        public static final int COSTITEMID_FIELD_NUMBER = 13;
        private int costItemId_;
        public static final int BEGINTIME_FIELD_NUMBER = 15;
        private int beginTime_;
        public static final int GACHARECORDURLOVERSEA_FIELD_NUMBER = 1004;
        private volatile Object gachaRecordUrlOversea_;
        public static final int WISHPROGRESS_FIELD_NUMBER = 246;
        private int wishProgress_;
        public static final int ENDTIME_FIELD_NUMBER = 3;
        private int endTime_;
        private byte memoizedIsInitialized;
        private static final GachaInfo DEFAULT_INSTANCE = new GachaInfo();
        private static final Parser<GachaInfo> PARSER = new AbstractParser<GachaInfo>() { // from class: emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfo.1
            @Override // com.google.protobuf.Parser
            public GachaInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new GachaInfo(input, extensionRegistry);
            }
        };

        private GachaInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.displayUp5ItemListMemoizedSerializedSize = -1;
            this.displayUp4ItemListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private GachaInfo() {
            this.displayUp5ItemListMemoizedSerializedSize = -1;
            this.displayUp4ItemListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.gachaPrefabPath_ = "";
            this.displayUp5ItemList_ = emptyIntList();
            this.displayUp4ItemList_ = emptyIntList();
            this.gachaRecordUrl_ = "";
            this.titleTextmap_ = "";
            this.gachaUpInfoList_ = Collections.emptyList();
            this.gachaPreviewPrefabPath_ = "";
            this.gachaProbUrl_ = "";
            this.gachaProbUrlOversea_ = "";
            this.gachaRecordUrlOversea_ = "";
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new GachaInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:135:0x0342 */
        private GachaInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 8:
                                this.gachaType_ = input.readUInt32();
                                break;
                            case 16:
                                this.scheduleId_ = input.readUInt32();
                                break;
                            case 24:
                                this.endTime_ = input.readUInt32();
                                break;
                            case 32:
                                this.tenCostItemId_ = input.readUInt32();
                                break;
                            case 42:
                                this.gachaProbUrl_ = input.readStringRequireUtf8();
                                break;
                            case 48:
                                this.gachaSortId_ = input.readUInt32();
                                break;
                            case 58:
                                this.gachaRecordUrl_ = input.readStringRequireUtf8();
                                break;
                            case 66:
                                this.gachaPreviewPrefabPath_ = input.readStringRequireUtf8();
                                break;
                            case 74:
                                this.gachaPrefabPath_ = input.readStringRequireUtf8();
                                break;
                            case 80:
                                this.tenCostItemNum_ = input.readUInt32();
                                break;
                            case 88:
                                this.gachaTimesLimit_ = input.readUInt32();
                                break;
                            case 96:
                                this.leftGachaTimes_ = input.readUInt32();
                                break;
                            case 104:
                                this.costItemId_ = input.readUInt32();
                                break;
                            case 112:
                                this.costItemNum_ = input.readUInt32();
                                break;
                            case 120:
                                this.beginTime_ = input.readUInt32();
                                break;
                            case 384:
                                this.curScheduleDailyGachaTimes_ = input.readUInt32();
                                break;
                            case 1968:
                                this.wishProgress_ = input.readUInt32();
                                break;
                            case 2232:
                                if ((mutable_bitField0_ & 2) == 0) {
                                    this.displayUp4ItemList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                this.displayUp4ItemList_.addInt(input.readUInt32());
                                break;
                            case 2234:
                                int limit = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 2) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.displayUp4ItemList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.displayUp4ItemList_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit);
                                break;
                            case 2472:
                                this.wishItemId_ = input.readUInt32();
                                break;
                            case 6122:
                                this.gachaProbUrlOversea_ = input.readStringRequireUtf8();
                                break;
                            case 6952:
                                this.isNewWish_ = input.readBool();
                                break;
                            case 8034:
                                this.gachaRecordUrlOversea_ = input.readStringRequireUtf8();
                                break;
                            case 9826:
                                this.titleTextmap_ = input.readStringRequireUtf8();
                                break;
                            case 13352:
                                this.wishMaxProgress_ = input.readUInt32();
                                break;
                            case 14690:
                                if ((mutable_bitField0_ & 4) == 0) {
                                    this.gachaUpInfoList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 4) == 1 ? 1 : 0;
                                }
                                this.gachaUpInfoList_.add((GachaUpInfoOuterClass.GachaUpInfo) input.readMessage(GachaUpInfoOuterClass.GachaUpInfo.parser(), extensionRegistry));
                                break;
                            case 14808:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.displayUp5ItemList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                this.displayUp5ItemList_.addInt(input.readUInt32());
                                break;
                            case 14810:
                                int limit2 = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.displayUp5ItemList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.displayUp5ItemList_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit2);
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
                    this.displayUp4ItemList_.makeImmutable();
                }
                if ((mutable_bitField0_ & 4) != 0) {
                    this.gachaUpInfoList_ = Collections.unmodifiableList(this.gachaUpInfoList_);
                }
                if ((mutable_bitField0_ & 1) != 0) {
                    this.displayUp5ItemList_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return GachaInfoOuterClass.internal_static_GachaInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return GachaInfoOuterClass.internal_static_GachaInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(GachaInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
        public String getGachaPrefabPath() {
            Object ref = this.gachaPrefabPath_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.gachaPrefabPath_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
        public ByteString getGachaPrefabPathBytes() {
            Object ref = this.gachaPrefabPath_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.gachaPrefabPath_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
        public int getScheduleId() {
            return this.scheduleId_;
        }

        @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
        public List<Integer> getDisplayUp5ItemListList() {
            return this.displayUp5ItemList_;
        }

        @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
        public int getDisplayUp5ItemListCount() {
            return this.displayUp5ItemList_.size();
        }

        @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
        public int getDisplayUp5ItemList(int index) {
            return this.displayUp5ItemList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
        public int getGachaSortId() {
            return this.gachaSortId_;
        }

        @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
        public List<Integer> getDisplayUp4ItemListList() {
            return this.displayUp4ItemList_;
        }

        @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
        public int getDisplayUp4ItemListCount() {
            return this.displayUp4ItemList_.size();
        }

        @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
        public int getDisplayUp4ItemList(int index) {
            return this.displayUp4ItemList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
        public boolean getIsNewWish() {
            return this.isNewWish_;
        }

        @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
        public int getGachaTimesLimit() {
            return this.gachaTimesLimit_;
        }

        @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
        public int getCostItemNum() {
            return this.costItemNum_;
        }

        @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
        public String getGachaRecordUrl() {
            Object ref = this.gachaRecordUrl_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.gachaRecordUrl_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
        public ByteString getGachaRecordUrlBytes() {
            Object ref = this.gachaRecordUrl_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.gachaRecordUrl_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
        public String getTitleTextmap() {
            Object ref = this.titleTextmap_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.titleTextmap_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
        public ByteString getTitleTextmapBytes() {
            Object ref = this.titleTextmap_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.titleTextmap_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
        public List<GachaUpInfoOuterClass.GachaUpInfo> getGachaUpInfoListList() {
            return this.gachaUpInfoList_;
        }

        @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
        public List<? extends GachaUpInfoOuterClass.GachaUpInfoOrBuilder> getGachaUpInfoListOrBuilderList() {
            return this.gachaUpInfoList_;
        }

        @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
        public int getGachaUpInfoListCount() {
            return this.gachaUpInfoList_.size();
        }

        @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
        public GachaUpInfoOuterClass.GachaUpInfo getGachaUpInfoList(int index) {
            return this.gachaUpInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
        public GachaUpInfoOuterClass.GachaUpInfoOrBuilder getGachaUpInfoListOrBuilder(int index) {
            return this.gachaUpInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
        public String getGachaPreviewPrefabPath() {
            Object ref = this.gachaPreviewPrefabPath_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.gachaPreviewPrefabPath_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
        public ByteString getGachaPreviewPrefabPathBytes() {
            Object ref = this.gachaPreviewPrefabPath_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.gachaPreviewPrefabPath_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
        public int getCurScheduleDailyGachaTimes() {
            return this.curScheduleDailyGachaTimes_;
        }

        @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
        public int getGachaType() {
            return this.gachaType_;
        }

        @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
        public int getTenCostItemId() {
            return this.tenCostItemId_;
        }

        @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
        public int getLeftGachaTimes() {
            return this.leftGachaTimes_;
        }

        @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
        public String getGachaProbUrl() {
            Object ref = this.gachaProbUrl_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.gachaProbUrl_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
        public ByteString getGachaProbUrlBytes() {
            Object ref = this.gachaProbUrl_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.gachaProbUrl_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
        public String getGachaProbUrlOversea() {
            Object ref = this.gachaProbUrlOversea_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.gachaProbUrlOversea_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
        public ByteString getGachaProbUrlOverseaBytes() {
            Object ref = this.gachaProbUrlOversea_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.gachaProbUrlOversea_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
        public int getWishItemId() {
            return this.wishItemId_;
        }

        @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
        public int getTenCostItemNum() {
            return this.tenCostItemNum_;
        }

        @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
        public int getWishMaxProgress() {
            return this.wishMaxProgress_;
        }

        @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
        public int getCostItemId() {
            return this.costItemId_;
        }

        @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
        public int getBeginTime() {
            return this.beginTime_;
        }

        @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
        public String getGachaRecordUrlOversea() {
            Object ref = this.gachaRecordUrlOversea_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.gachaRecordUrlOversea_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
        public ByteString getGachaRecordUrlOverseaBytes() {
            Object ref = this.gachaRecordUrlOversea_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.gachaRecordUrlOversea_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
        public int getWishProgress() {
            return this.wishProgress_;
        }

        @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
        public int getEndTime() {
            return this.endTime_;
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
            if (this.gachaType_ != 0) {
                output.writeUInt32(1, this.gachaType_);
            }
            if (this.scheduleId_ != 0) {
                output.writeUInt32(2, this.scheduleId_);
            }
            if (this.endTime_ != 0) {
                output.writeUInt32(3, this.endTime_);
            }
            if (this.tenCostItemId_ != 0) {
                output.writeUInt32(4, this.tenCostItemId_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.gachaProbUrl_)) {
                GeneratedMessageV3.writeString(output, 5, this.gachaProbUrl_);
            }
            if (this.gachaSortId_ != 0) {
                output.writeUInt32(6, this.gachaSortId_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.gachaRecordUrl_)) {
                GeneratedMessageV3.writeString(output, 7, this.gachaRecordUrl_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.gachaPreviewPrefabPath_)) {
                GeneratedMessageV3.writeString(output, 8, this.gachaPreviewPrefabPath_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.gachaPrefabPath_)) {
                GeneratedMessageV3.writeString(output, 9, this.gachaPrefabPath_);
            }
            if (this.tenCostItemNum_ != 0) {
                output.writeUInt32(10, this.tenCostItemNum_);
            }
            if (this.gachaTimesLimit_ != 0) {
                output.writeUInt32(11, this.gachaTimesLimit_);
            }
            if (this.leftGachaTimes_ != 0) {
                output.writeUInt32(12, this.leftGachaTimes_);
            }
            if (this.costItemId_ != 0) {
                output.writeUInt32(13, this.costItemId_);
            }
            if (this.costItemNum_ != 0) {
                output.writeUInt32(14, this.costItemNum_);
            }
            if (this.beginTime_ != 0) {
                output.writeUInt32(15, this.beginTime_);
            }
            if (this.curScheduleDailyGachaTimes_ != 0) {
                output.writeUInt32(48, this.curScheduleDailyGachaTimes_);
            }
            if (this.wishProgress_ != 0) {
                output.writeUInt32(246, this.wishProgress_);
            }
            if (getDisplayUp4ItemListList().size() > 0) {
                output.writeUInt32NoTag(2234);
                output.writeUInt32NoTag(this.displayUp4ItemListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.displayUp4ItemList_.size(); i++) {
                output.writeUInt32NoTag(this.displayUp4ItemList_.getInt(i));
            }
            if (this.wishItemId_ != 0) {
                output.writeUInt32(309, this.wishItemId_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.gachaProbUrlOversea_)) {
                GeneratedMessageV3.writeString(output, GACHAPROBURLOVERSEA_FIELD_NUMBER, this.gachaProbUrlOversea_);
            }
            if (this.isNewWish_) {
                output.writeBool(869, this.isNewWish_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.gachaRecordUrlOversea_)) {
                GeneratedMessageV3.writeString(output, 1004, this.gachaRecordUrlOversea_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.titleTextmap_)) {
                GeneratedMessageV3.writeString(output, 1228, this.titleTextmap_);
            }
            if (this.wishMaxProgress_ != 0) {
                output.writeUInt32(1669, this.wishMaxProgress_);
            }
            for (int i2 = 0; i2 < this.gachaUpInfoList_.size(); i2++) {
                output.writeMessage(GACHAUPINFOLIST_FIELD_NUMBER, this.gachaUpInfoList_.get(i2));
            }
            if (getDisplayUp5ItemListList().size() > 0) {
                output.writeUInt32NoTag(14810);
                output.writeUInt32NoTag(this.displayUp5ItemListMemoizedSerializedSize);
            }
            for (int i3 = 0; i3 < this.displayUp5ItemList_.size(); i3++) {
                output.writeUInt32NoTag(this.displayUp5ItemList_.getInt(i3));
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
            if (this.gachaType_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.gachaType_);
            }
            if (this.scheduleId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(2, this.scheduleId_);
            }
            if (this.endTime_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(3, this.endTime_);
            }
            if (this.tenCostItemId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(4, this.tenCostItemId_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.gachaProbUrl_)) {
                size2 += GeneratedMessageV3.computeStringSize(5, this.gachaProbUrl_);
            }
            if (this.gachaSortId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(6, this.gachaSortId_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.gachaRecordUrl_)) {
                size2 += GeneratedMessageV3.computeStringSize(7, this.gachaRecordUrl_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.gachaPreviewPrefabPath_)) {
                size2 += GeneratedMessageV3.computeStringSize(8, this.gachaPreviewPrefabPath_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.gachaPrefabPath_)) {
                size2 += GeneratedMessageV3.computeStringSize(9, this.gachaPrefabPath_);
            }
            if (this.tenCostItemNum_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(10, this.tenCostItemNum_);
            }
            if (this.gachaTimesLimit_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(11, this.gachaTimesLimit_);
            }
            if (this.leftGachaTimes_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(12, this.leftGachaTimes_);
            }
            if (this.costItemId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(13, this.costItemId_);
            }
            if (this.costItemNum_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(14, this.costItemNum_);
            }
            if (this.beginTime_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(15, this.beginTime_);
            }
            if (this.curScheduleDailyGachaTimes_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(48, this.curScheduleDailyGachaTimes_);
            }
            if (this.wishProgress_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(246, this.wishProgress_);
            }
            int dataSize = 0;
            for (int i = 0; i < this.displayUp4ItemList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.displayUp4ItemList_.getInt(i));
            }
            int size3 = size2 + dataSize;
            if (!getDisplayUp4ItemListList().isEmpty()) {
                size3 = size3 + 2 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.displayUp4ItemListMemoizedSerializedSize = dataSize;
            if (this.wishItemId_ != 0) {
                size3 += CodedOutputStream.computeUInt32Size(309, this.wishItemId_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.gachaProbUrlOversea_)) {
                size3 += GeneratedMessageV3.computeStringSize(GACHAPROBURLOVERSEA_FIELD_NUMBER, this.gachaProbUrlOversea_);
            }
            if (this.isNewWish_) {
                size3 += CodedOutputStream.computeBoolSize(869, this.isNewWish_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.gachaRecordUrlOversea_)) {
                size3 += GeneratedMessageV3.computeStringSize(1004, this.gachaRecordUrlOversea_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.titleTextmap_)) {
                size3 += GeneratedMessageV3.computeStringSize(1228, this.titleTextmap_);
            }
            if (this.wishMaxProgress_ != 0) {
                size3 += CodedOutputStream.computeUInt32Size(1669, this.wishMaxProgress_);
            }
            for (int i2 = 0; i2 < this.gachaUpInfoList_.size(); i2++) {
                size3 += CodedOutputStream.computeMessageSize(GACHAUPINFOLIST_FIELD_NUMBER, this.gachaUpInfoList_.get(i2));
            }
            int dataSize2 = 0;
            for (int i3 = 0; i3 < this.displayUp5ItemList_.size(); i3++) {
                dataSize2 += CodedOutputStream.computeUInt32SizeNoTag(this.displayUp5ItemList_.getInt(i3));
            }
            int size4 = size3 + dataSize2;
            if (!getDisplayUp5ItemListList().isEmpty()) {
                size4 = size4 + 2 + CodedOutputStream.computeInt32SizeNoTag(dataSize2);
            }
            this.displayUp5ItemListMemoizedSerializedSize = dataSize2;
            int size5 = size4 + this.unknownFields.getSerializedSize();
            this.memoizedSize = size5;
            return size5;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof GachaInfo)) {
                return equals(obj);
            }
            GachaInfo other = (GachaInfo) obj;
            return getGachaPrefabPath().equals(other.getGachaPrefabPath()) && getScheduleId() == other.getScheduleId() && getDisplayUp5ItemListList().equals(other.getDisplayUp5ItemListList()) && getGachaSortId() == other.getGachaSortId() && getDisplayUp4ItemListList().equals(other.getDisplayUp4ItemListList()) && getIsNewWish() == other.getIsNewWish() && getGachaTimesLimit() == other.getGachaTimesLimit() && getCostItemNum() == other.getCostItemNum() && getGachaRecordUrl().equals(other.getGachaRecordUrl()) && getTitleTextmap().equals(other.getTitleTextmap()) && getGachaUpInfoListList().equals(other.getGachaUpInfoListList()) && getGachaPreviewPrefabPath().equals(other.getGachaPreviewPrefabPath()) && getCurScheduleDailyGachaTimes() == other.getCurScheduleDailyGachaTimes() && getGachaType() == other.getGachaType() && getTenCostItemId() == other.getTenCostItemId() && getLeftGachaTimes() == other.getLeftGachaTimes() && getGachaProbUrl().equals(other.getGachaProbUrl()) && getGachaProbUrlOversea().equals(other.getGachaProbUrlOversea()) && getWishItemId() == other.getWishItemId() && getTenCostItemNum() == other.getTenCostItemNum() && getWishMaxProgress() == other.getWishMaxProgress() && getCostItemId() == other.getCostItemId() && getBeginTime() == other.getBeginTime() && getGachaRecordUrlOversea().equals(other.getGachaRecordUrlOversea()) && getWishProgress() == other.getWishProgress() && getEndTime() == other.getEndTime() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 9)) + getGachaPrefabPath().hashCode())) + 2)) + getScheduleId();
            if (getDisplayUp5ItemListCount() > 0) {
                hash = (53 * ((37 * hash) + DISPLAYUP5ITEMLIST_FIELD_NUMBER)) + getDisplayUp5ItemListList().hashCode();
            }
            int hash2 = (53 * ((37 * hash) + 6)) + getGachaSortId();
            if (getDisplayUp4ItemListCount() > 0) {
                hash2 = (53 * ((37 * hash2) + 279)) + getDisplayUp4ItemListList().hashCode();
            }
            int hash3 = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * hash2) + 869)) + Internal.hashBoolean(getIsNewWish()))) + 11)) + getGachaTimesLimit())) + 14)) + getCostItemNum())) + 7)) + getGachaRecordUrl().hashCode())) + 1228)) + getTitleTextmap().hashCode();
            if (getGachaUpInfoListCount() > 0) {
                hash3 = (53 * ((37 * hash3) + GACHAUPINFOLIST_FIELD_NUMBER)) + getGachaUpInfoListList().hashCode();
            }
            int hash4 = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * hash3) + 8)) + getGachaPreviewPrefabPath().hashCode())) + 48)) + getCurScheduleDailyGachaTimes())) + 1)) + getGachaType())) + 4)) + getTenCostItemId())) + 12)) + getLeftGachaTimes())) + 5)) + getGachaProbUrl().hashCode())) + GACHAPROBURLOVERSEA_FIELD_NUMBER)) + getGachaProbUrlOversea().hashCode())) + 309)) + getWishItemId())) + 10)) + getTenCostItemNum())) + 1669)) + getWishMaxProgress())) + 13)) + getCostItemId())) + 15)) + getBeginTime())) + 1004)) + getGachaRecordUrlOversea().hashCode())) + 246)) + getWishProgress())) + 3)) + getEndTime())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash4;
            return hash4;
        }

        public static GachaInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GachaInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GachaInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GachaInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GachaInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GachaInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GachaInfo parseFrom(InputStream input) throws IOException {
            return (GachaInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GachaInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GachaInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static GachaInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (GachaInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static GachaInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GachaInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static GachaInfo parseFrom(CodedInputStream input) throws IOException {
            return (GachaInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GachaInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GachaInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(GachaInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GachaInfoOuterClass$GachaInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements GachaInfoOrBuilder {
            private int bitField0_;
            private int scheduleId_;
            private int gachaSortId_;
            private boolean isNewWish_;
            private int gachaTimesLimit_;
            private int costItemNum_;
            private RepeatedFieldBuilderV3<GachaUpInfoOuterClass.GachaUpInfo, GachaUpInfoOuterClass.GachaUpInfo.Builder, GachaUpInfoOuterClass.GachaUpInfoOrBuilder> gachaUpInfoListBuilder_;
            private int curScheduleDailyGachaTimes_;
            private int gachaType_;
            private int tenCostItemId_;
            private int leftGachaTimes_;
            private int wishItemId_;
            private int tenCostItemNum_;
            private int wishMaxProgress_;
            private int costItemId_;
            private int beginTime_;
            private int wishProgress_;
            private int endTime_;
            private Object gachaPrefabPath_ = "";
            private Internal.IntList displayUp5ItemList_ = GachaInfo.emptyIntList();
            private Internal.IntList displayUp4ItemList_ = GachaInfo.emptyIntList();
            private Object gachaRecordUrl_ = "";
            private Object titleTextmap_ = "";
            private List<GachaUpInfoOuterClass.GachaUpInfo> gachaUpInfoList_ = Collections.emptyList();
            private Object gachaPreviewPrefabPath_ = "";
            private Object gachaProbUrl_ = "";
            private Object gachaProbUrlOversea_ = "";
            private Object gachaRecordUrlOversea_ = "";

            public static final Descriptors.Descriptor getDescriptor() {
                return GachaInfoOuterClass.internal_static_GachaInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return GachaInfoOuterClass.internal_static_GachaInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(GachaInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (GachaInfo.alwaysUseFieldBuilders) {
                    getGachaUpInfoListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.gachaPrefabPath_ = "";
                this.scheduleId_ = 0;
                this.displayUp5ItemList_ = GachaInfo.emptyIntList();
                this.bitField0_ &= -2;
                this.gachaSortId_ = 0;
                this.displayUp4ItemList_ = GachaInfo.emptyIntList();
                this.bitField0_ &= -3;
                this.isNewWish_ = false;
                this.gachaTimesLimit_ = 0;
                this.costItemNum_ = 0;
                this.gachaRecordUrl_ = "";
                this.titleTextmap_ = "";
                if (this.gachaUpInfoListBuilder_ == null) {
                    this.gachaUpInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -5;
                } else {
                    this.gachaUpInfoListBuilder_.clear();
                }
                this.gachaPreviewPrefabPath_ = "";
                this.curScheduleDailyGachaTimes_ = 0;
                this.gachaType_ = 0;
                this.tenCostItemId_ = 0;
                this.leftGachaTimes_ = 0;
                this.gachaProbUrl_ = "";
                this.gachaProbUrlOversea_ = "";
                this.wishItemId_ = 0;
                this.tenCostItemNum_ = 0;
                this.wishMaxProgress_ = 0;
                this.costItemId_ = 0;
                this.beginTime_ = 0;
                this.gachaRecordUrlOversea_ = "";
                this.wishProgress_ = 0;
                this.endTime_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return GachaInfoOuterClass.internal_static_GachaInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public GachaInfo getDefaultInstanceForType() {
                return GachaInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GachaInfo build() {
                GachaInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GachaInfo buildPartial() {
                GachaInfo result = new GachaInfo(this);
                int i = this.bitField0_;
                result.gachaPrefabPath_ = this.gachaPrefabPath_;
                result.scheduleId_ = this.scheduleId_;
                if ((this.bitField0_ & 1) != 0) {
                    this.displayUp5ItemList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.displayUp5ItemList_ = this.displayUp5ItemList_;
                result.gachaSortId_ = this.gachaSortId_;
                if ((this.bitField0_ & 2) != 0) {
                    this.displayUp4ItemList_.makeImmutable();
                    this.bitField0_ &= -3;
                }
                result.displayUp4ItemList_ = this.displayUp4ItemList_;
                result.isNewWish_ = this.isNewWish_;
                result.gachaTimesLimit_ = this.gachaTimesLimit_;
                result.costItemNum_ = this.costItemNum_;
                result.gachaRecordUrl_ = this.gachaRecordUrl_;
                result.titleTextmap_ = this.titleTextmap_;
                if (this.gachaUpInfoListBuilder_ == null) {
                    if ((this.bitField0_ & 4) != 0) {
                        this.gachaUpInfoList_ = Collections.unmodifiableList(this.gachaUpInfoList_);
                        this.bitField0_ &= -5;
                    }
                    result.gachaUpInfoList_ = this.gachaUpInfoList_;
                } else {
                    result.gachaUpInfoList_ = this.gachaUpInfoListBuilder_.build();
                }
                result.gachaPreviewPrefabPath_ = this.gachaPreviewPrefabPath_;
                result.curScheduleDailyGachaTimes_ = this.curScheduleDailyGachaTimes_;
                result.gachaType_ = this.gachaType_;
                result.tenCostItemId_ = this.tenCostItemId_;
                result.leftGachaTimes_ = this.leftGachaTimes_;
                result.gachaProbUrl_ = this.gachaProbUrl_;
                result.gachaProbUrlOversea_ = this.gachaProbUrlOversea_;
                result.wishItemId_ = this.wishItemId_;
                result.tenCostItemNum_ = this.tenCostItemNum_;
                result.wishMaxProgress_ = this.wishMaxProgress_;
                result.costItemId_ = this.costItemId_;
                result.beginTime_ = this.beginTime_;
                result.gachaRecordUrlOversea_ = this.gachaRecordUrlOversea_;
                result.wishProgress_ = this.wishProgress_;
                result.endTime_ = this.endTime_;
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
                if (other instanceof GachaInfo) {
                    return mergeFrom((GachaInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(GachaInfo other) {
                if (other == GachaInfo.getDefaultInstance()) {
                    return this;
                }
                if (!other.getGachaPrefabPath().isEmpty()) {
                    this.gachaPrefabPath_ = other.gachaPrefabPath_;
                    onChanged();
                }
                if (other.getScheduleId() != 0) {
                    setScheduleId(other.getScheduleId());
                }
                if (!other.displayUp5ItemList_.isEmpty()) {
                    if (this.displayUp5ItemList_.isEmpty()) {
                        this.displayUp5ItemList_ = other.displayUp5ItemList_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureDisplayUp5ItemListIsMutable();
                        this.displayUp5ItemList_.addAll(other.displayUp5ItemList_);
                    }
                    onChanged();
                }
                if (other.getGachaSortId() != 0) {
                    setGachaSortId(other.getGachaSortId());
                }
                if (!other.displayUp4ItemList_.isEmpty()) {
                    if (this.displayUp4ItemList_.isEmpty()) {
                        this.displayUp4ItemList_ = other.displayUp4ItemList_;
                        this.bitField0_ &= -3;
                    } else {
                        ensureDisplayUp4ItemListIsMutable();
                        this.displayUp4ItemList_.addAll(other.displayUp4ItemList_);
                    }
                    onChanged();
                }
                if (other.getIsNewWish()) {
                    setIsNewWish(other.getIsNewWish());
                }
                if (other.getGachaTimesLimit() != 0) {
                    setGachaTimesLimit(other.getGachaTimesLimit());
                }
                if (other.getCostItemNum() != 0) {
                    setCostItemNum(other.getCostItemNum());
                }
                if (!other.getGachaRecordUrl().isEmpty()) {
                    this.gachaRecordUrl_ = other.gachaRecordUrl_;
                    onChanged();
                }
                if (!other.getTitleTextmap().isEmpty()) {
                    this.titleTextmap_ = other.titleTextmap_;
                    onChanged();
                }
                if (this.gachaUpInfoListBuilder_ == null) {
                    if (!other.gachaUpInfoList_.isEmpty()) {
                        if (this.gachaUpInfoList_.isEmpty()) {
                            this.gachaUpInfoList_ = other.gachaUpInfoList_;
                            this.bitField0_ &= -5;
                        } else {
                            ensureGachaUpInfoListIsMutable();
                            this.gachaUpInfoList_.addAll(other.gachaUpInfoList_);
                        }
                        onChanged();
                    }
                } else if (!other.gachaUpInfoList_.isEmpty()) {
                    if (this.gachaUpInfoListBuilder_.isEmpty()) {
                        this.gachaUpInfoListBuilder_.dispose();
                        this.gachaUpInfoListBuilder_ = null;
                        this.gachaUpInfoList_ = other.gachaUpInfoList_;
                        this.bitField0_ &= -5;
                        this.gachaUpInfoListBuilder_ = GachaInfo.alwaysUseFieldBuilders ? getGachaUpInfoListFieldBuilder() : null;
                    } else {
                        this.gachaUpInfoListBuilder_.addAllMessages(other.gachaUpInfoList_);
                    }
                }
                if (!other.getGachaPreviewPrefabPath().isEmpty()) {
                    this.gachaPreviewPrefabPath_ = other.gachaPreviewPrefabPath_;
                    onChanged();
                }
                if (other.getCurScheduleDailyGachaTimes() != 0) {
                    setCurScheduleDailyGachaTimes(other.getCurScheduleDailyGachaTimes());
                }
                if (other.getGachaType() != 0) {
                    setGachaType(other.getGachaType());
                }
                if (other.getTenCostItemId() != 0) {
                    setTenCostItemId(other.getTenCostItemId());
                }
                if (other.getLeftGachaTimes() != 0) {
                    setLeftGachaTimes(other.getLeftGachaTimes());
                }
                if (!other.getGachaProbUrl().isEmpty()) {
                    this.gachaProbUrl_ = other.gachaProbUrl_;
                    onChanged();
                }
                if (!other.getGachaProbUrlOversea().isEmpty()) {
                    this.gachaProbUrlOversea_ = other.gachaProbUrlOversea_;
                    onChanged();
                }
                if (other.getWishItemId() != 0) {
                    setWishItemId(other.getWishItemId());
                }
                if (other.getTenCostItemNum() != 0) {
                    setTenCostItemNum(other.getTenCostItemNum());
                }
                if (other.getWishMaxProgress() != 0) {
                    setWishMaxProgress(other.getWishMaxProgress());
                }
                if (other.getCostItemId() != 0) {
                    setCostItemId(other.getCostItemId());
                }
                if (other.getBeginTime() != 0) {
                    setBeginTime(other.getBeginTime());
                }
                if (!other.getGachaRecordUrlOversea().isEmpty()) {
                    this.gachaRecordUrlOversea_ = other.gachaRecordUrlOversea_;
                    onChanged();
                }
                if (other.getWishProgress() != 0) {
                    setWishProgress(other.getWishProgress());
                }
                if (other.getEndTime() != 0) {
                    setEndTime(other.getEndTime());
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
                GachaInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = GachaInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (GachaInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
            public String getGachaPrefabPath() {
                Object ref = this.gachaPrefabPath_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.gachaPrefabPath_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
            public ByteString getGachaPrefabPathBytes() {
                Object ref = this.gachaPrefabPath_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.gachaPrefabPath_ = b;
                return b;
            }

            public Builder setGachaPrefabPath(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.gachaPrefabPath_ = value;
                onChanged();
                return this;
            }

            public Builder clearGachaPrefabPath() {
                this.gachaPrefabPath_ = GachaInfo.getDefaultInstance().getGachaPrefabPath();
                onChanged();
                return this;
            }

            public Builder setGachaPrefabPathBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                GachaInfo.checkByteStringIsUtf8(value);
                this.gachaPrefabPath_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
            public int getScheduleId() {
                return this.scheduleId_;
            }

            public Builder setScheduleId(int value) {
                this.scheduleId_ = value;
                onChanged();
                return this;
            }

            public Builder clearScheduleId() {
                this.scheduleId_ = 0;
                onChanged();
                return this;
            }

            private void ensureDisplayUp5ItemListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.displayUp5ItemList_ = GachaInfo.mutableCopy(this.displayUp5ItemList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
            public List<Integer> getDisplayUp5ItemListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.displayUp5ItemList_) : this.displayUp5ItemList_;
            }

            @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
            public int getDisplayUp5ItemListCount() {
                return this.displayUp5ItemList_.size();
            }

            @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
            public int getDisplayUp5ItemList(int index) {
                return this.displayUp5ItemList_.getInt(index);
            }

            public Builder setDisplayUp5ItemList(int index, int value) {
                ensureDisplayUp5ItemListIsMutable();
                this.displayUp5ItemList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addDisplayUp5ItemList(int value) {
                ensureDisplayUp5ItemListIsMutable();
                this.displayUp5ItemList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllDisplayUp5ItemList(Iterable<? extends Integer> values) {
                ensureDisplayUp5ItemListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.displayUp5ItemList_);
                onChanged();
                return this;
            }

            public Builder clearDisplayUp5ItemList() {
                this.displayUp5ItemList_ = GachaInfo.emptyIntList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
            public int getGachaSortId() {
                return this.gachaSortId_;
            }

            public Builder setGachaSortId(int value) {
                this.gachaSortId_ = value;
                onChanged();
                return this;
            }

            public Builder clearGachaSortId() {
                this.gachaSortId_ = 0;
                onChanged();
                return this;
            }

            private void ensureDisplayUp4ItemListIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.displayUp4ItemList_ = GachaInfo.mutableCopy(this.displayUp4ItemList_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
            public List<Integer> getDisplayUp4ItemListList() {
                return (this.bitField0_ & 2) != 0 ? Collections.unmodifiableList(this.displayUp4ItemList_) : this.displayUp4ItemList_;
            }

            @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
            public int getDisplayUp4ItemListCount() {
                return this.displayUp4ItemList_.size();
            }

            @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
            public int getDisplayUp4ItemList(int index) {
                return this.displayUp4ItemList_.getInt(index);
            }

            public Builder setDisplayUp4ItemList(int index, int value) {
                ensureDisplayUp4ItemListIsMutable();
                this.displayUp4ItemList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addDisplayUp4ItemList(int value) {
                ensureDisplayUp4ItemListIsMutable();
                this.displayUp4ItemList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllDisplayUp4ItemList(Iterable<? extends Integer> values) {
                ensureDisplayUp4ItemListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.displayUp4ItemList_);
                onChanged();
                return this;
            }

            public Builder clearDisplayUp4ItemList() {
                this.displayUp4ItemList_ = GachaInfo.emptyIntList();
                this.bitField0_ &= -3;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
            public boolean getIsNewWish() {
                return this.isNewWish_;
            }

            public Builder setIsNewWish(boolean value) {
                this.isNewWish_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsNewWish() {
                this.isNewWish_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
            public int getGachaTimesLimit() {
                return this.gachaTimesLimit_;
            }

            public Builder setGachaTimesLimit(int value) {
                this.gachaTimesLimit_ = value;
                onChanged();
                return this;
            }

            public Builder clearGachaTimesLimit() {
                this.gachaTimesLimit_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
            public int getCostItemNum() {
                return this.costItemNum_;
            }

            public Builder setCostItemNum(int value) {
                this.costItemNum_ = value;
                onChanged();
                return this;
            }

            public Builder clearCostItemNum() {
                this.costItemNum_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
            public String getGachaRecordUrl() {
                Object ref = this.gachaRecordUrl_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.gachaRecordUrl_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
            public ByteString getGachaRecordUrlBytes() {
                Object ref = this.gachaRecordUrl_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.gachaRecordUrl_ = b;
                return b;
            }

            public Builder setGachaRecordUrl(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.gachaRecordUrl_ = value;
                onChanged();
                return this;
            }

            public Builder clearGachaRecordUrl() {
                this.gachaRecordUrl_ = GachaInfo.getDefaultInstance().getGachaRecordUrl();
                onChanged();
                return this;
            }

            public Builder setGachaRecordUrlBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                GachaInfo.checkByteStringIsUtf8(value);
                this.gachaRecordUrl_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
            public String getTitleTextmap() {
                Object ref = this.titleTextmap_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.titleTextmap_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
            public ByteString getTitleTextmapBytes() {
                Object ref = this.titleTextmap_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.titleTextmap_ = b;
                return b;
            }

            public Builder setTitleTextmap(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.titleTextmap_ = value;
                onChanged();
                return this;
            }

            public Builder clearTitleTextmap() {
                this.titleTextmap_ = GachaInfo.getDefaultInstance().getTitleTextmap();
                onChanged();
                return this;
            }

            public Builder setTitleTextmapBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                GachaInfo.checkByteStringIsUtf8(value);
                this.titleTextmap_ = value;
                onChanged();
                return this;
            }

            private void ensureGachaUpInfoListIsMutable() {
                if ((this.bitField0_ & 4) == 0) {
                    this.gachaUpInfoList_ = new ArrayList(this.gachaUpInfoList_);
                    this.bitField0_ |= 4;
                }
            }

            @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
            public List<GachaUpInfoOuterClass.GachaUpInfo> getGachaUpInfoListList() {
                if (this.gachaUpInfoListBuilder_ == null) {
                    return Collections.unmodifiableList(this.gachaUpInfoList_);
                }
                return this.gachaUpInfoListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
            public int getGachaUpInfoListCount() {
                if (this.gachaUpInfoListBuilder_ == null) {
                    return this.gachaUpInfoList_.size();
                }
                return this.gachaUpInfoListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
            public GachaUpInfoOuterClass.GachaUpInfo getGachaUpInfoList(int index) {
                if (this.gachaUpInfoListBuilder_ == null) {
                    return this.gachaUpInfoList_.get(index);
                }
                return this.gachaUpInfoListBuilder_.getMessage(index);
            }

            public Builder setGachaUpInfoList(int index, GachaUpInfoOuterClass.GachaUpInfo value) {
                if (this.gachaUpInfoListBuilder_ != null) {
                    this.gachaUpInfoListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureGachaUpInfoListIsMutable();
                    this.gachaUpInfoList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setGachaUpInfoList(int index, GachaUpInfoOuterClass.GachaUpInfo.Builder builderForValue) {
                if (this.gachaUpInfoListBuilder_ == null) {
                    ensureGachaUpInfoListIsMutable();
                    this.gachaUpInfoList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.gachaUpInfoListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addGachaUpInfoList(GachaUpInfoOuterClass.GachaUpInfo value) {
                if (this.gachaUpInfoListBuilder_ != null) {
                    this.gachaUpInfoListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureGachaUpInfoListIsMutable();
                    this.gachaUpInfoList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addGachaUpInfoList(int index, GachaUpInfoOuterClass.GachaUpInfo value) {
                if (this.gachaUpInfoListBuilder_ != null) {
                    this.gachaUpInfoListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureGachaUpInfoListIsMutable();
                    this.gachaUpInfoList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addGachaUpInfoList(GachaUpInfoOuterClass.GachaUpInfo.Builder builderForValue) {
                if (this.gachaUpInfoListBuilder_ == null) {
                    ensureGachaUpInfoListIsMutable();
                    this.gachaUpInfoList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.gachaUpInfoListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addGachaUpInfoList(int index, GachaUpInfoOuterClass.GachaUpInfo.Builder builderForValue) {
                if (this.gachaUpInfoListBuilder_ == null) {
                    ensureGachaUpInfoListIsMutable();
                    this.gachaUpInfoList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.gachaUpInfoListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllGachaUpInfoList(Iterable<? extends GachaUpInfoOuterClass.GachaUpInfo> values) {
                if (this.gachaUpInfoListBuilder_ == null) {
                    ensureGachaUpInfoListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.gachaUpInfoList_);
                    onChanged();
                } else {
                    this.gachaUpInfoListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearGachaUpInfoList() {
                if (this.gachaUpInfoListBuilder_ == null) {
                    this.gachaUpInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -5;
                    onChanged();
                } else {
                    this.gachaUpInfoListBuilder_.clear();
                }
                return this;
            }

            public Builder removeGachaUpInfoList(int index) {
                if (this.gachaUpInfoListBuilder_ == null) {
                    ensureGachaUpInfoListIsMutable();
                    this.gachaUpInfoList_.remove(index);
                    onChanged();
                } else {
                    this.gachaUpInfoListBuilder_.remove(index);
                }
                return this;
            }

            public GachaUpInfoOuterClass.GachaUpInfo.Builder getGachaUpInfoListBuilder(int index) {
                return getGachaUpInfoListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
            public GachaUpInfoOuterClass.GachaUpInfoOrBuilder getGachaUpInfoListOrBuilder(int index) {
                if (this.gachaUpInfoListBuilder_ == null) {
                    return this.gachaUpInfoList_.get(index);
                }
                return this.gachaUpInfoListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
            public List<? extends GachaUpInfoOuterClass.GachaUpInfoOrBuilder> getGachaUpInfoListOrBuilderList() {
                if (this.gachaUpInfoListBuilder_ != null) {
                    return this.gachaUpInfoListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.gachaUpInfoList_);
            }

            public GachaUpInfoOuterClass.GachaUpInfo.Builder addGachaUpInfoListBuilder() {
                return getGachaUpInfoListFieldBuilder().addBuilder(GachaUpInfoOuterClass.GachaUpInfo.getDefaultInstance());
            }

            public GachaUpInfoOuterClass.GachaUpInfo.Builder addGachaUpInfoListBuilder(int index) {
                return getGachaUpInfoListFieldBuilder().addBuilder(index, GachaUpInfoOuterClass.GachaUpInfo.getDefaultInstance());
            }

            public List<GachaUpInfoOuterClass.GachaUpInfo.Builder> getGachaUpInfoListBuilderList() {
                return getGachaUpInfoListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<GachaUpInfoOuterClass.GachaUpInfo, GachaUpInfoOuterClass.GachaUpInfo.Builder, GachaUpInfoOuterClass.GachaUpInfoOrBuilder> getGachaUpInfoListFieldBuilder() {
                if (this.gachaUpInfoListBuilder_ == null) {
                    this.gachaUpInfoListBuilder_ = new RepeatedFieldBuilderV3<>(this.gachaUpInfoList_, (this.bitField0_ & 4) != 0, getParentForChildren(), isClean());
                    this.gachaUpInfoList_ = null;
                }
                return this.gachaUpInfoListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
            public String getGachaPreviewPrefabPath() {
                Object ref = this.gachaPreviewPrefabPath_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.gachaPreviewPrefabPath_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
            public ByteString getGachaPreviewPrefabPathBytes() {
                Object ref = this.gachaPreviewPrefabPath_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.gachaPreviewPrefabPath_ = b;
                return b;
            }

            public Builder setGachaPreviewPrefabPath(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.gachaPreviewPrefabPath_ = value;
                onChanged();
                return this;
            }

            public Builder clearGachaPreviewPrefabPath() {
                this.gachaPreviewPrefabPath_ = GachaInfo.getDefaultInstance().getGachaPreviewPrefabPath();
                onChanged();
                return this;
            }

            public Builder setGachaPreviewPrefabPathBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                GachaInfo.checkByteStringIsUtf8(value);
                this.gachaPreviewPrefabPath_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
            public int getCurScheduleDailyGachaTimes() {
                return this.curScheduleDailyGachaTimes_;
            }

            public Builder setCurScheduleDailyGachaTimes(int value) {
                this.curScheduleDailyGachaTimes_ = value;
                onChanged();
                return this;
            }

            public Builder clearCurScheduleDailyGachaTimes() {
                this.curScheduleDailyGachaTimes_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
            public int getGachaType() {
                return this.gachaType_;
            }

            public Builder setGachaType(int value) {
                this.gachaType_ = value;
                onChanged();
                return this;
            }

            public Builder clearGachaType() {
                this.gachaType_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
            public int getTenCostItemId() {
                return this.tenCostItemId_;
            }

            public Builder setTenCostItemId(int value) {
                this.tenCostItemId_ = value;
                onChanged();
                return this;
            }

            public Builder clearTenCostItemId() {
                this.tenCostItemId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
            public int getLeftGachaTimes() {
                return this.leftGachaTimes_;
            }

            public Builder setLeftGachaTimes(int value) {
                this.leftGachaTimes_ = value;
                onChanged();
                return this;
            }

            public Builder clearLeftGachaTimes() {
                this.leftGachaTimes_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
            public String getGachaProbUrl() {
                Object ref = this.gachaProbUrl_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.gachaProbUrl_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
            public ByteString getGachaProbUrlBytes() {
                Object ref = this.gachaProbUrl_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.gachaProbUrl_ = b;
                return b;
            }

            public Builder setGachaProbUrl(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.gachaProbUrl_ = value;
                onChanged();
                return this;
            }

            public Builder clearGachaProbUrl() {
                this.gachaProbUrl_ = GachaInfo.getDefaultInstance().getGachaProbUrl();
                onChanged();
                return this;
            }

            public Builder setGachaProbUrlBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                GachaInfo.checkByteStringIsUtf8(value);
                this.gachaProbUrl_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
            public String getGachaProbUrlOversea() {
                Object ref = this.gachaProbUrlOversea_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.gachaProbUrlOversea_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
            public ByteString getGachaProbUrlOverseaBytes() {
                Object ref = this.gachaProbUrlOversea_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.gachaProbUrlOversea_ = b;
                return b;
            }

            public Builder setGachaProbUrlOversea(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.gachaProbUrlOversea_ = value;
                onChanged();
                return this;
            }

            public Builder clearGachaProbUrlOversea() {
                this.gachaProbUrlOversea_ = GachaInfo.getDefaultInstance().getGachaProbUrlOversea();
                onChanged();
                return this;
            }

            public Builder setGachaProbUrlOverseaBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                GachaInfo.checkByteStringIsUtf8(value);
                this.gachaProbUrlOversea_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
            public int getWishItemId() {
                return this.wishItemId_;
            }

            public Builder setWishItemId(int value) {
                this.wishItemId_ = value;
                onChanged();
                return this;
            }

            public Builder clearWishItemId() {
                this.wishItemId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
            public int getTenCostItemNum() {
                return this.tenCostItemNum_;
            }

            public Builder setTenCostItemNum(int value) {
                this.tenCostItemNum_ = value;
                onChanged();
                return this;
            }

            public Builder clearTenCostItemNum() {
                this.tenCostItemNum_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
            public int getWishMaxProgress() {
                return this.wishMaxProgress_;
            }

            public Builder setWishMaxProgress(int value) {
                this.wishMaxProgress_ = value;
                onChanged();
                return this;
            }

            public Builder clearWishMaxProgress() {
                this.wishMaxProgress_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
            public int getCostItemId() {
                return this.costItemId_;
            }

            public Builder setCostItemId(int value) {
                this.costItemId_ = value;
                onChanged();
                return this;
            }

            public Builder clearCostItemId() {
                this.costItemId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
            public int getBeginTime() {
                return this.beginTime_;
            }

            public Builder setBeginTime(int value) {
                this.beginTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearBeginTime() {
                this.beginTime_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
            public String getGachaRecordUrlOversea() {
                Object ref = this.gachaRecordUrlOversea_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.gachaRecordUrlOversea_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
            public ByteString getGachaRecordUrlOverseaBytes() {
                Object ref = this.gachaRecordUrlOversea_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.gachaRecordUrlOversea_ = b;
                return b;
            }

            public Builder setGachaRecordUrlOversea(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.gachaRecordUrlOversea_ = value;
                onChanged();
                return this;
            }

            public Builder clearGachaRecordUrlOversea() {
                this.gachaRecordUrlOversea_ = GachaInfo.getDefaultInstance().getGachaRecordUrlOversea();
                onChanged();
                return this;
            }

            public Builder setGachaRecordUrlOverseaBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                GachaInfo.checkByteStringIsUtf8(value);
                this.gachaRecordUrlOversea_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
            public int getWishProgress() {
                return this.wishProgress_;
            }

            public Builder setWishProgress(int value) {
                this.wishProgress_ = value;
                onChanged();
                return this;
            }

            public Builder clearWishProgress() {
                this.wishProgress_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
            public int getEndTime() {
                return this.endTime_;
            }

            public Builder setEndTime(int value) {
                this.endTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearEndTime() {
                this.endTime_ = 0;
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

        public static GachaInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<GachaInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<GachaInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public GachaInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        GachaUpInfoOuterClass.getDescriptor();
    }
}
