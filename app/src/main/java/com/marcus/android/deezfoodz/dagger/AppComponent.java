package com.marcus.android.deezfoodz.dagger;

import com.marcus.android.deezfoodz.ui.food.FoodActivity;
import com.marcus.android.deezfoodz.ui.food.FoodPresenterImpl;
import com.marcus.android.deezfoodz.ui.foodz.FoodzActivity;
import com.marcus.android.deezfoodz.ui.foodz.FoodzPresenterImpl;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by marcus on 5/2/17.
 */


@Singleton
@Component(modules = {AppModule.class, PresenterModule.class, NetworkModule.class})
public interface AppComponent {

    void inject(FoodzActivity target);
    void inject(FoodActivity target);
    void inject(FoodzPresenterImpl target);
    void inject(FoodPresenterImpl target);
}

