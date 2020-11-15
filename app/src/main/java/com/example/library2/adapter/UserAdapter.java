package com.example.library2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;

import androidx.recyclerview.widget.RecyclerView;

import com.example.library2.R;
import com.example.library2.model.User;


public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyViewHolder> {
    private Context mContext;
    private  User[] mUser;
    public UserAdapter(Context context , User[] users) {
        this.mContext = context;
        this.mUser = users;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.item_word,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        User user =  mUser[position];
        holder.nameTextView.setText(user.name);
        holder.lastNameView.setText(user.lastName);
        holder.statusTextView.setText(user.status);

    }

    @Override
    public int getItemCount() {
        return mUser.length;
    }

    static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView nameTextView;
        TextView lastNameView;
        TextView statusTextView;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            this.nameTextView = itemView.findViewById(R.id.name_text_view);
            this.lastNameView = itemView.findViewById(R.id.last_name_text_view);
            this.statusTextView = itemView.findViewById(R.id.status_text_view);

        }
    }
}
