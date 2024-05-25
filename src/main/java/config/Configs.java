package config;

import static java.lang.System.*;

public class Configs {
    protected String dbHost = getProperty("dbHost");
    protected String dbPort = getProperty("dbPort");
    protected String dbUser = getProperty("dbUser");
    protected String dbPassword = getProperty("dbPassword");
    protected String dbName = getProperty("dbName");
}
