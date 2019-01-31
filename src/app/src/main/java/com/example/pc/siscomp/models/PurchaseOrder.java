package com.example.pc.siscomp.models;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.pc.siscomp.fragments.CarFragment;
import com.example.pc.siscomp.helpers.QueueUtils.QueueObject;

import org.json.JSONException;
import org.json.JSONObject;

public class PurchaseOrder {

    int id;

    public static PurchaseOrder _singleObject;
    public PurchaseOrder(int _id) {
        this.id = _id;
    }
    public int getId() {
        return this.id;
    }

    public static void getOneSingleton(QueueObject o, final CarFragment _interface) {
        if ( _singleObject != null ) {
            _interface.setPurchaseOrder(_singleObject);
            return;
        }
        String url = "http://rrojasen.alwaysdata.net/purchaseorders.json";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.POST, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        if (response.has("data")) {
                            JSONObject object_response = null;
                            try {
                                object_response = response.getJSONObject("data");
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                            if ( object_response != null ) {
                                try {
                                    _singleObject = new PurchaseOrder(object_response.getInt("id"));
                                    _interface.setPurchaseOrder(_singleObject);
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
//                        _interface.refreshList();
                            }
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO: Handle error
//                    int b = 2;
//                    b += 1;

                    }
                });
        o.addToRequestQueue(jsonObjectRequest);
    }
}
