package com.company;

import com.company.db.Database;
import com.mongodb.ConnectionString;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.set;

public class Bot {
    public static void main(String[] args)
            throws IllegalArgumentException {
        Database.connect(new ConnectionString("insert_srv_here?retryWrites=true&w=majority"));
        Database.getInstance().getCollection().findOneAndUpdate(eq("guildId", 1), set("guildId", 2));
    }
}
