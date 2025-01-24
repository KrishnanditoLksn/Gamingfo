package app.ditsdev.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import app.ditsdev.favorite.databinding.FragmentFavoriteBinding
import app.ditsdev.favorite.ui.adapter.GameFavoriteAdapter
import app.ditsdev.gamingfo.ui.FavoriteViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class FavoriteFragment : Fragment() {
    private val favoriteViewModel: FavoriteViewModel by viewModel()
    private var _binding: FragmentFavoriteBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val favAdapter = GameFavoriteAdapter()
        favoriteViewModel.getAllFavoriteGames().observe(viewLifecycleOwner) {
            favAdapter.submitList(it)
        }
        binding.rvFavGameCollections.apply {
            adapter = favAdapter
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(requireContext())
        }
    }
}