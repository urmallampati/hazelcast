/*
 * Copyright (c) 2008-2018, Hazelcast, Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hazelcast.internal.config;

import com.hazelcast.config.MultiMapConfig;
import com.hazelcast.test.HazelcastParametersRunnerFactory;
import com.hazelcast.test.annotation.ParallelTest;
import com.hazelcast.test.annotation.QuickTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.UseParametersRunnerFactory;

import static com.hazelcast.internal.config.ConfigValidator.checkMultiMapConfig;

@RunWith(Parameterized.class)
@UseParametersRunnerFactory(HazelcastParametersRunnerFactory.class)
@Category({QuickTest.class, ParallelTest.class})
public class ConfigValidationMergePolicyMultiMapTest extends AbstractConfigValidatorMergePolicyTest {

    private MultiMapConfig multiMapConfig = new MultiMapConfig("ConfigValidationMergePolicyMultiMapTest");

    @Test
    public void testConfig_withEnabledStatisticsEnabled() {
        multiMapConfig
                .setStatisticsEnabled(true)
                .setMergePolicyConfig(mergePolicyConfig);

        expectedExceptions();
        checkMultiMapConfig(multiMapConfig);
    }

    @Test
    public void testConfig_withDisabledStatistics() {
        multiMapConfig
                .setStatisticsEnabled(false)
                .setMergePolicyConfig(mergePolicyConfig);

        expectExceptionsWithoutStatistics();
        checkMultiMapConfig(multiMapConfig);
    }
}
