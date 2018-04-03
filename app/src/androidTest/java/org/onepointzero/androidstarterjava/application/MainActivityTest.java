package org.onepointzero.androidstarterjava.application;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.onepointzero.androidstarterjava.domain.StarterData;
import org.onepointzero.androidstarterjava.domain.StarterDataRepository;
import org.onepointzero.androidstarterjava.infraestructure.DummyStarterDataRepository;
import org.onepointzero.androidstarterjava.support.Bootstrap;
import org.onepointzero.androidstarterjava.support.config.Configuration;
import org.onepointzero.androidstarterjava.support.config.TestConfiguration;
import org.onepointzero.androidstarterjava.support.di.AppComponent;
import org.onepointzero.androidstarterjava.support.di.AppModule;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Single;
import it.cosenonjaviste.daggermock.DaggerMockRule;

import static com.schibsted.spain.barista.assertion.BaristaVisibilityAssertions.assertDisplayed;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityTest {


    private AppModule appModule = new MyAppModule(getApp(), new TestConfiguration());

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

    @Test
    public void should_display_mock_test() {

        activity.launchActivity(null);
        assertDisplayed("Foo");
    }

    @Module
    class MyAppModule extends AppModule {

        public MyAppModule(Context context, Configuration configuration) {
            super(context, configuration);
        }

        @Provides
        @Override
        public StarterDataRepository starterDataRepository() {
            return () -> Single.just(new StarterData("Foo"));
        }

    }
}