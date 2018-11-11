package com.mstech.expandablelist;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by EswarLakshmi on 26/06/17.
 */

public class DriverJobsModel implements Serializable {
//    {"BarCode":"1001317566325",
// "ClientId":1001,
// "ClientRef":"158963",
// "CreatedBy":1001,
// "CreatedTime":"January 3,
// 2017 03:54 PM",
// "DeliveryGeoAddress":"Caboolture Private Hospital, Mckean Street, Caboolture, Queensland, Australia",
// "DeliveryInstructions":"Test2",
// "DeliveryLoc":"Caboolture Private Hospital (CPH)",
// "DeliveryLocation":null,
// "DeliveryScannedDate":"",
// "DeliveryTime":"",
// "Department":"CSSD \/ Sterilizing",
// "DisplayType":"",
// "DriverId":1,
// "ETA":"",
// "EmergencyTime":null,
// "GoodsReadyTime":"",
// "IsAccepted":2,
// "IsDeliveryLocation":null,
// "IsDeliveryScanned":0,
// "IsPickedUpScanned":0,
// "IsPickupLocation":null,
// "ItemQty":12,
// "JobAllotmentId":32177,
// "JobOrderId":31756,
// "LoadedTime":"",
// "Mobile":null,
// "OperationDate":"January 14, 2017 11:23 AM",
// "OperationDateTime":"",
// "OrderStatusId":4,
// "OtherInfo":"",
// "PhotoofBox":null,
// "PickedUpScannedDate":"",
// "PickupGeoAddress":"",
// "PickupLoc":"",
// "PickupLocation":null,
// "PickupTime":"",
// "RecieverName":null,
// "RecieverSignature":null,
// "ReorganizeDeliveryInstructions":"Test2",
// "ServiceType":"Overnight Before  Next Day (Non-Urgent)",
// "ServiceTypeId":1}
//


    @SerializedName("ClientId")
    public String clientId;


    @SerializedName("ClientRef")
    public String clientRef;

    @SerializedName("CreatedBy")
    public String createdBy;


    @SerializedName("CreatedTime")
    public String createdTime;


    @SerializedName("DeliveryGeoAddress")
    public String deliveryGeoAddress;

    @SerializedName("DeliveryInstructions")
    public String deliveryInstructions;

    @SerializedName("DeliveryLoc")
    public String deliveryLoc;


    @SerializedName("DeliveryLocation")
    public String DeliveryLocation;


    @SerializedName("DeliveryScannedDate")
    public String deliveryScannedDate;

    @SerializedName("DeliveryTime")
    public String deliveryTime;

    @SerializedName("Department")
    public String department;


    @SerializedName("DisplayType")
    public String displayType;


    @SerializedName("DriverId")
    public String driverId;


    @SerializedName("ETA")
    public String eta;

    @SerializedName("EmergencyTime")
    public String emergencyTime;


    @SerializedName("GoodsReadyTime")
    public String goodsReadyTime;


    @SerializedName("IsAccepted")
    public String isAccepted;


    @SerializedName("IsDeliveryLocation")
    public String isDeliveryLocation;


    @SerializedName("BarCode")
    public String barCode;


    @SerializedName("IsDeliveryScanned")
    public String isDeliveryScanned;

    @SerializedName("IsPickedUpScanned")
    public String isPickedUpScanned;

    @SerializedName("IsPickupLocation")
    public String isPickupLocation;

    @SerializedName("ItemQty")
    public String itemQty;

    @SerializedName("JobAllotmentId")
    public String jobAllotmentId;


    @SerializedName("JobOrderId")
    public String jobOrderId;


    @SerializedName("LoadedTime")
    public String loadedTime;


    @SerializedName("Mobile")
    public String Mobile;


    @SerializedName("OperationDate")
    public String operationDate;


    @SerializedName("OperationDateTime")
    public String operationDateTime;

    @SerializedName("OrderStatusId")
    public String orderStatusId;

    @SerializedName("OtherInfo")
    public String otherInfo;

    @SerializedName("PhotoofBox")
    public String photoofBox;


    @SerializedName("PickedUpScannedDate")
    public String pickedUpScannedDate;


    @SerializedName("PickupGeoAddress")
    public String pickupGeoAddress;


    @SerializedName("PickupLoc")
    public String pickupLoc;

    @SerializedName("RecieverName")
    public String recieverName;


    @SerializedName("RecieverSignature")
    public String recieverSignature;


    @SerializedName("ReorganizeDeliveryInstructions")
    public String reorganizeDeliveryInstruction;


    @SerializedName("ServiceType")
    public String serviceType;

    @SerializedName("ServiceTypeId")
    public String serviceTypeId;

    public boolean checkedSeleted=false;

}
