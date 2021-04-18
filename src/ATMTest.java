/*
 *author: Guruprem Rajpal
 *date: 13 March 2021
 *Description: ATM Extra Credit
 */

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class ATMTest {
    private ATM atm;
    HashMap<String, Integer> pin = new HashMap<>();
    HashMap<String, String> name = new HashMap<>();
    HashMap<String, String> location = new HashMap<>();
    HashMap<String, Double> funds = new HashMap<>();

    @BeforeEach
    void setUp() {
        name.put("bankName","OtterUnion");
        pin.put("pin",100);
        location.put("atmLocation","BIT");
        funds.put("funds",100.00);

        atm = new ATM(pin.get("pin"),name.get("bankName"),location.get("atmLocation"),funds.get("funds"));
    }

    @AfterEach
    void tearDown() {
        atm = null;
        pin = null;
        name = null;
        location= null;
        funds = null;
    }

    @Test
    void getPin() {
        assertEquals(pin.get("pin"),atm.getPin());
    }

    @Test
    void getBankName() {
        assertEquals(name.get("bankName"),atm.getBankName());
    }

    @Test
    void getATMLocation() {
        assertEquals(location.get("atmLocation"),atm.getATMLocation());
    }

    @Test
    void getFunds() {
        assertEquals(funds.get("funds"),atm.getFunds());
    }
}