/*
 * Copyright 2024 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.ondevicepersonalization.federatedcompute.shuffler.common.config.gcp;

import com.google.common.base.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/** GCP parameter configuration */
@Configuration
public class GcpParameterConfig {

  private static final Logger logger = LoggerFactory.getLogger(GcpParameterConfig.class);
  private final GoogleCloudArgs googleCloudArgs;
  private final SecurityArgs securityArgs;
  private final GcpParameterClient gcpParameterClient;

  public GcpParameterConfig(
      GoogleCloudArgs googleCloudArgs,
      SecurityArgs securityArgs,
      GcpParameterClient gcpParameterClient) {
    this.googleCloudArgs = googleCloudArgs;
    this.securityArgs = securityArgs;
    this.gcpParameterClient = gcpParameterClient;
  }

  @Bean
  @Qualifier("spannerInstance")
  public String spannerInstance() {
    String spannerInstance = googleCloudArgs.getSpannerInstance();
    if (Strings.isNullOrEmpty(spannerInstance)) {
      spannerInstance = gcpParameterClient.getParameter("SPANNER_INSTANCE").orElse(null);
    }
    logger.info("Registering spannerInstance parameter as: " + spannerInstance);
    return spannerInstance;
  }

  @Bean
  @Qualifier("lockDatabaseName")
  public String lockDatabaseName() {
    String lockDatabaseName = googleCloudArgs.getTaskDatabaseName();
    if (Strings.isNullOrEmpty(lockDatabaseName)) {
      lockDatabaseName = gcpParameterClient.getParameter("LOCK_DATABASE_NAME").orElse(null);
    }
    logger.info("Registering lockDatabaseName parameter as: " + lockDatabaseName);
    return lockDatabaseName;
  }

  @Bean
  @Qualifier("taskDatabaseName")
  public String taskDatabaseName() {
    String taskDatabaseName = googleCloudArgs.getTaskDatabaseName();
    if (Strings.isNullOrEmpty(taskDatabaseName)) {
      taskDatabaseName = gcpParameterClient.getParameter("TASK_DATABASE_NAME").orElse(null);
    }
    logger.info("Registering taskDatabaseName parameter as: " + taskDatabaseName);
    return taskDatabaseName;
  }

  @Bean
  @Qualifier("clientGradientBucketTemplate")
  public String clientGradientBucketTemplate() {
    String clientGradientBucketTemplate = googleCloudArgs.getClientGradientBucketTemplate();
    if (Strings.isNullOrEmpty(clientGradientBucketTemplate)) {
      clientGradientBucketTemplate =
          gcpParameterClient.getParameter("CLIENT_GRADIENT_BUCKET_TEMPLATE").orElse(null);
    }
    logger.info(
        "Registering clientGradientBucketTemplate parameter as: " + clientGradientBucketTemplate);
    return clientGradientBucketTemplate;
  }

  @Bean
  @Qualifier("aggregatedGradientBucketTemplate")
  public String aggregatedGradientBucketTemplate() {
    String aggregatedGradientBucketTemplate = googleCloudArgs.getAggregatedGradientBucketTemplate();
    if (Strings.isNullOrEmpty(aggregatedGradientBucketTemplate)) {
      aggregatedGradientBucketTemplate =
          gcpParameterClient.getParameter("AGGREGATED_GRADIENT_BUCKET_TEMPLATE").orElse(null);
    }
    logger.info(
        "Registering aggregatedGradientBucketTemplate parameter as: "
            + aggregatedGradientBucketTemplate);
    return aggregatedGradientBucketTemplate;
  }

  @Bean
  @Qualifier("modelBucketTemplate")
  public String modelBucketTemplate() {
    String modelBucketTemplate = googleCloudArgs.getModelBucketTemplate();
    if (Strings.isNullOrEmpty(modelBucketTemplate)) {
      modelBucketTemplate = gcpParameterClient.getParameter("MODEL_BUCKET_TEMPLATE").orElse(null);
    }
    logger.info("Registering modelBucketTemplate parameter as: " + modelBucketTemplate);
    return modelBucketTemplate;
  }

  @Bean
  @Qualifier("modelUpdaterPubsubTopic")
  public String modelUpdaterPubsubTopic() {
    String modelUpdaterPubsubTopic = googleCloudArgs.getModelUpdaterPubsubTopic();
    if (Strings.isNullOrEmpty(modelUpdaterPubsubTopic)) {
      modelUpdaterPubsubTopic =
          gcpParameterClient.getParameter("MODEL_UPDATER_PUBSUB_TOPIC").orElse(null);
    }
    logger.info("Registering modelUpdaterPubsubTopic parameter as: " + modelUpdaterPubsubTopic);
    return modelUpdaterPubsubTopic;
  }

  @Bean
  @Qualifier("aggregatorPubsubSubscription")
  public String aggregatorPubsubSubscription() {
    String aggregatorPubsubSubscription = googleCloudArgs.getAggregatorPubsubSubscription();
    if (Strings.isNullOrEmpty(aggregatorPubsubSubscription)) {
      aggregatorPubsubSubscription =
          gcpParameterClient.getParameter("AGGREGATOR_PUBSUB_SUBSCRIPTION").orElse(null);
    }
    logger.info(
        "Registering aggregatorPubsubSubscription parameter as: " + aggregatorPubsubSubscription);
    return aggregatorPubsubSubscription;
  }

  @Bean
  @Qualifier("aggregatorPubsubTopic")
  public String aggregatorPubsubTopic() {
    String aggregatorPubsubTopic = googleCloudArgs.getAggregatorPubsubTopic();
    if (Strings.isNullOrEmpty(aggregatorPubsubTopic)) {
      aggregatorPubsubTopic =
          gcpParameterClient.getParameter("AGGREGATOR_PUBSUB_TOPIC").orElse(null);
    }
    logger.info("Registering aggregatorPubsubTopic parameter as: " + aggregatorPubsubTopic);
    return aggregatorPubsubTopic;
  }

  @Bean
  @Qualifier("modelUpdaterPubsubSubscription")
  public String modelUpdaterPubsubSubscription() {
    String modelUpdaterPubsubSubscription = googleCloudArgs.getModelUpdaterPubsubSubscription();
    if (Strings.isNullOrEmpty(modelUpdaterPubsubSubscription)) {
      modelUpdaterPubsubSubscription =
          gcpParameterClient.getParameter("MODEL_UPDATER_PUBSUB_SUBSCRIPTION").orElse(null);
    }
    logger.info(
        "Registering modelUpdaterPubsubSubscription parameter as: "
            + modelUpdaterPubsubSubscription);
    return modelUpdaterPubsubSubscription;
  }

  @Bean
  @Qualifier("encryptionKeyServiceABaseUrl")
  public String encryptionKeyServiceABaseUrl() {
    String encryptionKeyServiceABaseUrl = googleCloudArgs.getEncryptionKeyServiceABaseUrl();
    if (Strings.isNullOrEmpty(encryptionKeyServiceABaseUrl)) {
      encryptionKeyServiceABaseUrl =
          gcpParameterClient.getParameter("ENCRYPTION_KEY_SERVICE_A_BASE_URL").orElse(null);
    }
    logger.info(
        "Registering encryptionKeyServiceABaseUrl parameter as: " + encryptionKeyServiceABaseUrl);
    return encryptionKeyServiceABaseUrl;
  }

  @Bean
  @Qualifier("encryptionKeyServiceBBaseUrl")
  public String encryptionKeyServiceBBaseUrl() {
    String encryptionKeyServiceBBaseUrl = googleCloudArgs.getEncryptionKeyServiceBBaseUrl();
    if (Strings.isNullOrEmpty(encryptionKeyServiceBBaseUrl)) {
      encryptionKeyServiceBBaseUrl =
          gcpParameterClient.getParameter("ENCRYPTION_KEY_SERVICE_B_BASE_URL").orElse(null);
    }
    logger.info(
        "Registering encryptionKeyServiceBBaseUrl parameter as: " + encryptionKeyServiceBBaseUrl);
    return encryptionKeyServiceBBaseUrl;
  }

  @Bean
  @Qualifier("encryptionKeyServiceACloudfunctionUrl")
  public String encryptionKeyServiceACloudfunctionUrl() {
    String encryptionKeyServiceACloudfunctionUrl =
        googleCloudArgs.getEncryptionKeyServiceACloudfunctionUrl();
    if (Strings.isNullOrEmpty(encryptionKeyServiceACloudfunctionUrl)) {
      encryptionKeyServiceACloudfunctionUrl =
          gcpParameterClient
              .getParameter("ENCRYPTION_KEY_SERVICE_A_CLOUDFUNCTION_URL")
              .orElse(null);
    }
    logger.info(
        "Registering encryptionKeyServiceACloudfunctionUrl parameter as: "
            + encryptionKeyServiceACloudfunctionUrl);
    return encryptionKeyServiceACloudfunctionUrl;
  }

  @Bean
  @Qualifier("encryptionKeyServiceBCloudfunctionUrl")
  public String encryptionKeyServiceBCloudfunctionUrl() {
    String encryptionKeyServiceBCloudfunctionUrl =
        googleCloudArgs.getEncryptionKeyServiceBCloudfunctionUrl();
    if (Strings.isNullOrEmpty(encryptionKeyServiceBCloudfunctionUrl)) {
      encryptionKeyServiceBCloudfunctionUrl =
          gcpParameterClient
              .getParameter("ENCRYPTION_KEY_SERVICE_B_CLOUDFUNCTION_URL")
              .orElse(null);
    }
    logger.info(
        "Registering encryptionKeyServiceBCloudfunctionUrl parameter as: "
            + encryptionKeyServiceBCloudfunctionUrl);
    return encryptionKeyServiceBCloudfunctionUrl;
  }

  @Bean
  @Qualifier("wipProviderA")
  public String wipProviderA() {
    String wipProviderA = googleCloudArgs.getWipProviderA();
    if (Strings.isNullOrEmpty(wipProviderA)) {
      wipProviderA = gcpParameterClient.getParameter("WIP_PROVIDER_A").orElse(null);
    }
    logger.info("Registering wipProviderA parameter as: " + wipProviderA);
    return wipProviderA;
  }

  @Bean
  @Qualifier("wipProviderB")
  public String wipProviderB() {
    String wipProviderB = googleCloudArgs.getWipProviderB();
    if (Strings.isNullOrEmpty(wipProviderB)) {
      wipProviderB = gcpParameterClient.getParameter("WIP_PROVIDER_B").orElse(null);
    }
    logger.info("Registering wipProviderB parameter as: " + wipProviderB);
    return wipProviderB;
  }

  @Bean
  @Qualifier("serviceAccountA")
  public String serviceAccountA() {
    String serviceAccountA = googleCloudArgs.getServiceAccountA();
    if (Strings.isNullOrEmpty(serviceAccountA)) {
      serviceAccountA = gcpParameterClient.getParameter("SERVICE_ACCOUNT_A").orElse(null);
    }
    logger.info("Registering serviceAccountA parameter as: " + serviceAccountA);
    return serviceAccountA;
  }

  @Bean
  @Qualifier("serviceAccountB")
  public String serviceAccountB() {
    String serviceAccountB = googleCloudArgs.getServiceAccountB();
    if (Strings.isNullOrEmpty(serviceAccountB)) {
      serviceAccountB = gcpParameterClient.getParameter("SERVICE_ACCOUNT_B").orElse(null);
    }
    logger.info("Registering serviceAccountB parameter as: " + serviceAccountB);
    return serviceAccountB;
  }

  @Bean
  @Qualifier("publicKeyServiceBaseUrl")
  public String publicKeyServiceBaseUrl() {
    String publicKeyServiceBaseUrl = googleCloudArgs.getPublicKeyServiceBaseUrl();
    if (Strings.isNullOrEmpty(publicKeyServiceBaseUrl)) {
      publicKeyServiceBaseUrl =
          gcpParameterClient.getParameter("PUBLIC_KEY_SERVICE_BASE_URL").orElse(null);
    }
    logger.info("Registering publicKeyServiceBaseUrl parameter as: " + publicKeyServiceBaseUrl);
    return publicKeyServiceBaseUrl;
  }

  @Bean
  @Qualifier("keyAttestationServiceBaseUrl")
  public String keyAttestationServiceBaseUrl() {
    String keyAttestationValidationUrl = securityArgs.getKeyAttestationServiceBaseUrl();
    if (Strings.isNullOrEmpty(keyAttestationValidationUrl)) {
      keyAttestationValidationUrl =
          gcpParameterClient.getParameter("KEY_ATTESTATION_VALIDATION_URL").orElse(null);
    }
    logger.info(
        "Registering keyAttestationValidationUrl parameter as: " + keyAttestationValidationUrl);
    return keyAttestationValidationUrl;
  }

  @Bean
  @Qualifier("keyAttestationApiKey")
  public String keyAttestationApiKey() {
    String keyAttestationApiKey = securityArgs.getKeyAttestationApiKey();
    if (Strings.isNullOrEmpty(keyAttestationApiKey)) {
      keyAttestationApiKey =
          gcpParameterClient.getParameter("KEY_ATTESTATION_API_KEY").orElse(null);
    }
    logger.info("Registering keyAttestationApiKey parameter as: " + keyAttestationApiKey);
    return keyAttestationApiKey;
  }

  @Bean
  @Qualifier("isAuthenticationEnabled")
  public Boolean isAuthenticationEnabled() {
    Boolean isAuthenticationEnabled = securityArgs.getIsAuthenticationEnabled();
    if (isAuthenticationEnabled == null) {
      isAuthenticationEnabled =
          Boolean.parseBoolean(
              gcpParameterClient.getParameter("IS_AUTHENTICATION_ENABLED").orElse(null));
    }
    logger.info("Registering isAuthenticationEnabled parameter as: " + isAuthenticationEnabled);
    return isAuthenticationEnabled;
  }

  @Bean
  @Qualifier("downloadPlanTokenDurationInSecond")
  public Long downloadPlanTokenDurationInSecond() {
    Long downloadPlanTokenDuration = googleCloudArgs.getDownloadPlanTokenDurationInSecond();
    if (downloadPlanTokenDuration == null) {
      downloadPlanTokenDuration =
          Long.parseLong(
              gcpParameterClient.getParameter("DOWNLOAD_PLAN_TOKEN_DURATION").orElse("900"));
    }
    logger.info(
        "Registering downloadPlanTokenDurationInSecond parameter as: " + downloadPlanTokenDuration);
    return downloadPlanTokenDuration;
  }

  @Bean
  @Qualifier("downloadCheckpointTokenDurationInSecond")
  public Long downloadCheckpointTokenDurationInSecond() {
    Long downloadCheckpointTokenDuration =
        googleCloudArgs.getDownloadCheckpointTokenDurationInSecond();
    if (downloadCheckpointTokenDuration == null) {
      downloadCheckpointTokenDuration =
          Long.parseLong(
              gcpParameterClient.getParameter("DOWNLOAD_CHECKPOINT_TOKEN_DURATION").orElse("900"));
    }
    logger.info(
        "Registering downloadCheckpointTokenDurationInSecond parameter as: "
            + downloadCheckpointTokenDuration);
    return downloadCheckpointTokenDuration;
  }

  @Bean
  @Qualifier("uploadGradientTokenDurationInSecond")
  public Long uploadGradientTokenDurationInSecond() {
    Long uploadGradientTokenDuration = googleCloudArgs.getUploadGradientTokenDurationInSecond();
    if (uploadGradientTokenDuration == null) {
      uploadGradientTokenDuration =
          Long.parseLong(
              gcpParameterClient.getParameter("UPLOAD_GRADIENT_TOKEN_DURATION").orElse("900"));
    }
    logger.info(
        "Registering uploadGradientTokenDurationInSecond parameter as: "
            + uploadGradientTokenDuration);
    return uploadGradientTokenDuration;
  }

  @Bean
  @Qualifier("localComputeTimeoutMinutes")
  public int localComputeTimeoutMinutes() {
    int localComputeTimeoutMinutes = googleCloudArgs.getLocalComputeTimeoutMinutes();
    if (localComputeTimeoutMinutes <= 0) {
      localComputeTimeoutMinutes =
          Integer.parseInt(
              gcpParameterClient.getParameter("LOCAL_COMPUTE_TIMEOUT_MINUTES").orElse("15"));
    }
    logger.info(
        "Registering localComputeTimeoutMinutes parameter as: " + localComputeTimeoutMinutes);
    return localComputeTimeoutMinutes;
  }

  @Bean
  @Qualifier("uploadTimeoutMinutes")
  public int uploadTimeoutMinutes() {
    int uploadTimeoutMinutes = googleCloudArgs.getUploadTimeoutMinutes();
    if (uploadTimeoutMinutes <= 0) {
      uploadTimeoutMinutes =
          Integer.parseInt(gcpParameterClient.getParameter("UPLOAD_TIMEOUT_MINUTES").orElse("15"));
    }
    logger.info("Registering uploadTimeoutMinutes parameter as: " + uploadTimeoutMinutes);
    return uploadTimeoutMinutes;
  }

  @Bean
  @Qualifier("modelUpdaterSubscriberMaxOutstandingElementCount")
  public long modelUpdaterSubscriberMaxOutstandingElementCount() {
    long modelUpdaterSubscriberMaxOutstandingElementCount =
        googleCloudArgs.getModelUpdaterSubscriberMaxOutstandingElementCount();
    if (modelUpdaterSubscriberMaxOutstandingElementCount <= 0) {
      modelUpdaterSubscriberMaxOutstandingElementCount =
          Long.parseLong(
              gcpParameterClient
                  .getParameter("MODEL_UPDATER_SUBSCRIBER_MAX_OUTSTANDING_ELEMENT_COUNT")
                  .orElse("2"));
    }
    logger.info(
        "Registering modelUpdaterSubscriberMaxOutstandingElementCount parameter as: "
            + modelUpdaterSubscriberMaxOutstandingElementCount);
    return modelUpdaterSubscriberMaxOutstandingElementCount;
  }

  @Bean
  @Qualifier("aggregatorSubscriberMaxOutstandingElementCount")
  public long aggregatorSubscriberMaxOutstandingElementCount() {
    long aggregatorSubscriberMaxOutstandingElementCount =
        googleCloudArgs.getAggregatorSubscriberMaxOutstandingElementCount();
    if (aggregatorSubscriberMaxOutstandingElementCount <= 0) {
      aggregatorSubscriberMaxOutstandingElementCount =
          Long.parseLong(
              gcpParameterClient
                  .getParameter("AGGREGATOR_SUBSCRIBER_MAX_OUTSTANDING_ELEMENT_COUNT")
                  .orElse("2"));
    }
    logger.info(
        "Registering aggregatorSubscriberMaxOutstandingElementCount parameter as: "
            + aggregatorSubscriberMaxOutstandingElementCount);
    return aggregatorSubscriberMaxOutstandingElementCount;
  }

  @Bean
  @Qualifier("collectorBatchSize")
  public int collectorBatchSize() {
    int collectorBatchSize = googleCloudArgs.getCollectorBatchSize();
    if (collectorBatchSize <= 0) {
      collectorBatchSize =
          Integer.parseInt(gcpParameterClient.getParameter("COLLECTOR_BATCH_SIZE").orElse("50"));
    }
    logger.info("Registering collectorBatchSize parameter as: " + collectorBatchSize);
    return collectorBatchSize;
  }
}
