// Generated by the protocol buffer compiler.  DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: library.proto
// Protobuf Java Version: 4.29.0

package org.example.systemManagment.file;

public interface LibraryItemOrBuilder extends
    // @@protoc_insertion_point(interface_extends:LibraryItem)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>int32 id = 1;</code>
   * @return The id.
   */
  int getId();

  /**
   * <code>string title = 2;</code>
   * @return The title.
   */
  java.lang.String getTitle();
  /**
   * <code>string title = 2;</code>
   * @return The bytes for title.
   */
  com.google.protobuf.ByteString
      getTitleBytes();

  /**
   * <code>string author = 3;</code>
   * @return The author.
   */
  java.lang.String getAuthor();
  /**
   * <code>string author = 3;</code>
   * @return The bytes for author.
   */
  com.google.protobuf.ByteString
      getAuthorBytes();

  /**
   * <code>string year = 4;</code>
   * @return The year.
   */
  java.lang.String getYear();
  /**
   * <code>string year = 4;</code>
   * @return The bytes for year.
   */
  com.google.protobuf.ByteString
      getYearBytes();

  /**
   * <code>.LibraryItem.LibraryItemType type = 5;</code>
   * @return The enum numeric value on the wire for type.
   */
  int getTypeValue();
  /**
   * <code>.LibraryItem.LibraryItemType type = 5;</code>
   * @return The type.
   */
  org.example.systemManagment.file.LibraryItem.LibraryItemType getType();
}
