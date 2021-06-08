package com.example.firebasedemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.firebasedemo.R;
import com.example.firebasedemo.adapter.ImageAdapter;
import com.example.firebasedemo.adapter.ImageProfileAdapter;
import com.example.firebasedemo.model.getall.Welcome;
import com.example.firebasedemo.model.user.WelcomeUser;
import com.example.firebasedemo.service.ImageService;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


public class ImageProfileActivity extends AppCompatActivity {
    private LinearLayout profileInformation;
    private RecyclerView recycleImageProfile;
    private ImageProfileAdapter adapter;
    private ProgressBar progressBarImageProfile;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_profile);
//        initView();
    }

    private void initView() {
        adapter = new ImageProfileAdapter(this);
        progressBarImageProfile=findViewById(R.id.progressBarImageProfile);
        progressBarImageProfile.setVisibility(View.VISIBLE);
        recycleImageProfile = findViewById(R.id.recycleImageProfile);
        recycleImageProfile.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));
    }

//    private void callService() {
//        Observable<List<Welcome>> cryptoObservable = ImageService.createService().
//                getRandomImagesWithTopic(idTopic,1, ImageService.clientId);
//
//        cryptoObservable.subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(this::handleResults, this::handleError);
//        // xư lý bất đồng bộ, khi get data sẽ xử lý trên một luồng it riêng,
//        // k ảnh hg đến luồng chính
//    }
    private void handleError(Throwable throwable) {
        Log.d("AppLog",throwable.toString());
    }

    private void handleResults(List<WelcomeUser> welcomeUsers) {
        adapter.setListImage(welcomeUsers);
        recycleImageProfile.setAdapter(adapter);
        progressBarImageProfile.setVisibility(View.GONE);

    }
}
