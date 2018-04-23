package wastengage.valian.com.wastengage.Networking;

import android.content.Context;
import android.os.AsyncTask;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.InputStream;

import wastengage.valian.com.wastengage.product_listing.ProductFullDetail;
import wastengage.valian.com.wastengage.product_listing.ProductFullView;
import wastengage.valian.com.wastengage.product_listing.Products;

/**
 * Created by emxcel on 10/4/18.
 */

public class LocalParser {
    private Context context;

    public LocalParser(Context context) {
        this.context = context;
    }

    private static final String productList = "product_list.json";
    private static final String productDetail = "product_detail.json";


    public String loadJSONFromAsset(String fileName) {
        String json = null;
        try {
            InputStream is = context.getAssets().open(fileName.trim());
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    public Products getProductList() {
        String obj = null;
        try {
            obj = loadJSONFromAsset(productList);
            System.out.println("----**json string :" + obj);
        } catch (Exception e) {
            System.out.println("----**LocalParser->getProductList()");
        }
        return convertToProducts(obj);
    }

    private Products convertToProducts(String obj) {
        Gson gson = new GsonBuilder().create();
        return gson.fromJson(obj, Products.class);
    }
    private ProductFullDetail convertToProductFullDetail(String obj) {
        Gson gson = new GsonBuilder().create();
        return gson.fromJson(obj, ProductFullDetail.class);
    }

    public ProductFullDetail getProductFullDetail(){
        String obj = null;
        try {
            obj = loadJSONFromAsset(productDetail);
            System.out.println("----**json string :" + obj);
        } catch (Exception e) {
            System.out.println("----**LocalParser->getProductList()");
        }
        return convertToProductFullDetail(obj);
    }

}
