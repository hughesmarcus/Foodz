package com.marcus.android.deezfoodz.dagger;

import com.marcus.android.deezfoodz.ui.foodz.FoodzPresenter;
import com.marcus.android.deezfoodz.ui.foodz.FoodzPresenterImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by marcus on 5/2/17.
 */

@Module
public class PresenterModule {
    @Provides
    @Singleton
    FoodzPresenter provideFoodzPresenter() {
        return new FoodzPresenterImpl();
    }
}