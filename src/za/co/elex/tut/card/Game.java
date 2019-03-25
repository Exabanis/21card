package za.co.elex.tut.card;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Thread.sleep;

public class Game {
    private static ArrayList<Player> players = new ArrayList<>();
    private static Scanner input = new Scanner(System.in);
    private static Dealer dealer;

    public static void main(String[] args) throws DeckDepltedException, InterruptedException {

        Deck deck = new Deck();
        dealer = new Dealer(deck);
        gamePlayers();
        playGame();
    }

    private static void gamePlayers() throws InterruptedException {

        System.out.println("\nNumber of players, 5 or less?");

        for (int i = input.nextInt(); i > 0; i--) {
            input.nextLine();
            System.out.println("\nInsert player name: "); sleep(1000);
            String person = input.nextLine();
            System.out.println("\nInsert player balance: "); sleep(1000);
            int balance = input.nextInt();
            Player player = new Player(person, balance);
            player.setDealer(dealer);
            players.add(player);
        }
    }

    private static void playGame() throws DeckDepltedException, InterruptedException {

        while (players.size() > 0) {

            dealer.deal(players);

            //Players turn to play
            for (Player player : players) {
                play(player);
            }

            //dealer plays
            while (dealer.getTotal() < 17) {
                dealer.hit();
                System.out.println("\nDealer " + dealer.getName() + " has " + dealer.getHand() + " totaling " + dealer.getTotal()+"\n");
                try {
                    sleep((long) Math.random() * 10000 + 4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            winOrLoose();

            prepNextRound();
        }
    }

    private static void play(Player player) throws DeckDepltedException, InterruptedException {

        System.out.println("\n"+player.getName() + "'s turn to player. Place your bet: ");
        player.setBet(input.nextInt());

        while(true) {
            System.out.println("\n"+player.getName() + " your hand " + player.getHand() + " totaling " + player.getTotal());
            System.out.println("\nInsert 1 to hit or 0 to stand");
            if (input.nextInt() == 1) {
                player.hit();
                if (player.getTotal() > 21) {
                    System.out.println("YOU BUSTED!"); sleep(2000);
                    break;
                }
            } else {
                break;
            }
        }
    }

    private static void winOrLoose() throws InterruptedException {
        System.out.println("\nDealer " + dealer.getName() + " has " + dealer.getHand() + " totaling " + dealer.getTotal()+"\n"); sleep(2000);

        for (Player player : players) {
            System.out.println("\n"+player.getName() + "'s hand " + player.getHand() + " totalling " + player.getTotal()); sleep(2000);
            if (player.getTotal() <= 21 && (player.getTotal() > dealer.getTotal() || dealer.getTotal() > 21)) {
                player.setMoney(player.getBet());
                dealer.setBalance(-player.getBet());
                System.out.println("\n"+player.getName() + " won " + player.getBet()); sleep(2000);
            } else if(player.getTotal() <= 21 && player.getTotal() == dealer.getTotal()) {
                System.out.println("\n"+player.getName() + " drawn"); sleep(2000);
                continue;
            }
            else {
                player.setMoney(-player.getBet());
                dealer.setBalance(player.getBet());
                System.out.println("\n"+player.getName() + " lost " + player.getBet()); sleep(2000);
            }
        }
    }

    private static void prepNextRound() throws InterruptedException {
        System.out.println("\n"+dealer.getName() + " your balance " + dealer.getBalance()); sleep(2000);
        dealer.setHand();

        for (Player player : players) {
            player.setHand();
            System.out.println("\n"+player.getName() + " your balance " + player.getMoney()); sleep(2000);
            if (player.getMoney() == 0){
                System.out.println("\n"+player.getName() + " you are out of the game!!!"); sleep(2000);
                players.remove(player);
            }
        }

    }
}
