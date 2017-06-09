package za.co.dvt.android.showcase.ui.login

import android.app.Activity
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseUser
import za.co.dvt.android.showcase.injection.ShowcaseComponent
import za.co.dvt.android.showcase.repository.UserRepository
import javax.inject.Inject

/**
 * @author rebeccafranks
 * *
 * @since 2017/06/08.
 */

class LoginViewModel : ViewModel(), ShowcaseComponent.Injectable {

    var emailAddress: String = ""
    var password: String = ""
    var loading: MutableLiveData<Boolean> = MutableLiveData()
    var loggedIn: MutableLiveData<Boolean> = MutableLiveData()

    @Inject
    lateinit var userRepository: UserRepository

    fun login(activity: Activity) {
        userRepository.login(emailAddress, password, activity, object : UserRepository.LoginCallback {

            override fun onLoggedInSuccess(user: FirebaseUser) {
                loading.value = false
                loggedIn.value = true
            }

            override fun onLoginFailed(exception: java.lang.Exception) {
                loading.value = false
            }
        })
    }

    override fun inject(component: ShowcaseComponent) {
        component.inject(this)
    }

}
