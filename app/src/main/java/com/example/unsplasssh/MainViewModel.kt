package com.example.unsplasssh

import androidx.lifecycle.ViewModel
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.unsplasssh.models.Photo
import com.example.unsplasssh.paging.PhotoSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val dataSource: DataSource) : ViewModel() {
    val photos: Flow<PagingData<Photo>> = Pager(PagingConfig(pageSize = 2)) {
        PhotoSource(dataSource = dataSource)
    }.flow
}