package org.onepointzero.androidstarterjava.domain;

import io.reactivex.Single;

public interface StarterDataRepository {
    public Single<StarterData> getStarterData();
}
