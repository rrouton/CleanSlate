package com.rrouton.android.cleanslate.ui.countdown

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.rrouton.android.cleanslate.R
import com.rrouton.android.cleanslate.viewModel.DaggerViewModelFactory
import com.rrouton.android.cleanslate.databinding.CountdownFragmentBinding
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.countdown_fragment.*
import javax.inject.Inject

class CountdownFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: DaggerViewModelFactory

    lateinit var viewModel: CountdownViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        //Set the view model and data binding
        viewModel = ViewModelProviders.of(this, this.viewModelFactory).get(CountdownViewModel::class.java)
        val binding: CountdownFragmentBinding = DataBindingUtil.inflate(layoutInflater, R.layout.countdown_fragment, container, false)
        binding.viewmodel = viewModel
        binding.setLifecycleOwner(this)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.countResult()
            .observe(viewLifecycleOwner, Observer {
                activity?.runOnUiThread {
                    Toast.makeText(activity, it.toString(),
                        Toast.LENGTH_LONG).show()
                }
            })

        test_countdown_button.setOnClickListener {
            viewModel.startCountDown()
        }
    }
}
