package com.eslam.kreazrx.ui.offer;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.eslam.kreazrx.R;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

import static androidx.navigation.Navigation.findNavController;
import static com.eslam.kreazrx.api.ApiClient.getApiService;

public class OffersFragmentViewModel extends ViewModel implements offer_list_adapter.ClickListener {
    private String TAG = OffersFragmentViewModel.class.getSimpleName();

    public OffersFragmentViewModel() {
        Log.e(TAG, "constructor");
        fetchList();
    }


    private offer_list_adapter adapter = new offer_list_adapter(this);

    public offer_list_adapter getAdapter() {
        return adapter;
    }

    private MutableLiveData isLoading = new MutableLiveData(false);

    public MutableLiveData<Boolean> getIsLoading() {
        return isLoading;
    }

    @SuppressLint("CheckResult")
    public void fetchList() {
        Log.e(TAG, "fetchList");

        isLoading.setValue(true);

        Single<OfferResponse> cryptoObservable = getApiService().fetchOfferList(
                "get",
                "offers");

        cryptoObservable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(result -> result)
                .subscribe(this::handleResults, this::handleError);

    }

    private void handleError(Throwable e) {
        isLoading.setValue(false);
        Log.e(TAG, e.getMessage() + " ");


    }

    private void handleResults(OfferResponse response) {
        isLoading.setValue(false);
        if (response.getType().equals("success")) {
            adapter.submitList(response.getData());
        }

        Log.e(TAG, response.getType());

    }

    @Override
    public void onRowClickListener(OfferResponse.DataBean offer, View view) {
        Bundle argument = new Bundle();
        argument.putParcelable("offer", offer);
        findNavController(view).navigate(R.id.action_OffersFragment_to_offerDetail, argument);
    }
}
