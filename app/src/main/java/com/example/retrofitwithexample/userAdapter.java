package com.example.retrofitwithexample;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.retrofitwithexample.databinding.CustomeRvBinding;

import java.util.List;

public class userAdapter extends RecyclerView.Adapter<userAdapter.ViewHolder> {
    List<UserModel> list;
    userAdapter(List<UserModel> list){
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(CustomeRvBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.customeRvBinding.txTest1.setText(list.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder  {
        CustomeRvBinding customeRvBinding;
        public ViewHolder(@NonNull CustomeRvBinding customeRvBinding) {
            super(customeRvBinding.getRoot());
            this.customeRvBinding = customeRvBinding;
        }
    }
}
