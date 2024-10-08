/**
 * Copyright 2024 Google LLC
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

output "task_management_name" {
  description = "Name of task management cloud run deployment"
  value       = google_cloud_run_v2_service.taskmanagement.name
}

output "task_management_url" {
  description = "URL of the task management service. The terraform may need to be re-run if blank to populate."
  value       = google_cloud_run_v2_service.taskmanagement.uri
}