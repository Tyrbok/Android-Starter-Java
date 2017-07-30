package org.onepointzero.androidstarterjava.support.di;

import org.onepointzero.androidstarterjava.application.MainPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    @Provides
    MainPresenter mainPresenter() {
        return new MainPresenter();
    }
}
