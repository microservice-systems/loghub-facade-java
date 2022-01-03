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

import systems.microservice.loghub.facade.config.Validator;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author Dmitry Kotlyarov
 * @since 1.0
 */
public final class ThreadManager {
    private static final AtomicBoolean alive = new AtomicBoolean(true);
    private static final AtomicBoolean terminated = new AtomicBoolean(false);
    private static final Semaphore sema = createSema();
    private static final AtomicLong count = new AtomicLong(0L);

    private ThreadManager() {
    }

    private static Semaphore createSema() {
        try {
            Semaphore s = new Semaphore(1, false);
            s.acquire();
            return s;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean isAlive() {
        return alive.get();
    }

    public static boolean isTerminated() {
        return terminated.get();
    }

    public static boolean sleep(long millis) {
        Validator.inRangeLong("millis", millis, 0L, Long.MAX_VALUE);

        if (alive.get()) {
            try {
                if (sema.tryAcquire(millis, TimeUnit.MILLISECONDS)) {
                    try {
                        return false;
                    } finally {
                        sema.release();
                    }
                } else {
                    return true;
                }
            } catch (InterruptedException e) {
                return true;
            }
        } else {
            return false;
        }
    }

    public static boolean shutdown() {
        if (alive.get()) {
            if (alive.compareAndSet(true, false)) {
                sema.release();
                return true;
            }
        }
        return false;
    }
}
