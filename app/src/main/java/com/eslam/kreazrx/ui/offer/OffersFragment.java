package com.eslam.kreazrx.ui.offer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.eslam.kreazrx.R;
import com.eslam.kreazrx.databinding.FragmentOffersBinding;

import org.jetbrains.annotations.NotNull;

public class OffersFragment extends Fragment {


    @Override
    public View onCreateView(
            @NotNull LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState
    ) {
        OffersFragmentViewModel viewModel = new ViewModelProvider(this).get(OffersFragmentViewModel.class);

        FragmentOffersBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_offers, container, false);

        binding.setViewModel(viewModel);
        binding.setLifecycleOwner(this);
        binding.executePendingBindings();
        return binding.getRoot();
    }


}