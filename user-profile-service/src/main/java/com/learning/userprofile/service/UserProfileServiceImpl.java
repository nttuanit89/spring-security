package com.learning.userprofile.service;

import com.learning.common.grpc.IService;
import com.learning.proto.userprofile.UpsertUserProfile;
import com.learning.proto.userprofile.UserProfileResponse;
import com.learning.proto.userprofile.UserProfileServiceGrpc;
import com.learning.userprofile.business.UserProfileBusiness;
import com.learning.userprofile.entity.UserProfile;
import com.learning.userprofile.mapper.UserProfileMapper;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.lognet.springboot.grpc.GRpcService;

@RequiredArgsConstructor
@GRpcService
@Slf4j
public class UserProfileServiceImpl extends UserProfileServiceGrpc.UserProfileServiceImplBase
    implements IService {
  private final UserProfileBusiness business;
  private final UserProfileMapper mapper;

  @Override
  public void upsertUserProfile(
      UpsertUserProfile request, StreamObserver<UserProfileResponse> response) {
    response(() -> upsertUserProfile(request), UserProfileResponse.class, response);
  }

  private UserProfileResponse upsertUserProfile(UpsertUserProfile request) {
    UserProfile profile = business.upsertUserProfile(request);
    return mapper.toUPRes(profile);
  }
}
