package com.practice.testDatingApp.people.repo.models


import com.fasterxml.jackson.annotation.JsonProperty
import androidx.annotation.Keep

@Keep
data class PeopleApiModel(
    @JsonProperty("height")
    val height: Int?,
    @JsonProperty("id")
    val id: String?,
    @JsonProperty("url")
    val url: String?,
    @JsonProperty("width")
    val width: Int?
)