package com.kwetter.messageService.proto;

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
    comments = "Source: MessageService.proto")
public class MessageServiceGrpc {

  private MessageServiceGrpc() {}

  public static final String SERVICE_NAME = "com.kwetter.messageService.proto.MessageService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.kwetter.messageService.proto.MessageServiceOuterClass.NewTweetRequest,
      com.kwetter.messageService.proto.MessageServiceOuterClass.SimpleResponse> METHOD_CREATE_NEW_TWEET =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "com.kwetter.messageService.proto.MessageService", "CreateNewTweet"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.kwetter.messageService.proto.MessageServiceOuterClass.NewTweetRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.kwetter.messageService.proto.MessageServiceOuterClass.SimpleResponse.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.kwetter.messageService.proto.MessageServiceOuterClass.EditTweetRequest,
      com.kwetter.messageService.proto.MessageServiceOuterClass.TweetResponse> METHOD_EDIT_TWEET =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "com.kwetter.messageService.proto.MessageService", "EditTweet"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.kwetter.messageService.proto.MessageServiceOuterClass.EditTweetRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.kwetter.messageService.proto.MessageServiceOuterClass.TweetResponse.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.kwetter.messageService.proto.MessageServiceOuterClass.LikeTweetRequest,
      com.kwetter.messageService.proto.MessageServiceOuterClass.SimpleResponse> METHOD_DELETE_TWEET =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "com.kwetter.messageService.proto.MessageService", "DeleteTweet"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.kwetter.messageService.proto.MessageServiceOuterClass.LikeTweetRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.kwetter.messageService.proto.MessageServiceOuterClass.SimpleResponse.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.kwetter.messageService.proto.MessageServiceOuterClass.TweetsByProfileRequest,
      com.kwetter.messageService.proto.MessageServiceOuterClass.TweetsResponse> METHOD_GET_TWEETS_BY_PROFILE_IDS =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "com.kwetter.messageService.proto.MessageService", "GetTweetsByProfileIds"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.kwetter.messageService.proto.MessageServiceOuterClass.TweetsByProfileRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.kwetter.messageService.proto.MessageServiceOuterClass.TweetsResponse.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.kwetter.messageService.proto.MessageServiceOuterClass.LikeTweetRequest,
      com.kwetter.messageService.proto.MessageServiceOuterClass.SimpleResponse> METHOD_LIKE =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "com.kwetter.messageService.proto.MessageService", "Like"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.kwetter.messageService.proto.MessageServiceOuterClass.LikeTweetRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.kwetter.messageService.proto.MessageServiceOuterClass.SimpleResponse.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.kwetter.messageService.proto.MessageServiceOuterClass.LikeTweetRequest,
      com.kwetter.messageService.proto.MessageServiceOuterClass.SimpleResponse> METHOD_UNLIKE =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "com.kwetter.messageService.proto.MessageService", "Unlike"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.kwetter.messageService.proto.MessageServiceOuterClass.LikeTweetRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.kwetter.messageService.proto.MessageServiceOuterClass.SimpleResponse.getDefaultInstance()));

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static MessageServiceStub newStub(io.grpc.Channel channel) {
    return new MessageServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static MessageServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new MessageServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary and streaming output calls on the service
   */
  public static MessageServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new MessageServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class MessageServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     *Create new message
     * </pre>
     */
    public void createNewTweet(com.kwetter.messageService.proto.MessageServiceOuterClass.NewTweetRequest request,
        io.grpc.stub.StreamObserver<com.kwetter.messageService.proto.MessageServiceOuterClass.SimpleResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_CREATE_NEW_TWEET, responseObserver);
    }

    /**
     * <pre>
     *Edit message
     * </pre>
     */
    public void editTweet(com.kwetter.messageService.proto.MessageServiceOuterClass.EditTweetRequest request,
        io.grpc.stub.StreamObserver<com.kwetter.messageService.proto.MessageServiceOuterClass.TweetResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_EDIT_TWEET, responseObserver);
    }

    /**
     * <pre>
     *Delete tweet
     * </pre>
     */
    public void deleteTweet(com.kwetter.messageService.proto.MessageServiceOuterClass.LikeTweetRequest request,
        io.grpc.stub.StreamObserver<com.kwetter.messageService.proto.MessageServiceOuterClass.SimpleResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_DELETE_TWEET, responseObserver);
    }

    /**
     * <pre>
     *Get messages by ids
     * </pre>
     */
    public void getTweetsByProfileIds(com.kwetter.messageService.proto.MessageServiceOuterClass.TweetsByProfileRequest request,
        io.grpc.stub.StreamObserver<com.kwetter.messageService.proto.MessageServiceOuterClass.TweetsResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_TWEETS_BY_PROFILE_IDS, responseObserver);
    }

    /**
     * <pre>
     *Like message
     * </pre>
     */
    public void like(com.kwetter.messageService.proto.MessageServiceOuterClass.LikeTweetRequest request,
        io.grpc.stub.StreamObserver<com.kwetter.messageService.proto.MessageServiceOuterClass.SimpleResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_LIKE, responseObserver);
    }

    /**
     * <pre>
     *Unlike message
     * </pre>
     */
    public void unlike(com.kwetter.messageService.proto.MessageServiceOuterClass.LikeTweetRequest request,
        io.grpc.stub.StreamObserver<com.kwetter.messageService.proto.MessageServiceOuterClass.SimpleResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_UNLIKE, responseObserver);
    }

    @java.lang.Override public io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_CREATE_NEW_TWEET,
            asyncUnaryCall(
              new MethodHandlers<
                com.kwetter.messageService.proto.MessageServiceOuterClass.NewTweetRequest,
                com.kwetter.messageService.proto.MessageServiceOuterClass.SimpleResponse>(
                  this, METHODID_CREATE_NEW_TWEET)))
          .addMethod(
            METHOD_EDIT_TWEET,
            asyncUnaryCall(
              new MethodHandlers<
                com.kwetter.messageService.proto.MessageServiceOuterClass.EditTweetRequest,
                com.kwetter.messageService.proto.MessageServiceOuterClass.TweetResponse>(
                  this, METHODID_EDIT_TWEET)))
          .addMethod(
            METHOD_DELETE_TWEET,
            asyncUnaryCall(
              new MethodHandlers<
                com.kwetter.messageService.proto.MessageServiceOuterClass.LikeTweetRequest,
                com.kwetter.messageService.proto.MessageServiceOuterClass.SimpleResponse>(
                  this, METHODID_DELETE_TWEET)))
          .addMethod(
            METHOD_GET_TWEETS_BY_PROFILE_IDS,
            asyncUnaryCall(
              new MethodHandlers<
                com.kwetter.messageService.proto.MessageServiceOuterClass.TweetsByProfileRequest,
                com.kwetter.messageService.proto.MessageServiceOuterClass.TweetsResponse>(
                  this, METHODID_GET_TWEETS_BY_PROFILE_IDS)))
          .addMethod(
            METHOD_LIKE,
            asyncUnaryCall(
              new MethodHandlers<
                com.kwetter.messageService.proto.MessageServiceOuterClass.LikeTweetRequest,
                com.kwetter.messageService.proto.MessageServiceOuterClass.SimpleResponse>(
                  this, METHODID_LIKE)))
          .addMethod(
            METHOD_UNLIKE,
            asyncUnaryCall(
              new MethodHandlers<
                com.kwetter.messageService.proto.MessageServiceOuterClass.LikeTweetRequest,
                com.kwetter.messageService.proto.MessageServiceOuterClass.SimpleResponse>(
                  this, METHODID_UNLIKE)))
          .build();
    }
  }

  /**
   */
  public static final class MessageServiceStub extends io.grpc.stub.AbstractStub<MessageServiceStub> {
    private MessageServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private MessageServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MessageServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new MessageServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     *Create new message
     * </pre>
     */
    public void createNewTweet(com.kwetter.messageService.proto.MessageServiceOuterClass.NewTweetRequest request,
        io.grpc.stub.StreamObserver<com.kwetter.messageService.proto.MessageServiceOuterClass.SimpleResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_CREATE_NEW_TWEET, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *Edit message
     * </pre>
     */
    public void editTweet(com.kwetter.messageService.proto.MessageServiceOuterClass.EditTweetRequest request,
        io.grpc.stub.StreamObserver<com.kwetter.messageService.proto.MessageServiceOuterClass.TweetResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_EDIT_TWEET, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *Delete tweet
     * </pre>
     */
    public void deleteTweet(com.kwetter.messageService.proto.MessageServiceOuterClass.LikeTweetRequest request,
        io.grpc.stub.StreamObserver<com.kwetter.messageService.proto.MessageServiceOuterClass.SimpleResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_DELETE_TWEET, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *Get messages by ids
     * </pre>
     */
    public void getTweetsByProfileIds(com.kwetter.messageService.proto.MessageServiceOuterClass.TweetsByProfileRequest request,
        io.grpc.stub.StreamObserver<com.kwetter.messageService.proto.MessageServiceOuterClass.TweetsResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_TWEETS_BY_PROFILE_IDS, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *Like message
     * </pre>
     */
    public void like(com.kwetter.messageService.proto.MessageServiceOuterClass.LikeTweetRequest request,
        io.grpc.stub.StreamObserver<com.kwetter.messageService.proto.MessageServiceOuterClass.SimpleResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_LIKE, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *Unlike message
     * </pre>
     */
    public void unlike(com.kwetter.messageService.proto.MessageServiceOuterClass.LikeTweetRequest request,
        io.grpc.stub.StreamObserver<com.kwetter.messageService.proto.MessageServiceOuterClass.SimpleResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_UNLIKE, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class MessageServiceBlockingStub extends io.grpc.stub.AbstractStub<MessageServiceBlockingStub> {
    private MessageServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private MessageServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MessageServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new MessageServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     *Create new message
     * </pre>
     */
    public com.kwetter.messageService.proto.MessageServiceOuterClass.SimpleResponse createNewTweet(com.kwetter.messageService.proto.MessageServiceOuterClass.NewTweetRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_CREATE_NEW_TWEET, getCallOptions(), request);
    }

    /**
     * <pre>
     *Edit message
     * </pre>
     */
    public com.kwetter.messageService.proto.MessageServiceOuterClass.TweetResponse editTweet(com.kwetter.messageService.proto.MessageServiceOuterClass.EditTweetRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_EDIT_TWEET, getCallOptions(), request);
    }

    /**
     * <pre>
     *Delete tweet
     * </pre>
     */
    public com.kwetter.messageService.proto.MessageServiceOuterClass.SimpleResponse deleteTweet(com.kwetter.messageService.proto.MessageServiceOuterClass.LikeTweetRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_DELETE_TWEET, getCallOptions(), request);
    }

    /**
     * <pre>
     *Get messages by ids
     * </pre>
     */
    public com.kwetter.messageService.proto.MessageServiceOuterClass.TweetsResponse getTweetsByProfileIds(com.kwetter.messageService.proto.MessageServiceOuterClass.TweetsByProfileRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_TWEETS_BY_PROFILE_IDS, getCallOptions(), request);
    }

    /**
     * <pre>
     *Like message
     * </pre>
     */
    public com.kwetter.messageService.proto.MessageServiceOuterClass.SimpleResponse like(com.kwetter.messageService.proto.MessageServiceOuterClass.LikeTweetRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_LIKE, getCallOptions(), request);
    }

    /**
     * <pre>
     *Unlike message
     * </pre>
     */
    public com.kwetter.messageService.proto.MessageServiceOuterClass.SimpleResponse unlike(com.kwetter.messageService.proto.MessageServiceOuterClass.LikeTweetRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_UNLIKE, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class MessageServiceFutureStub extends io.grpc.stub.AbstractStub<MessageServiceFutureStub> {
    private MessageServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private MessageServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MessageServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new MessageServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     *Create new message
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.kwetter.messageService.proto.MessageServiceOuterClass.SimpleResponse> createNewTweet(
        com.kwetter.messageService.proto.MessageServiceOuterClass.NewTweetRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_CREATE_NEW_TWEET, getCallOptions()), request);
    }

    /**
     * <pre>
     *Edit message
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.kwetter.messageService.proto.MessageServiceOuterClass.TweetResponse> editTweet(
        com.kwetter.messageService.proto.MessageServiceOuterClass.EditTweetRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_EDIT_TWEET, getCallOptions()), request);
    }

    /**
     * <pre>
     *Delete tweet
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.kwetter.messageService.proto.MessageServiceOuterClass.SimpleResponse> deleteTweet(
        com.kwetter.messageService.proto.MessageServiceOuterClass.LikeTweetRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_DELETE_TWEET, getCallOptions()), request);
    }

    /**
     * <pre>
     *Get messages by ids
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.kwetter.messageService.proto.MessageServiceOuterClass.TweetsResponse> getTweetsByProfileIds(
        com.kwetter.messageService.proto.MessageServiceOuterClass.TweetsByProfileRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_TWEETS_BY_PROFILE_IDS, getCallOptions()), request);
    }

    /**
     * <pre>
     *Like message
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.kwetter.messageService.proto.MessageServiceOuterClass.SimpleResponse> like(
        com.kwetter.messageService.proto.MessageServiceOuterClass.LikeTweetRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_LIKE, getCallOptions()), request);
    }

    /**
     * <pre>
     *Unlike message
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.kwetter.messageService.proto.MessageServiceOuterClass.SimpleResponse> unlike(
        com.kwetter.messageService.proto.MessageServiceOuterClass.LikeTweetRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_UNLIKE, getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_NEW_TWEET = 0;
  private static final int METHODID_EDIT_TWEET = 1;
  private static final int METHODID_DELETE_TWEET = 2;
  private static final int METHODID_GET_TWEETS_BY_PROFILE_IDS = 3;
  private static final int METHODID_LIKE = 4;
  private static final int METHODID_UNLIKE = 5;

  private static class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final MessageServiceImplBase serviceImpl;
    private final int methodId;

    public MethodHandlers(MessageServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_NEW_TWEET:
          serviceImpl.createNewTweet((com.kwetter.messageService.proto.MessageServiceOuterClass.NewTweetRequest) request,
              (io.grpc.stub.StreamObserver<com.kwetter.messageService.proto.MessageServiceOuterClass.SimpleResponse>) responseObserver);
          break;
        case METHODID_EDIT_TWEET:
          serviceImpl.editTweet((com.kwetter.messageService.proto.MessageServiceOuterClass.EditTweetRequest) request,
              (io.grpc.stub.StreamObserver<com.kwetter.messageService.proto.MessageServiceOuterClass.TweetResponse>) responseObserver);
          break;
        case METHODID_DELETE_TWEET:
          serviceImpl.deleteTweet((com.kwetter.messageService.proto.MessageServiceOuterClass.LikeTweetRequest) request,
              (io.grpc.stub.StreamObserver<com.kwetter.messageService.proto.MessageServiceOuterClass.SimpleResponse>) responseObserver);
          break;
        case METHODID_GET_TWEETS_BY_PROFILE_IDS:
          serviceImpl.getTweetsByProfileIds((com.kwetter.messageService.proto.MessageServiceOuterClass.TweetsByProfileRequest) request,
              (io.grpc.stub.StreamObserver<com.kwetter.messageService.proto.MessageServiceOuterClass.TweetsResponse>) responseObserver);
          break;
        case METHODID_LIKE:
          serviceImpl.like((com.kwetter.messageService.proto.MessageServiceOuterClass.LikeTweetRequest) request,
              (io.grpc.stub.StreamObserver<com.kwetter.messageService.proto.MessageServiceOuterClass.SimpleResponse>) responseObserver);
          break;
        case METHODID_UNLIKE:
          serviceImpl.unlike((com.kwetter.messageService.proto.MessageServiceOuterClass.LikeTweetRequest) request,
              (io.grpc.stub.StreamObserver<com.kwetter.messageService.proto.MessageServiceOuterClass.SimpleResponse>) responseObserver);
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
        METHOD_CREATE_NEW_TWEET,
        METHOD_EDIT_TWEET,
        METHOD_DELETE_TWEET,
        METHOD_GET_TWEETS_BY_PROFILE_IDS,
        METHOD_LIKE,
        METHOD_UNLIKE);
  }

}
