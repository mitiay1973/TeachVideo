package com.example.teachvideo;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AdapterMask  extends BaseAdapter {
    private Context mContext;
    List<Mask> maskList;

    public AdapterMask(Context mContext, List<Mask> listVideo) {
        this.mContext = mContext;
        this.maskList = listVideo;
    }

    @Override
    public int getCount() {
        return maskList.size();
    }

    @Override
    public Object getItem(int i) {
        return maskList.get(i);
    }

    @Override
    public long getItemId(int i)
    {
        return maskList.get(i).getId();
    }


    @Override
    public View getView(int i, View view, ViewGroup viewGroup)
    {
        View v = View.inflate(mContext,R.layout.item_layuot,null);
        TextView teachVideo = v.findViewById(R.id.video);
        Mask mask = maskList.get(i);
        teachVideo.setText(mask.getName());

        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intenDetalis=new Intent(mContext,YouTubeActivity.class);
                intenDetalis.putExtra("video",mask);
                mContext.startActivity(intenDetalis);

            }
        });
        return v;
    }

}

