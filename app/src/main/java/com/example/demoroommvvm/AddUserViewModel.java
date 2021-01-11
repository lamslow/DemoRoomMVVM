package com.example.demoroommvvm;

import android.content.Context;
import android.util.Log;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.ObservableField;
import androidx.navigation.NavController;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.demoroommvvm.databinding.FragmentFirstBinding;

import java.util.List;

public class AddUserViewModel extends BaseObservable {

    RecyclerView rvList;
    UserAdapter userAdapter;
    Context context;
    String username;
    String password;
    List<User> userList;
    FragmentFirstBinding fragmentFirstBinding;
    NavController navController;

    public AddUserViewModel(Context context, RecyclerView rvList, FragmentFirstBinding fragmentFirstBinding, NavController navController) {
        this.context = context;
        this.rvList = rvList;
        this.fragmentFirstBinding=fragmentFirstBinding;
        this.navController=navController;
    }

    public ObservableField<String> mesage = new ObservableField<>();

    @Bindable
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
        notifyPropertyChanged(BR.username);
    }
    @Bindable
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        notifyPropertyChanged(BR.password);
    }
    public void signUpUser(){
        User user=new User(getUsername(),getPassword());
        UserDatabase.getInstance(context).userDAO().insertUser(user);
        mesage.set("Thành công");
        userList=UserDatabase.getInstance(context).userDAO().getListUser();
        Log.e("AAA",userList.size()+"");
        userAdapter= new UserAdapter(context,userList,navController);
        fragmentFirstBinding.rvList.setAdapter(userAdapter);
        fragmentFirstBinding.rvList.setLayoutManager(new LinearLayoutManager(context));
    }
    public void showList(List<User> users){
        userAdapter= new UserAdapter(context,users,navController);
        rvList.setAdapter(userAdapter);
        rvList.setLayoutManager(new LinearLayoutManager(context));
    }
}
