package com.example.nikiizvorski.sqlmvpdagger.insert;

import android.content.Context;

import com.example.nikiizvorski.sqlmvpdagger.util.DBHelper;

import dagger.Module;
import dagger.Provides;

/**
 * The type Insert module.
 */
@Module
class InsertModule {
    private InsertView insertView;
    private Context context;

    /**
     * Instantiates a new Insert module.
     *
     * @param insertView the insert view
     * @param context    the context
     */
    public InsertModule(InsertView insertView, Context context) {
        this.insertView = insertView;
        this.context = context;
    }

    /**
     * Gets insert view.
     *
     * @return the insert view
     */
    @Provides
    public InsertView getInsertView() {
        return insertView;
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
     * Insert presenter insert presenter.
     *
     * @param insertView the insert view
     * @param dbHelper   the db helper
     * @return the insert presenter
     */
    @Provides
    InsertPresenter insertPresenter(InsertView insertView, DBHelper dbHelper){
        return new InsertPresenterImpl(insertView, dbHelper);
    }
}
