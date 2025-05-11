package com.johnnyconsole.android.jeopardygamecontroller_android.ui.setup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.johnnyconsole.android.jeopardygamecontroller_android.R
import com.johnnyconsole.android.jeopardygamecontroller_android.databinding.FragmentSetupBinding

class SetupFragment : Fragment() {

    private var _binding: FragmentSetupBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSetupBinding.inflate(inflater, container, false)

        with(binding) {
            etRoundCategory1.hint = getString(R.string.category, 1)
            etRoundCategory2.hint = getString(R.string.category, 2)
            etRoundCategory3.hint = getString(R.string.category, 3)
            etRoundCategory4.hint = getString(R.string.category, 4)
            etRoundCategory5.hint = getString(R.string.category, 5)
            etRoundCategory6.hint = getString(R.string.category, 6)
            etFinalJeopardyCategory.hint = "Final Jeopardy Category"

            rbSingleJeopardy.setOnClickListener {
                llCategories.visibility = VISIBLE
                llFinalJeopardy.visibility = INVISIBLE
            }

            rbDoubleJeopardy.setOnClickListener {
                llCategories.visibility = VISIBLE
                llFinalJeopardy.visibility = INVISIBLE
            }

            rbFinalJeopardy.setOnClickListener {
                llCategories.visibility = INVISIBLE
                llFinalJeopardy.visibility = VISIBLE
            }

            return root
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}