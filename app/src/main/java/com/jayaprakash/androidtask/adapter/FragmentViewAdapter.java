package com.jayaprakash.androidtask.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jayaprakash.androidtask.R;
import com.jayaprakash.androidtask.data.FragmentData;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class FragmentViewAdapter extends RecyclerView.Adapter<FragmentViewAdapter.ViewHolder> {

    private ArrayList<FragmentData> mData = new ArrayList<>();
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;
    private Context context;

    public FragmentViewAdapter(Context context, ArrayList<FragmentData> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.rv_fragment, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.txtTime.setText(""+mData.get(position).getTime());
        holder.txtTitle.setText(""+mData.get(position).getTitle());
        holder.txtContent.setText(""+mData.get(position).getContent());
        Picasso.with(context)
                .load(mData.get(position).getId())
                .placeholder(R.drawable.video)
                .into(holder.ivImage);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView ivImage;
        public TextView txtTime;
        public TextView txtTitle;
        public TextView txtContent;

        public ViewHolder(View itemView) {
            super(itemView);
            ivImage = (ImageView) itemView.findViewById(R.id.image);
            txtTime = (TextView) itemView.findViewById(R.id.txt_time);
            txtTitle = (TextView) itemView.findViewById(R.id.txt_title);
            txtContent = (TextView) itemView.findViewById(R.id.txt_content);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
        }
    }

    public String getItem(int id) {
        return mData.get(id).getTitle();
    }

    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    public interface ItemClickListener {
        void onItemClick(View view, int position, String s);
    }
}
