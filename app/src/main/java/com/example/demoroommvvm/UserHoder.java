package com.example.demoroommvvm;

import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demoroommvvm.databinding.ItemUserBinding;


public class UserHoder extends RecyclerView.ViewHolder {
    ItemUserBinding viewDataBinding;
    public UserHoder(@NonNull ItemUserBinding itemView) {
        super(itemView.getRoot());
       viewDataBinding=itemView;

    }
}
