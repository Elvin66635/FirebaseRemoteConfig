package olimp.bet.olimpbet.bk.app

import android.app.Application
import android.util.Log
import com.google.firebase.remoteconfig.FirebaseRemoteConfig

class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        FirebaseRemoteConfig.getInstance().fetchAndActivate().apply {
            addOnCompleteListener {
                if (it.isCanceled || !it.isSuccessful) {
                    Log.d("felipe", "Not successful or canceled")
                } else
                    Log.d("felipe", "Success")
            }
        }
    }
}