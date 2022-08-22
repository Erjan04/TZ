package kg.erjan.domain.repository

import kotlinx.coroutines.flow.Flow

interface GalleryRepository {

    fun getImages(): Flow<List<String>>

}