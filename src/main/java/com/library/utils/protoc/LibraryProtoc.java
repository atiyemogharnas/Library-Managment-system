// Generated by the protocol buffer compiler.  DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: library.proto
// Protobuf Java Version: 4.29.0

package com.library.utils.protoc;

public final class LibraryProtoc {
  private LibraryProtoc() {}
  static {
    com.google.protobuf.RuntimeVersion.validateProtobufGencodeVersion(
      com.google.protobuf.RuntimeVersion.RuntimeDomain.PUBLIC,
      /* major= */ 4,
      /* minor= */ 29,
      /* patch= */ 0,
      /* suffix= */ "",
      LibraryProtoc.class.getName());
  }
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_LibraryItem_descriptor;
  static final 
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_LibraryItem_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\rlibrary.proto\"\270\001\n\013LibraryItem\022\n\n\002id\030\001 " +
      "\001(\005\022\r\n\005title\030\002 \001(\t\022\016\n\006author\030\003 \001(\t\022\014\n\004ye" +
      "ar\030\004 \001(\t\022*\n\004type\030\005 \001(\0162\034.LibraryItem.Lib" +
      "raryItemType\"D\n\017LibraryItemType\022\010\n\004BOOK\020" +
      "\000\022\014\n\010MAGAZINE\020\001\022\n\n\006THESIS\020\002\022\r\n\tREFERENCE" +
      "\020\003B+\n\030com.library.utils.protocB\rLibraryP" +
      "rotocP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_LibraryItem_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_LibraryItem_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_LibraryItem_descriptor,
        new java.lang.String[] { "Id", "Title", "Author", "Year", "Type", });
    descriptor.resolveAllFeaturesImmutable();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
