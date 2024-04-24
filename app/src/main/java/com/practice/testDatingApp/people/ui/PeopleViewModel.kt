package com.practice.testDatingApp.people.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.practice.testDatingApp.people.useCase.GetPeopleListUseCase
import com.practice.testDatingApp.people.useCase.models.PeopleModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class PeopleViewModel @Inject constructor(
    private val  peopleListUseCase: GetPeopleListUseCase
):ViewModel() {


    fun getPeopleList(): Flow<PagingData<PeopleModel>> {
        return peopleListUseCase.getPeoplesProfiles()
            .cachedIn(viewModelScope)
    }

}