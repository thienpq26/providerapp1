package com.example.providerapp1.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.providerapp1.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentManager {
    private DatabaseHelper mHelper;
    private Context mContext;
    private SQLiteDatabase mDatabase;

    public StudentManager(Context mContext) {
        this.mContext = mContext;
        mHelper = new DatabaseHelper(mContext);
        mDatabase = mHelper.getWritableDatabase();
    }

    /**
     * Insert a student to sqlite database
     *
     * @param student The student insert to database
     */
    public void addStudent(Student student) {
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.NAME, student.getName());
        values.put(DatabaseHelper.PHONE, student.getPhone());
        values.put(DatabaseHelper.ADDRESS, student.getAddress());
        values.put(DatabaseHelper.EMAIL, student.getEmail());
        mDatabase.insert(DatabaseHelper.TABLE_NAME, null, values);
    }

    /**
     * Select students from sqlite database
     *
     * @return list of the student
     */
    public List<Student> getStudents() {
        List<Student> mList = new ArrayList<>();
        Cursor cursor = mDatabase.rawQuery("SELECT * FROM " + DatabaseHelper.TABLE_NAME, null);
        if (cursor.moveToFirst()) {
            do {
                mList.add(new Student(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4)));
            } while (cursor.moveToNext());
        }
        return mList;
    }

    /**
     * Delete a student follow the id of the student
     *
     * @param id The id of the student
     */
    public void deleteStudent(int id) {
        String arrArgs[] = {id + ""};
        mDatabase.delete(DatabaseHelper.TABLE_NAME, DatabaseHelper.ID + " = ?", arrArgs);
    }

    /**
     * Method get students from ContentResolver
     *
     * @param projection    A list of which columns to return. Passing null will return all columns, which is inefficient. This value may be null.
     * @param selection     A filter to apply to rows before deleting, formatted as an SQL WHERE clause (excluding the WHERE itself). This value may be null
     * @param selectionArgs This value may be null.
     * @param sortOrder     Sorted by sequence
     * @return Cursor including students information
     */
    public Cursor getStudentsProvider(String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        return mDatabase.query(DatabaseHelper.TABLE_NAME, projection, selection, selectionArgs, null, null, sortOrder);
    }

    /**
     * Method delete a student follow the id from ContentResolver
     *
     * @param selection     A filter to apply to rows before deleting, formatted as an SQL WHERE clause (excluding the WHERE itself). This value may be null
     * @param selectionArgs This value may be null.
     * @return Another zero if successfully deleted
     */
    public int deleteStudentProvider(String selection, String[] selectionArgs) {
        return mDatabase.delete(DatabaseHelper.TABLE_NAME, selection, selectionArgs);
    }
}
