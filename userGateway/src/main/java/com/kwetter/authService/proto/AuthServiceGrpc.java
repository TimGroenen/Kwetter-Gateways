package com.kwetter.authService.proto;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.0.1)",
    comments = "Source: AuthService.proto")
public class AuthServiceGrpc {

  private AuthServiceGrpc() {}

  public static final String SERVICE_NAME = "com.kwetter.authService.proto.AuthService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.kwetter.authService.proto.AuthServiceOuterClass.RegisterRequest,
      com.kwetter.authService.proto.AuthServiceOuterClass.RegisterResponse> METHOD_REGISTER =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "com.kwetter.authService.proto.AuthService", "Register"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.kwetter.authService.proto.AuthServiceOuterClass.RegisterRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.kwetter.authService.proto.AuthServiceOuterClass.RegisterResponse.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.kwetter.authService.proto.AuthServiceOuterClass.LoginRequest,
      com.kwetter.authService.proto.AuthServiceOuterClass.LoginResponse> METHOD_LOGIN =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "com.kwetter.authService.proto.AuthService", "Login"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.kwetter.authService.proto.AuthServiceOuterClass.LoginRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.kwetter.authService.proto.AuthServiceOuterClass.LoginResponse.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.kwetter.authService.proto.AuthServiceOuterClass.ValidationRequest,
      com.kwetter.authService.proto.AuthServiceOuterClass.ValidationResponse> METHOD_VALIDATE_TOKEN =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "com.kwetter.authService.proto.AuthService", "ValidateToken"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.kwetter.authService.proto.AuthServiceOuterClass.ValidationRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.kwetter.authService.proto.AuthServiceOuterClass.ValidationResponse.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.kwetter.authService.proto.AuthServiceOuterClass.EmailRequest,
      com.kwetter.authService.proto.AuthServiceOuterClass.RegisterResponse> METHOD_GET_ACCOUNT_BY_EMAIL =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "com.kwetter.authService.proto.AuthService", "GetAccountByEmail"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.kwetter.authService.proto.AuthServiceOuterClass.EmailRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.kwetter.authService.proto.AuthServiceOuterClass.RegisterResponse.getDefaultInstance()));

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AuthServiceStub newStub(io.grpc.Channel channel) {
    return new AuthServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AuthServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new AuthServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary and streaming output calls on the service
   */
  public static AuthServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new AuthServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class AuthServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void register(com.kwetter.authService.proto.AuthServiceOuterClass.RegisterRequest request,
        io.grpc.stub.StreamObserver<com.kwetter.authService.proto.AuthServiceOuterClass.RegisterResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_REGISTER, responseObserver);
    }

    /**
     */
    public void login(com.kwetter.authService.proto.AuthServiceOuterClass.LoginRequest request,
        io.grpc.stub.StreamObserver<com.kwetter.authService.proto.AuthServiceOuterClass.LoginResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_LOGIN, responseObserver);
    }

    /**
     */
    public void validateToken(com.kwetter.authService.proto.AuthServiceOuterClass.ValidationRequest request,
        io.grpc.stub.StreamObserver<com.kwetter.authService.proto.AuthServiceOuterClass.ValidationResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_VALIDATE_TOKEN, responseObserver);
    }

    /**
     */
    public void getAccountByEmail(com.kwetter.authService.proto.AuthServiceOuterClass.EmailRequest request,
        io.grpc.stub.StreamObserver<com.kwetter.authService.proto.AuthServiceOuterClass.RegisterResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_ACCOUNT_BY_EMAIL, responseObserver);
    }

    @java.lang.Override public io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_REGISTER,
            asyncUnaryCall(
              new MethodHandlers<
                com.kwetter.authService.proto.AuthServiceOuterClass.RegisterRequest,
                com.kwetter.authService.proto.AuthServiceOuterClass.RegisterResponse>(
                  this, METHODID_REGISTER)))
          .addMethod(
            METHOD_LOGIN,
            asyncUnaryCall(
              new MethodHandlers<
                com.kwetter.authService.proto.AuthServiceOuterClass.LoginRequest,
                com.kwetter.authService.proto.AuthServiceOuterClass.LoginResponse>(
                  this, METHODID_LOGIN)))
          .addMethod(
            METHOD_VALIDATE_TOKEN,
            asyncUnaryCall(
              new MethodHandlers<
                com.kwetter.authService.proto.AuthServiceOuterClass.ValidationRequest,
                com.kwetter.authService.proto.AuthServiceOuterClass.ValidationResponse>(
                  this, METHODID_VALIDATE_TOKEN)))
          .addMethod(
            METHOD_GET_ACCOUNT_BY_EMAIL,
            asyncUnaryCall(
              new MethodHandlers<
                com.kwetter.authService.proto.AuthServiceOuterClass.EmailRequest,
                com.kwetter.authService.proto.AuthServiceOuterClass.RegisterResponse>(
                  this, METHODID_GET_ACCOUNT_BY_EMAIL)))
          .build();
    }
  }

  /**
   */
  public static final class AuthServiceStub extends io.grpc.stub.AbstractStub<AuthServiceStub> {
    private AuthServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AuthServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AuthServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AuthServiceStub(channel, callOptions);
    }

    /**
     */
    public void register(com.kwetter.authService.proto.AuthServiceOuterClass.RegisterRequest request,
        io.grpc.stub.StreamObserver<com.kwetter.authService.proto.AuthServiceOuterClass.RegisterResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_REGISTER, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void login(com.kwetter.authService.proto.AuthServiceOuterClass.LoginRequest request,
        io.grpc.stub.StreamObserver<com.kwetter.authService.proto.AuthServiceOuterClass.LoginResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_LOGIN, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void validateToken(com.kwetter.authService.proto.AuthServiceOuterClass.ValidationRequest request,
        io.grpc.stub.StreamObserver<com.kwetter.authService.proto.AuthServiceOuterClass.ValidationResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_VALIDATE_TOKEN, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAccountByEmail(com.kwetter.authService.proto.AuthServiceOuterClass.EmailRequest request,
        io.grpc.stub.StreamObserver<com.kwetter.authService.proto.AuthServiceOuterClass.RegisterResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_ACCOUNT_BY_EMAIL, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class AuthServiceBlockingStub extends io.grpc.stub.AbstractStub<AuthServiceBlockingStub> {
    private AuthServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AuthServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AuthServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AuthServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.kwetter.authService.proto.AuthServiceOuterClass.RegisterResponse register(com.kwetter.authService.proto.AuthServiceOuterClass.RegisterRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_REGISTER, getCallOptions(), request);
    }

    /**
     */
    public com.kwetter.authService.proto.AuthServiceOuterClass.LoginResponse login(com.kwetter.authService.proto.AuthServiceOuterClass.LoginRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_LOGIN, getCallOptions(), request);
    }

    /**
     */
    public com.kwetter.authService.proto.AuthServiceOuterClass.ValidationResponse validateToken(com.kwetter.authService.proto.AuthServiceOuterClass.ValidationRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_VALIDATE_TOKEN, getCallOptions(), request);
    }

    /**
     */
    public com.kwetter.authService.proto.AuthServiceOuterClass.RegisterResponse getAccountByEmail(com.kwetter.authService.proto.AuthServiceOuterClass.EmailRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_ACCOUNT_BY_EMAIL, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class AuthServiceFutureStub extends io.grpc.stub.AbstractStub<AuthServiceFutureStub> {
    private AuthServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AuthServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AuthServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AuthServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.kwetter.authService.proto.AuthServiceOuterClass.RegisterResponse> register(
        com.kwetter.authService.proto.AuthServiceOuterClass.RegisterRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_REGISTER, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.kwetter.authService.proto.AuthServiceOuterClass.LoginResponse> login(
        com.kwetter.authService.proto.AuthServiceOuterClass.LoginRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_LOGIN, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.kwetter.authService.proto.AuthServiceOuterClass.ValidationResponse> validateToken(
        com.kwetter.authService.proto.AuthServiceOuterClass.ValidationRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_VALIDATE_TOKEN, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.kwetter.authService.proto.AuthServiceOuterClass.RegisterResponse> getAccountByEmail(
        com.kwetter.authService.proto.AuthServiceOuterClass.EmailRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_ACCOUNT_BY_EMAIL, getCallOptions()), request);
    }
  }

  private static final int METHODID_REGISTER = 0;
  private static final int METHODID_LOGIN = 1;
  private static final int METHODID_VALIDATE_TOKEN = 2;
  private static final int METHODID_GET_ACCOUNT_BY_EMAIL = 3;

  private static class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AuthServiceImplBase serviceImpl;
    private final int methodId;

    public MethodHandlers(AuthServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_REGISTER:
          serviceImpl.register((com.kwetter.authService.proto.AuthServiceOuterClass.RegisterRequest) request,
              (io.grpc.stub.StreamObserver<com.kwetter.authService.proto.AuthServiceOuterClass.RegisterResponse>) responseObserver);
          break;
        case METHODID_LOGIN:
          serviceImpl.login((com.kwetter.authService.proto.AuthServiceOuterClass.LoginRequest) request,
              (io.grpc.stub.StreamObserver<com.kwetter.authService.proto.AuthServiceOuterClass.LoginResponse>) responseObserver);
          break;
        case METHODID_VALIDATE_TOKEN:
          serviceImpl.validateToken((com.kwetter.authService.proto.AuthServiceOuterClass.ValidationRequest) request,
              (io.grpc.stub.StreamObserver<com.kwetter.authService.proto.AuthServiceOuterClass.ValidationResponse>) responseObserver);
          break;
        case METHODID_GET_ACCOUNT_BY_EMAIL:
          serviceImpl.getAccountByEmail((com.kwetter.authService.proto.AuthServiceOuterClass.EmailRequest) request,
              (io.grpc.stub.StreamObserver<com.kwetter.authService.proto.AuthServiceOuterClass.RegisterResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    return new io.grpc.ServiceDescriptor(SERVICE_NAME,
        METHOD_REGISTER,
        METHOD_LOGIN,
        METHOD_VALIDATE_TOKEN,
        METHOD_GET_ACCOUNT_BY_EMAIL);
  }

}
