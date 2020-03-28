package com.eslam.kreazrx.ui.offer;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.eslam.kreazrx.R;
import com.eslam.kreazrx.databinding.OfferRowItemBinding;

import io.reactivex.annotations.NonNull;


public class offer_list_adapter extends ListAdapter<OfferResponse.DataBean, offer_list_adapter.ViewHolder> {

    private static DiffUtil.ItemCallback<OfferResponse.DataBean> diff = new DiffUtil.ItemCallback<OfferResponse.DataBean>() {
        @Override
        public boolean areItemsTheSame(OfferResponse.DataBean oldItem, OfferResponse.DataBean newItem) {
            return oldItem.getOfferId().equals(newItem.getOfferId());
        }

        @SuppressLint("DiffUtilEquals")
        @Override
        public boolean areContentsTheSame(OfferResponse.DataBean oldItem, OfferResponse.DataBean newItem) {
            return oldItem == newItem;
        }
    };
    private ClickListener mClickListener;

    public offer_list_adapter(ClickListener mClickListener) {
        super(diff);
        this.mClickListener = mClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        OfferRowItemBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.offer_row_item,
                parent,
                false);
        return new ViewHolder(binding);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        OfferResponse.DataBean offer = getItem(position);
        holder.binding.setOffer(offer);
        holder.binding.setClickListener(mClickListener);
        holder.binding.executePendingBindings();

    }

    public interface ClickListener {
        void onRowClickListener(OfferResponse.DataBean offer, View v);


    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        OfferRowItemBinding binding;

        public ViewHolder(final OfferRowItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }


}

