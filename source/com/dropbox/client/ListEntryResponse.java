package com.dropbox.client;

/*
 * Copyright (c) 2002-2010 David Kocher. All rights reserved.
 *
 * http://cyberduck.ch/
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * Bug fixes, suggestions and comments should be sent to:
 * dkocher@cyberduck.ch
 */

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.Map;

/**
 * @version $Id:$
 */
public class ListEntryResponse extends AbstractResponse {
    private long length;
    private String hash;
    private String icon;
    private boolean directory;
    private String modified;
    private String path;
    private String root;
    private String size;
    private String mime;
    private long revision;
    private boolean thumbnail;

    private ArrayList<ListEntryResponse> contents;

    public ListEntryResponse(JSONObject map) {
        length = this.getFromMapAsLong(map, "bytes");

        hash = (String) map.get("hash");
        icon = (String) map.get("icon");

        directory = getFromMapAsBoolean(map, "is_dir");

        modified = (String) map.get("modified");
        path = (String) map.get("path");
        root = (String) map.get("root");
        size = (String) map.get("size");
        mime = (String) map.get("mime_type");

        revision = this.getFromMapAsLong(map, "revision");

        thumbnail = getFromMapAsBoolean(map, "thumb_exists");

        Object json_contents = map.get("contents");
        if(json_contents != null && json_contents instanceof JSONArray) {
            contents = new ArrayList<ListEntryResponse>();
            Object entry;
            for(Object o : ((JSONArray) json_contents)) {
                entry = o;
                if(entry instanceof Map) {
                    contents.add(new ListEntryResponse((JSONObject) entry));
                }
            }
        }
    }

    public ArrayList<ListEntryResponse> getContents() {
        return contents;
    }

    public long getLength() {
        return length;
    }

    public String getHash() {
        return hash;
    }

    public String getIcon() {
        return icon;
    }

    public boolean isDirectory() {
        return directory;
    }

    public String getModified() {
        return modified;
    }

    public String getPath() {
        return path;
    }

    public String getRoot() {
        return root;
    }

    public String getSize() {
        return size;
    }

    public String getMime() {
        return mime;
    }

    public long getRevision() {
        return revision;
    }

    public boolean isThumbnail() {
        return thumbnail;
    }

    private boolean getFromMapAsBoolean(Map map, String name) {
        Object val = map.get(name);
        if(val != null && val instanceof Boolean) {
            return (Boolean) val;
        }
        else {
            return false;
        }
    }
}
