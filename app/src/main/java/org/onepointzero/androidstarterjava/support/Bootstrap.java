package org.onepointzero.androidstarterjava.support;

import android.app.Application;

import org.onepointzero.androidstarterjava.support.config.Configuration;
import org.onepointzero.androidstarterjava.support.config.ProdConfiguration;
import org.onepointzero.androidstarterjava.support.di.AppComponent;
import org.onepointzero.androidstarterjava.support.di.AppModule;
import org.onepointzero.androidstarterjava.support.di.DaggerAppComponent;

public class Bootstrap extends Application {
    AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        AppModule appModule = new AppModule(this.getApplicationContext(), getConfiguration());
        component = DaggerAppComponent.builder().appModule(appModule).build();
    }

    public AppComponent getComponent() {
        return component;
    }

    public void setComponent(AppComponent component) {
        this.component = component;
    }

    public Configuration getConfiguration() {
        return new ProdConfiguration();
    }
}
