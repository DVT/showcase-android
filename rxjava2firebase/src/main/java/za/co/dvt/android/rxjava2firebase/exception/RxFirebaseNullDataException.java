package za.co.dvt.android.rxjava2firebase.exception;


import android.support.annotation.NonNull;

public class RxFirebaseNullDataException extends NullPointerException {

   public RxFirebaseNullDataException() {
   }

   public RxFirebaseNullDataException(@NonNull String detailMessage) {
      super(detailMessage);
   }

}
