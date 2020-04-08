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

package press.advent.dynamicfeatures.articleslist.ui.detail.di

import androidx.annotation.VisibleForTesting
import androidx.annotation.VisibleForTesting.PRIVATE
import dagger.Module
import dagger.Provides
import press.advent.commons.ui.extensions.viewModel
import press.advent.commons.views.ProgressBarDialog
import press.advent.core.database.characterfavorite.CharacterFavoriteRepository
import press.advent.core.di.scopes.FeatureScope
import press.advent.core.network.repositiories.MarvelRepository
import press.advent.dynamicfeatures.articleslist.ui.detail.CharacterDetailFragment
import press.advent.dynamicfeatures.articleslist.ui.detail.CharacterDetailViewModel
import press.advent.dynamicfeatures.articleslist.ui.detail.model.CharacterDetailMapper

/**
 * Class that contributes to the object graph [CharacterDetailComponent].
 *
 * @see Module
 */
@Module
class CharacterDetailModule(
    @VisibleForTesting(otherwise = PRIVATE)
    val fragment: CharacterDetailFragment
) {

    /**
     * Create a provider method binding for [CharacterDetailViewModel].
     *
     * @param marvelRepository
     * @param characterFavoriteRepository handler character favorite repository
     * @param characterDetailMapper mapper to parse view model
     *
     * @return instance of view model.
     */
    @FeatureScope
    @Provides
    fun providesCharacterDetailViewModel(
        marvelRepository: MarvelRepository,
        characterFavoriteRepository: CharacterFavoriteRepository,
        characterDetailMapper: CharacterDetailMapper
    ) = fragment.viewModel {
        CharacterDetailViewModel(
            marvelRepository = marvelRepository,
            characterFavoriteRepository = characterFavoriteRepository,
            characterDetailMapper = characterDetailMapper
        )
    }

    /**
     * Create a provider method binding for [CharacterDetailMapper].
     *
     * @return instance of mapper.
     * @see Provides
     */
    @FeatureScope
    @Provides
    fun providesCharacterDetailMapper() = CharacterDetailMapper()

    /**
     * Create a provider method binding for [ProgressBarDialog].
     *
     * @return instance of dialog.
     * @see Provides
     */
    @FeatureScope
    @Provides
    fun providesProgressBarDialog() = ProgressBarDialog(fragment.requireContext())
}
