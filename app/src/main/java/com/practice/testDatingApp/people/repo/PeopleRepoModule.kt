package com.practice.testDatingApp.people.repo

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
interface PeopleRepoModule {
    @Binds
    fun bindsPeopleRepo(peopleRepoImpl: PeopleRepoImpl):PeopleRepo
}