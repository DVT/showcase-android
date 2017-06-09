package za.co.dvt.android.showcase.ui.login

import android.app.Activity
import android.arch.lifecycle.LifecycleFragment
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import za.co.dvt.android.showcase.DvtShowcaseApplication
import za.co.dvt.android.showcase.R
import za.co.dvt.android.showcase.injection.ShowcaseFactory

/**
 * @author rebeccafranks
 * *
 * @since 2017/06/08.
 */

class LoginFragment : LifecycleFragment() {

    lateinit var loginViewModel: LoginViewModel
    lateinit var editTextEmail: EditText
    lateinit var editTextPassword: EditText
    lateinit var buttonSignIn: Button

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(R.layout.fragment_login, container, false)
        loginViewModel = ViewModelProviders
                .of(this, ShowcaseFactory(activity.application as DvtShowcaseApplication))
                .get(LoginViewModel::class.java)
        buttonSignIn = view?.findViewById(R.id.button_login) as Button
        editTextEmail = view.findViewById(R.id.edit_text_email) as EditText
        editTextPassword = view.findViewById(R.id.edit_text_password) as EditText
        buttonSignIn.setOnClickListener { loginViewModel.login(activity) }

        editTextEmail.addTextChangedListener(object : TextWatcher {

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                loginViewModel.emailAddress = s.toString()
            }
        })
        editTextPassword.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                loginViewModel.password = s.toString()
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

        })
        loginViewModel.loggedIn.observe(this, Observer<Boolean> {
            if (it != null && it) {
                activity.setResult(Activity.RESULT_OK)
                activity.finish()

            }
        })
        loginViewModel.loading.observe(this, Observer<Boolean> {
            if (it != null) {

            }
        })

        return view
    }
}
