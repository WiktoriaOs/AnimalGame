package com.ggit;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Genome {
    private static final int GENOME_LENGTH = 32;
    private static final int MIN_SPLIT = 1;
    private static final int MAX_SPLIT = 30;
    private static final Random random = new Random();

    private List<MapDirection> genes;

    public Genome(){
        /*genes= new ArrayList<>();
        for (int i = 0; i < 32; i++) {

        }*/
        genes = Stream.generate(MapDirection ::random).
                limit(GENOME_LENGTH).collect(Collectors.toCollection(ArrayList ::new));

    }

    public Genome(Genome mother, Genome father){
        int split = random.nextInt(MIN_SPLIT, MAX_SPLIT);
        genes= new ArrayList<>(GENOME_LENGTH);
        genes.addAll(mother.genes.subList(0, split));
        genes.addAll(split, father.genes.subList(split, GENOME_LENGTH));
    }
}
