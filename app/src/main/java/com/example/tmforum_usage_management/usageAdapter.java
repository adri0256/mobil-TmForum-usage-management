package com.example.tmforum_usage_management;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tmforum_usage_management.models.Usage;

import java.util.ArrayList;

public class usageAdapter extends RecyclerView.Adapter<usageAdapter.ViewHolder> {
    private final String LOG_TAG = usageAdapter.class.getName();

    private OnAdapterItemClickListener adapterItemClickListener = null;

    private Context mContext;
    private ArrayList<Usage> mUsageData;
    private ArrayList<Usage> mUsageDataAll;

    public usageAdapter(Context mContext, ArrayList<Usage> mUsageData, OnAdapterItemClickListener listener) {
        this.mContext = mContext;
        this.mUsageData = mUsageData;
        this.mUsageDataAll = mUsageData;
        this.adapterItemClickListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.usage_card, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Usage currentItem = mUsageData.get(position);

        holder.bindTo(currentItem);
    }

    @Override
    public int getItemCount() {
        return mUsageData.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mCardId;
        private TextView mCardHref;
        private TextView mCardDescription;

        ViewHolder(View itemView) {
            super(itemView);

            // Initialize the views.
            mCardId = itemView.findViewById(R.id.cardId);
            mCardHref = itemView.findViewById(R.id.cardHref);
            mCardDescription = itemView.findViewById(R.id.cardDesc);

            itemView.findViewById(R.id.cardEditBtn).setOnClickListener(view -> {
                adapterItemClickListener.onAdapterItemClickListener("edit", mCardId.getText().toString().split(" ")[1]);
            });

            itemView.findViewById(R.id.cardDeleteBtn).setOnClickListener(view -> {
                adapterItemClickListener.onAdapterItemClickListener("delete", mCardId.getText().toString().split(" ")[1]);
            });
        }

        void bindTo(Usage currentItem) {
            mCardId.setText("ID: " + currentItem.getId());
            mCardHref.setText("Href: " + currentItem.getHref());
            mCardDescription.setText("Description: " + currentItem.getDescription());
        }
    }
}
