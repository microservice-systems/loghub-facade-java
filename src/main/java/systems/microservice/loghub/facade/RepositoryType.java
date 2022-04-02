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
public enum RepositoryType {
    GITHUB((byte) 1),
    GITLAB((byte) 2),
    BITBUCKET((byte) 3);

    private static final Map<Byte, RepositoryType> repositoryTypes = createRepositoryTypes();

    public final byte id;

    RepositoryType(byte id) {
        this.id = id;
    }

    private static Map<Byte, RepositoryType> createRepositoryTypes() {
        Map<Byte, RepositoryType> rts = new HashMap<>(32);
        rts.put(GITHUB.id, GITHUB);
        rts.put(GITLAB.id, GITLAB);
        rts.put(BITBUCKET.id, BITBUCKET);
        return rts;
    }

    public static RepositoryType get(byte id) {
        return repositoryTypes.get(id);
    }
}
