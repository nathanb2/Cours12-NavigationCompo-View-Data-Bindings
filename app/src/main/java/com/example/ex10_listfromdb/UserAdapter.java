package com.example.ex10_listfromdb;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    private final List<User> users;

    public UserAdapter(List<User> userList) {
        users = userList;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = users.get(position);
        holder.nameTv.setText(user.getName());
        holder.ageTv.setText(String.valueOf(user.getAge()));

        if (user.getAge() >= 18){
            holder.itemView.setBackgroundColor(holder.itemView.getContext()
                    .getResources().getColor(R.color.design_default_color_error));
        }else {
            holder.itemView.setBackgroundColor(holder.itemView.getContext()
                    .getResources().getColor(R.color.white));
        }
    }

    @Override
    public int getItemCount() {
        if (users != null) {
            return users.size();
        }
        return 0;
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {

        private final TextView nameTv;
        private final TextView ageTv;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTv = itemView.findViewById(R.id.IT_name_tv);
            ageTv = itemView.findViewById(R.id.IT_age_tv);
        }
    }
}
