package com.example.appjorge

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appjorge.databinding.FragmentListaBinding

class ListaFragment : Fragment() {

    private var _binding: FragmentListaBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val items = generateMenuOptions()
        val adapter = MenuOptionAdapter(items) { option ->
            val intent = Intent(requireContext(), DetailActivity::class.java).apply {
                putExtra(DetailActivity.EXTRA_TITLE, option.title)
                putExtra(DetailActivity.EXTRA_DESCRIPTION, option.description)
            }
            startActivity(intent)
        }

        binding.recyclerOptions.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerOptions.adapter = adapter
    }

    private fun generateMenuOptions(): List<MenuOption> {
        return List(20) { index ->
            val number = index + 1
            MenuOption(
                title = getString(R.string.list_item_title, number),
                description = getString(R.string.list_item_description, number)
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
