package wastengage.valian.com.wastengage.product_listing;

import com.google.gson.annotations.SerializedName;

/**
 * Created by emxcel on 16/2/18.
 */

public class ProductModel {
    @SerializedName("id")
    public String id;
    @SerializedName("type")
    public String type;
    @SerializedName("typeId")
    public String typeId;
    @SerializedName("name")
    public String name;
    @SerializedName("price")
    public String price;
    @SerializedName("shortDesc")
    public String shortDesc;
    @SerializedName("image")
    public String image;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public ProductModel(String id, String type, String typeId, String name, String price, String shortDesc, String image) {

        this.id = id;
        this.type = type;
        this.typeId = typeId;
        this.name = name;
        this.price = price;
        this.shortDesc = shortDesc;
        this.image = image;
    }
}
