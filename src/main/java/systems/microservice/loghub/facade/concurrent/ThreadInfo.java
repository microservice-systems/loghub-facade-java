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

package systems.microservice.loghub.facade.concurrent;

import systems.microservice.loghub.facade.Tag;
import systems.microservice.loghub.facade.config.Validator;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.UUID;

/**
 * @author Dmitry Kotlyarov
 * @since 1.0
 */
public final class ThreadInfo {
    private static final ThreadLocal<ThreadInfo> info = ThreadLocal.withInitial(() -> new ThreadInfo());

    public final UUID guid;
    public final Thread thread;
    public final SecureRandom random;
    public final LinkedHashMap<String, ArrayList<Tag>> tags;
    public int depth;

    private ThreadInfo() {
        this.guid = UUID.randomUUID();
        this.thread = Thread.currentThread();
        this.random = new SecureRandom();
        this.tags = new LinkedHashMap<>(64);
        this.depth = 0;
    }

    public Tag getTag(String key) {
        Validator.notNull("key", key);

        ArrayList<Tag> ts = tags.get(key);
        if (ts != null) {
            return ts.get(ts.size() - 1);
        } else {
            return null;
        }
    }

    public Tag addTag(Tag tag) {
        Validator.notNull("tag", tag);

        ArrayList<Tag> ts = tags.get(tag.key);
        if (ts == null) {
            ts = new ArrayList<>(16);
            tags.put(tag.key, ts);
        }
        ts.add(tag);
        return tag;
    }

    public Tag addTag(String key, Object value) {
        return addTag(new Tag(key, value));
    }

    public Tag addTag(String key, Object value, String unit) {
        return addTag(new Tag(key, value, unit));
    }

    public Tag removeTag(String key) {
        Validator.notNull("key", key);

        ArrayList<Tag> ts = tags.get(key);
        if (ts != null) {
            Tag t = ts.remove(ts.size() - 1);
            if (ts.isEmpty()) {
                tags.remove(key);
            }
            return t;
        } else {
            return null;
        }
    }

    public static ThreadInfo get() {
        return info.get();
    }
}