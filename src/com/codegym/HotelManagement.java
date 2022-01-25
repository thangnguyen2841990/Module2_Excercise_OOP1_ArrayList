package com.codegym;

import java.io.*;
import java.util.ArrayList;

public class HotelManagement {
    private ArrayList<Hotel> hotels;

    public HotelManagement() {
        this.hotels = new ArrayList<>();
    }

    public HotelManagement(ArrayList<Hotel> hotels) {
        this.hotels = hotels;
    }

    public ArrayList<Hotel> getHotels() {
        return hotels;
    }

    public void setHotels(ArrayList<Hotel> hotels) {
        this.hotels = hotels;
    }

    //thêm khách thuê phòng
    public void addNewHotel(Hotel newHotel) {
        hotels.add(newHotel);
    }

    //hiển thị toàn bộ khách thuê phòng
    public void displayAllHotels() {
        for (int i = 0; i < hotels.size(); i++) {
            System.out.println((i + 1) + ". " + hotels.get(i));
        }
    }

    //Xóa khách thuê phòng
    public void removeHotel(int index) {
        hotels.remove(index);
    }

    //cập nhật thông tin khách hàng
    public void updateHotel(int index, Hotel newHotel) {
        hotels.set(index, newHotel);
    }

    //tìm thông tin của khách theo CMND
    public int findIndentityCustomer(String indentity) {
        int index = -1;
        for (int i = 0; i < hotels.size(); i++) {
            if (hotels.get(i).getPerson().getindentity().equals(indentity)) {
                index = i;
            }
        }
        return index;
    }

    //tính tiền cho khách
    public double payMoney(String indentity) {
        int index = findIndentityCustomer(indentity);
        return hotels.get(index).getPrice() * hotels.get(index).getRentsDay();
    }

    //ghi file
    public void writeToFiles(String path) throws IOException {
        FileWriter fileWriter = new FileWriter(path);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        for (Hotel hotel : hotels) {
            bufferedWriter.write(hotel.toString() + "\n");
        }
        bufferedWriter.close();
        fileWriter.close();
    }
    // đọc file
    public void readFiles(String path) throws IOException {
        FileReader fileReader = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = null;
        while ((line = bufferedReader.readLine()) != null){
            String[] lines = line.split(",");
            String name = lines[0].trim();
            String birthDay = lines[1].trim();
            String indentity = lines[2].trim();
            Person person = new Person(name,birthDay,indentity);
            int rentDay = Integer.parseInt(lines[3].trim());
            String type = lines[4].trim();
            double price = Double.parseDouble(lines[5].trim());
            Hotel hotel = new Hotel(rentDay,type,price,person);
            this.hotels.add(hotel);
        }
        bufferedReader.close();
        fileReader.close();
    }
}

