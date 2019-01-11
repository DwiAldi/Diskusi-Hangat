package com.polinema.app.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MenuFragment extends Fragment {
    ListView listView;
    String[] kopiNames = {"Kopi Ceria","Kopi Sejuk","Kopi Bali","Kopi Mataram","Vietnam Drip"};
    int[] kopiImages = {R.drawable.kopi_ceria,R.drawable.kopi_sejuk,R.drawable.kopi_bali,R.drawable.kopi_mataram,R.drawable.vietnam_drip};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_menu, container, false);
        //finding listview
        listView = rootView.findViewById(R.id.listview);
        CustomAdapter customAdapter = new CustomAdapter();
        listView.setAdapter(customAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(),DetailActivity.class);
                intent.putExtra("name",kopiNames[position]);
                intent.putExtra("image",kopiImages[position]);
                startActivity(intent);

            }
        });
        return rootView;
    }
    private class CustomAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return kopiImages.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View view1 = getLayoutInflater().inflate(R.layout.item_kopi,null);
            //getting view in row_data
            TextView name = view1.findViewById(R.id.txtJudul);
            ImageView image = view1.findViewById(R.id.imgKopi);

            name.setText(kopiNames[i]);
            image.setImageResource(kopiImages[i]);
            return view1;



        }
    }
}
