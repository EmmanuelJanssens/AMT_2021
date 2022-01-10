package com.amt.mygarden.config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AmazonConfig {
    @Value("${s3.key.id}")
    private String accessKeyId;

    @Value("${s3.key.secret}")
    private String accessKeySecret;

    @Value("${s3.region.name}")
    private String s3RegionName;

    @Bean
    public AmazonS3 s3() {
        AWSCredentials awsCredentials = new BasicAWSCredentials(accessKeyId, accessKeySecret);
        return AmazonS3ClientBuilder
                .standard()
                .withRegion(s3RegionName)
                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
                .build();
    }
}
