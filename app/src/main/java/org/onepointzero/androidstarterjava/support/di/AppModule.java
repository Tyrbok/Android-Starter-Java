package org.onepointzero.androidstarterjava.support.di;

import android.content.Context;

import org.onepointzero.androidstarterjava.application.GetStarterData;
import org.onepointzero.androidstarterjava.application.MainPresenter;
import org.onepointzero.androidstarterjava.domain.StarterDataRepository;
import org.onepointzero.androidstarterjava.infraestructure.DummyStarterDataRepository;
import org.onepointzero.androidstarterjava.support.config.Configuration;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    Context context;
    Configuration configuration;

    public AppModule(Context context, Configuration configuration) {
        this.context = context;
        this.configuration = configuration;
    }

    @Provides
    public MainPresenter mainPresenter(GetStarterData getStarterData) {
        return new MainPresenter(getStarterData);
    }

    @Provides
    public StarterDataRepository starterDataRepository() {
        return new DummyStarterDataRepository(context);
    }

    @Provides
    public GetStarterData getStarterData(StarterDataRepository starterDataRepository) {
        return new GetStarterData(starterDataRepository);
    }
}
