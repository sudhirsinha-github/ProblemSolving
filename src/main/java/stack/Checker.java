///*
//package stack;
//
//import java.text.SimpleDateFormat;
//import java.util.*;
//
//class Checker implements Comparator<Player> {
//    @Override
//    public int compare(Player player, Player next) {
//        if(player.score == next.score)
//        {
//            return player.name.compareTo(next.name);
//        }
//
//        return player.score<next.score?1:-1;
//    }
//}
//class Player implements Comparable{
//    // Q why not here we can implement compare???
//    String name;
//    int score;
//
//    Player(String name, int score){
//        this.name = name;
//        this.score = score;
//    }
//
//
//
//    @Override
//    public int compareTo(Object o) {
//        Player player = (Player)o;
//        if(player.score == this.score)
//        {
//            return this.name.compareTo(player.name);
//        }
//
//        return player.score<this.score?1:-1;    }
//}
//
//class Solution {
//
//    public static void main(String[] args) {
//
//        Player[] player = new Player[n];
//        Checker checker = new Checker();
//
//        for(int i = 0; i < n; i++){
//            player[i] = new Player(scan.next(), scan.nextInt());
//        }
//        scan.close();
//
//        // Collections.sort(player); + compareTo for natural -> Arraylist not generic arrays
//
//        Arrays.sort(player);
//        for(int i = 0; i < player.length; i++){
//            System.out.printf("%s %s\n", player[i].name, player[i].score);
//        }
//    }
//}*/
