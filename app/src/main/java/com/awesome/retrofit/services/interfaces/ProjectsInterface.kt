package com.awesome.retrofit.services.interfaces

import com.awesome.retrofit.services.dataClasses.ProjectsAll
import retrofit2.Call
import retrofit2.http.GET

interface ProjectsInterface {
    //
    @GET("projects/all")
    fun getProjects():Call<ProjectsAll>

}