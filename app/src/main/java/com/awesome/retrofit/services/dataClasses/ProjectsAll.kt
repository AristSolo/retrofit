package com.awesome.retrofit.services.dataClasses


import com.google.gson.annotations.SerializedName

class ProjectsAll : ArrayList<ProjectsAll.ProjectsItem>(){
    data class ProjectsItem(
        @SerializedName("description")
        val description: String,
        @SerializedName("id")
        val id: Int,
        @SerializedName("name")
        val name: String,
        @SerializedName("purpose")
        val purpose: String
    )
}