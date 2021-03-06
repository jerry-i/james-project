/****************************************************************
 * Licensed to the Apache Software Foundation (ASF) under one   *
 * or more contributor license agreements.  See the NOTICE file *
 * distributed with this work for additional information        *
 * regarding copyright ownership.  The ASF licenses this file   *
 * to you under the Apache License, Version 2.0 (the            *
 * "License"); you may not use this file except in compliance   *
 * with the License.  You may obtain a copy of the License at   *
 *                                                              *
 *   http://www.apache.org/licenses/LICENSE-2.0                 *
 *                                                              *
 * Unless required by applicable law or agreed to in writing,   *
 * software distributed under the License is distributed on an  *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY       *
 * KIND, either express or implied.  See the License for the    *
 * specific language governing permissions and limitations      *
 * under the License.                                           *
 ****************************************************************/

package org.apache.james.onami.lifecycle;

import java.io.Closeable;
import java.lang.annotation.Annotation;
import java.util.concurrent.ExecutorService;

/**
 * {@link org.apache.onami.lifecycle.core.Stager} that disposes resources.
 *
 * @author Mikhail Mazursky
 */
public interface DisposingStager<A extends Annotation> extends Stager<A> {

    /**
     * Register an {@link java.util.concurrent.ExecutorService} to be staged.
     *
     * @param executorService object to be staged to dispose resources.
     * @return Staged object
     */
    <T extends ExecutorService> T register(T executorService);

    /**
     * Register a {@link java.io.Closeable} to be staged.
     *
     * @param closeable object to be staged to dispose resources.
     * @return Staged object
     */
    <T extends Closeable> T register(T closeable);

}
