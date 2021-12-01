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

package systems.microservice.loghub.facade.config;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Dmitry Kotlyarov
 * @since 1.0
 */
public abstract class Parser<T> {
    private static final ReentrantLock lock = new ReentrantLock(false);
    private static final AtomicReference<Map<Class<?>, Parser<?>>> parsers = new AtomicReference<>(createParsers());

    protected Parser() {
    }

    public abstract T parse(String value);

    private static Map<Class<?>, Parser<?>> createParsers() {
        Map<Class<?>, Parser<?>> ps = new HashMap<>(64);
        ps.put(Boolean.class, new Parser<Boolean>() {
            @Override
            public Boolean parse(String value) {
                return Boolean.valueOf(value);
            }
        });
        ps.put(Byte.class, new Parser<Byte>() {
            @Override
            public Byte parse(String value) {
                return Byte.valueOf(value);
            }
        });
        ps.put(Character.class, new Parser<Character>() {
            @Override
            public Character parse(String value) {
                return value.charAt(0);
            }
        });
        ps.put(Short.class, new Parser<Short>() {
            @Override
            public Short parse(String value) {
                return Short.valueOf(value);
            }
        });
        ps.put(Integer.class, new Parser<Integer>() {
            @Override
            public Integer parse(String value) {
                return Integer.valueOf(value);
            }
        });
        ps.put(Long.class, new Parser<Long>() {
            @Override
            public Long parse(String value) {
                return Long.valueOf(value);
            }
        });
        ps.put(Float.class, new Parser<Float>() {
            @Override
            public Float parse(String value) {
                return Float.valueOf(value);
            }
        });
        ps.put(Double.class, new Parser<Double>() {
            @Override
            public Double parse(String value) {
                return Double.valueOf(value);
            }
        });
        ps.put(UUID.class, new Parser<UUID>() {
            @Override
            public UUID parse(String value) {
                return UUID.fromString(value);
            }
        });
        ps.put(BigInteger.class, new Parser<BigInteger>() {
            @Override
            public BigInteger parse(String value) {
                return new BigInteger(value);
            }
        });
        ps.put(BigDecimal.class, new Parser<BigDecimal>() {
            @Override
            public BigDecimal parse(String value) {
                return new BigDecimal(value);
            }
        });
        ps.put(Boolean.class, new Parser<Boolean>() {
            @Override
            public Boolean parse(String value) {
                return Boolean.valueOf(value);
            }
        });
        ps.put(Boolean.class, new Parser<Boolean>() {
            @Override
            public Boolean parse(String value) {
                return Boolean.valueOf(value);
            }
        });
        ps.put(Boolean.class, new Parser<Boolean>() {
            @Override
            public Boolean parse(String value) {
                return Boolean.valueOf(value);
            }
        });
        ps.put(Boolean.class, new Parser<Boolean>() {
            @Override
            public Boolean parse(String value) {
                return Boolean.valueOf(value);
            }
        });
        ps.put(Boolean.class, new Parser<Boolean>() {
            @Override
            public Boolean parse(String value) {
                return Boolean.valueOf(value);
            }
        });
        ps.put(Boolean.class, new Parser<Boolean>() {
            @Override
            public Boolean parse(String value) {
                return Boolean.valueOf(value);
            }
        });
        ps.put(Boolean.class, new Parser<Boolean>() {
            @Override
            public Boolean parse(String value) {
                return Boolean.valueOf(value);
            }
        });
        ps.put(Boolean.class, new Parser<Boolean>() {
            @Override
            public Boolean parse(String value) {
                return Boolean.valueOf(value);
            }
        });
        ps.put(Boolean.class, new Parser<Boolean>() {
            @Override
            public Boolean parse(String value) {
                return Boolean.valueOf(value);
            }
        });
        ps.put(Boolean.class, new Parser<Boolean>() {
            @Override
            public Boolean parse(String value) {
                return Boolean.valueOf(value);
            }
        });
        ps.put(Boolean.class, new Parser<Boolean>() {
            @Override
            public Boolean parse(String value) {
                return Boolean.valueOf(value);
            }
        });
        ps.put(Boolean.class, new Parser<Boolean>() {
            @Override
            public Boolean parse(String value) {
                return Boolean.valueOf(value);
            }
        });
        ps.put(Boolean.class, new Parser<Boolean>() {
            @Override
            public Boolean parse(String value) {
                return Boolean.valueOf(value);
            }
        });
        ps.put(Boolean.class, new Parser<Boolean>() {
            @Override
            public Boolean parse(String value) {
                return Boolean.valueOf(value);
            }
        });
        ps.put(Boolean.class, new Parser<Boolean>() {
            @Override
            public Boolean parse(String value) {
                return Boolean.valueOf(value);
            }
        });
        ps.put(Boolean.class, new Parser<Boolean>() {
            @Override
            public Boolean parse(String value) {
                return Boolean.valueOf(value);
            }
        });
        ps.put(Boolean.class, new Parser<Boolean>() {
            @Override
            public Boolean parse(String value) {
                return Boolean.valueOf(value);
            }
        });
        ps.put(Boolean.class, new Parser<Boolean>() {
            @Override
            public Boolean parse(String value) {
                return Boolean.valueOf(value);
            }
        });
        ps.put(Boolean.class, new Parser<Boolean>() {
            @Override
            public Boolean parse(String value) {
                return Boolean.valueOf(value);
            }
        });
        return ps;
    }
}
