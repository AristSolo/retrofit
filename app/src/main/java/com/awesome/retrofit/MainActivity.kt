package com.awesome.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import com.awesome.retrofit.services.builder.RetrofitBuilder
import com.awesome.retrofit.services.dataClasses.ProjectsAll
import com.awesome.retrofit.services.interfaces.ProjectsInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private const val TAG = "MainActivity"
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadProjects()
    }
    override fun onRestart() {
        super.onRestart()
        loadProjects()
    }
    private fun loadProjects(){
        val projectsInstance = RetrofitBuilder.buildService(ProjectsInterface::class.java)
        val requestCall:Call<ProjectsAll> = projectsInstance.getProjects()
        requestCall.enqueue(object : Callback<ProjectsAll> {
            //
            override fun onResponse(call: Call<ProjectsAll>, response: Response<ProjectsAll>) {
                if(response.isSuccessful){
                    val projects = response.body()!!
                    val textView = findViewById<TextView>(R.id.multi)
                    textView.text = projects.toString()
                }else{
                    Toast.makeText(this@MainActivity, "Failed to retrieve projects", Toast.LENGTH_SHORT).show()
                }
            }
            //
            override fun onFailure(call: Call<ProjectsAll>, t: Throwable) {
                Log.d(TAG, t.message.toString())
                Toast.makeText(this@MainActivity, "An Error Occurred${t.message}", Toast .LENGTH_SHORT).show()
            }
        })
    }
}