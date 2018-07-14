package com.example.mohamed.sample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class Mozakra extends AppCompatActivity {
    String ur;//virable to store links of materials

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Spinner faculty = (Spinner) findViewById(R.id.faculty);
        final Spinner department = (Spinner) findViewById(R.id.department);
        final Spinner year = (Spinner) findViewById(R.id.year);
        final Spinner semester = (Spinner) findViewById(R.id.semester);
        final Spinner material = (Spinner) findViewById(R.id.material);
        final Button goButton = (Button) findViewById(R.id.Go);



        /*faculties*/
        ArrayAdapter facultyAdapter = ArrayAdapter.createFromResource(this, R.array.faculty,
                android.R.layout.simple_spinner_dropdown_item);
        faculty.setAdapter(facultyAdapter);

        faculty.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                year.setVisibility(View.GONE);
                semester.setVisibility(View.GONE);
                material.setVisibility(View.GONE);
                if (faculty.getSelectedItem().toString().equals("Choose your Faculty....")) {
                    Toast.makeText(Mozakra.this, "Choose your faculty..", Toast.LENGTH_SHORT).show();
                    department.setVisibility(View.GONE);
                    year.setVisibility(View.GONE);
                    semester.setVisibility(View.GONE);
                    material.setVisibility(View.GONE);
                    goButton.setVisibility(View.GONE);

                    /*Science*/
                } else if (faculty.getSelectedItem().toString().equals("Science Faculty")) {
                    department.setVisibility(View.VISIBLE);
                    semester.setVisibility(View.GONE);
                    material.setVisibility(View.GONE);
                    goButton.setVisibility(View.GONE);
                    year.setVisibility(View.GONE);
                    ArrayAdapter departmentAdapter = ArrayAdapter.createFromResource(Mozakra.this,
                            R.array.departmentSC, android.R.layout.simple_spinner_dropdown_item);
                    department.setAdapter(departmentAdapter);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        /*departments*/
        department.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(
                            AdapterView<?> parent, View view, int position, long id) {
                        semester.setVisibility(View.GONE);
                        material.setVisibility(View.GONE);
                        /*Science*/
                        if (faculty.getSelectedItem().toString().equals("Science Faculty")) {
                            if (department.getSelectedItem().toString().equals("حقوق انسان مشترك")) {
                                material.setVisibility(View.VISIBLE);
                                goButton.setVisibility(View.GONE);
                                ArrayAdapter yearAdapter = ArrayAdapter.createFromResource(Mozakra.this,
                                        R.array.material_حقوق_انسان, android.R.layout.simple_spinner_dropdown_item);
                                material.setAdapter(yearAdapter);
                            } else if (department.getSelectedItem().toString().equals("Industrial Chemistry")) {
                                material.setVisibility(View.VISIBLE);
                                goButton.setVisibility(View.GONE);
                                ArrayAdapter yearAdapter = ArrayAdapter.createFromResource(Mozakra.this,
                                        R.array.materialIC, android.R.layout.simple_spinner_dropdown_item);
                                material.setAdapter(yearAdapter);
                            } else if (department.getSelectedItem().toString().equals("Biochemistry")) {
                                material.setVisibility(View.VISIBLE);
                                goButton.setVisibility(View.GONE);
                                ArrayAdapter yearAdapter = ArrayAdapter.createFromResource(Mozakra.this,
                                        R.array.materialBC, android.R.layout.simple_spinner_dropdown_item);
                                material.setAdapter(yearAdapter);
                            } else if (department.getSelectedItem().toString().equals("Geology")) {
                                material.setVisibility(View.VISIBLE);
                                goButton.setVisibility(View.GONE);
                                ArrayAdapter yearAdapter = ArrayAdapter.createFromResource(Mozakra.this,
                                        R.array.materialPG, android.R.layout.simple_spinner_dropdown_item);
                                material.setAdapter(yearAdapter);
                            } else if (department.getSelectedItem().toString().equals("Physics")) {
                                material.setVisibility(View.VISIBLE);
                                goButton.setVisibility(View.GONE);
                                ArrayAdapter yearAdapter = ArrayAdapter.createFromResource(Mozakra.this,
                                        R.array.materialPH, android.R.layout.simple_spinner_dropdown_item);
                                material.setAdapter(yearAdapter);
                            } else if (department.getSelectedItem().toString().equals("Mathematics")) {
                                material.setVisibility(View.VISIBLE);
                                goButton.setVisibility(View.GONE);
                                ArrayAdapter yearAdapter = ArrayAdapter.createFromResource(Mozakra.this,
                                        R.array.materialMA, android.R.layout.simple_spinner_dropdown_item);
                                material.setAdapter(yearAdapter);
                            } else if (department.getSelectedItem().toString().equals("Microbiology")) {
                                material.setVisibility(View.VISIBLE);
                                goButton.setVisibility(View.GONE);
                                ArrayAdapter yearAdapter = ArrayAdapter.createFromResource(Mozakra.this,
                                        R.array.materialMI, android.R.layout.simple_spinner_dropdown_item);
                                material.setAdapter(yearAdapter);
                            } else if (department.getSelectedItem().toString().equals("Biotechnology")) {
                                material.setVisibility(View.VISIBLE);
                                goButton.setVisibility(View.GONE);
                                ArrayAdapter yearAdapter = ArrayAdapter.createFromResource(Mozakra.this,
                                        R.array.materialBI, android.R.layout.simple_spinner_dropdown_item);
                                material.setAdapter(yearAdapter);
                            }
                        }
                    }

                    public void onNothingSelected(AdapterView<?> parent) {
                    }
                });
        /*material*/
        material.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener()

                {
                    public void onItemSelected(
                            AdapterView<?> parent, View view, int position, long id) {

                        if (faculty.getSelectedItem().toString().equals("Science Faculty")) {
                           if (material.getSelectedItem().toString().equals("نووية واشعاعية")){
                               goButton.setVisibility(View.VISIBLE);
                               ur = "https://accounts.google.com/signin/v2/sl/pwd?hl=ar&passive=true&continue=https%3A%2F%2Fdrive.google.com%2Fdrive%2Ffolders%2F0B9fM-j_4HhpGTUExanB2eXhCLTA&service=writely&flowName=GlifWebSignIn&flowEntry=ServiceLogin";
                           }else if (material.getSelectedItem().toString().equals("")){
                               goButton.setVisibility(View.VISIBLE);
                               ur = "";
                           }else if (material.getSelectedItem().toString().equals("")){
                               goButton.setVisibility(View.VISIBLE);
                               ur = "";
                           }else if (material.getSelectedItem().toString().equals("")){
                               goButton.setVisibility(View.VISIBLE);
                               ur = "";
                           }else if (material.getSelectedItem().toString().equals("")){
                               goButton.setVisibility(View.VISIBLE);
                               ur = "";
                           }else if (material.getSelectedItem().toString().equals("")){
                               goButton.setVisibility(View.VISIBLE);
                               ur = "";
                           }else if (material.getSelectedItem().toString().equals("")){
                               goButton.setVisibility(View.VISIBLE);
                               ur = "";
                           }else if (material.getSelectedItem().toString().equals("")){
                               goButton.setVisibility(View.VISIBLE);
                               ur = "";
                           }else if (material.getSelectedItem().toString().equals("")){
                               goButton.setVisibility(View.VISIBLE);
                               ur = "";
                           }else if (material.getSelectedItem().toString().equals("")){
                               goButton.setVisibility(View.VISIBLE);
                               ur = "";
                           }else if (material.getSelectedItem().toString().equals("")){
                               goButton.setVisibility(View.VISIBLE);
                               ur = "";
                           }else if (material.getSelectedItem().toString().equals("")){
                               goButton.setVisibility(View.VISIBLE);
                               ur = "";
                           }else if (material.getSelectedItem().toString().equals("")){
                               goButton.setVisibility(View.VISIBLE);
                               ur = "";
                           }else if (material.getSelectedItem().toString().equals("")){
                               goButton.setVisibility(View.VISIBLE);
                               ur = "";
                           }else if (material.getSelectedItem().toString().equals("")){
                               goButton.setVisibility(View.VISIBLE);
                               ur = "";
                           }else if (material.getSelectedItem().toString().equals("")){
                               goButton.setVisibility(View.VISIBLE);
                               ur = "";
                           }else if (material.getSelectedItem().toString().equals("")){
                               goButton.setVisibility(View.VISIBLE);
                               ur = "";
                           }else if (material.getSelectedItem().toString().equals("")){
                               goButton.setVisibility(View.VISIBLE);
                               ur = "";
                           }else if (material.getSelectedItem().toString().equals("")){
                               goButton.setVisibility(View.VISIBLE);
                               ur = "";
                           }else if (material.getSelectedItem().toString().equals("")){
                               goButton.setVisibility(View.VISIBLE);
                               ur = "";
                           }else if (material.getSelectedItem().toString().equals("")){
                               goButton.setVisibility(View.VISIBLE);
                               ur = "";
                           }else if (material.getSelectedItem().toString().equals("")){
                               goButton.setVisibility(View.VISIBLE);
                               ur = "";
                           }else if (material.getSelectedItem().toString().equals("")){
                               goButton.setVisibility(View.VISIBLE);
                               ur = "";
                           }else if (material.getSelectedItem().toString().equals("")){
                               goButton.setVisibility(View.VISIBLE);
                               ur = "";
                           }else if (material.getSelectedItem().toString().equals("")){
                               goButton.setVisibility(View.VISIBLE);
                               ur = "";
                           }else if (material.getSelectedItem().toString().equals("")){
                               goButton.setVisibility(View.VISIBLE);
                               ur = "";
                           }else if (material.getSelectedItem().toString().equals("")){
                               goButton.setVisibility(View.VISIBLE);
                               ur = "";
                           }else if (material.getSelectedItem().toString().equals("")){
                               goButton.setVisibility(View.VISIBLE);
                               ur = "";
                           }else if (material.getSelectedItem().toString().equals("")){
                               goButton.setVisibility(View.VISIBLE);
                               ur = "";
                           }else if (material.getSelectedItem().toString().equals("")){
                               goButton.setVisibility(View.VISIBLE);
                               ur = "";
                           }else if (material.getSelectedItem().toString().equals("")){
                               goButton.setVisibility(View.VISIBLE);
                               ur = "";
                           }else if (material.getSelectedItem().toString().equals("")){
                               goButton.setVisibility(View.VISIBLE);
                               ur = "";
                           }else if (material.getSelectedItem().toString().equals("")){
                               goButton.setVisibility(View.VISIBLE);
                               ur = "";
                           }else if (material.getSelectedItem().toString().equals("")){
                               goButton.setVisibility(View.VISIBLE);
                               ur = "";
                           }else if (material.getSelectedItem().toString().equals("")){
                               goButton.setVisibility(View.VISIBLE);
                               ur = "";
                           }else if (material.getSelectedItem().toString().equals("")){
                               goButton.setVisibility(View.VISIBLE);
                               ur = "";
                           }else if (material.getSelectedItem().toString().equals("")){
                               goButton.setVisibility(View.VISIBLE);
                               ur = "";
                           }else if (material.getSelectedItem().toString().equals("")){
                               goButton.setVisibility(View.VISIBLE);
                               ur = "";
                           }else if (material.getSelectedItem().toString().equals("")){
                               goButton.setVisibility(View.VISIBLE);
                               ur = "";
                           }else if (material.getSelectedItem().toString().equals("")){
                               goButton.setVisibility(View.VISIBLE);
                               ur = "";
                           }else if (material.getSelectedItem().toString().equals("")){
                               goButton.setVisibility(View.VISIBLE);
                               ur = "";
                           }else if (material.getSelectedItem().toString().equals("")){
                               goButton.setVisibility(View.VISIBLE);
                               ur = "";
                           }else if (material.getSelectedItem().toString().equals("")){
                               goButton.setVisibility(View.VISIBLE);
                               ur = "";
                           }else if (material.getSelectedItem().toString().equals("")){
                               goButton.setVisibility(View.VISIBLE);
                               ur = "";
                           }else if (material.getSelectedItem().toString().equals("")){
                               goButton.setVisibility(View.VISIBLE);
                               ur = "";
                           }else if (material.getSelectedItem().toString().equals("")){
                               goButton.setVisibility(View.VISIBLE);
                               ur = "";
                           }else if (material.getSelectedItem().toString().equals("")){
                               goButton.setVisibility(View.VISIBLE);
                               ur = "";
                           }else if (material.getSelectedItem().toString().equals("")){
                               goButton.setVisibility(View.VISIBLE);
                               ur = "";
                           }else if (material.getSelectedItem().toString().equals("")){
                               goButton.setVisibility(View.VISIBLE);
                               ur = "";
                           }else if (material.getSelectedItem().toString().equals("")){
                               goButton.setVisibility(View.VISIBLE);
                               ur = "";
                           }else if (material.getSelectedItem().toString().equals("")){
                               goButton.setVisibility(View.VISIBLE);
                               ur = "";
                           }else if (material.getSelectedItem().toString().equals("")){
                               goButton.setVisibility(View.VISIBLE);
                               ur = "";
                           }else if (material.getSelectedItem().toString().equals("")){
                               goButton.setVisibility(View.VISIBLE);
                               ur = "";
                           }else if (material.getSelectedItem().toString().equals("")){
                               goButton.setVisibility(View.VISIBLE);
                               ur = "";
                           }else if (material.getSelectedItem().toString().equals("")){
                               goButton.setVisibility(View.VISIBLE);
                               ur = "";
                           }else if (material.getSelectedItem().toString().equals("")){
                               goButton.setVisibility(View.VISIBLE);
                               ur = "";
                           }else if (material.getSelectedItem().toString().equals("")){
                               goButton.setVisibility(View.VISIBLE);
                               ur = "";
                           }else if (material.getSelectedItem().toString().equals("")){
                               goButton.setVisibility(View.VISIBLE);
                               ur = "";
                           }else if (material.getSelectedItem().toString().equals("")){
                               goButton.setVisibility(View.VISIBLE);
                               ur = "";
                           }else if (material.getSelectedItem().toString().equals("")){
                               goButton.setVisibility(View.VISIBLE);
                               ur = "";
                           }else if (material.getSelectedItem().toString().equals("")){
                               goButton.setVisibility(View.VISIBLE);
                               ur = "";
                           }else if (material.getSelectedItem().toString().equals("")){
                               goButton.setVisibility(View.VISIBLE);
                               ur = "";
                           }else if (material.getSelectedItem().toString().equals("")){
                               goButton.setVisibility(View.VISIBLE);
                               ur = "";
                           }
                        }
                    }


                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
        goButton.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Mozakra.this, webView_Pdf.class);
                intent.putExtra("url", ur);
                startActivity(intent);

            }
        });
    }

}
