@file:JvmName("SmartCast")
@file:Suppress("NOTHING_TO_INLINE", "UNCHECKED_CAST", "NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")

package com.github.xjcyan1de.cellulose.util

import java.util.*

fun <T> cast(any: Any): T = any as T

inline fun <T, R> T?.asOptional(): Optional<R> = Optional.ofNullable(this as? R)

inline fun <T> Optional<T>.asNullable(): T? = orElse(null)

inline fun <T, R> Collection<T>?.asImmutable(): Collection<R> =
    Collections.unmodifiableCollection(this) as Collection<R>