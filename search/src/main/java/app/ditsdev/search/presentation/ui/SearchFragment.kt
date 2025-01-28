package app.ditsdev.search.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import app.ditsdev.search.databinding.FragmentSearchBinding
import app.ditsdev.search.di.SearchModule
import app.ditsdev.search.presentation.viewmodels.SearchViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules

class SearchFragment : Fragment() {
    private val loadFeature by lazy { loadKoinModules(SearchModule.searchFeatureModule) }
    private lateinit var binding: FragmentSearchBinding
    private val searchViewModel: SearchViewModel by viewModel()

    private fun injectSearchFeatures() = loadFeature
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val gameAdapter = GameResultAdapter()
        with(binding) {
            svGames.setupWithSearchBar(sbGames)
            svGames
                .editText.setOnEditorActionListener { _, _, _ ->
                    sbGames.setText(svGames.text)
                    svGames.hide()
                    searchViewModel.searchGame(svGames.text.toString())
                        .observe(viewLifecycleOwner) {
                            gameAdapter.submitList(it)
                        }
                    false
                }
        }
        binding.rvSearchResultGame.apply {
            adapter = gameAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectSearchFeatures()
    }
}