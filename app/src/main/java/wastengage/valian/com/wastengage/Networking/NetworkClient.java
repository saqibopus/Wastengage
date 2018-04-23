package wastengage.valian.com.wastengage.Networking;

import android.content.Context;

import com.android.volley.Response;
import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.Calendar;
import java.util.Map;

import wastengage.valian.com.wastengage.aboutus.Model.AboutUsModel;

/**
 * Created by john kana on 12/3/18.
 */

public class NetworkClient<T> {

    private static final String METHOD_POST = "POST";
    private static final String METHOD_GET = "GET";
    private NetworkClientPresenter presenter;
    private Context context;
    private String method;
    private String networkPath;
    private Map<String, String> pathParameter;
    private Class<T> responseType;



    public NetworkClient(Context context, String method, String networkPath, Map<String, String> pathParameter,Class<T> responseType) {
        this.context = context;
        this.method = method;
        this.networkPath = networkPath;
        this.pathParameter = pathParameter;
        this.responseType=responseType;
    }


    public void requestAsync(NetworkClientPresenter presenter) {
        this.presenter = presenter;
        if (method.equalsIgnoreCase(METHOD_POST))
            makeRequestPost();
        else
            makeRequestGet();
    }


    private void makeRequestPost() {

        AndroidNetworking.post(networkPath)
                .addPathParameter(pathParameter)
                .setTag(this)
                .setPriority(Priority.LOW)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        presenter.onSuccess((T)makeClassToObjct(response.toString(),responseType));
                    }

                    @Override
                    public void onError(ANError anError) {
                        presenter.onError(anError);
                    }
                });

    }

    private void makeRequestGet() {

        AndroidNetworking.get(networkPath)
                .addPathParameter(pathParameter)
                .setTag(this)
                .setPriority(Priority.LOW)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        presenter.onSuccess(makeClassToObjct(response.toString(),responseType));
                    }

                    @Override
                    public void onError(ANError anError) {
                        presenter.onError(anError);
                    }
                });
    }



    private T makeClassToObjct(String object, Class<T> t) {
        Gson gson = new GsonBuilder().create();
        return gson.fromJson(object,t);
    }



    public static class NetworkClientBuilder<T> {


        private Context context;
        private String method;
        private String networkPath;
        private Map<String, String> pathParameter;
        private Class responceType;

        public NetworkClientBuilder() {

        }

        public NetworkClientBuilder setMethod(String method) {
            this.method = method;
            return this;
        }

        public NetworkClientBuilder setNetworkPath(String networkPath) {
            this.networkPath = networkPath;
            return this;
        }

        public NetworkClientBuilder setParameter(Map<String, String> pathParameter) {
            this.pathParameter = pathParameter;
            return this;
        }
        public NetworkClientBuilder setResponceType(Class responceType) {
            this.responceType = responceType;
            return this;
        }

        public NetworkClient build() {
            return new NetworkClient(context, method, networkPath, pathParameter,responceType);
        }
    }
}
