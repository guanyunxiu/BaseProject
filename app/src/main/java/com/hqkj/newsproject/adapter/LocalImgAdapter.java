package com.hqkj.newsproject.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.allure.lbanners.LMBanners;
import com.allure.lbanners.adapter.LBaseAdapter;
import com.hqkj.newsproject.R;
import com.hqkj.newsproject.bean.ViewPagerBean;
import com.hqkj.newsproject.utils.ImageLoader;

/**
 * Created by luomin on 16/7/12.
 */
public class LocalImgAdapter implements LBaseAdapter<ViewPagerBean> {
    private Context mContext;

    public LocalImgAdapter(Context context) {
        mContext=context;
    }

    @Override
    public View getView(final LMBanners lBanners, final Context context, final int position, final ViewPagerBean data) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.activity_home_banner_item, null);
        ImageView imageView = (ImageView) view.findViewById(R.id.id_image);

        ImageLoader.load(context,data.getUrl(),imageView);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              if(bannerInterface != null){
                  bannerInterface.onItem(data);
              }
            }
        });
        return view;
    }
    public interface BannerInterface{
        void onItem(ViewPagerBean bannerListBean);
    }
    public BannerInterface bannerInterface;

    public BannerInterface getBannerInterface() {
        return bannerInterface;
    }

    public void setBannerInterface(BannerInterface bannerInterface) {
        this.bannerInterface = bannerInterface;
    }
}
