package io.github.collagrid;
import java.util.*;

/**
 * Pet Order
 *
 * An order for a pets from the pet store
 */
public class Order {


    public Long id;

    public Long petId;

    public Long quantity;

    public String shipDate;

    /**
     * Order Status
     */
    public String status;

    public Boolean complete;
}
