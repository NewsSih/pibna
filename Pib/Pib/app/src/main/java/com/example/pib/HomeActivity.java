package com.example.pib;

import androidx.annotation.NonNull;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.icu.text.CaseMap;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

//    initilizing variables
    Spinner region,language;
    String PIB;
    RecyclerView recyclerView;
    // Declare an adapter
    RecyclerView.Adapter programAdapter;
    RecyclerView.LayoutManager layoutmanager;

//initialize Database__________________________________________________________
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("News_pib");

    List<String> arrlist = new ArrayList<>();
    List<String> TitleText = new ArrayList<>();
    List<String> DescText = new ArrayList<>();
//    String[] TitleText = new String[20];
//    String[] DescText = new String[20];

    ArrayList<News> la = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        region = findViewById(R.id.region);
        language = findViewById(R.id.language);







//        Setting the regions in the spinnner_______________________________________________________

        String regions[] = {"PIB Delhi","PIB Mumbai","PIB Hyderabad","PIB Chennai",
                "PIB Chandigarh","PIB Kolkata" ,"PIB Bengaluru" ,"PIB Bhubaneshwar" ,
                "PIB Ahmedabad" ,"PIB Guwahati","PIB Thiruvananthapuram", "PIB Imphal"};
        region.setAdapter(new ArrayAdapter<String>(getApplicationContext(),R.layout.spinner_list,regions));
        region.setDropDownVerticalOffset(70);
        language.setDropDownVerticalOffset(70);



// Read from the database




        region.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                Object item = parent.getItemAtPosition(pos);
                PIB = item.toString();

                String Mumbai[] = {"Marathi","English"};
                String Delhi[] = {"English","Hindi","Urdu"};
                String Hyderabad[] = {"Telugu","English"};
                String Bengaluru[] = {"Kannada","English"};
                String Chennai[] = {"Tamil","English"};
                String Kolkata[] = {"Bengali","English"};
                String Chandugarh[] = {"Punjabi","English"};
                String Ahmedabad[] = {"Gujarati","English"};
                String Thiruvunantpuram[] = {"Malayalam","English"};
                String imphal[] = {"English"};
                String Bhubaneshwar[] = {"Odia","English"};
                String Guwahati[] = {"Assamese","English"};



//
                switch(item.toString()){
                    case "PIB Delhi":
                        language.setAdapter(new ArrayAdapter<String>(getApplicationContext(),R.layout.spinner_list,Delhi));
                        break;
                    case "PIB Mumbai":
                        language.setAdapter(new ArrayAdapter<String>(getApplicationContext(),R.layout.spinner_list,Mumbai));
                        break;
                    case "PIB Hyderabad":
                        language.setAdapter(new ArrayAdapter<String>(getApplicationContext(),R.layout.spinner_list,Hyderabad));
                        break;
                    case "PIB Bengaluru":
                        language.setAdapter(new ArrayAdapter<String>(getApplicationContext(),R.layout.spinner_list,Bengaluru));
                        break;
                    case "PIB Chennai":
                        language.setAdapter(new ArrayAdapter<String>(getApplicationContext(),R.layout.spinner_list,Chennai));
                        break;
                    case "PIB Ahmedabad":
                        language.setAdapter(new ArrayAdapter<String>(getApplicationContext(),R.layout.spinner_list,Ahmedabad));
                        break;
                    case "PIB Kolkata":
                        language.setAdapter(new ArrayAdapter<String>(getApplicationContext(),R.layout.spinner_list,Kolkata));
                        break;
                    case "PIB Chandigarh":

                        language.setAdapter(new ArrayAdapter<String>(getApplicationContext(),R.layout.spinner_list,Chandugarh));
                        break;
                    case "PIB Thiruvunantpuram":

                        language.setAdapter(new ArrayAdapter<String>(getApplicationContext(),R.layout.spinner_list,Thiruvunantpuram));
                        break;
                    case "PIB Imphal":

                        language.setAdapter(new ArrayAdapter<String>(getApplicationContext(),R.layout.spinner_list, imphal));
                        break;
                    case "PIB Bhubaneshwar":

                        language.setAdapter(new ArrayAdapter<String>(getApplicationContext(),R.layout.spinner_list, Bhubaneshwar));
                        break;
                    case "PIB Guwahati":

                        language.setAdapter(new ArrayAdapter<String>(getApplicationContext(),R.layout.spinner_list, Guwahati));
                        break;
                }




            }

            // Read from the database

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


        language.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                Object item = parent.getItemAtPosition(position);

//                Toast.makeText(HomeActivity.this, item.toString(), Toast.LENGTH_SHORT).show();


                arrlist.clear();

                try {
                    myRef.child(item.toString()).addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                            TitleText.clear();
                            DescText.clear();
                            for(DataSnapshot snap : dataSnapshot.getChildren()){

                                if(snap.child("Posted by").getValue().toString().equals(PIB)) {
                                    arrlist.add(snap.child("Title").getValue().toString());
                                String title = snap.child("Title").getValue().toString();
                                String date = snap.child("Date").getValue().toString();
                                String time = snap.child("Time").getValue().toString();
                                String Posted = snap.child("Posted by").getValue().toString();
                                String min = snap.child("Ministry").getValue().toString();
                                News n = new News(title,date,time,Posted,min);
//
//
                                    if (date.equals("18 AUG 2022")) {
                                        TitleText.add(title);
                                        DescText.add(date);

                                    }

                                }

                            }

                            ArrayAdapter adapter = new ArrayAdapter<String>(HomeActivity.this,R.layout.newscard,arrlist);
                            recyclerView = findViewById(R.id.rvProgram);
                            // You may use this setting to improve performance if you know that changes
                            // in content do not change the layout size of the RecyclerView
                            recyclerView.setHasFixedSize(true);
                            // Use a linear layout manager
                            layoutmanager = new LinearLayoutManager(HomeActivity.this);
                            recyclerView.setLayoutManager(layoutmanager);
                            // Create an instance of ProgramAdapter. Pass context and all the array elements to the constructor
                            programAdapter = new ProgramAdapter(HomeActivity.this, TitleText, DescText);
                            // Finally, attach the adapter with the RecyclerView
                            recyclerView.setAdapter(programAdapter);

//                            ListView listView = (ListView) findViewById(R.id.List1);
//                            ListAdapter lad;
//                            lad = new ListAdapter(HomeActivity.this,
//                                    la);
//
//
//                            listView.setAdapter(adapter);

                        System.out.print(la);
//
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {
                            Toast.makeText(HomeActivity.this, "Error", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
                catch (Exception e){
                    e.printStackTrace();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



    }


}

