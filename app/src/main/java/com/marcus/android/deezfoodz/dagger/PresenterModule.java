package com.marcus.android.deezfoodz.dagger;

import android.content.Context;

import com.marcus.android.deezfoodz.ui.food.FoodPresenter;
import com.marcus.android.deezfoodz.ui.food.FoodPresenterImpl;
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
    FoodzPresenter provideFoodzPresenter(Context context) {
        return new FoodzPresenterImpl(context);
    }

    @Provides
    @Singleton
    FoodPresenter provideFoodPresenter(Context context){
        return new FoodPresenterImpl(context);
    }
}