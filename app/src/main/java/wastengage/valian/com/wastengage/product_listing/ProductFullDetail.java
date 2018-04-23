package wastengage.valian.com.wastengage.product_listing;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by emxcel on 11/4/18.
 */

public class ProductFullDetail {

    @SerializedName("status")
    public String status;

    @SerializedName("data")
    public List<ProductFullDetailData> data;

    public List<ProductFullDetailData> getData() {
        return data;
    }

    public void setData(List<ProductFullDetailData> data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}
