package com.johnnyconsole.android.jeopardygamecontroller_android.ui.export_board

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.johnnyconsole.android.jeopardygamecontroller_android.databinding.FragmentImportBinding

class ExportBoardFragment : Fragment() {

    private var _binding: FragmentImportBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val exportBoardViewModel =
            ViewModelProvider(this).get(ExportBoardViewModel::class.java)

        _binding = FragmentImportBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textSlideshow
        exportBoardViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}