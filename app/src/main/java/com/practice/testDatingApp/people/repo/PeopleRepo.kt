package com.practice.testDatingApp.people.repo

import com.practice.testDatingApp.people.repo.models.PeopleApiModel

interface PeopleRepo {
    suspend fun getPeopleList(pageIndex:Int):List<PeopleApiModel>
}