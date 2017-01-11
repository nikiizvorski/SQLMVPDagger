package com.example.nikiizvorski.sqlmvpdagger.main;

import android.widget.AdapterView;

import java.util.ArrayList;

/**
 * The interface Main presenter.
 */
interface MainPresenter {
    /**
     * Gets students.
     *
     * @return the students
     */
    ArrayList<String> getStudents();

    /**
     * Insertin db.
     */
    void insertinDB();

    /**
     * On destroy.
     */
    void onDestroy();

    /**
     * Show students.
     */
    void showStudents();

    /**
     * Sets on item clicked.
     *
     * @param position the position
     * @param parent   the parent
     */
    void setOnItemClicked(int position, AdapterView<?> parent);

    /**
     * Remove student.
     *
     * @param position the position
     */
    void removeStudent(int position);
}
