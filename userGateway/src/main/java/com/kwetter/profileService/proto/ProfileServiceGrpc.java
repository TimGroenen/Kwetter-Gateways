package com.kwetter.profileService.proto;

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
    comments = "Source: ProfileService.proto")
public class ProfileServiceGrpc {

  private ProfileServiceGrpc() {}

  public static final String SERVICE_NAME = "com.kwetter.profileService.proto.ProfileService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.kwetter.profileService.proto.ProfileServiceOuterClass.NewProfileRequest,
      com.kwetter.profileService.proto.ProfileServiceOuterClass.ProfileResponse> METHOD_CREATE_NEW_PROFILE =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "com.kwetter.profileService.proto.ProfileService", "CreateNewProfile"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.kwetter.profileService.proto.ProfileServiceOuterClass.NewProfileRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.kwetter.profileService.proto.ProfileServiceOuterClass.ProfileResponse.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.kwetter.profileService.proto.ProfileServiceOuterClass.UpdateProfileInfoRequest,
      com.kwetter.profileService.proto.ProfileServiceOuterClass.ProfileResponse> METHOD_UPDATE_PROFILE_INFO =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "com.kwetter.profileService.proto.ProfileService", "UpdateProfileInfo"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.kwetter.profileService.proto.ProfileServiceOuterClass.UpdateProfileInfoRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.kwetter.profileService.proto.ProfileServiceOuterClass.ProfileResponse.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.kwetter.profileService.proto.ProfileServiceOuterClass.GetProfileByUserIdRequest,
      com.kwetter.profileService.proto.ProfileServiceOuterClass.ProfileResponse> METHOD_GET_PROFILE_BY_USER_ID =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "com.kwetter.profileService.proto.ProfileService", "GetProfileByUserId"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.kwetter.profileService.proto.ProfileServiceOuterClass.GetProfileByUserIdRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.kwetter.profileService.proto.ProfileServiceOuterClass.ProfileResponse.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.kwetter.profileService.proto.ProfileServiceOuterClass.FollowUserRequest,
      com.kwetter.profileService.proto.ProfileServiceOuterClass.SimpleResponse> METHOD_FOLLOW_USER =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "com.kwetter.profileService.proto.ProfileService", "FollowUser"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.kwetter.profileService.proto.ProfileServiceOuterClass.FollowUserRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.kwetter.profileService.proto.ProfileServiceOuterClass.SimpleResponse.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.kwetter.profileService.proto.ProfileServiceOuterClass.FollowUserRequest,
      com.kwetter.profileService.proto.ProfileServiceOuterClass.SimpleResponse> METHOD_UNFOLLOW_USER =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "com.kwetter.profileService.proto.ProfileService", "UnfollowUser"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.kwetter.profileService.proto.ProfileServiceOuterClass.FollowUserRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.kwetter.profileService.proto.ProfileServiceOuterClass.SimpleResponse.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.kwetter.profileService.proto.ProfileServiceOuterClass.GetByProfileIdRequest,
      com.kwetter.profileService.proto.ProfileServiceOuterClass.ProfilesResponse> METHOD_GET_FOLLOWED =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "com.kwetter.profileService.proto.ProfileService", "GetFollowed"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.kwetter.profileService.proto.ProfileServiceOuterClass.GetByProfileIdRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.kwetter.profileService.proto.ProfileServiceOuterClass.ProfilesResponse.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.kwetter.profileService.proto.ProfileServiceOuterClass.GetByProfileIdRequest,
      com.kwetter.profileService.proto.ProfileServiceOuterClass.ProfilesResponse> METHOD_GET_FOLLOWERS =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "com.kwetter.profileService.proto.ProfileService", "GetFollowers"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.kwetter.profileService.proto.ProfileServiceOuterClass.GetByProfileIdRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.kwetter.profileService.proto.ProfileServiceOuterClass.ProfilesResponse.getDefaultInstance()));

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ProfileServiceStub newStub(io.grpc.Channel channel) {
    return new ProfileServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ProfileServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ProfileServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary and streaming output calls on the service
   */
  public static ProfileServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ProfileServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class ProfileServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     *Create empty profile with supplied name and accountId
     * </pre>
     */
    public void createNewProfile(com.kwetter.profileService.proto.ProfileServiceOuterClass.NewProfileRequest request,
        io.grpc.stub.StreamObserver<com.kwetter.profileService.proto.ProfileServiceOuterClass.ProfileResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_CREATE_NEW_PROFILE, responseObserver);
    }

    /**
     * <pre>
     *Update profile information
     * </pre>
     */
    public void updateProfileInfo(com.kwetter.profileService.proto.ProfileServiceOuterClass.UpdateProfileInfoRequest request,
        io.grpc.stub.StreamObserver<com.kwetter.profileService.proto.ProfileServiceOuterClass.ProfileResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_UPDATE_PROFILE_INFO, responseObserver);
    }

    /**
     * <pre>
     *Get profile by userId
     * </pre>
     */
    public void getProfileByUserId(com.kwetter.profileService.proto.ProfileServiceOuterClass.GetProfileByUserIdRequest request,
        io.grpc.stub.StreamObserver<com.kwetter.profileService.proto.ProfileServiceOuterClass.ProfileResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_PROFILE_BY_USER_ID, responseObserver);
    }

    /**
     * <pre>
     *Follow user
     * </pre>
     */
    public void followUser(com.kwetter.profileService.proto.ProfileServiceOuterClass.FollowUserRequest request,
        io.grpc.stub.StreamObserver<com.kwetter.profileService.proto.ProfileServiceOuterClass.SimpleResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_FOLLOW_USER, responseObserver);
    }

    /**
     * <pre>
     *Unfollow user
     * </pre>
     */
    public void unfollowUser(com.kwetter.profileService.proto.ProfileServiceOuterClass.FollowUserRequest request,
        io.grpc.stub.StreamObserver<com.kwetter.profileService.proto.ProfileServiceOuterClass.SimpleResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_UNFOLLOW_USER, responseObserver);
    }

    /**
     * <pre>
     *Get followed
     * </pre>
     */
    public void getFollowed(com.kwetter.profileService.proto.ProfileServiceOuterClass.GetByProfileIdRequest request,
        io.grpc.stub.StreamObserver<com.kwetter.profileService.proto.ProfileServiceOuterClass.ProfilesResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_FOLLOWED, responseObserver);
    }

    /**
     * <pre>
     *Get followers
     * </pre>
     */
    public void getFollowers(com.kwetter.profileService.proto.ProfileServiceOuterClass.GetByProfileIdRequest request,
        io.grpc.stub.StreamObserver<com.kwetter.profileService.proto.ProfileServiceOuterClass.ProfilesResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_FOLLOWERS, responseObserver);
    }

    @java.lang.Override public io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_CREATE_NEW_PROFILE,
            asyncUnaryCall(
              new MethodHandlers<
                com.kwetter.profileService.proto.ProfileServiceOuterClass.NewProfileRequest,
                com.kwetter.profileService.proto.ProfileServiceOuterClass.ProfileResponse>(
                  this, METHODID_CREATE_NEW_PROFILE)))
          .addMethod(
            METHOD_UPDATE_PROFILE_INFO,
            asyncUnaryCall(
              new MethodHandlers<
                com.kwetter.profileService.proto.ProfileServiceOuterClass.UpdateProfileInfoRequest,
                com.kwetter.profileService.proto.ProfileServiceOuterClass.ProfileResponse>(
                  this, METHODID_UPDATE_PROFILE_INFO)))
          .addMethod(
            METHOD_GET_PROFILE_BY_USER_ID,
            asyncUnaryCall(
              new MethodHandlers<
                com.kwetter.profileService.proto.ProfileServiceOuterClass.GetProfileByUserIdRequest,
                com.kwetter.profileService.proto.ProfileServiceOuterClass.ProfileResponse>(
                  this, METHODID_GET_PROFILE_BY_USER_ID)))
          .addMethod(
            METHOD_FOLLOW_USER,
            asyncUnaryCall(
              new MethodHandlers<
                com.kwetter.profileService.proto.ProfileServiceOuterClass.FollowUserRequest,
                com.kwetter.profileService.proto.ProfileServiceOuterClass.SimpleResponse>(
                  this, METHODID_FOLLOW_USER)))
          .addMethod(
            METHOD_UNFOLLOW_USER,
            asyncUnaryCall(
              new MethodHandlers<
                com.kwetter.profileService.proto.ProfileServiceOuterClass.FollowUserRequest,
                com.kwetter.profileService.proto.ProfileServiceOuterClass.SimpleResponse>(
                  this, METHODID_UNFOLLOW_USER)))
          .addMethod(
            METHOD_GET_FOLLOWED,
            asyncUnaryCall(
              new MethodHandlers<
                com.kwetter.profileService.proto.ProfileServiceOuterClass.GetByProfileIdRequest,
                com.kwetter.profileService.proto.ProfileServiceOuterClass.ProfilesResponse>(
                  this, METHODID_GET_FOLLOWED)))
          .addMethod(
            METHOD_GET_FOLLOWERS,
            asyncUnaryCall(
              new MethodHandlers<
                com.kwetter.profileService.proto.ProfileServiceOuterClass.GetByProfileIdRequest,
                com.kwetter.profileService.proto.ProfileServiceOuterClass.ProfilesResponse>(
                  this, METHODID_GET_FOLLOWERS)))
          .build();
    }
  }

  /**
   */
  public static final class ProfileServiceStub extends io.grpc.stub.AbstractStub<ProfileServiceStub> {
    private ProfileServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ProfileServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProfileServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ProfileServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     *Create empty profile with supplied name and accountId
     * </pre>
     */
    public void createNewProfile(com.kwetter.profileService.proto.ProfileServiceOuterClass.NewProfileRequest request,
        io.grpc.stub.StreamObserver<com.kwetter.profileService.proto.ProfileServiceOuterClass.ProfileResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_CREATE_NEW_PROFILE, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *Update profile information
     * </pre>
     */
    public void updateProfileInfo(com.kwetter.profileService.proto.ProfileServiceOuterClass.UpdateProfileInfoRequest request,
        io.grpc.stub.StreamObserver<com.kwetter.profileService.proto.ProfileServiceOuterClass.ProfileResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_UPDATE_PROFILE_INFO, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *Get profile by userId
     * </pre>
     */
    public void getProfileByUserId(com.kwetter.profileService.proto.ProfileServiceOuterClass.GetProfileByUserIdRequest request,
        io.grpc.stub.StreamObserver<com.kwetter.profileService.proto.ProfileServiceOuterClass.ProfileResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_PROFILE_BY_USER_ID, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *Follow user
     * </pre>
     */
    public void followUser(com.kwetter.profileService.proto.ProfileServiceOuterClass.FollowUserRequest request,
        io.grpc.stub.StreamObserver<com.kwetter.profileService.proto.ProfileServiceOuterClass.SimpleResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_FOLLOW_USER, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *Unfollow user
     * </pre>
     */
    public void unfollowUser(com.kwetter.profileService.proto.ProfileServiceOuterClass.FollowUserRequest request,
        io.grpc.stub.StreamObserver<com.kwetter.profileService.proto.ProfileServiceOuterClass.SimpleResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_UNFOLLOW_USER, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *Get followed
     * </pre>
     */
    public void getFollowed(com.kwetter.profileService.proto.ProfileServiceOuterClass.GetByProfileIdRequest request,
        io.grpc.stub.StreamObserver<com.kwetter.profileService.proto.ProfileServiceOuterClass.ProfilesResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_FOLLOWED, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *Get followers
     * </pre>
     */
    public void getFollowers(com.kwetter.profileService.proto.ProfileServiceOuterClass.GetByProfileIdRequest request,
        io.grpc.stub.StreamObserver<com.kwetter.profileService.proto.ProfileServiceOuterClass.ProfilesResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_FOLLOWERS, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ProfileServiceBlockingStub extends io.grpc.stub.AbstractStub<ProfileServiceBlockingStub> {
    private ProfileServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ProfileServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProfileServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ProfileServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     *Create empty profile with supplied name and accountId
     * </pre>
     */
    public com.kwetter.profileService.proto.ProfileServiceOuterClass.ProfileResponse createNewProfile(com.kwetter.profileService.proto.ProfileServiceOuterClass.NewProfileRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_CREATE_NEW_PROFILE, getCallOptions(), request);
    }

    /**
     * <pre>
     *Update profile information
     * </pre>
     */
    public com.kwetter.profileService.proto.ProfileServiceOuterClass.ProfileResponse updateProfileInfo(com.kwetter.profileService.proto.ProfileServiceOuterClass.UpdateProfileInfoRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_UPDATE_PROFILE_INFO, getCallOptions(), request);
    }

    /**
     * <pre>
     *Get profile by userId
     * </pre>
     */
    public com.kwetter.profileService.proto.ProfileServiceOuterClass.ProfileResponse getProfileByUserId(com.kwetter.profileService.proto.ProfileServiceOuterClass.GetProfileByUserIdRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_PROFILE_BY_USER_ID, getCallOptions(), request);
    }

    /**
     * <pre>
     *Follow user
     * </pre>
     */
    public com.kwetter.profileService.proto.ProfileServiceOuterClass.SimpleResponse followUser(com.kwetter.profileService.proto.ProfileServiceOuterClass.FollowUserRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_FOLLOW_USER, getCallOptions(), request);
    }

    /**
     * <pre>
     *Unfollow user
     * </pre>
     */
    public com.kwetter.profileService.proto.ProfileServiceOuterClass.SimpleResponse unfollowUser(com.kwetter.profileService.proto.ProfileServiceOuterClass.FollowUserRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_UNFOLLOW_USER, getCallOptions(), request);
    }

    /**
     * <pre>
     *Get followed
     * </pre>
     */
    public com.kwetter.profileService.proto.ProfileServiceOuterClass.ProfilesResponse getFollowed(com.kwetter.profileService.proto.ProfileServiceOuterClass.GetByProfileIdRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_FOLLOWED, getCallOptions(), request);
    }

    /**
     * <pre>
     *Get followers
     * </pre>
     */
    public com.kwetter.profileService.proto.ProfileServiceOuterClass.ProfilesResponse getFollowers(com.kwetter.profileService.proto.ProfileServiceOuterClass.GetByProfileIdRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_FOLLOWERS, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ProfileServiceFutureStub extends io.grpc.stub.AbstractStub<ProfileServiceFutureStub> {
    private ProfileServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ProfileServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProfileServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ProfileServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     *Create empty profile with supplied name and accountId
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.kwetter.profileService.proto.ProfileServiceOuterClass.ProfileResponse> createNewProfile(
        com.kwetter.profileService.proto.ProfileServiceOuterClass.NewProfileRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_CREATE_NEW_PROFILE, getCallOptions()), request);
    }

    /**
     * <pre>
     *Update profile information
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.kwetter.profileService.proto.ProfileServiceOuterClass.ProfileResponse> updateProfileInfo(
        com.kwetter.profileService.proto.ProfileServiceOuterClass.UpdateProfileInfoRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_UPDATE_PROFILE_INFO, getCallOptions()), request);
    }

    /**
     * <pre>
     *Get profile by userId
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.kwetter.profileService.proto.ProfileServiceOuterClass.ProfileResponse> getProfileByUserId(
        com.kwetter.profileService.proto.ProfileServiceOuterClass.GetProfileByUserIdRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_PROFILE_BY_USER_ID, getCallOptions()), request);
    }

    /**
     * <pre>
     *Follow user
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.kwetter.profileService.proto.ProfileServiceOuterClass.SimpleResponse> followUser(
        com.kwetter.profileService.proto.ProfileServiceOuterClass.FollowUserRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_FOLLOW_USER, getCallOptions()), request);
    }

    /**
     * <pre>
     *Unfollow user
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.kwetter.profileService.proto.ProfileServiceOuterClass.SimpleResponse> unfollowUser(
        com.kwetter.profileService.proto.ProfileServiceOuterClass.FollowUserRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_UNFOLLOW_USER, getCallOptions()), request);
    }

    /**
     * <pre>
     *Get followed
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.kwetter.profileService.proto.ProfileServiceOuterClass.ProfilesResponse> getFollowed(
        com.kwetter.profileService.proto.ProfileServiceOuterClass.GetByProfileIdRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_FOLLOWED, getCallOptions()), request);
    }

    /**
     * <pre>
     *Get followers
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.kwetter.profileService.proto.ProfileServiceOuterClass.ProfilesResponse> getFollowers(
        com.kwetter.profileService.proto.ProfileServiceOuterClass.GetByProfileIdRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_FOLLOWERS, getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_NEW_PROFILE = 0;
  private static final int METHODID_UPDATE_PROFILE_INFO = 1;
  private static final int METHODID_GET_PROFILE_BY_USER_ID = 2;
  private static final int METHODID_FOLLOW_USER = 3;
  private static final int METHODID_UNFOLLOW_USER = 4;
  private static final int METHODID_GET_FOLLOWED = 5;
  private static final int METHODID_GET_FOLLOWERS = 6;

  private static class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ProfileServiceImplBase serviceImpl;
    private final int methodId;

    public MethodHandlers(ProfileServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_NEW_PROFILE:
          serviceImpl.createNewProfile((com.kwetter.profileService.proto.ProfileServiceOuterClass.NewProfileRequest) request,
              (io.grpc.stub.StreamObserver<com.kwetter.profileService.proto.ProfileServiceOuterClass.ProfileResponse>) responseObserver);
          break;
        case METHODID_UPDATE_PROFILE_INFO:
          serviceImpl.updateProfileInfo((com.kwetter.profileService.proto.ProfileServiceOuterClass.UpdateProfileInfoRequest) request,
              (io.grpc.stub.StreamObserver<com.kwetter.profileService.proto.ProfileServiceOuterClass.ProfileResponse>) responseObserver);
          break;
        case METHODID_GET_PROFILE_BY_USER_ID:
          serviceImpl.getProfileByUserId((com.kwetter.profileService.proto.ProfileServiceOuterClass.GetProfileByUserIdRequest) request,
              (io.grpc.stub.StreamObserver<com.kwetter.profileService.proto.ProfileServiceOuterClass.ProfileResponse>) responseObserver);
          break;
        case METHODID_FOLLOW_USER:
          serviceImpl.followUser((com.kwetter.profileService.proto.ProfileServiceOuterClass.FollowUserRequest) request,
              (io.grpc.stub.StreamObserver<com.kwetter.profileService.proto.ProfileServiceOuterClass.SimpleResponse>) responseObserver);
          break;
        case METHODID_UNFOLLOW_USER:
          serviceImpl.unfollowUser((com.kwetter.profileService.proto.ProfileServiceOuterClass.FollowUserRequest) request,
              (io.grpc.stub.StreamObserver<com.kwetter.profileService.proto.ProfileServiceOuterClass.SimpleResponse>) responseObserver);
          break;
        case METHODID_GET_FOLLOWED:
          serviceImpl.getFollowed((com.kwetter.profileService.proto.ProfileServiceOuterClass.GetByProfileIdRequest) request,
              (io.grpc.stub.StreamObserver<com.kwetter.profileService.proto.ProfileServiceOuterClass.ProfilesResponse>) responseObserver);
          break;
        case METHODID_GET_FOLLOWERS:
          serviceImpl.getFollowers((com.kwetter.profileService.proto.ProfileServiceOuterClass.GetByProfileIdRequest) request,
              (io.grpc.stub.StreamObserver<com.kwetter.profileService.proto.ProfileServiceOuterClass.ProfilesResponse>) responseObserver);
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
        METHOD_CREATE_NEW_PROFILE,
        METHOD_UPDATE_PROFILE_INFO,
        METHOD_GET_PROFILE_BY_USER_ID,
        METHOD_FOLLOW_USER,
        METHOD_UNFOLLOW_USER,
        METHOD_GET_FOLLOWED,
        METHOD_GET_FOLLOWERS);
  }

}
