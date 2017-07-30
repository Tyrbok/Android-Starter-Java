package org.onepointzero.androidstarterjava.support;

import android.app.Application;

import org.onepointzero.androidstarterjava.support.di.AppComponent;
import org.onepointzero.androidstarterjava.support.di.DaggerAppComponent;

public class Bootstrap extends Application {
    public AppComponent getComponent() {
//        AppModule appModule = new AppModule(getConfiguration(), publisher);
//        return DaggerAppComponent.builder().appModule(appModule).build();

        return DaggerAppComponent.builder().build();

    }

//    public Configuration getConfiguration() {
//        return new ProductionConfiguration();
//    }
}
