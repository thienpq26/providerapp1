package com.example.providerapp1.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;

import com.example.providerapp1.data.DatabaseHelper;
import com.example.providerapp1.data.StudentManager;

public class StudentsProvider extends ContentProvider {

    public static final String AUTHORITY = "com.example.providerapp1.provider.StudentsProvider";
    private StudentManager manager;
    private UriMatcher uriMatcher;

    public StudentsProvider() {
    }

    /**
     * @param uri           The URL of the row to delete. This value cannot be null.
     * @param selection     A filter to apply to rows before deleting, formatted as an SQL WHERE clause (excluding the WHERE itself). This value may be null.
     * @param selectionArgs This value may be null.
     * @return The number of rows deleted.
     */
    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return manager.deleteStudentProvider(selection, selectionArgs);
    }

    /**
     * @param uri A Uri identifying content (either a list or specific type), using the content:// scheme. This value cannot be null.
     * @return A MIME type for the content, or null if the URL is invalid or the type is unknown
     */
    @Override
    public String getType(Uri uri) {
        // TODO: Implement this to handle requests for the MIME type of the data
        // at the given URI.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        // TODO: Implement this to handle requests to insert a new row.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public boolean onCreate() {
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(AUTHORITY, DatabaseHelper.TABLE_NAME, 1);
        manager = new StudentManager(getContext());
        return true;
    }

    /**
     * @param uri           The URI, using the content:// scheme, for the content to retrieve. This value cannot be null.
     * @param projection    A list of which columns to return. Passing null will return all columns, which is inefficient. This value may be null.
     * @param selection     A filter declaring which rows to return, formatted as an SQL WHERE clause (excluding the WHERE itself). Passing null will return all rows for the given URI. This value may be null.
     * @param selectionArgs You may include ?s in selection, which will be replaced by the values from selectionArgs, in the order that they appear in the selection. The values will be bound as Strings. This value may be null.
     * @param sortOrder     How to order the rows, formatted as an SQL ORDER BY clause (excluding the ORDER BY itself). Passing null will use the default sort order, which may be unordered. This value may be null.
     * @return A Cursor object, which is positioned before the first entry. May return null if the underlying content provider returns null, or if it crashes.
     */
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        return manager.getStudentsProvider(projection, selection, selectionArgs, sortOrder);
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        // TODO: Implement this to handle requests to update one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
