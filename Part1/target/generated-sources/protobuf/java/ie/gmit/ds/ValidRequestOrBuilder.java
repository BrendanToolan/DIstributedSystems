// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: password.proto

package ie.gmit.ds;

public interface ValidRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:ie.gmit.ds.ValidRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string password = 1;</code>
   */
  java.lang.String getPassword();
  /**
   * <code>string password = 1;</code>
   */
  com.google.protobuf.ByteString
      getPasswordBytes();

  /**
   * <code>bytes passwordHashed = 2;</code>
   */
  com.google.protobuf.ByteString getPasswordHashed();

  /**
   * <code>bytes salt = 3;</code>
   */
  com.google.protobuf.ByteString getSalt();
}
