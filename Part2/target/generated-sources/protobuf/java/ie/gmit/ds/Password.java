// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: password.proto

package ie.gmit.ds;

public final class Password {
  private Password() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ie_gmit_ds_HashPasswordRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ie_gmit_ds_HashPasswordRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ie_gmit_ds_HashPasswordResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ie_gmit_ds_HashPasswordResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ie_gmit_ds_ValidRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ie_gmit_ds_ValidRequest_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\016password.proto\022\nie.gmit.ds\032\036google/pro" +
      "tobuf/wrappers.proto\"3\n\023HashPasswordRequ" +
      "est\022\n\n\002id\030\001 \001(\005\022\020\n\010password\030\002 \001(\t\"H\n\024Has" +
      "hPasswordResponse\022\n\n\002id\030\001 \001(\005\022\026\n\016passwor" +
      "dHashed\030\002 \001(\014\022\014\n\004salt\030\003 \001(\014\"F\n\014ValidRequ" +
      "est\022\020\n\010password\030\001 \001(\t\022\026\n\016passwordHashed\030" +
      "\002 \001(\014\022\014\n\004salt\030\003 \001(\0142\252\001\n\017PasswordService\022" +
      "Q\n\014hashPassword\022\037.ie.gmit.ds.HashPasswor" +
      "dRequest\032 .ie.gmit.ds.HashPasswordRespon" +
      "se\022D\n\014validateHash\022\030.ie.gmit.ds.ValidReq" +
      "uest\032\032.google.protobuf.BoolValueB\016\n\nie.g" +
      "mit.dsP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.google.protobuf.WrappersProto.getDescriptor(),
        });
    internal_static_ie_gmit_ds_HashPasswordRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_ie_gmit_ds_HashPasswordRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ie_gmit_ds_HashPasswordRequest_descriptor,
        new java.lang.String[] { "Id", "Password", });
    internal_static_ie_gmit_ds_HashPasswordResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_ie_gmit_ds_HashPasswordResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ie_gmit_ds_HashPasswordResponse_descriptor,
        new java.lang.String[] { "Id", "PasswordHashed", "Salt", });
    internal_static_ie_gmit_ds_ValidRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_ie_gmit_ds_ValidRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ie_gmit_ds_ValidRequest_descriptor,
        new java.lang.String[] { "Password", "PasswordHashed", "Salt", });
    com.google.protobuf.WrappersProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
