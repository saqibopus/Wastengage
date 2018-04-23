package wastengage.valian.com.wastengage.Networking;

import android.content.Context;

import com.android.volley.Response;
import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.Map;

/**
 * Created by john kana on 12/3/18.
 */

public class NetworkClientBackUP_T<T> {

    private static final String METHOD_POST = "POST";
    private static final String METHOD_GET = "GET";
    private NetworkClientPresenter presenter;
    private Context context;
    private String method;
    private String networkPath;
    private Map<String, String> pathParameter;



    public NetworkClientBackUP_T(Context context, String method, String networkPath, Map<String, String> pathParameter) {
        this.context = context;
        this.method = method;
        this.networkPath = networkPath;
        this.pathParameter = pathParameter;
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
                        presenter.onSuccess(makeClassToObjct(response.toString()));
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
                        presenter.onSuccess(makeClassToObjct(response.toString()));
                    }

                    @Override
                    public void onError(ANError anError) {
                        presenter.onError(anError);
                    }
                });
    }



    private T makeClassToObjct(String object) {
        Gson gson = new GsonBuilder().create();
        Type responseType = new TypeToken<Response<T>>() {}.getType();
        return (T)gson.fromJson(object, responseType);
    }

    public static class NetworkClientBuilder<T> {


        private Context context;
        private String method;
        private String networkPath;
        private Map<String, String> pathParameter;
        private T modelClass;

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

        public NetworkClientBackUP_T build() {
            return new NetworkClientBackUP_T<T>(context, method, networkPath, pathParameter);
        }
    }
}
