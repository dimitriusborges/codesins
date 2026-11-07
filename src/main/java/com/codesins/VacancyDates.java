package main.java.com.codesins;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class VacancyDates {


    private final int[][] propertiesCalendar;


    VacancyDates(int[][] propertiesCalendar){
        this.propertiesCalendar = propertiesCalendar.clone();
    }


    public int[] findVacantDays(){

        if(this.propertiesCalendar.length == 0) {
            return new int[0];
        }

        var vacancyPerProperty = Arrays.stream(this.propertiesCalendar).map(this::vacancyPerProperty).parallel().toList();

        Set<Integer> vacantDays = new TreeSet<>(vacancyPerProperty.getFirst());

        vacancyPerProperty.stream().skip(1).forEach(vacantDays::retainAll);

        return vacantDays.stream().mapToInt(Integer::intValue).toArray();
    }


    private Set<Integer> vacancyPerProperty(int[] propertyCalendar){

        Set<Integer> vacantDays = new HashSet<>();

        for(int day = 0; day < propertyCalendar.length; day++){

            if(propertyCalendar[day] == 0){
                vacantDays.add(day);
            }

        }

        return vacantDays;
    }
}
