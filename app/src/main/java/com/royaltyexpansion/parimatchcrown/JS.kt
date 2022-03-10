package com.royaltyexpansion.parimatchcrown

import android.content.Context
import com.orhanobut.hawk.Hawk
import com.royaltyexpansion.parimatchcrown.Constants.Campaign1
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.jsoup.Jsoup

class JS(val context: Context) {
    private var jsoup: String? = "null"
    private val hawk : String? = Hawk.get(Campaign1)

    private var forJsoupSetNaming: String = Constants.FilterLink + Constants.subber1 + hawk
    suspend fun getDocSecretKey(): String?{
        withContext(Dispatchers.IO){
            val doc = Jsoup.connect(forJsoupSetNaming).get()
            jsoup = doc.text().toString()
        }
        return jsoup
    }
}