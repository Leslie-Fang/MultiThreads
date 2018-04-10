package com.intel.dcg;

public class DBConfig {
    private String url;
    private String name;
    private String password;
    {
        this.url = "jdbc:mysql://localhost:3306/express2react";
        this.name = "sampadm";
        this.password = "secret";
    }
    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getUrl() {
        return url;
    }
}
