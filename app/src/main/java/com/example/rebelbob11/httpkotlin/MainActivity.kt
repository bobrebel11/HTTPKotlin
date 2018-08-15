package com.example.rebelbob11.httpkotlin

import android.content.Context
import android.net.NetworkInfo
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    //4672493

    val NURL = "https://simplifiedcoding.net/demos/marvel/"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE)

        Log.e("CONN MNGR","CONN INFO"+connectivityManager)


        val url = URL(NURL)

        Thread(Runnable {

            try {

                var urlConnection:HttpURLConnection = url.openConnection() as HttpURLConnection

                var inputStream = urlConnection.inputStream
                var reader = InputStreamReader(inputStream)
                var bufferedReader = BufferedReader(reader)

                var stringBuilder:StringBuilder = StringBuilder()

                var tempString:String
                tempString = bufferedReader.toString()

                while (true){

                    stringBuilder.append(tempString)
                    stringBuilder.append("/n")

                }

                Log.d("STRING BUILDER", ""+stringBuilder.toString())



            }
            catch (e:Exception){
                e.printStackTrace()
            }

        }).start()



        //request to open the socket for communication





    }
}
