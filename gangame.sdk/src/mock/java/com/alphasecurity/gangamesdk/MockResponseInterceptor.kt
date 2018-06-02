package com.alphasecurity.gangamesdk

import okhttp3.*

class MockResponseInterceptor(val responses: HashMap<String, String>,
                              val defaultJsonResponse: String) : Interceptor {

    val MEDIA_TYPE_JSON = MediaType.parse("application/json")

    override fun intercept(chain: Interceptor.Chain): Response {
        val requests = chain.request()
        val response = getResponseFor(requests.url().toString())

        return Response.Builder().body(ResponseBody.create(MEDIA_TYPE_JSON, response))
                .request(requests).protocol(Protocol.HTTP_1_1)
                .code(200).message("success").build()
    }

    private fun getResponseFor(url: String): String {
        return if (responses.containsKey(url))
            responses[url]!!
        else
            defaultJsonResponse
    }
}