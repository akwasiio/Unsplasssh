package com.example.unsplasssh.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.unsplasssh.ImagesDataSource
import com.example.unsplasssh.network.models.Photo

class PhotosPagingSource(private val imagesDataSource: ImagesDataSource) : PagingSource<Int, Photo>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Photo> {
        return try {
            val nextPage = params.key ?: 1
            val photos: List<Photo> = imagesDataSource.getImages(nextPage)

            LoadResult.Page(
                data = photos,
                nextKey = nextPage + 1,
                prevKey = if (nextPage == 1) null else nextPage - 1
            )
        } catch (e: Exception) {
            e.printStackTrace()
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Photo>): Int {
        return 1
    }
}