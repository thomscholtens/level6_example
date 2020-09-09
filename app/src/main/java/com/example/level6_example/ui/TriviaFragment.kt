package com.example.level6_example.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.level6_example.R
import com.example.level6_example.viewmodel.TriviaViewModel
import kotlinx.android.synthetic.main.fragment_trivia.*

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class TriviaFragment : Fragment() {
    private val viewModel: TriviaViewModel by activityViewModels()

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_trivia, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeTrivia()
    }

    private fun observeTrivia() {
        viewModel.trivia.observe(viewLifecycleOwner, Observer {
            tvTrivia.text = it?.text
        })

        // Observe the error message.
        viewModel.errorText.observe(viewLifecycleOwner, Observer {
            Toast.makeText(activity, it, Toast.LENGTH_SHORT).show()
        })
    }

}