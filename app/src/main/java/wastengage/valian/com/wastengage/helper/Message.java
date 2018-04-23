package wastengage.valian.com.wastengage.helper;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by john lenon on 12/3/18.
 */

public class Message {
    private Context context;

    public Message(Context context) {
        this.context = context;
    }
    public void tShort(String s){
        Toast.makeText(context,s,Toast.LENGTH_SHORT).show();
    }
    public void tLong(String s){
        Toast.makeText(context,s,Toast.LENGTH_LONG).show();
    }
    public void tDebugShort(String s){
        Toast.makeText(context,s,Toast.LENGTH_SHORT).show();
    }
    public void tDebugLong(String s){
        Toast.makeText(context,s,Toast.LENGTH_LONG).show();
    }
}

