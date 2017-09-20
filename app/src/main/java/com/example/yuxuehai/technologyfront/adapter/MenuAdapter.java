package com.example.yuxuehai.technologyfront.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yuxuehai.technologyfront.R;
import com.example.yuxuehai.technologyfront.bean.MenuItem;
import com.example.yuxuehai.technologyfront.dao.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuxuehai on 2017/9/7.
 */

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuViewHolder> {

    private List<MenuItem> mDataSet = new ArrayList<>();
    OnItemClickListener<MenuItem> mItemClickListener;

    public MenuAdapter(List<MenuItem> dateSet){
        mDataSet = dateSet;
    }

    @Override
    public MenuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MenuViewHolder(inflateItemView(parent, R.layout.menu_item));
    }

    @Override
    public void onBindViewHolder(MenuViewHolder holder, int position) {
        final MenuItem item = getItem(position);
        holder.nameTextView.setText(item.text);
        holder.userImageView.setImageResource(item.iconResId);
        setupItemViewClickListener(holder, item);
    }

    public void setOnItemClickListener(OnItemClickListener<MenuItem> clickListener) {
        this.mItemClickListener = clickListener;
    }

    /**
     * ItemView的点击事件
     *
     * @param viewHolder
     * @param position
     */
    protected void setupItemViewClickListener(MenuViewHolder viewHolder, final MenuItem item) {
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (mItemClickListener != null) {
                    mItemClickListener.onClick(item);
                }
            }
        });
    }

    protected MenuItem getItem(int position) {
        return mDataSet.get(position);
    }

    protected View inflateItemView(ViewGroup viewGroup, int layoutId) {
        return LayoutInflater.from(viewGroup.getContext()).inflate(layoutId, viewGroup, false);
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }


    static class MenuViewHolder extends RecyclerView.ViewHolder {
        public ImageView userImageView;
        public TextView nameTextView;

        public MenuViewHolder(View itemView) {
            super(itemView);
            userImageView = (ImageView) itemView.findViewById(R.id.menu_icon_imageview);
            nameTextView = (TextView) itemView.findViewById(R.id.menu_text_tv);
        }
    }
}
