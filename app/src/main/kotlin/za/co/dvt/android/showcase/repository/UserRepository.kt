package za.co.dvt.android.showcase.repository

import com.google.firebase.auth.FirebaseUser
import java.lang.Exception

/**
 * @author rebeccafranks
 * *
 * @since 2017/04/13
 */
interface UserRepository {
    fun login(email: String, password: String, loginCallback: LoginCallback)

    interface LoginCallback {
        fun onLoggedInSuccess(user: FirebaseUser)
        fun onLoginFailed(exception: Exception)
    }
}
