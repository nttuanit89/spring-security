package com.learning.userprofile;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.retry.annotation.EnableRetry;

@SpringBootApplication(scanBasePackages = "com.learning")
@ConfigurationPropertiesScan(basePackages = "com.learning")
@EnableRetry
@EntityScan(basePackages = {"com.learning.common.crud", "com.learning.**.entity"})
public class UserProfileServiceApplication {
}
