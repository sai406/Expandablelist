package com.mstech.expandablelist;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by EswarLakshmi on 27/06/17.
 */

public class JobOrdersAdapter extends BaseExpandableListAdapter {

    private Context _context;
    private List<String> _listDataHeader; // header titles
    // child data in format of header title, child title
    private HashMap<String, List<DriverJobsModel>> _listDataChild;

    public JobOrdersAdapter(Context context, List<String> listDataHeader,
                            HashMap<String, List<DriverJobsModel>> listChildData) {
        this._context = context;
        this._listDataHeader = listDataHeader;
        this._listDataChild = listChildData;
    }

    @Override
    public int getGroupCount() {
        return _listDataHeader != null && _listDataHeader.size() != 0 ? _listDataHeader.size() : 0;
    }

    @Override
    public int getChildrenCount(int i) {

        return this._listDataChild.get(this._listDataHeader.get(i)) != null && _listDataChild.get(this._listDataHeader.get(i)).size() != 0 ? _listDataChild.get(this._listDataHeader.get(i)).size() : 0;
    }

    @Override
    public Object getGroup(int i) {
        return this._listDataHeader.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {

        return this._listDataChild.get(this._listDataHeader.get(i))
                .get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {

        String headerTitle = (String) getGroup(i);

        if (view == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = infalInflater.inflate(R.layout.groupindexview, null);
            TextView headerText = (TextView) view.findViewById(R.id.groupindex_path);
            headerText.setText(headerTitle);
        }

        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        View v = view;
        final DriverJobsModel driverJobModel = (DriverJobsModel) getChild(i, i1);
        ViewHolder holder;

        if (view == null) {

            LayoutInflater inflater = (LayoutInflater) _context.getSystemService
                    (Context.LAYOUT_INFLATER_SERVICE);
//            final String childText = (String) getChild(i,_listDataChild.);
            //Here is the ListView of the ChildView
            v = inflater.inflate(R.layout.driver_jobs_cell, null);
            holder = new ViewHolder(v);
            holder.txtJobId.setText(driverJobModel.jobOrderId);
            holder.txtClientRef.setText(driverJobModel.clientRef);
            holder.txtPicLoc.setText(driverJobModel.pickupLoc);
            holder.txtDeliveryLoc.setText(driverJobModel.deliveryLoc);
            holder.txtType.setText(driverJobModel.serviceType);
            holder.txtEta.setText(driverJobModel.eta);
            holder.txtQty.setText(driverJobModel.itemQty);
            holder.txtGoodsAva.setText(driverJobModel.goodsReadyTime);
            holder.txtOpdate.setText(driverJobModel.operationDateTime);

            if (driverJobModel.serviceType.equalsIgnoreCase("Standard - Delivery Today (Non-Urgent)")) {

                holder.txtType.setText("STN");
                holder.txtType.setTextColor(v.getResources().getColor(R.color.colorStsYellow));

            } else if (driverJobModel.serviceType.equalsIgnoreCase("Emergency")) {
                holder.txtType.setText("EMR");
                holder.txtType.setTextColor(v.getResources().getColor(R.color.colorStsRed));

            } else if (driverJobModel.serviceType.contains("Time Sensitive Freight (TSF)")) {

                holder.txtType.setText("TIME");
                holder.txtType.setTextColor(v.getResources().getColor(R.color.colorStsGreen));
            } else {

            }

        }
        return v;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }

    public static class ViewHolder {


        @Nullable
        @BindView(R.id.txt_joborderid)
        TextView txtJobId;

        @Nullable
        @BindView(R.id.txt_clientref)
        TextView txtClientRef;


        @Nullable
        @BindView(R.id.txt_deliveryloc)
        TextView txtDeliveryLoc;


        @Nullable
        @BindView(R.id.txt_eta)
        TextView txtEta;


        @Nullable
        @BindView(R.id.txt_goodsavaliable)
        TextView txtGoodsAva;


        @Nullable
        @BindView(R.id.txt_opdate)
        TextView txtOpdate;


        @Nullable
        @BindView(R.id.txt_pickuploc)
        TextView txtPicLoc;

        @BindView(R.id.txt_type)
        TextView txtType;


        @Nullable
        @BindView(R.id.txt_qty)
        TextView txtQty;


        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
