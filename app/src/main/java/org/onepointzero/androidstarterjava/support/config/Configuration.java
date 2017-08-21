package org.onepointzero.androidstarterjava.support.config;

public interface Configuration {

    public Environment getEnvironment();

    public enum Environment {
        PRO, PRE, DEV
    }
}
