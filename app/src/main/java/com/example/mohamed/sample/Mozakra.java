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

                } else if (faculty.getSelectedItem().toString().equals("Computers and information")) {
                    department.setVisibility(View.GONE);
                    semester.setVisibility(View.GONE);
                    material.setVisibility(View.GONE);
                    goButton.setVisibility(View.GONE);
                    year.setVisibility(View.VISIBLE);
                    ArrayAdapter yearAdapter = ArrayAdapter.createFromResource(Mozakra.this,
                            R.array.yearcs, android.R.layout.simple_spinner_dropdown_item);
                    year.setAdapter(yearAdapter);
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
                        if (faculty.getSelectedItem().toString().equals("Education Faculty")) {

                        }

                    }

                    public void onNothingSelected(AdapterView<?> parent) {
                    }
                });
        /*year*/
        year.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(
                            AdapterView<?> parent, View view, int position, long id) {
                        material.setVisibility(View.GONE);
                        /*Computers and information*/
                        if (faculty.getSelectedItem().toString().equals("Computers and information")) {
                            if (year.getSelectedItem().toString().equals("first year C.S")) {
                                semester.setVisibility(View.VISIBLE);
                                goButton.setVisibility(View.GONE);
                                material.setVisibility(View.GONE);
                                ArrayAdapter semesterAdapter = ArrayAdapter.createFromResource(Mozakra.this,
                                        R.array.semestercs1, android.R.layout.simple_spinner_dropdown_item);
                                semester.setAdapter(semesterAdapter);
                            } else if (year.getSelectedItem().toString().equals("second year C.S")) {
                                semester.setVisibility(View.VISIBLE);
                                goButton.setVisibility(View.GONE);
                                material.setVisibility(View.GONE);
                                ArrayAdapter semesterAdapter = ArrayAdapter.createFromResource(Mozakra.this,
                                        R.array.semestercs2, android.R.layout.simple_spinner_dropdown_item);
                                semester.setAdapter(semesterAdapter);
                            }
                        }
                    }

                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

        /*semester*/
        semester.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(
                            AdapterView<?> parent, View view, int position, long id) {
                        if (faculty.getSelectedItem().toString().equals("Computers and information")) {
                            if (semester.getSelectedItem().toString().equals("first semester Y1-C.S")) {
                                goButton.setVisibility(View.GONE);
                                material.setVisibility(View.VISIBLE);
                                ArrayAdapter materialAdapter = ArrayAdapter.createFromResource(Mozakra.this,
                                        R.array.materialcs11, android.R.layout.simple_spinner_dropdown_item);
                                material.setAdapter(materialAdapter);
                            } else if (semester.getSelectedItem().toString().equals("second semester Y1-C.S")) {
                                goButton.setVisibility(View.GONE);
                                material.setVisibility(View.VISIBLE);
                                ArrayAdapter materialAdapter = ArrayAdapter.createFromResource(Mozakra.this,
                                        R.array.materialcs12, android.R.layout.simple_spinner_dropdown_item);
                                material.setAdapter(materialAdapter);
                            } else if (semester.getSelectedItem().toString().equals("first semester Y2-C.S")) {
                                goButton.setVisibility(View.GONE);
                                material.setVisibility(View.VISIBLE);
                                ArrayAdapter materialAdapter = ArrayAdapter.createFromResource(Mozakra.this,
                                        R.array.materialcs21, android.R.layout.simple_spinner_dropdown_item);
                                material.setAdapter(materialAdapter);
                            }
                        }
                    }

                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
        /*material*/
        material.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(
                            AdapterView<?> parent, View view, int position, long id) {

                        if (faculty.getSelectedItem().toString().equals("Computers and information")) {
                            if (material.getSelectedItem().toString().equals("Physics1 Dr.Yasser Amoun")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://accounts.google.com/signin/v2/sl/pwd?hl=ar&passive=true&continue=https%3A%2F%2Fdrive.google.com%2Fdrive%2Ffolders%2F0ByJz1l2rodbFYWZnaVk3cE56SU0&service=writely&flowName=GlifWebSignIn&flowEntry=ServiceLogin";

                            } else if (material.getSelectedItem().toString().equals("Math1 Dr.Mohamed Ramadan")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://accounts.google.com/signin/v2/sl/pwd?hl=ar&passive=true&continue=https%3A%2F%2Fdrive.google.com%2Fdrive%2Ffolders%2F0ByJz1l2rodbFSjN2NnoxTGN2UjA&service=writely&flowName=GlifWebSignIn&flowEntry=ServiceLogin";

                            } else if (material.getSelectedItem().toString().equals("General English Dr.Dosoky")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://accounts.google.com/signin/v2/sl/pwd?hl=ar&passive=true&continue=https%3A%2F%2Fdrive.google.com%2Fdrive%2Ffolders%2F0ByJz1l2rodbFZ0NaZUpEMjJ4N0k&service=writely&flowName=GlifWebSignIn&flowEntry=ServiceLogin";

                            } else if (material.getSelectedItem().toString().equals("Programming Dr.Mohammed Ali")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://accounts.google.com/signin/v2/sl/pwd?hl=ar&passive=true&continue=https%3A%2F%2Fdrive.google.com%2Fdrive%2Ffolders%2F0ByJz1l2rodbFY01nMlZTTEt6bGM&service=writely&flowName=GlifWebSignIn&flowEntry=ServiceLogin";

                            } else if (material.getSelectedItem().toString().equals("Mathematics2 Dr.Taha El-Garib")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://accounts.google.com/signin/v2/sl/pwd?hl=ar&passive=true&continue=https%3A%2F%2Fdrive.google.com%2Fdrive%2Ffolders%2F0ByJz1l2rodbFUWd0UlZDVjA1bFk&service=writely&flowName=GlifWebSignIn&flowEntry=ServiceLogin";

                            } else if (material.getSelectedItem().toString().equals("English writing Dr.Dosoky")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://accounts.google.com/signin/v2/sl/pwd?hl=ar&passive=true&continue=https%3A%2F%2Fdrive.google.com%2Fdrive%2Ffolders%2F0ByJz1l2rodbFRUpOTloxN1dydlE&service=writely&flowName=GlifWebSignIn&flowEntry=ServiceLogin";

                            } else if (material.getSelectedItem().toString().equals("Discrete structure Dr.Hussein Sharaf")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://accounts.google.com/signin/v2/sl/pwd?hl=ar&passive=true&continue=https%3A%2F%2Fdrive.google.com%2Fdrive%2Ffolders%2F0ByJz1l2rodbFUW1RYUhxVl9HLVE&service=writely&flowName=GlifWebSignIn&flowEntry=ServiceLogin";

                            } else if (material.getSelectedItem().toString().equals("Cables")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://accounts.google.com/signin/v2/sl/pwd?hl=ar&passive=true&continue=https%3A%2F%2Fdrive.google.com%2Fdrive%2Ffolders%2F1_4TNzdTh-H6GWT-plDMO4clpaISOBUwA&service=writely&flowName=GlifWebSignIn&flowEntry=ServiceLogin";

                            } else if (material.getSelectedItem().toString().equals("Communication")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://accounts.google.com/signin/v2/sl/pwd?hl=ar&passive=true&continue=https%3A%2F%2Fdrive.google.com%2Fdrive%2Ffolders%2F1yexQTZj0ADIPxVtq0akMJZIUeNyNSSbg&service=writely&flowName=GlifWebSignIn&flowEntry=ServiceLogin";

                            } else if (material.getSelectedItem().toString().equals("IP adress")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://accounts.google.com/signin/v2/sl/pwd?hl=ar&passive=true&continue=https%3A%2F%2Fdrive.google.com%2Fdrive%2Ffolders%2F12RI9VYznM5tbafheV2VBqFzLgJW25ES_%3Fpli%3D1&service=writely&flowName=GlifWebSignIn&flowEntry=ServiceLogin";

                            } else if (material.getSelectedItem().toString().equals("Is امتحانات")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://accounts.google.com/signin/v2/sl/pwd?hl=ar&passive=true&continue=https%3A%2F%2Fdrive.google.com%2Fdrive%2Ffolders%2F1uiAfeScfWpFXZdGhC_5toGb-izWTLIO6&service=writely&flowName=GlifWebSignIn&flowEntry=ServiceLogin";

                            } else if (material.getSelectedItem().toString().equals("Laplace transformation")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://accounts.google.com/signin/v2/sl/pwd?hl=ar&passive=true&continue=https%3A%2F%2Fdrive.google.com%2Fdrive%2Ffolders%2F1l_3IWgxIKVc7wotlFkGE7xA7E3Y0MkUs&service=writely&flowName=GlifWebSignIn&flowEntry=ServiceLogin";

                            } else if (material.getSelectedItem().toString().equals("maths Dr.Mohammed Saleh امتحانات")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://accounts.google.com/signin/v2/sl/pwd?hl=ar&passive=true&continue=https%3A%2F%2Fdrive.google.com%2Fdrive%2Ffolders%2F1QRgHev21L5oB0KYU2ZPqxDro-vYqbMB6&service=writely&flowName=GlifWebSignIn&flowEntry=ServiceLogin";

                            } else if (material.getSelectedItem().toString().equals("maths 3 fouri series")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://accounts.google.com/ServiceLogin?hl=ar&passive=true&continue=https://drive.google.com/drive/folders/1gTWol5njJaY9YTAj9UMGYTyzqw6bZBaK&service=writely";

                            } else if (material.getSelectedItem().toString().equals("الأعداد المركبة maths 3")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://accounts.google.com/ServiceLogin?hl=ar&passive=true&continue=https://drive.google.com/drive/folders/1aa6mv-brReV_cUIShequ7Mekjo2QmqNv&service=writely";

                            } else if (material.getSelectedItem().toString().equals("System analysis")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://accounts.google.com/ServiceLogin?hl=ar&passive=true&continue=https://drive.google.com/drive/folders/1PpHQpO7OIfl42aYJ-geHRuJKdDlwAJ3X&service=writely";

                            } else if (material.getSelectedItem().toString().equals("امتحانات دكتور هيثم")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://accounts.google.com/ServiceLogin?hl=ar&passive=true&continue=https://drive.google.com/drive/folders/1dSXTZ8mQMjvW86irDapdj5c-wnoSkQvC&service=writely";

                            } else if (material.getSelectedItem().toString().equals("Business")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://accounts.google.com/ServiceLogin?hl=ar&passive=true&continue=https://drive.google.com/drive/folders/1CnDW5EZXLhpGuQqvhmJHVGICRXl64q4Q%3Fpli%3D1&service=writely";

                            } else if (material.getSelectedItem().toString().equals("definition of Java")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://accounts.google.com/ServiceLogin?hl=ar&passive=true&continue=https://drive.google.com/drive/folders/1CnDW5EZXLhpGuQqvhmJHVGICRXl64q4Q&service=writely";

                            } else if (material.getSelectedItem().toString().equals("امتحانات تانية حاسبات")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://accounts.google.com/ServiceLogin?hl=ar&passive=true&continue=https://drive.google.com/drive/folders/1CnDW5EZXLhpGuQqvhmJHVGICRXl64q4Q&service=writely";

                            }
                        }
                    }


                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
        goButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Mozakra.this, webView_Pdf.class);
                intent.putExtra("url", ur);
                startActivity(intent);

            }
        });
    }

}
