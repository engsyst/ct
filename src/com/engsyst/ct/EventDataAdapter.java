package com.engsyst.ct;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.engsyst.ct.entity.Event;

public class EventDataAdapter extends BaseAdapter {
//	private Context context;
	private LayoutInflater lInflater;
	private ArrayList<Event> events;

	public EventDataAdapter(Context context, ArrayList<Event> items) {
//		this.context = context;
		this.events = items;
		lInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public int getCount() {
		return events.size();
	}

	@Override
	public Object getItem(int index) {
		return events.get(index);
	}

	@Override
	public long getItemId(int index) {
		return index;
	}

	@Override
	public View getView(int index, View convertView, ViewGroup parent) {
	    View view = convertView;
	    if (view == null) {
	      view = lInflater.inflate(R.layout.item_view, parent, false);
	    }
	    Event item = (Event) getItem(index);
	    
	    ((TextView) view.findViewById(R.id.itemTitle)).setText(item.getTitle());
	    ((TextView) view.findViewById(R.id.itemDescription)).setText(item.getDescription());
	    ((FrameLayout) view.findViewById(R.id.color_of_item)).setBackgroundColor(item.getColor());

	    CheckBox cbSelected = (CheckBox) view.findViewById(R.id.checkItem);
	    // set listener
	    cbSelected.setOnCheckedChangeListener(itemCheckChange);
	    // set tag as index 
	    cbSelected.setTag(index);
	    // set state from item
	    cbSelected.setChecked(item.isSelected());
	    return view;
	}

	OnCheckedChangeListener itemCheckChange = new OnCheckedChangeListener() {
		public void onCheckedChanged(CompoundButton buttonView,
				boolean isChecked) {
			// change state in item
			((Event) getItem((Integer) buttonView.getTag())).setSelected(isChecked);
		}
	};

}
