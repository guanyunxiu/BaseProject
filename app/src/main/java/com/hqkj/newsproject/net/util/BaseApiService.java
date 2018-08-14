package com.hqkj.newsproject.net.util;


import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;


/**
 * Created by Ｔａｍｉｃ on 2016-07-08.
 * {@link # https://github.com/NeglectedByBoss/RetrofitClient}
 */
public interface BaseApiService {
    @POST("api/user/passwordLogin")
    Observable<BaseResponse> loginRX(@Body Map<String, Object> map);
}
