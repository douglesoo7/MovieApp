package dougles.project.myapplication.models

import com.google.gson.annotations.SerializedName

data class ResponseDTO(

	@field:SerializedName("page")
	val page: Int? = null,

	@field:SerializedName("results")
	val results: List<ResultsDTO?>? = null,

	@field:SerializedName("total_pages")
	val totalPages: Int? = null,

	@field:SerializedName("total_results")
	val totalResults: Int? = null
)