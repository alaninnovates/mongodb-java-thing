package com.company.db;

import com.company.models.Guild;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class Database {
    private static Database instance;
    private MongoClient mongoClient;
    private MongoDatabase db;
    private MongoCollection<Guild> collection;

    public Database() {
        mongoClient = null;
        db = null;
        collection = null;
    }

    public static void connect(ConnectionString uri) {
        CodecRegistry pojoCodecRegistry = fromProviders(PojoCodecProvider.builder().automatic(true).build());
        CodecRegistry codecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), pojoCodecRegistry);
        MongoClientSettings clientSettings = MongoClientSettings.builder()
                .applyConnectionString(uri)
                .codecRegistry(codecRegistry)
                .build();
        try (MongoClient c = MongoClients.create(clientSettings)) {
//            System.out.println("db open");
            MongoDatabase d = c.getDatabase("db");
            Database cls = new Database();
            cls.mongoClient = c;
            cls.db = d;
            cls.collection = d.getCollection("bot", Guild.class);
            instance = cls;
        }
    }

    public static Database getInstance() {
        return instance;
    }

    public MongoDatabase getDb() {
        return db;
    }

    public MongoCollection<Guild> getCollection() {
        return collection;
    }

    public MongoClient getClient() {
        return mongoClient;
    }
}
