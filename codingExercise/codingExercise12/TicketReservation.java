package codingExercise.codingExercise12;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

public class TicketReservation {

    private static final int CONFIRMEDLIST_LIMIT = 10;
    private static final int WAITINGLIST_LIMIT = 3;

    private List<Passenger> confirmedList = new ArrayList<>();
    private Deque<Passenger> waitingList = new ArrayDeque<>();

    private int totalConfirmed;
    private int totalWaiting;
    // This getter is used only by the junit test case.
    public List<Passenger> getConfirmedList() {
        return confirmedList;
    }

    /**
     * Returns true if passenger could be added into either confirmedList or
     * waitingList. Passenger will be added to waitingList only if confirmedList
     * is full.
     *
     * Return false if both passengerList & waitingList are full
     */
    public boolean bookFlight(String firstName, String lastName, int age, String gender, String travelClass,String confirmationNumber) {
        if(totalConfirmed>=10 && totalWaiting>=3) return false;
        Passenger passenger = new Passenger(firstName,lastName,age,gender,travelClass,confirmationNumber);
        if(totalConfirmed<10){
            confirmedList.add(passenger);
            totalConfirmed++;
        }
        else{
            waitingList.add(passenger);
            totalWaiting++;
        }
        return true;
    }

    /**
     * Removes passenger with the given confirmationNumber. Passenger could be
     * in either confirmedList or waitingList. The implementation to remove the
     * passenger should go in removePassenger() method and removePassenger method
     * will be tested separately by the uploaded test scripts.

     * If passenger is in confirmedList, then after removing that passenger, the
     * passenger at the front of waitingList (if not empty) must be moved into
     * passengerList. Use poll() method (not remove()) to extract the passenger
     * from waitingList.
     */
    public boolean cancel(String confirmationNumber) {
        System.out.println("confirmationNumber: "+confirmationNumber);
        boolean checkIfInWaiting = false;
        /*System.out.println("waitingList before delete: ");
        for(Iterator<Passenger> iterator = waitingList.iterator();iterator.hasNext();){
            System.out.println(iterator.next());
        }*/
        for(Iterator<Passenger> iterator = waitingList.iterator();iterator.hasNext();){
            Passenger passenger = iterator.next();
            if(passenger.getConfirmationNumber().equals(confirmationNumber)){
                return  removePassenger(iterator,confirmationNumber);
                //break;
            }
        }
        /*System.out.println("waitingList after delete: ");
        for(Iterator<Passenger> iterator = waitingList.iterator();iterator.hasNext();){
            System.out.println(iterator.next());
        }


        System.out.println("confirmedList before delete:");
        for(Iterator<Passenger> iterator = confirmedList.iterator();iterator.hasNext();){
            System.out.println(iterator.next());
        }*/
        for(Iterator<Passenger> iterator = confirmedList.iterator();iterator.hasNext();){
            Passenger passenger = iterator.next();
            if(passenger.getConfirmationNumber().equals(confirmationNumber)){
                boolean flag =  removePassenger(iterator,confirmationNumber);
                if(totalWaiting>0){
                    Passenger lastPassenger = waitingList.poll();
                    totalWaiting--;
                    confirmedList.add(lastPassenger);
                }
                return flag;
            }
        }
        /*System.out.println("confirmedList after delete:");
        for(Iterator<Passenger> iterator = confirmedList.iterator();iterator.hasNext();){
            System.out.println(iterator.next());
        }*/
        return true;
    }

    /**
     * Removes passenger with the given confirmation number.
     * Returns true only if passenger was present and removed. Otherwise, return false.
     */
    public boolean removePassenger(Iterator<Passenger> iterator, String confirmationNumber) {
        iterator.remove();
        return true;
    }

}