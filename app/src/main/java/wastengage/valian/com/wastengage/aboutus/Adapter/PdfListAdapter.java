package wastengage.valian.com.wastengage.aboutus.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import wastengage.valian.com.wastengage.R;
import wastengage.valian.com.wastengage.aboutus.Model.PdfListModel;

/**
 * Created by emxcel on 10/3/18.
 */

public class PdfListAdapter extends RecyclerView.Adapter<PdfListAdapter.MyViewHolder> {

    private Context context;
    private List<PdfListModel> list;

    public PdfListAdapter(Context context, List<PdfListModel> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_pdf_list, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        PdfListModel data = list.get(position);
        holder.title.setText(data.getPdfName());
        holder.download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"data",Toast.LENGTH_SHORT).show();
            }
        });
        holder.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"title",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public ImageView download;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.pdfName);
            download = (ImageView)view.findViewById(R.id.pdfDownloadIcon);
        }
    }
}
