package za.co.dvt.android.showcase.repository.impl

import com.google.firebase.auth.FirebaseAuth
import timber.log.Timber
import za.co.dvt.android.showcase.repository.UserRepository


/**
 * @author rebeccafranks
 * *
 * @since 2017/06/08.
 */

class FirebaseUserRepository(val firebaseAuth: FirebaseAuth) : UserRepository {

    override fun login(email: String, password: String, loginCallback: UserRepository.LoginCallback) {
        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener({ task ->
                    if (task.isSuccessful) {
                        Timber.d("signInWithEmail:success")
                        val user = firebaseAuth.currentUser
                        if (user != null) {
                            loginCallback.onLoggedInSuccess(user)
                        }
                    } else {
                        task.exception?.let {
                            Timber.d("signInWithEmail:failure", it)
                            loginCallback.onLoginFailed(it)
                        }
                    }
                })
    }

}
