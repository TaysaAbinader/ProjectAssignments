# Task 3

The Singleton is a design pattern where only one object of a class is allowed to exist. For that reason the constructor is usually marked private, so you can not call it outside the class, and you get the object through the method .getInstance(), which creates the object once and after its creation only returns the already created object. So there are no reasonn to allow the use of the new operation, which has the function to create new objects.
