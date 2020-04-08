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

package press.advent.dynamicfeatures.articlesfavorites.ui.favorite.di

import androidx.annotation.VisibleForTesting
import androidx.annotation.VisibleForTesting.PRIVATE
import dagger.Module
import dagger.Provides
import press.advent.commons.ui.extensions.viewModel
import press.advent.core.database.characterfavorite.CharacterFavoriteRepository
import press.advent.core.di.scopes.FeatureScope
import press.advent.dynamicfeatures.articlesfavorites.ui.favorite.CharactersFavoriteFragment
import press.advent.dynamicfeatures.articlesfavorites.ui.favorite.CharactersFavoriteViewModel
import press.advent.dynamicfeatures.articlesfavorites.ui.favorite.adapter.CharactersFavoriteAdapter

/**
 * Class that contributes to the object graph [CharactersFavoriteComponent].
 *
 * @see Module
 */
@Module
class CharactersFavoriteModule(
    @VisibleForTesting(otherwise = PRIVATE)
    val fragment: CharactersFavoriteFragment
) {

    /**
     * Create a provider method binding for [CharactersFavoriteViewModel].
     *
     * @param characterFavoriteRepository Handler character favorite repository.
     * @return Instance of view model.
     * @see Provides
     */
    @Provides
    @FeatureScope
    fun providesCharactersFavoriteViewModel(
        characterFavoriteRepository: CharacterFavoriteRepository
    ) = fragment.viewModel {
        CharactersFavoriteViewModel(
            characterFavoriteRepository = characterFavoriteRepository
        )
    }

    /**
     * Create a provider method binding for [CharactersFavoriteAdapter].
     *
     * @return Instance of adapter.
     * @see Provides
     */
    @Provides
    @FeatureScope
    fun providesCharactersFavoriteAdapter() = CharactersFavoriteAdapter()
}
