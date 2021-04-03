package workshop;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.lang.System.exit;

public class Match {
    final private static Random random = new Random();

    public static void main(String[] args) {
        final int target = 20;
        Over firstOver = new Over();
        firstOver.overID = 1;
        Over nextOver = new Over();
        nextOver.overID = 2;
        List<Over> overs = new ArrayList<>();
        overs.add(firstOver);
        overs.add(nextOver);

        Batsman batsman = new Batsman();
        batsman.attackingType = AttackingType.DEFENSIVE;
        int scoredBatsManRun = 0;
        int scoredBallerRun = 0;
        for (Over over : overs) {
            batsman.name = "BatsMan_" + over.overID;
            batsman.isBatsMan = true;

            Baller baller = new Baller();
            baller.name = "Baller_" + over.overID;
            baller.isBatsMan = false;
            System.out.println("Baller is playing over " + over.overID + " , name " + baller.name);

            List<Player> batsmen = new ArrayList<>();
            batsmen.add(batsman);
            Team batsmenTeam = new Team(batsmen);

            List<Player> ballerTeam = new ArrayList<>();
            ballerTeam.add(baller);
            Team ballersTeam = new Team(ballerTeam);

            playKnockout(over, target, batsmenTeam, ballersTeam, scoredBatsManRun, scoredBallerRun);
        }

        batsman.isOut = true;

        if (scoredBatsManRun >= target) {
            System.out.println(" Yay !! BatsMan won with " + scoredBatsManRun);
            return;
        } else {
            System.out.println(" Yay !! Baller won with " + scoredBallerRun);
            return;
        }

    }

    public static void playKnockout(final Over over, int target, Team batsman, Team ballers, int scoredBatsManRun, int scoredBallerRun ) {

        String ballersName = ((Baller) ballers.players.get(0)).name;

        for (int i = 0; i < over.numberOfBalls; i++) {
            int max_score = over.maxScorePerBall;

            int currentBatsManRun = getRandomScoreBasedOnAttackType(((Batsman) batsman.players.get(0)).attackingType);
            int currentBallerRun = randomScore(max_score);

            System.out.println(" currentBatsManRun - " + currentBatsManRun);
            System.out.println(" currentBallerRun - " + currentBallerRun);

            if (currentBallerRun == currentBatsManRun && currentBatsManRun > 0) {
                System.out.println(" Baller won!!" + ballersName);
                exit(0);
            }

            scoredBatsManRun += currentBatsManRun;
            scoredBallerRun += currentBallerRun;
        }
    }

    private static int getRandomScoreBasedOnAttackType(AttackingType attackingType) {
        int random = 0;
        switch (attackingType) {
            case ATTACKING:
                random = getRandom(new int[]{0, 4, 6});
                break;
            case DEFENSIVE:
                random = getRandom(new int[]{0, 1, 2, 3});
                break;
            case MIXED:
                random = getRandom(new int[]{1, 2, 3, 4, 5, 6});
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + attackingType);
        }

        return random;
    }

    public static int getRandom(int[] array) {
        int rnd = new Random().nextInt(array.length);
        return array[rnd];
    }

    private static int randomScore(int max_score) {
        return random.nextInt(max_score);
    }

}
