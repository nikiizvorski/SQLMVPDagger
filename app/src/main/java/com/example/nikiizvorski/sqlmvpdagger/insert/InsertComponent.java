package com.example.nikiizvorski.sqlmvpdagger.insert;


import com.example.nikiizvorski.sqlmvpdagger.util.CustomScope;

import dagger.Component;

/**
 * The interface Insert component.
 */
@CustomScope
@Component(modules = InsertModule.class)
public interface InsertComponent {
    /**
     * Inject.
     *
     * @param insertActivity the insert activity
     */
    void inject(InsertActivity insertActivity);
}
