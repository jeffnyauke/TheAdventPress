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

import androidx.annotation.VisibleForTesting
import androidx.annotation.VisibleForTesting.PRIVATE
import androidx.lifecycle.viewModelScope
import dagger.Module
import dagger.Provides
import press.advent.commons.ui.extensions.viewModel
import press.advent.core.di.scopes.FeatureScope
import press.advent.core.network.repositiories.MarvelRepository
import press.advent.dynamicfeatures.articleslist.ui.list.CharactersListFragment
import press.advent.dynamicfeatures.articleslist.ui.list.CharactersListViewModel
import press.advent.dynamicfeatures.articleslist.ui.list.adapter.CharactersListAdapter
import press.advent.dynamicfeatures.articleslist.ui.list.model.CharacterItemMapper
import press.advent.dynamicfeatures.articleslist.ui.list.paging.CharactersPageDataSource
import press.advent.dynamicfeatures.articleslist.ui.list.paging.CharactersPageDataSourceFactory

/**
 * Class that contributes to the object graph [CharactersListComponent].
 *
 * @see Module
 */
@Module
class CharactersListModule(
    @VisibleForTesting(otherwise = PRIVATE)
    val fragment: CharactersListFragment
) {

    /**
     * Create a provider method binding for [CharactersListViewModel].
     *
     * @param dataFactory Data source factory for characters.
     * @return Instance of view model.
     * @see Provides
     */
    @FeatureScope
    @Provides
    fun providesCharactersListViewModel(
        dataFactory: CharactersPageDataSourceFactory
    ) = fragment.viewModel {
        CharactersListViewModel(dataFactory)
    }

    /**
     * Create a provider method binding for [CharactersPageDataSource].
     *
     * @return Instance of data source.
     * @see Provides
     */
    @Provides
    fun providesCharactersPageDataSource(
        viewModel: CharactersListViewModel,
        repository: MarvelRepository,
        mapper: CharacterItemMapper
    ) = CharactersPageDataSource(
        repository = repository,
        scope = viewModel.viewModelScope,
        mapper = mapper
    )

    /**
     * Create a provider method binding for [CharacterItemMapper].
     *
     * @return Instance of mapper.
     * @see Provides
     */
    @FeatureScope
    @Provides
    fun providesCharacterItemMapper() = CharacterItemMapper()

    /**
     * Create a provider method binding for [CharactersListAdapter].
     *
     * @return Instance of adapter.
     * @see Provides
     */
    @FeatureScope
    @Provides
    fun providesCharactersListAdapter(
        viewModel: CharactersListViewModel
    ) = CharactersListAdapter(viewModel)
}
