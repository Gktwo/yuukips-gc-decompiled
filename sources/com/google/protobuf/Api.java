package com.google.protobuf;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.Descriptors;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.Method;
import com.google.protobuf.Mixin;
import com.google.protobuf.Option;
import com.google.protobuf.SourceContext;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:com/google/protobuf/Api.class */
public final class Api extends GeneratedMessageV3 implements ApiOrBuilder {
    private static final long serialVersionUID = 0;
    public static final int NAME_FIELD_NUMBER = 1;
    private volatile Object name_;
    public static final int METHODS_FIELD_NUMBER = 2;
    private List<Method> methods_;
    public static final int OPTIONS_FIELD_NUMBER = 3;
    private List<Option> options_;
    public static final int VERSION_FIELD_NUMBER = 4;
    private volatile Object version_;
    public static final int SOURCE_CONTEXT_FIELD_NUMBER = 5;
    private SourceContext sourceContext_;
    public static final int MIXINS_FIELD_NUMBER = 6;
    private List<Mixin> mixins_;
    public static final int SYNTAX_FIELD_NUMBER = 7;
    private int syntax_;
    private byte memoizedIsInitialized;
    private static final Api DEFAULT_INSTANCE = new Api();
    private static final Parser<Api> PARSER = new AbstractParser<Api>() { // from class: com.google.protobuf.Api.1
        @Override // com.google.protobuf.Parser
        public Api parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return new Api(input, extensionRegistry);
        }
    };

    private Api(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = -1;
    }

    private Api() {
        this.memoizedIsInitialized = -1;
        this.name_ = "";
        this.methods_ = Collections.emptyList();
        this.options_ = Collections.emptyList();
        this.version_ = "";
        this.mixins_ = Collections.emptyList();
        this.syntax_ = 0;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.protobuf.GeneratedMessageV3
    public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
        return new Api();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:83:0x016e */
    /* JADX DEBUG: Multi-variable search result rejected for r0v45, resolved type: java.util.List<com.google.protobuf.Mixin> */
    /* JADX DEBUG: Multi-variable search result rejected for r0v67, resolved type: java.util.List<com.google.protobuf.Option> */
    /* JADX DEBUG: Multi-variable search result rejected for r0v75, resolved type: java.util.List<com.google.protobuf.Method> */
    /* JADX WARN: Multi-variable type inference failed */
    private Api(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.name_ = input.readStringRequireUtf8();
                            break;
                        case 18:
                            if ((mutable_bitField0_ & 1) == 0) {
                                this.methods_ = new ArrayList();
                                mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                            }
                            this.methods_.add(input.readMessage(Method.parser(), extensionRegistry));
                            break;
                        case 26:
                            if ((mutable_bitField0_ & 2) == 0) {
                                this.options_ = new ArrayList();
                                mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                            }
                            this.options_.add(input.readMessage(Option.parser(), extensionRegistry));
                            break;
                        case 34:
                            this.version_ = input.readStringRequireUtf8();
                            break;
                        case 42:
                            SourceContext.Builder subBuilder = this.sourceContext_ != null ? this.sourceContext_.toBuilder() : null;
                            this.sourceContext_ = (SourceContext) input.readMessage(SourceContext.parser(), extensionRegistry);
                            if (subBuilder == null) {
                                break;
                            } else {
                                subBuilder.mergeFrom(this.sourceContext_);
                                this.sourceContext_ = subBuilder.buildPartial();
                                break;
                            }
                        case 50:
                            if ((mutable_bitField0_ & 4) == 0) {
                                this.mixins_ = new ArrayList();
                                mutable_bitField0_ = (mutable_bitField0_ | 4) == 1 ? 1 : 0;
                            }
                            this.mixins_.add(input.readMessage(Mixin.parser(), extensionRegistry));
                            break;
                        case 56:
                            this.syntax_ = input.readEnum();
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
                this.methods_ = Collections.unmodifiableList(this.methods_);
            }
            if ((mutable_bitField0_ & 2) != 0) {
                this.options_ = Collections.unmodifiableList(this.options_);
            }
            if ((mutable_bitField0_ & 4) != 0) {
                this.mixins_ = Collections.unmodifiableList(this.mixins_);
            }
            this.unknownFields = unknownFields.build();
            makeExtensionsImmutable();
        }
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return ApiProto.internal_static_google_protobuf_Api_descriptor;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return ApiProto.internal_static_google_protobuf_Api_fieldAccessorTable.ensureFieldAccessorsInitialized(Api.class, Builder.class);
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public String getName() {
        Object ref = this.name_;
        if (ref instanceof String) {
            return (String) ref;
        }
        String s = ((ByteString) ref).toStringUtf8();
        this.name_ = s;
        return s;
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public ByteString getNameBytes() {
        Object ref = this.name_;
        if (!(ref instanceof String)) {
            return (ByteString) ref;
        }
        ByteString b = ByteString.copyFromUtf8((String) ref);
        this.name_ = b;
        return b;
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public List<Method> getMethodsList() {
        return this.methods_;
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public List<? extends MethodOrBuilder> getMethodsOrBuilderList() {
        return this.methods_;
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public int getMethodsCount() {
        return this.methods_.size();
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public Method getMethods(int index) {
        return this.methods_.get(index);
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public MethodOrBuilder getMethodsOrBuilder(int index) {
        return this.methods_.get(index);
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public List<Option> getOptionsList() {
        return this.options_;
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public List<? extends OptionOrBuilder> getOptionsOrBuilderList() {
        return this.options_;
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public int getOptionsCount() {
        return this.options_.size();
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public Option getOptions(int index) {
        return this.options_.get(index);
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public OptionOrBuilder getOptionsOrBuilder(int index) {
        return this.options_.get(index);
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public String getVersion() {
        Object ref = this.version_;
        if (ref instanceof String) {
            return (String) ref;
        }
        String s = ((ByteString) ref).toStringUtf8();
        this.version_ = s;
        return s;
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public ByteString getVersionBytes() {
        Object ref = this.version_;
        if (!(ref instanceof String)) {
            return (ByteString) ref;
        }
        ByteString b = ByteString.copyFromUtf8((String) ref);
        this.version_ = b;
        return b;
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public boolean hasSourceContext() {
        return this.sourceContext_ != null;
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public SourceContext getSourceContext() {
        return this.sourceContext_ == null ? SourceContext.getDefaultInstance() : this.sourceContext_;
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public SourceContextOrBuilder getSourceContextOrBuilder() {
        return getSourceContext();
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public List<Mixin> getMixinsList() {
        return this.mixins_;
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public List<? extends MixinOrBuilder> getMixinsOrBuilderList() {
        return this.mixins_;
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public int getMixinsCount() {
        return this.mixins_.size();
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public Mixin getMixins(int index) {
        return this.mixins_.get(index);
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public MixinOrBuilder getMixinsOrBuilder(int index) {
        return this.mixins_.get(index);
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public int getSyntaxValue() {
        return this.syntax_;
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public Syntax getSyntax() {
        Syntax result = Syntax.valueOf(this.syntax_);
        return result == null ? Syntax.UNRECOGNIZED : result;
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
        if (!GeneratedMessageV3.isStringEmpty(this.name_)) {
            GeneratedMessageV3.writeString(output, 1, this.name_);
        }
        for (int i = 0; i < this.methods_.size(); i++) {
            output.writeMessage(2, this.methods_.get(i));
        }
        for (int i2 = 0; i2 < this.options_.size(); i2++) {
            output.writeMessage(3, this.options_.get(i2));
        }
        if (!GeneratedMessageV3.isStringEmpty(this.version_)) {
            GeneratedMessageV3.writeString(output, 4, this.version_);
        }
        if (this.sourceContext_ != null) {
            output.writeMessage(5, getSourceContext());
        }
        for (int i3 = 0; i3 < this.mixins_.size(); i3++) {
            output.writeMessage(6, this.mixins_.get(i3));
        }
        if (this.syntax_ != Syntax.SYNTAX_PROTO2.getNumber()) {
            output.writeEnum(7, this.syntax_);
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
        if (!GeneratedMessageV3.isStringEmpty(this.name_)) {
            size2 = 0 + GeneratedMessageV3.computeStringSize(1, this.name_);
        }
        for (int i = 0; i < this.methods_.size(); i++) {
            size2 += CodedOutputStream.computeMessageSize(2, this.methods_.get(i));
        }
        for (int i2 = 0; i2 < this.options_.size(); i2++) {
            size2 += CodedOutputStream.computeMessageSize(3, this.options_.get(i2));
        }
        if (!GeneratedMessageV3.isStringEmpty(this.version_)) {
            size2 += GeneratedMessageV3.computeStringSize(4, this.version_);
        }
        if (this.sourceContext_ != null) {
            size2 += CodedOutputStream.computeMessageSize(5, getSourceContext());
        }
        for (int i3 = 0; i3 < this.mixins_.size(); i3++) {
            size2 += CodedOutputStream.computeMessageSize(6, this.mixins_.get(i3));
        }
        if (this.syntax_ != Syntax.SYNTAX_PROTO2.getNumber()) {
            size2 += CodedOutputStream.computeEnumSize(7, this.syntax_);
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
        if (!(obj instanceof Api)) {
            return equals(obj);
        }
        Api other = (Api) obj;
        if (getName().equals(other.getName()) && getMethodsList().equals(other.getMethodsList()) && getOptionsList().equals(other.getOptionsList()) && getVersion().equals(other.getVersion()) && hasSourceContext() == other.hasSourceContext()) {
            return (!hasSourceContext() || getSourceContext().equals(other.getSourceContext())) && getMixinsList().equals(other.getMixinsList()) && this.syntax_ == other.syntax_ && this.unknownFields.equals(other.unknownFields);
        }
        return false;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        if (this.memoizedHashCode != 0) {
            return this.memoizedHashCode;
        }
        int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + getName().hashCode();
        if (getMethodsCount() > 0) {
            hash = (53 * ((37 * hash) + 2)) + getMethodsList().hashCode();
        }
        if (getOptionsCount() > 0) {
            hash = (53 * ((37 * hash) + 3)) + getOptionsList().hashCode();
        }
        int hash2 = (53 * ((37 * hash) + 4)) + getVersion().hashCode();
        if (hasSourceContext()) {
            hash2 = (53 * ((37 * hash2) + 5)) + getSourceContext().hashCode();
        }
        if (getMixinsCount() > 0) {
            hash2 = (53 * ((37 * hash2) + 6)) + getMixinsList().hashCode();
        }
        int hash3 = (29 * ((53 * ((37 * hash2) + 7)) + this.syntax_)) + this.unknownFields.hashCode();
        this.memoizedHashCode = hash3;
        return hash3;
    }

    public static Api parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static Api parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static Api parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static Api parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static Api parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static Api parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static Api parseFrom(InputStream input) throws IOException {
        return (Api) GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static Api parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Api) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
    }

    public static Api parseDelimitedFrom(InputStream input) throws IOException {
        return (Api) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
    }

    public static Api parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Api) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }

    public static Api parseFrom(CodedInputStream input) throws IOException {
        return (Api) GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static Api parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Api) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(Api prototype) {
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

    /* loaded from: grasscutter.jar:com/google/protobuf/Api$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ApiOrBuilder {
        private int bitField0_;
        private Object name_;
        private List<Method> methods_;
        private RepeatedFieldBuilderV3<Method, Method.Builder, MethodOrBuilder> methodsBuilder_;
        private List<Option> options_;
        private RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> optionsBuilder_;
        private Object version_;
        private SourceContext sourceContext_;
        private SingleFieldBuilderV3<SourceContext, SourceContext.Builder, SourceContextOrBuilder> sourceContextBuilder_;
        private List<Mixin> mixins_;
        private RepeatedFieldBuilderV3<Mixin, Mixin.Builder, MixinOrBuilder> mixinsBuilder_;
        private int syntax_;

        public static final Descriptors.Descriptor getDescriptor() {
            return ApiProto.internal_static_google_protobuf_Api_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ApiProto.internal_static_google_protobuf_Api_fieldAccessorTable.ensureFieldAccessorsInitialized(Api.class, Builder.class);
        }

        private Builder() {
            this.name_ = "";
            this.methods_ = Collections.emptyList();
            this.options_ = Collections.emptyList();
            this.version_ = "";
            this.mixins_ = Collections.emptyList();
            this.syntax_ = 0;
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent parent) {
            super(parent);
            this.name_ = "";
            this.methods_ = Collections.emptyList();
            this.options_ = Collections.emptyList();
            this.version_ = "";
            this.mixins_ = Collections.emptyList();
            this.syntax_ = 0;
            maybeForceBuilderInitialization();
        }

        private void maybeForceBuilderInitialization() {
            if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                getMethodsFieldBuilder();
                getOptionsFieldBuilder();
                getMixinsFieldBuilder();
            }
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            clear();
            this.name_ = "";
            if (this.methodsBuilder_ == null) {
                this.methods_ = Collections.emptyList();
                this.bitField0_ &= -2;
            } else {
                this.methodsBuilder_.clear();
            }
            if (this.optionsBuilder_ == null) {
                this.options_ = Collections.emptyList();
                this.bitField0_ &= -3;
            } else {
                this.optionsBuilder_.clear();
            }
            this.version_ = "";
            if (this.sourceContextBuilder_ == null) {
                this.sourceContext_ = null;
            } else {
                this.sourceContext_ = null;
                this.sourceContextBuilder_ = null;
            }
            if (this.mixinsBuilder_ == null) {
                this.mixins_ = Collections.emptyList();
                this.bitField0_ &= -5;
            } else {
                this.mixinsBuilder_.clear();
            }
            this.syntax_ = 0;
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return ApiProto.internal_static_google_protobuf_Api_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Api getDefaultInstanceForType() {
            return Api.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Api build() {
            Api result = buildPartial();
            if (result.isInitialized()) {
                return result;
            }
            throw newUninitializedMessageException((Message) result);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Api buildPartial() {
            Api result = new Api(this);
            int i = this.bitField0_;
            result.name_ = this.name_;
            if (this.methodsBuilder_ == null) {
                if ((this.bitField0_ & 1) != 0) {
                    this.methods_ = Collections.unmodifiableList(this.methods_);
                    this.bitField0_ &= -2;
                }
                result.methods_ = this.methods_;
            } else {
                result.methods_ = this.methodsBuilder_.build();
            }
            if (this.optionsBuilder_ == null) {
                if ((this.bitField0_ & 2) != 0) {
                    this.options_ = Collections.unmodifiableList(this.options_);
                    this.bitField0_ &= -3;
                }
                result.options_ = this.options_;
            } else {
                result.options_ = this.optionsBuilder_.build();
            }
            result.version_ = this.version_;
            if (this.sourceContextBuilder_ == null) {
                result.sourceContext_ = this.sourceContext_;
            } else {
                result.sourceContext_ = this.sourceContextBuilder_.build();
            }
            if (this.mixinsBuilder_ == null) {
                if ((this.bitField0_ & 4) != 0) {
                    this.mixins_ = Collections.unmodifiableList(this.mixins_);
                    this.bitField0_ &= -5;
                }
                result.mixins_ = this.mixins_;
            } else {
                result.mixins_ = this.mixinsBuilder_.build();
            }
            result.syntax_ = this.syntax_;
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
            if (other instanceof Api) {
                return mergeFrom((Api) other);
            }
            mergeFrom(other);
            return this;
        }

        public Builder mergeFrom(Api other) {
            if (other == Api.getDefaultInstance()) {
                return this;
            }
            if (!other.getName().isEmpty()) {
                this.name_ = other.name_;
                onChanged();
            }
            if (this.methodsBuilder_ == null) {
                if (!other.methods_.isEmpty()) {
                    if (this.methods_.isEmpty()) {
                        this.methods_ = other.methods_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureMethodsIsMutable();
                        this.methods_.addAll(other.methods_);
                    }
                    onChanged();
                }
            } else if (!other.methods_.isEmpty()) {
                if (this.methodsBuilder_.isEmpty()) {
                    this.methodsBuilder_.dispose();
                    this.methodsBuilder_ = null;
                    this.methods_ = other.methods_;
                    this.bitField0_ &= -2;
                    this.methodsBuilder_ = GeneratedMessageV3.alwaysUseFieldBuilders ? getMethodsFieldBuilder() : null;
                } else {
                    this.methodsBuilder_.addAllMessages(other.methods_);
                }
            }
            if (this.optionsBuilder_ == null) {
                if (!other.options_.isEmpty()) {
                    if (this.options_.isEmpty()) {
                        this.options_ = other.options_;
                        this.bitField0_ &= -3;
                    } else {
                        ensureOptionsIsMutable();
                        this.options_.addAll(other.options_);
                    }
                    onChanged();
                }
            } else if (!other.options_.isEmpty()) {
                if (this.optionsBuilder_.isEmpty()) {
                    this.optionsBuilder_.dispose();
                    this.optionsBuilder_ = null;
                    this.options_ = other.options_;
                    this.bitField0_ &= -3;
                    this.optionsBuilder_ = GeneratedMessageV3.alwaysUseFieldBuilders ? getOptionsFieldBuilder() : null;
                } else {
                    this.optionsBuilder_.addAllMessages(other.options_);
                }
            }
            if (!other.getVersion().isEmpty()) {
                this.version_ = other.version_;
                onChanged();
            }
            if (other.hasSourceContext()) {
                mergeSourceContext(other.getSourceContext());
            }
            if (this.mixinsBuilder_ == null) {
                if (!other.mixins_.isEmpty()) {
                    if (this.mixins_.isEmpty()) {
                        this.mixins_ = other.mixins_;
                        this.bitField0_ &= -5;
                    } else {
                        ensureMixinsIsMutable();
                        this.mixins_.addAll(other.mixins_);
                    }
                    onChanged();
                }
            } else if (!other.mixins_.isEmpty()) {
                if (this.mixinsBuilder_.isEmpty()) {
                    this.mixinsBuilder_.dispose();
                    this.mixinsBuilder_ = null;
                    this.mixins_ = other.mixins_;
                    this.bitField0_ &= -5;
                    this.mixinsBuilder_ = GeneratedMessageV3.alwaysUseFieldBuilders ? getMixinsFieldBuilder() : null;
                } else {
                    this.mixinsBuilder_.addAllMessages(other.mixins_);
                }
            }
            if (other.syntax_ != 0) {
                setSyntaxValue(other.getSyntaxValue());
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
            Api parsedMessage = null;
            try {
                try {
                    parsedMessage = (Api) Api.PARSER.parsePartialFrom(input, extensionRegistry);
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (Api) e.getUnfinishedMessage();
                    throw e.unwrapIOException();
                }
            } catch (Throwable th) {
                if (parsedMessage != null) {
                    mergeFrom(parsedMessage);
                }
                throw th;
            }
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public String getName() {
            Object ref = this.name_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.name_ = s;
            return s;
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public ByteString getNameBytes() {
            Object ref = this.name_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.name_ = b;
            return b;
        }

        public Builder setName(String value) {
            if (value == null) {
                throw new NullPointerException();
            }
            this.name_ = value;
            onChanged();
            return this;
        }

        public Builder clearName() {
            this.name_ = Api.getDefaultInstance().getName();
            onChanged();
            return this;
        }

        public Builder setNameBytes(ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            }
            AbstractMessageLite.checkByteStringIsUtf8(value);
            this.name_ = value;
            onChanged();
            return this;
        }

        private void ensureMethodsIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.methods_ = new ArrayList(this.methods_);
                this.bitField0_ |= 1;
            }
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public List<Method> getMethodsList() {
            if (this.methodsBuilder_ == null) {
                return Collections.unmodifiableList(this.methods_);
            }
            return this.methodsBuilder_.getMessageList();
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public int getMethodsCount() {
            if (this.methodsBuilder_ == null) {
                return this.methods_.size();
            }
            return this.methodsBuilder_.getCount();
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public Method getMethods(int index) {
            if (this.methodsBuilder_ == null) {
                return this.methods_.get(index);
            }
            return this.methodsBuilder_.getMessage(index);
        }

        public Builder setMethods(int index, Method value) {
            if (this.methodsBuilder_ != null) {
                this.methodsBuilder_.setMessage(index, value);
            } else if (value == null) {
                throw new NullPointerException();
            } else {
                ensureMethodsIsMutable();
                this.methods_.set(index, value);
                onChanged();
            }
            return this;
        }

        public Builder setMethods(int index, Method.Builder builderForValue) {
            if (this.methodsBuilder_ == null) {
                ensureMethodsIsMutable();
                this.methods_.set(index, builderForValue.build());
                onChanged();
            } else {
                this.methodsBuilder_.setMessage(index, builderForValue.build());
            }
            return this;
        }

        public Builder addMethods(Method value) {
            if (this.methodsBuilder_ != null) {
                this.methodsBuilder_.addMessage(value);
            } else if (value == null) {
                throw new NullPointerException();
            } else {
                ensureMethodsIsMutable();
                this.methods_.add(value);
                onChanged();
            }
            return this;
        }

        public Builder addMethods(int index, Method value) {
            if (this.methodsBuilder_ != null) {
                this.methodsBuilder_.addMessage(index, value);
            } else if (value == null) {
                throw new NullPointerException();
            } else {
                ensureMethodsIsMutable();
                this.methods_.add(index, value);
                onChanged();
            }
            return this;
        }

        public Builder addMethods(Method.Builder builderForValue) {
            if (this.methodsBuilder_ == null) {
                ensureMethodsIsMutable();
                this.methods_.add(builderForValue.build());
                onChanged();
            } else {
                this.methodsBuilder_.addMessage(builderForValue.build());
            }
            return this;
        }

        public Builder addMethods(int index, Method.Builder builderForValue) {
            if (this.methodsBuilder_ == null) {
                ensureMethodsIsMutable();
                this.methods_.add(index, builderForValue.build());
                onChanged();
            } else {
                this.methodsBuilder_.addMessage(index, builderForValue.build());
            }
            return this;
        }

        public Builder addAllMethods(Iterable<? extends Method> values) {
            if (this.methodsBuilder_ == null) {
                ensureMethodsIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.methods_);
                onChanged();
            } else {
                this.methodsBuilder_.addAllMessages(values);
            }
            return this;
        }

        public Builder clearMethods() {
            if (this.methodsBuilder_ == null) {
                this.methods_ = Collections.emptyList();
                this.bitField0_ &= -2;
                onChanged();
            } else {
                this.methodsBuilder_.clear();
            }
            return this;
        }

        public Builder removeMethods(int index) {
            if (this.methodsBuilder_ == null) {
                ensureMethodsIsMutable();
                this.methods_.remove(index);
                onChanged();
            } else {
                this.methodsBuilder_.remove(index);
            }
            return this;
        }

        public Method.Builder getMethodsBuilder(int index) {
            return getMethodsFieldBuilder().getBuilder(index);
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public MethodOrBuilder getMethodsOrBuilder(int index) {
            if (this.methodsBuilder_ == null) {
                return this.methods_.get(index);
            }
            return this.methodsBuilder_.getMessageOrBuilder(index);
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public List<? extends MethodOrBuilder> getMethodsOrBuilderList() {
            if (this.methodsBuilder_ != null) {
                return this.methodsBuilder_.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.methods_);
        }

        public Method.Builder addMethodsBuilder() {
            return getMethodsFieldBuilder().addBuilder(Method.getDefaultInstance());
        }

        public Method.Builder addMethodsBuilder(int index) {
            return getMethodsFieldBuilder().addBuilder(index, Method.getDefaultInstance());
        }

        public List<Method.Builder> getMethodsBuilderList() {
            return getMethodsFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilderV3<Method, Method.Builder, MethodOrBuilder> getMethodsFieldBuilder() {
            if (this.methodsBuilder_ == null) {
                this.methodsBuilder_ = new RepeatedFieldBuilderV3<>(this.methods_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                this.methods_ = null;
            }
            return this.methodsBuilder_;
        }

        private void ensureOptionsIsMutable() {
            if ((this.bitField0_ & 2) == 0) {
                this.options_ = new ArrayList(this.options_);
                this.bitField0_ |= 2;
            }
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public List<Option> getOptionsList() {
            if (this.optionsBuilder_ == null) {
                return Collections.unmodifiableList(this.options_);
            }
            return this.optionsBuilder_.getMessageList();
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public int getOptionsCount() {
            if (this.optionsBuilder_ == null) {
                return this.options_.size();
            }
            return this.optionsBuilder_.getCount();
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public Option getOptions(int index) {
            if (this.optionsBuilder_ == null) {
                return this.options_.get(index);
            }
            return this.optionsBuilder_.getMessage(index);
        }

        public Builder setOptions(int index, Option value) {
            if (this.optionsBuilder_ != null) {
                this.optionsBuilder_.setMessage(index, value);
            } else if (value == null) {
                throw new NullPointerException();
            } else {
                ensureOptionsIsMutable();
                this.options_.set(index, value);
                onChanged();
            }
            return this;
        }

        public Builder setOptions(int index, Option.Builder builderForValue) {
            if (this.optionsBuilder_ == null) {
                ensureOptionsIsMutable();
                this.options_.set(index, builderForValue.build());
                onChanged();
            } else {
                this.optionsBuilder_.setMessage(index, builderForValue.build());
            }
            return this;
        }

        public Builder addOptions(Option value) {
            if (this.optionsBuilder_ != null) {
                this.optionsBuilder_.addMessage(value);
            } else if (value == null) {
                throw new NullPointerException();
            } else {
                ensureOptionsIsMutable();
                this.options_.add(value);
                onChanged();
            }
            return this;
        }

        public Builder addOptions(int index, Option value) {
            if (this.optionsBuilder_ != null) {
                this.optionsBuilder_.addMessage(index, value);
            } else if (value == null) {
                throw new NullPointerException();
            } else {
                ensureOptionsIsMutable();
                this.options_.add(index, value);
                onChanged();
            }
            return this;
        }

        public Builder addOptions(Option.Builder builderForValue) {
            if (this.optionsBuilder_ == null) {
                ensureOptionsIsMutable();
                this.options_.add(builderForValue.build());
                onChanged();
            } else {
                this.optionsBuilder_.addMessage(builderForValue.build());
            }
            return this;
        }

        public Builder addOptions(int index, Option.Builder builderForValue) {
            if (this.optionsBuilder_ == null) {
                ensureOptionsIsMutable();
                this.options_.add(index, builderForValue.build());
                onChanged();
            } else {
                this.optionsBuilder_.addMessage(index, builderForValue.build());
            }
            return this;
        }

        public Builder addAllOptions(Iterable<? extends Option> values) {
            if (this.optionsBuilder_ == null) {
                ensureOptionsIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.options_);
                onChanged();
            } else {
                this.optionsBuilder_.addAllMessages(values);
            }
            return this;
        }

        public Builder clearOptions() {
            if (this.optionsBuilder_ == null) {
                this.options_ = Collections.emptyList();
                this.bitField0_ &= -3;
                onChanged();
            } else {
                this.optionsBuilder_.clear();
            }
            return this;
        }

        public Builder removeOptions(int index) {
            if (this.optionsBuilder_ == null) {
                ensureOptionsIsMutable();
                this.options_.remove(index);
                onChanged();
            } else {
                this.optionsBuilder_.remove(index);
            }
            return this;
        }

        public Option.Builder getOptionsBuilder(int index) {
            return getOptionsFieldBuilder().getBuilder(index);
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public OptionOrBuilder getOptionsOrBuilder(int index) {
            if (this.optionsBuilder_ == null) {
                return this.options_.get(index);
            }
            return this.optionsBuilder_.getMessageOrBuilder(index);
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public List<? extends OptionOrBuilder> getOptionsOrBuilderList() {
            if (this.optionsBuilder_ != null) {
                return this.optionsBuilder_.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.options_);
        }

        public Option.Builder addOptionsBuilder() {
            return getOptionsFieldBuilder().addBuilder(Option.getDefaultInstance());
        }

        public Option.Builder addOptionsBuilder(int index) {
            return getOptionsFieldBuilder().addBuilder(index, Option.getDefaultInstance());
        }

        public List<Option.Builder> getOptionsBuilderList() {
            return getOptionsFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilderV3<Option, Option.Builder, OptionOrBuilder> getOptionsFieldBuilder() {
            if (this.optionsBuilder_ == null) {
                this.optionsBuilder_ = new RepeatedFieldBuilderV3<>(this.options_, (this.bitField0_ & 2) != 0, getParentForChildren(), isClean());
                this.options_ = null;
            }
            return this.optionsBuilder_;
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public String getVersion() {
            Object ref = this.version_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.version_ = s;
            return s;
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public ByteString getVersionBytes() {
            Object ref = this.version_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.version_ = b;
            return b;
        }

        public Builder setVersion(String value) {
            if (value == null) {
                throw new NullPointerException();
            }
            this.version_ = value;
            onChanged();
            return this;
        }

        public Builder clearVersion() {
            this.version_ = Api.getDefaultInstance().getVersion();
            onChanged();
            return this;
        }

        public Builder setVersionBytes(ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            }
            AbstractMessageLite.checkByteStringIsUtf8(value);
            this.version_ = value;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public boolean hasSourceContext() {
            return (this.sourceContextBuilder_ == null && this.sourceContext_ == null) ? false : true;
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public SourceContext getSourceContext() {
            if (this.sourceContextBuilder_ == null) {
                return this.sourceContext_ == null ? SourceContext.getDefaultInstance() : this.sourceContext_;
            }
            return this.sourceContextBuilder_.getMessage();
        }

        public Builder setSourceContext(SourceContext value) {
            if (this.sourceContextBuilder_ != null) {
                this.sourceContextBuilder_.setMessage(value);
            } else if (value == null) {
                throw new NullPointerException();
            } else {
                this.sourceContext_ = value;
                onChanged();
            }
            return this;
        }

        public Builder setSourceContext(SourceContext.Builder builderForValue) {
            if (this.sourceContextBuilder_ == null) {
                this.sourceContext_ = builderForValue.build();
                onChanged();
            } else {
                this.sourceContextBuilder_.setMessage(builderForValue.build());
            }
            return this;
        }

        public Builder mergeSourceContext(SourceContext value) {
            if (this.sourceContextBuilder_ == null) {
                if (this.sourceContext_ != null) {
                    this.sourceContext_ = SourceContext.newBuilder(this.sourceContext_).mergeFrom(value).buildPartial();
                } else {
                    this.sourceContext_ = value;
                }
                onChanged();
            } else {
                this.sourceContextBuilder_.mergeFrom(value);
            }
            return this;
        }

        public Builder clearSourceContext() {
            if (this.sourceContextBuilder_ == null) {
                this.sourceContext_ = null;
                onChanged();
            } else {
                this.sourceContext_ = null;
                this.sourceContextBuilder_ = null;
            }
            return this;
        }

        public SourceContext.Builder getSourceContextBuilder() {
            onChanged();
            return getSourceContextFieldBuilder().getBuilder();
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public SourceContextOrBuilder getSourceContextOrBuilder() {
            if (this.sourceContextBuilder_ != null) {
                return this.sourceContextBuilder_.getMessageOrBuilder();
            }
            return this.sourceContext_ == null ? SourceContext.getDefaultInstance() : this.sourceContext_;
        }

        private SingleFieldBuilderV3<SourceContext, SourceContext.Builder, SourceContextOrBuilder> getSourceContextFieldBuilder() {
            if (this.sourceContextBuilder_ == null) {
                this.sourceContextBuilder_ = new SingleFieldBuilderV3<>(getSourceContext(), getParentForChildren(), isClean());
                this.sourceContext_ = null;
            }
            return this.sourceContextBuilder_;
        }

        private void ensureMixinsIsMutable() {
            if ((this.bitField0_ & 4) == 0) {
                this.mixins_ = new ArrayList(this.mixins_);
                this.bitField0_ |= 4;
            }
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public List<Mixin> getMixinsList() {
            if (this.mixinsBuilder_ == null) {
                return Collections.unmodifiableList(this.mixins_);
            }
            return this.mixinsBuilder_.getMessageList();
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public int getMixinsCount() {
            if (this.mixinsBuilder_ == null) {
                return this.mixins_.size();
            }
            return this.mixinsBuilder_.getCount();
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public Mixin getMixins(int index) {
            if (this.mixinsBuilder_ == null) {
                return this.mixins_.get(index);
            }
            return this.mixinsBuilder_.getMessage(index);
        }

        public Builder setMixins(int index, Mixin value) {
            if (this.mixinsBuilder_ != null) {
                this.mixinsBuilder_.setMessage(index, value);
            } else if (value == null) {
                throw new NullPointerException();
            } else {
                ensureMixinsIsMutable();
                this.mixins_.set(index, value);
                onChanged();
            }
            return this;
        }

        public Builder setMixins(int index, Mixin.Builder builderForValue) {
            if (this.mixinsBuilder_ == null) {
                ensureMixinsIsMutable();
                this.mixins_.set(index, builderForValue.build());
                onChanged();
            } else {
                this.mixinsBuilder_.setMessage(index, builderForValue.build());
            }
            return this;
        }

        public Builder addMixins(Mixin value) {
            if (this.mixinsBuilder_ != null) {
                this.mixinsBuilder_.addMessage(value);
            } else if (value == null) {
                throw new NullPointerException();
            } else {
                ensureMixinsIsMutable();
                this.mixins_.add(value);
                onChanged();
            }
            return this;
        }

        public Builder addMixins(int index, Mixin value) {
            if (this.mixinsBuilder_ != null) {
                this.mixinsBuilder_.addMessage(index, value);
            } else if (value == null) {
                throw new NullPointerException();
            } else {
                ensureMixinsIsMutable();
                this.mixins_.add(index, value);
                onChanged();
            }
            return this;
        }

        public Builder addMixins(Mixin.Builder builderForValue) {
            if (this.mixinsBuilder_ == null) {
                ensureMixinsIsMutable();
                this.mixins_.add(builderForValue.build());
                onChanged();
            } else {
                this.mixinsBuilder_.addMessage(builderForValue.build());
            }
            return this;
        }

        public Builder addMixins(int index, Mixin.Builder builderForValue) {
            if (this.mixinsBuilder_ == null) {
                ensureMixinsIsMutable();
                this.mixins_.add(index, builderForValue.build());
                onChanged();
            } else {
                this.mixinsBuilder_.addMessage(index, builderForValue.build());
            }
            return this;
        }

        public Builder addAllMixins(Iterable<? extends Mixin> values) {
            if (this.mixinsBuilder_ == null) {
                ensureMixinsIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.mixins_);
                onChanged();
            } else {
                this.mixinsBuilder_.addAllMessages(values);
            }
            return this;
        }

        public Builder clearMixins() {
            if (this.mixinsBuilder_ == null) {
                this.mixins_ = Collections.emptyList();
                this.bitField0_ &= -5;
                onChanged();
            } else {
                this.mixinsBuilder_.clear();
            }
            return this;
        }

        public Builder removeMixins(int index) {
            if (this.mixinsBuilder_ == null) {
                ensureMixinsIsMutable();
                this.mixins_.remove(index);
                onChanged();
            } else {
                this.mixinsBuilder_.remove(index);
            }
            return this;
        }

        public Mixin.Builder getMixinsBuilder(int index) {
            return getMixinsFieldBuilder().getBuilder(index);
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public MixinOrBuilder getMixinsOrBuilder(int index) {
            if (this.mixinsBuilder_ == null) {
                return this.mixins_.get(index);
            }
            return this.mixinsBuilder_.getMessageOrBuilder(index);
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public List<? extends MixinOrBuilder> getMixinsOrBuilderList() {
            if (this.mixinsBuilder_ != null) {
                return this.mixinsBuilder_.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.mixins_);
        }

        public Mixin.Builder addMixinsBuilder() {
            return getMixinsFieldBuilder().addBuilder(Mixin.getDefaultInstance());
        }

        public Mixin.Builder addMixinsBuilder(int index) {
            return getMixinsFieldBuilder().addBuilder(index, Mixin.getDefaultInstance());
        }

        public List<Mixin.Builder> getMixinsBuilderList() {
            return getMixinsFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilderV3<Mixin, Mixin.Builder, MixinOrBuilder> getMixinsFieldBuilder() {
            if (this.mixinsBuilder_ == null) {
                this.mixinsBuilder_ = new RepeatedFieldBuilderV3<>(this.mixins_, (this.bitField0_ & 4) != 0, getParentForChildren(), isClean());
                this.mixins_ = null;
            }
            return this.mixinsBuilder_;
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public int getSyntaxValue() {
            return this.syntax_;
        }

        public Builder setSyntaxValue(int value) {
            this.syntax_ = value;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public Syntax getSyntax() {
            Syntax result = Syntax.valueOf(this.syntax_);
            return result == null ? Syntax.UNRECOGNIZED : result;
        }

        public Builder setSyntax(Syntax value) {
            if (value == null) {
                throw new NullPointerException();
            }
            this.syntax_ = value.getNumber();
            onChanged();
            return this;
        }

        public Builder clearSyntax() {
            this.syntax_ = 0;
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

    public static Api getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<Api> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<Api> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public Api getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
