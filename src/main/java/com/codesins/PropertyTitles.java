package main.java.com.codesins;

import java.util.Arrays;
import java.util.Locale;
import java.util.stream.Collectors;

public class PropertyTitles {

    private String[] propertyTitles;


    PropertyTitles(String[] titles){
        this.propertyTitles = titles.clone();
    }

    public String[] formatPropertyTitles(){

        var resultList = Arrays.stream(propertyTitles).map(this::formatPropertyTitle).parallel().toList();
        return resultList.toArray(new String[0]);

    }


    private String formatPropertyTitle(String titleToFormat){

        var trimmed = titleToFormat.trim();
        var titleMembers = trimmed.split(" ");

        var titleAdjusted = Arrays.stream(titleMembers).filter(el -> !el.isEmpty()).map(this::adjustCase).toList();
        return String.join(" ", titleAdjusted);
    }

    private String adjustCase(String member){
        var lowered = member.toLowerCase();

        return lowered.substring(0, 1).toUpperCase() + lowered.substring(1);


    }


}
