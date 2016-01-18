import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;

/**
 * Created by Aluno on 18/01/2016.
 */
public class BootReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        //Log.i("BOOT", "Boot Compleed!");
        Intent it = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:555"));
        it.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(it);
        //context.startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:555")));
    }


}
