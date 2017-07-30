package org.onepointzero.androidstarterjava.application;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.onepointzero.androidstarterjava.R;
import org.onepointzero.androidstarterjava.support.Bootstrap;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainScreen {

    @Inject MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((Bootstrap) getApplication()).getComponent().inject(this);

        ButterKnife.bind(this);

        presenter.bind(this);
    }
}
