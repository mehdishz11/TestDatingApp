package com.practice.testDatingApp.people.useCase

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.practice.testDatingApp.people.repo.PeopleRepo
import com.practice.testDatingApp.people.useCase.models.PeopleModel
import com.practice.testDatingApp.people.useCase.models.toModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPeopleListUseCase @Inject constructor(private val peopleRepo: PeopleRepo) :
    PagingSource<Int, PeopleModel>() {

        fun getPeoplesProfiles(): Flow<PagingData<PeopleModel>> {
            return Pager(
                config = PagingConfig(pageSize = 20),
                pagingSourceFactory = {
                    this@GetPeopleListUseCase
                }
            ).flow
        }

    override fun getRefreshKey(state: PagingState<Int, PeopleModel>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, PeopleModel> {
        val pageIndex = params.key ?: 0
        return try {
            val response = peopleRepo.getPeopleList(pageIndex).map { it.toModel() }
            val nextKey =
                if (response.isEmpty()) {
                    null
                } else {
                    pageIndex + 1
                }
            LoadResult.Page(
                data = response,
                prevKey = if (pageIndex == 0) null else pageIndex,
                nextKey = nextKey
            )
        } catch (exception: Exception) {
            return LoadResult.Error(exception)
        }
    }

}