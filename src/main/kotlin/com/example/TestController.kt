package com.example

import io.micronaut.context.annotation.Property
import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Controller("/test")
open class TestController {

    @Property(name="app.string")
    var stringParam:String ?= null

    @Property(name="app.map")
    var mapParam:Map<String, String> ?= null

    @Get("/")
    fun index(): HttpResponse<String> {
        return HttpResponse.ok("""
            string param = ${stringParam}
            map param = ${mapParam}
            """).contentType(MediaType.TEXT_PLAIN_TYPE)
    }
}