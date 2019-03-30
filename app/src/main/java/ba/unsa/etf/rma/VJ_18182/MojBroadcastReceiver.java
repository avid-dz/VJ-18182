package ba.unsa.etf.rma.VJ_18182;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

public class MojBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        ConnectivityManager connectivityManager =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo == null) {
            Toast.makeText(context, R.string.toast_nema_konekcije, Toast.LENGTH_SHORT).show();
            return;
        }
        if (!networkInfo.isConnected())
            Toast.makeText(context, R.string.toast_nema_konekcije, Toast.LENGTH_SHORT).show();
    }
}
