package com.example.unsplasssh.ui.screens

import androidx.lifecycle.ViewModel
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.unsplasssh.ImagesDataSource
import com.example.unsplasssh.network.models.Photo
import com.example.unsplasssh.paging.PhotosPagingSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class ImagesViewModel @Inject constructor(private val imagesDataSource: ImagesDataSource) :
    ViewModel() {
    val photos: Flow<PagingData<Photo>> = Pager(PagingConfig(pageSize = 2), pagingSourceFactory = {
        PhotosPagingSource(imagesDataSource = imagesDataSource)
    }).flow
}