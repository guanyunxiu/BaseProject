package com.hqkj.newsproject.net;


import com.hqkj.newsproject.bean.User;
import com.hqkj.newsproject.net.util.BaseResponse;

import java.util.Map;


import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface API {
    @POST("api/user/passwordLogin")
    Call<BaseResponse> login(@Body Map<String, Object> map);
    @POST("api/user/passwordLogin")
    Observable<BaseResponse> loginRX(@Body Map<String, Object> map);
}
