package za.co.dvt.android.showcase.ui.login

import android.app.Activity
import android.arch.lifecycle.LifecycleFragment
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import za.co.dvt.android.showcase.DvtShowcaseApplication
import za.co.dvt.android.showcase.R
import za.co.dvt.android.showcase.databinding.FragmentLoginBinding
import za.co.dvt.android.showcase.injection.ShowcaseFactory

/**
 * @author rebeccafranks
 * *
 * @since 2017/06/08.
 */

class LoginFragment : LifecycleFragment() {

    lateinit var loginViewModel: LoginViewModel
    lateinit var buttonSignIn: Button
    lateinit var viewDataBinding: FragmentLoginBinding

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(R.layout.fragment_login, container, false)
        loginViewModel = ViewModelProviders
                .of(this, ShowcaseFactory(activity.application as DvtShowcaseApplication))
                .get(LoginViewModel::class.java)

        view?.let {
            viewDataBinding = FragmentLoginBinding.bind(view)
            viewDataBinding.viewModel = loginViewModel
        }
        buttonSignIn = view?.findViewById(R.id.button_login) as Button
        buttonSignIn.setOnClickListener { loginViewModel.login(activity) }


        loginViewModel.loggedIn.observe(this, Observer<Boolean> {
            if (it != null && it) {
                activity.setResult(Activity.RESULT_OK)
                activity.finish()

            }
        })

        return viewDataBinding.root
    }
}
