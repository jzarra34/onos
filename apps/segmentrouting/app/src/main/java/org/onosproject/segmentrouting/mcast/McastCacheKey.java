/*
 * Copyright 2018-present Open Networking Foundation
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

package org.onosproject.segmentrouting.mcast;

import org.onlab.packet.IpAddress;
import org.onosproject.net.ConnectPoint;

import java.util.Objects;

import static com.google.common.base.MoreObjects.toStringHelper;
import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Key of the multicast event cache.
 */
class McastCacheKey {
    // The group ip
    private final IpAddress mcastIp;
    // The sink connect point
    private final ConnectPoint sink;

    /**
     * Constructs a key for multicast event cache.
     *
     * @param mcastIp multicast group IP address
     * @param sink connect point of the sink
     */
    public McastCacheKey(IpAddress mcastIp, ConnectPoint sink) {
        checkNotNull(mcastIp, "mcastIp cannot be null");
        checkNotNull(sink, "sink cannot be null");
        checkArgument(mcastIp.isMulticast(), "mcastIp must be a multicast address");
        this.mcastIp = mcastIp;
        this.sink = sink;
    }

    /**
     * Returns the multicast IP address of this key.
     *
     * @return multicast IP
     */
    public IpAddress mcastIp() {
        return mcastIp;
    }

    /**
     * Returns the sink of this key.
     *
     * @return connect point of the sink
     */
    public ConnectPoint sink() {
        return sink;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof McastCacheKey)) {
            return false;
        }
        McastCacheKey that =
                (McastCacheKey) o;
        return (Objects.equals(this.mcastIp, that.mcastIp) &&
                Objects.equals(this.sink, that.sink));
    }

    @Override
    public int hashCode() {
         return Objects.hash(mcastIp, sink);
    }

    @Override
    public String toString() {
        return toStringHelper(getClass())
                .add("mcastIp", mcastIp)
                .add("sink", sink)
                .toString();
    }
}
