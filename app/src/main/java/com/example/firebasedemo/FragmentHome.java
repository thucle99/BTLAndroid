package com.example.firebasedemo;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import com.example.firebasedemo.FragmentTopic.FragmentBottomAdapterTab;
import com.google.android.material.tabs.TabLayout;

public class FragmentHome extends Fragment {
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable
            ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_home, container, false);
        TabLayout tabLayout = view.findViewById(R.id.tab);
        ViewPager viewPager = view.findViewById(R.id.viewPager);
        FragmentManager manager = getActivity().getSupportFragmentManager();

        FragmentBottomAdapterTab adapter = new FragmentBottomAdapterTab(manager,
                FragmentBottomAdapterTab.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        return view;
    }


//    private RecyclerView recyclerView;
//    private ImageAdapter imageAdapter;
//    private ProgressBar progressBarLoadingHome;
//    @Nullable
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
//                             @Nullable Bundle savedInstanceState) {
//        View view =  inflater.inflate(R.layout.fragment_home, container, false);
//        imageAdapter = new ImageAdapter(getContext());
//        progressBarLoadingHome=view.findViewById(R.id.progressBarLoadingHome);
//        progressBarLoadingHome.setVisibility(View.VISIBLE);
//        recyclerView = view.findViewById(R.id.recycleHome);
//        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));
////      dữ liệu ảnh trên mộ hàng,  chiều rộng bằng nhau, chiều dài co dãn
//
//        callService();
//        return view;
//    }
//    private void callService() {
//        Observable<List<Welcome>> cryptoObservable = ImageService.createService().
//                getRandomImages(1, ImageService.clientId);
//
//        cryptoObservable.subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(this::handleResults, this::handleError);
//        // xư lý bất đồng bộ, khi get data sẽ xử lý trên một luồng it riêng,
//        // k ảnh hg đến luồng chính
//    }
//    private void handleError(Throwable throwable) {
//        Log.d("AppLog",throwable.toString());
//    }
//
//    private void handleResults(List<Welcome> welcomes) {
//        imageAdapter.setListImage(welcomes);
//        recyclerView.setAdapter(imageAdapter);
//        progressBarLoadingHome.setVisibility(View.GONE);
//
//    }
}
