package com.example.firebasedemo.FragmentTopic;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.firebasedemo.R;
import com.example.firebasedemo.adapter.ImageAdapter;
import com.example.firebasedemo.model.getall.Welcome;
import com.example.firebasedemo.service.ImageService;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class FragmentTab extends Fragment {
    private RecyclerView recyclerView;
    private ImageAdapter imageAdapter;
    private ProgressBar progressBarLoadingHome;
    private String idTopic;

    public FragmentTab(String idTopic){
        this.idTopic=idTopic;

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable
            ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return inflater.inflate(R.layout.fragment_tab1,container,false);
        View view =  inflater.inflate(R.layout.fragment_tab, container, false);
        imageAdapter = new ImageAdapter(getContext());
        progressBarLoadingHome=view.findViewById(R.id.progressBarLoadingHome);
        progressBarLoadingHome.setVisibility(View.VISIBLE);
        recyclerView = view.findViewById(R.id.recycleHome);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));
//      dữ liệu ảnh trên mộ hàng,  chiều rộng bằng nhau, chiều dài co dãn

        callService();
        return view;
    }

    private void callService() {
        Observable<List<Welcome>> cryptoObservable = ImageService.createService().
                getRandomImagesWithTopic(idTopic,1, ImageService.clientId);

        cryptoObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleResults, this::handleError);
        // xư lý bất đồng bộ, khi get data sẽ xử lý trên một luồng it riêng,
        // k ảnh hg đến luồng chính
    }
    private void handleError(Throwable throwable) {
        Log.d("AppLog",throwable.toString());
    }

    private void handleResults(List<Welcome> welcomes) {
        imageAdapter.setListImage(welcomes);
        recyclerView.setAdapter(imageAdapter);
        progressBarLoadingHome.setVisibility(View.GONE);

    }
}
