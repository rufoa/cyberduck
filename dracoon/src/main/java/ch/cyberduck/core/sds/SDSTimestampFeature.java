package ch.cyberduck.core.sds;/*
 * Copyright (c) 2002-2020 iterate GmbH. All rights reserved.
 * https://cyberduck.io/
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 */

import ch.cyberduck.core.DisabledListProgressListener;
import ch.cyberduck.core.Path;
import ch.cyberduck.core.exception.BackgroundException;
import ch.cyberduck.core.sds.io.swagger.client.ApiException;
import ch.cyberduck.core.sds.io.swagger.client.api.NodesApi;
import ch.cyberduck.core.sds.io.swagger.client.model.UpdateFileRequest;
import ch.cyberduck.core.shared.DefaultTimestampFeature;
import ch.cyberduck.core.transfer.TransferStatus;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;

public class SDSTimestampFeature extends DefaultTimestampFeature {

    private final SDSSession session;
    private final SDSNodeIdProvider nodeid;

    public SDSTimestampFeature(final SDSSession session, final SDSNodeIdProvider nodeid) {
        this.session = session;
        this.nodeid = nodeid;
    }

    @Override
    public void setTimestamp(final Path file, final TransferStatus status) throws BackgroundException {
        try {
            new NodesApi(session.getClient()).updateFile(new UpdateFileRequest().timestampModification(new DateTime(status.getTimestamp())),
                Long.parseLong(nodeid.getFileid(file, new DisabledListProgressListener())), StringUtils.EMPTY, null);
        }
        catch(ApiException e) {
            throw new SDSExceptionMappingService().map("Failure to write attributes of {0}", e, file);
        }
    }
}
