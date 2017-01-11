package com.example.nikiizvorski.sqlmvpdagger.insert;

import com.example.nikiizvorski.sqlmvpdagger.util.DBHelper;

import javax.inject.Inject;

/**
 * The type Insert presenter.
 */
public class InsertPresenterImpl implements InsertPresenter {
    /**
     * The Insert view.
     */
    @Inject InsertView insertView;
    /**
     * The Db helper.
     */
    @Inject DBHelper dbHelper;

    /**
     * Instantiates a new Insert presenter.
     *
     * @param insertView the insert view
     * @param dbHelper   the db helper
     */
    @Inject
    public InsertPresenterImpl(InsertView insertView, DBHelper dbHelper) {
        this.insertView = insertView;
        this.dbHelper = dbHelper;
    }

    @Override
    public void getStudent() {
        insertView.getDataFromViews();
    }

    @Override
    public void onDestroy() {
        insertView = null;
    }

    @Override
    public void insertStudent(String name, String phone, String email, String street, String city) {
        if (name != null && !name.isEmpty()){
            if (phone != null && !phone.isEmpty()){
                if(email != null && !email.isEmpty()){
                    if(street != null && !street.isEmpty()){
                        if (city != null && !city.isEmpty()){
                            dbHelper.insertContact(name, phone, email, street, city);
                        } else insertView.showCityError();
                    } else insertView.showStreetError();
                } else insertView.showEmailError();
            } else insertView.showPhoneError();
        } else insertView.showNameError();
    }
}
