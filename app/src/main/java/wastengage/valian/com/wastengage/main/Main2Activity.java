package wastengage.valian.com.wastengage.main;

import android.os.Bundle;
import android.support.constraint.solver.Goal;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.androidnetworking.error.ANError;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import wastengage.valian.com.wastengage.MainActivity;
import wastengage.valian.com.wastengage.Networking.NetworkClient;
import wastengage.valian.com.wastengage.Networking.NetworkClientPresenter;
import wastengage.valian.com.wastengage.R;
import wastengage.valian.com.wastengage.aboutus.Model.AboutUsModel;

public class Main2Activity extends AppCompatActivity implements NetworkClientPresenter{
    private TextView tvData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        tvData = (TextView)findViewById(R.id.data);
        NetworkClient<AboutUsModel> data = new NetworkClient.NetworkClientBuilder<AboutUsModel>()
                                                .setMethod("GET")
                                                .setResponceType(AboutUsModel.class)
                                                .setNetworkPath("https://dog.ceo/api/breeds/list")
                                                .setParameter(null)
                                                .build();

        data.requestAsync(this);


        Iterator it = new ArrayList<String>().iterator();

        Set set = new HashSet();


    }

    @Override
    public void onError(ANError anError) {
        Toast.makeText(Main2Activity.this,"onError",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSuccess(Object o) {
        Toast.makeText(Main2Activity.this,"onSuccess",Toast.LENGTH_SHORT).show();
        Gson gson = new Gson();

        System.out.println("----**"+gson.toJson(o));
        tvData.setText(gson.toJson(o));
        AboutUsModel data = (AboutUsModel)o;
        System.out.println("----**status :"+data.getStatus());
    }


    @Override
    public void onMessage() {
        Toast.makeText(Main2Activity.this,"onMessage",Toast.LENGTH_SHORT).show();
    }
}
