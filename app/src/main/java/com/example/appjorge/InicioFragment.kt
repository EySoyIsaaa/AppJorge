package com.example.appjorge

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.appjorge.databinding.FragmentInicioBinding
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class InicioFragment : Fragment() {

    private var _binding: FragmentInicioBinding? = null
    private val binding get() = _binding!!

    private var taskOneJob: Job? = null
    private var taskTwoJob: Job? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentInicioBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnOpenActivity.setOnClickListener {
            val intent = Intent(requireContext(), DetailActivity::class.java).apply {
                putExtra(DetailActivity.EXTRA_TITLE, getString(R.string.detail_from_inicio_title))
                putExtra(DetailActivity.EXTRA_DESCRIPTION, getString(R.string.detail_from_inicio_desc))
            }
            startActivity(intent)
        }

        binding.btnStartTasks.setOnClickListener {
            startParallelTasks()
        }
    }

    private fun startParallelTasks() {
        taskOneJob?.cancel()
        taskTwoJob?.cancel()

        binding.tvTaskOneStatus.text = getString(R.string.task_running)
        binding.tvTaskTwoStatus.text = getString(R.string.task_running)
        binding.progressTaskOne.progress = 0
        binding.progressTaskTwo.progress = 0

        taskOneJob = viewLifecycleOwner.lifecycleScope.launch {
            for (progress in 1..100) {
                binding.progressTaskOne.progress = progress
                delay(45)
            }
            binding.tvTaskOneStatus.text = getString(R.string.task_finished)
        }

        taskTwoJob = viewLifecycleOwner.lifecycleScope.launch {
            for (progress in 1..100) {
                binding.progressTaskTwo.progress = progress
                delay(70)
            }
            binding.tvTaskTwoStatus.text = getString(R.string.task_finished)
        }
    }

    override fun onDestroyView() {
        taskOneJob?.cancel()
        taskTwoJob?.cancel()
        super.onDestroyView()
        _binding = null
    }
}
