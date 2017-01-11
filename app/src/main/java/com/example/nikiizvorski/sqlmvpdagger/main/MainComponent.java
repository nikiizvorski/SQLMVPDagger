package com.example.nikiizvorski.sqlmvpdagger.main;

import com.example.nikiizvorski.sqlmvpdagger.util.CustomScope;
import dagger.Component;

/**
 * The interface Main component.
 */
@CustomScope
@Component(modules = MainModule.class)
public interface MainComponent {
    /**
     * Inject.
     *
     * @param mainActivity the main activity
     */
    void inject(MainActivity mainActivity);
}
