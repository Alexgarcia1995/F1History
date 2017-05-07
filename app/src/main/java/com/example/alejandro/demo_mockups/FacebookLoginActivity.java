package com.example.alejandro.demo_mockups;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class FacebookLoginActivity extends BaseActivity {
    private static final String TAG = "FacebookLogin";

  //  @BindView(R.id.status)
    TextView mStatusTextView;
  //  @BindView(R.id.detail)
    TextView mDetailTextView;
   // @BindView(R.id.button_facebook_login)
    LoginButton buttonFacebookLogin;
  //  @BindView(R.id.button_facebook_signout)
    Button buttonFacebookSignOut;

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private CallbackManager mCallbackManager;
    private Unbinder unbinder;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_facebook);
        unbinder = ButterKnife.bind(this);
        //buttonFacebookSignOut = (Button) findViewById(R.id.button_facebook_signout);
       // mStatusTextView=(TextView) findViewById(R.id.status);
       // mDetailTextView=(TextView) findViewById(R.id.detail);
        buttonFacebookLogin=(LoginButton) findViewById(R.id.button_facebook_login);
        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
                } else {
                    // User is signed out
                    Log.d(TAG, "onAuthStateChanged:signed_out");
                }
                updateUI(user);
            }
        };
        /*
        buttonFacebookSignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signOut();
            }
        });
        */
        mCallbackManager = CallbackManager.Factory.create();
        buttonFacebookLogin.setReadPermissions("email", "public_profile");
        buttonFacebookLogin.registerCallback(mCallbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Log.d(TAG, "facebook:onSuccess:" + loginResult);
                handleFacebookAccessToken(loginResult.getAccessToken());
            }

            @Override
            public void onCancel() {
                Log.d(TAG, "facebook:onCancel");
                updateUI(null);
            }

            @Override
            public void onError(FacebookException error) {
                Log.d(TAG, "facebook:onError", error);
                updateUI(null);
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mCallbackManager.onActivityResult(requestCode, resultCode, data);
    }

    private void handleFacebookAccessToken(AccessToken token) {
        Log.d(TAG, "handleFacebookAccessToken:" + token);
        showProgressDialog();
        AuthCredential credential = FacebookAuthProvider.getCredential(token.getToken());
        mAuth.signInWithCredential(credential).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                Log.d(TAG, "signInWithCredential:onComplete:" + task.isSuccessful());
                // If sign in fails, display a message to the user. If sign in succeeds
                // the auth state listener will be notified and logic to handle the
                // signed in user can be handled in the listener.
                if (!task.isSuccessful()) {
                    Log.w(TAG, "signInWithCredential", task.getException());
                    Toast.makeText(FacebookLoginActivity.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
                }
                hideProgressDialog();
                Intent volver =new Intent(FacebookLoginActivity.this,MainActivity.class);
                startActivity(volver);
            }
        });
    }

    public void signOut() {
        mAuth.signOut();
        updateUI(null);
    }

    private void updateUI(FirebaseUser user) {
        hideProgressDialog();
        if (user != null) {
           // mStatusTextView.setText(getString(R.string.facebook_status_fmt, user.getDisplayName()));
          //  mDetailTextView.setText(getString(R.string.firebase_status_fmt, user.getUid()));
            buttonFacebookLogin.setVisibility(View.VISIBLE);
          //  buttonFacebookSignOut.setVisibility(View.VISIBLE);
        } else {
          //  mStatusTextView.setText(R.string.signed_out);
            //mDetailTextView.setText(null);
            buttonFacebookLogin.setVisibility(View.VISIBLE);
          //  buttonFacebookSignOut.setVisibility(View.GONE);
        }
    }

   // @OnClick(R.id.button_facebook_signout)
    public void onClickFacebookSignOut() {
        signOut();
    }
}
