package com.example.providerapp1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.providerapp1.adapter.StudentsAdapter;
import com.example.providerapp1.data.StudentManager;
import com.example.providerapp1.model.Student;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements StudentsAdapter.OnNoteListener {

    private EditText edtName, edtPhone, edtAddress, edtEmail;
    private Button btnAdd, btnDelete;
    private RecyclerView rvStudents;
    private StudentManager manager;
    private List<Student> mList;
    private StudentsAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        manager = new StudentManager(this);
        mList = new ArrayList<>();
        if (!manager.getStudents().isEmpty()) {
            mList = manager.getStudents();
            Toast.makeText(this, "size: " + mList.size(), Toast.LENGTH_SHORT).show();
            setAdapter(mList);
        }
        Cursor cursor = manager.getStudentsProvider(null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                Student student = new Student(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4));
                Log.d("D/e", student.toString());
                //mList.add();
            } while (cursor.moveToNext());
            setAdapter(mList);
        }
    }

    private void initViews() {
        edtName = findViewById(R.id.edtName);
        edtPhone = findViewById(R.id.edtPhone);
        edtAddress = findViewById(R.id.edtAddress);
        edtEmail = findViewById(R.id.edtEmail);
        btnAdd = findViewById(R.id.btnAdd);
        btnDelete = findViewById(R.id.btnDelete);
        rvStudents = findViewById(R.id.rvStudents);
    }

    public void handlerAddStudent(View view) {
        manager.addStudent(getEditText());
        resetEditText();
        loadData();
    }

    private Student getEditText() {
        return new Student(edtName.getText().toString(), edtPhone.getText().toString(), edtAddress.getText().toString(), edtEmail.getText().toString());
    }

    private void resetEditText() {
        edtName.setText("");
        edtPhone.setText("");
        edtAddress.setText("");
        edtEmail.setText("");
    }

    private void loadData() {
        mList.clear();
        mList.addAll(manager.getStudents());
        setAdapter(mList);
    }

    private void setAdapter(List<Student> mList) {
        layoutManager = new LinearLayoutManager(this);
        adapter = new StudentsAdapter(mList, this);
        rvStudents.setLayoutManager(layoutManager);
        rvStudents.setAdapter(adapter);
    }

    @Override
    public void onNoteClick(int position) {
        id = mList.get(position).getId();
        edtName.setText(mList.get(position).getName());
        edtPhone.setText(mList.get(position).getPhone());
        edtAddress.setText(mList.get(position).getAddress());
        edtEmail.setText(mList.get(position).getEmail());
    }

    public void handlerDeleteStudent(View view) {
        manager.deleteStudent(id);
        resetEditText();
        loadData();
    }
}
