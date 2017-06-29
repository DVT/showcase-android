package za.co.dvt.android.rxjava2firebase.exception;

import android.support.annotation.NonNull;

import com.google.firebase.database.DatabaseError;

public class RxFirebaseDataException extends Exception {

   protected DatabaseError error;

   public RxFirebaseDataException(@NonNull DatabaseError error) {
      this.error = error;
   }

   public DatabaseError getError() {
      return error;
   }

   @Override
   public String toString() {
      return "RxFirebaseDataException{" +
         "error=" + error +
         '}';
   }
}
