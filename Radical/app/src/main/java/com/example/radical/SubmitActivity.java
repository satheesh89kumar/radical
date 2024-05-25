package com.example.radical;

import static android.content.ContentValues.TAG;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.radical.Adapter.ProductAdapter;
import com.example.radical.Model.ResponseModel.ProductResponse;
import com.example.radical.ViewModel.CommanViewModel;

import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.Result;

public class SubmitActivity extends AppCompatActivity {
private TextView submitbtn,qrtext,statustext;
private ImageView statusicon,loadericon;
    private    String projectId ;
    private   String vendorId ;
private CommanViewModel commanViewModel;

private RecyclerView recyclerView;
    TextView textView;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.submit_activity);

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        getWindow().setStatusBarColor(getResources().getColor(R.color.white));

        submitbtn =findViewById(R.id.submitbtn);
        qrtext =findViewById(R.id.qr_text);
        statustext=findViewById(R.id.statusupdate);
        statusicon=findViewById(R.id.status_icon);
        //loadericon=findViewById(R.id.loader);
        recyclerView=findViewById(R.id.recycler_view);

        commanViewModel = new ViewModelProvider(this).get(CommanViewModel.class);
        commanViewModel.init(SubmitActivity.this);

        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("scannedData")) {
            String scannedData = intent.getStringExtra("scannedData");
            // Split the string by comma
            String[] parts = scannedData.split(",");

            // Process and print each part
            if (parts.length >= 2) {
                projectId = parts[0]; // First part
                vendorId = parts[1];  // Second part
                Log.d(TAG, "projectId: " + projectId);
                Log.d(TAG, "vendorId: " + vendorId);
                if(!projectId.isEmpty() && !vendorId.isEmpty()){
                    commanViewModel.getproductRequest(projectId,vendorId);
                }
            } else {
                Log.d(TAG, "Invalid scanned data format. Expected format: projectId,vendorId");
            }
        }

        ProductAdapter productAdapter = new ProductAdapter(new ArrayList<>());
        recyclerView.setAdapter(productAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        commanViewModel.getProductResponseLiveData().observe(SubmitActivity.this, new Observer<ProductResponse>() {
            @Override
            public void onChanged(ProductResponse productResponse) {
                if (productResponse != null && !productResponse.isError()) {

                } else {
                    // Handle the error case
                   // Log.d(TAG, "Error in response: " + productResponse.getMessage());
                }
            }
        });

        submitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.getText().toString();
                textView.setVisibility(View.GONE);
                statustext.setVisibility(View.VISIBLE);
                statusicon.setVisibility(View.VISIBLE);
                qrtext.setVisibility(View.GONE);
                //loadericon.setVisibility(View.GONE);
                submitbtn.setVisibility(View.GONE);

            }
        });





    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(SubmitActivity.this, ScanerActivity.class);
        startActivity(intent);
        finish();
    }
}
