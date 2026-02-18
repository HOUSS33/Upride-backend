package com.upride.platform.service;



import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.core.sync.RequestBody;

import java.net.URI;

@Service
public class SupabaseS3Service {

    @Value("${supabase.s3.endpoint}")
    private String endpoint;

    @Value("${supabase.s3.access-key}")
    private String accessKey;

    @Value("${supabase.s3.secret-key}")
    private String secretKey;

    @Value("${supabase.s3.bucket}")
    private String bucket;

    @Value("${supabase.s3.region}")
    private String region;

    // Create the S3 client once (do NOT create on every upload)
    private S3Client s3Client;

    private S3Client getS3Client() {
        if (s3Client == null) {
            s3Client = S3Client.builder()
                    .endpointOverride(URI.create(endpoint))
                    .credentialsProvider(
                            StaticCredentialsProvider.create(
                                    AwsBasicCredentials.create(accessKey, secretKey)
                            )
                    )
                    .region(Region.of(region))
                    .build();
        }
        return s3Client;
    }

    // Upload a file to Supabase S3
    public void upload(byte[] file, String key) {
        getS3Client().putObject(
                builder -> builder.bucket(bucket).key(key),
                RequestBody.fromBytes(file)
        );
    }

    // Optionally: get public URL (assuming your bucket is public)
    public String getPublicUrl(String key) {
        return endpoint + "/" + bucket + "/" + key;
    }
}


