package olimp.bet.olimpbet.bk.app

import android.content.Context
import android.content.SharedPreferences
import android.os.Build
import android.os.Bundle
import android.telephony.TelephonyManager
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.compose.setContent
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat.getSystemService
import com.google.firebase.ktx.Firebase
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfigSettings
import olimp.bet.olimpbet.bk.app.databinding.FragmentWebBinding

class WebFragment : Fragment() {
    private var binding: FragmentWebBinding? = null
    var sharedPreference: SharedPreferences? = null
    private lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        RemoteConfigUtils.init()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentWebBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        // Inflate the layout for this fragment
        val getUrlFromFirebase = RemoteConfigUtils.getConfigUrl()
        val getUrl = sharedPreference?.getString(getUrlFromFirebase, "")
        if (getUrlFromFirebase != null) {
            Log.d(
                "CheckPref",
                "onCreate: ${getUrl}"
            )
            binding?.webView?.webViewClient = WebViewClient()
            binding?.webView?.loadUrl(getUrlFromFirebase)
            sharedPreference?.edit()?.putString("url", getUrlFromFirebase)
        } else {
            Log.d("Zagl", "onCreateView: $getUrl")
        }
        return binding?.root

    }


        fun urlIntent() {
            val remoteConfig: FirebaseRemoteConfig = Firebase.remoteConfig
            val configSettings = remoteConfigSettings {
                minimumFetchIntervalInSeconds = 3600
            }
            remoteConfig.setConfigSettingsAsync(configSettings)

            val url = remoteConfig.getString("url");
            //       val telMgr = getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
            //          val simState = telMgr.simState

            if (url.isEmpty()
//            || Build.BRAND.contains("google") || Build.SERIAL == "unknown"
//            || simState != TelephonyManager.SIM_STATE_ABSENT
            ) {
                Log.d("Test2", "UrlIntent: ${url}")
                Log.d("Test2", "UrlIntent: ${Build.BRAND.contains("google")}")
                Log.d("Test2", "UrlIntent: ${Build.SERIAL == "unknown"}")

      /*          setContent {
                    GymScreen()
                }*/
            } else {
                Log.d("Test1", "UrlIntent: ${url.isEmpty()}")
                Log.d("Test1", "UrlIntent: ${Build.BRAND.contains("google")}")
                Log.d("Test1", "UrlIntent: ${Build.SERIAL == "unknown"}")


                        WebView(requireContext()).apply {
                            sharedPreference?.edit()?.putString("url", url)
                            webViewClient = WebViewClient()
                            loadUrl(url)
                            Log.d("check_url", "UrlIntent:$url")
                        }
                }
            }
    }