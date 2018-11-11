package com.mstech.expandablelist;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static android.widget.Toast.LENGTH_SHORT;

public class MainActivity extends AppCompatActivity {
    private ProgressDialog pDialog;
    List<DisplayTypeJobs> driverJobsModelList;
    List<String> listDataHeader;
    HashMap<String, List<DriverJobsModel>> listDataChild;
    List<String> assignjobs = new ArrayList<String>();
    ExpandableListView expandableListView;
    JobOrdersAdapter jobOrdersAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        expandableListView = (ExpandableListView) findViewById(R.id.expandablelist);
        makeJsonArrayRequest();
//        MediService
    }

    private void makeJsonArrayRequest() {

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        String getDriverJobs = "http://services.mflaustralia.com/.svc/GetJobOrdersByGroup?DriverId=1370";


        getDriverJobs = getDriverJobs.replace(" ", "%20").trim();


        JsonArrayRequest req = new JsonArrayRequest(getDriverJobs,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        // Parsing json array response
                        // loop through each json object
                        driverJobsModelList = new ArrayList<DisplayTypeJobs>();
                        GsonBuilder gsonBuilder = new GsonBuilder();
                        gsonBuilder.setDateFormat("M/d/yy hh:mm a");
                        Gson gson = gsonBuilder.create();
                        driverJobsModelList = Arrays.asList(gson.fromJson(response.toString(), DisplayTypeJobs[].class));
                        prepareListData(driverJobsModelList);

                        jobOrdersAdapter = new JobOrdersAdapter(MainActivity.this, listDataHeader, listDataChild);

                        // attach the adapter to the expandable list view
                        // setting list adapter
                        expandableListView.setAdapter(jobOrdersAdapter);
//                        expandableListView.setOnChildClickListener(MainActivity.this);
//                        expandableListView.setOnGroupClickListener(MainActivity.this);
//                        expandAll();
//                        hidepDialog();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
//                VolleyLog.d(TAG, "Error: " + error.getMessage());
                Toast.makeText(getApplicationContext(),
                        error.getMessage(), LENGTH_SHORT).show();
//                hidepDialog();
            }
        });

        // Adding request to request queue
        requestQueue.add(req);
    }

    private void prepareListData(List<DisplayTypeJobs> list) {
        assignjobs.clear();
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<DriverJobsModel>>();

        for (int i = 0; i <= list.size() - 1; i++) {

            String groupType = list.get(i).getDisplayTypes();
            if (groupType.equalsIgnoreCase("") || groupType == null) {


            } else {
                listDataHeader.add(groupType);
                List<DriverJobsModel> childData = new ArrayList<DriverJobsModel>();
//                List<String> jobids = new ArrayList<String>();
                List<DriverJobsModel> childType = list.get(i).getStore();

                for (int j = 0; j <= childType.size() - 1; j++) {
                    DriverJobsModel newLocation = new DriverJobsModel();
                    newLocation.jobOrderId = childType.get(j).jobOrderId;
                    newLocation.clientRef = childType.get(j).clientRef;
                    newLocation.pickupLoc = childType.get(j).pickupLoc;
                    newLocation.deliveryLoc = childType.get(j).deliveryLoc;
                    newLocation.serviceType = childType.get(j).serviceType;
                    newLocation.eta = childType.get(j).eta;
                    newLocation.itemQty = childType.get(j).itemQty;
                    newLocation.goodsReadyTime = childType.get(j).goodsReadyTime;
                    newLocation.operationDateTime = childType.get(j).operationDateTime;
                    newLocation.jobAllotmentId = childType.get(j).jobAllotmentId;
//                    jobids.add(childType.get(j).jobOrderId);
                    if (listDataHeader.get(i).equals("Jobs Assigned")) {

                        assignjobs.add(childType.get(j).jobOrderId);
                    }

                    childData.add(j, newLocation);
                }
                listDataChild.put(listDataHeader.get(i), childData); // Header, Child data


            }
        }

    }
}
