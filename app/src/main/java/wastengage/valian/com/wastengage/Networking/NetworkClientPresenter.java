package wastengage.valian.com.wastengage.Networking;

import com.androidnetworking.error.ANError;

/**
 * Created by john sina on 12/3/18.
 */

public interface NetworkClientPresenter<T> {

    void onError(ANError anError);
    void onSuccess(T t);
    void onMessage();
}
