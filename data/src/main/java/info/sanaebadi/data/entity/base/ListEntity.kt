package info.sanaebadi.data.entity.base


abstract class ListEntity<T : Entity> : Entity {

    open var list: List<T> = emptyList()
}