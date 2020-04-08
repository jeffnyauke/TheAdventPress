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

package press.advent.dynamicfeatures.articleslist.ui.list.di

import androidx.lifecycle.ViewModel
import io.mockk.*
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.CoroutineScope
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import press.advent.core.network.repositiories.MarvelRepository
import press.advent.dynamicfeatures.articleslist.ui.list.CharactersListFragment
import press.advent.dynamicfeatures.articleslist.ui.list.CharactersListViewModel
import press.advent.dynamicfeatures.articleslist.ui.list.model.CharacterItemMapper
import press.advent.dynamicfeatures.articleslist.ui.list.paging.CharactersPageDataSourceFactory

class CharactersListModuleTest {

    @MockK
    lateinit var fragment: CharactersListFragment
    lateinit var module: CharactersListModule

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
    }

    @Test
    fun initializeCharactersListModule_ShouldSetUpCorrectly() {
        module = CharactersListModule(fragment)

        assertEquals(fragment, module.fragment)
    }

    @Test
    fun verifyProvidedCharactersListViewModel() {
        mockkStatic("press.advent.commons.ui.extensions.FragmentExtensionsKt")

        every {
            fragment.viewModel(any(), any<() -> ViewModel>())
        } returns mockk<CharactersListViewModel>()

        val factoryCaptor = slot<() -> CharactersListViewModel>()
        val dataFactory = mockk<CharactersPageDataSourceFactory>(relaxed = true)
        module = CharactersListModule(fragment)
        module.providesCharactersListViewModel(dataFactory)

        verify {
            fragment.viewModel(factory = capture(factoryCaptor))
        }

        assertEquals(dataFactory, factoryCaptor.captured().dataSourceFactory)
    }

    @Test
    fun verifyProvidedCharactersPageDataSource() {
        val repository = mockk<MarvelRepository>(relaxed = true)
        val mapper = mockk<CharacterItemMapper>(relaxed = true)
        val viewModel = mockk<CharactersListViewModel>(relaxed = true)
        val scope = mockk<CoroutineScope>()
        every { viewModel.viewModelScope } returns scope

        module = CharactersListModule(fragment)
        val dataSource = module.providesCharactersPageDataSource(
            viewModel = viewModel,
            repository = repository,
            mapper = mapper
        )

        assertEquals(repository, dataSource.repository)
        assertEquals(mapper, dataSource.mapper)
        assertEquals(scope, dataSource.scope)
    }
}
