/*
 * Copyright (c) 2008-2013, Hazelcast, Inc. All Rights Reserved.
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

package com.hazelcast.client.spi;

import com.hazelcast.client.ClientRequest;
import com.hazelcast.client.spi.impl.ClientCallFuture;
import com.hazelcast.instance.MemberImpl;
import com.hazelcast.nio.Address;
import com.hazelcast.nio.serialization.DataAdapter;

import java.io.IOException;
import java.util.Collection;

/**
 * @author mdogan 5/16/13
 */
public interface ClientClusterService {

    MemberImpl getMember(Address address);

    MemberImpl getMember(String uuid);

    Collection<MemberImpl> getMemberList();

    Address getMasterAddress();

    int getSize();

    long getClusterTime();

    void handlePacket(DataAdapter packet);

    long registerCall(ClientCallFuture future);

    public boolean deRegisterCall(long callId);

    boolean send(ClientRequest request) throws IOException;

    boolean send(ClientRequest request, Address target) throws IOException ;

    boolean sendAndHandle(ClientRequest request, EventHandler handler) throws IOException ;

    boolean sendAndHandle(ClientRequest request, Address target, EventHandler handler) throws IOException ;

    void registerListener(String uuid, long callId);

    public boolean deRegisterListener(String uuid);
}
