package com.example.radical.Model;

import static com.example.radical.Constants.Constent.BASE_URL;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.radical.Model.ResponseModel.ProductResponse;
import com.example.radical.Service.Apiconfig;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.converter.gson.GsonConverterFactory;

public class Commanrepository {

    private MutableLiveData<ProductResponse> productResponseMutableLiveData;

    private Apiconfig Apiconfig;

    private Context context;

    public Commanrepository(Context context) {
        this.context = context;
        productResponseMutableLiveData =new MutableLiveData<>();
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.level(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .retryOnConnectionFailure(true)
                .build();

        Apiconfig = new retrofit2.Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(Apiconfig.class);
    }

    public void getproductRequest(String projectId,String vendorId) {
        Apiconfig.getproductRequest(projectId,vendorId).enqueue(new Callback<ProductResponse>() {
            @Override
            public void onResponse(Call<ProductResponse> call, Response<ProductResponse> response) {
                if (response.body() != null) {
                    productResponseMutableLiveData.postValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<ProductResponse> call, Throwable t) {
                productResponseMutableLiveData.postValue(null);
            }
        });
    }

    public LiveData<ProductResponse> getproductRequest() {
        return productResponseMutableLiveData;
    }
}
