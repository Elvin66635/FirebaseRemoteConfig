package olimp.bet.olimpbet.bk.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class GymActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gym)

        Log.d("GymActivity", "onCreate: ")
    }
}