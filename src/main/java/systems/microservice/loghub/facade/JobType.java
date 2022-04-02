/*
 * Copyright (C) 2020 Microservice Systems, Inc.
 * All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package systems.microservice.loghub.facade;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Dmitry Kotlyarov
 * @since 1.0
 */
public enum JobType {
    GITHUB((byte) 1),
    GITLAB((byte) 2),
    BITBUCKET((byte) 3),
    JENKINS((byte) 4),
    TEAMCITY((byte) 5),
    BAMBOO((byte) 6),
    CIRCLECI((byte) 7),
    BUDDY((byte) 8),
    TRAVISCI((byte) 9),
    CODESHIP((byte) 10),
    GOCD((byte) 11),
    WERCKER((byte) 12),
    SEMAPHORE((byte) 13),
    CODEMAGIC((byte) 14),
    SPINNAKER((byte) 15),
    BUILDBOT((byte) 16);

    private static final Map<Byte, JobType> jobTypes = createJobTypes();

    public final byte id;

    JobType(byte id) {
        this.id = id;
    }

    private static Map<Byte, JobType> createJobTypes() {
        Map<Byte, JobType> jts = new HashMap<>(32);
        jts.put(GITHUB.id, GITHUB);
        jts.put(GITLAB.id, GITLAB);
        jts.put(BITBUCKET.id, BITBUCKET);
        jts.put(JENKINS.id, JENKINS);
        jts.put(TEAMCITY.id, TEAMCITY);
        jts.put(BAMBOO.id, BAMBOO);
        jts.put(CIRCLECI.id, CIRCLECI);
        jts.put(BUDDY.id, BUDDY);
        jts.put(TRAVISCI.id, TRAVISCI);
        jts.put(CODESHIP.id, CODESHIP);
        jts.put(GOCD.id, GOCD);
        jts.put(WERCKER.id, WERCKER);
        jts.put(SEMAPHORE.id, SEMAPHORE);
        jts.put(CODEMAGIC.id, CODEMAGIC);
        jts.put(SPINNAKER.id, SPINNAKER);
        jts.put(BUILDBOT.id, BUILDBOT);
        return jts;
    }

    public static JobType get(byte id) {
        return jobTypes.get(id);
    }
}
