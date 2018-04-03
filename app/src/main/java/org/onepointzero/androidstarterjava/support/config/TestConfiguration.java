package org.onepointzero.androidstarterjava.support.config;

public class TestConfiguration implements Configuration {

    @Override
    public Environment getEnvironment() {
        return Environment.TEST;
    }
}
