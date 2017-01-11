package com.example.nikiizvorski.sqlmvpdagger.main;

import android.content.Context;

import com.example.nikiizvorski.sqlmvpdagger.util.DBHelper;

import dagger.Module;
import dagger.Provides;

/**
 * The type Main module.
 */
@Module
class MainModule {
    private MainView mainView;
    private Context context;

    /**
     * Instantiates a new Main module.
     *
     * @param mainView the main view
     * @param context  the context
     */
    MainModule(MainView mainView, Context context) {
        this.mainView = mainView;
        this.context = context;
    }

    /**
     * Gets main view.
     *
     * @return the main view
     */
    @Provides
    MainView getMainView() {
        return mainView;
    }

    /**
     * Db helper db helper.
     *
     * @return the db helper
     */
    @Provides
    DBHelper dbHelper(){
        return new DBHelper(context);
    }

    /**
     * Main presenter main presenter.
     *
     * @param dbHelper the db helper
     * @param mainView the main view
     * @return the main presenter
     */
    @Provides
    MainPresenter mainPresenter(DBHelper dbHelper, MainView mainView){
        return new MainPresenterImpl(mainView, dbHelper);
    }

}
