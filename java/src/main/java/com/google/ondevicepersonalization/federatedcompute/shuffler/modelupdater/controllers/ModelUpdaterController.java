// Copyright 2024 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
//
////////////////////////////////////////////////////////////////////////////////

package com.google.ondevicepersonalization.federatedcompute.shuffler.modelupdater.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/** Model Updater controller. */
@RestController
public final class ModelUpdaterController {
  @GetMapping("/ready")
  public String ready() {
    // TODO(291594777): Implement readiness check.
    return "Greetings from Model Updater Spring Boot! Ready check. \n";
  }

  @GetMapping("/healthz")
  public String healthz() {
    // TODO(291594777): Implement health check.
    return "Greetings from Model Updater Spring Boot! Health check. \n";
  }
}