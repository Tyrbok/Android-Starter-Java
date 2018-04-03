package org.onepointzero.androidstarterjava.support;

import android.content.Context;

import org.onepointzero.androidstarterjava.domain.StarterData;
import org.onepointzero.androidstarterjava.domain.StarterDataRepository;
import org.onepointzero.androidstarterjava.support.config.Configuration;
import org.onepointzero.androidstarterjava.support.di.AppModule;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Single;

@Module
public class TestAppModule extends AppModule {
    private String message = "Test App Module Message";

    public void setMessage(String message) {
        this.message = message;
    }

    public TestAppModule(Context context, Configuration configuration) {
        super(context, configuration);
    }

    @Provides
    @Override
    public StarterDataRepository starterDataRepository() {
        return () -> Single.just(new StarterData(message));
    }

}
