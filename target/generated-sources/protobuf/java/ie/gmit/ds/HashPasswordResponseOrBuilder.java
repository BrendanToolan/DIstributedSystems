// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: password.proto

package ie.gmit.ds;

public interface HashPasswordResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:ie.gmit.ds.HashPasswordResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>int32 id = 1;</code>
   */
  int getId();

  /**
   * <code>bytes passwordHashed = 2;</code>
   */
  com.google.protobuf.ByteString getPasswordHashed();

  /**
   * <code>bytes salt = 3;</code>
   */
  com.google.protobuf.ByteString getSalt();
}
