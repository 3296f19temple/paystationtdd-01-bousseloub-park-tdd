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

    @Override
    public void addPayment(int coinValue)
            throws IllegalCoinException {

        Map<String, Integer> coins = new HashMap<String, Integer>();

        switch (coinValue) {
            case 5:
                if (coinCountN == 0) {
                    coins.put("nickel", 1);
                } else {

                    coinCount = coins.get("nickel");
                    coinCount++;
                    coins.put("nickel", coinCount);
                }
                break;

            case 10:
                if (coinCountD == 0) {
                    coins.put("dime", 1);
                } else {

                    coinCount = coins.get("dime");
                    coinCount++;
                    coins.put("dime", coinCount);
                }
                break;

            case 25:
                if (coinCountQ == 0) {
                    coins.put("quarter", 1);
                } else {

                    coinCount = coins.get("quarter");
                    coinCount++;
                    coins.put("quarter", coinCount);
                }
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

    }*/
    @Override
    public Map<Integer, Integer> cancel() {
        reset();
    }

    private void reset() {
        timeBought = insertedSoFar = 0;
        //should be an existing map called "coins"
    }

    @Override
    public int empty() {
        int totalAmountCollected = insertedSoFar;
        reset();
        return totalAmountCollected;
    }
}
