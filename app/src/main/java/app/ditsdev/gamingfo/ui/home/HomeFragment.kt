package app.ditsdev.gamingfo.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import app.ditsdev.core.result.resource.ResourceResult
import app.ditsdev.gamingfo.databinding.FragmentHomeBinding
import app.ditsdev.gamingfo.ui.GameListAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {
    private val homeViewModel: HomeViewModel by viewModel()
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.gameProgressBar.visibility = View.INVISIBLE
        val gameAdapter = GameListAdapter()
        homeViewModel.getAllGames().observe(viewLifecycleOwner) { result ->
            when (result) {
                is ResourceResult.Success -> {
                    binding.gameProgressBar.visibility = View.INVISIBLE
                    gameAdapter.submitList(result.data)
                }

                is ResourceResult.Loading -> {
                    binding.gameProgressBar.visibility = View.VISIBLE
                }

                is ResourceResult.Error -> {
                    binding.gameProgressBar.visibility = View.INVISIBLE
                }
            }
            binding.rvHeadlines.apply {
                adapter = gameAdapter
                setHasFixedSize(true)
                layoutManager = GridLayoutManager(requireContext(), 1)
                    .apply {
                        orientation = GridLayoutManager.HORIZONTAL
                    }
            }
        }
    }
}