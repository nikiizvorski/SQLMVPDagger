package com.example.nikiizvorski.sqlmvpdagger.insert;

/**
 * The interface Insert view.
 */
interface InsertView {
    /**
     * Init views.
     */
    void initViews();

    /**
     * Init data.
     */
    void initData();

    /**
     * Gets data from views.
     */
    void getDataFromViews();

    /**
     * Data for presenter.
     *
     * @param name   the name
     * @param phone  the phone
     * @param email  the email
     * @param street the street
     * @param city   the city
     */
    void dataForPresenter(String name, String phone, String email, String street, String city);

    /**
     * Show city error.
     */
    void showCityError();

    /**
     * Show street error.
     */
    void showStreetError();

    /**
     * Show email error.
     */
    void showEmailError();

    /**
     * Show phone error.
     */
    void showPhoneError();

    /**
     * Show name error.
     */
    void showNameError();
}
