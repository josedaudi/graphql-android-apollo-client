package dev.encipher.android.graphqlapolloclient.app.utils

import com.apollographql.apollo.ApolloClient
import okhttp3.OkHttpClient

class AplClient {

    private val BASE_URL  = "https://encipher-graphql-app.herokuapp.com/graphql"
    private lateinit var mApolloClient: ApolloClient

    fun getApolloClient(): ApolloClient {
        val okHttpClient = OkHttpClient.Builder().build()
        mApolloClient = ApolloClient.builder()
            .serverUrl(BASE_URL)
            .okHttpClient(okHttpClient)
            .build()

        return mApolloClient
    }
}