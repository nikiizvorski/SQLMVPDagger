# SQLMVPDagger
==========

Sample MVP Project containing Unit Tests, SQLite implementation and DI with Dagger2, Butterknife, SQLOpenHelper. 

This is how a proper non-spagetti code should look like! It have a good architecture a slight defects here and there which can be fixed but i wanted to share my knowlege with the rest and see how they can manage to fix this if they can actually see the problems. 

This project contains a proper Dagger2 implementation and a good MVP architecture which can be easy maintained and tested.

In the project you have SQLite implementation a simple display and add button. It can be a good step for someone that is just getting in to these libraries and into the android world.

There are a massive amout of tools and website to show you how to properly work and fix the problems in this project which are not that many.

Problem with deletion?

- You may have some problems with Delete of objects which will just not be displayed. But it is working correctly as everything else.

- I will leave to you to do what is needed from here simply you will need to add a custom adapter to display your correct items at all time.

Project Structure? Updated for the latest 2.8 libs

- Component and Module -> Dagger2 -> DI
- Presenter -> Presentation Layer
- Activity -> View Layer
- DB and Model class -> Model Layer

#### Author

- Niki Izvorski (nikiizvorski@gmail.com)
