package com.mizmer.github.search.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ListView
import android.widget.Toast
import com.mizmer.github.search.*
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val service = GithubApiService.Factory.create()
        val lv  = findViewById<ListView>(R.id.recipe_list_view)

        button.setOnClickListener {

            service.search("ionic").enqueue(object : Callback<RepoList> {
                override fun onResponse(call: Call<RepoList>, response: Response<RepoList>) {
                    val repos = response.body() as RepoList
                    val adapter = RepositoryAdapter(this@MainActivity, repos?.items)
                    lv.adapter = adapter
                    Toast.makeText(this@MainActivity,"Succes",Toast.LENGTH_SHORT).show()

                }
                override fun onFailure(call: Call<RepoList>, t: Throwable) {
                    Log.d("TAG",t.localizedMessage)
                    Toast.makeText(this@MainActivity,"Failure",Toast.LENGTH_SHORT).show()
                }
            })

        }


    }
}
