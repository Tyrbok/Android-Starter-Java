package org.onepointzero.androidstarterjava.support;

import android.app.Application;

import org.onepointzero.androidstarterjava.support.config.Configuration;
import org.onepointzero.androidstarterjava.support.config.ProdConfiguration;
import org.onepointzero.androidstarterjava.support.di.AppComponent;
import org.onepointzero.androidstarterjava.support.di.AppModule;
import org.onepointzero.androidstarterjava.support.di.DaggerAppComponent;

public class Bootstrap extends Application {
    AppModule appModule;

    @Override
    public void onCreate() {
        super.onCreate();

        appModule = new AppModule(this.getApplicationContext(), getConfiguration());
    }

    public AppComponent getComponent() {
        return DaggerAppComponent.builder().appModule(appModule).build();
    }

    public Configuration getConfiguration() {
        return new ProdConfiguration();
    }
}
