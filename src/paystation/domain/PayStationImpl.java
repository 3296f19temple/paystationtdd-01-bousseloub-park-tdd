package paystation.domain;

import java.util.HashMap;
import java.util.Map;

/**
 * Implementation of the pay station.
 *
 * Responsibilities:
 *
 * 1) Accept payment; 2) Calculate parking time based on payment; 3) Know
 * earning, parking time bought; 4) Issue receipts; 5) Handle buy and cancel
 * events.
 *
 * This source code is from the book "Flexible, Reliable Software: Using
 * Patterns and Agile Development" published 2010 by CRC Press. Author: Henrik B
 * Christensen Computer Science Department Aarhus University
 *
 * This source code is provided WITHOUT ANY WARRANTY either expressed or
 * implied. You may study, use, modify, and distribute it for non-commercial
 * purposes. For any commercial use, see http://www.baerbak.com/
 */
public class PayStationImpl implements PayStation {

    private int insertedSoFar;
    private int timeBought;
    private int coinCount;
    private int coinCountN = 0;
    private int coinCountD = 0;
    private int coinCountQ = 0;

    private Map<Integer, Integer> coinsMap = new HashMap<>();

    @Override
    public void addPayment(int coinValue)
            throws IllegalCoinException {

        switch (coinValue) {

            case 5:
                /*if (coinCountN == 0) {
                    coinsMap.put(5, 1);
                } else {

                    coinCount = coinsMap.get(5);
                    coinCount++;
                    coinsMap.put(5, coinCount);
                }*/
                break;
            case 10:
                /*if (coinCountD == 0) {
                    coinsMap.put(10, 1);
                } else {

                    coinCount = coinsMap.get(10);
                    coinCount++;
                    coinsMap.put(10, coinCount);
                }*/
                break;
            case 25:
                /*if (coinCountQ == 0) {
                    coinsMap.put(25, 1);
                } else {

                    coinCount = coinsMap.get(25);
                    coinCount++;
                    coinsMap.put(25, coinCount);
                }*/
                break;
            default:
                throw new IllegalCoinException("Invalid coin: " + coinValue);
        }

        insertedSoFar += coinValue;
        timeBought = insertedSoFar / 5 * 2;
    }

    @Override
    public int readDisplay() {
        return timeBought;
    }

    @Override
    public Receipt buy() {
        Receipt r = new ReceiptImpl(timeBought);
        reset();
        return r;
    }

    @Override
    public Map<Integer, Integer> cancel() {
        Map<Integer, Integer> mapTest = new HashMap<>(coinsMap);
        reset();
        return mapTest;
    }

    private void reset() {
        timeBought = insertedSoFar = 0;
        //should be an existing map called "coinsMap"
        coinsMap.clear(); //clear the map

    }

    @Override
    public int empty() {
        int totalAmountCollected = insertedSoFar;
        reset();
        return totalAmountCollected;
    }
}
