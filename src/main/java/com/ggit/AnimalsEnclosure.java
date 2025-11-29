package com.ggit;

import java.util.*;

public class AnimalsEnclosure extends  AbstractWorldMap{
    private AnimalsMapping animals = new AnimalsMapping();
    private Map<Vector2D, Plant> plants = new HashMap<>();

    public AnimalsEnclosure(int width, int height, int noOfPlants, int noOfAnimals){
        super(width, height);
        createAnimals(noOfAnimals);
        //animal= new Animal(Vector2D.random(width, height));
        createPlants(noOfPlants);
    }

    @Override
    public void run() {
        /*MapDirection[] directions = MapDirection.values();
        animals.forEach(animal ->animal.move(directions[random.nextInt(directions.length)], this));
*/
        animals.moveAnimals();
    }
    private void createPlants(int noOfPlants){
        for (int i = 0; i < noOfPlants ; i++) {
            growPlant();
        }
    }

    @Override
    public void feed() {
        animals.animalsByPosition.forEach((position, animalsOnPosition )-> {
            if (isPositionOccupiedByPlant(position)) {
                animalsOnPosition.stream().max(Animal::compareTo).ifPresent(animal -> {
                    removePlant(position);
                    animal.eat();
                    growPlant();
                    System.out.printf("Animal %d ate plant and now has energy level: %d\n", animal.getId(), animal.getEnergy());
                });
            }
        });
    }

    @Override
    public void endDay() {
        int animalsCount = animals.allAnimals.size();
        animals.updateAllAnimals(
                animals.allAnimals.stream()
                        .map(Animal::ageOneDay)
                        .filter(animal -> animal.getEnergy() > 0)
                        .collect(Collectors.toList()), false);
        System.out.printf("There were %d animals, %d animals left", animalsCount, animals.allAnimals.size());
    }
    @Override
    public void startDay(int dayNumber) {
        System.out.println("Day number " + dayNumber);
    }

    private void removePlant(Vector2D position){
        /*Plant toRemove=null;
        for(Plant plant: plants){
            if(plant.getPosition().equals(position)){
                toRemove=plant;
                break;
            }
        }
        if(toRemove!=null) plants.remove(toRemove);*/
        /*Iterator<Plant> it = plants.iterator();
        while (it.hasNext()){
            if(it.next().getPosition().equals(position)){
                it.remove();
                break;
            }
        }*/
        plants.remove(position);
    }

    private void createAnimals(int noOfAnimals){
        for (int i = 0; i < noOfAnimals; i++) {
            animals.addAnimal(new Animal(Vector2D.random(width, height)));
        }

    }

    private void growPlant(){
        if (plants.size() == width * height) return;

        Vector2D newPosition = Vector2D.random(width, height);
        while (isPositionOccupiedByPlant(newPosition)) {
            newPosition = Vector2D.random(width, height);
        }
        plants.put(newPosition, new Plant(newPosition));
    }
    private boolean isPositionOccupiedByPlant(Vector2D position) {
        return plants.containsKey(position);
    }
    private boolean isPositionOccupied(Vector2D position){
        /*for (Plant plant: plants) {
            if(plant.getPosition().equals(position)) return true;
        }
        return false;*/
        return plants.containsKey(position);
    }

    private class AnimalsMapping{
        private final List<Animal> allAnimals = new ArrayList<>();
        private final Map<Vector2D, List<Animal>> animalsByPosition = new HashMap<>();

        public void addAnimal(Animal animal) {
            allAnimals.add(animal);
            positionAnimalOnMap(animal);
        }

        public void moveAnimals() {
            allAnimals.forEach(animal -> animal.move(MapDirection.random(), AnimalsEnclosure.this));
            rebuildMap();
        }

        public void updateAllAnimals(List<Animal> animals, boolean rebuildMap) {
            allAnimals.clear();
            allAnimals.addAll(animals);
            if (rebuildMap) rebuildMap();
        }

        private void rebuildMap() {
            animalsByPosition.clear();
            allAnimals.forEach(this::positionAnimalOnMap);
        }

        private void positionAnimalOnMap(Animal animal) {
            animalsByPosition.computeIfAbsent(animal.getPosition(), _ -> new LinkedList<>()).add(animal);
        }
    }
}
