package com.example.demoroommvvm;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.NavController;
import androidx.recyclerview.widget.RecyclerView;
import com.example.demoroommvvm.databinding.ItemUserBinding;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserHoder> {
    private List<User> userList;
    private Context context;
    NavController navController;

    public UserAdapter(Context context, List<User> userList, NavController navController) {
        this.userList = userList;
        this.context = context;
        this.navController = navController;
    }

    @NonNull
    @Override
    public UserHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemUserBinding view = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.item_user, parent, false);
        UserHoder userHoder = new UserHoder(view);
        return userHoder;
    }

    @Override
    public void onBindViewHolder(@NonNull UserHoder holder, int position) {
        User user = userList.get(position);
        holder.viewDataBinding.setListUser(user);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirstFragmentDirections.ActionFirstFragmentToSecondFragment action=FirstFragmentDirections.actionFirstFragmentToSecondFragment(user);
                navController.navigate(action);
            }
        });
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }
}
