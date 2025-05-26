package com.example.sheilaapi

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.json.JSONException
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    var tvResult: TextView? = null
    var btnFetch: Button? = null
    var url: String = "https://sheila-api.free.beeceptor.com/api/path"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvResult = findViewById(R.id.txtResult)
        btnFetch = findViewById(R.id.btnRequest)

        btnFetch?.setOnClickListener {
            val queue: RequestQueue = Volley.newRequestQueue(this)
            val request = JsonObjectRequest(Request.Method.GET, url, null,
                { response ->
                    try {
                        val data: JSONObject = response.getJSONObject("data")

                        val nama = data.getString("Nama")
                        val nim = data.getString("NIM")
                        val perguruanTinggi = data.getString("Perguruan Tinggi")
                        val programStudi = data.getString("Program Studi")
                        val hobi = data.getString("Hobi")
                        val usia = data.getString("Usia")


                        val resultText = """
                            Nama: $nama
                            NIM:  $nim
                            Perguruan Tinggi: $perguruanTinggi
                            Program Studi: $programStudi
                            Hobi: $hobi
                            Usia: $usia
                            
                        """.trimIndent()

                        tvResult?.text = resultText
                    } catch (e: JSONException) {
                        e.printStackTrace()
                        tvResult?.text = "JSON Parsing Error!"
                    }
                },
                { error ->
                    tvResult?.text = "Request Failed: ${error.message}"
                }
            )
            queue.add(request)
        }
    }
}