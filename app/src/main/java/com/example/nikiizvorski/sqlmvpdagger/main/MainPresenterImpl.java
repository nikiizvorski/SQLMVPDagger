package com.example.nikiizvorski.sqlmvpdagger.main;

import android.database.Cursor;
import android.widget.AdapterView;

import com.example.nikiizvorski.sqlmvpdagger.util.DBHelper;
import java.util.ArrayList;
import javax.inject.Inject;

/**
 * The type Main presenter.
 */
class MainPresenterImpl implements MainPresenter {
    /**
     * The Main view.
     */
    @Inject MainView mainView;
    /**
     * The Db helper.
     */
    @Inject DBHelper dbHelper;

    /**
     * Instantiates a new Main presenter.
     *
     * @param mainView the main view
     * @param dbHelper the db helper
     */
    @Inject
    public MainPresenterImpl(MainView mainView, DBHelper dbHelper) {
        this.mainView = mainView;
        this.dbHelper = dbHelper;
    }

    @Override
    public void showStudents() {
        mainView.displayStudents();
    }

    @Override
    public void setOnItemClicked(int position, AdapterView<?> parent) {
        Cursor rs = dbHelper.getData(position+1);
        if(rs != null && rs.moveToFirst()){
            String city = rs.getString(rs.getColumnIndex(DBHelper.CONTACTS_COLUMN_CITY));
            mainView.showmsg(city);
        }
        if(!rs.isClosed()) rs.close();
    }

    @Override
    public void removeStudent(int position) {
        dbHelper.deleteContact(position+1);
    }

    @Override
    public ArrayList<String> getStudents() {
        return dbHelper.getAllCotacts();
    }

    @Override
    public void insertinDB() {
        mainView.goToInsertActivity();
    }

    @Override
    public void onDestroy() {
        mainView = null;
    }
}
