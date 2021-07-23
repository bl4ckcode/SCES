package com.bl4ckcode.sces.util.sharedpreferences

import android.content.Context
import android.content.SharedPreferences

interface IPreferenceHelper {
    fun setApiKey(apiKey: String)
    fun getApiKey(): String
    fun setEmail(email: String)
    fun getEmailKey(): String
    fun setPassword(password: String)
    fun getPassword(): String
    fun setClientId(id: String)
    fun getClientId(): String
    fun clearPrefs()
}

open class PreferenceManager constructor(context: Context) : IPreferenceHelper {
    private val PREFS_NAME = "SharedPreferenceDemo"
    private var preferences: SharedPreferences =
        context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    override fun setApiKey(apiKey: String) {
        preferences[API_KEY] = apiKey
    }

    override fun getApiKey(): String {
        return preferences[API_KEY] ?: ""
    }

    override fun setEmail(email: String) {
        preferences[EMAIL] = email
    }

    override fun getEmailKey(): String {
        return preferences[EMAIL] ?: ""
    }

    override fun setPassword(password: String) {
        preferences[PASSWORD] = password
    }

    override fun getPassword(): String {
        return preferences[PASSWORD] ?: ""
    }

    override fun setClientId(id: String) {
        preferences[CLIENT_ID] = id
    }

    override fun getClientId(): String {
        return preferences[CLIENT_ID] ?: ""
    }


    override fun clearPrefs() {
        preferences.edit().clear().apply()
    }

    companion object {
        const val API_KEY = "api_key"
        const val EMAIL = "email"
        const val PASSWORD = "password"
        const val CLIENT_ID = "client_id"
    }
}

private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
    val editor = this.edit()
    operation(editor)
    editor.apply()
}

private operator fun SharedPreferences.set(key: String, value: Any?) {
    when (value) {
        is String? -> edit { it.putString(key, value) }
        is Int -> edit { it.putInt(key, value) }
        is Boolean -> edit { it.putBoolean(key, value) }
        is Float -> edit { it.putFloat(key, value) }
        is Long -> edit { it.putLong(key, value) }
        else -> throw UnsupportedOperationException("Not yet implemented")
    }
}

private inline operator fun <reified T : Any> SharedPreferences.get(
    key: String,
    defaultValue: T? = null
): T? {
    return when (T::class) {
        String::class -> getString(key, defaultValue as? String) as T?
        Int::class -> getInt(key, defaultValue as? Int ?: -1) as T?
        Boolean::class -> getBoolean(key, defaultValue as? Boolean ?: false) as T?
        Float::class -> getFloat(key, defaultValue as? Float ?: -1f) as T?
        Long::class -> getLong(key, defaultValue as? Long ?: -1) as T?
        else -> throw UnsupportedOperationException("Not yet implemented")
    }
}