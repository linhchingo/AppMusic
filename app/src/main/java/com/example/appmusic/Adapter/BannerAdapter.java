package com.example.appmusic.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.appmusic.Model.Quangcao;
import com.example.appmusic.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class BannerAdapter extends PagerAdapter {
    private Context context;
    private ArrayList<Quangcao> quangcaoArrayList;

    public BannerAdapter(Context context, ArrayList<Quangcao> quangcaoArrayList) {
        this.context = context;
        this.quangcaoArrayList = quangcaoArrayList;
    }

    @Override
    public int getCount() {
        return quangcaoArrayList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_banner,null);

        ImageView imageViewBannerBackgroud = view.findViewById(R.id.imageView_banner_backgroud);
        ImageView imageViewBannerSong = view.findViewById(R.id.imageView_banner);
        TextView txtTilteBanner = view.findViewById(R.id.textview_title_banner_song);
        TextView txtContent = view.findViewById(R.id.textView_content);

        Picasso.get().load(quangcaoArrayList.get(position).getHinhAnh()).into(imageViewBannerBackgroud);
        Picasso.get().load(quangcaoArrayList.get(position).getHinhBaiHat()).into(imageViewBannerSong);
        txtTilteBanner.setText(quangcaoArrayList.get(position).getTenBaiHat());
        txtContent.setText(quangcaoArrayList.get(position).getNoiDung());

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
