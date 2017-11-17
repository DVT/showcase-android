package za.co.dvt.android.showcase.ui.login

import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations
import za.co.dvt.android.showcase.repository.TrackingRepository
import za.co.dvt.android.showcase.repository.UserRepository

/**
 * @author rebeccafranks
 * *
 * @since 2017/08/07.
 */
class LoginViewModelTest {

    private lateinit var loginViewModel: LoginViewModel

    @Mock
    private lateinit var userRepository: UserRepository
    @Mock
    private lateinit var trackingRepository: TrackingRepository

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)

        loginViewModel = LoginViewModel()
        loginViewModel.userRepository = userRepository
        loginViewModel.trackingRepository = trackingRepository
    }

    @Test
    fun initializeScreenCallsTrackingRepository() {
        loginViewModel.initializeScreen()

        verify(trackingRepository).trackViewUserLogin()
    }

    @After
    fun tearDown() {

    }

}