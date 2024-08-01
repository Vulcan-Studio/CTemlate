package net.coma112.ctemplate.database;

public abstract class AbstractDatabase {
    public abstract boolean isConnected();

    public abstract void disconnect();

    public abstract void reconnect();

    public abstract void createTable();
}
