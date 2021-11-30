package dougles.project.myapplication.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dougles.project.myapplication.api.ApiClient
import dougles.project.myapplication.models.ResponseDTO

class MovieRepository(private val apiClient: ApiClient) {

    private val moviesLiveData = MutableLiveData<ResponseDTO>()
    val movies: LiveData<ResponseDTO>
        get() = moviesLiveData

    suspend fun getMovies(page: String) {
        val result = apiClient.getMovies("328c283cd27bd1877d9080ccb1604c91", page)
        if (result?.body() != null) {
            moviesLiveData.postValue(result.body())

        }
    }
}
