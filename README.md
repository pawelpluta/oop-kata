# OOP Kata

A code kata is an exercise that will help you to train a very specific skill. 
This one will help you train your Object-Oriented approach.
Feel free to over-engineer solution. 
Below you will find general information about the project that you will work on.

## Warm up

You can jump straight to the code, or you might look at the [article explaining the approach](https://pawelpluta.com/the-oop-has-been-explained-wrongly-to-me/).

## Initial project

Code on `main` branch simulates some washing machine. 
There are a few requirements, that it needs to fulfil.

* Must provide dedicated programs for a different type of fabric; supported ones are wool, cotton and silk
* Programs for fabrics must be adjustable in the matter of temperature and spin speed
    * Wool can be washed only in temperature up to 40°C, with spin speed between 100 and 400 rounds per minute
    * Cotton can be washed in temperature between 30 and 95°C, with spin speed up to 1200 RPM
    * The maximum temperature for silk is 30°C and up to 300 RPM
* The washer should have protection for putting over 7 kilograms of laundries
* The default value for temperature and spin speed will be its maximum value

## Sample solution

You can find a sample solution on [sample-solution](https://github.com/pawelpluta/oop-kata/tree/sample-solution) branch.
If you need guidance on start, you can follow these steps:

* make a class for each type of Laundry Elements and remove enum
* do not use setters for an update of laundry `dirty` flag, make dedicated, explicit methods that will mark laundry as dirty or clean
* create a class that will group Laundry Elements into Laundry object. Use this object in communication between classes
* create a Basket class that will handle the logic of sorting laundry by its type
* create a class for Program that will store spin speed and temperature
* rename Washing Machine methods so they will reflect real-world operations that you perform on it
* try to remove all direct passing of List as method parameter - List should be only used internally inside of a class
* extend Programme class so it will contain behaviours to adjust parameters
* temperature can be changed only every 5 degrees
* the spin speed can be changed only every 100
* the programme can be set up to perform an additional rinse
* create dedicated classes for temperature and spin speed
* move check if the value is in a valid range to Temperature and SpinSpeed classes
* laundry, that does not fit into Washing Machine should be put back into Basket
* try to remove Service class or name it properly - naming class with 'Service' suffix promotes adding all, barely connected code into this class instead of splitting responsibilities

## Another languages
Thanks to the community, this Kata is available also for another languages. Check them out!
* [Swift](https://github.com/ytyubox/oop-kata-swift) by [@ytyubox](https://github.com/ytyubox/oop-kata-swift)
