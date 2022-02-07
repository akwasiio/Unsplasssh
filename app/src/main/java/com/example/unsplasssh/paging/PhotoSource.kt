package com.example.unsplasssh.paging

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.unsplasssh.models.Photo

class PhotoSource(private val dataSource: com.example.unsplasssh.DataSource) :
    PagingSource<Int, Photo>() {


    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Photo> {
        return try {
            val nextPage = params.key ?: 1
            val photos: List<Photo> = dataSource.getImages(nextPage)
            Log.e("Photos isEmpty", photos.isEmpty().toString())
            Log.e("Photos", photos.toString())

            LoadResult.Page(data = photos, nextKey = nextPage + 1, prevKey = if(nextPage == 1) null else nextPage - 1 )
        } catch (e: Exception) {
            e.printStackTrace()
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Photo>): Int {
        return 1
    }


}