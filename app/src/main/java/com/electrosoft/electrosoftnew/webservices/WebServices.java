package com.electrosoft.electrosoftnew.webservices;

public class WebServices {

    public static String BASE_URL = "http://143.110.176.86:3000/";


    public static String API_LOGIN = BASE_URL +"api/users/login";
    public static String API_PIN = BASE_URL +"api/users/verify_reset_password";
    public static String API_CHANGE_PASSWORD = BASE_URL +"api/users/change_password";
    public static String API_SEND_EMAIL = BASE_URL +"api/users/forget_password/";
    public static String API_GET_ROOMS = BASE_URL +"api/rooms/getByUser";
    public static String API_GET_DEVICES = BASE_URL + "api/devices/getByUser";
    public static String API_ADD_ROOM = BASE_URL + "api/rooms";
    public static String API_UPDATE_ROOM = BASE_URL + "api/rooms/";
    public static String API_DELETE_ROOM = BASE_URL + "api/devices/";

    //TODO add ID after URL and then add /assignRoom at end
    public static String API__UPDATE_CONFIG_DEVICE = BASE_URL + "api/devices/";



    //TODO add ID after this URL
    public static String API_GET_SENSORS = BASE_URL + "api/sensors/allDeviceSensors/";



}
