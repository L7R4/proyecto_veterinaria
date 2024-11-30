PACKAGE 'DESIGN'

Description 

The following package contains the design classes of the Management System 'KlinSY'. These classes, along with the objects they generate, will be consumed in the 'Business Package'.
This separation is implemented to enhance the system's organization, adhering to principles of safety, structure, and presentation.
The principal classes designed in this package are:

abstract class Person
class Employee (extends Person)
class Client (extends Person)
abstract class Animal
class Canine (extends Animal)
class Feline (extends Animal)
class Rodent (extends Animal)
class Reptile (extends Animal)
class Avian (extends Animal)
class Special (extends Animal)

Other classes include:

class User
class Appointment
class Treatment
class InventoryItem

The interfaces generated for the system are:

interface PersonFileOperations
interface AnimalFileOperations

All principal classes follow JavaBean conventions. Principal classes inherit 'Serializable' from Animal and Person, respectively. 
The interfaces 'PersonFileOperations' and 'AnimalFileOperations' were split into two separate interfaces to provide more targeted functionality. In my opinion, using a general Object type in one interface wouldn't be optimal for ensuring safe and consistent operations.

TO DO LIST and Considerations

PERSON METHODS
Considerations
a. There can't be 2 persons with the same 'ID'

EMPLOYEE METHODS
Considerations
a. There can't be 2 employees with the same 'ID_employee'
b.  The search, modification and deletion of employees will always be done using 'ID_employee'
c. Certain employees, considering the value of the atribute 'work_Area', will be able to access certain sections of the system. 

CLIENT METHODS
Considerations
a. Each client must be linked to, at least, 1 pet.
b.  The search, modification and deletion of a client will always be done using 'ID'.
d. When a client is deleted, their pet or pets will be deleted from the system too.

Considerations about Interfaces - TO DO
Change methods 'showDetails' and method 'getBasicInfo' to interfaces, so Animal uses them too.
Design an interface that contains all the files' rutes; that way, if I modify the name of a folder or file, I'll just update the changes there, instead of navigating each class.

Classes and Methods  - TO DO
Finish unique classes' methods in principal classes.
Finish building Treatment, InventoryItem, User and Appointment classes.
Finish building the modify method for each principal class (consider using a switch; think about the logic mixed with the GUI).
