package thread.sample;

/**
 * This is the method to mock booking tickets from station
 */
class Station implements Runnable{

    private int available;
    private String name;

    public Station(int available, String name) {
        this.available = available;
        this.name = name;
    }

    @Override
    public void run() {
        Passenger passenger = (Passenger) Thread.currentThread();
        boolean flag = this.bookTickets(passenger.seats);
        if (flag) {
            System.out.println("success " + Thread.currentThread().getName() + " " + passenger.seats);
        } else {
            System.out.println("fail " + Thread.currentThread().getName());
        }
    }

    public synchronized boolean bookTickets(int seats) {
        System.out.println("available positions: " + available);
        if (seats > available) {
            return false;
        }
        available -= seats;
        return true;
    }
}

class Passenger extends Thread{

    int seats;

    // make passenger as a proxy
    public Passenger(Runnable target, String name, int seats) {
        super(target, name);
        this.seats = seats;
    }
}

public class StationSynchronizedMethod {
    public static void main(String[] args) {
        Station station = new Station(2, "Dalian Station");
        new Passenger(station, "Li", 2).start();
        new Passenger(station, "Bi", 1).start();
    }
}
