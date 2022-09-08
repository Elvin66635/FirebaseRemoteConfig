package olimp.bet.olimpbet.bk.app

import android.app.Application

class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        RemoteConfigUtils.init()
    }
}