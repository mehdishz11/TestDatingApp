package com.practice.testDatingApp.people.repo.services

import com.practice.testDatingApp.people.repo.models.PeopleApiModel
import retrofit2.http.GET
import retrofit2.http.Query

interface GetPeopleListService {
    @GET("v1/images/search?limit=10")
    suspend fun getPeopleList(@Query("page") pageIndex:Int):List<PeopleApiModel>
}