package les22.retrofit;

import les22.retrofit.pojo.*;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface APIInterface {
    @GET("users/2")
    Call<Account> getUserById();

    @GET("unknown/2")
    Call<Resource> getResource();

    @POST("login")
    Call<LoginOut> login(@Body Register register);

    @POST("register")
    Call<RegisterOut> register(@Body Register register);
}
