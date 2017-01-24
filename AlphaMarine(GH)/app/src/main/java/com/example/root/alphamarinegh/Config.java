package com.example.root.alphamarinegh;

public class Config {

    //Address of the scripts for CRUD
    private static String hostUrl = "http://192.168.1.7:88/";
    public static final String URL_ADD = hostUrl+"insert_customers.php";
    public static final String URL_GET_DEST = hostUrl+"show_customers_destination.php";
    public static final String URL_GET_CUST = hostUrl+"getCustomer.php?ID=";
    public static final String URL_UPDATE = hostUrl+"updateCustomer.php";
    public static final String URL_DELETE = hostUrl+"deleteCustomer.php?ID=";

    //Keys that will be used to send the request to php scripts
    public static final String KEY_ID = "ID";
    public static final String KEY_CUSTID = "CustID";
    public static final String KEY_FNAME = "FName";
    public static final String KEY_LNAME = "LName";
    public static final String KEY_DESTINATION = "Destination";
    public static final String KEY_NBOXES = "Nboxes";
    public static final String KEY_ITEMS= "Items";
    public static final String KEY_PFONE = "PFone";
    public static final String KEY_CITY = "City";
    public static final String KEY_STATE = "State";
    public static final String KEY_SHIPTO = "Shipto";
    public static final String KEY_RECEFONE = "ReceFone";
    public static final String KEY_NOTES = "Notes";
    public static final String KEY_UNITCHARGE = "UnitCharge";
    public static final String KEY_LowerDateStart = "LowerDateStart";
    public static final String KEY_UpperDateEnd = "UpperDateEnd";

    //JSON Tags
    public static final String TAG_JSON_ARRAY = "result";
    public static final String TAG_ID = "id";
    public static final String TAG_CUSTID = "custid";
    public static final String TAG_NAME = "name";
    public static final String TAG_DESG = "desg";
    //public static final String TAG_CITY = "city"
    public static final String TAG_AMOUNT = "amount";

    //Customer ID to pass with Intent
    public static final String CUST_ID = "Cust_ID";

}
