//package com.demo.service.utils;
//
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//public class DateTimeGenerator {
//
//    public static List<String> generateDateTimeStrings() {
//        List<String> dateTimeStrings = new ArrayList<>();
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
//
//        // Ngày bắt đầu và kết thúc
//        Date startDate = new Date(2023 - 1900, 6, 29); // Tháng tính từ 0 (tháng 7 là tháng 6)
//        Date endDate = new Date(2023 - 1900, 7, 10); // Tháng tính từ 0 (tháng 8 là tháng 7)
//
//        // Thời gian trong mảng
//        int[] times = {7, 9, 12, 14, 16, 18};
//
//        // Tạo chuỗi cho mỗi ngày và thời gian
//        for (Date currentDate = startDate; currentDate.compareTo(endDate) <= 0; currentDate.setTime(currentDate.getTime() + 24 * 60 * 60 * 1000)) {
//            for (int time : times) {
//                String dateTimeString = generateDateTimeString(currentDate, time);
//                dateTimeStrings.add(dateTimeString);
//            }
//        }
//
//        return dateTimeStrings;
//    }
//
//    private static String generateDateTimeString(Date date, int time) {
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
//        String dateString = dateFormat.format(date);
//        String timeString = String.format("%02d:00:00", time);
//
//        return dateString + "T" + timeString;
//    }
//
//    public static void main(String[] args) {
//        List<String> dateTimeStrings = generateDateTimeStrings();
//        for (String dateTimeString : dateTimeStrings) {
//            System.out.println(dateTimeString);
//        }
//    }
//}
