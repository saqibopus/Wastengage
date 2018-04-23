package wastengage.valian.com.wastengage.product_listing;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

import wastengage.valian.com.wastengage.R;

/**
 * Created by emxcel on 16/2/18.
 */

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {

    private Activity activity;
    private List<ProductModel> list;


    public ProductAdapter(Activity activity, List<ProductModel> list) {
        this.activity = activity;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_product, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        final ProductModel data = list.get(position);
        Picasso.get()
                .load(data.getImage())
                .placeholder(R.mipmap.ic_launcher)
                .into(holder.productImage);
        holder.name.setText(data.getName());
        holder.price.setText("Price : " + data.getPrice() + "Rs");

        holder.layoutMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(activity,ProductFullView.class);
                i.putExtra("id",data.getId());
                activity.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView productImage;
        TextView name, price;
        CardView layoutMain;
        public ViewHolder(View view) {
            super(view);
            productImage = (ImageView) view.findViewById(R.id.img_product);
            name = (TextView) view.findViewById(R.id.tvName);
            price = (TextView) view.findViewById(R.id.tvPrice);
            layoutMain =(CardView)view.findViewById(R.id.layoutMain);
        }
    }

}
