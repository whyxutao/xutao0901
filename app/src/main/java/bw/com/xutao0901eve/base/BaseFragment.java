package bw.com.xutao0901eve.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class BaseFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = View.inflate(getActivity(),getLayoutID(),null);

        initView(view);

        initData();

        return view;
    }

    protected abstract int getLayoutID();

    protected abstract void initView(View view);

    protected abstract void initData();

}
