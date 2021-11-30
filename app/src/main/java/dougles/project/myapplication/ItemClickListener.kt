package dougles.project.myapplication

import dougles.project.myapplication.models.ResultsDTO

interface ItemClickListener {
    fun itemClickListener(responseDTOItem: ResultsDTO, position: Int)
}