package com.rrouton.android.cleanslate.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.rrouton.android.cleanslate.R
import com.rrouton.android.cleanslate.viewModel.ClientViewModelFactory
import com.rrouton.android.cleanslate.databinding.LoginFragmentBinding
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.login_fragment.*
import javax.inject.Inject

class LoginFragment : DaggerFragment() {

    @Inject
    lateinit var viewModeFactory: ClientViewModelFactory

    lateinit var viewModel: LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        //Set the view model and data binding
        viewModel = ViewModelProviders.of(this, this.viewModeFactory).get(LoginViewModel::class.java)
        val binding: LoginFragmentBinding = DataBindingUtil.inflate(layoutInflater, R.layout.login_fragment, container, false)
        binding.viewmodel = viewModel
        binding.setLifecycleOwner(this)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.countResult()
            .observe(this, Observer {
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
