package za.co.dvt.android.rxjava2firebase.exception;

import android.support.annotation.NonNull;

public class RxFirebaseDataCastException extends Exception {

   public RxFirebaseDataCastException() {
   }

   public RxFirebaseDataCastException(@NonNull String detailMessage) {
      super(detailMessage);
   }

   public RxFirebaseDataCastException(@NonNull String detailMessage, @NonNull Throwable throwable) {
      super(detailMessage, throwable);
   }

   public RxFirebaseDataCastException(@NonNull Throwable throwable) {
      super(throwable);
   }
}