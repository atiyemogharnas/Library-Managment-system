// Generated by the protocol buffer compiler.  DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: library.proto
// Protobuf Java Version: 4.29.0

package org.example.systemManagment.file;

/**
 * Protobuf type {@code LibraryItem}
 */
public final class LibraryItem extends
    com.google.protobuf.GeneratedMessage implements
    // @@protoc_insertion_point(message_implements:LibraryItem)
    LibraryItemOrBuilder {
private static final long serialVersionUID = 0L;
  static {
    com.google.protobuf.RuntimeVersion.validateProtobufGencodeVersion(
      com.google.protobuf.RuntimeVersion.RuntimeDomain.PUBLIC,
      /* major= */ 4,
      /* minor= */ 29,
      /* patch= */ 0,
      /* suffix= */ "",
      LibraryItem.class.getName());
  }
  // Use LibraryItem.newBuilder() to construct.
  private LibraryItem(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
    super(builder);
  }
  private LibraryItem() {
    title_ = "";
    author_ = "";
    year_ = "";
    type_ = 0;
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return org.example.systemManagment.file.LibraryProtoc.internal_static_LibraryItem_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return org.example.systemManagment.file.LibraryProtoc.internal_static_LibraryItem_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            org.example.systemManagment.file.LibraryItem.class, org.example.systemManagment.file.LibraryItem.Builder.class);
  }

  /**
   * Protobuf enum {@code LibraryItem.LibraryItemType}
   */
  public enum LibraryItemType
      implements com.google.protobuf.ProtocolMessageEnum {
    /**
     * <code>BOOK = 0;</code>
     */
    BOOK(0),
    /**
     * <code>MAGAZINE = 1;</code>
     */
    MAGAZINE(1),
    /**
     * <code>THESIS = 2;</code>
     */
    THESIS(2),
    /**
     * <code>REFERENCE = 3;</code>
     */
    REFERENCE(3),
    UNRECOGNIZED(-1),
    ;

    static {
      com.google.protobuf.RuntimeVersion.validateProtobufGencodeVersion(
        com.google.protobuf.RuntimeVersion.RuntimeDomain.PUBLIC,
        /* major= */ 4,
        /* minor= */ 29,
        /* patch= */ 0,
        /* suffix= */ "",
        LibraryItemType.class.getName());
    }
    /**
     * <code>BOOK = 0;</code>
     */
    public static final int BOOK_VALUE = 0;
    /**
     * <code>MAGAZINE = 1;</code>
     */
    public static final int MAGAZINE_VALUE = 1;
    /**
     * <code>THESIS = 2;</code>
     */
    public static final int THESIS_VALUE = 2;
    /**
     * <code>REFERENCE = 3;</code>
     */
    public static final int REFERENCE_VALUE = 3;


    public final int getNumber() {
      if (this == UNRECOGNIZED) {
        throw new java.lang.IllegalArgumentException(
            "Can't get the number of an unknown enum value.");
      }
      return value;
    }

    /**
     * @param value The numeric wire value of the corresponding enum entry.
     * @return The enum associated with the given numeric wire value.
     * @deprecated Use {@link #forNumber(int)} instead.
     */
    @java.lang.Deprecated
    public static LibraryItemType valueOf(int value) {
      return forNumber(value);
    }

    /**
     * @param value The numeric wire value of the corresponding enum entry.
     * @return The enum associated with the given numeric wire value.
     */
    public static LibraryItemType forNumber(int value) {
      switch (value) {
        case 0: return BOOK;
        case 1: return MAGAZINE;
        case 2: return THESIS;
        case 3: return REFERENCE;
        default: return null;
      }
    }

    public static com.google.protobuf.Internal.EnumLiteMap<LibraryItemType>
        internalGetValueMap() {
      return internalValueMap;
    }
    private static final com.google.protobuf.Internal.EnumLiteMap<
        LibraryItemType> internalValueMap =
          new com.google.protobuf.Internal.EnumLiteMap<LibraryItemType>() {
            public LibraryItemType findValueByNumber(int number) {
              return LibraryItemType.forNumber(number);
            }
          };

    public final com.google.protobuf.Descriptors.EnumValueDescriptor
        getValueDescriptor() {
      if (this == UNRECOGNIZED) {
        throw new java.lang.IllegalStateException(
            "Can't get the descriptor of an unrecognized enum value.");
      }
      return getDescriptor().getValues().get(ordinal());
    }
    public final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptorForType() {
      return getDescriptor();
    }
    public static final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptor() {
      return org.example.systemManagment.file.LibraryItem.getDescriptor().getEnumTypes().get(0);
    }

    private static final LibraryItemType[] VALUES = values();

    public static LibraryItemType valueOf(
        com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
      if (desc.getType() != getDescriptor()) {
        throw new java.lang.IllegalArgumentException(
          "EnumValueDescriptor is not for this type.");
      }
      if (desc.getIndex() == -1) {
        return UNRECOGNIZED;
      }
      return VALUES[desc.getIndex()];
    }

    private final int value;

    private LibraryItemType(int value) {
      this.value = value;
    }

    // @@protoc_insertion_point(enum_scope:LibraryItem.LibraryItemType)
  }

  public static final int ID_FIELD_NUMBER = 1;
  private int id_ = 0;
  /**
   * <code>int32 id = 1;</code>
   * @return The id.
   */
  @java.lang.Override
  public int getId() {
    return id_;
  }

  public static final int TITLE_FIELD_NUMBER = 2;
  @SuppressWarnings("serial")
  private volatile java.lang.Object title_ = "";
  /**
   * <code>string title = 2;</code>
   * @return The title.
   */
  @java.lang.Override
  public java.lang.String getTitle() {
    java.lang.Object ref = title_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      title_ = s;
      return s;
    }
  }
  /**
   * <code>string title = 2;</code>
   * @return The bytes for title.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getTitleBytes() {
    java.lang.Object ref = title_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      title_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int AUTHOR_FIELD_NUMBER = 3;
  @SuppressWarnings("serial")
  private volatile java.lang.Object author_ = "";
  /**
   * <code>string author = 3;</code>
   * @return The author.
   */
  @java.lang.Override
  public java.lang.String getAuthor() {
    java.lang.Object ref = author_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      author_ = s;
      return s;
    }
  }
  /**
   * <code>string author = 3;</code>
   * @return The bytes for author.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getAuthorBytes() {
    java.lang.Object ref = author_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      author_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int YEAR_FIELD_NUMBER = 4;
  @SuppressWarnings("serial")
  private volatile java.lang.Object year_ = "";
  /**
   * <code>string year = 4;</code>
   * @return The year.
   */
  @java.lang.Override
  public java.lang.String getYear() {
    java.lang.Object ref = year_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      year_ = s;
      return s;
    }
  }
  /**
   * <code>string year = 4;</code>
   * @return The bytes for year.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getYearBytes() {
    java.lang.Object ref = year_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      year_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int TYPE_FIELD_NUMBER = 5;
  private int type_ = 0;
  /**
   * <code>.LibraryItem.LibraryItemType type = 5;</code>
   * @return The enum numeric value on the wire for type.
   */
  @java.lang.Override public int getTypeValue() {
    return type_;
  }
  /**
   * <code>.LibraryItem.LibraryItemType type = 5;</code>
   * @return The type.
   */
  @java.lang.Override public org.example.systemManagment.file.LibraryItem.LibraryItemType getType() {
    org.example.systemManagment.file.LibraryItem.LibraryItemType result = org.example.systemManagment.file.LibraryItem.LibraryItemType.forNumber(type_);
    return result == null ? org.example.systemManagment.file.LibraryItem.LibraryItemType.UNRECOGNIZED : result;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (id_ != 0) {
      output.writeInt32(1, id_);
    }
    if (!com.google.protobuf.GeneratedMessage.isStringEmpty(title_)) {
      com.google.protobuf.GeneratedMessage.writeString(output, 2, title_);
    }
    if (!com.google.protobuf.GeneratedMessage.isStringEmpty(author_)) {
      com.google.protobuf.GeneratedMessage.writeString(output, 3, author_);
    }
    if (!com.google.protobuf.GeneratedMessage.isStringEmpty(year_)) {
      com.google.protobuf.GeneratedMessage.writeString(output, 4, year_);
    }
    if (type_ != org.example.systemManagment.file.LibraryItem.LibraryItemType.BOOK.getNumber()) {
      output.writeEnum(5, type_);
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (id_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(1, id_);
    }
    if (!com.google.protobuf.GeneratedMessage.isStringEmpty(title_)) {
      size += com.google.protobuf.GeneratedMessage.computeStringSize(2, title_);
    }
    if (!com.google.protobuf.GeneratedMessage.isStringEmpty(author_)) {
      size += com.google.protobuf.GeneratedMessage.computeStringSize(3, author_);
    }
    if (!com.google.protobuf.GeneratedMessage.isStringEmpty(year_)) {
      size += com.google.protobuf.GeneratedMessage.computeStringSize(4, year_);
    }
    if (type_ != org.example.systemManagment.file.LibraryItem.LibraryItemType.BOOK.getNumber()) {
      size += com.google.protobuf.CodedOutputStream
        .computeEnumSize(5, type_);
    }
    size += getUnknownFields().getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof org.example.systemManagment.file.LibraryItem)) {
      return super.equals(obj);
    }
    org.example.systemManagment.file.LibraryItem other = (org.example.systemManagment.file.LibraryItem) obj;

    if (getId()
        != other.getId()) return false;
    if (!getTitle()
        .equals(other.getTitle())) return false;
    if (!getAuthor()
        .equals(other.getAuthor())) return false;
    if (!getYear()
        .equals(other.getYear())) return false;
    if (type_ != other.type_) return false;
    if (!getUnknownFields().equals(other.getUnknownFields())) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + ID_FIELD_NUMBER;
    hash = (53 * hash) + getId();
    hash = (37 * hash) + TITLE_FIELD_NUMBER;
    hash = (53 * hash) + getTitle().hashCode();
    hash = (37 * hash) + AUTHOR_FIELD_NUMBER;
    hash = (53 * hash) + getAuthor().hashCode();
    hash = (37 * hash) + YEAR_FIELD_NUMBER;
    hash = (53 * hash) + getYear().hashCode();
    hash = (37 * hash) + TYPE_FIELD_NUMBER;
    hash = (53 * hash) + type_;
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static org.example.systemManagment.file.LibraryItem parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.example.systemManagment.file.LibraryItem parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.example.systemManagment.file.LibraryItem parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.example.systemManagment.file.LibraryItem parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.example.systemManagment.file.LibraryItem parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.example.systemManagment.file.LibraryItem parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.example.systemManagment.file.LibraryItem parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input);
  }
  public static org.example.systemManagment.file.LibraryItem parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static org.example.systemManagment.file.LibraryItem parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseDelimitedWithIOException(PARSER, input);
  }

  public static org.example.systemManagment.file.LibraryItem parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static org.example.systemManagment.file.LibraryItem parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input);
  }
  public static org.example.systemManagment.file.LibraryItem parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(org.example.systemManagment.file.LibraryItem prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessage.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code LibraryItem}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessage.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:LibraryItem)
      org.example.systemManagment.file.LibraryItemOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return org.example.systemManagment.file.LibraryProtoc.internal_static_LibraryItem_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return org.example.systemManagment.file.LibraryProtoc.internal_static_LibraryItem_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              org.example.systemManagment.file.LibraryItem.class, org.example.systemManagment.file.LibraryItem.Builder.class);
    }

    // Construct using org.example.systemManagment.file.LibraryItem.newBuilder()
    private Builder() {

    }

    private Builder(
        com.google.protobuf.GeneratedMessage.BuilderParent parent) {
      super(parent);

    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      bitField0_ = 0;
      id_ = 0;
      title_ = "";
      author_ = "";
      year_ = "";
      type_ = 0;
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return org.example.systemManagment.file.LibraryProtoc.internal_static_LibraryItem_descriptor;
    }

    @java.lang.Override
    public org.example.systemManagment.file.LibraryItem getDefaultInstanceForType() {
      return org.example.systemManagment.file.LibraryItem.getDefaultInstance();
    }

    @java.lang.Override
    public org.example.systemManagment.file.LibraryItem build() {
      org.example.systemManagment.file.LibraryItem result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public org.example.systemManagment.file.LibraryItem buildPartial() {
      org.example.systemManagment.file.LibraryItem result = new org.example.systemManagment.file.LibraryItem(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(org.example.systemManagment.file.LibraryItem result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.id_ = id_;
      }
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.title_ = title_;
      }
      if (((from_bitField0_ & 0x00000004) != 0)) {
        result.author_ = author_;
      }
      if (((from_bitField0_ & 0x00000008) != 0)) {
        result.year_ = year_;
      }
      if (((from_bitField0_ & 0x00000010) != 0)) {
        result.type_ = type_;
      }
    }

    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof org.example.systemManagment.file.LibraryItem) {
        return mergeFrom((org.example.systemManagment.file.LibraryItem)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(org.example.systemManagment.file.LibraryItem other) {
      if (other == org.example.systemManagment.file.LibraryItem.getDefaultInstance()) return this;
      if (other.getId() != 0) {
        setId(other.getId());
      }
      if (!other.getTitle().isEmpty()) {
        title_ = other.title_;
        bitField0_ |= 0x00000002;
        onChanged();
      }
      if (!other.getAuthor().isEmpty()) {
        author_ = other.author_;
        bitField0_ |= 0x00000004;
        onChanged();
      }
      if (!other.getYear().isEmpty()) {
        year_ = other.year_;
        bitField0_ |= 0x00000008;
        onChanged();
      }
      if (other.type_ != 0) {
        setTypeValue(other.getTypeValue());
      }
      this.mergeUnknownFields(other.getUnknownFields());
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 8: {
              id_ = input.readInt32();
              bitField0_ |= 0x00000001;
              break;
            } // case 8
            case 18: {
              title_ = input.readStringRequireUtf8();
              bitField0_ |= 0x00000002;
              break;
            } // case 18
            case 26: {
              author_ = input.readStringRequireUtf8();
              bitField0_ |= 0x00000004;
              break;
            } // case 26
            case 34: {
              year_ = input.readStringRequireUtf8();
              bitField0_ |= 0x00000008;
              break;
            } // case 34
            case 40: {
              type_ = input.readEnum();
              bitField0_ |= 0x00000010;
              break;
            } // case 40
            default: {
              if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                done = true; // was an endgroup tag
              }
              break;
            } // default:
          } // switch (tag)
        } // while (!done)
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.unwrapIOException();
      } finally {
        onChanged();
      } // finally
      return this;
    }
    private int bitField0_;

    private int id_ ;
    /**
     * <code>int32 id = 1;</code>
     * @return The id.
     */
    @java.lang.Override
    public int getId() {
      return id_;
    }
    /**
     * <code>int32 id = 1;</code>
     * @param value The id to set.
     * @return This builder for chaining.
     */
    public Builder setId(int value) {

      id_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>int32 id = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearId() {
      bitField0_ = (bitField0_ & ~0x00000001);
      id_ = 0;
      onChanged();
      return this;
    }

    private java.lang.Object title_ = "";
    /**
     * <code>string title = 2;</code>
     * @return The title.
     */
    public java.lang.String getTitle() {
      java.lang.Object ref = title_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        title_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string title = 2;</code>
     * @return The bytes for title.
     */
    public com.google.protobuf.ByteString
        getTitleBytes() {
      java.lang.Object ref = title_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        title_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string title = 2;</code>
     * @param value The title to set.
     * @return This builder for chaining.
     */
    public Builder setTitle(
        java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      title_ = value;
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <code>string title = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearTitle() {
      title_ = getDefaultInstance().getTitle();
      bitField0_ = (bitField0_ & ~0x00000002);
      onChanged();
      return this;
    }
    /**
     * <code>string title = 2;</code>
     * @param value The bytes for title to set.
     * @return This builder for chaining.
     */
    public Builder setTitleBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      title_ = value;
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }

    private java.lang.Object author_ = "";
    /**
     * <code>string author = 3;</code>
     * @return The author.
     */
    public java.lang.String getAuthor() {
      java.lang.Object ref = author_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        author_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string author = 3;</code>
     * @return The bytes for author.
     */
    public com.google.protobuf.ByteString
        getAuthorBytes() {
      java.lang.Object ref = author_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        author_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string author = 3;</code>
     * @param value The author to set.
     * @return This builder for chaining.
     */
    public Builder setAuthor(
        java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      author_ = value;
      bitField0_ |= 0x00000004;
      onChanged();
      return this;
    }
    /**
     * <code>string author = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearAuthor() {
      author_ = getDefaultInstance().getAuthor();
      bitField0_ = (bitField0_ & ~0x00000004);
      onChanged();
      return this;
    }
    /**
     * <code>string author = 3;</code>
     * @param value The bytes for author to set.
     * @return This builder for chaining.
     */
    public Builder setAuthorBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      author_ = value;
      bitField0_ |= 0x00000004;
      onChanged();
      return this;
    }

    private java.lang.Object year_ = "";
    /**
     * <code>string year = 4;</code>
     * @return The year.
     */
    public java.lang.String getYear() {
      java.lang.Object ref = year_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        year_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string year = 4;</code>
     * @return The bytes for year.
     */
    public com.google.protobuf.ByteString
        getYearBytes() {
      java.lang.Object ref = year_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        year_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string year = 4;</code>
     * @param value The year to set.
     * @return This builder for chaining.
     */
    public Builder setYear(
        java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      year_ = value;
      bitField0_ |= 0x00000008;
      onChanged();
      return this;
    }
    /**
     * <code>string year = 4;</code>
     * @return This builder for chaining.
     */
    public Builder clearYear() {
      year_ = getDefaultInstance().getYear();
      bitField0_ = (bitField0_ & ~0x00000008);
      onChanged();
      return this;
    }
    /**
     * <code>string year = 4;</code>
     * @param value The bytes for year to set.
     * @return This builder for chaining.
     */
    public Builder setYearBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      year_ = value;
      bitField0_ |= 0x00000008;
      onChanged();
      return this;
    }

    private int type_ = 0;
    /**
     * <code>.LibraryItem.LibraryItemType type = 5;</code>
     * @return The enum numeric value on the wire for type.
     */
    @java.lang.Override public int getTypeValue() {
      return type_;
    }
    /**
     * <code>.LibraryItem.LibraryItemType type = 5;</code>
     * @param value The enum numeric value on the wire for type to set.
     * @return This builder for chaining.
     */
    public Builder setTypeValue(int value) {
      type_ = value;
      bitField0_ |= 0x00000010;
      onChanged();
      return this;
    }
    /**
     * <code>.LibraryItem.LibraryItemType type = 5;</code>
     * @return The type.
     */
    @java.lang.Override
    public org.example.systemManagment.file.LibraryItem.LibraryItemType getType() {
      org.example.systemManagment.file.LibraryItem.LibraryItemType result = org.example.systemManagment.file.LibraryItem.LibraryItemType.forNumber(type_);
      return result == null ? org.example.systemManagment.file.LibraryItem.LibraryItemType.UNRECOGNIZED : result;
    }
    /**
     * <code>.LibraryItem.LibraryItemType type = 5;</code>
     * @param value The type to set.
     * @return This builder for chaining.
     */
    public Builder setType(org.example.systemManagment.file.LibraryItem.LibraryItemType value) {
      if (value == null) {
        throw new NullPointerException();
      }
      bitField0_ |= 0x00000010;
      type_ = value.getNumber();
      onChanged();
      return this;
    }
    /**
     * <code>.LibraryItem.LibraryItemType type = 5;</code>
     * @return This builder for chaining.
     */
    public Builder clearType() {
      bitField0_ = (bitField0_ & ~0x00000010);
      type_ = 0;
      onChanged();
      return this;
    }

    // @@protoc_insertion_point(builder_scope:LibraryItem)
  }

  // @@protoc_insertion_point(class_scope:LibraryItem)
  private static final org.example.systemManagment.file.LibraryItem DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new org.example.systemManagment.file.LibraryItem();
  }

  public static org.example.systemManagment.file.LibraryItem getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<LibraryItem>
      PARSER = new com.google.protobuf.AbstractParser<LibraryItem>() {
    @java.lang.Override
    public LibraryItem parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      Builder builder = newBuilder();
      try {
        builder.mergeFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(builder.buildPartial());
      } catch (com.google.protobuf.UninitializedMessageException e) {
        throw e.asInvalidProtocolBufferException().setUnfinishedMessage(builder.buildPartial());
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(e)
            .setUnfinishedMessage(builder.buildPartial());
      }
      return builder.buildPartial();
    }
  };

  public static com.google.protobuf.Parser<LibraryItem> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<LibraryItem> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public org.example.systemManagment.file.LibraryItem getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
