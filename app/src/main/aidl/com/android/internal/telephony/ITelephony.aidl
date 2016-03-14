// ITelephony.aidl
package com.android.internal.telephony;

// Declare any non-default types here with import statements

interface ITelephony {

   /**
        * Dial a number. This doesn't place the call. It displays
        * the Dialer screen.
        *
        * @param number the number to be dialed. If null, this
        *               would display the Dialer screen with no number pre-filled.
        */
       void dial(String number);

       /**
        * Place a call to the specified number.
        *
        * @param number the number to be called.
        */
       void call(String number);

       /**
        * Allow mobile data connections.
        */
       boolean enableDataConnectivity();

       /**
        * Disallow mobile data connections.
        */
       boolean disableDataConnectivity();

}
