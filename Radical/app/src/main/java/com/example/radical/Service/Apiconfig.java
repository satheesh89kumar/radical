package com.example.radical.Service;

import static com.example.radical.Service.ApiConstant.projectItems;

import com.example.radical.Model.ResponseModel.ProductResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Apiconfig {

    @GET(projectItems)
    Call<ProductResponse> getproductRequest(@Path("projectId") String projectId,@Path("vendorId") String vendorId);

}
