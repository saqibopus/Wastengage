package wastengage.valian.com.wastengage.product_listing;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import wastengage.valian.com.wastengage.Networking.LocalParser;
import wastengage.valian.com.wastengage.R;
import wastengage.valian.com.wastengage.helper.Logger;


public class FragmentProductListing extends Fragment {

    private List<ProductModel> list;
    private RecyclerView recyclerView;
    private ProductAdapter adapter = null;
    private LocalParser localParser;

    public FragmentProductListing() {
        // Required empty public constructor
    }

    public static FragmentProductListing newInstance(String param1, String param2) {
        FragmentProductListing fragment = new FragmentProductListing();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_fragment_product_listing, container, false);
        initClass();
        initRecycleView(v);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    private void initClass() {
        localParser = new LocalParser(getActivity());
        list = getList();
    }

    private void initRecycleView(View v) {
        recyclerView = v.findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        //recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(8), true));
        recyclerView.setNestedScrollingEnabled(false);
        adapter = new ProductAdapter(getActivity(), list);
        recyclerView.setAdapter(adapter);
    }

    private List<ProductModel> getList() {
        return localParser.getProductList().getList();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }



}
