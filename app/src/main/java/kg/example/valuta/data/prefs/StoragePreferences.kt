package kg.example.valuta.data.prefs

import android.content.Context

class StoragePreferences(context: Context) : BasePrefs(context) {

    override val prefFileName: String
        get() = "kg.o.internlabs.core.data.local.prefs"

    var currents: String by PrefDelegate(sharedPreference, Keys.CURRENT, "test")
    var current2: String by PrefDelegate(sharedPreference, Keys.CURRENT2, "test")


    object Keys {

        const val CURRENT = "CURRENT"
        const val CURRENT2 = "CURRENT2"
    }
}