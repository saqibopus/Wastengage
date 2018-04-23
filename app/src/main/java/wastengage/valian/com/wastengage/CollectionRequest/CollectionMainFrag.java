package wastengage.valian.com.wastengage.CollectionRequest;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.mlsdev.rximagepicker.RxImagePicker;
import com.mlsdev.rximagepicker.Sources;
import com.squareup.picasso.Picasso;

import io.reactivex.functions.Consumer;
import wastengage.valian.com.wastengage.R;


public class CollectionMainFrag extends Fragment {
    //UI Element
    private EditText etName;
    private EditText etSocietyApartment, etArea, etNeatLocation, etFamousLandmark, etZipcode;
    private EditText etMobileNumber;
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
                RxImagePicker.with(getActivity()).requestImage(Sources.GALLERY).subscribe(new Consumer<Uri>() {
                    @Override
                    public void accept(@NonNull Uri uri) throws Exception {
                        Picasso.get()
                                .load(uri)
                                .error(R.mipmap.ic_launcher)
                                .into(imgSelected);
                    }
                });
            }
        });
        imgCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RxImagePicker.with(getActivity()).requestImage(Sources.CAMERA).subscribe(new Consumer<Uri>() {
                    @Override
                    public void accept(@NonNull Uri uri) throws Exception {
                        Picasso.get()
                                .load(uri)
                                .error(R.mipmap.ic_launcher)
                                .into(imgSelected);
                    }
                });
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
        etName = (EditText) v.findViewById(R.id.etName);
        etSocietyApartment = (EditText) v.findViewById(R.id.etSocietyApartment);
        etArea = (EditText) v.findViewById(R.id.etArea);
        etNeatLocation = (EditText) v.findViewById(R.id.etNearLocation);
        etFamousLandmark = (EditText) v.findViewById(R.id.etFamousLandmark);
        etZipcode = (EditText) v.findViewById(R.id.etZipCode);
        etMobileNumber = (EditText) v.findViewById(R.id.etMobileNumber);
        imgCamera = (ImageView) v.findViewById(R.id.imgCamera);
        imgGallary = (ImageView) v.findViewById(R.id.imgGallary);
        imgSelected = (ImageView) v.findViewById(R.id.imgSelected);
    }

    private void initClasses() {

    }
}
