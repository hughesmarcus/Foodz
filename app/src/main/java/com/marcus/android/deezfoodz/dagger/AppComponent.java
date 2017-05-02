package com.marcus.android.deezfoodz.dagger;

import com.marcus.android.deezfoodz.ui.foodz.FoodzActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by marcus on 5/2/17.
 */


@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    void inject(FoodzActivity target);
}

