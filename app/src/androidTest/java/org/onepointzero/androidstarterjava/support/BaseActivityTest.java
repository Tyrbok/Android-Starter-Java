package org.onepointzero.androidstarterjava.support;

import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.intent.rule.IntentsTestRule;

import org.junit.Rule;
import org.onepointzero.androidstarterjava.application.MainActivity;
import org.onepointzero.androidstarterjava.support.config.TestConfiguration;
import org.onepointzero.androidstarterjava.support.di.AppComponent;
import org.onepointzero.androidstarterjava.support.di.AppModule;

import it.cosenonjaviste.daggermock.DaggerMockRule;

public abstract class BaseActivityTest {

    private AppModule appModule = new TestAppModule(getApp(), new TestConfiguration());

    @Rule
    public IntentsTestRule<MainActivity> activity = new IntentsTestRule<>(MainActivity.class, true, false);

    @Rule
    public DaggerMockRule<AppComponent> daggerMockRule = new DaggerMockRule<>(AppComponent.class, appModule)
            .set(component -> {
                Bootstrap app = getApp();
                app.setComponent(component);
            });

    private Bootstrap getApp() {
        return (Bootstrap) InstrumentationRegistry.getInstrumentation()
                .getTargetContext()
                .getApplicationContext();
    }

    protected TestAppModule getAppModule() {
        return (TestAppModule) appModule;
    }
}
