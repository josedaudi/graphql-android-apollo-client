package dev.encipher.android.graphqlapolloclient.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.apollographql.apollo.ApolloCall
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.exception.*
import dev.encipher.android.graphqlapolloclient.app.schema.UsersQuery
import dev.encipher.android.graphqlapolloclient.app.utils.AplClient

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getUsers()
    }

    private fun getUsers(){
        AplClient().getApolloClient().query(UsersQuery()).toBuilder().build()
            .enqueue(object: ApolloCall.Callback<UsersQuery.Data>() {
                override fun onResponse(response: Response<UsersQuery.Data>) {
                    println("Users List ${response.data?.users?.get(0)?.id}")
                }

                override fun onFailure(e: ApolloException) {

                }
            })

    }
}