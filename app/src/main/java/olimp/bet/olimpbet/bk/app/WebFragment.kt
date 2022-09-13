package olimp.bet.olimpbet.bk.app

import android.annotation.SuppressLint
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
import android.view.WindowManager
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat.getSystemService
import androidx.navigation.fragment.findNavController
import com.google.firebase.ktx.Firebase
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfigSettings
import olimp.bet.olimpbet.bk.app.databinding.FragmentWebBinding

class WebFragment : Fragment() {
    private var binding: FragmentWebBinding? = null
    var sharedPreference: SharedPreferences? = null
    var configBackground: FirebaseRemoteConfig? = null
    var result: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        configBackground = FirebaseRemoteConfig.getInstance()
        result = configBackground?.getString("url")
        Log.d("resultConfigOnCreate", "Result: $result")

        sharedPreference = activity?.getPreferences(Context.MODE_PRIVATE) ?: return
        with (sharedPreference?.edit()) {
            this?.putString("url", result)
            this?.apply()
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentWebBinding.inflate(inflater, container, false)
        binding = fragmentBinding

        val sharedString = sharedPreference?.getString("url", "")
        Log.d("OnCreateView", "Result shared string: $sharedString")

        val telMgr = activity?.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
        val simState = telMgr.simState

        if (sharedString?.isEmpty() == true || Build.BRAND.contains("google") || Build.SERIAL == "unknown"
            || simState != TelephonyManager.SIM_STATE_ABSENT) {
            Log.d("nullUrl", "onCreateView: $sharedString")
            findNavController().navigate(R.id.action_webFragment_to_gymFragment)
        }else {
            binding?.webView?.webViewClient = WebViewClient()
            binding?.webView?.apply {
                    loadUrl(sharedString!!)
            }
        }
        return binding?.root
    }

    override fun onResume() {
        super.onResume()
        activity?.window?.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)

    }

    override fun onPause() {
        super.onPause()
        activity?.window?.clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)

        // Clear the systemUiVisibility flag
        activity?.window?.decorView?.systemUiVisibility = 0
    }
}