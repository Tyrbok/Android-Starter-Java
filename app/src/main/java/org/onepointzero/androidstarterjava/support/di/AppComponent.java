package org.onepointzero.androidstarterjava.support.di;

import org.onepointzero.androidstarterjava.application.MainActivity;

import dagger.Component;

@Component(modules = AppModule.class)
public interface AppComponent {
    void inject(MainActivity activity);
}
