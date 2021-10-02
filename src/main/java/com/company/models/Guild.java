package com.company.models;

import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

public class Guild {
    private ObjectId id;

    @BsonProperty(value = "guild_id")
    private String guildId;

    @BsonProperty(value = "channel_id")
    private String channelId;

    public ObjectId getId() {
        return id;
    }

    public Guild setId(ObjectId id) {
        this.id = id;
        return this;
    }

    public String getGuildId() {
        return guildId;
    }

    public Guild setGuildId(String guildId) {
        this.guildId = guildId;
        return this;
    }

    public String getChannelId() {
        return channelId;
    }

    public Guild setChannelId(String channelId) {
        this.channelId = channelId;
        return this;
    }
}
