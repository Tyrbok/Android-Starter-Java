package org.onepointzero.androidstarterjava.support.config;

public class ProdConfiguration implements Configuration {

    @Override
    public Environment getEnvironment() {
        return Environment.PRO;
    }
}
