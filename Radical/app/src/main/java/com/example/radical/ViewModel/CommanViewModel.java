package com.example.radical.ViewModel;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.radical.Model.Commanrepository;
import com.example.radical.Model.ResponseModel.ProductResponse;

public class CommanViewModel extends AndroidViewModel {
    public CommanViewModel(@NonNull Application application) {
        super(application);
    }

    private Commanrepository commanrepository;

    private LiveData<ProductResponse> productResponseLiveData;

    public void init(Context context){
        commanrepository=new Commanrepository(context);
        productResponseLiveData=commanrepository.getproductRequest();
    }
    public void getproductRequest(String projectId, String vendorId){
        commanrepository.getproductRequest(projectId,vendorId);
    }
    public LiveData<ProductResponse> getProductResponseLiveData(){
        return productResponseLiveData;
    }

}
