package wastengage.valian.com.wastengage.product_listing;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import wastengage.valian.com.wastengage.Networking.LocalParser;
import wastengage.valian.com.wastengage.R;
import wastengage.valian.com.wastengage.helper.Logs;

public class ProductFullView extends AppCompatActivity {


    private Toolbar toolbar;
    private LocalParser parser;
    private List<ProductFullDetailData> detailList = null;
    private ProductFullDetailData detail = null;
    private ImageView imgProduct;
    private TextView  tvPrice, tvFullDetail;
    private Button btButton;
    private String id="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_full_view);
        try{
            id = getIntent().getExtras().getString("id");
            Logs.p("id: "+id);
        }catch (Exception e){

        }

        init();
        initToolbar();
        loadData();
        setData();




    }

    private void init() {
        parser = new LocalParser(ProductFullView.this);

        imgProduct = (ImageView)findViewById(R.id.imgProduct);
        btButton = (Button) findViewById(R.id.btAddToCart);
        tvPrice = (TextView) findViewById(R.id.tvPrice);
        tvFullDetail = (TextView) findViewById(R.id.tvFullDetail);
    }

    private void initToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(false);
        toolbar.setNavigationIcon(R.drawable.ic_left_arrow);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProductFullView.this.finish();
            }
        });
    }

    private void setData() {
        setTitle(detail.name);
        tvFullDetail.setText(Html.fromHtml(detail.fullDesc));
        tvPrice.setText("Price : "+detail.price+" Rs");

        Picasso.get()
                .load(detail.image)
                .placeholder(R.mipmap.ic_launcher)
                .into(imgProduct);
    }

    private void loadData() {
        detailList = parser.getProductFullDetail().getData();
        for (int i=0;i<detailList.size();i++){
            ProductFullDetailData data = detailList.get(i);
            if(data.getId().equalsIgnoreCase(id)){
                detail = data;
                return;
            }
        }
        setData();
    }


}
