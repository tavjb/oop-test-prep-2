##Task

Create a 'Building' class. The building will have several families, with each family having an array of parents and children.
Both arrays will be of type 'Person', with the parents array having a max of 2 parents.

Furthermore, write the following static methods:

getAverageChildAge(building)
getAverageAge(building)
getSingleParentFamilies(building) - gets an array with all the families that only have 1 parent
getSingleChildGenderFamilies(building) - gets an array with all the families who's children are only of 1 gender

```
Classes
Building

- constructor(numberOfApartments)
- families

Family
- constructor(parent, children) throws ImpossibleChildAgeException 
- constructor(parent1, parent2, children) throws ImpossibleChildAgeException 
- parents
- children
- addChild(child)


Person

- name
- age
- gender (MALE, FEMALE)
