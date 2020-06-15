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

package press.advent.dynamicfeatures.home.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import androidx.lifecycle.Observer
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import press.advent.android.App
import press.advent.commons.ui.base.BaseFragment
import press.advent.commons.ui.extensions.setupWithNavController
import press.advent.core.utils.ThemeUtils
import press.advent.dynamicfeatures.home.ui.di.DaggerHomeComponent
import press.advent.dynamicfeatures.home.ui.di.HomeModule
import press.advent.dynamicfeatures.home.ui.menu.ToggleThemeCheckBox
import press.android.dynamicfeatures.home.R
import press.android.dynamicfeatures.home.databinding.FragmentHomeBinding
import javax.inject.Inject

private const val DELAY_TO_APPLY_THEME = 1000L

/**
 * Home principal view containing bottom navigation bar with different characters tabs.
 *
 * @see BaseFragment
 */
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>(
    layoutId = R.layout.fragment_home
) {

    @Inject
    lateinit var themeUtils: ThemeUtils

    private val navGraphIds = listOf(
        R.navigation.navigation_characters_list_graph,
        R.navigation.navigation_characters_favorites_graph
    )

    /**
     * Called to have the fragment instantiate its user interface view.
     *
     * @param view The view returned by onCreateView(LayoutInflater, ViewGroup, Bundle)}.
     * @param savedInstanceState If non-null, this fragment is being re-constructed
     * from a previous saved state as given here.
     * @see BaseFragment.onViewCreated
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupToolbar()
        if (savedInstanceState == null) {
            setupBottomNavigationBar()
        }
    }

    /**
     * Initialize the contents of the Fragment host's standard options menu.
     *
     * @param menu The options menu in which you place your items.
     * @param inflater Inflater to instantiate menu XML files into Menu objects.
     * @see BaseFragment.onCreateOptionsMenu
     */
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.toolbar_menu, menu)

        menu.findItem(R.id.menu_toggle_theme).apply {
            val actionView = this.actionView
            if (actionView is ToggleThemeCheckBox) {
                actionView.isChecked = themeUtils.isDarkTheme(requireContext())
                actionView.setOnCheckedChangeListener { _, isChecked ->
                    themeUtils.setNightMode(isChecked, DELAY_TO_APPLY_THEME)
                }
            }
        }
    }

    /**
     * Initialize dagger injection dependency graph.
     */
    override fun onInitDependencyInjection() {
        DaggerHomeComponent
            .builder()
            .coreComponent(App.coreComponent(requireContext()))
            .homeModule(HomeModule(this))
            .build()
            .inject(this)
    }

    /**
     * Initialize view data binding variables.
     */
    override fun onInitDataBinding() {
        viewBinding.viewModel = viewModel
    }

    // ============================================================================================
    //  Private setups methods
    // ============================================================================================

    /**
     * Configure app custom support action bar.
     */
    private fun setupToolbar() {
        setHasOptionsMenu(true)
        requireCompatActivity().setSupportActionBar(viewBinding.toolbar)
    }

    /**
     * Configure app bottom bar via navigation graph.
     */
    private fun setupBottomNavigationBar() {
        val navController = viewBinding.bottomNavigation.setupWithNavController(
            navGraphIds = navGraphIds,
            fragmentManager = childFragmentManager,
            containerId = R.id.nav_host_container,
            intent = requireActivity().intent
        )

        navController.observe(viewLifecycleOwner, Observer {
            viewModel.navigationControllerChanged(it)
            setupActionBarWithNavController(requireCompatActivity(), it)
        })
    }
}
