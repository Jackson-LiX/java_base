package thread.sample;

import java.util.ArrayList;
import java.util.List;

/**
 * This is the method to mock booking tickets from cinema
 *
 * @author jacksonli
 */
public class CinemaSynchronizedBlock {
    public static void main(String[] args) {
        List<Integer> availablePositions = new ArrayList<>();
        availablePositions.add(1);
        availablePositions.add(2);
        availablePositions.add(3);
        availablePositions.add(4);
        availablePositions.add(5);
        availablePositions.add(6);
        Cinema cinema = new Cinema(availablePositions, "Cinema");
        List<Integer> seats1 = new ArrayList<>();
        seats1.add(1);
        seats1.add(2);
        List<Integer> seats2 = new ArrayList<>();
        seats2.add(3);
        seats2.add(2);
        new Thread(new Customer(cinema, seats1)).start();
        new Thread(new Customer(cinema, seats2)).start();
    }
}

class Cinema {

    private List<Integer> availablePositions;
    private String name;

    public Cinema(List<Integer> availablePositions, String name) {
        this.availablePositions = availablePositions;
        this.name = name;
    }

    public boolean bookTickets(List<Integer> seats) {
        System.out.println("This is " + name);
        System.out.println("available positions are:" + availablePositions);
        List<Integer> tempList = new ArrayList<>();
        tempList.addAll(availablePositions);
        tempList.removeAll(seats);
        if (availablePositions.size() - tempList.size() != seats.size()) {
            return false;
        }
        availablePositions = tempList;
        return true;
    }
}

class Customer implements Runnable {

    private final Cinema cinema;

    private final List<Integer> seats;

    public Customer(Cinema cinema, List<Integer> seats) {
        this.cinema = cinema;
        this.seats = seats;
    }

    @Override
    public void run() {
        synchronized (cinema) {
            boolean flag = cinema.bookTickets(seats);
            if (flag) {
                System.out.println("success" + Thread.currentThread().getName());
                System.out.println("positions: " + seats);
            } else {
                System.out.println("fail");
            }
        }
    }
}

