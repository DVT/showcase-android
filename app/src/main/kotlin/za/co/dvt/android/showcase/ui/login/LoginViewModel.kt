package za.co.dvt.android.showcase.ui.login

import android.app.Activity
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.databinding.ObservableBoolean
import android.databinding.ObservableField
import com.google.firebase.auth.FirebaseUser
import za.co.dvt.android.showcase.injection.ShowcaseComponent
import za.co.dvt.android.showcase.repository.TrackingRepository
import za.co.dvt.android.showcase.repository.UserRepository
import za.co.dvt.android.showcase.utils.SnackbarMessage
import javax.inject.Inject

/**
 * @author rebeccafranks
 * *
 * @since 2017/06/08.
 */

class LoginViewModel : ViewModel(), ShowcaseComponent.Injectable {

    var emailAddress: ObservableField<String> = ObservableField("")
    var password: ObservableField<String> = ObservableField("")
    var loading: ObservableBoolean = ObservableBoolean(false)
    var loggedIn: MutableLiveData<Boolean> = MutableLiveData()
    val snackbarText = SnackbarMessage()

    @Inject
    lateinit var userRepository: UserRepository

    @Inject
    lateinit var trackingRepository: TrackingRepository

    fun login(activity: Activity) {
        loading.set(true)
        userRepository.login(emailAddress.get(), password.get(), activity, object : UserRepository.LoginCallback {

            override fun onLoggedInSuccess(user: FirebaseUser) {
                loggedIn.value = true
                loading.set(false)
                trackingRepository.trackUserLoginSuccess()
            }

            override fun onLoginFailed(exception: java.lang.Exception) {
                loading.set(false)
                snackbarText.value = exception.message
                trackingRepository.trackUserLoginFailed(exception.message)
            }
        })
    }

    override fun inject(component: ShowcaseComponent) {
        component.inject(this)
    }

    fun initializeScreen() {
        trackingRepository.trackViewUserLogin()
    }

}
