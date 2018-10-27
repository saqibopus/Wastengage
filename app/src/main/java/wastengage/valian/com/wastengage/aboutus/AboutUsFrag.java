package wastengage.valian.com.wastengage.aboutus;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

import wastengage.valian.com.wastengage.R;
import wastengage.valian.com.wastengage.aboutus.Adapter.PdfListAdapter;
import wastengage.valian.com.wastengage.aboutus.Model.PdfListModel;
import wastengage.valian.com.wastengage.helper.ItemOffsetDecoration;

/**
 * A simple {@link Fragment} subclass.
 */
public class AboutUsFrag extends Fragment {

    private RecyclerView recyclerView;
    private PdfListAdapter adapter;
    private List<PdfListModel> list;

    private LinearLayout layoutManager;
    private WebView webViewService,webViewAboutUs,webViewContactUs;

    private LinearLayout layoutAboutUs, layoutServices, layoutContactUs;
    private RadioGroup radioGroup;

    public AboutUsFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_about_us, container, false);
        init(v);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        layoutAboutUs.setVisibility(View.VISIBLE);
        layoutServices.setVisibility(View.GONE);
        layoutContactUs.setVisibility(View.GONE);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radioAboutUs:
                        layoutAboutUs.setVisibility(View.VISIBLE);
                        layoutServices.setVisibility(View.GONE);
                        layoutContactUs.setVisibility(View.GONE);
                        break;
                    case R.id.radioiServices:
                        layoutServices.setVisibility(View.VISIBLE);
                        layoutAboutUs.setVisibility(View.GONE);
                        layoutContactUs.setVisibility(View.GONE);
                        break;
                    case R.id.radioContactUs:
                        layoutContactUs.setVisibility(View.VISIBLE);
                        layoutServices.setVisibility(View.GONE);
                        layoutAboutUs.setVisibility(View.GONE);
                        break;
                    default:
                        break;
                }
            }
        });

    }

    private void init(View v) {
        initClass();
        initRecycleView(v);
        initView(v);
        setAdapter();
    }

    private void initView(View v) {
        layoutManager = (LinearLayout) v.findViewById(R.id.layoutContainer);

        layoutAboutUs = (LinearLayout) v.findViewById(R.id.layoutAboutUs);
        layoutServices = (LinearLayout) v.findViewById(R.id.layoutServices);
        layoutContactUs = (LinearLayout) v.findViewById(R.id.layoutContactUs);

        radioGroup = (RadioGroup) v.findViewById(R.id.radioGroup1);
        webViewService = (WebView) v.findViewById(R.id.webviewServices);
        webViewService.setWebViewClient(new MyBrowser());
        webViewAboutUs = (WebView) v.findViewById(R.id.webviewAboutUs);
        webViewAboutUs.setWebViewClient(new MyBrowser());
        webViewContactUs = (WebView) v.findViewById(R.id.webviewContactUs);
        webViewContactUs.setWebViewClient(new MyBrowser());

        webViewService.loadUrl("http://wastengage.com/?page_id=6");
        webViewAboutUs.loadUrl("http://wastengage.com/?page_id=6");
        webViewContactUs.loadUrl("http://wastengage.com/?page_id=6");


    }

    private void initClass() {

    }

    private void initRecycleView(View v) {
        recyclerView = (RecyclerView) v.findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new ItemOffsetDecoration(5));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    private void setAdapter() {
        adapter = new PdfListAdapter(getActivity(), getList());
        if (recyclerView != null) {
            recyclerView.setAdapter(adapter);
        }
    }

    private List<PdfListModel> getList() {
        List<PdfListModel> models = new ArrayList<>();
        models.add(new PdfListModel(1, "i am name1 i am name1 i am name1 i am name1", "image", "https://cran.r-project.org/doc/manuals/r-release/R-data.pdf"));
        models.add(new PdfListModel(1, "i am name2", "image", "https://repository.up.ac.za/dspace/bitstream/handle/2263/27367/03chapter3.pdf"));
        models.add(new PdfListModel(1, "i am name3", "image", "https://cran.r-project.org/doc/manuals/r-release/R-data.pdf"));
        models.add(new PdfListModel(1, "i am name1", "image", "https://cran.r-project.org/doc/manuals/r-release/R-data.pdf"));
        models.add(new PdfListModel(1, "i am name2", "image", "https://repository.up.ac.za/dspace/bitstream/handle/2263/27367/03chapter3.pdf"));
        models.add(new PdfListModel(1, "i am name3", "image", "https://cran.r-project.org/doc/manuals/r-release/R-data.pdf"));
        return models;
    }

    private class MyBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }

}
