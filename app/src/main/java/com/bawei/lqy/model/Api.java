package com.bawei.lqy.model;

import com.bawei.lqy.model.bean.CartBean;
import com.bawei.lqy.model.bean.GsonBean;
import com.bawei.lqy.model.bean.LoginBean;
import com.bawei.lqy.model.bean.SecondGson;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Time:2020/1/2 0002下午 03:51202001
 * 邮箱:2094158527@qq.com
 * 作者:李庆瑶
 * 类功能:
 */
public interface Api {
    @FormUrlEncoded
    @POST("small/user/v1/login")
    Observable<LoginBean> getJsonPost(@Field("phone") String phone, @Field("pwd") String pwd);

    @GET("small/commodity/v1/findCommodityByKeyword")
    Observable<GsonBean> getJsonGet(@Query("page") int page, @Query("count") int count, @Query("keyword") String keyword);

    @GET("small/order/verify/v1/findShoppingCart")
    Observable<CartBean> getCartData(@Header("userId") String userId, @Header("sessionId") String sessionId);

    @GET("small/commodity/v1/commodityList")
    Observable<SecondGson> getSecondData();
}
