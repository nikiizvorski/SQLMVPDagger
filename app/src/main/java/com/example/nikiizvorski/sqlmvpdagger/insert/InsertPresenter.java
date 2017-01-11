package com.example.nikiizvorski.sqlmvpdagger.insert;

/**
 * The interface Insert presenter.
 */
interface InsertPresenter {
    /**
     * Insert student.
     *
     * @param name   the name
     * @param phone  the phone
     * @param email  the email
     * @param street the street
     * @param city   the city
     */
    void insertStudent(String name, String phone, String email, String street, String city);

    /**
     * Gets student.
     */
    void getStudent();

    /**
     * On destroy.
     */
    void onDestroy();
}
