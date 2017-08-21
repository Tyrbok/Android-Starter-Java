package org.onepointzero.androidstarterjava.support;

import android.app.Application;

import org.onepointzero.androidstarterjava.support.config.Configuration;
import org.onepointzero.androidstarterjava.support.config.ProdConfiguration;
import org.onepointzero.androidstarterjava.support.di.AppComponent;
import org.onepointzero.androidstarterjava.support.di.AppModule;
import org.onepointzero.androidstarterjava.support.di.DaggerAppComponent;

public class Bootstrap extends Application {
    public AppComponent getComponent() {
        AppModule appModule = new AppModule(this.getApplicationContext(), getConfiguration());
        return DaggerAppComponent.builder().appModule(appModule).build();
    }

    public Configuration getConfiguration() {
        return new ProdConfiguration();
    }
}
