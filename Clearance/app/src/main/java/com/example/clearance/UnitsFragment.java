package com.example.clearance;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link UnitsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UnitsFragment extends Fragment {

    CheckBox checkBox1, checkBox2, checkBox3, checkBox4, checkBox5, checkBox6, checkBox7;
    Button button;
    ArrayList courses;
    TextView selectedUnits;
    DatabaseReference mReference = FirebaseDatabase.getInstance().getReference();


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        courses = new ArrayList();

        selectedUnits = getView().findViewById(R.id.selected_units);
        button = getView().findViewById(R.id.outlinedButton);
        checkBox1 = getView().findViewById(R.id.checkbox1);
        checkBox2 = getView().findViewById(R.id.checkbox2);
        checkBox3 = getView().findViewById(R.id.checkbox3);
        checkBox4 = getView().findViewById(R.id.checkbox4);
        checkBox5 = getView().findViewById(R.id.checkbox5);
        checkBox6 = getView().findViewById(R.id.checkbox6);
        checkBox7 = getView().findViewById(R.id.checkbox7);

        selectCourses(checkBox1);
        selectCourses(checkBox2);
        selectCourses(checkBox3);
        selectCourses(checkBox4);
        selectCourses(checkBox5);
        selectCourses(checkBox6);
        selectCourses(checkBox7);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveUnitsData();
            }
        });

    }

    public void saveUnitsData() {
        mReference.child("temp_reg").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (task.isSuccessful()) {
                    String regNo = String.valueOf(task.getResult().getValue());

                    mReference.child(regNo).child("courses").setValue(courses.toString()).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(getContext(), "Task Successful", Toast.LENGTH_SHORT).show();
                            }else {
                                Toast.makeText(getContext(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

                    Toast.makeText(getContext(), "val: " + String.valueOf(task.getResult().getValue()), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void selectCourses(CheckBox checkBox) {
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckBox checkBoxLocal = (CheckBox) v;

                if (courses.size() < 5 && checkBoxLocal.isChecked()) {
                    courses.add(checkBoxLocal.getText());
                } else if (!(checkBoxLocal.isChecked()) && courses.contains(checkBoxLocal.getText())) {
                    courses.remove(checkBoxLocal.getText());
                } else {
                    Toast.makeText(getContext(), "Only select 5 units", Toast.LENGTH_SHORT).show();
                }

                if (courses.size() > 0) {
                    selectedUnits.setText(courses.toString());
                } else {
                    selectedUnits.setText("Selected units will be displayed below");
                }
            }
        });
    }

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public UnitsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment UnitsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static UnitsFragment newInstance(String param1, String param2) {
        UnitsFragment fragment = new UnitsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_units, container, false);
    }
}