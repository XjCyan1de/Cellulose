package com.github.xjcyan1de.cellulose.common

import com.google.inject.PrivateModule
import com.google.inject.binder.AnnotatedBindingBuilder

abstract class AbstractCelluloseModule : PrivateModule() {
    override fun configure() {}
    protected fun <T> bindAndExpose(type: Class<T>?): AnnotatedBindingBuilder<T> {
        this.expose(type)
        return this.bind(type)
    }
}