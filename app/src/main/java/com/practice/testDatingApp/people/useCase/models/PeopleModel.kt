package com.practice.testDatingApp.people.useCase.models


import com.practice.testDatingApp.people.repo.models.PeopleApiModel

data class PeopleModel(
    val id: String,
    val url: String
)

fun PeopleApiModel.toModel() =
    PeopleModel(
        id = id ?: "",
        url = url ?: ""
    )