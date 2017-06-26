import android.support.design.widget.Snackbar
import android.view.View


fun View.snack(snackbarText: String) {
    Snackbar.make(this, snackbarText, Snackbar.LENGTH_LONG).show()
}
