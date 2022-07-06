package com.learning.userprofile.mapper;

import com.learning.common.mapper.DefaultGrpcV2Config;
import com.learning.proto.userprofile.UserProfileResponse;
import com.learning.userprofile.entity.UserProfile;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;

@Mapper(config = DefaultGrpcV2Config.class)
public interface UserProfileMapper {
  @Mapping(target = "results", source = "profile", qualifiedByName = "toUP")
  @Mapping(target = "status", ignore = true)
  UserProfileResponse toUPRes(UserProfile profile);

  @Named("toUP")
  com.learning.proto.userprofile.UserProfile toUP(UserProfile profile);

  UserProfile toNewUP(com.learning.proto.userprofile.UserProfile profile);

  void fillProfile(
      @MappingTarget UserProfile target, com.learning.proto.userprofile.UserProfile source);
}
