package com.example.administrator.cs301examples;

import java.io.Serializable;

/**
 * Created by wagnern17 on 9/27/2015.
 */
public class player implements Serializable {

    public String stat1;
    public String name;

    protected player() {

        name = "John Doe";
        stat1 = "6";

    }


}
