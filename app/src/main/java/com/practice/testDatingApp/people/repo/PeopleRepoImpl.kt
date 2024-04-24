package com.practice.testDatingApp.people.repo

import com.practice.testDatingApp.people.repo.models.PeopleApiModel
import com.practice.testDatingApp.people.repo.services.GetPeopleListService
import retrofit2.Retrofit
import javax.inject.Inject

class PeopleRepoImpl @Inject constructor(private val retrofit:Retrofit):PeopleRepo {

    override suspend fun getPeopleList(pageIndex:Int): List<PeopleApiModel> {
        return retrofit.create(GetPeopleListService::class.java).getPeopleList(pageIndex)
    }
}