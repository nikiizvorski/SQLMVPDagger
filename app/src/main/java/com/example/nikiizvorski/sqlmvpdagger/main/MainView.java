package com.example.nikiizvorski.sqlmvpdagger.main;

/**
 * The interface Main view.
 */
interface MainView {
    /**
     * Init views.
     */
    void initViews();

    /**
     * Init data.
     */
    void initData();

    /**
     * Add student.
     */
    void addStudent();

    /**
     * Display students.
     */
    void displayStudents();

    /**
     * Go to insert activity.
     */
    void goToInsertActivity();

    /**
     * Showmsg.
     *
     * @param msg the msg
     */
    void showmsg(String msg);
}
