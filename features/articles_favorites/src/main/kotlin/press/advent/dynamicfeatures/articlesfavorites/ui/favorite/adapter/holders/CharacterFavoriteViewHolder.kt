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

package press.advent.dynamicfeatures.articlesfavorites.ui.favorite.adapter.holders

import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import press.advent.commons.ui.base.BaseViewHolder
import press.advent.core.database.characterfavorite.CharacterFavorite
import press.advent.dynamicfeatures.articlesfavorites.databinding.ListItemCharactersFavoriteBinding

/**
 * Class describes character favorite view and metadata about its place within the [RecyclerView].
 *
 * @see BaseViewHolder
 */
class CharacterFavoriteViewHolder(
    inflater: LayoutInflater
) : BaseViewHolder<ListItemCharactersFavoriteBinding>(
    binding = ListItemCharactersFavoriteBinding.inflate(inflater)
) {
    /**
     * Bind view data binding variables.
     *
     * @param characterFavorite Character favorite to bind.
     */
    fun bind(characterFavorite: CharacterFavorite) {
        binding.character = characterFavorite
        binding.executePendingBindings()
    }
}
