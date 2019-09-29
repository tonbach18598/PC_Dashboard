package com.example.pcdashboard.Adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.pcdashboard.Model.PostComment;
import com.example.pcdashboard.R;

import java.util.ArrayList;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.ViewHolder> {
    private Context context;
    private ArrayList<PostComment> postComments;

    public CommentAdapter(Context context, ArrayList<PostComment> postComments) {
        this.context = context;
        this.postComments = postComments;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_post_comment, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PostComment postComment = postComments.get(position);
        Glide.with(context).load(Uri.parse(postComment.getUserAvatar())).centerCrop().override(40, 40).into(holder.ivAvatar);
        holder.tvName.setText(postComment.getUserName());
        holder.tvContent.setText(postComment.getContent());
        holder.tvTime.setText(postComment.getTime());
    }

    @Override
    public int getItemCount() {
        return postComments.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivAvatar;
        TextView tvName, tvContent, tvTime;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivAvatar = itemView.findViewById(R.id.iv_avatar_comment_item);
            tvName = itemView.findViewById(R.id.tv_name_comment_item);
            tvContent = itemView.findViewById(R.id.tv_content_comment_item);
            tvTime = itemView.findViewById(R.id.tv_time_comment_item);
        }
    }
}