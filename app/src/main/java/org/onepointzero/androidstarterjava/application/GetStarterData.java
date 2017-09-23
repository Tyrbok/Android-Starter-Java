package org.onepointzero.androidstarterjava.application;

import org.onepointzero.androidstarterjava.domain.StarterData;
import org.onepointzero.androidstarterjava.domain.StarterDataRepository;

import io.reactivex.Single;

public class GetStarterData {
    private StarterDataRepository starterDataRepository;

    public GetStarterData(StarterDataRepository starterDataRepository) {
        this.starterDataRepository = starterDataRepository;
    }

    public Single<String> execute() {
        return starterDataRepository
                .getStarterData()
                .map(StarterData::getMessage);
    }
}
