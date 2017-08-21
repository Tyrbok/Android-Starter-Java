package org.onepointzero.androidstarterjava.support.config;

public class DevConfiguration implements Configuration {

    @Override
    public Environment getEnvironment() {
        return Environment.DEV;
    }
}
