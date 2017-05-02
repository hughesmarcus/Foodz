/*
 * Copyright (c) 2016 Razeware LLC
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.marcus.android.deezfoodz.ui.foodz;

import android.content.Context;

import com.annimon.stream.Collectors;
import com.annimon.stream.Stream;
import com.marcus.android.deezfoodz.app.Constants;
import com.marcus.android.deezfoodz.app.DeezFoodzApplication;
import com.marcus.android.deezfoodz.model.FoodzItem;
import com.marcus.android.deezfoodz.model.FoodzListResponse;
import com.marcus.android.deezfoodz.network.UsdaApi;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FoodzPresenterImpl implements FoodzPresenter {
  @Inject
  UsdaApi usdaApi;
  private FoodzView view;
  public FoodzPresenterImpl(Context context) {
    ((DeezFoodzApplication)context).getAppComponent().inject(this);
  }
  @Override
  public void setView(FoodzView view) {
    this.view = view;
  }

  @Override
  public void getFoodz() {
    view.showLoading();



    usdaApi.getFoodzList().enqueue(new Callback<FoodzListResponse>() {
      @Override
      public void onResponse(Call<FoodzListResponse> call, Response<FoodzListResponse> response) {

        if (response.code() != 200) {

          view.showErrorMessage();

        } else {

          List<FoodzItem> foodzItemList = Stream.of(response.body().getList().getItem())
              .filter(foodzItem -> !foodzItem.getName().contains("ERROR"))
              .collect(Collectors.toList());

          view.showFoodz(foodzItemList);
        }
        view.hideLoading();
      }

      @Override
      public void onFailure(Call<FoodzListResponse> call, Throwable t) {
        view.showErrorMessage();
        view.hideLoading();
      }
    });
  }

}
