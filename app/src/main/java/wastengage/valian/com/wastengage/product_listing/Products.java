package wastengage.valian.com.wastengage.product_listing;

import android.widget.LinearLayout;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by emxcel on 10/4/18.
 */

public class Products {
    @SerializedName("status")
    public String status;
    @SerializedName("products")
    public List<ProductModel> list;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ProductModel> getList() {
        return list;
    }

    public void setList(List<ProductModel> list) {
        this.list = list;
    }
}
