package com.adriantoman.accounttypedisplay;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ListView listView=(ListView)findViewById(R.id.listView);
        listView.setAdapter(new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, getAccountTypes()));
    }

    private ArrayList<String> getAccountTypes()
    {
        ArrayList<String> accountTypes = new ArrayList<>();

        Account[] accounts = AccountManager.get(this).getAccounts();

        for (Account account : accounts) {
            accountTypes.add(account.type);
        }

        return accountTypes;
    }
}
