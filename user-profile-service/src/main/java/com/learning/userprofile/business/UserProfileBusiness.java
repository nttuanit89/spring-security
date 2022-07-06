package com.learning.userprofile.business;

import com.learning.common.crud.repository.RepoHelper;
import com.learning.proto.userprofile.UpsertUserProfile;
import com.learning.userprofile.entity.UserProfile;
import com.learning.userprofile.mapper.UserProfileMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import static org.apache.commons.lang3.StringUtils.isEmpty;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class UserProfileBusiness {
  private final RepoHelper repoHelper;
  private final UserProfileMapper mapper;

  public UserProfile upsertUserProfile(UpsertUserProfile request) {
    UserProfile profile =
        isEmpty(request.getUserProfile().getId()) ? insertUP(request) : updateUP(request);
    if (profile == null) {
      return UserProfile.builder().build();
    }
    return repoHelper.get(UserProfile.class).save(profile);
  }

  private UserProfile insertUP(UpsertUserProfile request) {
    return mapper.toNewUP(request.getUserProfile());
  }

  private UserProfile updateUP(UpsertUserProfile request) {
    var opProfile = repoHelper.get(UserProfile.class).findById(request.getUserProfile().getId());
    opProfile.ifPresent(p -> mapper.fillProfile(p, request.getUserProfile()));
    return opProfile.orElse(null);
  }
}
