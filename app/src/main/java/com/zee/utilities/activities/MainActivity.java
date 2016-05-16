package com.zee.utilities.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.zee.utilities.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        parse();
    }


    private static void parse()
    {

        String response = "{\"UserName\":zack\",   \"Email\": \"zackcool6@gmail.com\",   \"IsRegistered\": true,   \"AccountPrivilege\": \"Premium\" }";
        Gson gson = new GsonBuilder().create();

        User user = gson.fromJson(response, User.class);
        Log.d("GSON parse","user: "+user.getAccountPrivilege());
    }

    public enum AccountPrivilegeType {

        @com.google.gson.annotations.SerializedName("Basic")
        TYPE_BASIC(0,"Basic"),
        @com.google.gson.annotations.SerializedName("Premium")
        TYPE_PREMIUM(1,"Premium");

        private final int value;
        private final String name;

        AccountPrivilegeType(int value, String name) {
            this.value = value;
            this.name = name;
        }

        public int getValue() {
            return value;
        }

        public String getName() {
            return name;
        }

    }
    public class User
    {
        @com.google.gson.annotations.SerializedName("Email")
        String email;

        @com.google.gson.annotations.SerializedName("AccountPrivilege")
        AccountPrivilegeType accountPrivilege;

        public AccountPrivilegeType getAccountPrivilege() {
            return accountPrivilege;
        }

        public void setAccountPrivilege(AccountPrivilegeType accountPrivilege) {
            this.accountPrivilege = accountPrivilege;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }
}
