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

package com.google.ondevicepersonalization.federatedcompute.shuffler.common.tensorflow;

import com.google.fcp.aggregation.AggregationSession;
import com.google.fcp.plan.PhaseSessionV2;
import com.google.fcp.plan.PlanSession;
import com.google.fcp.plan.TensorflowPhaseSessionV2;
import com.google.fcp.plan.TensorflowPlanSession;
import com.google.protobuf.ByteString;
import org.springframework.stereotype.Component;

@Component
public class TensorflowPlanSessionFactory {
  public PlanSession createPlanSession(ByteString plan) {
    return new TensorflowPlanSession(plan);
  }

  public PhaseSessionV2 createPhaseSessionV2(ByteString plan) {
    return new TensorflowPhaseSessionV2(plan);
  }

  public AggregationSession createAggregationSession(byte[] plan) {
    return AggregationSession.createFromByteArray(plan);
  }
}
