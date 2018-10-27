package wastengage.valian.com.wastengage.CollectionRequest;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.androidnetworking.interfaces.UploadProgressListener;
import com.mlsdev.rximagepicker.RxImageConverters;
import com.mlsdev.rximagepicker.RxImagePicker;
import com.mlsdev.rximagepicker.Sources;
import com.squareup.picasso.Picasso;
import org.json.JSONObject;
import java.io.File;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import wastengage.valian.com.wastengage.R;
import wastengage.valian.com.wastengage.helper.Logs;


public class CollectionMainFrag extends Fragment {
    //UI Element

    private EditText etName;
    private EditText etSocietyApartment;
    private EditText etArea;
    private EditText etNearLocation;
    private EditText etFamousLandmark;
    private EditText etZipCode;
    private EditText etMobileNumber;
    private Button btSubmit;
    private File imageFile=null;

    private ImageView imgCamera, imgGallary, imgSelected;
    //Classes

    public CollectionMainFrag() {
        // Required empty public constructor
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_collection_frag, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_collection_main, container, false);
        initUIElement(v);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        imgGallary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RxImagePicker.with(getActivity()).requestImage(Sources.GALLERY)
                        .flatMap(new Function<Uri, ObservableSource<File>>() {
                            @Override
                            public ObservableSource<File> apply(@NonNull Uri uri) throws Exception {
                                Picasso.get()
                                        .load(uri)
                                        .error(R.mipmap.ic_launcher)
                                        .into(imgSelected);
                                return RxImageConverters.uriToFile(getContext(), uri,new File(Environment.getExternalStorageDirectory() + File.separator, "temp.jpg"));
                            }
                        }).subscribe(new Consumer<File>() {
                    @Override
                    public void accept(@NonNull File file) throws Exception {
                        imageFile = file;
                    }
                });
            }
        });


        imgCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RxImagePicker.with(getActivity()).requestImage(Sources.CAMERA)
                        .flatMap(new Function<Uri, ObservableSource<File>>() {
                            @Override
                            public ObservableSource<File> apply(@NonNull Uri uri) throws Exception {
                                Picasso.get()
                                        .load(uri)
                                        .error(R.mipmap.ic_launcher)
                                        .into(imgSelected);
                                return RxImageConverters.uriToFile(getContext(), uri,new File(Environment.getExternalStorageDirectory() + File.separator, "temp.jpg"));
                            }
                        }).subscribe(new Consumer<File>() {
                    @Override
                    public void accept(@NonNull File file) throws Exception {
                        imageFile = file;
                    }
                });
            }
        });
        btSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitData();
            }
        });

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();

    }

    private void initUIElement(View v) {
        imgCamera = (ImageView) v.findViewById(R.id.imgCamera);
        imgGallary = (ImageView) v.findViewById(R.id.imgGallary);
        imgSelected = (ImageView) v.findViewById(R.id.imgSelected);

         etName = (EditText)v.findViewById(R.id.etName);
         etSocietyApartment= (EditText)v.findViewById(R.id.etSocietyApartment);
         etArea= (EditText)v.findViewById(R.id.etArea);
         etNearLocation= (EditText)v.findViewById(R.id.etNearLocation);
         etFamousLandmark= (EditText)v.findViewById(R.id.etFamousLandmark);
         etZipCode= (EditText)v.findViewById(R.id.etZipCode);
         etMobileNumber= (EditText)v.findViewById(R.id.etMobileNumber);
        btSubmit= (Button) v.findViewById(R.id.btSubmit);
    }

    private void submitData(){

        if(etName.getText().toString().equals("")){
            etName.setError("Please Enter Name");
            return;
        }
        if(etSocietyApartment.getText().toString().equals("")){
            etSocietyApartment.setError("Please Enter Society Name");
            return;
        }
        if(etArea.getText().toString().equals("")){
            etArea.setError("Please Enter Area");
            return;
        }
        if(etNearLocation.getText().toString().equals("")){
            etNearLocation.setError("Please Enter near location");
            return;
        }
        if(etFamousLandmark.getText().toString().equals("")){
            etFamousLandmark.setError("Please Enter Landmark");
            return;
        }
        if(etZipCode.getText().toString().equals("")){
            etZipCode.setError("Please Enter Zip code");
            return;
        }
        if(etMobileNumber.getText().toString().equals("")){
            etMobileNumber.setError("Please Enter Mobile number");
            return;
        }

        if (imageFile == null){
            Toast.makeText(getActivity(),"Please Select Image",Toast.LENGTH_SHORT).show();
            return;
        }

        Logs.p("waste : file uri : "+imageFile.getPath());

        AndroidNetworking.upload("http://wastengage.com/api/public/updateUser")
                .addMultipartFile("image",imageFile)
                .addMultipartParameter("name",etName.getText().toString())
                .addMultipartParameter("society",etSocietyApartment.getText().toString())
                .addMultipartParameter("area",etArea.getText().toString())
                .addMultipartParameter("near_location",etNearLocation.getText().toString())
                .addMultipartParameter("famous_landmark",etFamousLandmark.getText().toString())
                .addMultipartParameter("zip_code",etZipCode.getText().toString())
                .addMultipartParameter("mobile_number",etMobileNumber.getText().toString())
                .setTag("uploadTest")
                .setPriority(Priority.HIGH)
                .build()
                .setUploadProgressListener(new UploadProgressListener() {
                    @Override
                    public void onProgress(long bytesUploaded, long totalBytes) {
                        Logs.p("waste : "+bytesUploaded +" from :"+totalBytes);
                    }
                })
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Logs.p("waste : onResponse :"+response);
                    }
                    @Override
                    public void onError(ANError error) {
                        Logs.p("waste : onError :1"+error.getErrorBody());
                        Logs.p("waste : onError :2"+error.getErrorDetail());
                        Logs.p("waste : onError :3"+error.getErrorCode());
                        Logs.p("waste : onError :4"+error.getResponse());
                        Logs.p("waste : onError :5"+error.getMessage());
                        Logs.p("waste : onError :6"+error.getCause());
                        Logs.p("waste : onError :7"+error.getLocalizedMessage());
                        Logs.p("waste : onError :8:"+error.getStackTrace());
                    }
                });
    }
}
