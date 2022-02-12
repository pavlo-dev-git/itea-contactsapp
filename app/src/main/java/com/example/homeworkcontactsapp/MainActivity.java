package com.example.homeworkcontactsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.homeworkcontactsapp.adapter.ContactAdapter;
import com.example.homeworkcontactsapp.model.Contact;
import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    RecyclerView contactRecycler;
    ContactAdapter contactAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Faker faker = new Faker();
        List<Contact> contactList = new ArrayList<>();
        Random random = new Random();
        int contactSize = random.nextInt(50) + 1;
        for (int i = 0; i < contactSize; i++) {
            contactList.add(new Contact(UUID.randomUUID().toString(), faker.name().firstName(), faker.name().lastName(), faker.phoneNumber().cellPhone(), faker.name().firstName().toLowerCase(Locale.ROOT) + "." + faker.name().lastName().toLowerCase(Locale.ROOT) + "@gmail.com"));
        }

        setContactRecycler(contactList);
    }

    private void setContactRecycler(List<Contact> contactList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        contactRecycler = findViewById(R.id.contactRecycler);
        contactRecycler.setLayoutManager(layoutManager);

        contactAdapter = new ContactAdapter(this, contactList);
        contactRecycler.setAdapter(contactAdapter);
    }


}