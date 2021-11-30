package dougles.project.myapplication.api

import dougles.project.myapplication.models.ResponseDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiClient {
    @GET("3/discover/movie")
    suspend fun getMovies(
        @Query("api_key") token: String, @Query("page") page: String
    ): Response<ResponseDTO>


}