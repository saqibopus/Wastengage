package wastengage.valian.com.wastengage.Intro;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import wastengage.valian.com.wastengage.R;


public class IntroFrag1 extends Fragment {

    private ImageView imgImage;
    private TextView tvText;
    private static final String TEXT = "TEXT";
    private static final String URL = "URL";


    public IntroFrag1 getInstance(String text, String url) {
        IntroFrag1 introFrag1 = new IntroFrag1();
        Bundle args = new Bundle();
        args.putString(TEXT, text);
        args.putString(URL, url);
        introFrag1.setArguments(args);
        return introFrag1;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_intro_frag1, container, false);
        init(view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getArguments() != null) {
            Picasso.get()
                    .load(getArguments().getString(URL))
                    .error(R.mipmap.ic_launcher)
                    .into(imgImage);
            tvText.setText(getArguments().getString(TEXT));
        }


    }

    private void init(View v) {
        imgImage = (ImageView) v.findViewById(R.id.imgImage);
        tvText = (TextView) v.findViewById(R.id.tvSlogan);
    }

    public void AnimateBell(View v) {
        Animation shake = AnimationUtils.loadAnimation(getActivity(), R.anim.shakeanimation);
        //ImageView imgBell= (ImageView) v.findViewById(R.id.imgBell);
        // imgBell.setAnimation(shake);
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();

    }


}
