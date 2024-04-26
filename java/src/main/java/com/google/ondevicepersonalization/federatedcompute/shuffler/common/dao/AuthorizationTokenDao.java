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

package com.google.ondevicepersonalization.federatedcompute.shuffler.common.dao;

public interface AuthorizationTokenDao {

  TokenStatus isTokenAuthorized(String token);

  TokenStatus insert(String token);

  enum TokenStatus {
    /**
     * There are internal errors so that the token status is unknown. The server would let the
     * device retry later.
     */
    UNKNOWN,
    /** The token is unauthorized. */
    UNAUTHORIZED,
    /** The token is authorized. */
    AUTHORIZED;
  }
}
