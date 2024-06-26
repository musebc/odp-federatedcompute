/**
 * Copyright 2023 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

################################################################################
# Global Variables.
################################################################################

variable "project_id" {
  description = "GCP Project ID in which this module will be created."
  type        = string
}

variable "environment" {
  description = "Description for the environment, e.g. dev, staging, production"
  type        = string
}

variable "region" {
  description = "Region where all services will be created."
  type        = string
}

variable "model_bucket_force_destroy" {
  description = "Whether to force destroy the bucket even if it is not empty."
  type        = bool
  nullable    = false
}

variable "model_bucket_versioning" {
  description = "Enable bucket versioning."
  type        = bool
  nullable    = false
}

variable "client_gradient_bucket_force_destroy" {
  description = "Whether to force destroy the bucket even if it is not empty."
  type        = bool
  nullable    = false
}

variable "client_gradient_bucket_versioning" {
  description = "Enable bucket versioning."
  type        = bool
  nullable    = false
}

variable "aggregated_gradient_bucket_force_destroy" {
  description = "Whether to force destroy the bucket even if it is not empty."
  type        = bool
  nullable    = false
}

variable "aggregated_gradient_bucket_versioning" {
  description = "Enable bucket versioning."
  type        = bool
  nullable    = false
}

# https://cloud.google.com/spanner/docs/pitr
# Must be between 1 hour and 7 days. Can be specified in days, hours, minutes, or seconds.
# eg: 1d, 24h, 1440m, and 86400s are equivalent.
variable "spanner_database_retention_period" {
  description = "Duration to maintain table versioning for point-in-time recovery."
  type        = string
  nullable    = false
}

variable "spanner_instance_config" {
  type        = string
  description = "Multi region config value for the Spanner Instance. Example: 'nam10' for North America."
}

variable "spanner_processing_units" {
  description = "Spanner's compute capacity. 1000 processing units = 1 node and must be set as a multiple of 100."
  type        = number
}

variable "spanner_database_deletion_protection" {
  description = "Prevents destruction of the Spanner database."
  type        = bool
}