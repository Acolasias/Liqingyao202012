package com.bawei.lqy.utile;

import android.widget.ImageView;

import com.bawei.lqy.model.Api;
import com.bawei.lqy.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Time:2020/1/2 0002下午 04:57202001
 * 邮箱:2094158527@qq.com
 * 作者:李庆瑶
 * 类功能:
 */
public class NetUtile {

    private final Api api;

    private static class SingleHolder{
        private static final NetUtile NET_UTILE= new NetUtile();
    }

    public static NetUtile getInstance() {
        return SingleHolder.NET_UTILE;
    }
    private static final String BASE_URL="http://172.17.8.100/";
    private NetUtile() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        HttpLoggingInterceptor httpLoggingInterceptor1 = httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(5, TimeUnit.SECONDS)
                .writeTimeout(5, TimeUnit.SECONDS)
                .connectTimeout(5, TimeUnit.SECONDS)
                .addInterceptor(httpLoggingInterceptor1)
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        api = retrofit.create(Api.class);
    }

    public Api getApi() {
        return api;
    }

    public void getPhoto(String httpUrl, ImageView imageView){
        Glide.with(imageView).load(httpUrl)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher_round)
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(30)))
                .into(imageView);
    }
}
