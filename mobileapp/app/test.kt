import com.google.android.gms.auth.api.identity.SignInClient
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import org.junit.Test
import org.mockito.Mockito.*
import org.mockito.kotlin.mock

class GoogleSignInTest {

    private val signInClient: SignInClient = mock()

    @Test
    fun testGoogleSignInSuccess() {
        val request = mock<BeginSignInRequest>()
        // test success 
        `when`(signInClient.beginSignIn(request))
            .thenReturn(mock())

        val result = signInClient.beginSignIn(request)
        assert(result != null)
    }

    @Test
    fun testGoogleSignInFailure() {
        val request = mock<BeginSignInRequest>()
           // test fail
        `when`(signInClient.beginSignIn(request))
            .thenThrow(RuntimeException("Google Sign-In failed"))

        try {
            signInClient.beginSignIn(request)
        } catch (e: Exception) {
            assert(e.message == "Google Sign-In failed")
        }
    }
}
