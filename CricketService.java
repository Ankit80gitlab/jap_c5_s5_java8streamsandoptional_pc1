package com.jap.streams;

import java.util.*;

public class CricketService {

    //Given a country and a name, find the cricketer from the entire data list of cricket players

    public Optional<Cricket> getCricketerName(List<Cricket> cricketList, String cricketerName, String countryName)
    {
        List<Cricket> list5 = new ArrayList<>();

        cricketList.stream().filter(a -> a.getCountry().getName().equalsIgnoreCase(countryName)).forEach(b -> list5.add(b));

        Optional<Cricket> opt = list5.stream().filter(c -> c.getName().equalsIgnoreCase(cricketerName)).findFirst();
        if(opt.isPresent())
        {
            return opt;
        }
        return opt;
    }


     //Sort the list of cricketers in alphabetical order of their names belonging to a particular country.

    public List<String> getCricketerNamesForCountry(List<Cricket> cricketList, String countryName)
    {
        List<Cricket> list3 = new ArrayList<>();
        List<String> list4 = new ArrayList<>();

        cricketList.stream().filter(n -> n.getCountry().getName().equalsIgnoreCase(countryName)).forEach(m -> list3.add(m));

        list3.stream().sorted((o1,o2) -> o1.getName().compareToIgnoreCase(o2.getName())).forEach(l -> list4.add(String.valueOf(l)));

        return list4;
    }


     //Search for cricketers who have played more than 50 matches

    public List<Cricket> getPlayerNamePlayedMoreThan50Matches(List<Cricket> cricketList)
    {

        List<Cricket> list1 = new ArrayList<>();

        cricketList.stream().filter(k -> k.getMatchesPlayed()>50).forEach(l ->list1.add(l));

        return list1;
    }

     //Find the cricketers who have scored the highest runs for their country

    public Integer getHighestRunsScoredByCricketer(List<Cricket> cricketList, String countryName)
    {

        List<Cricket> list2 = new ArrayList<>();
        cricketList.stream().filter( f-> f.getCountry().getName().equalsIgnoreCase(countryName)).forEach(g -> list2.add(g));
        int[] s = new int[1];

        list2.stream().sorted((o1, o2) -> o1.getHighestScore()-o2.getHighestScore()).forEach(i -> s[0]=i.getHighestScore());
        Integer e = (Integer)s[0];
        return s[0];
    }
}
