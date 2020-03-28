package com.eslam.kreazrx.ui.offer;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class OfferResponse {

    @SerializedName("type")
    private String type;
    @SerializedName("data")
    private List<DataBean> data;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean implements Parcelable {
        @SerializedName("offer_id")
        private String offerId;
        @SerializedName("branch_id")
        private String branchId;
        @SerializedName("name")
        private String name;
        @SerializedName("address")
        private String address;
        @SerializedName("times")
        private String times;
        @SerializedName("lon")
        private String lon;
        @SerializedName("lat")
        private String lat;
        @SerializedName("icon")
        private String icon;
        @SerializedName("img")
        private String img;
        @SerializedName("offer_img")
        private String offerImg;
        @SerializedName("date")
        private String date;
        @SerializedName("valid")
        private int valid;
        @SerializedName("phones")
        private List<String> phones;

        protected DataBean(Parcel in) {
            offerId = in.readString();
            branchId = in.readString();
            name = in.readString();
            address = in.readString();
            times = in.readString();
            lon = in.readString();
            lat = in.readString();
            icon = in.readString();
            img = in.readString();
            offerImg = in.readString();
            date = in.readString();
            valid = in.readInt();
            phones = in.createStringArrayList();
        }

        public static final Creator<DataBean> CREATOR = new Creator<DataBean>() {
            @Override
            public DataBean createFromParcel(Parcel in) {
                return new DataBean(in);
            }

            @Override
            public DataBean[] newArray(int size) {
                return new DataBean[size];
            }
        };

        public String getOfferId() {
            return offerId;
        }

        public void setOfferId(String offerId) {
            this.offerId = offerId;
        }

        public String getBranchId() {
            return branchId;
        }

        public void setBranchId(String branchId) {
            this.branchId = branchId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getTimes() {
            return times;
        }

        public void setTimes(String times) {
            this.times = times;
        }

        public String getLon() {
            return lon;
        }

        public void setLon(String lon) {
            this.lon = lon;
        }

        public String getLat() {
            return lat;
        }

        public void setLat(String lat) {
            this.lat = lat;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getOfferImg() {
            return offerImg;
        }

        public void setOfferImg(String offerImg) {
            this.offerImg = offerImg;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public int getValid() {
            return valid;
        }

        public void setValid(int valid) {
            this.valid = valid;
        }

        public List<String> getPhones() {
            return phones;
        }

        public void setPhones(List<String> phones) {
            this.phones = phones;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(offerId);
            dest.writeString(branchId);
            dest.writeString(name);
            dest.writeString(address);
            dest.writeString(times);
            dest.writeString(lon);
            dest.writeString(lat);
            dest.writeString(icon);
            dest.writeString(img);
            dest.writeString(offerImg);
            dest.writeString(date);
            dest.writeInt(valid);
            dest.writeStringList(phones);
        }
    }
}
