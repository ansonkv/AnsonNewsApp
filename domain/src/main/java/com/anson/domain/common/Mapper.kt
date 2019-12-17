package app.vyap.domain.common

interface Mapper<E, T> {
    fun mapFrom(from: E): T
}