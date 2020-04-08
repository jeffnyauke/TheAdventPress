/*
 *
 *  Copyright (c) 2020 jeffnyauke@gmail.com
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */

package press.advent.core.di

import com.nhaarman.mockitokotlin2.*
import okhttp3.logging.HttpLoggingInterceptor
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import press.advent.core.di.modules.NetworkModule
import press.advent.core.network.services.MarvelService
import retrofit2.Retrofit

class NetworkModuleTest {

    private lateinit var networkModule: NetworkModule

    @Before
    fun setUp() {
        networkModule = NetworkModule()
    }

    @Test
    fun verifyProvidedHttpLoggingInterceptor() {
        val interceptor = networkModule.provideHttpLoggingInterceptor()
        assertEquals(HttpLoggingInterceptor.Level.BODY, interceptor.level)
    }

    @Test
    fun verifyProvidedHttpClient() {
        val interceptor = mock<HttpLoggingInterceptor>()
        val httpClient = networkModule.provideHttpClient(interceptor)

        assertEquals(1, httpClient.interceptors.size)
        assertEquals(interceptor, httpClient.interceptors.first())
    }

    @Test
    fun verifyProvidedRetrofitBuilder() {
        val retrofit = networkModule.provideRetrofitBuilder()

        assertEquals(BuildConfig.MARVEL_API_BASE_URL, retrofit.baseUrl().toUrl().toString())
    }

    @Test
    fun verifyProvidedMarvelService() {
        val retrofit = mock<Retrofit>()
        val marvelService = mock<MarvelService>()
        val serviceClassCaptor = argumentCaptor<Class<*>>()

        doReturn(marvelService).whenever(retrofit).create<MarvelService>(any())

        networkModule.provideMarvelService(retrofit)

        verify(retrofit).create(serviceClassCaptor.capture())
        assertEquals(MarvelService::class.java, serviceClassCaptor.lastValue)
    }

    @Test
    fun verifyProvidedMarvelRepository() {
        val marvelService = mock<MarvelService>()
        val marvelRepository = networkModule.provideMarvelRepository(marvelService)

        assertEquals(marvelService, marvelRepository.service)
    }
}
