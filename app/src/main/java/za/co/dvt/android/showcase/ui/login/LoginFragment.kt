package za.co.dvt.android.showcase.ui.login

import android.app.Activity
import android.arch.lifecycle.LifecycleFragment
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import snack
import za.co.dvt.android.showcase.R
import za.co.dvt.android.showcase.ShowcaseApplication
import za.co.dvt.android.showcase.databinding.FragmentLoginBinding
import za.co.dvt.android.showcase.injection.ShowcaseFactory
import za.co.dvt.android.showcase.utils.SnackbarMessage


/**
 * @author rebeccafranks
 * *
 * @since 2017/06/08.
 */
class LoginFragment : LifecycleFragment() {

    lateinit var loginViewModel: LoginViewModel
    lateinit var buttonSignIn: Button
    lateinit var viewDataBinding: FragmentLoginBinding
    lateinit var editTextPassword: EditText

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)

        setupViewBinding(view)

        loginViewModel.loggedIn.observe(this, Observer<Boolean> {
            if (it != null && it) {
                activity.setResult(Activity.RESULT_OK)
                activity.finish()

            }
        })
        setupSnackbar()
        return viewDataBinding.root
    }

    private fun setupViewBinding(view: View) {
        loginViewModel = ViewModelProviders
                .of(this, ShowcaseFactory(activity.application as ShowcaseApplication))
                .get(LoginViewModel::class.java)
        loginViewModel.initializeScreen()

        viewDataBinding = FragmentLoginBinding.bind(view)
        viewDataBinding.viewModel = loginViewModel
        buttonSignIn = view.findViewById(R.id.button_login) as Button
        buttonSignIn.setOnClickListener {
            loginViewModel.login(activity)
            closeKeyboard()
        }
        editTextPassword = view.findViewById(R.id.edit_text_password) as EditText
        editTextPassword.setOnEditorActionListener(TextView.OnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_GO || actionId == EditorInfo.IME_ACTION_DONE) {
                loginViewModel.login(activity)
                return@OnEditorActionListener false
            }
            false
        })

    }

    fun closeKeyboard() {
        val imm = activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(editTextPassword.windowToken, InputMethodManager.RESULT_UNCHANGED_SHOWN)
    }

    fun setupSnackbar() {
        loginViewModel.snackbarText.observe(this, object : SnackbarMessage.SnackbarObserver {

            override fun onNewMessage(snackbarMessage: String?) {
                view?.snack(snackbarMessage ?: getString(R.string.login_generic_error))
            }
        })
    }


}

