package info.sanaebadi.placeapp.mapper.base

import info.sanaebadi.domain.model.base.BaseDomainModel
import info.sanaebadi.placeapp.model.base.PresentationModel

interface PresentationLayerMapper<P : PresentationModel?, D : BaseDomainModel?> {
    fun toDomain(p: P): D
    fun toPresentation(d: D): P
}